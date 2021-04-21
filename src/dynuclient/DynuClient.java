/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynuclient;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DynuClient {
  
  private static Image image = Toolkit.getDefaultToolkit().getImage("logodynu.png");
  private static TrayIcon trayIcon = new TrayIcon(image, "Dynu Client");
  
  public static void main(String args[]) throws Exception {
    if (SystemTray.isSupported()) {
      SystemTray tray = SystemTray.getSystemTray();
      trayIcon.setImageAutoSize(true);
      trayIcon.setToolTip("Dynu Client");
      
      trayIcon.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          System.out.println("In here");
          trayIcon.displayMessage("Tester!", "Some action performed", TrayIcon.MessageType.INFO);
        }
      });

      try {
        tray.add(trayIcon);
      } catch (AWTException e) {
        System.err.println("TrayIcon could not be added.");
      }
    }else{
        System.out.println("Not Supported");
    }
  }
}
