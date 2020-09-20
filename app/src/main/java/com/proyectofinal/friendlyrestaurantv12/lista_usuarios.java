package com.proyectofinal.friendlyrestaurantv12;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class lista_usuarios extends AppCompatActivity {
    ListView lista;
    SQLDataBase dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_usuarios);


        final SQLDataBase tiendaDB=new SQLDataBase(getApplication());
        //lista
        final Cursor cursorCliente =tiendaDB.listaUsuarios();
        String []desde=new String[]{"cedula","correo","nombre","apellido","direcciom","celular"};
        int[]hasta=new int[]{R.id.txtcedulausu,R.id.txtcorreousu,R.id.txtnombreusu,R.id.txtapellidousu,R.id.txtdireccionusu,R.id.txtcelularusu};
        final CursorAdapter clienteAdapter=new SimpleCursorAdapter(getApplication(),
                R.layout.personalizado_usu,cursorCliente,desde,hasta,0);
        final ListView listView=(ListView)findViewById(R.id.lista_tab);
        listView.setAdapter(clienteAdapter);
    }
}