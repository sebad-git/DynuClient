
package com.sdm.dynuclient.util;

import com.sdm.dynuclient.view.App;
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
    
    private static final int DAYS_TO_KEEP_LOGS=2; 
    
    public  static final File getLogFile() throws IOException{
        final String fileName = String.format( "logs/%s.log",new SimpleDateFormat("dd-MM-yyyy").format(new Date()) );
        File logFile = new File(fileName);
        if(!logFile.getParentFile().exists()){ logFile.getParentFile().mkdirs(); }
        if(!logFile.exists()){ logFile.createNewFile(); }
        return logFile;
    }
    
     public static final void log(final String data) {
      try{
        final File logFile = getLogFile();
        final BufferedWriter writer = new BufferedWriter(new FileWriter(logFile,true));
        final String logDate = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date());
        writer.append(String.format("[%s]: %s",logDate,data) );
        writer.newLine();
        writer.close();
      }
      catch(Exception e){ e.printStackTrace(); }
    }
     
     public static final void log(Exception e) {
      try{
        final File logFile = getLogFile();
        final BufferedWriter writer = new BufferedWriter(new FileWriter(logFile,true));
        final StringBuilder logTrace = new StringBuilder();
        final StackTraceElement[] stacktrace = e.getStackTrace();
        for (int i = 0; i < stacktrace.length; i++) {
            logTrace.append(stacktrace[i].toString());
            logTrace.append(App.NEW_LINE);
        }
        final String logDate = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date());
        writer.append(String.format("[%s]: %s",logDate,logTrace.toString()) );
        writer.newLine();
        writer.close();
      }
      catch(Exception le){ le.printStackTrace(); }
    }
     
    public static final void clearLogs(){
       try {
           final File logsDir = new File("logs");
           File[] logFiles = logsDir.listFiles();
           final Date currentDate = new Date();
           final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
           for (File logFile : logFiles) {
               final Date lastModified = dateFormat.parse(dateFormat.format(logFile.lastModified()));
               final long dayDiff = (currentDate.getTime() - lastModified.getTime()) / (1000 * 60 * 60 * 24);
               if(dayDiff>=DAYS_TO_KEEP_LOGS){ logFile.delete(); }
           }
        } catch (Exception e) { e.printStackTrace(); }
    }
}
