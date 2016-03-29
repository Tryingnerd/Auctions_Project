package com.example.charlestrudel.auction_project;


import com.example.charlestrudel.auction_project.GSAAuctions.Results;
import com.example.charlestrudel.auction_project.GSAAuctions.Root;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.util.List;

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

    public List<Results> run() throws IOException{
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        String json = response.body().string();

        //Parser le contenu de la demande
        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<Root> jsonAdapter = moshi.adapter(Root.class);
        Root root = jsonAdapter.fromJson(json);

        //Ajouter ici les conditions pour afficher les résultats voulu seulement.
        //On doit ajouter une variable qui est paramètre et qui sera passé depuis une autre page
        //nos conditions dépendront de cette variable. voir tutoriel listview avancé
        //Va falloir ne pas afficher l'objet d'une position donnée qu'on ne veut pas.
        List<Results> genericResults;

        genericResults = root.results;


        return genericResults;

    }
}
