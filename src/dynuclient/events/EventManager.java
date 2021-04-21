
package dynuclient.events;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebad-git
 */
public class EventManager {
    private static final List<IDataListener> dataListeners = new ArrayList<IDataListener>();
    
    public static void subscribe(IDataListener dataListener){
        if(dataListeners.contains(dataListener)){ return; }
        dataListeners.add(dataListener);
    }
    
    public static void unSubscribe(IDataListener dataListener){
        if(!dataListeners.contains(dataListener)){ return; }
        dataListeners.remove(dataListener);
    }
    
    public static void notifyListeners(){
        if(!dataListeners.isEmpty()){return;}
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                for (IDataListener dataListener : dataListeners) { dataListener.onDataUpdated(); }
            }
        });
    }
    
}
