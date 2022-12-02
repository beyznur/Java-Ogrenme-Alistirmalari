package com.example.hayvangalerisi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GridView mGridView;
    private String[] hayvanlar={"At","Fil","Kedi","Köpek","Kurt","Ördek","Panda","Papagan","Sincap","Tavşan","Tilki"};
    private int[] resimler={R.drawable.at, R.drawable.fil, R.drawable.kedi, R.drawable.kopek, R.drawable.kurt, R.drawable.ordek, R.drawable.panda,
        R.drawable.papagan, R.drawable.sincap, R.drawable.tavsan, R.drawable.tilki};

    private HayvanAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGridView=(GridView)findViewById(R.id.main_activity_gridView);
        adapter=new HayvanAdapter(hayvanlar,resimler,this);
        mGridView.setAdapter(adapter);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),hayvanlar[position],Toast.LENGTH_SHORT).show();
            }
        });

    }
}