/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdm.dynuclient.view;

import com.sdm.dynuclient.resources.Resources;
import com.sdm.dynuclient.util.AppLogger;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author sebad-git
 */
public class MonitorWindow extends javax.swing.JFrame {

    private UpdateMonitor monitorThread;
    
    public MonitorWindow() {
        initComponents();
        App.init(this, "Monitor",Resources.loadImage(Resources.DYN_ICON));
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if(visible){
            if(monitorThread ==null){ monitorThread = new UpdateMonitor(); }
            monitorThread.start();
        }
        else{ if(monitorThread!=null){ monitorThread.Stop(); } }
    }

    @Override
    public void dispose() {
        if(monitorThread!=null){ monitorThread.Stop(); }
        super.dispose();
    }
    
    private final class UpdateMonitor extends Thread {
        private boolean running;

        @Override
        public synchronized void start() { if(running){ return; } running = true; super.start(); }
        
        @Override
        public void run() {
            while(running){
                try (
                    BufferedReader reader = new BufferedReader(new FileReader(AppLogger.getLogFile()))) {
                     System.out.println("Reading log.");
                    StringBuilder logMonitor = new StringBuilder();
                    Object[] lines = reader.lines().toArray();
                    for (Object line : lines) { logMonitor.append(line); logMonitor.append(App.NEW_LINE); }
                    reader.close();
                    txtLog.setText(logMonitor.toString());
                } catch (Exception ex) { System.out.println(ex.getMessage()); }
                try { Thread.sleep(30 * 1000); } catch (InterruptedException ex) {ex.printStackTrace(); }
            }
        }
        public void Stop(){ if(!running){ return; } running=false; monitorThread=null; }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();

        txtLog.setBackground(new java.awt.Color(0, 0, 0));
        txtLog.setColumns(20);
        txtLog.setFont(new java.awt.Font("Lucida Console", 0, 13)); // NOI18N
        txtLog.setForeground(new java.awt.Color(255, 255, 255));
        txtLog.setRows(5);
        txtLog.setBorder(null);
        txtLog.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(txtLog);
        txtLog.getAccessibleContext().setAccessibleParent(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtLog;
    // End of variables declaration//GEN-END:variables

}
