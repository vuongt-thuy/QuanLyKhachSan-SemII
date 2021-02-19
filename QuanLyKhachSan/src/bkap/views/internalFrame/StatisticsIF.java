/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.views.internalFrame;

import bkap.dao.impl.CategoryServiceDAO;
import bkap.dao.impl.CheckinDetailsDAO;
import bkap.dao.impl.CheckinServiceDetailsDAO;
import bkap.dao.impl.RoomDAO;
import bkap.dao.impl.ServiceDAO;
import bkap.model.CategoryService;
import bkap.model.CheckinDetails;
import bkap.model.CheckinServiceDetails;
import bkap.model.Room;
import bkap.model.Service;
import bkap.utils.Helper;
import bkap.utils.SystemConstant;
import bkap.utils.Utils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author THUY
 */
public class StatisticsIF extends javax.swing.JInternalFrame {

    private RoomDAO roomDAO = new RoomDAO();
    private CheckinDetailsDAO checkinDetailsDAO = new CheckinDetailsDAO();
    private CheckinServiceDetailsDAO checkinSerDetailsDAO = new CheckinServiceDetailsDAO();
    private ServiceDAO serDAO = new ServiceDAO();
    private CategoryServiceDAO catSerDAO = new CategoryServiceDAO();

    private List<Room> listRoom;
    private List<Service> listService;
    private List<CheckinDetails> listCheckinDetails;
    private List<CheckinDetails> listCheckinDetailsFindByMonth;
    private List<CheckinDetails> listCheckinDetailsFindByDay;
    private List<CheckinServiceDetails> listCheckinServiceDetails;
    private List<CheckinServiceDetails> listCheckinServiceDetailsFindByMonth;
    private List<CategoryService> listCategoryService;

    private DefaultComboBoxModel cbModelMonthStatisticRevenue;
    private DefaultComboBoxModel cbModelMonthStatisticBookRoom;
    private DefaultComboBoxModel cbModelMonthStatisticMenu;
    private DefaultComboBoxModel cbModelMonthStatisticRevenueByMonth;
    private DefaultComboBoxModel cbModelSortStatisticRoomRevenue;
    private DefaultComboBoxModel cbModelSortStatisticMenu;
    private DefaultTableModel modelTblStatisticRoomRevenue;
    private DefaultTableModel modelTblStatisticMenu;

    private String timeSelected = "";
    private String monthSelected = "";
    private double countBookRoom = 0;
    private double totalCountBookRoom = 0;
    private float revenueRoom = 0;
    private float totalRevenue = 0;
    private float totalRevenueRoom = 0;
    private float totalRevenueService = 0;
    private float totalFee = 0;
    private float totalSubPrice = 0;
    private float totalExPrice = 0;
    private float totalBenefit = 0;
    private float totalInputPriceMenu = 0;
    private double rate = 0;
    private double rateRoom = 0;
    private double rateService = 0;
    private double rateExPrice = 0;
    private double rateSubPrice = 0;

    private double totalCountMenuBook = 0;
    private double countMenuBook = 0;
    private float serviceRevenue = 0;
    private float totalServiceRevenue = 0;
    private double rateServiceRevenue = 0;
    private DecimalFormat decimalFormat = new DecimalFormat("#0.00");

