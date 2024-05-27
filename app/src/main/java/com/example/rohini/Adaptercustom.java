//package com.example.rohini;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//public class Adaptercustom extends RecyclerView .Adapter<Adaptercustom.MyViewHolder> {
//    Context context;
//
//    public Adaptercustom(Context context, ArrayList<Modelclass> modelclasses) {
//        this.context = context;
//        this.modelclasses = modelclasses;
//    }
//
//    ArrayList<Modelclass> modelclasses;
//
//
//
//    @NonNull
//    @Override
//    public Adaptercustom.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom ,parent,false);
//
//
//
//        return new MyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull Adaptercustom.MyViewHolder holder, int position) {
//      //  holder.imageView.setImageResource(modelclasses.get(position).getImg());
//        holder.textView.setText(modelclasses.get(position).getName());
//        holder.textView2.setText(modelclasses.get(position).getName());
//
//
//    }
//
//
//    @Override
//    public int getItemCount() {
//        return modelclasses.size();
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        ImageView imageView;
//        TextView textView,textView2;
//
//
//
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//            imageView = itemView.findViewById(R.id.imgoo);
//            textView = itemView.findViewById(R.id.text11);
//            textView2 = itemView.findViewById(R.id.text22);
//
//
//
//        }
//    }
//}
