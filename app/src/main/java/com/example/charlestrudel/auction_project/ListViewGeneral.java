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

    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_general);

        listItems = (ListView)findViewById(R.id.listView_items);

        adapter = new MyAdapter();
        listItems.setAdapter(adapter);
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
                v = inflater.inflate(R.layout.rangee, parent, false);
            }
            TextView itemName = (TextView)v.findViewById(R.id.textView_ItemName);
            TextView HighBidAmount = (TextView)v.findViewById(R.id.textView_highBid);
            TextView AucEndDt = (TextView)v.findViewById(R.id.textView_endDate);

            itemName.setText("Product: "+((Integer)position).toString());
            HighBidAmount.setText("Highest bid: "+((Integer)position).toString());
            AucEndDt.setText("End Date: "+((Integer)position).toString());
            return null;
        }
    }

}