    /**
     * Creates new form Statistics
     */
    public StatisticsIF() {
        Utils.setIconIF(this, Helper.getResources("statistic"));
        initComponents();

        listRoom = roomDAO.findAll();
        listService = serDAO.findAll();
        listCheckinDetails = checkinDetailsDAO.findAll();
        listCheckinDetailsFindByMonth = new ArrayList<>();
        listCheckinDetailsFindByDay = new ArrayList<>();
        listCheckinServiceDetails = checkinSerDetailsDAO.findAll();
        listCheckinServiceDetailsFindByMonth = new ArrayList<>();
        listCategoryService = catSerDAO.findAll();

        cbModelMonthStatisticRevenue = (DefaultComboBoxModel) cbMonthStatisticRevenue.getModel();
        cbModelMonthStatisticBookRoom = (DefaultComboBoxModel) cbMonthStatisticBookRoom.getModel();
        cbModelMonthStatisticMenu = (DefaultComboBoxModel) cbMonthStatisticMenu.getModel();
        cbModelSortStatisticRoomRevenue = (DefaultComboBoxModel) cbSortStatisticRoomRevenue.getModel();
        cbModelSortStatisticMenu = (DefaultComboBoxModel) cbSortStatisticMenu.getModel();
        modelTblStatisticRoomRevenue = (DefaultTableModel) tblStatisticRoom.getModel();
        modelTblStatisticMenu = (DefaultTableModel) tblStatisticMenu.getModel();

        setDataComboxSort(cbModelSortStatisticRoomRevenue);
        setDataComboxSort(cbModelSortStatisticMenu);

        setDataComboxMonth(cbModelMonthStatisticRevenue);
        setDataComboxMonth(cbModelMonthStatisticBookRoom);
        setDataComboxMonth(cbModelMonthStatisticMenu);
//        setDataComboxStatisticRevenueByMonth();

        setDataChartPieFee();
        setDataChartPieBenifit();
        setDataChartRevenueByDay();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        containChartRevenueByDay = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        cbMonthStatisticMenu = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cbSortStatisticMenu = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStatisticMenu = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtTotalRevenueMenu = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbMonthStatisticBookRoom = new javax.swing.JComboBox<>();
        cbSortStatisticRoomRevenue = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        tblStatisticRoom = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtTotalRevenue = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnExportFileExcel = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        containChartPieRevenue = new javax.swing.JPanel();
        containChartPieBenifit = new javax.swing.JPanel();
        cbMonthStatisticRevenue = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtStatisticRevenueTotalRevenue = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtStatisticRevenueRateRoomRevenue = new javax.swing.JLabel();
        txtStatisticRevenueRoomTotalRevenue = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtStatisticRevenueMenuRevenue = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtStatisticRevenueRateMenuRevenue = new javax.swing.JLabel();
        txtStatisticRevenueThuGiamTru = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtStatisticRevenueRateThuGiamTru = new javax.swing.JLabel();
        txtStatisticRevenueExPrice = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtStatisticRevenueRateExPrice = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtStatisticRevenueTotalBenefit = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtStatisticRevenueTotal_Benefit = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtStatisticRevenueRateTotalBenefit = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtStatisticRevenueTotalFee = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtStatisticRevenueTotal_Fee = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtStatisticRevenueRateTotalFee = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        containChartPieFee = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout containChartRevenueByDayLayout = new javax.swing.GroupLayout(containChartRevenueByDay);
        containChartRevenueByDay.setLayout(containChartRevenueByDayLayout);
        containChartRevenueByDayLayout.setHorizontalGroup(
            containChartRevenueByDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1187, Short.MAX_VALUE)
        );
        containChartRevenueByDayLayout.setVerticalGroup(
            containChartRevenueByDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(containChartRevenueByDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(85, 85, 85))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(containChartRevenueByDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(290, 290, 290))
        );

        jTabbedPane1.addTab("Doanh thu ngày", jPanel1);

