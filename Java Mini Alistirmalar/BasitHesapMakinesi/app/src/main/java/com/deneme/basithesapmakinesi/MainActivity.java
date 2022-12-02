package com.deneme.basithesapmakinesi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTxtBirinciSayi, editTxtIkinciSayi;
    private TextView txtSonuc;
    private String birinciSayi, ikinciSayi;
    int s1, s2, sonuc;
    private Hesapla hesapla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTxtBirinciSayi = (EditText)findViewById(R.id.editTxtBirinciSayi);
        editTxtIkinciSayi = (EditText)findViewById((R.id.editTxtIkinciSayi));
        txtSonuc = (TextView)findViewById((R.id.txtViewSonuc));


    }

    public void btnHesapla(View v) {
        birinciSayi = editTxtBirinciSayi.getText().toString();
        ikinciSayi = editTxtIkinciSayi.getText().toString();

        if (!TextUtils.isEmpty(birinciSayi) && !TextUtils.isEmpty(ikinciSayi)) {
            s1 = Integer.valueOf(birinciSayi);//Degeri integer deger yapıp atar.
            s2 = Integer.valueOf(ikinciSayi);//Degeri integer deger yapıp atar.
            hesapla = new Hesapla(s1, s2);

            switch (v.getId()) {
                case R.id.btnTopla:
                    sonuc = hesapla.sonucuGonder("+");
                    break;

                case R.id.btnFark:
                    sonuc = hesapla.sonucuGonder("-");
                    break;

                case R.id.btnCarp:
                    sonuc = hesapla.sonucuGonder("*");
                    break;

                case R.id.btnBolme:
                    sonuc = hesapla.sonucuGonder("/");
                    break;
            }

            txtSonuc.setText(("Sonuç : " + sonuc));


        } else
            txtSonuc.setText(("Girilen degerler bos olamaz"));
    }
}