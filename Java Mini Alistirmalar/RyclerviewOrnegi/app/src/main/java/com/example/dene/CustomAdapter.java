package com.example.dene;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    ArrayList<VerileriIsle> arrayList;
    LayoutInflater layoutInflater;
    Context context;

    public CustomAdapter(ArrayList<VerileriIsle> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    // Her bir satır için temsil edilecek olan arayüz belirlenir.
    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.satir_genel_ayari,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    // Her bir satırın içeriği belirlenir.
    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {

        holder.txt_kisi_adi.setText(arrayList.get(position).getIsim_soyisim());
        holder.txt_kisi_dogum_tarihi.setText(arrayList.get(position).getDogum_tarihi());
        holder.img_resim.setImageResource(arrayList.get(position).getResim());
        holder.ll_liste_elemani.setTag(holder);
        // Listedeki elemanlara tıklanıdığında yapılacak olan işlem...
        holder.ll_liste_elemani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewHolder holder1 = (ViewHolder)view.getTag();
                int position = holder1.getPosition();
                String yazdir = arrayList.get(position).getIsim_soyisim();

                Toast.makeText(context, ""+yazdir, Toast.LENGTH_SHORT).show();
            }
        });

    }

    // Listedeki eleman sayısı kadar işlemin yapılmasını sağladık. Elle de bir değer verilebilirdi.
    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    // Elemanlarımıza erişip tanımladığımız yer
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt_kisi_adi, txt_kisi_dogum_tarihi;
        ImageView img_resim;
        LinearLayout ll_liste_elemani;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_kisi_adi = itemView.findViewById(R.id.txt_kisi_adi);
            txt_kisi_dogum_tarihi = itemView.findViewById(R.id.txt_kisi_dogum_tarihi);
            img_resim = itemView.findViewById(R.id.img_resim);
            ll_liste_elemani = itemView.findViewById(R.id.ll_liste_elemani);
        }
    }
}
