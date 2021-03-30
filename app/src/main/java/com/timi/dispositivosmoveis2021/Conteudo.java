package com.timi.dispositivosmoveis2021;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.timi.dispositivosmoveis2021.model.Photos;
import com.timi.dispositivosmoveis2021.ui.DetalheActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Conteudo extends AppCompatActivity
    implements Response.Listener<JSONArray>,
    Response.ErrorListener{

    List<Photos> todos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteudo);
        TextView tv = (TextView) findViewById(R.id.textoConteudo);
        Intent it = getIntent();
        String txt = it.getStringExtra("nome");
        Pessoa pes = it.getParcelableExtra("objPessoa");
        tv.setText(txt);

        RequestQueue queue = Volley.newRequestQueue(this);
        String urlPhotos = "https://jsonplaceholder.typicode.com/photos";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlPhotos,null,
                                this, this);

        queue.add(jsonArrayRequest);
        Toast.makeText(this,"qtd"+todos.size(),Toast.LENGTH_LONG).show();
    }



    @Override
    public void onResponse(JSONArray response) {
        try {

            for(int i = 0; i < response.length(); i++) {
                JSONObject json = response.getJSONObject(i);
                Photos obj = new Photos(json.getInt("albumId"),
                        json.getInt("id"),
                        json.getString("title"),
                        json.getString("url"),
                        json.getString("thumbnailUrl"));
                todos.add(obj);

            }
            Toast.makeText(this,"qtd:"+todos.size(),Toast.LENGTH_LONG).show();
            LinearLayout ll = findViewById(R.id.layoutVerticalItens);
            for(Photos obj1 : todos) {
                Button bt = new Button(this);
                bt.setText(obj1.getTitle());
                bt.setTag(obj1);
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Button btn = (Button) v;
                        Photos photo = (Photos) btn.getTag();

                        Intent intent = new Intent(getApplicationContext(), DetalheActivity.class);

                        // adicional para incluir dados para a proxima activity
                        intent.putExtra("objTodo", photo);
                        // lança intent para o SO chamar a activity
                        startActivity(intent);
                        //Toast.makeText(v.getContext(),todo.getId()+" - "+todo.getTitle(),Toast.LENGTH_LONG).show();
                    }
                });
                ll.addView(bt);
            }


        }catch (JSONException e) {
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