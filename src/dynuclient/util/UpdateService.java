
package dynuclient.util;

import dynuclient.model.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author sebad-git
 */
public class UpdateService extends Thread {
    
    private HttpClient client;
    private boolean running;
    
    private static UpdateService instance;
    
    public static UpdateService getInstance(){
        if(instance==null){instance=new UpdateService(); } return instance;
    }
    
    public void Start(){
        if(Data.isEmpty()){ this.running=false; return; }
        if(this.running){ return; }
        this.running=true;
         this.client = new HttpClient();
        this.start();
        AppLogger.log("PROCESS STARTED.");
        System.out.println("PROCESS STARTED.");
    }
    
    public boolean isRunning(){return this.running; }
    
    public void run(){
        while(this.running){
            if(Data.isEmpty()){ return; }
            System.out.println("Calling api.");
            AppLogger.log("Calling api.");
            Data data = Data.Load();
            String response=this.client.CallApi(data.User(),data.Password());
            System.out.println(response);
            AppLogger.log(response);
            String nextCallTime = String.format("%s minutes",data.TTL());
            if(data.TTL()>=60){ nextCallTime = String.format("%s hour(s)",data.TTL()/60); }
            if(data.TTL()>=1440){ nextCallTime = String.format("%s day(s)",data.TTL()/60/24); }
            if(data.TTL()>=10080){ nextCallTime = String.format("%s week(s)",data.TTL()/60/24/7); }
            String nextCall = String.format("Next call in %s.",nextCallTime);
            System.out.println(nextCall);
            AppLogger.log(nextCall);
            try {Thread.sleep(data.TTL()*60*1000); } catch (InterruptedException ex) {}
        }
    }
    
    public void Stop(){ 
        this.running=false; instance=null;
        System.out.println("PROCESS STOPPED.");
        AppLogger.log("PROCESS STOPPED.");
    }
    
}
