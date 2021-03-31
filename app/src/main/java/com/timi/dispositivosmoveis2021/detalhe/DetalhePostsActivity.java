package com.timi.dispositivosmoveis2021.detalhe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.timi.dispositivosmoveis2021.R;
import com.timi.dispositivosmoveis2021.model.Posts;

public class DetalhePostsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_posts);
        Intent intent = getIntent();
        Parcelable prc = intent.getParcelableExtra("objPosts");
        if (prc instanceof Posts) { }
        Posts posts = intent.getParcelableExtra("objPosts");
        bind(posts);
    }

    public void trocaLayout(View v) {
        setContentView(R.layout.layout);
        Intent intent = getIntent();
        Posts posts = intent.getParcelableExtra("objPosts");
        bind(posts);
    }

    private void bind(Posts obj) {
        TextView
        tv = findViewById(R.id.postsId);
        tv.setText(obj.getId()+"");
        tv = findViewById(R.id.postsUserId);
        tv.setText(obj.getUserId()+"");
        tv = findViewById(R.id.postsTitle);
        tv.setText(obj.getTitle()+"");
        tv = findViewById(R.id.postsBody);
        tv.setText(obj.getBody()+"");
    }
}