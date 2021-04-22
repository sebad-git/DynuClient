
package dynuclient.view.main;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import dynuclient.model.Data;
import dynuclient.util.UpdateThread;
import dynuclient.resources.Resources;
import dynuclient.util.Logger;
import dynuclient.view.windows.SettingsWindow;
import dynuclient.view.windows.SplashWindow;

/**
 *
 * @author sebad-git
 */
public class DynuClient {
    
  private static final Image image = Resources.loadImage(Resources.DYN_ICON);
  private static final TrayIcon trayIcon = new TrayIcon(image, App.NAME);
  private static final TrayPopupMenu menu = new TrayPopupMenu();
  
  public static void main(String args[]) { 
      App.setTheme(); 
      SplashWindow splash = new SplashWindow();
      splash.setVisible(true);
  }
  
  /*
  private static final void StartApp() {
    if (SystemTray.isSupported()) {
        SplashWindow splash = new SplashWindow();
        splash.setVisible(true);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try { Thread.sleep(1300); splash.setVisible(false); } catch (InterruptedException ex) {}
                 if(Data.isEmpty()){ SettingsWindow.getInstance().setVisible(true); }
                 else{
                     UpdateThread.getInstance().Start(); trayIcon.setToolTip("Dynu Client Started..."); 
                 }
                try {
                    SystemTray tray = SystemTray.getSystemTray();
                    trayIcon.setImageAutoSize(true);
                    trayIcon.setToolTip(App.NAME);
                    trayIcon.setPopupMenu(menu);
                    tray.add(trayIcon);
                    trayIcon.displayMessage("Title", "MESSAGE HERE", TrayIcon.MessageType.ERROR);
                }
                catch (Exception e) {Logger.log(e); App.exit("Tray icon not Supported."); }
            }
        });
    }else{ App.exit("Tray icon not Supported."); }
    
  }
*/
  
  private static final void StartApp(){
      SplashWindow splash = new SplashWindow();
      splash.setVisible(true);
      java.awt.EventQueue.invokeLater(new Runnable() {
          public void run() {
              try { Thread.sleep(1300); splash.setVisible(false); } catch (InterruptedException ex) {}
              showTray();
          }});
  }
  
  private static final void showTray(){
       if (SystemTray.isSupported()) {
            try {
                SystemTray tray = SystemTray.getSystemTray();
                trayIcon.setImageAutoSize(true);
                trayIcon.setToolTip(App.NAME);
                trayIcon.setPopupMenu(menu);
                tray.add(trayIcon);
                trayIcon.displayMessage("Title", "MESSAGE HERE", TrayIcon.MessageType.ERROR);
            }
            catch (Exception e) {Logger.log(e); App.exit("Tray icon not Supported."); }
         if(Data.isEmpty()){ SettingsWindow.getInstance().setVisible(true); }
         else{
             UpdateThread.getInstance().Start(); trayIcon.setToolTip("Dynu Client Started..."); 
         }
       }else{ App.exit("Tray icon not Supported."); }
  }
  
  
}
