package com.example.jitu.jsontestt;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    AutoCompleteTextView actv;
    List<String> students;
    ImageView mImageView;
    //private JSONArray result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        students = new ArrayList<String>();
        mImageView = (ImageView) findViewById(R.id.myImage);
         final String url = "http://api.androidhive.info/pizza/?format=xml";
         //getData8(url);
        //getData6();

        zzz x=new zzz();
        x.k(this);
       x.getData9(url);

       // Intent i = new Intent(getApplicationContext(), zzz.class);
       // startActivity(i);
    }



   /* private void getData() {
        //Creating a string request
        StringRequest stringRequest = new StringRequest(Config.DATA_URL3,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject j;
                        try {
                            //Parsing the fetched Json String to JSON Object
                            j = new JSONObject(response);
                            //Storing the Array of JSON String to our JSON Array
                            result = j.getJSONArray(Config.JSON_ARRAY);
                            Toast.makeText(MainActivity.this, "fgdgdf"+result, Toast.LENGTH_LONG).show();
                            //Calling method getStudents to get the students from the JSON Array
                            getStudents(result);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        //Creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //Adding request to the queue
        requestQueue.add(stringRequest);
    }

    private void getStudents(JSONArray j) {
        //Traversing through all the items in the json array
        for (int i = 0; i < j.length(); i++) {
            try {
                //Getting json object
                JSONObject json = j.getJSONObject(i);

                //Adding the name of the student to array list
                students.add(json.getString(Config.TAG_USERNAME));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        actv.setThreshold(1);
        actv.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.select_dialog_item, students));
    }*/


    private void getData1() {
        //Creating a string request
        StringRequest stringRequest = new StringRequest(Config.DATA_URL5, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONArray j;
                try {
                    //Parsing the fetched Json String to JSON Object
                    j = new JSONArray(response);
                    //Storing the Array of JSON String to our JSON Array
                    // result = j.getJSONArray(Config.JSON_ARRAY);
                    Toast.makeText(MainActivity.this, "" + j, Toast.LENGTH_LONG).show();
                    //Calling method getStudents to get the students from the JSON Array
                    getStudents1(j);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        //Creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //Adding request to the queue
        requestQueue.add(stringRequest);
    }

    public void getData8(String url){

        RequestQueue queue = Volley.newRequestQueue(this);

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //xml =response.toString();
                        Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
        //return xml;
    }

    private void getStudents1(JSONArray j) {
        //Traversing through all the items in the json array
        for (int i = 0; i < j.length(); i++) {
            try {
                //Getting json object
                JSONObject json = j.getJSONObject(i);

                //Adding the name of the student to array list
                students.add(json.getString(Config.TAG_USERNAME));

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        String[] array = students.toArray(new String[students.size()]);
        Toast.makeText(MainActivity.this, "dddd" + array[2], Toast.LENGTH_LONG).show();

        actv.setThreshold(1);
        actv.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.select_dialog_item, students));
    }

    public void getData2() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://www.google.com";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this, "" + response.substring(0, 500), Toast.LENGTH_LONG).show();

                        // Display the first 500 characters of the response string.
                        // mTextView.setText("Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // mTextView.setText("That didn't work!");
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    private void getData3() {
        //Creating a string request
        RequestQueue mRequestQueue;

// Instantiate the cache
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap

// Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());

// Instantiate the RequestQueue with the cache and network.
        mRequestQueue = new RequestQueue(cache, network);

// Start the queue
        mRequestQueue.start();

        String url = "http://hellohelps.com/HelloHelps/getarea.php";

// Formulate the request and handle the response.
        JsonArrayRequest jsObjRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    JSONArray j;

                    @Override
                    public void onResponse(JSONArray response) {
                        // Do something with the response
                        j = response;
                        //Storing the Array of JSON String to our JSON Array
                        // result = j.getJSONArray(Config.JSON_ARRAY);
                        Toast.makeText(MainActivity.this, "" + j, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                    }
                });

// Add the request to the RequestQueue.
        mRequestQueue.add(jsObjRequest);
    }

    //jsonarray request
    private void getData4() {
        //Creating a string request
        JsonArrayRequest jsObjRequest = new JsonArrayRequest(Config.DATA_URL5, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONArray j;
                //Parsing the fetched Json String to JSON Object
                j = response;
                //Storing the Array of JSON String to our JSON Array
                // result = j.getJSONArray(Config.JSON_ARRAY);
                Toast.makeText(MainActivity.this, "" + j, Toast.LENGTH_LONG).show();
                //Calling method getStudents to get the students from the JSON Array
                // getStudents1(j);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        //Creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //Adding request to the queue
        requestQueue.add(jsObjRequest);
    }

    private void getData5() {
        //Creating a string request
        JsonArrayRequest jsObjRequest = new JsonArrayRequest(Config.DATA_URL5, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONArray j;
                //Parsing the fetched Json String to JSON Object
                j = response;
                //Storing the Array of JSON String to our JSON Array
                // result = j.getJSONArray(Config.JSON_ARRAY);
                Toast.makeText(MainActivity.this, "" + j, Toast.LENGTH_LONG).show();
                //Calling method getStudents to get the students from the JSON Array
                // getStudents1(j);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        //Creating a request queue

        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);
    }
    //get image using volley
    private void getData6() {
        String url = "http://androidtutorialpoint.com/api/lg_nexus_5x";
        ImageRequest request = new ImageRequest(url,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        mImageView.setImageBitmap(bitmap);
                    }
                }, 0, 0, null,
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        mImageView.setImageResource(R.drawable.image_load_error);
                    }
                });
// Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(request);
    }
    //get json object

}
