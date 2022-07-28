package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {

    Button button2;
    TextView xBMI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        xBMI=(TextView) findViewById(R.id.txt_BMI);

        Intent intent=getIntent();
        xBMI.setText(intent.getStringExtra("BMI"));

        button2=(Button) findViewById(R.id.btn2);
        button2.setOnClickListener(new Main2Activity.btn2click());


    }

    private class btn2click implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Main2Activity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}