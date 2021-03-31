package com.timi.dispositivosmoveis2021.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.timi.dispositivosmoveis2021.R;
import com.timi.dispositivosmoveis2021.model.Posts;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PostsActivity extends AppCompatActivity
                           implements Response.Listener<JSONArray>,
                                      Response.ErrorListener{

    List<Posts> todos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        RequestQueue queue = Volley.newRequestQueue(this);
        String urlPosts = "https://jsonplaceholder.typicode.com/posts";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlPosts,
                                               null,this, this);
        queue.add(jsonArrayRequest);
        Toast.makeText(this,"qtd"+todos.size(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONArray response) {
        try {
            for(int i = 0; i < response.length(); i++) {
                JSONObject json = response.getJSONObject(i);
                Posts posts = new Posts(
                        json.getInt("userId"),
                        json.getInt("id"),
                        json.getString("title"),
                        json.getString("body"));
                todos.add(posts);
            }

        } catch (JSONException e) {
            Log.e("erro",e.getMessage());
            e.printStackTrace();
        }
    }
        @Override
    public void onErrorResponse(VolleyError error) {
            String msg = error.getMessage();
            Toast.makeText(this.getApplicationContext(),"deu erro: "+msg,Toast.LENGTH_LONG).show();
    }
}