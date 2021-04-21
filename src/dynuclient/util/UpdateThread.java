
package dynuclient.util;

import dynuclient.model.Data;

/**
 *
 * @author sebad-git
 */
public class UpdateThread extends Thread {
    
    private HttpClient client;
    private boolean running;
    private Data userData;
    
    private static UpdateThread instance;
    
    public static UpdateThread getInstance(){
        if(instance==null){instance=new UpdateThread(); } return instance;
    }
    
    public void Start(){
        if(Data.isEmpty()){ this.running=false; return; }
        if(this.running){ return; }
        this.running=true;
        this.start();
        System.out.println("PROCESS STARTED.");
    }
    
    public boolean isRunning(){return this.running; }
    
    public void run(){
        while(this.running){
            if(Data.isEmpty()){ return; }
            this.userData = Data.Load();
            this.client = new HttpClient(userData.User(), userData.Password());
            System.out.println("Calling api.");
            String response=this.client.CallApi();
             System.out.println(response);
            try {Thread.sleep(userData.TTL()*1000); } catch (InterruptedException ex) {}
        }
    }
    
    public void Stop(){ this.running=false; System.out.println("PROCESS STOPPED."); }
    
}
