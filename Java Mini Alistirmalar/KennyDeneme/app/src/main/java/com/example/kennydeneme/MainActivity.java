package com.example.kennydeneme;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Handler handler;
    Runnable runnable;
    TextView timeText,skorText;
    ImageView imageView,imageView2,imageView3,imageView4,
            imageView5,imageView6,imageView7,imageView8,imageView9;
    ImageView[]  imageArray;
    int skor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        skorText=findViewById(R.id.skorText);
        timeText=findViewById(R.id.timeText);

        imageView=findViewById(R.id.imageView);
        imageView2=findViewById(R.id.imageView2);
        imageView3=findViewById(R.id.imageView3);
        imageView4=findViewById(R.id.imageView4);
        imageView5=findViewById(R.id.imageView5);
        imageView6=findViewById(R.id.imageView6);
        imageView7=findViewById(R.id.imageView7);
        imageView8=findViewById(R.id.imageView8);
        imageView9=findViewById(R.id.imageView9);

        skor=0;

        imageArray=new ImageView[] {imageView,imageView2,imageView3,imageView4,
                imageView5,imageView6,imageView7,imageView8,imageView9};
        resimGoster();



        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long l) {
               timeText.setText("Time: " +l/1000);
            }

            @Override
            public void onFinish() {
                timeText.setText("Time Off...");
                handler.removeCallbacks(runnable);
                for (ImageView image: imageArray)
                    image.setVisibility(View.INVISIBLE);

                AlertDialog.Builder alert= new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Restart?");
                alert.setMessage("Are you sure to restart game?");
                alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);

                    }
                });

                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Game Over",Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();

            }
        }.start();
    }


    public void skorArttir(View view)
    {
        skor++;
        skorText.setText("Skor: "+ skor);

    }

    public void resimGoster()
    {
        handler= new Handler();
        runnable =new Runnable() {
            @Override
            public void run() {
                for(ImageView image: imageArray)
                    image.setVisibility(View.INVISIBLE);

                Random random = new Random();
                int i=random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,500);
            }
        };
        handler.post(runnable);


    }

}