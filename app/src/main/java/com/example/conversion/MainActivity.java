package com.example.conversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import Models.Celsius;

public class MainActivity extends AppCompatActivity {

TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Celsius c=new Celsius(0.0);

        text2 = findViewById(R.id.text2);

        Button btn1=findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(4000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        int counter =(int) millisUntilFinished/1000 ;
                        text2.setText(String.valueOf(counter));
                        counter++;
                    }
                    public void onFinish() {
                        text2.setText("YA!!");
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                    }
                }.start();
            }
        });


        LottieAnimationView animationView = findViewById(R.id.animationView);
        animationView.setAnimation(R.raw.a);
        animationView.playAnimation();



    }
}