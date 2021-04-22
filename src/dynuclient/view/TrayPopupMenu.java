
package dynuclient.view;

import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author sebad-git
 */
public class TrayPopupMenu extends PopupMenu implements ActionListener {
    
    private final MenuItem settings = new MenuItem("Settings");
    private final MenuItem monitor = new MenuItem("Process Monitor");
    private final MenuItem exit = new MenuItem("Exit");
    
    public TrayPopupMenu(){ init(); }
    
    private void init(){
       settings.addActionListener(this);
       monitor.addActionListener(this);
       exit.addActionListener(this);
       add(settings); add(monitor); add(exit);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==settings) { App.ShowSettings(); return; }
        if (e.getSource()==monitor) { App.ShowMonitor();return; }
        if (e.getSource()==exit) { App.exit(); }
    }
}
