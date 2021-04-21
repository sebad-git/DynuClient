/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynuclient.view;

import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author sebad-git
 */
public class TrayPopupMenu extends PopupMenu implements ActionListener{
    
    private final MenuItem settings = new MenuItem("Settings");
    private final MenuItem start = new MenuItem("Start");
    private final MenuItem stop = new MenuItem("Stop");
    private final MenuItem exit = new MenuItem("Exit");
    
    public TrayPopupMenu(){
       settings.addActionListener(this);
       start.addActionListener(this);
       stop.addActionListener(this);
       exit.addActionListener(this);
       add(settings); add(start); add(stop); add(exit);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==settings) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new DynuClientWindow().setVisible(true);
                }
            });
            return;
        }
        if (e.getSource()==start) {
            JOptionPane.showMessageDialog(null,"START","MSG", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (e.getSource()==stop) {
            JOptionPane.showMessageDialog(null,"STOP","MSG", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (e.getSource()==exit) { System.exit(0); }
    }
}
