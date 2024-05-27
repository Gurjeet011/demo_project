
package com.example.rohini;

import android.content.Context;
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



public class Floweradapter2 extends RecyclerView .Adapter<Floweradapter2.Myviewholder> {
    Context context;

    public Floweradapter2(Context context, ArrayList<Modelclass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    ArrayList<Modelclass> arrayList;


    @NonNull
    @Override
    public Floweradapter2.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_flower2 ,parent,false);


        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Floweradapter2.Myviewholder holder, int position) {

        holder.textView2.setText(arrayList.get(position).getName());
        holder.textView2.setSelected(true);
        holder.sale.setText(arrayList.get(position).getN1());
        holder.sale.setPaintFlags(holder.mrp.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.mrp.setText(arrayList.get(position).getN2());
        holder.dis.setText(arrayList.get(position).getN3());

        String img_uri = "https://www.websunindia.com/demo/bornto/assets/upload/product/"+arrayList.get(position).getCat_img();

        try {
            Glide.with(context).load(img_uri).into(holder.imageView1);
        } catch (Exception e) {
            Log.e("GlideError", "Glide error: " + e.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {
        ImageView imageView1;
        TextView textView2,mrp,sale,dis;

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            imageView1=itemView.findViewById(R.id.imgcardl);
            textView2=itemView.findViewById(R.id.text2);
            mrp=itemView.findViewById(R.id.text3);
            sale=itemView.findViewById(R.id.text4);
            dis=itemView.findViewById(R.id.text5);


        }
    }
}

