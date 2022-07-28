package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1;
    EditText xheight;
    EditText xweight;
    double res;
    Double heightNum, weightNum;
    RadioButton xmen,xwomen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.btn);
        button1.setOnClickListener(new btn1click());//定义一个接口类
        xheight = (EditText) findViewById(R.id.height);
        xweight = (EditText) findViewById(R.id.weight);
        xmen=(RadioButton)findViewById(R.id.men);
        xwomen=(RadioButton)findViewById(R.id.women);

    }

    private class btn1click implements View.OnClickListener {

        String h, w, msg = "";

        @Override
        public void onClick(View view) {

            h = xheight.getText().toString().trim();
            w = xweight.getText().toString().trim();
            if (!h.isEmpty() && !w.isEmpty()) {

                heightNum = Double.parseDouble(h);
                weightNum = Double.parseDouble(w);

                res = (1000 * heightNum) / (weightNum * weightNum);
                if (xmen.isChecked()){
                    if(res>90){
                        msg = "体质指数偏胖，计算结果为：" + res;
                    }else if (res>80){
                        msg = "体质指数标准，计算结果为：" + res;
                    }else{
                        msg = "体质指数偏瘦，计算结果为：" + res;
                    }
                }else if(xwomen.isChecked()){
                    if(res>85){
                        msg = "体质指数偏胖，计算结果为：" + res;
                    }else if (res>75){
                        msg = "体质指数标准，计算结果为：" + res;
                    }else{
                        msg = "体质指数偏瘦，计算结果为：" + res;
                    }
                }

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("BMI", msg);
                startActivity(intent);//定义一个内部类
            }else{

                Toast.makeText(MainActivity.this,"身高体重不能为空",Toast.LENGTH_LONG).show();
            }
        }
    }
}

