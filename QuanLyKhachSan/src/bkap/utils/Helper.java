/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.utils;

import java.util.ResourceBundle;

/**
 *
 * @author THUY
 */
public class Helper {

    public static String getResources(String key) {
        ResourceBundle bundle = ResourceBundle.getBundle("bkap.lang.resources/Resources", AppConfig.locale);
        return bundle.getString(key);
    }
}
