package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView mListview;
    private String[] meyveler = {"Muz","Kiraz","Elma","cilek"};
    private int[] kaloriler={25,20,15,30};
    private int[] resimler={R.drawable.muz,R.drawable.kiraz,R.drawable.elma,R.drawable.cilek};
    private MeyveAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListview=findViewById(R.id.main_activity_listView);
        adapter=new MeyveAdapter(meyveler,kaloriler,resimler,this);
        mListview.setAdapter(adapter);

        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),meyveler[position],Toast.LENGTH_SHORT).show();
            }
        });

    }
}