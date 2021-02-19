/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.views;

import bkap.dao.impl.CategoryServiceDAO;
import bkap.dao.impl.ProductDAO;
import bkap.dao.impl.RoomDAO;
import bkap.dao.impl.ServiceDAO;
import bkap.model.CategoryService;
import bkap.model.Room;
import bkap.model.Service;
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;

/**
 *
 * @author hongb
 */
public class ListServiceJDialog extends javax.swing.JDialog {

    private ProductDAO proDao = new ProductDAO();
    private RoomDAO roomDAO = new RoomDAO();
    private ServiceDAO serDao = new ServiceDAO();
    private CategoryServiceDAO catSerDao = new CategoryServiceDAO();
    private List<Service> listSer;
    private List<CategoryService> listCatSer;
    private List<Integer> listRoomSelected;
    private DefaultComboBoxModel modelListRoom;
    private Map<Integer, List<Integer>> listServiceSelected;
    private List<Integer> listServiceitem;
    private JPanel pnl;
    private Border blackline;
    private JCheckBox checkbox;
    private Room r;
    private boolean check = false;

    /**
     * Creates new form ListServiceJDialog
     */
    public ListServiceJDialog(java.awt.Frame parent, boolean modal, List<Integer> listRoom, Map<Integer, List<Integer>> listSS) {
        super(parent, modal);
        initComponents();

        this.listRoomSelected = listRoom;
        this.listServiceSelected = listSS;

        listSer = serDao.findAll();
        listCatSer = catSerDao.findAll();

        modelListRoom = (DefaultComboBoxModel) cbRoom.getModel();
        setComboxModel();

        pnlContainer.setLayout(new CardLayout());
        if (listServiceSelected.size() == 0) {
            for (Integer listRoom1 : listRoomSelected) {
                listServiceSelected.put(listRoom1, new ArrayList<>());
            }
        }
        createNewPanel();

    }

    private void setComboxModel() {
        modelListRoom.addElement("Tất cả");
        for (Integer listR : listRoomSelected) {
            modelListRoom.addElement(roomDAO.findByRoomId(listR));
        }
    }

    private void createNewPanel() {

        listServiceitem = new ArrayList<>();
        pnlContainer.removeAll();
        if (pnl != null) {
            pnl.removeAll();
        } else {
            pnl = new JPanel();
        }
        for (CategoryService listC : listCatSer) {
            getItemService(listC.getId());
        }
        pnlContainer.add(pnl);
        pnl.setLayout(new GridLayout(listCatSer.size(), 1));
        pnl.setVisible(true);
        pnl.validate();
    }

    private void getItemService(int id) {
        JPanel pnlItem = new JPanel();
        for (CategoryService listC : listCatSer) {
            if (id == listC.getId()) {
                blackline = BorderFactory.createTitledBorder(listC.getName());
            }
        }
        pnlItem.setBorder(blackline);
        pnlItem.setLayout(new FlowLayout(5));

//        checkbox = new JCheckBox();
        for (Service list : listSer) {
            if (id == list.getCatService()) {
                checkbox = new JCheckBox(list.getName(), false);
                try {
                    Room r = (Room) cbRoom.getSelectedItem();
                    if (listServiceSelected.get(r.getRoomId()).contains(list.getId())) {
                        checkbox.setSelected(true);
                    }
                } catch (Exception e) {
                    checkbox.setSelected(true);
                    for (Map.Entry<Integer, List<Integer>> entrySet : listServiceSelected.entrySet()) {
                        Integer key = entrySet.getKey();
                        List<Integer> value = entrySet.getValue();
                        if (!value.contains(list.getId())) {
                            checkbox.setSelected(false);
                            break;
                        }
                    }
                }

                pnlItem.add(checkbox);
                checkbox.setName(list.getId() + "");
                checkbox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        chbServiceActionPerformed(ae);
                    }
                });
            }
        }
        pnl.add(pnlItem);
        pnlItem.setVisible(true);
        pnlItem.validate();
    }

    private void chbServiceActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        JCheckBox checkbox = ((JCheckBox) evt.getSource());
        int serviceId = Integer.parseInt(checkbox.getName());
        try {
            Room r = (Room) cbRoom.getSelectedItem();
            List<Integer> data = listServiceSelected.get(r.getRoomId());
            if (checkbox.isSelected()) {
                data.add(serviceId);
            } else {
                data.removeIf(x -> x == serviceId);
            }
        } catch (Exception e) {
            for (Map.Entry<Integer, List<Integer>> entrySet : listServiceSelected.entrySet()) {
                Integer key = entrySet.getKey();
                List<Integer> value = entrySet.getValue();
                if (checkbox.isSelected()) {
                    if (!value.contains(serviceId)) {
                        value.add(serviceId);
                    }
                } else {
                    value.removeIf(x -> x == serviceId);
                }
            }
        }
        //JOptionPane.showMessageDialog(pnl, checkbox.isSelected() + checkbox.getName());

        listServiceitem.add(Integer.parseInt(checkbox.getName()));
    }

    public Map<Integer, List<Integer>> getListServiceSelected() {
        return listServiceSelected;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbRoom = new javax.swing.JComboBox();
        pnlContainer = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        cbRoom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbRoomItemStateChanged(evt);
            }
        });

        pnlContainer.setBackground(new java.awt.Color(255, 255, 255));
        pnlContainer.setAutoscrolls(true);
        pnlContainer.setLayout(new java.awt.CardLayout());

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbRoom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 455, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbRoomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbRoomItemStateChanged
        // TODO add your handling code here:
        createNewPanel();
    }//GEN-LAST:event_cbRoomItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        JOptionPane.showMessageDialog(pnl, "Thêm dịch vụ thành công");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        createNewPanel();
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListServiceJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListServiceJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListServiceJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListServiceJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListServiceJDialog dialog = new ListServiceJDialog(new javax.swing.JFrame(), true, null, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbRoom;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlContainer;
    // End of variables declaration//GEN-END:variables
}
