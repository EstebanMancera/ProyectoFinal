package com.proyectofinal.friendlyrestaurantv12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registro_usuario extends AppCompatActivity{
    Button btncrear, btncancelar;
    SQLDataBase dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_usuario);
        final SQLDataBase tiendaBD=new SQLDataBase(getApplicationContext());

        Bundle datos = getIntent().getExtras();

        final TextView titulo = (TextView)findViewById(R.id.textLista);
        final EditText cedula=(EditText)findViewById(R.id.txtCedulaRegis);
        final EditText correo=(EditText)findViewById(R.id.txtCorreoRegis);
        final EditText contraseña=(EditText)findViewById(R.id.txtContraseñaRegis);
        final EditText nombre=(EditText)findViewById(R.id.txtNombreRegis);
        final EditText apellido=(EditText)findViewById(R.id.txtApellidoRegis);
        final EditText direccion=(EditText)findViewById(R.id.txtDireccionRegis);
        final EditText celular=(EditText)findViewById(R.id.txtCelularRegis);

        btncrear=(Button)findViewById(R.id.btncrear);
        btncancelar=(Button)findViewById(R.id.btncancelar);



        if(datos==null){
            titulo.setText("Nuevo Usuario");
            btncrear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(cedula.getText().toString().isEmpty()){
                        cedula.setError("Ingrese la cedula");
                        cedula.requestFocus();
                        return;
                    }
                    if(correo.getText().toString().isEmpty()){
                        correo.setError("Ingrese el correo");
                        correo.requestFocus();
                        return;
                    }
                    if(contraseña.getText().toString().isEmpty()){
                        contraseña.setError("Ingrese la contraseña");
                        contraseña.requestFocus();
                        return;
                    }
                    if(nombre.getText().toString().isEmpty()){
                        nombre.setError("Ingrese el nombre");
                        nombre.requestFocus();
                        return;
                    }
                    if(apellido.getText().toString().isEmpty()){
                        apellido.setError("Ingrese el apellido");
                        apellido.requestFocus();
                        return;
                    }
                    if(direccion.getText().toString().isEmpty()){
                        direccion.setError("Ingrese la direccion");
                        direccion.requestFocus();
                        return;
                    }

                    if(celular.getText().toString().isEmpty()){
                        celular.setError("Ingrese el celular");
                        celular.requestFocus();
                        return;
                    }

                    Usuario c = new Usuario(cedula.getText().toString(), correo.getText().toString(), contraseña.getText().toString(), nombre.getText().toString(), apellido.getText().toString(), direccion.getText().toString(), Integer.valueOf(celular.getText().toString()));

                    if (tiendaBD.insertarUsuario(c) == null) {
                        Toast.makeText(getApplicationContext(), "Guardado", Toast.LENGTH_SHORT);
                        finish();
                        return;
                    } else {
                        Toast.makeText(getApplicationContext(), tiendaBD.insertarUsuario(c), Toast.LENGTH_SHORT);
                    }


                }
            });


        }else{
            btncrear.setText("Editar");
            titulo.setText("Editar cliente");
            String cedula1 = datos.getString("cedula");
            String correo1 = datos.getString("correo");
            String contraseña1 = datos.getString("contraseña");
            String nombre1 = datos.getString("nombre");
            String apellido1 = datos.getString("apellido");
            String direccion1 = datos.getString("direccion");
            String celular1 = datos.getString("celular");
            cedula.setText(cedula1);
            cedula.setEnabled(false);
            correo.setText(correo1);
            contraseña.setText(contraseña1);
            nombre.setText(nombre1);
            apellido.setText(apellido1);
            direccion.setText(direccion1);
            celular.setText(celular1);
            btncrear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Usuario c = new Usuario(cedula.getText().toString(), correo.getText().toString(), contraseña.getText().toString(), nombre.getText().toString(), apellido.getText().toString(), direccion.getText().toString(), Integer.valueOf(celular.getText().toString()));


                    if (tiendaBD.editar(c) == null) {
                        Toast.makeText(getApplicationContext(), "Cambios realizados", Toast.LENGTH_SHORT);
                        finish();
                        return;
                    } else {
                        Toast.makeText(getApplicationContext(), tiendaBD.editar(c), Toast.LENGTH_SHORT);
                    }
                }
            });
        }

    }
/*
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btncrear:
                Usuario u = new Usuario();
                u.setCedula(cedula.getText().toString());
                u.setCorreo(correo.getText().toString());
                u.setContraseña(contraseña.getText().toString());
                u.setNombre(nombre.getText().toString());
                u.setApellido(apellido.getText().toString());
                u.setDireccion(direccion.getText().toString());
                u.setCelular(Integer.valueOf(celular.getText().toString()));
                //cliente.setLimiteCredito(Double.valueOf(limiteCredito.getText().toString()));
                if (!u.isNull()){
                    Toast.makeText(this,"ERROR: Campos vacios", Toast.LENGTH_LONG).show();
                }else if(dao.insertarUsuario(u)){
                    Toast.makeText(this,"REGISTRO EXITOSO", Toast.LENGTH_LONG).show();
                    Intent i2= new Intent(registro_usuario.this,MainActivity.class);
                    startActivity(i2);
                    finish();
                }else{
                    Toast.makeText(this,"USUARIO EXISTENTE", Toast.LENGTH_LONG).show();
                }

                /*
                Intent i2= new Intent(registro_usuario.this,MainActivity.class);
                startActivity(i2);*//*
                break;
            case R.id.btncancelar:
                Intent i= new Intent(registro_usuario.this, MainActivity.class);
                startActivity(i);
                break;
        }
    }*/
}