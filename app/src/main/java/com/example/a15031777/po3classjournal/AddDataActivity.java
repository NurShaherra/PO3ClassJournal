package com.example.a15031777.po3classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AddDataActivity extends AppCompatActivity {
    TextView tvWeek;
    Button btnSubmit;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        Intent i = getIntent();
        final int weekNum = i.getIntExtra("weekNum", 1);

        getSupportActionBar().setTitle("Add Data for Week ");

        rg = (RadioGroup) findViewById(R.id.radioGroup);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        tvWeek = (TextView) findViewById(R.id.tvWeeks);

        tvWeek.setText("Week" + weekNum);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedButtonId = rg.getCheckedRadioButtonId();



                if (selectedButtonId == R.id.radioButton) {
                    Intent i = new Intent();
                    i.putExtra("grade", "A");
                    // Set result to RESULT_OK to indicate normal			// response and pass in the intent containing the 		// like
                    setResult(RESULT_OK, i);
                } else if (selectedButtonId == R.id.radioButton2) {
                    Intent i = new Intent();
                    i.putExtra("grade", "B");
                    // Set result to RESULT_OK to indicate normal			// response and pass in the intent containing the 		// like
                    setResult(RESULT_OK, i);

                } else if (selectedButtonId == R.id.radioButton3) {
                    Intent i = new Intent();
                    i.putExtra("grade", "C");
                    // Set result to RESULT_OK to indicate normal			// response and pass in the intent containing the 		// like
                    setResult(RESULT_OK, i);

                } else if (selectedButtonId == R.id.radioButton4) {
                    Intent i = new Intent();
                    i.putExtra("grade", "D");
                    // Set result to RESULT_OK to indicate normal			// response and pass in the intent containing the 		// like
                    setResult(RESULT_OK, i);

                } else if (selectedButtonId == R.id.radioButton5) {
                    Intent i = new Intent();
                    i.putExtra("grade", "F");
                    // Set result to RESULT_OK to indicate normal			// response and pass in the intent containing the 		// like
                    setResult(RESULT_OK, i);

                } else if (selectedButtonId == R.id.radioButton6) {
                    Intent i = new Intent();
                    i.putExtra("grade", "X");
                    // Set result to RESULT_OK to indicate normal			// response and pass in the intent containing the 		// like
                    setResult(RESULT_OK, i);
                }

                finish();
            }
        });

    }
}
