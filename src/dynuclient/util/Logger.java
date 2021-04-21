
package dynuclient.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author sebad-git
 */
public class Logger {
    
     public static final void log(String data) {
      try{
        String fileName = String.format( "logs/%s.log",new SimpleDateFormat("dd-MM-yyyy").format(new Date()) );
        File logFile = new File(fileName);
        if(!logFile.getParentFile().exists()){ logFile.getParentFile().mkdirs(); }
        if(!logFile.exists()){logFile.createNewFile(); }
        BufferedWriter writer = new BufferedWriter(new FileWriter(logFile,true));
        writer.append(String.format("[%s]: %s",new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()),data) );
        writer.newLine();
        writer.close();
      }
      catch(Exception e){ e.printStackTrace(); }
    }
}
