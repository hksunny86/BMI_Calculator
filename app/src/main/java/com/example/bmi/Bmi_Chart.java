package com.example.bmi;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoViewAttacher;

public class Bmi_Chart extends AppCompatActivity {
    ImageView chart;
    PhotoViewAttacher mAttacher;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_chart);
        Button back = (Button) findViewById(R.id.back_b);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bmi_Chart.this , MainActivity.class);
                startActivity(intent);
                Toast.makeText(Bmi_Chart.this,"BMI CALCULATOR",Toast.LENGTH_LONG).show();

            }
        });
         chart = (ImageView) findViewById(R.id.chart);
        int getResources = getResources().getIdentifier("@drawable/chart",null,this.getPackageName());
        chart.setImageResource(getResources);
        Drawable bitmap = getResources().getDrawable(R.drawable.chart);
        chart.setImageDrawable(bitmap);

        mAttacher = new PhotoViewAttacher(chart);
        mAttacher.update();
    }


    public void ZoomIn(View view) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
        chart.startAnimation(animation);

    }

    public void ZoomOut(View view) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
        chart.startAnimation(animation);
    }
}
