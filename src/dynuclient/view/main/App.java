
package dynuclient.view.main;

import dynuclient.util.Logger;
import dynuclient.util.UpdateThread;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author sebad-git
 */
public class App {
    
    public static final String NEW_LINE = System.getProperty("line.separator");
    
    public static final String NAME = "Dynu Client";
    
    public static void setTheme(){
      try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); }
      catch (Exception ex) { Logger.log(ex); ex.printStackTrace(); }
    }
     
    public static void exit(){
         UpdateThread.getInstance().Stop();
         System.exit(0);
    }
    
    public static void exit(String errorMessage){
        JOptionPane.showMessageDialog(null,errorMessage,"Error", JOptionPane.ERROR_MESSAGE);
        exit();
    }
    
}
