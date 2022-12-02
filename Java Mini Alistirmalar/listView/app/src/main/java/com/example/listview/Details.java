package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    private TextView sehirİsmi,sehirAciklama;
    private ImageView sehirResmi;
    private String sAciklama,sİsim;
    private Bitmap secilenSehir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        sehirİsmi=findViewById(R.id.details_activity_textViewSehirİsmi);
        sehirAciklama=findViewById(R.id.details_activitiy_textViewDetay);
        sehirResmi=findViewById(R.id.details_activity_imageViewSehirResmi);

        sİsim=MainActivity.sehir.getIsim();
        sAciklama=MainActivity.sehir.getAciklama();
        secilenSehir=MainActivity.sehir.getResim();

        if(!TextUtils.isEmpty(sİsim)&& !TextUtils.isEmpty(sAciklama) ){
            sehirİsmi.setText(sİsim);
            sehirAciklama.setText(sAciklama);
            sehirResmi.setImageBitmap(secilenSehir);
        }
    }
}