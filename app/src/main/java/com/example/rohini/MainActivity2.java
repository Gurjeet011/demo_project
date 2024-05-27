/*
package com.example.rohini;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    Adapter3 adapter3;
    Adapter4 adapter4;
    RecyclerView recyclerVieww,recycle;
    ArrayList<Modelclass> arrayList;
    ArrayList<Model2>arrayList2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerVieww = findViewById(R.id.rv1);
        recycle = findViewById(R.id.rv2);

        arrayList = new ArrayList<>();
        arrayList.add(new Modelclass("Startinghdgdn", R.drawable.flower));
        arrayList.add(new Modelclass("cookiies", R.drawable.flower3));
        arrayList.add(new Modelclass("cookiies", R.drawable.flower4));
        arrayList.add(new Modelclass("cookiies", R.drawable.flower5));
        arrayList.add(new Modelclass("cookiies", R.drawable.flower));
        arrayList.add(new Modelclass("cookiies", R.drawable.flower3));
        arrayList.add(new Modelclass("cookiies", R.drawable.flower3));
        arrayList.add(new Modelclass("cookiies", R.drawable.flower3));
        arrayList.add(new Modelclass("cookiies", R.drawable.flower3));
        arrayList.add(new Modelclass("cookiies", R.drawable.flower3));
        arrayList.add(new Modelclass("cookiies", R.drawable.flower3));
        arrayList.add(new Modelclass("cookiies", R.drawable.flower3));
        arrayList.add(new Modelclass("cookiies", R.drawable.flower3));
        arrayList.add(new Modelclass("cookiies", R.drawable.flower3));
        arrayList.add(new Modelclass("cookiies", R.drawable.flower3));
        arrayList.add(new Modelclass("cookiies", R.drawable.flower3));

        adapter3 = new Adapter3(getApplicationContext(), arrayList);
        recyclerVieww.setAdapter(adapter3);
        GridLayoutManager layoutManagerr = new GridLayoutManager(getApplicationContext(), 1);
        recyclerVieww.setLayoutManager(layoutManagerr);

        arrayList2 = new ArrayList<>();
        arrayList2.add(new Model2("Cauliflower-(kg)","price 56","1kg",R.drawable.gobiii));
        arrayList2.add(new Model2("Onion-(kg)","price 56","1kg",R.drawable.veg));
        arrayList2.add(new Model2("Carrot-(kg)","price 56","1kg",R.drawable.gajjarrr));
        arrayList2.add(new Model2("Onion-(kg)","price 56","1kg",R.drawable.bengan));
        arrayList2.add(new Model2("Beans-(kg)","price 56","1kg",R.drawable.matar));
        arrayList2.add(new Model2("Tomato-(kg)","price 56","1kg",R.drawable.tmatar));
        arrayList2.add(new Model2("chili-(kg)","price 56","1kg",R.drawable.shimlaa));
        arrayList2.add(new Model2("Onion-(kg)","price 56","1kg",R.drawable.piyaz));
        arrayList2.add(new Model2("Onion-(kg)","price 56","1kg",R.drawable.gobiii));
        arrayList2.add(new Model2("Onion-(kg)","price 56","1kg",R.drawable.gobiii));

        adapter4 = new Adapter4(getApplicationContext(), arrayList2);
        recycle.setAdapter(adapter4);
        GridLayoutManager layoutManagerrr = new GridLayoutManager(getApplicationContext(), 2);
        recycle.setLayoutManager(layoutManagerrr);



    }
    @Override
    public void onBackPressed() {
        // Add your custom code for back button press
        // For example, you can navigate to another activity or finish the current activity
        super.onBackPressed();
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    }
*/
