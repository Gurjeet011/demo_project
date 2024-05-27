//package com.example.rohini;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.GridLayoutManager;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.os.Bundle;
//
//import java.util.ArrayList;
//
//public class Home_Activity extends AppCompatActivity {
//
//    Homeadapter homeadapter;
//    Homeadapter2 homeadapter2;
//    Adaptercustom adaptercustom;
//
//    RecyclerView recyclerView,recyclerView22,recyclerView3;
//
//    ArrayList<Modelclass> arrayList;
//    @SuppressLint("MissingInflatedId")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
//        recyclerView=findViewById(R.id.homerecycle);
//        recyclerView22=findViewById(R.id.homerecycle2);
//        recyclerView3=findViewById(R.id.rv3);
//
//
//
//        arrayList = new ArrayList<>();
//        arrayList.add(new Modelclass("choclate",R.drawable.homeveg));
//        arrayList.add(new Modelclass("cookiies",R.drawable.cookiies));
//
//
//        homeadapter = new Homeadapter(getApplicationContext(),arrayList);
//        recyclerView.setAdapter(homeadapter);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false);
//        recyclerView.setLayoutManager(layoutManager);
//
//        arrayList = new ArrayList<>();
//        arrayList.add(new Modelclass("vegetables",R.drawable.homeveg));
//        arrayList.add(new Modelclass("shimla",R.drawable.shimlaa));
//        arrayList.add(new Modelclass("mixes",R.drawable.veg));
//        arrayList.add(new Modelclass("gobi",R.drawable.gobiii));
//        arrayList.add(new Modelclass("carrat",R.drawable.gajjarrr));
//        arrayList.add(new Modelclass("bengan",R.drawable.bengan));
//        arrayList.add(new Modelclass("tomato",R.drawable.tmatar));
//        arrayList.add(new Modelclass("beans",R.drawable.matar));
//        arrayList.add(new Modelclass("onion",R.drawable.piyaz));
//        arrayList.add(new Modelclass("cookiies",R.drawable.cookiies));
//
//
//        homeadapter2 = new Homeadapter2(getApplicationContext(),arrayList);
//        recyclerView22.setAdapter(homeadapter2);
//        GridLayoutManager layoutManagerr = new GridLayoutManager(getApplicationContext(), 5);
//        recyclerView22.setLayoutManager(layoutManagerr);
//
//        arrayList = new ArrayList<>();
//        arrayList.add(new Modelclass("choclate",R.drawable.homeveg));
//        arrayList.add(new Modelclass("cookiies",R.drawable.aataa));
//        arrayList.add(new Modelclass("cookiies",R.drawable.amull));
//        arrayList.add(new Modelclass("cookiies",R.drawable.aataa));
//        arrayList.add(new Modelclass("cookiies",R.drawable.homeveg));
//        arrayList.add(new Modelclass("cookiies",R.drawable.cookiies));
//
//        adaptercustom = new Adaptercustom(getApplicationContext(),arrayList);
//        recyclerView3.setAdapter(adaptercustom);
//        GridLayoutManager layoutManagerrr = new GridLayoutManager(getApplicationContext(), 3);
//        recyclerView3.setLayoutManager(layoutManagerrr);
//
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
//        Intent intent = new Intent(Home_Activity.this, MainActivity2.class);
//        startActivity(intent);
//        finish();
//    }
//
//}