
package dynuclient.util;

import dynuclient.model.Data;

/**
 *
 * @author sebad-git
 */
public class UpdateThread extends Thread {
    
    private HttpClient client;
    private boolean running;
    
    private static UpdateThread instance;
    
    public static UpdateThread getInstance(){
        if(instance==null){instance=new UpdateThread(); } return instance;
    }
    
    public void Start(){
        if(Data.isEmpty()){ this.running=false; return; }
        if(this.running){ return; }
        this.running=true;
         this.client = new HttpClient();
        this.start();
        System.out.println("PROCESS STARTED.");
    }
    
    public boolean isRunning(){return this.running; }
    
    public void run(){
        while(this.running){
            if(Data.isEmpty()){ return; }
            System.out.println("Calling api.");
            Data data = Data.Load();
            String response=this.client.CallApi(data.User(),data.Password());
             System.out.println(response);
            try {Thread.sleep(data.TTL()*1000); } catch (InterruptedException ex) {}
        }
    }
    
    public void Stop(){ this.running=false; instance=null; System.out.println("PROCESS STOPPED."); }
    
}
