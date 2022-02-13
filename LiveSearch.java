package com.example.lore;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LiveSearch extends AppCompatActivity {
    ListView lv;
    ArrayAdapter adapter;
    ArrayList<String>list1;
    ArrayList<String>list2;
    SearchView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livesearch);
        lv=(ListView) findViewById(R.id.list);
        sv=(SearchView)findViewById(R.id.search);
        list1=new ArrayList<String>();
        list1.add("MEDICINE 1");
        list1.add("AVAILABLE");
        list1.add("Shop 1,Addr 2");

        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list1);

        lv.setAdapter(adapter);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


    }



}
