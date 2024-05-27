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
//public class Adapter3 extends RecyclerView.Adapter<Adapter3.MyViewHolder> {
//    public Adapter3(Context context, ArrayList<Modelclass> modelclasses) {
//        this.context = context;
//        this.modelclasses = modelclasses;
//    }
//
//    Context context;
//    ArrayList<Modelclass> modelclasses;
//
//
//    @NonNull
//    @Override
//    public Adapter3.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom3 ,parent,false);
//
//
//        return new MyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull Adapter3.MyViewHolder holder, int position) {
//        holder.textVieww.setText(modelclasses.get(position).getName());
//       // holder.imageVieww.setImageResource(modelclasses.get(position).getImg());
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return modelclasses.size();
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        ImageView imageVieww;
//        TextView textVieww;
//
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//            imageVieww = itemView.findViewById(R.id.cimg);
//            textVieww = itemView.findViewById(R.id.t2);
//
//
//        }
//    }
//}
