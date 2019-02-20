package com.example.myapplication;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {



    String[] films;
    ArrayList<String> films_list = new ArrayList<>();
    ListView lv;
    ArrayAdapter adapter;
    EditText tv;
    TextView Tev=(TextView)findViewById(R.id.Tev);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.films);
        Tev.setText(lv.getAdapter().getCount());
        Resources res = getResources();
        films = res.getStringArray(R.array.films);
        films_list.addAll(Arrays.asList(films));
        adapter = new ArrayAdapter(getApplicationContext(), R.layout.item, films_list);
        lv.setAdapter(adapter);
        lv.getAdapter().getCount();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                films_list.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void onClick(View v) {
        tv=(EditText)findViewById(R.id.editText);
        films_list.add(tv.getText().toString());
        adapter.notifyDataSetChanged();

    }

    public void onClick1(View view) {
       adapter.clear();
        adapter.notifyDataSetChanged();

    }

}
