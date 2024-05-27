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

public class Adaptergrid3 extends RecyclerView .Adapter<Adaptergrid3.MyViewHolder> {
    Context context;

    public Adaptergrid3(Context context, ArrayList<Modelclass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    ArrayList<Modelclass> arrayList;
    @NonNull
    @Override
    public Adaptergrid3.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cutom_grid3, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Adaptergrid3.MyViewHolder holder, int position) {
        holder.textView11.setText(arrayList.get(position).getName2());
        holder.textView22.setText(arrayList.get(position).getName());


        String img_uri = "https://www.websunindia.com/demo/bornto/assets/upload/product/" + arrayList.get(position).getCat_img();

        try {
            Glide.with(context).load(img_uri).into(holder.imageView91);
        } catch (Exception e) {
            Log.e("GlideError", "Glide error: " + e.getMessage());
        }


    }



    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView91;
        TextView textView11,textView22;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView91=itemView.findViewById(R.id.imgcard23);
            textView11=itemView.findViewById(R.id.t44);
            textView22=itemView.findViewById(R.id.t4);


        }
    }
}