        cbMonthStatisticMenu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMonthStatisticMenuItemStateChanged(evt);
            }
        });

        jLabel6.setText("Xem theo tháng");

        jLabel17.setText("Sắp xếp");

        cbSortStatisticMenu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSortStatisticMenuItemStateChanged(evt);
            }
        });

        tblStatisticMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên dịch vụ", "Loại dịch vụ", "Số lượng", "Doanh thu", "Tỉ lệ (%)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblStatisticMenu);

        jButton1.setText("Xuất file Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Tổng doanh thu menu:");

        txtTotalRevenueMenu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTotalRevenueMenu.setText("500.000 ");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("VNĐ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotalRevenueMenu)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel20))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbMonthStatisticMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 737, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSortStatisticMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbMonthStatisticMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSortStatisticMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(txtTotalRevenueMenu)
                        .addComponent(jLabel20))
                    .addComponent(jButton1))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thống kê menu", jPanel4);

        jLabel1.setText("Xem theo tháng");

        cbMonthStatisticBookRoom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMonthStatisticBookRoomItemStateChanged(evt);
            }
        });

        cbSortStatisticRoomRevenue.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSortStatisticRoomRevenueItemStateChanged(evt);
            }
        });

        jLabel2.setText("Sắp xếp");

        tblStatisticRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên phòng", "Số lượt thuê", "Tổng doanh thu", "Tỉ lệ (%)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scroll.setViewportView(tblStatisticRoom);
        if (tblStatisticRoom.getColumnModel().getColumnCount() > 0) {
            tblStatisticRoom.getColumnModel().getColumn(0).setResizable(false);
            tblStatisticRoom.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblStatisticRoom.getColumnModel().getColumn(1).setResizable(false);
            tblStatisticRoom.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblStatisticRoom.getColumnModel().getColumn(2).setResizable(false);
            tblStatisticRoom.getColumnModel().getColumn(3).setResizable(false);
            tblStatisticRoom.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Tổng doanh thu phòng:");

        txtTotalRevenue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTotalRevenue.setText("500.000 ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("VNĐ");

        btnExportFileExcel.setText("Xuất file Excel");
        btnExportFileExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportFileExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbMonthStatisticBookRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 792, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSortStatisticRoomRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnExportFileExcel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotalRevenue)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel5)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbMonthStatisticBookRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSortStatisticRoomRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTotalRevenue)
                    .addComponent(jLabel5)
                    .addComponent(btnExportFileExcel))
                .addContainerGap(266, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thống kê thuê phòng", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        containChartPieRevenue.setPreferredSize(new java.awt.Dimension(230, 230));

        javax.swing.GroupLayout containChartPieRevenueLayout = new javax.swing.GroupLayout(containChartPieRevenue);
        containChartPieRevenue.setLayout(containChartPieRevenueLayout);
        containChartPieRevenueLayout.setHorizontalGroup(
            containChartPieRevenueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        containChartPieRevenueLayout.setVerticalGroup(
            containChartPieRevenueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        containChartPieBenifit.setPreferredSize(new java.awt.Dimension(230, 230));

        javax.swing.GroupLayout containChartPieBenifitLayout = new javax.swing.GroupLayout(containChartPieBenifit);
        containChartPieBenifit.setLayout(containChartPieBenifitLayout);
        containChartPieBenifitLayout.setHorizontalGroup(
            containChartPieBenifitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        containChartPieBenifitLayout.setVerticalGroup(
            containChartPieBenifitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        cbMonthStatisticRevenue.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMonthStatisticRevenueItemStateChanged(evt);
            }
        });

        jLabel4.setText("Xem theo tháng");

        txtStatisticRevenueTotalRevenue.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        txtStatisticRevenueTotalRevenue.setText("1.000.000");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Doanh thu");

        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 3, new java.awt.Color(153, 153, 255)));

        jLabel9.setText("Doanh thu từ phòng");

        txtStatisticRevenueRateRoomRevenue.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtStatisticRevenueRateRoomRevenue.setText("97.00");

        txtStatisticRevenueRoomTotalRevenue.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtStatisticRevenueRoomTotalRevenue.setForeground(new java.awt.Color(102, 102, 102));
        txtStatisticRevenueRoomTotalRevenue.setText("860.000");

        jLabel12.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 3, new java.awt.Color(153, 153, 255)));

        jLabel13.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 3, new java.awt.Color(153, 153, 255)));

        jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 3, new java.awt.Color(153, 153, 255)));

        txtStatisticRevenueMenuRevenue.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtStatisticRevenueMenuRevenue.setForeground(new java.awt.Color(102, 102, 102));
        txtStatisticRevenueMenuRevenue.setText("60.000");

        jLabel16.setText("Doanh thu từ Menu");

        txtStatisticRevenueRateMenuRevenue.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtStatisticRevenueRateMenuRevenue.setText("7.00");

        txtStatisticRevenueThuGiamTru.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtStatisticRevenueThuGiamTru.setForeground(new java.awt.Color(102, 102, 102));
        txtStatisticRevenueThuGiamTru.setText("15.000");

        jLabel19.setText("Thu, giảm trừ");

        txtStatisticRevenueRateThuGiamTru.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtStatisticRevenueRateThuGiamTru.setText("2.09");

        txtStatisticRevenueExPrice.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtStatisticRevenueExPrice.setForeground(new java.awt.Color(102, 102, 102));
        txtStatisticRevenueExPrice.setText("7.000");

        jLabel22.setText("Thu khác");

        txtStatisticRevenueRateExPrice.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtStatisticRevenueRateExPrice.setText("0.15");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel24.setText("%");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel25.setText("%");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel26.setText("%");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel27.setText("%");

        txtStatisticRevenueTotalBenefit.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        txtStatisticRevenueTotalBenefit.setText("1.000.000");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 102, 102));
        jLabel29.setText("Lợi nhuận");

        txtStatisticRevenueTotal_Benefit.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtStatisticRevenueTotal_Benefit.setForeground(new java.awt.Color(102, 102, 102));
        txtStatisticRevenueTotal_Benefit.setText("1.000.000");

        jLabel31.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 3, new java.awt.Color(153, 153, 255)));

        jLabel32.setText("Lợi nhuận");

        txtStatisticRevenueRateTotalBenefit.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtStatisticRevenueRateTotalBenefit.setText("100.00");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel34.setText("%");

        txtStatisticRevenueTotalFee.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        txtStatisticRevenueTotalFee.setText("1.000.000");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Chi phí");

        jLabel11.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 3, new java.awt.Color(153, 153, 255)));

        txtStatisticRevenueTotal_Fee.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtStatisticRevenueTotal_Fee.setForeground(new java.awt.Color(102, 102, 102));
        txtStatisticRevenueTotal_Fee.setText("860.000");

        jLabel15.setText("Chi phí nhập menu");

        txtStatisticRevenueRateTotalFee.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtStatisticRevenueRateTotalFee.setText("97.00");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel28.setText("%");

        containChartPieFee.setPreferredSize(new java.awt.Dimension(230, 230));

        javax.swing.GroupLayout containChartPieFeeLayout = new javax.swing.GroupLayout(containChartPieFee);
        containChartPieFee.setLayout(containChartPieFeeLayout);
        containChartPieFeeLayout.setHorizontalGroup(
            containChartPieFeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        containChartPieFeeLayout.setVerticalGroup(
            containChartPieFeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbMonthStatisticRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(containChartPieBenifit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(containChartPieRevenue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(containChartPieFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(txtStatisticRevenueTotal_Fee)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(txtStatisticRevenueRateTotalFee)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel28))))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(txtStatisticRevenueRoomTotalRevenue)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(txtStatisticRevenueRateRoomRevenue)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel24))
                                            .addComponent(txtStatisticRevenueTotalRevenue)
                                            .addComponent(jLabel7))))
                                .addGap(82, 82, 82)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtStatisticRevenueTotal_Benefit)
                                            .addComponent(jLabel32)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(txtStatisticRevenueRateTotalBenefit)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel34))
                                            .addComponent(txtStatisticRevenueTotalBenefit)
                                            .addComponent(jLabel29)))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtStatisticRevenueTotalFee)
                                            .addComponent(jLabel10))))
                                .addGap(99, 99, 99)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(txtStatisticRevenueMenuRevenue)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtStatisticRevenueRateMenuRevenue)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel25)))
                        .addGap(79, 79, 79)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtStatisticRevenueRateThuGiamTru)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel26))
                            .addComponent(txtStatisticRevenueThuGiamTru))
                        .addGap(104, 104, 104)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtStatisticRevenueRateExPrice)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel27))
                            .addComponent(txtStatisticRevenueExPrice))))
                .addContainerGap(263, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbMonthStatisticRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(containChartPieRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtStatisticRevenueTotalRevenue)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addGap(26, 26, 26)
                                .addComponent(txtStatisticRevenueRoomTotalRevenue)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtStatisticRevenueRateRoomRevenue)
                                    .addComponent(jLabel24)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(txtStatisticRevenueMenuRevenue)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtStatisticRevenueRateMenuRevenue)
                                            .addComponent(jLabel25))
                                        .addGap(11, 11, 11))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(txtStatisticRevenueThuGiamTru)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtStatisticRevenueRateThuGiamTru)
                                            .addComponent(jLabel26))
                                        .addGap(13, 13, 13))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(txtStatisticRevenueExPrice)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtStatisticRevenueRateExPrice)
                                            .addComponent(jLabel27))
                                        .addGap(14, 14, 14)))))
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(containChartPieFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(containChartPieBenifit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(txtStatisticRevenueTotalBenefit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel29)
                                .addGap(33, 33, 33)
                                .addComponent(txtStatisticRevenueTotal_Benefit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtStatisticRevenueRateTotalBenefit)
                                    .addComponent(jLabel34))))
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(txtStatisticRevenueTotalFee)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(txtStatisticRevenueTotal_Fee)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtStatisticRevenueRateTotalFee)
                                    .addComponent(jLabel28)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(302, 302, 302))))))
        );

        jTabbedPane1.addTab("Lợi nhuận", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbMonthStatisticRevenueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMonthStatisticRevenueItemStateChanged
        monthSelected = cbMonthStatisticRevenue.getSelectedItem().toString();
        totalRevenue = 0;
        totalRevenueRoom = 0;
        totalSubPrice = 0;
        totalRevenueService = 0;
        totalExPrice = 0;
        totalInputPriceMenu = 0;
        for (int i = 1; i <= 12; i++) {
            if (monthSelected.equals("Tháng " + i)) {
                for (CheckinDetails c : listCheckinDetails) {
                    if (c.getStartDate().getMonth() + 1 == i) {
                        totalRevenueRoom += c.getPrice();
                        totalSubPrice += c.getSubPrice();
                        totalRevenueService += c.getTotalServicePrice();
                        totalExPrice += c.getExPrice();
                        for (CheckinServiceDetails csd : listCheckinServiceDetails) {
                            if (csd.getIdCheckinDetails() == c.getDetailId()) {
                                for (Service s : listService) {
                                    if (s.getId() == csd.getIdService()) {
                                        totalInputPriceMenu += s.getInputPrice();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        totalRevenue = totalRevenueRoom + totalSubPrice + totalRevenueService + totalExPrice;
        totalBenefit = totalRevenue - totalInputPriceMenu;

        rateRoom = (totalRevenueRoom / totalRevenue) * 100;
        rateService = (totalRevenueService / totalRevenue) * 100;
        rateExPrice = (totalExPrice / totalRevenue) * 100;
        rateSubPrice = (totalSubPrice / totalRevenue) * 100;

        containChartPieRevenue.removeAll();
        containChartPieRevenue.validate();
        setDataChartPieRevenue(revenueRoom, totalRevenueService, totalSubPrice, totalExPrice);

        // revenue
        txtStatisticRevenueTotalRevenue.setText(Utils.formatPrice(totalRevenue));
        txtStatisticRevenueRoomTotalRevenue.setText(Utils.formatPrice(totalRevenueRoom));
        txtStatisticRevenueRateRoomRevenue.setText(decimalFormat.format((double) rateRoom));
        txtStatisticRevenueMenuRevenue.setText(Utils.formatPrice(totalRevenueService));
        txtStatisticRevenueRateMenuRevenue.setText(decimalFormat.format((double) rateService));
        txtStatisticRevenueThuGiamTru.setText(Utils.formatPrice(totalSubPrice));
        txtStatisticRevenueRateThuGiamTru.setText(decimalFormat.format((double) rateSubPrice));
        txtStatisticRevenueExPrice.setText(Utils.formatPrice(totalExPrice));
        txtStatisticRevenueRateExPrice.setText(decimalFormat.format((double) rateExPrice));

        // fee
        txtStatisticRevenueTotalFee.setText(Utils.formatPrice(totalInputPriceMenu));
        txtStatisticRevenueTotal_Fee.setText(Utils.formatPrice(totalInputPriceMenu));
        txtStatisticRevenueRateTotalFee.setText(decimalFormat.format((double) 100));

        // benefit
        txtStatisticRevenueTotalBenefit.setText(Utils.formatPrice(totalBenefit));
        txtStatisticRevenueTotal_Benefit.setText(Utils.formatPrice(totalBenefit));
        txtStatisticRevenueRateTotalBenefit.setText(decimalFormat.format((double) 100));
    }//GEN-LAST:event_cbMonthStatisticRevenueItemStateChanged

    private void btnExportFileExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportFileExcelActionPerformed
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Thống kê thuê phòng " + monthSelected);

        XSSFRow row = null;
        Cell cell = null;

        int rownum = 0;
        row = sheet.createRow(rownum);

        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("STT");

        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Tên phòng");

        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Số lượt thuê");

        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Tổng doanh thu");

        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Tỉ lệ (&)");

        if (listCheckinDetailsFindByMonth.size() == 0) {
            JOptionPane.showMessageDialog(rootPane, SystemConstant.MSG_EXPORT_ERRORS);
        } else {
            FileOutputStream fos = null;
            try {
                for (int i = 0; i < tblStatisticRoom.getRowCount(); i++) {
                    row = sheet.createRow(rownum + 1);

                    cell = row.createCell(0, CellType.NUMERIC);
                    cell.setCellValue(modelTblStatisticRoomRevenue.getValueAt(i, 0) + "");

                    cell = row.createCell(1, CellType.NUMERIC);
                    cell.setCellValue(modelTblStatisticRoomRevenue.getValueAt(i, 1) + "");

                    cell = row.createCell(2, CellType.NUMERIC);
                    cell.setCellValue(modelTblStatisticRoomRevenue.getValueAt(i, 2) + "");

                    cell = row.createCell(3, CellType.STRING);
                    cell.setCellValue(modelTblStatisticRoomRevenue.getValueAt(i, 3) + "");

                    cell = row.createCell(4, CellType.STRING);
                    cell.setCellValue(modelTblStatisticRoomRevenue.getValueAt(i, 4) + "");
                    rownum++;
                }

                File file = new File("Statistic_Revenue_Room_" + monthSelected + ".xlxs");
                fos = new FileOutputStream(file);
                workbook.write(fos);

                JOptionPane.showMessageDialog(rootPane, SystemConstant.MSG_EXPORT_SUCCESSFULLY);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    fos.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btnExportFileExcelActionPerformed

    private void cbSortStatisticRoomRevenueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSortStatisticRoomRevenueItemStateChanged
        Utils.sortDataTable(cbSortStatisticRoomRevenue, tblStatisticRoom, 4);
    }//GEN-LAST:event_cbSortStatisticRoomRevenueItemStateChanged

    private void cbMonthStatisticBookRoomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMonthStatisticBookRoomItemStateChanged
        monthSelected = cbMonthStatisticBookRoom.getSelectedItem().toString();
        listCheckinDetailsFindByMonth.clear();
        totalRevenue = 0;
        for (int i = 1; i <= 12; i++) {
            if (monthSelected.equals("Tháng " + i)) {
                for (CheckinDetails c : listCheckinDetails) {
                    if (c.getStartDate().getMonth() + 1 == i) {
                        listCheckinDetailsFindByMonth.add(c);
                    }
                }
            }
        }
        setDataTableStatisticRoomRevenue(listCheckinDetailsFindByMonth);
    }//GEN-LAST:event_cbMonthStatisticBookRoomItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Thống kê menu " + monthSelected);

        XSSFRow row = null;
        Cell cell = null;

        int rownum = 0;
        row = sheet.createRow(rownum);

        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("STT");

        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Tên dịch vụ");

        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Loại dịch vụ");

        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Số lượng");

        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Doanh thu");

        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Tỉ lệ (%)");

        if (listCheckinServiceDetailsFindByMonth.size() == 0) {
            JOptionPane.showMessageDialog(rootPane, SystemConstant.MSG_EXPORT_ERRORS);
        } else {
            FileOutputStream fos = null;
            try {
                for (int i = 0; i < tblStatisticMenu.getRowCount(); i++) {
                    row = sheet.createRow(rownum + 1);

                    cell = row.createCell(0, CellType.NUMERIC);
                    cell.setCellValue(modelTblStatisticMenu.getValueAt(i, 0) + "");

                    cell = row.createCell(1, CellType.NUMERIC);
                    cell.setCellValue(modelTblStatisticMenu.getValueAt(i, 1) + "");

                    cell = row.createCell(2, CellType.NUMERIC);
                    cell.setCellValue(modelTblStatisticMenu.getValueAt(i, 2) + "");

                    cell = row.createCell(3, CellType.NUMERIC);
                    cell.setCellValue(modelTblStatisticMenu.getValueAt(i, 3) + "");

                    cell = row.createCell(4, CellType.NUMERIC);
                    cell.setCellValue(modelTblStatisticMenu.getValueAt(i, 4) + "");

                    cell = row.createCell(5, CellType.NUMERIC);
                    cell.setCellValue(modelTblStatisticMenu.getValueAt(i, 5) + "");

                    rownum++;
                }

                File file = new File("Statistic_Revenue_Menu_" + monthSelected + ".xlxs");
                fos = new FileOutputStream(file);
                workbook.write(fos);

                JOptionPane.showMessageDialog(rootPane, SystemConstant.MSG_EXPORT_SUCCESSFULLY);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    fos.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbSortStatisticMenuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSortStatisticMenuItemStateChanged
        Utils.sortDataTable(cbSortStatisticMenu, tblStatisticMenu, 5);
    }//GEN-LAST:event_cbSortStatisticMenuItemStateChanged

    private void cbMonthStatisticMenuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMonthStatisticMenuItemStateChanged
        monthSelected = cbMonthStatisticMenu.getSelectedItem().toString();
        listCheckinDetailsFindByMonth.clear();
        listCheckinServiceDetailsFindByMonth.clear();
        totalServiceRevenue = 0;

        for (int i = 1; i <= 12; i++) {
            if (monthSelected.equals("Tháng " + i)) {
                for (CheckinDetails c : listCheckinDetails) {
                    if (c.getStartDate().getMonth() + 1 == i) {
                        listCheckinDetailsFindByMonth.add(c);
                    }
                }
            }
        }
        for (CheckinDetails c : listCheckinDetailsFindByMonth) {
            for (CheckinServiceDetails s : listCheckinServiceDetails) {
                if (c.getDetailId() == s.getIdCheckinDetails()) {
                    listCheckinServiceDetailsFindByMonth.add(s);
                }
            }
        }
        setDataTableStatisticMenu(listCheckinServiceDetailsFindByMonth);
    }//GEN-LAST:event_cbMonthStatisticMenuItemStateChanged

    private void setDataComboxMonth(DefaultComboBoxModel cbModel) {
        for (int i = 1; i <= 12; i++) {
            cbModel.addElement("Tháng " + i);
        }
    }

    private void setDataComboxStatisticRevenueByMonth() {
        cbModelMonthStatisticRevenueByMonth.addElement("6 tháng");
        cbModelMonthStatisticRevenueByMonth.addElement("1 năm");
    }

    private void setDataComboxSort(DefaultComboBoxModel cbModel) {
        cbModel.addElement("Tăng dần");
        cbModel.addElement("Giảm dần");
    }

    private void setDataTableStatisticMenu(List<CheckinServiceDetails> listCSD) {
        modelTblStatisticMenu.setRowCount(0);
        int i = 1;
        totalCountMenuBook = 0;

        for (CheckinServiceDetails c : listCheckinServiceDetailsFindByMonth) {
            totalCountMenuBook += c.getQuantity();
        }

        for (CategoryService catSer : listCategoryService) {
            for (Service ser : listService) {
                for (CheckinServiceDetails c : listCSD) {
                    if (ser.getId() == c.getIdService()) {
                        countMenuBook += c.getQuantity();
                        serviceRevenue = (float) (c.getPrice() * countMenuBook);
                    }
                }
                rateServiceRevenue = (countMenuBook / totalCountMenuBook) * 100;
                if (countMenuBook > 0) {
                    if (catSer.getId() == ser.getCatService()) {
                        modelTblStatisticMenu.addRow(new Object[]{
                            null, ser.getName(), catSer.getName(), (int) countMenuBook, Utils.formatPrice(serviceRevenue), decimalFormat.format((double) rateServiceRevenue)
                        });
                    }
                }
                countMenuBook = 0;
                serviceRevenue = 0;
                i++;
            }
        }

        String strPriceGetFromTable = "";
        float priceGetFromTable = 0;
        for (int j = 0; j < tblStatisticMenu.getRowCount(); j++) {
            // set STT cho bảng
            modelTblStatisticMenu.setValueAt(j + 1, j, 0);
            strPriceGetFromTable = modelTblStatisticMenu.getValueAt(j, 4).toString().replace(".", "");
            priceGetFromTable = Float.parseFloat(strPriceGetFromTable);
            totalServiceRevenue += priceGetFromTable;
        }
        txtTotalRevenueMenu.setText(Utils.formatPrice(totalServiceRevenue));
    }

    private void setDataTableStatisticRoomRevenue(List<CheckinDetails> listCKD) {
        modelTblStatisticRoomRevenue.setRowCount(0);
        int i = 1;
        totalCountBookRoom = 0;
        for (Room r : listRoom) {
            for (CheckinDetails c : listCKD) {
                if (r.getRoomId() == c.getRoomId()) {
                    totalCountBookRoom++;
                }
            }
        }

        for (Room r : listRoom) {
            for (CheckinDetails c : listCKD) {
                if (r.getRoomId() == c.getRoomId()) {
                    countBookRoom++;
                    revenueRoom += c.getPrice();
                }
            }
            totalRevenue += revenueRoom;
            rate = (countBookRoom / totalCountBookRoom) * 100;
            if (countBookRoom > 0) {
                modelTblStatisticRoomRevenue.addRow(new Object[]{
                    i, r.getRoomId(), (int) countBookRoom, Utils.formatPrice(revenueRoom), decimalFormat.format((double) rate)
                });
            }
            revenueRoom = 0;
            countBookRoom = 0;
            i++;
        }
        txtTotalRevenue.setText(Utils.formatPrice(totalRevenue));
        totalRevenue = 0;
    }

    private void setDataChartPieRevenue(float getRevenueRoom, float getRevenueService, float getSubPrice, float getOtherPrice) {
        DefaultPieDataset pieDataSet = new DefaultPieDataset();
        pieDataSet.setValue("Doanh thu từ phòng", new Float(getRevenueRoom));
        pieDataSet.setValue("Doanh thu từ Menu", new Float(getRevenueService));
        pieDataSet.setValue("Thu, giảm trừ", new Float(getSubPrice));
        pieDataSet.setValue("Thu khác", new Float(getOtherPrice));
        JFreeChart chart = ChartFactory.createPieChart("", pieDataSet, false, true, true);
        PiePlot p = (PiePlot) chart.getPlot();

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setDomainZoomable(true);
        containChartPieRevenue.add(chartPanel);
        containChartPieRevenue.setLayout(new BorderLayout());
        containChartPieRevenue.add(chartPanel, BorderLayout.CENTER);
        chartPanel.setVisible(true);
    }

    private void setDataChartPieFee() {

        DefaultPieDataset pieDataSet = new DefaultPieDataset();
        pieDataSet.setValue("Chi phí", new Integer(100));
        JFreeChart chart = ChartFactory.createPieChart("", pieDataSet, false, true, true);
        PiePlot p = (PiePlot) chart.getPlot();

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setDomainZoomable(true);
        containChartPieFee.add(chartPanel);
        containChartPieFee.setLayout(new BorderLayout());
        containChartPieFee.add(chartPanel, BorderLayout.CENTER);
        chartPanel.setVisible(true);
    }

    private void setDataChartPieBenifit() {
        DefaultPieDataset pieDataSet = new DefaultPieDataset();
        pieDataSet.setValue("Lợi nhuận", new Integer(100));
        JFreeChart chart = ChartFactory.createPieChart("", pieDataSet, false, true, true);
        PiePlot p = (PiePlot) chart.getPlot();

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setDomainZoomable(true);
        containChartPieBenifit.add(chartPanel);
        containChartPieBenifit.setLayout(new BorderLayout());
        containChartPieBenifit.add(chartPanel, BorderLayout.CENTER);
        chartPanel.setVisible(true);
    }

    private void setDataChartRevenueByDay() {
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        monthSelected = cbMonthStatisticMenu.getSelectedItem().toString();

        Calendar currentTime = new GregorianCalendar();
        currentTime.setTime(new Date());
        int currentYear = currentTime.get(Calendar.YEAR);
        int currentMonth = currentTime.get(Calendar.MONTH);
        int currentDay = currentTime.get(Calendar.DATE);

        int index;
        if (currentDay - 6 < 1) {
            index = 1;
        } else {
            index = currentDay - 6;
        }

        List<Float> listRevenue = new ArrayList<>();
        for (int i = index; i <= currentDay; i++) {
            listRevenue.add(caculateRevenueRoomByDay(i));
        }

        for (int i = index; i < currentDay; i++) {
            if (listRevenue.size() == 7) {
                dcd.setValue(listRevenue.get(0), "Doanh số", currentYear + "-" + (currentMonth + 1) + "-" + i);
                dcd.setValue(listRevenue.get(1), "Doanh số", currentYear + "-" + (currentMonth + 1) + "-" + (i + 1));
                dcd.setValue(listRevenue.get(2), "Doanh số", currentYear + "-" + (currentMonth + 1) + "-" + (i + 2));
                dcd.setValue(listRevenue.get(3), "Doanh số", currentYear + "-" + (currentMonth + 1) + "-" + (i + 3));
                dcd.setValue(listRevenue.get(4), "Doanh số", currentYear + "-" + (currentMonth + 1) + "-" + (i + 4));
                dcd.setValue(listRevenue.get(5), "Doanh số", currentYear + "-" + (currentMonth + 1) + "-" + (i + 5));
                dcd.setValue(listRevenue.get(6), "Doanh số", currentYear + "-" + (currentMonth + 1) + "-" + (i + 6));
                break;
            } else {
                dcd.setValue(listRevenue.get(0), "Doanh số", currentYear + "-" + (currentMonth + 1) + "-" + i);
                dcd.setValue(listRevenue.get(1), "Doanh số", currentYear + "-" + (currentMonth + 1) + "-" + (i + 1));
                dcd.setValue(listRevenue.get(2), "Doanh số", currentYear + "-" + (currentMonth + 1) + "-" + (i + 2));
                dcd.setValue(listRevenue.get(3), "Doanh số", currentYear + "-" + (currentMonth + 1) + "-" + (i + 3));
                dcd.setValue(listRevenue.get(4), "Doanh số", currentYear + "-" + (currentMonth + 1) + "-" + (i + 4));
                break;
            }
        }
        
        JFreeChart chart = ChartFactory.createBarChart("Doanh thu theo ngày", "Thời gian", "Doanh số", dcd, PlotOrientation.VERTICAL, true, true, true);
        CategoryPlot p = (CategoryPlot) chart.getPlot();

        p.setRangeGridlinePaint(Color.black);

        ChartPanel chartPanel = new ChartPanel(chart);

        chartPanel.setDomainZoomable(
                true);
        containChartRevenueByDay.add(chartPanel);

        containChartRevenueByDay.setLayout(
                new BorderLayout());
        containChartRevenueByDay.add(chartPanel, BorderLayout.CENTER);

        chartPanel.setVisible(
                true);
    }

    private float caculateRevenueRoomByDay(int mainDay) {
        Calendar calStartDate = new GregorianCalendar();
        Calendar calEndDate = new GregorianCalendar();
        Calendar currentTime = new GregorianCalendar();
        currentTime.setTime(new Date());
        int currentYear = currentTime.get(Calendar.YEAR);
        int currentMonth = currentTime.get(Calendar.MONTH);
        int startYear = 0;
        int endYear = 0;
        int startMonth = 0;
        int endMonth = 0;
        int startDay = 0;
        int endDay = 0;

        totalRevenueRoom = 0;
        listCheckinDetailsFindByDay.clear();
        for (CheckinDetails c : listCheckinDetails) {
            calStartDate.setTime(c.getStartDate());
            calEndDate.setTime(c.getEndDate());
            // calculate year
            startYear = calStartDate.get(Calendar.YEAR);
            endYear = calEndDate.get(Calendar.YEAR);
            // calculate month
            startMonth = calStartDate.get(Calendar.MONTH);
            endMonth = calEndDate.get(Calendar.MONTH);
            // calculate days 
            startDay = calStartDate.get(Calendar.DATE);
            endDay = calEndDate.get(Calendar.DATE);
            if (startYear == currentYear && endYear == currentYear && startMonth == currentMonth || endMonth == currentMonth) {
                for (int i = startDay; i <= endDay; i++) {
                    if (i == mainDay) {
                        listCheckinDetailsFindByDay.add(c);
                    }
                }
            }
        }

        for (CheckinDetails cd : listCheckinDetailsFindByDay) {
            revenueRoom = cd.getPrice();
            totalRevenueRoom += revenueRoom;
        }
        return totalRevenueRoom;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportFileExcel;
    private javax.swing.JComboBox<String> cbMonthStatisticBookRoom;
    private javax.swing.JComboBox<String> cbMonthStatisticMenu;
    private javax.swing.JComboBox<String> cbMonthStatisticRevenue;
    private javax.swing.JComboBox<String> cbSortStatisticMenu;
    private javax.swing.JComboBox<String> cbSortStatisticRoomRevenue;
    private javax.swing.JPanel containChartPieBenifit;
    private javax.swing.JPanel containChartPieFee;
    private javax.swing.JPanel containChartPieRevenue;
    private javax.swing.JPanel containChartRevenueByDay;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tblStatisticMenu;
    private javax.swing.JTable tblStatisticRoom;
    private javax.swing.JLabel txtStatisticRevenueExPrice;
    private javax.swing.JLabel txtStatisticRevenueMenuRevenue;
    private javax.swing.JLabel txtStatisticRevenueRateExPrice;
    private javax.swing.JLabel txtStatisticRevenueRateMenuRevenue;
    private javax.swing.JLabel txtStatisticRevenueRateRoomRevenue;
    private javax.swing.JLabel txtStatisticRevenueRateThuGiamTru;
    private javax.swing.JLabel txtStatisticRevenueRateTotalBenefit;
    private javax.swing.JLabel txtStatisticRevenueRateTotalFee;
    private javax.swing.JLabel txtStatisticRevenueRoomTotalRevenue;
    private javax.swing.JLabel txtStatisticRevenueThuGiamTru;
    private javax.swing.JLabel txtStatisticRevenueTotalBenefit;
    private javax.swing.JLabel txtStatisticRevenueTotalFee;
    private javax.swing.JLabel txtStatisticRevenueTotalRevenue;
    private javax.swing.JLabel txtStatisticRevenueTotal_Benefit;
    private javax.swing.JLabel txtStatisticRevenueTotal_Fee;
    private javax.swing.JLabel txtTotalRevenue;
    private javax.swing.JLabel txtTotalRevenueMenu;
    // End of variables declaration//GEN-END:variables
}
