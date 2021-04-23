
package com.sdm.dynuclient.service;

import com.sdm.dynuclient.model.Data;
import com.sdm.dynuclient.util.AppLogger;
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
    
    public final void Start(){
        if(Data.isEmpty()){ this.running=false; return; }
        if(this.running){ return; }
        this.running=true;
        this.client = new HttpClient();
        AppLogger.log("PROCESS STARTED.");
        System.out.println("PROCESS STARTED.");
        this.start();
    }
    
    public final boolean isRunning(){return this.running; }
    
    public void run(){
        while(this.running){
            if(Data.isEmpty()){ AppLogger.log("User data not Found"); return; }
            System.out.println("Calling api.");
            AppLogger.log("Calling api.");
            final Data data = Data.Load();
            final String response=this.client.updateIP(data.User(),data.Password());
            System.out.println(response);
            AppLogger.log(response);
            String nextCallTime = String.format("%s seconds",data.TTL());
            if(data.TTL()>=60){ nextCallTime = String.format("%s minutes(s)",data.TTL()/60f); }
            String nextCall = String.format("Next call in %s.",nextCallTime);
            System.out.println(nextCall);
            AppLogger.log(nextCall);
            try {Thread.sleep(data.TTL()*1000); } catch (InterruptedException ex) {}
            AppLogger.clearLogs();
        }
    }
    
    public final void Stop(){ 
        this.running=false; instance=null;
        System.out.println("PROCESS STOPPED.");
        AppLogger.log("PROCESS STOPPED.");
    }
    
}
