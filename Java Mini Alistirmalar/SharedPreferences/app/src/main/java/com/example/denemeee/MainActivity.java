package com.example.denemeee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);

        editText=findViewById(R.id.editTextNumber);
        sharedPreferences=this.getSharedPreferences(" com.example.denemeee", Context.MODE_PRIVATE);
        int storeAge= sharedPreferences.getInt("storeAge",0);
        if(storeAge==0)
                textView.setText("Your Age: ");
        else
                textView.setText("Your Age: "+ storeAge);

    }


    public void save(View view){
        if(!editText.getText().toString().matches("")){
            int age=Integer.parseInt(editText.getText().toString());
            textView.setText("Your Age:" + age);
            sharedPreferences.edit().putInt("storeAge", age).apply();
        }

    }
    public void delete(View view){
        int storedData=sharedPreferences.getInt("storeAge",0);
        if(storedData!=0){
            sharedPreferences.edit().remove("storeAge").apply();
            textView.setText("Your Age: ");

        }

    }

}