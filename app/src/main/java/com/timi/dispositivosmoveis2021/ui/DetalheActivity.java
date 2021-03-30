package com.timi.dispositivosmoveis2021.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.timi.dispositivosmoveis2021.Pessoa;
import com.timi.dispositivosmoveis2021.R;
import com.timi.dispositivosmoveis2021.model.Photos;

public class DetalheActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);
        Intent intent = getIntent();
        Parcelable prc = intent.getParcelableExtra("objPhoto");
        if (prc instanceof Photos) {

        }
        if (prc instanceof Pessoa) {

        }
        Photos photo = intent.getParcelableExtra("objPhoto");
        bind(photo);

    }
    public void trocaLayout(View v) {
        setContentView(R.layout.layout);
        Intent intent = getIntent();
        Photos photo = intent.getParcelableExtra("objPhoto");
        bind(photo);

    }

    private void bind(Photos obj) {
        TextView tv = findViewById(R.id.tvId1);
        tv.setText(obj.getId()+"");
        tv = findViewById(R.id.tvIdUser);
        tv.setText(obj.getAlbumId()+"");
        tv = findViewById(R.id.tvId2);
        tv.setText(obj.getTitle());
        tv = findViewById(R.id.tvTitle);
        tv.setText(obj.getUrl()+"");
        tv = findViewById(R.id.url);
        tv.setText(obj.getUrl()+"");
        tv = findViewById(R.id.thumbUrl);


    }
}