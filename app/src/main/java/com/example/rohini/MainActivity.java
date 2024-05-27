package com.example.rohini;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.smarteist.autoimageslider.SliderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView,recyclerView2,recyclerView3,recyclerView4;
    Adapter adapter;
    Adaptergrid adaptergrid;
    Adaptergrid2 adaptergrid2;
    Adaptergrid3 adaptergrid3;
    Slideradapter slideradapter;
    ArrayList<Modelclass> arrayList;
    SliderView sliderView;
    RequestQueue queue,queue1,queue2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rr1);
        recyclerView2 = findViewById(R.id.r2);
        recyclerView3 = findViewById(R.id.r3);
        recyclerView4 = findViewById(R.id.r4);

        queue1 = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest1 = new StringRequest(Request.Method.GET, "https://www.websunindia.com/demo/bornto/api/navbar", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                arrayList = new ArrayList<>();
                Toast.makeText(MainActivity.this, "gggg" + response, Toast.LENGTH_SHORT).show();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String get_status = jsonObject.getString("status");
                    if (get_status.equals("true")) {
                        String get_data = jsonObject.getString("data");
                        JSONArray jsonArray = new JSONArray(get_data);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject10 = jsonArray.getJSONObject(i);
                            String id = jsonObject10.getString("id");
                            String imgge = jsonObject10.getString("category_image");
                            String txt = jsonObject10.getString("category_name");

                            Modelclass modelclass = new Modelclass();
                            modelclass.setId(id);
                            modelclass.setCat_img(imgge);
                            modelclass.setName(txt);

                            arrayList.add(modelclass);
                        }
                    }

                    adapter = new Adapter(MainActivity.this, arrayList);
                    recyclerView.setAdapter(adapter);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false);
                    recyclerView.setLayoutManager(layoutManager);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "error" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



// Move this line outside of onResponse block


        queue = Volley.newRequestQueue(getApplicationContext());
        sliderView = findViewById(R.id.sliderview);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://www.websunindia.com/demo/bornto/api/slider", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                arrayList = new ArrayList<>();
                //   Toast.makeText(MainActivity.this, "responce" + response, Toast.LENGTH_SHORT).show();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String get_status = jsonObject.getString("status");
                    if (get_status.equals("true")) {
                        String get_data = jsonObject.getString("data");
                        JSONArray jsonArray = new JSONArray(get_data);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            String imgg = jsonObject1.getString("image");
                            Modelclass modelclass = new Modelclass();
                            modelclass.setImg(imgg);
                            arrayList.add(modelclass);
                        }
                    }
                    slideradapter = new Slideradapter(MainActivity.this, arrayList);
                    sliderView.setSliderAdapter(slideradapter);
                    sliderView.setScrollTimeInSec(2);
                    sliderView.setAutoCycle(true);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
             //   Toast.makeText(MainActivity.this, "error" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

