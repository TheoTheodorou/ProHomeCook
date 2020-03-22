package com.example.phc.services;

import com.example.phc.models.Recipe;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpRequest {
    //Fill Recipe Model with data from API

    public URL url;
    public static String SERVER_BASE_URL = "https://api.spoonacular.com/recipes/";

    public static Recipe getRecipeInformation(String recipeId) throws IOException {
        String jsonResponse = fetchResponse(recipeId + "/information?apiKey=152f4847a7f04a93a7d76d6066c8df7a");
        Gson gson = new Gson();
        Recipe recipe = gson.fromJson(jsonResponse, Recipe.class);
        return recipe;
    }

    public static String fetchResponse(String reqPath) throws IOException {
        URL url = new URL(SERVER_BASE_URL + reqPath);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoInput(true);

        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line;

        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        con.disconnect();
        return sb.toString();
    }

}
