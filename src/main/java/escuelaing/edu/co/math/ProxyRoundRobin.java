package escuelaing.edu.co.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ProxyRoundRobin {

    private static final String USER_AGENT = "Mozilla/5.0";
    private List<String> servers;
    private int currentIndex = 0;

    public ProxyRoundRobin() {
        servers = List.of(
            "http://localhost:8080"
        );
    }

    public String sendRequest(String path) throws IOException {
        String serverUrl = servers.get(currentIndex);
        currentIndex = (currentIndex + 1) % servers.size();
        URL obj = new URL(serverUrl + path);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } else {
            System.out.println("POST request not worked");
            throw new IOException("HTTP error code: " + responseCode);
        }
    }
}
