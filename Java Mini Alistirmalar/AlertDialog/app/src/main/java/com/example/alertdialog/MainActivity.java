package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private AlertDialog.Builder alert;
    private String secim="Seçtikleriniz";
    private String[] isletimSistemleri={"Windows 10","Windows 98","Windows XP","Windows 7"};
    private boolean[] secimler={true,false,true,true};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void normalAlertDialog(View View){
       alert=new AlertDialog.Builder(this);
        alert.setTitle("Kütüphane Otomasyonu");
        alert.setMessage("Uygulamadan Çıkmak İstediğinize Emin Misiniz");
        //alert.setCancelable(false);
        alert.setIcon(R.mipmap.ic_launcher);
        alert.setPositiveButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.setNegativeButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Çıkışa bastın",Toast.LENGTH_SHORT).show();
            }
        });
        alert.show();
    }

    public void alertDialog(View view){
        alert=new AlertDialog.Builder(this);
        alert.setTitle("İşletim Sistemi Türü Tercihinizi Seçiniz");
        DialogInterface.OnMultiChoiceClickListener listener=new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked){
                    secim+= "\n" +isletimSistemleri[which] ;
                    Toast.makeText(getApplicationContext(),isletimSistemleri[which],Toast.LENGTH_SHORT).show();
                }
            }
        };

        alert.setMultiChoiceItems(isletimSistemleri,secimler,listener);
        alert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),secim,Toast.LENGTH_SHORT).show();

            }
        });
        alert.show();
    }
}