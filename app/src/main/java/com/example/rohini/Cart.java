//package com.example.rohini;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//
//import java.util.ArrayList;
//
//public class Cart extends AppCompatActivity {
//    //Cartadapter cartadapter;
//    RecyclerView recyclerViewy;
//    ArrayList<Modelclass> arrayList;
//    @SuppressLint("MissingInflatedId")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_cart);
//        recyclerViewy=findViewById(R.id.rv44);
//
//        arrayList = new ArrayList<>();
//        arrayList.add(new Modelclass("choclate",R.drawable.amull));
//        //cartadapter = new Cartadapter(getApplicationContext(),arrayList);
//     //   recyclerViewy.setAdapter(cartadapter);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false);
//        recyclerViewy.setLayoutManager(layoutManager);
//
//
//
//
//    }
//    @Override
//    public void onBackPressed() {
//        // Add your custom code for back button press
//        // For example, you can navigate to another activity or finish the current activity
//        super.onBackPressed();
//        Intent intent = new Intent(Cart.this, Home_Activity.class);
//        startActivity(intent);
//        finish();
//    }
//}