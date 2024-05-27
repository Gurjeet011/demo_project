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
//public class Homeadapter2 extends RecyclerView.Adapter<Homeadapter2.MyViewHolder> {
//   Context context;
//
//    public Homeadapter2(Context context, ArrayList<Modelclass> modelclasses) {
//        this.context = context;
//        this.modelclasses = modelclasses;
//    }
//
//    ArrayList<Modelclass> modelclasses;
//    @NonNull
//    @Override
//    public Homeadapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customhome2 ,parent,false);
//
//        return new MyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull Homeadapter2.MyViewHolder holder, int position) {
//
//      //  holder.imageView.setImageResource(modelclasses.get(position).getImg());
//        holder.textView.setText(modelclasses.get(position).getName());
//
//
//
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return modelclasses.size();
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        ImageView imageView;
//        TextView textView;
//
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//            textView=itemView.findViewById(R.id.htxt);
//            imageView=itemView.findViewById(R.id.himg);
//
//        }
//    }
//}
