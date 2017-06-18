package com.example.a15031777.po3classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> al;
    ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvModule = (ListView) findViewById(R.id.lvModule);
        al = new ArrayList<String>();
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, al);
        al.add("C347");
        al.add("C349");

        lvModule.setAdapter(aa);
        aa.notifyDataSetChanged();

        lvModule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String module = al.get(position).toString();
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra("module", module);
                startActivity(intent);
            }
        });

    }
}
