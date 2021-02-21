package com.saltamontes.modulos;

import com.saltamontes.conexion.Conexion;
import com.saltamontes.intefaces.IModels;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Persona extends Conexion {
    private int id_persona;
    private String nombre;
    private String apellidos;
    private String dni;
    private String fecha_Nacimiento;
    private String genero;
    private String usuario;
    private String direccion;
    private String telefono;
    private List<Persona> personas;

    public int getId_persona() {
        return id_persona;
    }
    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFecha_Nacimiento(){return fecha_Nacimiento;}
    public void setFecha_Nacimiento(String fecha_Nacimiento){this.fecha_Nacimiento=fecha_Nacimiento;}

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public Persona(){
        this.id_persona=0;
        this.nombre="";
        this.apellidos="";
        this.dni="";
        this.fecha_Nacimiento="";
        this.genero="";
        this.usuario="";
        this.direccion="";
        this.telefono="";

        personas=new ArrayList<Persona>();
    }
    public Persona(String nombre, String apellidos, String dni, String fecha_Nacimiento,
                   String genero, String usuario,String direccion, String telefono){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.dni=dni;
        this.fecha_Nacimiento=fecha_Nacimiento;
        this.genero=genero;
        this.usuario=usuario;
        this.direccion=direccion;
        this.telefono=telefono;

        personas=new ArrayList<Persona>();
    }




}
