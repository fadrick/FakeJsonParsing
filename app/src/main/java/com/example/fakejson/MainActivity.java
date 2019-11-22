package com.example.fakejson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    RequestQueue requestQueue;
    private String TAG="Mainactivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView) findViewById(R.id.text);

        String url="https://jsonplaceholder.typicode.com/albums";

        final JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int i=0 ; i<response.length();i++ ){

                    try {
                        JSONObject jsonObject=response.getJSONObject(i);

                       // For debugging purposes Log.d(TAG, "onResponse: "+response);


                        String title=jsonObject.getString("title");
                        String id=jsonObject.getString("dasd");


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();

            }
        });

        RequestQueue requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);


    }
}
