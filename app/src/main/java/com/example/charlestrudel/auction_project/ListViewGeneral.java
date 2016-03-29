package com.example.charlestrudel.auction_project;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.charlestrudel.auction_project.GSAAuctions.Results;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

public class ListViewGeneral extends AppCompatActivity {

    ListView listItems;
    public final int n = 30;
    List<Results> myresults;

    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_general);

        listItems = (ListView)findViewById(R.id.listView_items);

        RunAPI run = new RunAPI();
        run.execute();
    }

    public class RunAPI extends AsyncTask<String, Object, List<Results>>{

        @Override
        protected List<Results> doInBackground(String... params) {
            WebAPI web = new WebAPI();
            try{
                myresults = web.run();
            }catch(IOException e){}
            return myresults;
        }

        @Override
        protected void onPostExecute(List<Results> results) {
            super.onPostExecute(results);

            adapter = new MyAdapter();
            listItems.setAdapter(adapter);
        }
    }

    public class MyAdapter extends BaseAdapter
    {
        LayoutInflater inflater;

        public MyAdapter(){
            inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {

            return myresults.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if(v == null)
            {
                v = inflater.inflate(R.layout.rangee, parent, false);
            }
            TextView itemName = (TextView)v.findViewById(R.id.rangee_ItemName);
            TextView HighBidAmount = (TextView)v.findViewById(R.id.rangee_highBid);
            TextView AucEndDt = (TextView)v.findViewById(R.id.rangee_endDate);
            ImageView ObjIma = (ImageView)v.findViewById(R.id.rangee_ima);


            String itemname = myresults.get(position).ItemName;
            float highbidamount = myresults.get(position).HighBidAmount;
            String aucenddate = myresults.get(position).AucEndDt;
            String url = myresults.get(position).ImageURL;


            //itemName.setText("Product: "+((Integer)position).toString());
            itemName.setText("Product: "+itemname);
            HighBidAmount.setText("Highest bid: "+highbidamount);
            AucEndDt.setText("End Date: "+((Integer)position).toString());

            Picasso.with(getApplicationContext()).load(url).into(ObjIma);
            return v;
        }
    }

}
