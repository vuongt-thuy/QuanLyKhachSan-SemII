/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.views.internalFrame;

import bkap.dao.impl.CategoryRoomDAO;
import bkap.dao.impl.CategoryServiceDAO;
import bkap.dao.impl.CheckinDAO;
import bkap.dao.impl.CheckinDetailsDAO;
import bkap.dao.impl.CheckinServiceDetailsDAO;
import bkap.dao.impl.CustomerDAO;
import bkap.dao.impl.RoomDAO;
import bkap.dao.impl.ServiceDAO;
import bkap.model.CategoryRoom;
import bkap.model.CategoryService;
import bkap.model.Checkin;
import bkap.model.CheckinDetails;
import bkap.model.CheckinServiceDetails;
import bkap.model.Customer;
import bkap.model.Room;
import bkap.views.CheckoutJDialog;
import com.itextpdf.text.BaseColor;

import java.awt.Button;
import java.awt.CardLayout;

import java.awt.FlowLayout;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JMenuItem;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.Border;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author hongb
 */
public class ListRoomDetailIF extends javax.swing.JInternalFrame {

    private CheckinDAO checkinDao = new CheckinDAO();
    private CheckinDetailsDAO checkinDetailDao = new CheckinDetailsDAO();
    private CheckinServiceDetailsDAO checkinSerDetailDao = new CheckinServiceDetailsDAO();
    private CustomerDAO cusDao = new CustomerDAO();
    private RoomDAO roomDao = new RoomDAO();
    private ServiceDAO serDao = new ServiceDAO();

    private RoomDAO roomDAO = new RoomDAO();
    private CategoryRoomDAO catRoomDao = new CategoryRoomDAO();
    private List<Room> listR;
    private List<CategoryRoom> listCatRoom;
    private List<CheckinDetails> listCheckinDetail;
    private List<CheckinServiceDetails> listSer;
    private JPanel pnl;
    private Border blackline;
    private int page = 0;

    /**
     * Creates new form ListRoomDetailIF
     */
    public ListRoomDetailIF() {
        initComponents();
        setTitle("Thuê - Trả Phòng");
        listCatRoom = catRoomDao.findAll();
        pnlContainer.setLayout(new CardLayout());
        mnStatus0MouseClicked(null);
    }

    private void createNewPanel(List<CheckinDetails> list) {
        pnlContainer.removeAll();
        if (pnl != null) {
            pnl.removeAll();
        } else {
            pnl = new JPanel();
        }
        for (CategoryRoom listCat : listCatRoom) {
            getItemCategoryRoom(listCat.getId(), list);
        }
        pnlContainer.add(pnl);
        pnl.setLayout(new GridLayout(listCatRoom.size(), 1));
        pnl.setVisible(true);
        pnl.validate();
    }

