//package com.example.rohini;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//public class Homeadapter extends RecyclerView.Adapter<Homeadapter.MyViewHolder> {
//    Context context;
//
//    public Homeadapter(Context context, ArrayList<Modelclass> modelclasses) {
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
//    public Homeadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customhome ,parent,false);
//
//
//        return new MyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull Homeadapter.MyViewHolder holder, int position) {
//           // holder.imageView.setImageResource(modelclasses.get(position).getImg());
//    }
//
//    @Override
//    public int getItemCount() {
//        return modelclasses.size();
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        ImageView imageView;
//
//
//
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            imageView=itemView.findViewById(R.id.homeimg);
//        }
//    }
//}
