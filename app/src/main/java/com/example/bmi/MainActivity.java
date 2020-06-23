package com.example.bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button clear , button , bmi_chart;
    TextView textView1 , textView2 , textView3, BMI_cat;
    EditText weight , height , cal_bmi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonListenere();
        Clear();
        chart_bmi();



    }
    public void chart_bmi(){
        bmi_chart = (Button) findViewById(R.id.buttonchart);
        bmi_chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , Bmi_Chart.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"BMI CHART",Toast.LENGTH_LONG).show();

            }
        });
    }
    public void Clear(){
        clear = (Button) findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight.setText("");
                height.setText("");
                cal_bmi.setText("");
                BMI_cat.setText("Your Category Will Be Displayed Here");
            }
        });
    }
    public void buttonListenere(){
        textView1 = (TextView) findViewById(R.id.title);
        textView2 = (TextView) findViewById(R.id.textView);
        textView3 = (TextView) findViewById(R.id.textView2);
        button = (Button)  findViewById(R.id.buttonBMI);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                weight = (EditText) findViewById(R.id.weight_kg);
                String w8 = weight.getText().toString();
                double weight_kg = Double.parseDouble(w8);
                height = (EditText) findViewById(R.id.height_m);
                String h8 = height.getText().toString();
                double height_m = Double.parseDouble(h8);
                double BMI = (weight_kg)/(height_m*height_m);
                DecimalFormat df = new DecimalFormat("#.#");
                double BMI_trimmed = Double.parseDouble(df.format(BMI));
                cal_bmi = (EditText) findViewById(R.id.cal_bmi);
                cal_bmi.setText(Double.toString(BMI_trimmed));
                String BMI_Cat;
                if (BMI < 15) BMI_Cat = "Very severely underweight";
                else if (BMI < 16) BMI_Cat = "Severely underweight";
                else if (BMI < 18.5) BMI_Cat = "Underweight";
                else if (BMI < 25) BMI_Cat = "Normal";
                else if (BMI < 30) BMI_Cat = "Overweight";
                else if (BMI < 35) BMI_Cat = "Obese Class 1 - Moderately Obese";
                else if (BMI < 40) BMI_Cat = "Obese Class 2 - Severely Obese";
                else BMI_Cat = "Obese Class 3 - Very Severely Obese";

                BMI_cat = (TextView) findViewById(R.id.category);
                BMI_cat.setText(BMI_Cat);

            }
        });
    }
}
