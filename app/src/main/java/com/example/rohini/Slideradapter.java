package com.example.rohini;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

public class Slideradapter extends SliderViewAdapter<Slideradapter.MyViewHolder> {

    Context context;
    ArrayList<Modelclass> arrayList;

    public Slideradapter(Context context, ArrayList<Modelclass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    @Override
    public Slideradapter.MyViewHolder onCreateViewHolder(ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_view,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Slideradapter.MyViewHolder viewHolder, int position) {

        String img_uri = "https://www.websunindia.com/demo/bornto/assets/upload/slider/"+arrayList.get(position).getImg();

        try {
            Glide.with(context).load(img_uri).into(viewHolder.imageView19);
        } catch (Exception e) {
            Log.e("GlideError", "Glide error: " + e.getMessage());
        }
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends ViewHolder {
        ImageView imageView19;

        public MyViewHolder(View itemView) {
            super(itemView);
             imageView19 = itemView.findViewById(R.id.slider);
        }

    }
}