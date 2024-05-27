package com.example.rohini;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adaptergrid2 extends RecyclerView.Adapter<Adaptergrid2.MyViewHolder> {
    public Adaptergrid2(Context context, ArrayList<Modelclass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    Context context;
    ArrayList<Modelclass> arrayList;

    @NonNull
    @Override
    public Adaptergrid2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_grid2, parent, false);
        return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull Adaptergrid2.MyViewHolder holder, int position) {


        holder.textView1.setText(arrayList.get(position).getName2());
        holder.textView2.setText(arrayList.get(position).getName());


        String img_uri = "https://www.websunindia.com/demo/bornto/assets/upload/product/" + arrayList.get(position).getCat_img();

        try {
            Glide.with(context).load(img_uri).into(holder.imageView9);
        } catch (Exception e) {
            Log.e("GlideError", "Glide error: " + e.getMessage());
        }


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView9;
        TextView textView1,textView2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView9=itemView.findViewById(R.id.imgcard2);
            textView1=itemView.findViewById(R.id.t2);
            textView2=itemView.findViewById(R.id.t3);


        }
    }
}
