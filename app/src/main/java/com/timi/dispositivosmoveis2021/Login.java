package com.timi.dispositivosmoveis2021;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private EditText edUser = null;
    private EditText edSenha = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUser = (EditText)findViewById(R.id.activity_login_user);
        edSenha = (EditText)findViewById(R.id.activity_login_senha);

    }

    public void onClick1 (View view){
        valida_user();
    }

    public void valida_user (){
        String user = edUser.getText().toString();
        String senha = edSenha.getText().toString();

        if (user == null){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Aviso");
            dlg.setMessage("Usuario deve ser preenchido!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        } else if (senha == null){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Aviso");
            dlg.setMessage("Senha deve ser preenchida!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        } else if (user == senha){
            Intent conteudo = new Intent( this, Conteudo.class);
            startActivity(conteudo);
        }
    }
}