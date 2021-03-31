package com.timi.dispositivosmoveis2021.detalhe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.timi.dispositivosmoveis2021.R;
import com.timi.dispositivosmoveis2021.model.Comments;

public class DetalheCommentsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_comments);
        Intent intent = getIntent();
        Parcelable prc = intent.getParcelableExtra("objComments");
        if (prc instanceof Comments) { }
        Comments comments = intent.getParcelableExtra("objComments");
        bind(comments);
    }

    public void trocaLayout(View v) {
        setContentView(R.layout.layout);
        Intent intent = getIntent();
        Comments comments = intent.getParcelableExtra("objComments");
        bind(comments);
    }

    private void bind(Comments obj) {
        TextView
        tv = findViewById(R.id.commentsName);
        tv.setText(obj.getName()+"");
        tv = findViewById(R.id.commentsID);
        tv.setText(obj.getId()+"");
        tv = findViewById(R.id.commentsPostId);
        tv.setText(obj.getPostId()+"");
        tv = findViewById(R.id.commentsEmail);
        tv.setText(obj.getEmail()+"");
        tv = findViewById(R.id.commentsBody);
        tv.setText(obj.getBody()+"");


    }
}