    private void getItemCategoryRoom(int idCat, List<CheckinDetails> list) {
        JPanel pnlItem = new JPanel();
        for (CategoryRoom listC : listCatRoom) {
            if (idCat == listC.getId()) {
                blackline = BorderFactory.createTitledBorder(listC.getName());
            }
        }
        pnlItem.setBorder(blackline);
        pnlItem.setLayout(new FlowLayout(5));

        for (CheckinDetails listItem : list) {
            if (idCat == roomDAO.findByRoomId(listItem.getRoomId()).getTypeId()) {
                Customer cus = cusDao.findByPhone(checkinDao.findById(listItem.getCheckinId()).getCusPhone()).get(0);
                Button b = new Button("P " + listItem.getRoomId() + " " + cus.getFullname() + " " + cus.getPhone());
                pnlItem.add(b);

                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //your actions
                        switch (listItem.getStatus()) {
                            case 0:
                                final JPopupMenu editMenu = new JPopupMenu("Edit");
                                JMenuItem receiveMenuItem = new JMenuItem("Nhận phòng");
                                receiveMenuItem.setActionCommand("Nhận phòng");
                                JMenuItem dropMenuItem = new JMenuItem("Hủy phòng");
                                dropMenuItem.setActionCommand("Hủy phòng");
                                editMenu.add(receiveMenuItem);
                                editMenu.add(dropMenuItem);
                                editMenu.show(b, b.getX(), b.getY());
                                receiveMenuItem.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        int idCheckinDetail = checkinDetailDao.findByIdRoomStatus(listItem.getRoomId(), 0).getDetailId();
                                        checkinDetailDao.changeStatusRoom(idCheckinDetail, 1);
                                    }
                                });
                                dropMenuItem.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        int idCheckinDetail = checkinDetailDao.findByIdRoomStatus(listItem.getRoomId(), 0).getDetailId();
                                        checkinDetailDao.changeStatusRoom(idCheckinDetail, 3);
                                    }
                                });
                                break;
                            case 1:
                                CheckoutJDialog formCheckout = new CheckoutJDialog(null, closable, listItem.getDetailId());
                                formCheckout.setVisible(true);
                                formCheckout.validate();
                                break;
                            case 2:
                                if (page == 2) {
                                    final JPopupMenu clearMenu = new JPopupMenu("Edit");
                                    JMenuItem clearMenuItem = new JMenuItem("Đã dọn phòng");
                                    clearMenuItem.setActionCommand("Đã dọn phòng");
                                    clearMenu.add(clearMenuItem);
                                    clearMenu.show(b, b.getX(), b.getY());
                                    clearMenuItem.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent ae) {
                                            roomDao.changeStatus(listItem.getRoomId(), 0);
                                        }
                                    });
                                } else if (page == 3) {
                                    final JPopupMenu historyMenu = new JPopupMenu("Edit");
                                    JMenuItem billMenuItem = new JMenuItem("In hóa đơn");
                                    billMenuItem.setActionCommand("In hóa đơn");
                                    historyMenu.add(billMenuItem);
                                    historyMenu.show(b, b.getX(), b.getY());
                                    billMenuItem.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent ae) {
                                            try {
                                                // in hóa đơn
                                                PrintBill(listItem.getDetailId());
                                            } catch (FileNotFoundException ex) {
                                                Logger.getLogger(ListRoomDetailIF.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    });
                                }

                                break;
                            default:
                                break;
                        }
                    }
                });
            }
        }
        pnl.add(pnlItem);
        pnlItem.setVisible(true);
        pnlItem.validate();
    }

    private void PrintBill(int idCheckinDetail) throws FileNotFoundException {
        CheckinDetails checkinDetail = checkinDetailDao.findByDetailId(idCheckinDetail).get(0);
        Checkin checkin = checkinDao.findById(checkinDetail.getCheckinId());
        Customer cus = cusDao.findByPhone(checkin.getCusPhone()).get(0);

        String name = cus.getFullname();
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
        String stringDate = s.format(date);
        String part = "Bill//" + name + stringDate + ".pdf";

        String nameHotel = "HHotel";
        String line = "-----------------------------------------------------------------------";
        String address = "";
        String phone = "";
        String title = "PHIEU THANH TOAN";
        String room = "P " + checkinDetail.getRoomId();
        Date startDate = checkinDetail.getStartDate();
        Date endDate = checkinDetail.getEndDate();
        long time = (endDate.getTime() - startDate.getTime()) / 1000 / 60 / 60 / 24;

        List<String> list1 = new ArrayList<>();
        list1.add("Phong");
        list1.add(room);
        list1.add("Gio vao");
        list1.add(startDate + "");
        list1.add("Gio ra");
        list1.add(endDate + "");
        list1.add("Thoi gian");
        list1.add(time + "");

        List<String> list2 = new ArrayList<>();
        list2.add("MENU");
        list2.add("SL");
        list2.add("Thanh tien");

        List<String> list3 = new ArrayList<>();
        list3.add("Tien phong");
        list3.add((checkinDetail.getPrice() * time) + "");
        list3.add("Tien menu");
        list3.add(checkinDetail.getTotalServicePrice() + "");
        list3.add("Tong tien");
        list3.add(checkinDetail.getPrice() + checkinDetail.getTotalServicePrice() + "");

        listSer = checkinSerDetailDao.findByIdCheckinDetail(idCheckinDetail);

        Document document = new Document();

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(part));
            document.open();
            document.add(new Paragraph(nameHotel));
            document.add(new Paragraph(line));
            document.add(new Paragraph(""));
            document.add(new Paragraph(title));

            // table 1
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100); //Width 100%
            table.setSpacingBefore(10f); //Space before table
            table.setSpacingAfter(10f); //Space after table
            //Set Column widths
            float[] columnWidths = {1f, 1f};
            table.setWidths(columnWidths);
            for (String l : list1) {
                PdfPCell cell1 = new PdfPCell(new Paragraph(l));
                cell1.setPaddingLeft(10);
                cell1.setBorderColor(BaseColor.WHITE);
                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(cell1);
            }
            document.add(table);

            document.add(new Paragraph(line));

            // table 2
            PdfPTable table2 = new PdfPTable(3);
            table2.setWidthPercentage(100);
            table2.setSpacingBefore(10f);
            table2.setSpacingAfter(10f);
            float[] columnWidths2 = {1f, 1f, 1f};
            table2.setWidths(columnWidths2);
            for (String l : list2) {
                PdfPCell cell1 = new PdfPCell(new Paragraph(l));
                cell1.setPaddingLeft(10);
                cell1.setBorderColor(BaseColor.WHITE);
                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table2.addCell(cell1);
            }
            document.add(table2);

            document.add(new Paragraph(line));

            if (listSer.size() != 0) {
                PdfPTable table4 = new PdfPTable(3);
                table4.setWidthPercentage(100);
                table4.setSpacingBefore(10f);
                table4.setSpacingAfter(10f);
                float[] columnWidths4 = {1f, 1f, 1f};
                table4.setWidths(columnWidths4);
                for (CheckinServiceDetails l : listSer) {                 
                    PdfPCell cell12 = new PdfPCell(new Paragraph(serDao.findByID(l.getIdService()).getName()));
                    cell12.setPaddingLeft(10);
                    cell12.setBorderColor(BaseColor.WHITE);
                    cell12.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell12.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    PdfPCell cell13 = new PdfPCell(new Paragraph(l.getQuantity()+""));
                    cell13.setPaddingLeft(10);
                    cell13.setBorderColor(BaseColor.WHITE);
                    cell13.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell13.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    PdfPCell cell14 = new PdfPCell(new Paragraph(l.getQuantity() * l.getPrice()+""));
                    cell14.setPaddingLeft(10);
                    cell14.setBorderColor(BaseColor.WHITE);
                    cell14.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell14.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    table4.addCell(cell12);
                    table4.addCell(cell13);
                    table4.addCell(cell14);

                }
                document.add(table4);
            }else{
                document.add(new Paragraph("Khong co menu"));
            }

            document.add(new Paragraph(line));

            PdfPTable table3 = new PdfPTable(2);
            table3.setWidthPercentage(100);
            table3.setSpacingBefore(10f);
            table3.setSpacingAfter(10f);
            float[] columnWidths3 = {1f, 1f};
            table3.setWidths(columnWidths);

            for (String l : list3) {
                PdfPCell cell15 = new PdfPCell(new Paragraph(l));
                cell15.setPaddingLeft(10);
                cell15.setBorderColor(BaseColor.WHITE);
                cell15.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell15.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table3.addCell(cell15);
            }
            document.add(table3);

            document.add(new Paragraph(line));

            document.add(new Paragraph("©Copyright Phan Mem HHotel"));

            document.close();
            writer.close();
            JOptionPane.showMessageDialog(pnl, "Đã in song hóa đơn");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContainer = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnStatus0 = new javax.swing.JMenu();
        mnStatus1 = new javax.swing.JMenu();
        mnStatus2 = new javax.swing.JMenu();
        mnHistory = new javax.swing.JMenu();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setAutoscrolls(true);
        setMinimumSize(new java.awt.Dimension(95, 200));

        pnlContainer.setLayout(new java.awt.CardLayout());

        mnStatus0.setText("Phòng chờ");
        mnStatus0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnStatus0MouseClicked(evt);
            }
        });
        jMenuBar1.add(mnStatus0);

        mnStatus1.setText("Phòng đang thuê");
        mnStatus1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnStatus1MouseClicked(evt);
            }
        });
        jMenuBar1.add(mnStatus1);

        mnStatus2.setText("Phòng cần dọn");
        mnStatus2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnStatus2MouseClicked(evt);
            }
        });
        jMenuBar1.add(mnStatus2);

        mnHistory.setText("Lịch sử");
        mnHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnHistoryMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnHistory);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnStatus0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnStatus0MouseClicked
        // TODO add your handling code here:
        page = 0;
        setTitle("Phòng chờ");
        listCheckinDetail = checkinDetailDao.findAllByStatus(0);
        createNewPanel(listCheckinDetail);

    }//GEN-LAST:event_mnStatus0MouseClicked

    private void mnStatus1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnStatus1MouseClicked
        // TODO add your handling code here:
        page = 1;
        setTitle("Phòng đang thuê");
        listCheckinDetail = checkinDetailDao.findAllByStatus(1);
        createNewPanel(listCheckinDetail);
    }//GEN-LAST:event_mnStatus1MouseClicked

    private void mnStatus2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnStatus2MouseClicked
        // TODO add your handling code here:
        page = 2;
        setTitle("Phòng cần dọn");
        listCheckinDetail = checkinDetailDao.findAllByStatus(2);
        createNewPanel(listCheckinDetail);
    }//GEN-LAST:event_mnStatus2MouseClicked

    private void mnHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnHistoryMouseClicked
        // TODO add your handling code here:
        page = 3;
        setTitle("Lịch sử");
        listCheckinDetail = checkinDetailDao.findAllByStatus(2);
        createNewPanel(listCheckinDetail);
    }//GEN-LAST:event_mnHistoryMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mnHistory;
    private javax.swing.JMenu mnStatus0;
    private javax.swing.JMenu mnStatus1;
    private javax.swing.JMenu mnStatus2;
    private javax.swing.JPanel pnlContainer;
    // End of variables declaration//GEN-END:variables
}
