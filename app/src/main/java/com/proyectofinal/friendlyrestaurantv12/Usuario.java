package com.proyectofinal.friendlyrestaurantv12;

public class Usuario {

    private String cedula, correo, contraseña, nombre, apellido, direccion;
    private int celular;

    public Usuario() {
    }

    public Usuario(String cedula) {
        this.cedula = cedula;
    }

    public Usuario( String cedula, String correo, String contraseña, String nombre, String apellido, String direccion, int celular) {
        this.cedula = cedula;
        this.correo = correo;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.celular = celular;
    }



    public boolean isNull(){
        if (cedula.equals("")&&correo.equals("")&&contraseña.equals("")&&nombre.equals("")&&apellido.equals("")&&direccion.equals("")){
            return false;

        }else{
            return true;
        }
    }



    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }
}
