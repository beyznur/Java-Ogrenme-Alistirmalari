package com.example.listview;

import android.graphics.Bitmap;

public class Sehir {
    private String aciklama,isim;
    private Bitmap resim;

    public Sehir(String aciklama, String isim, Bitmap resim) {
        this.aciklama = aciklama;
        this.isim = isim;
        this.resim = resim;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public Bitmap getResim() {
        return resim;
    }

    public void setResim(Bitmap resim) {
        this.resim = resim;
    }
}
