package com.proyectofinal.friendlyrestaurantv12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class inicio extends AppCompatActivity implements View.OnClickListener {

    Button btnmostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
        btnmostrar=(Button)findViewById(R.id.btn_mostrar);
        btnmostrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_mostrar:

                Intent i= new Intent(inicio.this, lista_usuarios.class);
                startActivity(i);

                break;
            case R.id.btnregistrar:
                Intent i2= new Intent(inicio.this, registro_usuario.class);
                startActivity(i2);
                break;
        }

    }
}