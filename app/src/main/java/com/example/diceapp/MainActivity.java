package com.example.diceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView dice1=findViewById(R.id.imgDice1);
        final ImageView dice2=findViewById(R.id.imgDice2);

        final int []diceImages={R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5, R.drawable.dice6};



        Button btnRoll = findViewById(R.id.btnRollTheDice);
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r1 = new Random();
                //Random r2 = new Random();
                Log.i("MyDiceApp","btnRoll is tapped now");
                int rand_num=r1.nextInt(6);
                int rand_num2=r1.nextInt(6);
                Log.i("MyDiceA",rand_num +"");
                dice1.setImageResource(diceImages[rand_num]);
                dice2.setImageResource(diceImages[rand_num2]);

                YoYo.with(Techniques.Shake)
                        .duration(300)
                        .repeat(2)
                        .playOn(dice1);

                YoYo.with(Techniques.Tada)
                        .duration(300)
                        .repeat(2)
                        .playOn(findViewById(R.id.imgDice2));

            }
        });

    }
}
