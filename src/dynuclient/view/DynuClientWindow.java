
package dynuclient.view;

import dynuclient.model.Data;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author sebad-git
 */
public class DynuClientWindow extends javax.swing.JFrame {

    private Data data=null;
    private static DynuClientWindow instance;
    public static DynuClientWindow getInstance(){
        if(instance==null){ instance = new DynuClientWindow(); } return instance;
    }
    
    public DynuClientWindow() {
        initComponents();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);
        setIconImage(LocalImages.loadImage(LocalImages.DYN_ICON));
        this.data=Data.Load();
        this.txtUser.setText(this.data.User());
        this.txtPassword.setText(this.data.Password());
        this.txtTTL.setText(String.valueOf(this.data.TTL()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        btnStart = new javax.swing.JButton();
        lblTTL = new javax.swing.JLabel();
        txtTTL = new javax.swing.JTextField();
        btnStop = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dynu Client");
        setBackground(new java.awt.Color(73, 77, 82));

        jPanel1.setBackground(new java.awt.Color(246, 246, 246));

        lblUser.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        lblUser.setForeground(new java.awt.Color(51, 51, 51));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setText("User:");

        txtUser.setBackground(new java.awt.Color(246, 246, 246));
        txtUser.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtUser.setForeground(new java.awt.Color(51, 51, 51));
        txtUser.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblPassword.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(51, 51, 51));
        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPassword.setText("Password:");

        txtPassword.setBackground(new java.awt.Color(246, 246, 246));
        txtPassword.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(51, 51, 51));
        txtPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnStart.setBackground(new java.awt.Color(168, 212, 252));
        btnStart.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        btnStart.setForeground(new java.awt.Color(51, 51, 51));
        btnStart.setText("Ok");
        btnStart.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnStart.setBorderPainted(false);
        btnStart.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        lblTTL.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        lblTTL.setForeground(new java.awt.Color(51, 51, 51));
        lblTTL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTTL.setText("TTL:");

        txtTTL.setBackground(new java.awt.Color(246, 246, 246));
        txtTTL.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtTTL.setForeground(new java.awt.Color(51, 51, 51));
        txtTTL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTTL.setText("60");
        txtTTL.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnStop.setBackground(new java.awt.Color(168, 212, 252));
        btnStop.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        btnStop.setForeground(new java.awt.Color(51, 51, 51));
        btnStop.setText("Cancel");
        btnStop.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTTL, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTTL, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(81, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPassword)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtUser)
                                .addGap(9, 9, 9))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUser))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTTL)
                    .addComponent(txtTTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        lblPassword.getAccessibleContext().setAccessibleName("lblPassword");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        if(!this.validateData()){ return; }
        this.data = new Data(txtUser.getText(), txtPassword.getText(), Integer.parseInt(txtTTL.getText()));
        try { Data.save(this.data); }
        catch (IOException ex) { ex.printStackTrace(); }
        this.setVisible(false);
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnStopActionPerformed
    
    private boolean validateData(){
       if(txtUser.getText()== null || txtUser.getText().length()<1){
            JOptionPane.showMessageDialog(this, "User is empty.","Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(txtPassword.getText()== null || txtPassword.getText().length()<1){
            JOptionPane.showMessageDialog(this, "Password is empty.","Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(txtTTL.getText()== null || txtTTL.getText().length()<1){
            JOptionPane.showMessageDialog(this, "MTU is empty.","Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        int mtu = 0;
        try{ mtu = Integer.parseInt(txtTTL.getText()); }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this,"MTU is not a number.","Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(mtu ==0){
            JOptionPane.showMessageDialog(this, "MTU cant be 0.","Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTTL;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtTTL;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
