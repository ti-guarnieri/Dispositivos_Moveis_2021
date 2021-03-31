package com.timi.dispositivosmoveis2021.detalhe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.timi.dispositivosmoveis2021.R;
import com.timi.dispositivosmoveis2021.model.Todo;

public class DetalheTodoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_todo);
        Intent intent = getIntent();
        Parcelable prc = intent.getParcelableExtra("objTodo");
        if (prc instanceof Todo)   { }
        Todo todo = intent.getParcelableExtra("objTodo");
        bind(todo);

    }
    public void trocaLayout(View v) {
        setContentView(R.layout.layout);
        Intent intent = getIntent();
        Todo todo = intent.getParcelableExtra("objTodo");
        bind(todo);
    }
    public void cbClick(View v) {
        CheckBox cb = findViewById(R.id.cbCompleted);
        Intent intent = getIntent();
        Todo todo = intent.getParcelableExtra("objTodo");
        todo.setCompleted(cb.isChecked());
    }
    private void bind(Todo obj) {
        TextView tv = findViewById(R.id.todoId);
        tv.setText(obj.getId()+"");
        tv = findViewById(R.id.todoUserId);
        tv.setText(obj.getUserId()+"");
        tv = findViewById(R.id.todoTitle);
        tv.setText(obj.getTitle()+"");
        CheckBox cb = findViewById(R.id.todoCbCompleted);
        cb.setChecked(obj.isCompleted());

    }
}