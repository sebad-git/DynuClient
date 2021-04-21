
package dynuclient.view;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import javax.swing.JOptionPane;
import dynuclient.model.Data;
import dynuclient.util.UpdateThread;

/**
 *
 * @author sebad-git
 */
public class DynuClient {
    
  private static final Image image = LocalImages.loadImage(LocalImages.DYN_ICON);
  private static final TrayIcon trayIcon = new TrayIcon(image, "Dynu Client");
  private static final TrayPopupMenu menu = new TrayPopupMenu();
  
  public static void main(String args[]) { new DynuClient(); }
  
  private DynuClient(){
    if (SystemTray.isSupported()) {
        SplashWindow.getInstance().setVisible(true);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try { Thread.sleep(2000); SplashWindow.getInstance().setVisible(false); }
                catch (InterruptedException ex) {}
                 if(Data.isEmpty()){ DynuClientWindow.getInstance().setVisible(true); }
                 else{ UpdateThread.getInstance().Start(); }
                  SystemTray tray = SystemTray.getSystemTray();
                trayIcon.setImageAutoSize(true);
                trayIcon.setToolTip("Dynu Client");
                trayIcon.setPopupMenu(menu);
                try { tray.add(trayIcon); }
                catch (AWTException e) { 
                    JOptionPane.showMessageDialog(null,"TrayIcon could not be added.","Error", JOptionPane.ERROR_MESSAGE);
                    UpdateThread.getInstance().Stop();
                    System.exit(0);
                }
            }
        });
       
    }else{
        JOptionPane.showMessageDialog(null,"Tray icon not Supported.","Error", JOptionPane.ERROR_MESSAGE);
        UpdateThread.getInstance().Stop();
        System.exit(0);
    }
    
  }
  
}
