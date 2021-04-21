/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynuclient.view.util;

import javax.swing.UIManager;

/**
 *
 * @author deneg
 */
public class Theme {
    
    public static void setTheme(){
      try { UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); }
      catch (Exception ex) { ex.printStackTrace(); }
    }
}
