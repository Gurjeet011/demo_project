
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
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

public class Descriptionadapter extends SliderViewAdapter<Descriptionadapter.viewholder> {
    Context context;

    public Descriptionadapter(Context context, ArrayList<Modelclass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    ArrayList<Modelclass>arrayList;
    public Descriptionadapter.viewholder onCreateViewHolder(ViewGroup parent) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_description,parent,false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(Descriptionadapter.viewholder viewHolder, int position) {
        String img_uri = "https://www.websunindia.com/demo/bornto/assets/upload/product/"+arrayList.get(position).getImg();

        try {
            Glide.with(context).load(img_uri).into(viewHolder.imggg);
        } catch (Exception e) {
            Log.e("GlideError", "Glide error: " + e.getMessage());
        }

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    public class viewholder extends ViewHolder {
        ImageView imggg;
        public viewholder(View itemView) {
            super(itemView);
            imggg=itemView.findViewById(R.id.disimg);
        }
    }
}

