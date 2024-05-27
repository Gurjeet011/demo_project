package com.example.rohini;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class    Flowers extends AppCompatActivity {
    RecyclerView recyclerView,recyclerView2;
    Floweradapter floweradapter;
    Floweradapter2 floweradapter2;
    ArrayList<Modelclass> arrayList,arrayList2;
    RequestQueue queue1,queue2;
    ProgressBar progressBar;

    String get_id ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowers);

        recyclerView = findViewById(R.id.rv1);
        recyclerView2 = findViewById(R.id.rv2);
        progressBar = findViewById(R.id.progressBar);
        arrayList = new ArrayList<>();

        get_id = getIntent().getStringExtra("ids");
        queue1 = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequestt = new StringRequest(Request.Method.POST, "https://www.websunindia.com/demo/bornto/api/sub_navbar", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("sahrhash", response);
                //  Toast.makeText(Flowers.this, "nnnnnnnnnnn" + response, Toast.LENGTH_SHORT).show();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String get_status = jsonObject.getString("status");
                    if (get_status.equals("true")) {
                        String get_data = jsonObject.getString("data");
                        JSONArray jsonArray = new JSONArray(get_data);

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObjectt = jsonArray.getJSONObject(i);
                            String imggez = jsonObjectt.getString("images");
                            String txtz = jsonObjectt.getString("subcat_name");
                            String id1 = jsonObjectt.getString("id");
                            String id2 = jsonObjectt.getString("maincat_id");
                            Modelclass modelclass = new Modelclass();
                            modelclass.setCat_img(imggez);
                            modelclass.setId(id1);
                            modelclass.setId2(id2);
                            Toast.makeText(Flowers.this, modelclass.getId2() + "", Toast.LENGTH_SHORT).show();

                            Log.d("sdjahe", imggez);
                            modelclass.setName(txtz);
                            arrayList.add(modelclass);
                        }
                    }
                    floweradapter = new Floweradapter(getApplicationContext(), arrayList);
                    recyclerView.setAdapter(floweradapter);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false);
                    recyclerView.setLayoutManager(layoutManager);
                    progressBar.setVisibility(View.GONE);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //  Toast.makeText(Flowers.this, "llllll" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("id", get_id);

                return params;
            }
        };
        arrayList2 = new ArrayList<>();
        queue2 = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequesttt = new StringRequest(Request.Method.POST, "https://www.websunindia.com/demo/bornto/api/main_navproduct", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("sahrhash", response);
                // Toast.makeText(Flowers.this, "nnnnnnnnnnn" + response, Toast.LENGTH_SHORT).show();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String get_status = jsonObject.getString("status");
                    if (get_status.equals("true")) {
                        String get_data = jsonObject.getString("data");
                        JSONArray jsonArray = new JSONArray(get_data);

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObjectt = jsonArray.getJSONObject(i);
                            String imggez = jsonObjectt.getString("img");
                            String txtza = jsonObjectt.getString("product_name");
                            String txtzb = jsonObjectt.getString("sale");
                            String txtzc = jsonObjectt.getString("mrp");
                            String txtzd = jsonObjectt.getString("discount");

                            Modelclass modelclass = new Modelclass();
                            modelclass.setCat_img(imggez);
                            Log.d("sdjahe", imggez);
                            modelclass.setName(txtza);
                            modelclass.setN1(txtzb);
                            modelclass.setN2(txtzc);
                            modelclass.setN3(txtzd);

                            arrayList2.add(modelclass);
                        }
                    }
                    floweradapter2 = new Floweradapter2(getApplicationContext(), arrayList2);
                    recyclerView2.setAdapter(floweradapter2);
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
                    recyclerView2.setLayoutManager(gridLayoutManager);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //    Toast.makeText(Flowers.this, "llllll" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("mid", get_id);
                return params;
            }
        };

        queue1.add(stringRequestt);
        queue2.add(stringRequesttt);


    }
}


