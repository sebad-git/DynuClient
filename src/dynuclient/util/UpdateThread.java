
package dynuclient.util;

import dynuclient.events.EventManager;
import dynuclient.events.IDataListener;
import dynuclient.model.Data;

/**
 *
 * @author sebad-git
 */
public class UpdateThread extends Thread implements IDataListener {
    
    private int ttl;
    private HttpClient client;
    private boolean running;
    
    private static UpdateThread instance;
    
    public static UpdateThread getInstance(){
        if(instance==null){instance=new UpdateThread(); } return instance;
    }
    
    private UpdateThread() { EventManager.subscribe(this); }
    
    public void Start(){
        if(Data.isEmpty()){ this.running=false; return; }
        if(this.running){ return; }
        this.running=true;
        Data userData = Data.Load();
        this.ttl=Integer.parseInt(userData.TTL());
        this.client = new HttpClient(userData.User(), userData.Password());
        this.start();
        System.out.println("PROCESS STARTED.");
    }
    
    public boolean isRunning(){return this.running; }
    
    public void run(){
        while(this.running){
            System.out.println("Calling api.");
            String response=this.client.CallApi();
             System.out.println(response);
            try {Thread.sleep(ttl*1000); } catch (InterruptedException ex) {}
        }
    }
    
    public void Stop(){ this.running=false; System.out.println("PROCESS STOPPED."); }

    @Override
    public void onDataUpdated() {
       Data userData = Data.Load();
       this.ttl = Integer.parseInt(userData.TTL());
       this.client = new HttpClient(userData.User(), userData.Password());
       System.out.println("Data Updated");
    }
    
}
