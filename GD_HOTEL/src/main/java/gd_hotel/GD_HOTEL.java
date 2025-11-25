/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package gd_hotel;

/**
 *
 * @author HOANG PHI
 */
public class GD_HOTEL {
    
    private static boolean checkSignUp = false;
        
    public static boolean getCheck() {
        return checkSignUp;
    }
    public static void setCheck(boolean check) {
        checkSignUp = check;
    }
    
    public static void main(String[] args) {
        
        // gọi HOME_PAGE
        java.awt.EventQueue.invokeLater(() -> new HOME_PAGE().setVisible(true));
        
        
        
        
        
        
    }
}
