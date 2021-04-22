
package dynuclient.util;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author sebad-git
 */
public class HttpClient {
    
    private static final int TIMEOUT = 10 *1000;
    private static final String API_URL_FORMAT = "https://api.dynu.com/nic/update?username=%s&password=%s";
    
    public String CallApi(String user, String password){
        try{
            String apiUrl =String.format(API_URL_FORMAT,user,password);
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "text/html; charset=utf-8");
            con.setConnectTimeout(TIMEOUT); con.setReadTimeout(TIMEOUT);
            int responseCode = con.getResponseCode();
            StringBuilder response = new StringBuilder();
            response.append(String.format("Response Code:%s ", responseCode));
            if (responseCode == HttpURLConnection.HTTP_OK) { response.append("IP Updated"); }
            else{ response.append("IP NOT Updated"); }
            return response.toString();
        }catch(Exception e){
            return String.format("Connection Failed (%s).", e.getMessage());
        }
    }
}
