/*
package com.example.rohini;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Cartadapter extends RecyclerView .Adapter<Cartadapter.MyViewHolder> {
    Context context;

    public Cartadapter(Context context, ArrayList<Modelclass> modelclasses) {
        this.context = context;
        this.modelclasses = modelclasses;
    }

    ArrayList<Modelclass> modelclasses;

    @NonNull
    @Override
    public Cartadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.milkcart ,parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Cartadapter.MyViewHolder holder, int position) {
        holder.imageViewn.setImageResource(modelclasses.get(position).getImg());

    }

    @Override
    public int getItemCount() {
        return modelclasses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewn=itemView.findViewById(R.id.milkimg);
        }
    }
}
*/
