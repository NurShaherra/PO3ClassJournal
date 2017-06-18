package com.example.a15031777.po3classjournal;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {
    Button btnAdd, btnInfo, btnEmail;
    ListView lvMod;
    ArrayAdapter aa;
    ArrayList<Weeks> weeks;
    int requestCodeForAddData = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent i = getIntent();
        String moduleName = i.getStringExtra("module");

        lvMod = (ListView) findViewById(R.id.lvMod);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnInfo = (Button) findViewById(R.id.btnInfo);
        btnEmail = (Button) findViewById(R.id.btnEmail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark)));

        getSupportActionBar().setTitle(moduleName);

        weeks = new ArrayList<Weeks>();
        if(moduleName.equalsIgnoreCase("C347")) {
            weeks.add(new Weeks("Week 1", "A"));
            weeks.add(new Weeks("Week 2", "C"));

        } else {
            weeks.add(new Weeks("Week 1", "B"));
        }

        aa = new WeeksAdapter(this, R.layout.row, weeks);
        lvMod.setAdapter(aa);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InfoActivity.this, AddDataActivity.class);
                //get the size of arraylist and pass to next activity
                i.putExtra("weekNum", (weeks.size()+1));
                startActivityForResult(i, requestCodeForAddData);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Only handle when 2nd activity closed normally
        //  and data contains something
        if (resultCode == RESULT_OK) {
            if (data != null) {
                // Get data passed back from 2nd activity
                String grade = data.getStringExtra("grade");
                if (requestCode == requestCodeForAddData) {
                    weeks.add(new Weeks("Week " + (weeks.size()+1), grade));
                    aa = new WeeksAdapter(this,R.layout.row,weeks);
                    lvMod.setAdapter(aa);
                }

            }
        }


    }
}
