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

public class Adaptergrid extends RecyclerView.Adapter<Adaptergrid.MyViewHolder> {
    Context context;
    ArrayList<Modelclass> arrayList;

    public Adaptergrid(Context context, ArrayList<Modelclass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Adaptergrid.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_grid, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Adaptergrid.MyViewHolder holder, int position) {
        holder.t1.setText(arrayList.get(position).getName2());
        holder.t2.setText(arrayList.get(position).getName());


        String img_uri = "https://www.websunindia.com/demo/bornto/assets/upload/product/" + arrayList.get(position).getCat_img();

        try {
            Glide.with(context).load(img_uri).into(holder.imageView);
        } catch (Exception e) {
            Log.e("GlideError", "Glide error: " + e.getMessage());
        }
    }

        @Override
        public int getItemCount () {
            return arrayList.size();
        }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView t1, t2;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgcard);
            t1 = itemView.findViewById(R.id.tt1);
            t2 = itemView.findViewById(R.id.tt121);
        }
    }
}





