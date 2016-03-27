package com.example.charlestrudel.auction_project;


import com.example.charlestrudel.auction_project.GSAAuctions.Results;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Charles Trudel on 2016-03-27.
 */
public class WebAPI {
    public String url;

    public WebAPI(){
        url = "https://api.data.gov/gsa/auctions?api_key=gg8oDHc7bYECD65aAmIDoDRfaSw09kA9YYkov6Wu&format=JSON";
    }

    public void run() throws IOException{
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        String json = response.body().string();

        //Parser le contenu de la demande
        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<Results> jsonAdapter = moshi.adapter(Results.class);
        Results results = jsonAdapter.fromJson(json);

        //Rendu 20e minute du tutoriel
    }
}
