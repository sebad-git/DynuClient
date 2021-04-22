
package dynuclient.util;

import dynuclient.model.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        Logger.log("PROCESS STARTED.");
        System.out.println("PROCESS STARTED.");
    }
    
    public boolean isRunning(){return this.running; }
    
    public void run(){
        while(this.running){
            if(Data.isEmpty()){ return; }
            System.out.println("Calling api.");
            Logger.log("Calling api.");
            Data data = Data.Load();
            String response=this.client.CallApi(data.User(),data.Password());
            System.out.println(response);
            Logger.log(response);
            String nextCallTime = new SimpleDateFormat("hh:mm").format(new Date(data.TTL()*60*1000));
            String nextCall = String.format("Next call in %s hours/minutes.",nextCallTime);
            System.out.println(nextCall);
            Logger.log(nextCall);
            try {Thread.sleep(data.TTL()*60*1000); } catch (InterruptedException ex) {}
        }
    }
    
    public void Stop(){ 
        this.running=false; instance=null;
        System.out.println("PROCESS STOPPED.");
        Logger.log("PROCESS STOPPED.");
    }
    
}
