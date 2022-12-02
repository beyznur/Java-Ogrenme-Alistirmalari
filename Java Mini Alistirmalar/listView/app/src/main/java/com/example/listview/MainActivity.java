package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private ArrayAdapter<String> adapter;
    private String[] sehirler={"Ankara","Adana","İstanbul","İzmir","Bursa","Bolu",
                                "Bolu","Aydın","Van","Muş","Karamanmaraş","Batman",
                                "Mardin","Diyarbakır"};
    private String[] sehirlerAciklama={"ankaraankaraankaraankaraankara","adanaadanaadanaadana","istanbulistanbulistanbulistanbul",
                                        "İzmirİzmirİzmirİzmir"};
    private int[] sehirlerResim= {R.drawable.ankara, R.drawable.adana, R.drawable.istanbul, R.drawable.izmir};

    private Intent detailsIntent;
    static public Sehir sehir;
    private Bitmap secilenSehir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView=findViewById(R.id.main_activity_listView);
        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,sehirler);//şehirleri buradan al liste şeklinde
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position<4){
                    //poisition tıklanan itemin indexini döner
                    //Toast.makeText(getApplicationContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();index yazdırır
                    //Toast.makeText(getApplicationContext(),sehirler[position],Toast.LENGTH_SHORT).show();
                    detailsIntent=new Intent(MainActivity.this,Details.class);
                    secilenSehir= BitmapFactory.decodeResource(getApplicationContext().getResources(),sehirlerResim[position]);
                    sehir=new Sehir(sehirlerAciklama[position],sehirler[position],secilenSehir);
                    startActivity(detailsIntent);
                }

            }
        });


    }
}