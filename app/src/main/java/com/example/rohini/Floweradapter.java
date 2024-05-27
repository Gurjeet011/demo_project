package com.example.rohini;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Floweradapter extends RecyclerView .Adapter<Floweradapter.Myviewholder> {
    Context context;

    public Floweradapter(Context context, ArrayList<Modelclass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    ArrayList<Modelclass> arrayList;


    @NonNull
    @Override
    public Floweradapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_flower1 ,parent,false);


        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Floweradapter.Myviewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.textViewb.setText(arrayList.get(position).getName());

        String img_uri = "https://www.websunindia.com/demo/bornto/assets/upload/product/" + arrayList.get(position).getCat_img();

        try {
            Glide.with(context).load(img_uri).into(holder.imageViewb);
        } catch (Exception e) {
            Log.e("GlideError", "Glide error: " + e.getMessage());
        }


        holder.imageViewb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Product.class);
                intent.putExtra("id1", arrayList.get(position).getId());
                intent.putExtra("id2", arrayList.get(position).getId2());
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
        CircleImageView imageViewb;
        TextView textViewb;

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            imageViewb=itemView.findViewById(R.id.hmimg);
            textViewb=itemView.findViewById(R.id.htxtb);
        }
    }
}
