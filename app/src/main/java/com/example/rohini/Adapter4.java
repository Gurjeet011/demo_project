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
//public class Adapter4 extends RecyclerView .Adapter<Adapter4.MyViewHolder> {
//   Context context;
//
//    public Adapter4(Context context, ArrayList<Model2> model2s) {
//        this.context = context;
//        this.model2s = model2s;
//    }
//
//    ArrayList<Model2>model2s;
//
//    @NonNull
//    @Override
//    public Adapter4.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom4 ,parent,false);
//
//        return new MyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull Adapter4.MyViewHolder holder, int position) {
//        holder.t.setText(model2s.get(position).getT());
//        holder.tt.setText(model2s.get(position).getT2());
//        holder.ttt.setText(model2s.get(position).getT3());
//
//       // holder.imageView.setImageResource(model2s.get(position).getImgg());
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return model2s.size();
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//
//        ImageView imageView;
//        TextView t,tt,ttt;
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//            imageView = itemView.findViewById(R.id.imgo);
//
//            t = itemView.findViewById(R.id.text1);
//            tt = itemView.findViewById(R.id.text2);
//            ttt = itemView.findViewById(R.id.text3);
//
//
//
//        }
//    }
//}