// Move this line outside of onResponse block

        queue2 = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest11 = new StringRequest(Request.Method.GET, "https://www.websunindia.com/demo/bornto/api/home_page", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    arrayList = new ArrayList<>();
                   // Toast.makeText(MainActivity.this, "gggg" + response, Toast.LENGTH_SHORT).show();
                    JSONObject jsonObject = new JSONObject(response);
                    String get_status = jsonObject.getString("status");

                    if (get_status.equals("true")) {
                        if (jsonObject.has("data")) {
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            ArrayList<Modelclass> arrayList = new ArrayList<>();
                            ArrayList<Modelclass> arrayList1 = new ArrayList<>();
                            ArrayList<Modelclass> arrayList2 = new ArrayList<>();
                            // Fetching data from position 0
                            if (jsonArray.length() > 0) {
                                JSONObject jsonObject101 = jsonArray.getJSONObject(0);

                                if (jsonObject101.has("sub_category")) {
                                    JSONArray subcategory = jsonObject101.getJSONArray("sub_category");
                                    for (int j = 0; j < subcategory.length(); j++) {
                                        String subcategoryItem = subcategory.getString(j);
                                        Modelclass modelclass = new Modelclass();
                                        modelclass.setName(subcategoryItem);

                                        if (jsonObject101.has("pro_image")) {
                                            JSONArray proImageArray = jsonObject101.getJSONArray("pro_image");
                                            if (proImageArray.length() > j) {
                                                String proImage = proImageArray.getString(j);
                                                modelclass.setCat_img(proImage);
                                            }
                                        }
                                        if (jsonObject101.has("dis_price")) {
                                            JSONArray disPriceArray = jsonObject101.getJSONArray("dis_price");
                                            if (disPriceArray.length() > j) {
                                                String price = disPriceArray.getString(j);
                                                modelclass.setName2(price);
                                            }
                                        }
                                        arrayList.add(modelclass);
                                    }


                                    adaptergrid = new Adaptergrid(getApplicationContext(), arrayList);
                                    recyclerView2.setAdapter(adaptergrid);
                                    GridLayoutManager layoutManagerrzn = new GridLayoutManager(getApplicationContext(), 2);
                                    recyclerView2.setLayoutManager(layoutManagerrzn);
                                }
                            }
// Fetching data from position 1
                            if (jsonArray.length() > 1) {
                                JSONObject jsonObject2 = jsonArray.getJSONObject(1);
                                if (jsonObject2.has("sub_category")) {
                                    JSONArray subcategory2 = jsonObject2.getJSONArray("sub_category");
                                   // ArrayList<Modelclass> arrayList2 = new ArrayList<>(); // Create a new list for position 1 data
                                    for (int k = 0; k < subcategory2.length(); k++) {
                                        String subcategoryItem2 = subcategory2.getString(k);
                                        Modelclass modelclass2 = new Modelclass();
                                        modelclass2.setName(subcategoryItem2);


                                        if (jsonObject2.has("pro_image")) {
                                            JSONArray proImageArray = jsonObject2.getJSONArray("pro_image");
                                            if (proImageArray.length() > k) {
                                                String proImage = proImageArray.getString(k);
                                                modelclass2.setCat_img(proImage);
                                            }
                                        }
                                        if (jsonObject2.has("dis_price")) {
                                            JSONArray disPriceArray = jsonObject2.getJSONArray("dis_price");
                                            if (disPriceArray.length() > k) {
                                                String price = disPriceArray.getString(k);
                                                modelclass2.setName2(price);
                                            }
                                        }
                                        // Add additional logic for pro_image and dis_price if needed
                                        arrayList1.add(modelclass2);
                                    }

                                    adaptergrid2 = new Adaptergrid2(getApplicationContext(), arrayList1);
                                    recyclerView3.setAdapter(adaptergrid2);
                                    GridLayoutManager layoutManagerrznm = new GridLayoutManager(getApplicationContext(), 2);
                                    recyclerView3.setLayoutManager(layoutManagerrznm);
                                }
                            }

                            // Fetching data from position 2
                            if (jsonArray.length() > 2) {
                                JSONObject jsonObject3 = jsonArray.getJSONObject(2);
                                if (jsonObject3.has("sub_category")) {
                                    JSONArray subcategory3 = jsonObject3.getJSONArray("sub_category");
                                   // ArrayList<Modelclass> arrayList2 = new ArrayList<>(); // Create a new list for position 1 data
                                    for (int k = 0; k < subcategory3.length(); k++) {
                                        String subcategoryItem2 = subcategory3.getString(k);
                                        Modelclass modelclass3 = new Modelclass();
                                        modelclass3.setName(subcategoryItem2);


                                        if (jsonObject3.has("pro_image")) {
                                            JSONArray proImageArray = jsonObject3.getJSONArray("pro_image");
                                            if (proImageArray.length() > k) {
                                                String proImage = proImageArray.getString(k);
                                                modelclass3.setCat_img(proImage);
                                            }
                                        }
                                        if (jsonObject3.has("dis_price")) {
                                            JSONArray disPriceArray = jsonObject3.getJSONArray("dis_price");
                                            if (disPriceArray.length() > k) {
                                                String price = disPriceArray.getString(k);
                                                modelclass3.setName2(price);
                                            }
                                        }
                                        // Add additional logic for pro_image and dis_price if needed
                                        arrayList2.add(modelclass3);
                                    }

                                    adaptergrid3 = new Adaptergrid3(getApplicationContext(), arrayList2);
                                    recyclerView4.setAdapter(adaptergrid3);
                                    GridLayoutManager layoutManagerrznmm = new GridLayoutManager(getApplicationContext(), 2);
                                    recyclerView4.setLayoutManager(layoutManagerrznmm);

                                }
                            }

                        }
                    }




                } catch (
                        JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               // Toast.makeText(MainActivity.this, "error" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        queue.add(stringRequest);
        queue1.add(stringRequest1);
        queue2.add(stringRequest11);

    }
}