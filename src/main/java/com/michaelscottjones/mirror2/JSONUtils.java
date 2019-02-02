package com.michaelscottjones.mirror2;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.*;

public class JSONUtils {

    private static String weatherUrl = "https://api.openweathermap.org/data/2.5/weather?zip=14623,us&appid=f4c9b626b1e7c444ad4c9fc0790d105d";
    private static String busUrl = "https://transloc-api-1-2.p.mashape.com/arrival-estimates.json?agencies=643&callback=call&routes=4010124%2C4010132%2C4012156%2C4012166&stops=4224626";

    public static String[] getWeather() {
        try {
            JSONObject json = readJsonFromUrl(weatherUrl);
            String condition = json.getJSONArray("weather").getJSONObject(0).getString("main");
            Float temp = json.getJSONObject("main").getFloat("temp");
            String[] x = {condition, temp.toString()};
            return x;

        } catch(Exception e) {
            System.err.println("ERROR: Could not get weather");
            String[] err = {"Error", "0"};
            return err;
        }
    }

    public static String[] getBus() {
        HashMap<String, String> routes = new HashMap<>();
        routes.put("4010124", "Colony Manor/Province");
        routes.put("4010132", "Colony Manor");
        routes.put("4012156", "Eastside");
        routes.put("4012166", "Weekend Eastside");

        try {
            JSONObject json = readJsonFromPost(busUrl);
            if (json.getJSONArray("data").length() == 0) {
                String[] err = {":(", "No bus available"};
                return err;
            }
            JSONArray arrivals = json.getJSONArray("data").getJSONArray(0);
            Date earliest = null;
            for (int i=0; i<arrivals.length(); i++) {
                String arrival = arrivals.getJSONObject(i).getString("arrival_at");
                System.out.println(arrival);
            }

            String time = "1";
            String name = "bob";

            String[] x = {time, name};
            return x;

        } catch(Exception e) {
            System.err.println("ERROR: Could not get bus information");
            String[] err = {"?", "Error"};
            return err;
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return new JSONObject(jsonText);
        }
    }


    private static JSONObject readJsonFromPost(String url) throws IOException, JSONException {
        HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead

        HttpGet request = new HttpGet(url);
        request.addHeader("X-Mashape-Key", "nSHjbzblkZmshk0iKFkcjGumedghp1Cz3ICjsnSI9FFo8bIFpl");
        request.addHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(request);

        try (InputStream is = response.getEntity().getContent()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return new JSONObject(jsonText);
        }

    }

}
