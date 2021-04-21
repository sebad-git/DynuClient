
package dynuclient.model;

import dynuclient.util.UpdateThread;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author sebad-git
 */
public class Data {
    
    private static final File DATA_FILE = new File("dynu.dat");
    
    private String user, password, ttl;
    
    public String User(){ return user; }
    public String Password(){ return password; }
    public int TTL(){ try{ return Integer.parseInt(ttl);}catch(NumberFormatException e){return 120;} }
    
    public Data(String user, String password, int ttl){
        this.user=user; this.password=password; this.ttl = String.valueOf(ttl);
    }
    
    public static final void save(Data data) throws IOException {
        if(!DATA_FILE.exists()){DATA_FILE.createNewFile();}
        BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE));
        StringBuilder sData = new StringBuilder();
        sData.append(data.User()); sData.append(";");
        sData.append(data.Password()); sData.append(";");
        sData.append(data.TTL());
        writer.write(sData.toString());
        writer.flush();
        writer.close();
        if(!Data.isEmpty()){ UpdateThread.getInstance().Start(); }
    }
    
     public static final boolean isEmpty(){ 
         if(!DATA_FILE.exists()){return true;}
         Data data = Load();
         if(data.User()==null || data.User().length()<1){ return true; }
         if(data.Password()==null || data.Password().length()<1){ return true; }
         return false;
     }
    
    public static final Data Load(){
        Data empty = new Data("","", 120);
        if(!DATA_FILE.exists()){ return empty; }
        String user, password, ttl;
        String[] sData;
        try (
            BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line = reader.readLine();
            reader.close();
            if(line==null || line.length()<1){return empty; }
            sData = line.split(";");
            user = sData[0]; password = sData[1]; ttl = sData[2];
            return new Data(user, password, Integer.parseInt(ttl));
        } catch (Exception ex) { System.out.println(ex.getMessage()); }
        return empty;
    }
}
