package com.example.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MeyveAdapter extends ArrayAdapter<String> {
    private String[] meyveler;
    private int[] kaloriler;
    private int[] resimler;
    private Context context;
    private TextView meyveIsmi,meyveKalori;
    private ImageView meyveResim;


    public MeyveAdapter(String[] meyveler, int[] kaloriler, int[] resimler, Context context) {
        super(context, R.layout.meyve_item,meyveler);
        this.meyveler = meyveler;
        this.kaloriler = kaloriler;
        this.resimler = resimler;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.meyve_item,null);
        if(view!=null){
            meyveIsmi=view.findViewById(R.id.meyve_item_textViewMeyveİsmi);
            meyveKalori=view.findViewById(R.id.meyve_item_textViewMeyveKalori);
            meyveResim=view.findViewById(R.id.meyve_item_imageViewResim);

            meyveIsmi.setText(meyveler[position]);
            meyveKalori.setText(String.valueOf(kaloriler[position]));
            meyveResim.setBackgroundResource(resimler[position]);
        }
        return view;
    }
}
