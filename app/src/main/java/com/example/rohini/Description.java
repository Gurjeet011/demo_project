package com.example.rohini;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Description extends AppCompatActivity {
    RequestQueue queue1;
    ArrayList<Modelclass> arrayList;
    Descriptionadapter descriptionadapter;
    ImageView imageView;
    TextView textView1,textView2,textView3,textView4;
     SliderView slider;
    String getidw;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        getidw = getIntent().getStringExtra("idd");
        imageView=findViewById(R.id.disimg);
        textView1=findViewById(R.id.modern);
        textView2=findViewById(R.id.oriprice);
        textView3=findViewById(R.id.cutprice);
        textView4=findViewById(R.id.pd);
        slider = findViewById(R.id.slidervieww);

        queue1 = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequestm = new StringRequest(Request.Method.POST, "https://www.websunindia.com/demo/bornto/api/product_detail", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("kjfhurseg", response);
                Toast.makeText(Description.this, "nnnnnnnnnnn" + response, Toast.LENGTH_SHORT).show();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String get_status = jsonObject.getString("status");
                    if (get_status.equals("true")) {
                        arrayList = new ArrayList<>();
                        String get_data = jsonObject.getString("data");
                        JSONArray jsonArray = new JSONArray(get_data);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObjectt = jsonArray.getJSONObject(i);
                            String ii = jsonObjectt.getString("images");

                            String mrpp = jsonObjectt.getString("mrp");
                            String sal = jsonObjectt.getString("sale");

                            JSONArray jsonArray1 = new JSONArray(ii);

                            Log.d("skdjsara",ii);
                            for (int i1=0;i1<jsonArray1.length();i1++){
                                String get_img = jsonArray1.getString(i1);

                                Log.d("asdhhA",get_img);
                                Modelclass modelclass = new Modelclass();
                                modelclass.setImg(get_img);
                                arrayList.add(modelclass);




                              JSONArray jsonArray2= new JSONArray(mrpp);
                                for( int i2=0;i2<jsonArray2.length();i2++){

                                    String get_price = jsonArray2.getString(i2);
                                    textView2.setText("₹"+get_price);
                                }

                                JSONArray jsonArray3= new JSONArray(sal);
                                for( int i3=0;i3<jsonArray3.length();i3++){

                                    String get_sale = jsonArray3.getString(i3);
                                   textView3.setText("₹"+get_sale);
                                }





                            }

                            String nam = jsonObjectt.getString("product_name");
                            textView1.setText(nam);


                            String dis = jsonObjectt.getString("description");
                            textView4.setText(Html.fromHtml(dis));




                        }
                        descriptionadapter = new Descriptionadapter(getApplicationContext(), arrayList);
                        slider.setSliderAdapter(descriptionadapter);
                        slider.setScrollTimeInSec(2);
                        slider.setAutoCycle(true);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Description.this, "llllll" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();

                params.put("pid", getidw);


                return params;
            }
        };
        queue1.add(stringRequestm);

    }

}

