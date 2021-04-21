
package dynuclient.model;

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
    
    private static final String FILE_NAME = "dynu.dat";
    
    private String user, password, ttl;
    
    public String User(){return user;}
    public String Password(){return password;}
    public String TTL(){return ttl;}
    
    public Data(String user, String password, int ttl){
        this.user=user; this.password=password; this.ttl = String.valueOf(ttl);
    }
    
    public static final void save(Data data) throws IOException {
        File dataFile = new File(FILE_NAME);
        if(!dataFile.exists()){dataFile.createNewFile();}
        BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile));
        StringBuilder sData = new StringBuilder();
        sData.append(data.User()); sData.append(";");
        sData.append(data.Password()); sData.append(";");
        sData.append(data.TTL());
        writer.write(sData.toString());
        writer.flush();
        writer.close();
    }
    
    public static final Data Load(){
        File dataFile = new File(FILE_NAME);
        Data empty = new Data("","", 60);
        if(!dataFile.exists()){ return empty; }
        String user, password, ttl;
        String[] sData;
        try (
            BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
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
