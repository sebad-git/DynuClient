
package dynuclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author deneg
 */
public class HttpClient {
    
    private static final int TIMEOUT = 10 *1000;
    private static final String API_URL_FORMAT = "https://api.dynu.com/nic/update?username=%s&password=%s";
    
    private String user, password, apiUrl;
    
    public HttpClient(String user, String password){
        this.user=user; this.password=password;
        apiUrl=String.format(API_URL_FORMAT, this.user,this.password);
    }
    public String CallApi(){
        try{
            URL url = new URL(apiUrl);
            System.out.println("Connecting to:"+ apiUrl);
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
            return String.format("Coonection Failed (%s).", e.getMessage());
        }
    }
}
