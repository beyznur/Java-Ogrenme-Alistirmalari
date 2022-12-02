package com.example.dene;

public class VerileriIsle {


        // Listeye eklenip kullanılacak olan veriler bu sınıftan geçer.
        // Basit bir şekilde constructor metot ve her değişkenin getter-setter metotlarını oluşturduk.
        // Aşağıda setter metotlarımızla bir işimiz yok ama yine de bulunsun...

        String isim_soyisim;
        String dogum_tarihi;
        int resim;

        public VerileriIsle(String isim_soyisim, String dogum_tarihi, int resim) {
            this.isim_soyisim = isim_soyisim;
            this.dogum_tarihi = dogum_tarihi;
            this.resim = resim;
        }

        public String getIsim_soyisim() {
            return isim_soyisim;
        }

        public void setIsim_soyisim(String isim_soyisim) {
            this.isim_soyisim = isim_soyisim;
        }

        public String getDogum_tarihi() {
            return dogum_tarihi;
        }

        public void setDogum_tarihi(String dogum_tarihi) {
            this.dogum_tarihi = dogum_tarihi;
        }

        public int getResim() {
            return resim;
        }

        public void setResim(int resim) {
            this.resim = resim;
        }
    }


