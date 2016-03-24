package com.example.charlestrudel.auction_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //api-key gsa auctions gg8oDHc7bYECD65aAmIDoDRfaSw09kA9YYkov6Wu
    //https://api.data.gov/gsa/auctions?api_key=gg8oDHc7bYECD65aAmIDoDRfaSw09kA9YYkov6Wu&format=JSON
    //That is giving us the JSON, now, with moshi, picasso etc, we should be able to do whatever we want.
}
