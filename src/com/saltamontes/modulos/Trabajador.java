package com.saltamontes.modulos;

import com.saltamontes.intefaces.IModels;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

public class Trabajador extends Persona implements IModels {
    private float sueldo;
    private String cargo;
    private String contrasena;
    private char EsRefresh;

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public char isEsRefresh() {
        return EsRefresh;
    }

    public void setEsRefresh(char esRefresh) {
        EsRefresh = esRefresh;
    }

    public Trabajador() {
        this.sueldo = 0;
        this.cargo = "";
        this.contrasena = "";
        this.EsRefresh='a';
    }

    public Trabajador(float sueldo,String cargo,String contrasena){
        this.sueldo = sueldo;
        this.cargo = cargo;
        this.contrasena = contrasena;
        this.EsRefresh='a';
    }

    @Override
    public boolean save(){

        try {
            openConexion();
            consulta=conexion.prepareStatement("call spInsertarPersona(?,?,?,?,?,?,?,?,?,?,?)");
            consulta.setString(1,getNombre());
            consulta.setString(2,getApellidos());
            consulta.setString(3,getDni());
            consulta.setString(4,getFecha_Nacimiento());
            consulta.setString(5,getGenero());
            consulta.setString(6,getUsuario());
            consulta.setString(7,getDireccion());
            consulta.setString(8,getTelefono());
            consulta.setFloat(9,getSueldo());
            consulta.setString(10,getCargo());
            consulta.setString(11,getContrasena());
            return consulta.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return true;
    }
    @Override
    public boolean refresh(){
        try {
            openConexion();
            consulta=conexion.prepareStatement("call spGestionarPersona(?,?,?,?,?,?,?)");
            consulta.setString(1,String.valueOf(isEsRefresh()));
            consulta.setInt(2,getId_persona());
            consulta.setString(3,getDireccion());
            consulta.setString(4,getTelefono());
            consulta.setFloat(5,getSueldo());
            consulta.setString(6,getCargo());
            consulta.setString(7,getContrasena());
            return consulta.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return true;
    }


    public static Trabajador getTrabajador(int id_traba){
        try {
            openConexion();
            consulta=conexion.prepareStatement("select direccion ,telefono ,sueldo, cargo_Trabajador, contraseña_Trabajador,nombres,apellidos from persona inner join trabajador on id_persona=id_trabajador where id_trabajador=?;");
            consulta.setInt(1,id_traba);
            resultado=consulta.executeQuery();
            if(resultado.next()){
                Trabajador trabajador=new Trabajador();
                trabajador.setDireccion(resultado.getString(1));
                trabajador.setTelefono(resultado.getString(2));
                trabajador.setSueldo(resultado.getFloat(3));
                trabajador.setCargo(resultado.getString(4));
                trabajador.setContrasena(resultado.getString(5));
                trabajador.setNombre(resultado.getString(6));
                trabajador.setApellidos(resultado.getString(7));
                return trabajador;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return  null;
    }

    public static Trabajador login(String usuario,String password){
        try {
            openConexion();
            consulta=conexion.prepareStatement("select*from persona inner join trabajador on id_persona=id_trabajador where usuario=? and contraseña_Trabajador=?;");
            consulta.setString(1,usuario);
            consulta.setString(2,password);
            resultado=consulta.executeQuery();
            if(resultado.next()){
                Trabajador trabajador=new Trabajador();
                trabajador.setId_persona(resultado.getInt(1));
                trabajador.setNombre(resultado.getString(2));
                trabajador.setApellidos(resultado.getString(3));
                trabajador.setDni(resultado.getString(4));
                trabajador.setFecha_Nacimiento(resultado.getString(5));
                trabajador.setGenero(resultado.getString(6));
                trabajador.setUsuario(resultado.getString(7));
                trabajador.setDireccion(resultado.getString(8));
                trabajador.setTelefono(resultado.getString(9));
                trabajador.setSueldo(resultado.getFloat(11));
                trabajador.setCargo(resultado.getString(12));
                trabajador.setContrasena(resultado.getString(13));
                return trabajador;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return  null;
    }


}
