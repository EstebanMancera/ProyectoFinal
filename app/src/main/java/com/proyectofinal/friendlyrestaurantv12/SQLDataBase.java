package com.proyectofinal.friendlyrestaurantv12;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class SQLDataBase extends SQLiteOpenHelper {
    private static final String DATABASE="tienda.db";
    Context miContext;

    public SQLDataBase(@Nullable Context context) {
        super(context, DATABASE,null, 1);
        miContext=context;
        File miArchivo=miContext.getDatabasePath(DATABASE);
        if(verificaBD(miArchivo.getAbsolutePath())){
            try {
                copiarBD(miArchivo);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    private boolean verificaBD(String ruta){
        SQLiteDatabase miBase=null;

        try{miBase=SQLiteDatabase.openDatabase(ruta,null,SQLiteDatabase.OPEN_READONLY);}
        catch (Exception e){
            e.printStackTrace();
        }

        if(miBase!=null){
            miBase.close();
        }
        return miBase!=null;
    }

    private void copiarBD(File archivoBD)throws IOException {
        InputStream inputStream = miContext.getAssets().open(DATABASE);
        OutputStream outputStream = new FileOutputStream(archivoBD);
        byte[] buffer=new byte[1024];
        int largo;
        while ((largo=inputStream.read(buffer))>0){
            outputStream.write(buffer,0, largo);

        }
        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }

    //Editar
    public String editar(Usuario ti){
        String sql ="UPDATE usuario SET correo = '"+
                ti.getCorreo()+"', contraseña = '"+
                ti.getContraseña()+"', nombre = '"+
                ti.getNombre()+"', apellido='"+
                ti.getApellido()+"', direccion='"+
                ti.getDireccion()+"', celular='"+
                ti.getCelular()+"' WHERE cedula ='"+
                ti.getCedula()+"' ";
        try{
            this.getWritableDatabase().execSQL(sql);
        }catch (SQLException e){
            return e.getMessage();
        }
        return null;
    }
    //listado  Clientes
    public Cursor listaUsuarios(){
        Cursor cursor;
        String sql="select ROWID as _id,* from usuario";
        cursor=this.getReadableDatabase().rawQuery(sql, null);
        return cursor;
    }
    //ingreso cliente
    public String insertarUsuario(Usuario usu){
        String sql="INSERT INTO usuario(cedula,correo,contraseña,nombre,apellido,direccion,celular)";
        sql+="VALUES('"+usu.getCedula()+"','"+usu.getCorreo()+"','"+usu.getContraseña()+"','"+usu.getNombre()+"','"+usu.getApellido()+"','"+usu.getDireccion()+"','"+usu.getCelular()+"')";
        try{
            this.getWritableDatabase().execSQL(sql);
        }catch (SQLException ex){
            return "Error en la creacion del usuario"+ ex.getMessage();
        }
        return null;
    }
    public String  eliminarCliente(String idCliente){
        String sql="DELETE FROM cliente WHERE identificacion IN ('"+idCliente+"');";
        try{
            this.getWritableDatabase().execSQL(sql);
        }catch (SQLException ex){
            return "Error en la eliminacion del cliente"+ ex.getMessage();
        }return null;
    }
    public String modificarCliente(String idCliente){
        String sql="UPDATE cliente FROM  WHERE identificacion IN ('"+idCliente+"');";
        try{
            this.getWritableDatabase().execSQL(sql);
        }catch (SQLException ex){
            return "Error en modificacion"+ ex.getMessage();
        }
        return null;

    }





    /*





    public Cursor listaUsuarios(){
            Cursor cursor;
            String sql="select ROWID as _id,  * from usuario";
            cursor=this.getReadableDatabase().rawQuery(sql, null);
            return cursor;
        }


    public boolean insertarUsuario(Usuario u){
        if(buscar(u.getCorreo())==0){
            ContentValues cv=new ContentValues();
            cv.put("cedula",u.getCorreo());
            cv.put("correo",u.getCorreo());
            cv.put("contraseña",u.getContraseña());
            cv.put("nombre",u.getNombre());
            cv.put("apellido",u.getApellido());
            cv.put("direccion",u.getDireccion());
            cv.put("celular",u.getCelular());
            return (sql.insert("usuario", null,cv)>0);
        }else{
            return false;
        }
    }

    public int buscar (String u){
        int  x=0;
        lista = selectusuario();
        for(Usuario us:lista){
            if(us.getCorreo().equals(u)){
                x++;
            }
        }
        return x;
    }

    public  ArrayList<Usuario> selectusuario(){
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        lista.clear();
        Cursor cr=sql.rawQuery("select * from usuario", null);
        if(cr!=null&&cr.moveToFirst()){
            do{
                Usuario u=new Usuario();
                u.setCedula(cr.getString(0));
                u.setCorreo(cr.getString(1));
                u.setContraseña(cr.getString(2));
                u.setNombre(cr.getString(3));
                u.setApellido(cr.getString(4));
                u.setDireccion(cr.getString(5));
                u.setCelular(cr.getInt(6));
                lista.add(u);
            }while(cr.moveToNext());

        }
        return lista;
    }

    public int login (String u, String p){
        int a = 0;
        Cursor cr=sql.rawQuery("select * from usuario", null);
        if(cr!=null&&cr.moveToFirst()){
            do{
                if(cr.getString(1).equals(u)&&cr.getString(2).equals(p)){
                    a++;
                }
            }while(cr.moveToNext());

        }
        return a;

    }

    public Usuario getUsuario(String u, String p){
        lista=selectusuario();
        for (Usuario us:lista) {
            if (us.getCorreo().equals(u)&&us.getContraseña().equals(p)){
                return us;
            }
        }
        return null;
    }*/
/*
    public Usuario getUsuarioById(int id){
        lista=selectusuario();
        for (Usuario us:lista) {
            if (us.getId()==id){
                return us;
            }
        }
        return null;
    }*/

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
