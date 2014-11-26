package packages.weather.mvc.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Mihai on 11/23/2014.
 */
public class WeatherSync {


       private static String URL_ADDRESS = "http://api.openweathermap.org/data/2.5/weather?lat=44&lon=26";

        /*
           Returns the Weather information in JSON format
         */
        public String getWeatherData() {
            HttpURLConnection myConn = null ;
            InputStream myIS = null;

            try {
                myConn = (HttpURLConnection) ( new URL(URL_ADDRESS)).openConnection();
                myConn.setRequestMethod("GET");
                myConn.setDoInput(true);
                myConn.setDoOutput(true);
                myConn.connect();


                StringBuffer buffer = new StringBuffer();
                myIS = myConn.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(myIS));
                String line = null;
                while (  (line = br.readLine()) != null )
                    buffer.append(line + "\r\n");

                myIS.close();
                myConn.disconnect();
                return buffer.toString();
            }
            catch(Throwable t) {
                t.printStackTrace();
            }
            finally {
                try { myIS.close(); } catch(Throwable t) {}
                try { myConn.disconnect(); } catch(Throwable t) {}
            }

            return null;

        }
    }

