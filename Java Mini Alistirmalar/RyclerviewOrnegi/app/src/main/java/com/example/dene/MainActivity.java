package com.example.dene;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    ArrayList<VerileriIsle> arrayList = new ArrayList<>();
    RecyclerView r_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r_view = findViewById(R.id.r_view);
        // LinearLayoutManager ile verilerin nasıl konumlandırılacağı belirlenir.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        linearLayoutManager.scrollToPosition(0);

        // Üstte oluşturulan düzen RecyclerView'a set edildi.
        r_view.setLayoutManager(linearLayoutManager);

        // Listeye eleman eklendi.
        arrayList.add(new VerileriIsle("Ahmet Sağ","1999",R.drawable.keny));
        arrayList.add(new VerileriIsle("Mehmet Sağ","2001",R.drawable.keny));
        arrayList.add(new VerileriIsle("Pelin Sağ","2005",R.drawable.keny));

        // Listenin uzun görülmesi için döngüden faydalanarak değerler ekledik.
        for(int i = 3; i <= 20; i++){
            arrayList.add(new VerileriIsle(""+i,""+i,R.drawable.keny));
        }

        // Adapter yapımızın nesnesini oluşturup parametre gönderdik ve ardın RecyclerView'a set ettik.
        CustomAdapter customAdapter = new CustomAdapter(arrayList,context);
        r_view.setAdapter(customAdapter);

    }
}