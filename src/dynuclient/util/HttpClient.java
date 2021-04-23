
package dynuclient.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

/**
 *
 * @author sebad-git
 */
public class HttpClient {
    
    private static final int TIMEOUT = 3 *1000;
    private static final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.106 Safari/537.36 OPR/38.0.2220.41";
    
    private static final String IPV_4_API = "http://checkip.amazonaws.com";
    //private static final String IPV_6_API = "http://www.trackip.net/ip";
    private static final String IPV_6_API = "http://bot.whatismyipaddress.com";
    
    private static final int DYNU_TIMEOUT = 10 *1000;
    //private static final String DYNU_API = "http://api.dynu.com/nic/update?username=%s&password=%s&myip=%s";
    private static final String DYNU_API = "http://api.dynu.com/nic/update?username=%s&password=%s";
    
    public String CallApi(String user, String password){
        try{
            String ipv4=getIPV4(); String ipv6=getIPV6(ipv4);
            //String apiUrl =String.format(DYNU_API,user,ipv4,ipv6,password);
            String apiUrl =String.format(DYNU_API,user,password);
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setConnectTimeout(DYNU_TIMEOUT); con.setReadTimeout(DYNU_TIMEOUT);
             if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String response = in.readLine(); in.close();
                con.disconnect();
                return response;
            }
            return "IP NOT Updated";
        }catch(Exception e){ return String.format("Connection Failed (%s).", e.getMessage()); }
    }
    
    public String getIPV4(){
         try{
            URL url = new URL(IPV_4_API);
            System.out.println(String.format("Connecting to: %s", IPV_4_API));
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setConnectTimeout(TIMEOUT); con.setReadTimeout(TIMEOUT);
            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String ipv4 = in.readLine(); in.close(); return ipv4;
            }
            return null;
        }catch(Exception e){ return null; }
    }
    
    private String getIPV6(String ipv4){
         try{ return String.format("::%s", ipv4);
        }catch(Exception e){ return null; }
    }
}
