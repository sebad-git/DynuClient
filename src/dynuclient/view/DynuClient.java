
package dynuclient.view;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author sebad-git
 */
public class DynuClient {
    
 
  private static final Image image = loadImage("logodynu.png");
  private static final TrayIcon trayIcon = new TrayIcon(image, "Dynu Client");
  private static final TrayPopupMenu menu = new TrayPopupMenu();
  
  public static void main(String args[]) throws Exception {
    if (SystemTray.isSupported()) {
      SystemTray tray = SystemTray.getSystemTray();
      trayIcon.setImageAutoSize(true);
      trayIcon.setToolTip("Dynu Client");
      trayIcon.setPopupMenu(menu);
      try {
        tray.add(trayIcon);
      } catch (AWTException e) {
         JOptionPane.showMessageDialog(null,"TrayIcon could not be added.","Error", JOptionPane.ERROR_MESSAGE);
      }
    }else{
        JOptionPane.showMessageDialog(null,"Tray icon not Supported.","Error", JOptionPane.ERROR_MESSAGE);
    }
  }
  
  private static BufferedImage loadImage(String fileName){
    try {
        BufferedImage buff = ImageIO.read(DynuClient.class.getResourceAsStream(fileName));
       return buff;
    } catch (Exception e) { e.printStackTrace(); return null; }
    
  }
  
}
