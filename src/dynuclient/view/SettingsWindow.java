
package dynuclient.view;

import dynuclient.resources.Resources;
import dynuclient.model.Data;
import java.io.IOException;

/**
 *
 * @author sebad-git
 */
public class SettingsWindow extends javax.swing.JFrame {

    private Data data=null;
    
    public SettingsWindow() {
        initComponents();
        App.init(this, "Dynu Settings",Resources.loadImage(Resources.DYN_ICON));
    }

    @Override
    public void setVisible(boolean visible) {
        if(visible){
            this.cb_ShowPWD.setSelected(false);
            this.data=Data.Load();
            this.txtUser.setText(this.data.User());
            this.txtPassword.setText(this.data.Password());
            this.txtTTL.setText(String.valueOf(this.data.TTL()));
            this.txtPassword.setEchoChar('*');
        }
       super.setVisible(visible);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblUserIcon = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        lblPassword = new javax.swing.JLabel();
        lblTTL1 = new javax.swing.JLabel();
        cb_ShowPWD = new javax.swing.JCheckBox();
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        txtTTL = new javax.swing.JTextField();

        setTitle("Dynu Client");
        setBackground(new java.awt.Color(51, 204, 255));

        jPanel1.setBackground(new java.awt.Color(222, 224, 228));

        lblUserIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserIcon.setIcon(dynuclient.resources.Resources.loadIcon(dynuclient.resources.Resources.DYN_ICON));

        lblUser.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblUser.setForeground(new java.awt.Color(64, 64, 64));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setText("Username:");
        lblUser.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        lblUser.setDoubleBuffered(true);

        txtUser.setBackground(new java.awt.Color(246, 246, 246));
        txtUser.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtUser.setForeground(new java.awt.Color(102, 102, 102));
        txtUser.setToolTipText("User");
        txtUser.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtPassword.setBackground(new java.awt.Color(246, 246, 246));
        txtPassword.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(102, 102, 102));
        txtPassword.setToolTipText("Password");
        txtPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(153, 153, 153))); // NOI18N

        lblPassword.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(64, 64, 64));
        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPassword.setText("Password:");
        lblPassword.setToolTipText("");
        lblPassword.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        lblPassword.setDoubleBuffered(true);

        lblTTL1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblTTL1.setForeground(new java.awt.Color(64, 64, 64));
        lblTTL1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTTL1.setText("TTL:");
        lblTTL1.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        lblTTL1.setDoubleBuffered(true);

        cb_ShowPWD.setBackground(new java.awt.Color(222, 224, 228));
        cb_ShowPWD.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cb_ShowPWD.setForeground(new java.awt.Color(64, 64, 64));
        cb_ShowPWD.setText("Show Password");
        cb_ShowPWD.setToolTipText("Show Password as Letters");
        cb_ShowPWD.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cb_ShowPWDStateChanged(evt);
            }
        });
        cb_ShowPWD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ShowPWDActionPerformed(evt);
            }
        });

        btnStart.setBackground(new java.awt.Color(246, 181, 29));
        btnStart.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        btnStart.setForeground(new java.awt.Color(64, 64, 64));
        btnStart.setText("Save");
        btnStart.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnStart.setBorderPainted(false);
        btnStart.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnStop.setBackground(new java.awt.Color(50, 103, 249));
        btnStop.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        btnStop.setForeground(new java.awt.Color(64, 64, 64));
        btnStop.setText("Close");
        btnStop.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        txtTTL.setBackground(new java.awt.Color(246, 246, 246));
        txtTTL.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtTTL.setForeground(new java.awt.Color(102, 102, 102));
        txtTTL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTTL.setText("30");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblUserIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                            .addComponent(txtPassword))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lblTTL1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTTL, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 27, Short.MAX_VALUE)
                                .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cb_ShowPWD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblUserIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cb_ShowPWD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTTL1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTTL, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        if(!this.validateData()){ return; }
        int ttl=Integer.parseInt(this.txtTTL.getText());
        this.data = new Data(txtUser.getText(), new String(txtPassword.getPassword()),ttl);
        try { Data.save(this.data); }
        catch (IOException ex) { ex.printStackTrace(); }
        this.setVisible(false);
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnStopActionPerformed

    private void cb_ShowPWDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ShowPWDActionPerformed

    }//GEN-LAST:event_cb_ShowPWDActionPerformed

    private void cb_ShowPWDStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cb_ShowPWDStateChanged
        if (cb_ShowPWD.isSelected()==true) { this.txtPassword.setEchoChar((char)0); }
        else{ this.txtPassword.setEchoChar('*'); }
    }//GEN-LAST:event_cb_ShowPWDStateChanged
    
    private boolean validateData(){
       if(this.txtUser.getText()== null || this.txtUser.getText().length()<1){
            App.ShowErrorMessage(this, "User is empty.");
            return false;
        }
        if(this.txtPassword.getPassword()== null || this.txtPassword.getPassword().length<1){
            App.ShowErrorMessage(this, "Password is empty.");
            return false;
        }
        if(this.txtTTL.getText()== null || this.txtTTL.getText().length()<1){
            App.ShowErrorMessage(this, "TTL is empty.");
            return false;
        }
        int ttl = 0;
        try{ttl=Integer.parseInt(this.txtTTL.getText());}
            catch(NumberFormatException e){
            App.ShowErrorMessage(this, "TTL is not a number.");
            return false;
        }
        if(ttl<30 || ttl>3000){
            App.ShowErrorMessage(this, "TTL must be between 30 and 3000.");
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JCheckBox cb_ShowPWD;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTTL1;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUserIcon;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtTTL;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
