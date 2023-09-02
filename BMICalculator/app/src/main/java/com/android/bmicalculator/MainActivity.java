package com.android.bmicalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edit_wt, edit_ht_ft, edit_ht_in;
    Button btn_BMI;
    TextView text_result;
    ImageView image;

    @SuppressLint({"MissingInflatedId", "ResourceAsColor", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edit_wt = findViewById(R.id.edt_Wt);
        edit_ht_ft = findViewById(R.id.ht_feet);
        edit_ht_in = findViewById(R.id.ht_inch);
        btn_BMI = findViewById(R.id.btn);
        text_result = findViewById(R.id.result_text);
        image = findViewById(R.id.person_image);

        btn_BMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (edit_wt.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter Weight", Toast.LENGTH_SHORT).show();
                } else if (edit_ht_ft.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter Height`s feet", Toast.LENGTH_SHORT).show();
                } else if (edit_ht_in.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter Height`s inches", Toast.LENGTH_SHORT).show();
                } else{

                    int wt = Integer.parseInt(edit_wt.getText().toString());
                    int ht_ft = Integer.parseInt(edit_ht_ft.getText().toString());
                    int ht_in = Integer.parseInt(edit_ht_in.getText().toString());

                    double totalinch = ht_ft * 12 + ht_in;
                    double totalcm = totalinch * 2.54;
                    double totalm = totalcm / 100;

                    double BMI = wt / (totalm * totalm);


                    if (BMI > 25) {
                        text_result.setText("You are Over Weight");
                        image.setImageResource(R.drawable.fat);
                    } else if (BMI < 18) {
                        text_result.setText("You are Under Weight");
                        image.setImageResource(R.drawable.thin);
                    } else {
                        text_result.setText("Congratulations You are Healthy");
                        image.setImageResource(R.drawable.perfect);
                    }
                }



            }

        });
    }
}