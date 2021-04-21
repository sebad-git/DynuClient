/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynuclient.view;

import dynuclient.util.UpdateThread;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author sebad-git
 */
public class TrayPopupMenu extends PopupMenu implements ActionListener{
    
    private final MenuItem settings = new MenuItem("Settings");
    private final MenuItem exit = new MenuItem("Exit");
    
    public TrayPopupMenu(){
       settings.addActionListener(this);
       exit.addActionListener(this);
       add(settings); add(exit);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==settings) {
           DynuClientWindow.getInstance().setVisible(true);
           return;
        }
        if (e.getSource()==exit) { 
            UpdateThread.getInstance().Stop();
            System.exit(0);
        }
    }
}
