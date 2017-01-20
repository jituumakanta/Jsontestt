package com.example.jitu.jsontestt;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by jitu on 1/20/2017.
 */

public class zzz  {

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData9();
    }*/
    public Context c;
public void k(Context c){
    this.c=c;
}
    public  void getData9(String url) {
       // String url = Config.url;
        Log.d("nam", url);


// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String xml =response.toString();
                        Log.d("nam", xml);
                       Toast.makeText(c, response, Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
// Add the request to the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(c);
        queue.add(stringRequest);
        //return xml;
    }




    

}
