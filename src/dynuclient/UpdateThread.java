/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynuclient;

/**
 *
 * @author deneg
 */
public class UpdateThread extends Thread {
    
    private int ttl;
    private HttpClient client;
    private javax.swing.JTextArea txtLog;
    private boolean running;
    private final StringBuilder buffer = new StringBuilder();
    
    public UpdateThread(Data userData,javax.swing.JTextArea txtLog){ 
        this.ttl=Integer.parseInt(userData.TTL());
        this.client = new HttpClient(userData.User(), userData.Password());
        this.txtLog = txtLog;
    }
    public void Start(){
        this.running=true;
        this.start();
        System.out.println("PROCESS STARTED.");
    }
    
    public boolean isRunning(){return this.running; }
    
    public void run(){
        if(!this.running){ System.out.println("PROCESS STOPPED."); }
        while(this.running){
            String response=this.client.CallApi();
             System.out.println(response);
             buffer.append(response); buffer.append("\n");
             this.txtLog.setText(this.buffer.toString());
            try {Thread.sleep(ttl*1000); } catch (InterruptedException ex) {}
        }
    }
    
    public void Stop(){ this.running=false; }
    
}
