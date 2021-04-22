
package dynuclient.view;

import dynuclient.util.AppLogger;
import dynuclient.util.UpdateService;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author sebad-git
 */
public class App {
    
    public static final String NEW_LINE = System.getProperty("line.separator");
    public static final String NAME = "Dynu Client";
    
    private static SettingsWindow settings;
    private static MonitorWindow monitor;
    
    public static void setTheme(){
      try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
      catch (Exception ex) { AppLogger.log(ex); ex.printStackTrace(); }
    }
     
    public static void exit(){
         UpdateService.getInstance().Stop();
         System.exit(0);
    }
    
    public static void exit(String errorMessage){
        JOptionPane.showMessageDialog(null,errorMessage,"Error", JOptionPane.ERROR_MESSAGE);
        exit();
    }
    
    public static void ShowSettings(){ if(settings==null){ settings = new SettingsWindow(); } settings.setVisible(true); }
    
    public static void ShowMonitor(){ if(monitor==null){ monitor = new MonitorWindow(); } monitor.setVisible(true); }
    
    public static void init(javax.swing.JFrame window, String title, Image icon){
         Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - window.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - window.getHeight()) / 2);
        window.setLocation(x, y);
        window.setTitle(title);
        if(icon!=null){ window.setIconImage(icon); }
        window.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        window.setResizable(false);
    }
    
    public static final void ShowErrorMessage(Component parent,String message){
        JOptionPane.showMessageDialog(parent,message,App.NAME, JOptionPane.ERROR_MESSAGE);
    }
}
