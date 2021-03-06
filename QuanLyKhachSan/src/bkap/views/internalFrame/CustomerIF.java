/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.views.internalFrame;

import bkap.dao.impl.CustomerDAO;
import bkap.model.Customer;
import bkap.utils.Helper;
import bkap.utils.SystemConstant;
import bkap.utils.Utils;
import bkap.views.LoginDialog;
import java.awt.Color;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hongb
 */
public class CustomerIF extends javax.swing.JInternalFrame {

    private CustomerDAO cusDAO = new CustomerDAO();

    private List<Customer> listCustomer;

    private DefaultTableModel modelCustomer;

    private int indexSelected = 0;
    private String cusPhone = "";
    private String fullname;
    private String phone;
    private String identityCard;
    private String descript;
    private String address;
    private String email;

    /**
     * Creates new form CustomerIF
     */
    public CustomerIF() {
        Utils.setIconIF(this, Helper.getResources("tCustomer"));
        initComponents();

        listCustomer = cusDAO.findAll();

        modelCustomer = (DefaultTableModel) tblCustomer.getModel();

        setDataTable(listCustomer);

        if (LoginDialog.levelUser == SystemConstant.LEVEL_USER) {
            btnAdd.setEnabled(false);
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
        }
        setNameLabelAndButton();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupGender = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lbFullname = new javax.swing.JLabel();
        txtFullname = new javax.swing.JTextField();
        lbPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lbEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lbAddress = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        lbGender = new javax.swing.JLabel();
        lbMale = new javax.swing.JRadioButton();
        lbFemale = new javax.swing.JRadioButton();
        lbIdentityCard = new javax.swing.JLabel();
        txtIdentityCard = new javax.swing.JTextField();
        lbNote = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescript = new javax.swing.JTextArea();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnRefresh = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCustomer = new javax.swing.JTable();
        msgInformation = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        txtKeySearch = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Khách hàng");
        setRequestFocusEnabled(false);

        lbFullname.setText("Họ và tên");

        lbPhone.setText("Số điện thoại");

        lbEmail.setText("Email");

        lbAddress.setText("Địa chỉ");

        txtAddress.setColumns(20);
        txtAddress.setRows(2);
        jScrollPane1.setViewportView(txtAddress);

        lbGender.setText("Giới tính");

        buttonGroupGender.add(lbMale);
        lbMale.setText("Nam");

        buttonGroupGender.add(lbFemale);
        lbFemale.setText("Nữ");

        lbIdentityCard.setText("Thẻ CMND/ CCCD");

        lbNote.setText("Ghi chú");

        txtDescript.setColumns(20);
        txtDescript.setRows(5);
        jScrollPane2.setViewportView(txtDescript);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bkap/images/icon/icons8_remove_20px.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bkap/images/icon/icons8_edit_20px.png"))); // NOI18N
        btnUpdate.setText("Sửa");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bkap/images/icon/icons8_add_20px.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(240, 240, 240));

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bkap/images/icon/icons8_refresh_20px.png"))); // NOI18N
        btnRefresh.setText("Làm mới");
        btnRefresh.setPreferredSize(new java.awt.Dimension(109, 29));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbFullname)
                            .addComponent(lbPhone)
                            .addComponent(lbAddress)
                            .addComponent(lbGender))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFullname)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbEmail)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtEmail))
                                    .addComponent(jScrollPane1)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(lbMale)
                                .addGap(18, 18, 18)
                                .addComponent(lbFemale)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbIdentityCard)
                            .addComponent(lbNote))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdentityCard)
                            .addComponent(jScrollPane2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFullname)
                    .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPhone)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAddress)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbGender)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbMale)
                        .addComponent(lbFemale)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIdentityCard)
                    .addComponent(txtIdentityCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNote)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tblCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Họ và tên", "Số điện thoại", "Email", "Địa chỉ", "Giới tính", "CMND/ CCCD", "Mô tả", "Ngày tạo", "Cập nhật gần đây"
            }
        ));
        tblCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomerMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblCustomer);

        msgInformation.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bkap/images/icon/icons8_search_20px.png"))); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtKeySearch.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        txtKeySearch.setForeground(new java.awt.Color(153, 153, 153));
        txtKeySearch.setText("Số điện thoại, CMND");
        txtKeySearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtKeySearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtKeySearchFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(msgInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtKeySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtKeySearch))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(msgInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        getValueOfFields();
        if (checkValidate()) {
            Customer c = setPropertiesForObject();
            cusDAO.add(c);
            Utils.setMessageInformation(msgInformation, SystemConstant.MSG_SUCCESSFUL_UPDATE, true);
            setNullValueFields();
            listCustomer = cusDAO.findAll();
            setDataTable(listCustomer);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int reply = JOptionPane.showConfirmDialog(rootPane, SystemConstant.CONFIRM_DELETE);

        if (reply == 0) {
            indexSelected = tblCustomer.getSelectedRow();

            if (indexSelected == -1) {
                Utils.setMessageInformation(msgInformation, SystemConstant.MSG_ERROR_CHOOSE_ROW_TABLE, false);
            } else {
                cusDAO.delete(cusPhone);
                setNullValueFields();
                Utils.setMessageInformation(msgInformation, SystemConstant.MSG_SUCCESSFUL_UPDATE, true);
                listCustomer = cusDAO.findAll();
                setDataTable(listCustomer);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomerMouseClicked
        btnAdd.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
        msgInformation.setText("");

        indexSelected = tblCustomer.getSelectedRow();

        Customer c = listCustomer.get(indexSelected);
        cusPhone = c.getPhone();
        txtFullname.setText(c.getFullname());
        txtPhone.setText(c.getPhone());
        txtEmail.setText(c.getEmail());
        txtAddress.setText(c.getAddress());
        txtIdentityCard.setText(c.getNumIdentityCard() + "");
        txtDescript.setText(c.getDescript());

        if (c.isGender() == SystemConstant.GENDER_FEMALE) {
            lbFemale.setSelected(true);
        } else {
            lbMale.setSelected(true);
        }

    }//GEN-LAST:event_tblCustomerMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int reply = JOptionPane.showConfirmDialog(rootPane, SystemConstant.CONFIRM_UPDATE);

        if (reply == 0) {
            indexSelected = tblCustomer.getSelectedRow();

            if (indexSelected == -1) {
                Utils.setMessageInformation(msgInformation, SystemConstant.MSG_ERROR_CHOOSE_ROW_TABLE, false);
            } else {
                getValueOfFields();
                if (checkValidate()) {
                    Customer c = setPropertiesForObject();
                    cusDAO.edit(c);
                    setNullValueFields();
                    Utils.setMessageInformation(msgInformation, SystemConstant.MSG_SUCCESSFUL_UPDATE, true);
                    listCustomer = cusDAO.findAll();
                    setDataTable(listCustomer);
                }
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtKeySearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtKeySearchFocusGained
        if (txtKeySearch.getText().equals("Số điện thoại, CMND")) {
            txtKeySearch.setText("");
            txtKeySearch.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtKeySearchFocusGained

    private void txtKeySearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtKeySearchFocusLost
        if (txtKeySearch.getText().equals("")) {
            txtKeySearch.setText("Số điện thoại, CMND");
            txtKeySearch.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtKeySearchFocusLost

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        setNullValueFields();
        listCustomer = cusDAO.findAll();
        setDataTable(listCustomer);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String keySearch = txtKeySearch.getText();
        if (listCustomer.equals("Số điện thoại, CMND")) {
            Utils.setMessageInformation(msgInformation, "Vui Lòng nhập thông tin cần tìm kiếm!", false);
        } else {
            listCustomer = cusDAO.findByPhone(keySearch);
            if (listCustomer.isEmpty()) {
                Utils.setMessageInformation(msgInformation, "Không tìm thấy khách hàng!", false);
                listCustomer = cusDAO.findByNumIdentityCard(keySearch);
                if (listCustomer.isEmpty()) {
                    Utils.setMessageInformation(msgInformation, "Không tìm thấy khách hàng!", false);
                } else {
                    msgInformation.setText("");
                }
            }
//        listCustomer = cusDAO.findByPhone(keySearch);
//        if (listCustomer.equals("Số điện thoại, CMND")) {
//            Utils.setMessageInformation(msgInformation, "Không tìm thấy khách hàng!", false);
//            listCustomer = cusDAO.findByNumIdentityCard(keySearch);
//            if (listCustomer.isEmpty()) {
//                Utils.setMessageInformation(msgInformation, "Không tìm thấy khách hàng!", false);
//            }
//        } else {
//            msgInformation.setText("");
        }
        setDataTable(listCustomer);
    }//GEN-LAST:event_btnSearchActionPerformed

    private Customer setPropertiesForObject() {
        Customer c = new Customer();
        c.setPhone(phone);
        c.setFullname(fullname);
        c.setEmail(email);
        c.setAddress(address);
        if (lbFemale.isSelected()) {
            c.setGender(SystemConstant.GENDER_FEMALE);
        } else {
            c.setGender(SystemConstant.GENDER_MALE);
        }
        c.setNumIdentityCard(identityCard);
        c.setDescript(descript);
        c.setCreatedAt(Utils.getCurrentTime());
        c.setUpdatedAt(Utils.getCurrentTime());
        return c;
    }

    private void getValueOfFields() {
        fullname = txtFullname.getText();
        phone = txtPhone.getText();
        identityCard = txtIdentityCard.getText();
        descript = txtDescript.getText();
        address = txtAddress.getText();
        email = txtEmail.getText();
    }

    private boolean checkValidate() {
        boolean check = false;
        if (fullname.isEmpty()) {
            Utils.setMessageInformation(msgInformation, "Vui lòng nhập tên khách hàng!", false);
        } else if (phone.isEmpty()) {
            Utils.setMessageInformation(msgInformation, "Vui lòng nhập số điện thoại!", false);
        } else if (!phone.matches("^[0-9]{10}+$")) {
            Utils.setMessageInformation(msgInformation, "Vui lòng nhập số điện thoại đúng định dạng!", false);
        } else if (!email.isEmpty() && !email.matches("^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$")) {
            Utils.setMessageInformation(msgInformation, "Vui lòng nhập đúng định dạng email!", false);
        } else if (address.isEmpty()) {
            Utils.setMessageInformation(msgInformation, "Vui lòng nhập đỉa chị khách hàng!", false);
        } else if (!lbFemale.isSelected() && !lbMale.isSelected()) {
            Utils.setMessageInformation(msgInformation, "Vui lòng chọn giới tính!", false);
        } else if (identityCard.isEmpty()) {
            Utils.setMessageInformation(msgInformation, "Vui lòng nhập số chứng minh thư!", false);
        } else {
            check = true;
        }
        return check;
    }

    private void setNullValueFields() {
        btnAdd.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);

        txtFullname.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
        txtIdentityCard.setText("");
        txtDescript.setText("");
        buttonGroupGender.clearSelection();

        txtKeySearch.setText("Số điện thoại, CMND");
        txtKeySearch.setForeground(new Color(153, 153, 153));
    }

    private void setDataTable(List<Customer> list) {
        modelCustomer.setRowCount(0);
        for (Customer c : list) {
            modelCustomer.addRow(new Object[]{
                c.getFullname(), c.getPhone(), c.getEmail(), c.getAddress(), c.isGender() == SystemConstant.GENDER_FEMALE ? "Nữ" : "Nam", c.getNumIdentityCard(), c.getDescript(), c.getCreatedAt(), c.getUpdatedAt()
            });
        }
    }

    private void setNameLabelAndButton() {
        lbAddress.setText(Helper.getResources("address"));
        lbEmail.setText(Helper.getResources("address"));
        lbFemale.setText(Helper.getResources("female"));
        lbFullname.setText(Helper.getResources("fullname"));
        lbGender.setText(Helper.getResources("gender"));
        lbIdentityCard.setText(Helper.getResources("numOfIdentityCard"));
        lbMale.setText(Helper.getResources("male"));
        lbNote.setText(Helper.getResources("note"));
        lbPhone.setText(Helper.getResources("phone"));

        btnAdd.setText(Helper.getResources("add"));
        btnDelete.setText(Helper.getResources("delete"));
        btnRefresh.setText(Helper.getResources("refresh"));
        btnSearch.setText(Helper.getResources("search"));
        btnUpdate.setText(Helper.getResources("update"));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroupGender;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbAddress;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JRadioButton lbFemale;
    private javax.swing.JLabel lbFullname;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbIdentityCard;
    private javax.swing.JRadioButton lbMale;
    private javax.swing.JLabel lbNote;
    private javax.swing.JLabel lbPhone;
    private javax.swing.JLabel msgInformation;
    private javax.swing.JTable tblCustomer;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextArea txtDescript;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JTextField txtIdentityCard;
    private javax.swing.JTextField txtKeySearch;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
