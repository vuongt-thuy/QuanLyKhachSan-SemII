/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.utils;

/**
 *
 * @author THUY
 */
public class SystemConstant {
    public final static String host = "localhost";
    public final static String port = "1433";
    public final static String databasename = "QuanLyKhachSan";
    public final static String username = "sa";
    public final static String password = "1234$";
    
    public final static String SECRET_KEY = "QLKS";
    
    public final static boolean GENDER_FEMALE = true;
    public final static boolean GENDER_MALE = false;
    public final static String GENDER_TXT_MALE = "Nam";
    public final static String GENDER_TXT_FEMALE = "Nữ";
    
    public final static String STATUS_TXT_ROOM_EMPTY = "Trống";
    public final static String STATUS_TXT_ROOM_USING = "Có khách";
    public final static String STATUS_TXT_ROOM_REPAIRING = "Đang bảo dưỡng";
    public final static int STATUS_ROOM_EMPTY = 0;
    public final static int STATUS_ROOM_USING = 1;
    public final static int STATUS_ROOM_REPAIRING = 2;
        
    public final static int STATUS_ON = 0;
    public final static int STATUS_OFF = 1;
    
    public final static int STATUS_PRODUCT_NORMAL = 0;
    public final static int STATUS_PRODUCT_ABNORMAl = 1;
    public final static String STATUS_TXT_PRODUCT_NORMAL = "Mới";
    public final static String STATUS_TXT_PRODUCT_ABNORMAL = "Hư hỏng";
    
    public final static int STATUS_CUPON_ON = 0; 
    public final static int STATUS_CUPON_OFF = 1; 
    public final static String STATUS_TXT_CUPON_ON = "Đang diễn ra"; 
    public final static String STATUS_TXT_CUPON_OFF = "Hết hạn"; 
    
    public final static String CONFIRM_DELETE = "Bạn có muốn xóa không?";
    public final static String CONFIRM_UPDATE = "Bạn có muốn cập nhật không?";
    
    public final static String MSG_SUCCESSFUL_UPDATE = "Cập nhật dữ liệu thành công";
    public final static String MSG_SUCCESSFUL_LOGIN = "Đăng nhập liệu thành công";
    
    public final static String MSG_ERROR_UPDATE = "Cập nhật dữ liệu thất bại";
    public final static String MSG_ERROR_LOGIN = "Đăng nhập thất bại";
    
    public final static String MSG_ERROR_CHOOSE_ROW_TABLE = "Vui lòng chọn đối tượng cần cập nhật!";
    
    public final static String ERROR_NO_RESULT = "Không tìm thấy kết quả!";
    
    public final static int LEVEL_ADMIN = 1;
    public final static int LEVEL_USER = 2;
    
    public final static String MSG_EXPORT_SUCCESSFULLY = "Xuất file thành công!";
    public final static String MSG_EXPORT_ERRORS = "Xuất file thất bại!";
}
