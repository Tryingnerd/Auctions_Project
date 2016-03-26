package com.example.charlestrudel.auction_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewGeneral extends AppCompatActivity {

    ListView listItems;
    public final int n = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_general);

        listItems = (ListView)findViewById(R.id.listView_items);

    }

    public class MyAdapter extends BaseAdapter
    {
        LayoutInflater inflater;

        public MyAdapter(){
            inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return n;
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
                v = inflater.inflate(android.R.layout.activity_list_item, parent, false);
            }
            TextView itemName = (TextView)v.findViewById(android.R.id.text1);
            TextView HighBidAmount = (TextView)v.findViewById(android.R.id.text1);
            TextView AucEndDt = (TextView)v.findViewById(android.R.id.text1);

            return null;
        }
    }

}
