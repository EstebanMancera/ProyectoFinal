package com.proyectofinal.friendlyrestaurantv12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText usuario, contraseña;
    Button btnentrar, btnregistrar;
    SQLDataBase dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario=(EditText)findViewById(R.id.txtUsuario);
        contraseña=(EditText)findViewById(R.id.txtContraseña);
        btnentrar=(Button)findViewById(R.id.btnentrar);
        btnregistrar=(Button)findViewById(R.id.btnregistrar);
        btnentrar.setOnClickListener(this);
        btnregistrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnentrar:/*
                String u= usuario.getText().toString();
                String p= contraseña.getText().toString();
                if(u.equals("")&&p.equals("")){
                    Toast.makeText(this, "ERROR: Campos vacios", Toast.LENGTH_SHORT).show();
                } else if(dao.login(u,p)==1){
                    Usuario ux = dao.getUsuario(u,p);
                    Toast.makeText(this, "Datos correctos", Toast.LENGTH_SHORT).show();
                    Intent i2= new Intent(MainActivity.this,inicio.class);
                    i2.putExtra("id", ux.getId());
                    startActivity(i2);
                }else{
                    Toast.makeText(this, "Usuario y/o Contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }*/

                Intent i2= new Intent(MainActivity.this,inicio.class);
                startActivity(i2);
                break;
            case R.id.btnregistrar:
                Intent i= new Intent(MainActivity.this, registro_usuario.class);
                startActivity(i);
                break;
        }

    }
}