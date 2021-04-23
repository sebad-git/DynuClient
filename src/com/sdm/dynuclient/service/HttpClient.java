
package com.sdm.dynuclient.service;
import com.sdm.dynuclient.util.AppLogger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 *
 * @author sebad-git
 */
public class HttpClient {
    
    private static final int TIMEOUT = 3 *1000;
    private static final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.106 Safari/537.36 OPR/38.0.2220.41";
    
    private static final String IPV_4_API = "http://checkip.amazonaws.com";
    private static final String IPV_6_API = "http://bot.whatismyipaddress.com";
    
    private static final int DYNU_TIMEOUT = 15 *1000;
    private static final String DYNU_API = "http://api.dynu.com/nic/update?username=%s&password=%s";
    
    public final String updateIP(final String user, final String password){
        try{
            String password256 = Encript(password);
            password256 = password256!=null? password256 : password;
            final String apiUrl =String.format(DYNU_API,user,password256);
            final URL url = new URL(apiUrl);
            final HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setConnectTimeout(DYNU_TIMEOUT); con.setReadTimeout(DYNU_TIMEOUT);
            final int responseCode = con.getResponseCode();
             if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                final String response = in.readLine(); in.close();
                if(response.equals("nochg")){return "IP did not change."; }
                if(response.equals("badauth")){return "User or password incorrect."; }
                return response;
            }
            return String.format("Api error: Response code:%s", responseCode);
        }catch(Exception e){ return String.format("Connection Failed (%s).", e.getMessage()); }
    }
    
    public final String getIPV4(){
         try{
            final URL url = new URL(IPV_4_API);
            System.out.println(String.format("Connecting to: %s", IPV_4_API));
            final HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setConnectTimeout(TIMEOUT); con.setReadTimeout(TIMEOUT);
            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                final String ipv4 = in.readLine(); in.close(); return ipv4;
            }
            return null;
        }catch(Exception e){ return null; }
    }
    
     private final String Encript(final String text){
         try {
             final MessageDigest digest = MessageDigest.getInstance("SHA-256");
             final byte[] hash = digest.digest( text.getBytes(StandardCharsets.UTF_8));
             final StringBuilder hexString = new StringBuilder(2 * hash.length);
             for (int i = 0; i < hash.length; i++) {
                 String hex = Integer.toHexString(0xff & hash[i]);
                 if(hex.length() == 1) { hexString.append('0'); }
                 hexString.append(hex);
             }
             return hexString.toString();
        }
        catch (Exception e) { AppLogger.log(e); e.getMessage(); return null; }
    }
}
