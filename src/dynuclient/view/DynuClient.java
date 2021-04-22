
package dynuclient.view;

import dynuclient.model.Data;
import dynuclient.resources.Resources;
import dynuclient.util.AppLogger;
import dynuclient.util.UpdateService;
import dynuclient.view.App;
import dynuclient.view.TrayPopupMenu;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;

/**
 *
 * @author sebad-git
 */
public class DynuClient extends javax.swing.JFrame {

    public DynuClient() {
        setUndecorated (true);
        initComponents();
        App.init(this, "",null);
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if(b){ startApp(); }
    }
    
    private void startApp(){
        java.awt.EventQueue.invokeLater(new Runnable() {
          public void run() {
              try { Thread.sleep(1300); setVisible(false); } catch (InterruptedException ex) {}
              createTray();
              dispose();
          }});
    }
    
    private void createTray(){
        if (SystemTray.isSupported()) {
             SystemTray tray = SystemTray.getSystemTray();
             final Image image = Resources.loadImage(Resources.DYN_ICON);
             final TrayIcon trayIcon = new TrayIcon(image, App.NAME);
             trayIcon.setImageAutoSize(true);
             trayIcon.setToolTip(App.NAME);
             trayIcon.setPopupMenu(new TrayPopupMenu());
            try {
                tray.add(trayIcon);
                trayIcon.displayMessage(App.NAME, "App Started.", TrayIcon.MessageType.INFO);
            }
            catch (Exception e) {AppLogger.log(e); App.exit("Tray icon not Supported."); }
         if(Data.isEmpty()){ App.ShowSettings(); }
         else{
             //UpdateService.getInstance().Start();
             trayIcon.displayMessage(App.NAME, "Update Service Started..", TrayIcon.MessageType.INFO);
         }
       }else{ App.exit("Tray icon not Supported."); }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                App.setTheme();
                new DynuClient().setVisible(true);
            }});
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        setType(java.awt.Window.Type.UTILITY);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dynu Client");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(dynuclient.resources.Resources.loadIcon(dynuclient.resources.Resources.DYN_LOGO));
        jLabel2.setIconTextGap(0);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
