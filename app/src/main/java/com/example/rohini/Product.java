package com.example.rohini;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
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

public class Product extends AppCompatActivity {
    RecyclerView recyclerViewp;
    Productadapter productadapter;
    RequestQueue queue1;
    ArrayList<Modelclass>arrayList;
    String getid1,getid2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        recyclerViewp=findViewById(R.id.rvp);

        getid1 = getIntent().getStringExtra("id1");
        getid2 = getIntent().getStringExtra("id2");


        arrayList = new ArrayList<>();
        queue1 = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequestm = new StringRequest(Request.Method.POST, "https://www.websunindia.com/demo/bornto/api/sub_navproduct", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("kjfhurseg", response);
                Toast.makeText(Product.this, "nnnnnnnnnnn" + response, Toast.LENGTH_SHORT).show();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String get_status = jsonObject.getString("status");
                    if (get_status.equals("true")) {
                        String get_data = jsonObject.getString("data");
                        JSONArray jsonArray = new JSONArray(get_data);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObjectt = jsonArray.getJSONObject(i);
                            String ii = jsonObjectt.getString("images");
                            String n = jsonObjectt.getString("product_name");
                            String s = jsonObjectt.getString("sale");
                            String m = jsonObjectt.getString("mrp");
                            String d = jsonObjectt.getString("discount");
                            String id3= jsonObjectt.getString("id");



                            Modelclass modelclass = new Modelclass();
                            modelclass.setCat_img(ii);
                            Log.d("sdjahe",ii);
                            modelclass.setName(n);
                            modelclass.setN1(s);
                            modelclass.setN2(m);
                            modelclass.setN3(d);
                            modelclass.setId(id3);

                            arrayList.add(modelclass);
                        }
                    }
                    productadapter = new Productadapter(getApplicationContext(), arrayList);
                    recyclerViewp.setAdapter(productadapter);
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
                    recyclerViewp.setLayoutManager(gridLayoutManager);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Product.this, "llllll" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();

                params.put("mid", getid2);
                params.put("sid", getid1);
                return params;
            }
        };
        queue1.add(stringRequestm);

    }

}
