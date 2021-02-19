/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author THUY
 */
public class Utils {

    public static void setIconIF(JInternalFrame internalFrame, String title) {
        ImageIcon imgIcon = new ImageIcon("src\\bkap\\images\\logo.png");
        Image image = imgIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon imgLogo = new ImageIcon(newimg);
        internalFrame.setTitle(title);
        internalFrame.setFrameIcon(imgLogo);
    }

    public static Date getCurrentTime() {
        Date currentTime = new Date();
        return currentTime;
    }

    public static String formatPrice(Float price) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat vn = NumberFormat.getInstance(localeVN);
        String formated = vn.format(price);
        return formated;
    }

    public static void setImage(JLabel containImg, String pathImg) {
        ImageIcon imgIcon = new ImageIcon(pathImg);
        Image img = imgIcon.getImage();
        Image newImage = img.getScaledInstance(containImg.getWidth(), containImg.getHeight(), Image.SCALE_SMOOTH);
        imgIcon = new ImageIcon(newImage);

        containImg.setIcon(imgIcon);
    }

    public static void setMessageInformation(JLabel label, String msg, Boolean status) {
        Font font = new Font("Tahoma", Font.ITALIC, 13);
        label.setFont(font);
        if (status == false) {
            label.setForeground(Color.RED);
            label.setText(msg);
        } else {
            label.setForeground(Color.BLUE);
            label.setText(msg);
        }
    }

    public static void sortDataTable(JComboBox cbName, JTable tblName, int positionColumnTableSorting) {
        String sortSelected = cbName.getSelectedItem().toString();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tblName.getModel());
        tblName.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();

        if (sortSelected.equals("Tăng dần")) {
            sortKeys.add(new RowSorter.SortKey(positionColumnTableSorting, SortOrder.ASCENDING));
            sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        } else {
            sortKeys.add(new RowSorter.SortKey(positionColumnTableSorting, SortOrder.DESCENDING));
            sortKeys.add(new RowSorter.SortKey(0, SortOrder.DESCENDING));
        }
        sorter.setSortKeys(sortKeys);
    }
}
