
package com.example.rohini;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
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

public class Productadapter extends RecyclerView .Adapter<Productadapter.Myviewholder> {
    Context context;

    public Productadapter(Context context, ArrayList<Modelclass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    ArrayList<Modelclass> arrayList;


    @NonNull
    @Override
    public Productadapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_product ,parent,false);


        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Productadapter.Myviewholder holder, @SuppressLint("RecyclerView") int position) {

        holder.textView2m.setText(arrayList.get(position).getName());
        holder.textView2m.setSelected(true);
        holder.salee.setText(arrayList.get(position).getN1());
        holder.salee.setPaintFlags(holder.mrpp.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.mrpp.setText(arrayList.get(position).getN2());
        holder.diss.setText(arrayList.get(position).getN3());

        String img_uri = "https://www.websunindia.com/demo/bornto/assets/upload/product/"+arrayList.get(position).getCat_img();

        try {
            Glide.with(context).load(img_uri).into(holder.imageView1a);
        } catch (Exception e) {
            Log.e("GlideError", "Glide error: " + e.getMessage());
        }

        holder.imageView1a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Description.class);
                intent.putExtra("idd",arrayList.get(position).getId());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {
        ImageView imageView1a;
        TextView textView2m,mrpp,salee,diss;

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            imageView1a=itemView.findViewById(R.id.productimg);
            textView2m=itemView.findViewById(R.id.text2p);
            mrpp=itemView.findViewById(R.id.text3p);
            salee=itemView.findViewById(R.id.text4p);
            diss=itemView.findViewById(R.id.text5p);


        }
    }
}

