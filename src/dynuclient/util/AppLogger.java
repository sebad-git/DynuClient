
package dynuclient.util;

import dynuclient.view.App;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author sebad-git
 */
public class AppLogger {
    
    public static File getLogFile() throws IOException{
        String fileName = String.format( "logs/%s.log",new SimpleDateFormat("dd-MM-yyyy").format(new Date()) );
        File logFile = new File(fileName);
        if(!logFile.getParentFile().exists()){ logFile.getParentFile().mkdirs(); }
        if(!logFile.exists()){ logFile.createNewFile(); }
        return logFile;
    }
    
     public static final void log(String data) {
      try{
        File logFile = getLogFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(logFile,true));
        String logDate = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date());
        writer.append(String.format("[%s]: %s",logDate,data) );
        writer.newLine();
        writer.close();
      }
      catch(Exception e){ e.printStackTrace(); }
    }
     
     public static final void log(Exception e) {
      try{
        File logFile = getLogFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(logFile,true));
        StringBuilder logTrace = new StringBuilder();
        StackTraceElement[] stacktrace = e.getStackTrace();
        for (int i = 0; i < stacktrace.length; i++) {
            logTrace.append(stacktrace[i].toString());
            logTrace.append(App.NEW_LINE);
        }
        String logDate = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date());
        writer.append(String.format("[%s]: %s",logDate,logTrace.toString()) );
        writer.newLine();
        writer.close();
      }
      catch(Exception le){ le.printStackTrace(); }
    }
}
