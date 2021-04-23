
package com.sdm.dynuclient.model;

import com.sdm.dynuclient.service.UpdateService;
import com.sdm.dynuclient.util.AppLogger;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.sdm.dynuclient.util.Security;
import com.sdm.dynuclient.view.App;

/**
 *
 * @author sebad-git
 */
public class Data {
    
    private static final File DATA_FILE = new File("dynu.dat");
    
    private String user, password, ttl;
    
    public final String User(){ return user; }
    public final String Password(){ return password; }
    public final int TTL(){ try{ return Integer.parseInt(ttl);}catch(NumberFormatException e){return 120;} }
    
    private static final String ENC_PASS = String.format("%s.@Sdm#App$$", App.NAME);
    
    public Data(final String user, final String password, final int ttl){
        this.user=user; this.password=password; this.ttl = String.valueOf(ttl);
    }
    
    public static final void save(final Data data) throws IOException {
        if(!DATA_FILE.exists()){DATA_FILE.createNewFile();}
        final BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE));
        final StringBuilder sData = new StringBuilder();
        sData.append(Security.encriptAES(ENC_PASS,data.User())); sData.append(";");
        sData.append(Security.encriptAES(ENC_PASS,data.Password())); sData.append(";");
        sData.append(data.TTL());
        writer.write(sData.toString());
        writer.flush();
        writer.close();
        if(!Data.isEmpty()){ UpdateService.getInstance().Start(); }
    }
    
     public static final boolean isEmpty(){ 
         if(!DATA_FILE.exists()){ return true; }
         final Data data = Load();
         if(data.User()==null || data.User().length()<1){ return true; }
         if(data.Password()==null || data.Password().length()<1){ return true; }
         return false;
     }
    
    public static final Data Load(){
        final Data empty = new Data("","", 5);
        if(!DATA_FILE.exists()){ return empty; }
        String user, password, ttl;
        final String[] sData;
        try (
            final BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            final String fileData = reader.readLine();
            reader.close();
            if(fileData==null || fileData.length()<1){return empty; }
            sData = fileData.split(";");
            user = Security.deciptAES(ENC_PASS,sData[0]);
            password = Security.deciptAES(ENC_PASS,sData[1]);
            ttl = sData[2];
            return new Data(user, password, Integer.parseInt(ttl));
        } catch (Exception ex) { AppLogger.log(ex); System.out.println(ex.getMessage()); }
        return empty;
    }
}
