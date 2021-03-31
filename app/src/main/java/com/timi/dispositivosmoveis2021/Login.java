package com.timi.dispositivosmoveis2021;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.timi.dispositivosmoveis2021.ui.PhotoActivity;

public class Login extends AppCompatActivity {

    private EditText edUser = null;
    private EditText edSenha = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Faça o Login");
        setContentView(R.layout.activity_login);
        edUser = (EditText) findViewById(R.id.activity_login_user);
        edSenha = (EditText) findViewById(R.id.activity_login_senha);
    }

    public void onClick1 (View view){
        validaUser();
    }

    private void validaUser (){
        String user = edUser.getText().toString();
        String senha = edSenha.getText().toString();

       if (user.equals(senha)){
           Intent conteudo = new Intent( this, PhotoActivity.class);
           startActivity(conteudo);

        } else if (user != senha){
           edSenha.requestFocus();
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
           dlg.setTitle("Aviso");
           dlg.setMessage("Usuario e senha devem ser iguais!");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }
    }
}
