package com.saltamontes.modulos;

import com.saltamontes.conexion.Conexion;

public class Cliente extends Conexion {
    private String nombres;
    private String apellidos;
    private String dni;
    private String direccion;
    private String telefono;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombre) {
        this.nombres = nombre;
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
    public Cliente(){
        this.nombres="";
        this.apellidos="";
        this.dni="";
        this.direccion="";
        this.telefono="";
    }
    public Cliente(String nombres,String apellidos,String dni, String direccion,String telefono){
        this.nombres=nombres;
        this.apellidos=apellidos;
        this.dni=dni;
        this.direccion=direccion;
        this.telefono=telefono;
    }

    public static Cliente getCliente(String usurio) {
        try {
            openConexion();
            consulta = conexion.prepareStatement("select nombres ,apellidos ,dni, direccion, telefono from persona inner join cliente on id_persona=id_cliente where usuario =?");
            consulta.setString(1, usurio);
            resultado = consulta.executeQuery();
            if (resultado.next()) {
                Cliente c = new Cliente();
                c.setNombres(resultado.getString(1));
                c.setApellidos(resultado.getString(2));
                c.setDni(resultado.getString(3));
                c.setDireccion(resultado.getString(4));
                c.setTelefono(resultado.getString(5));
                return c;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeConexion();
        }
        return null;
    }
    @Override
    public String toString(){
        return "Nombres: "+nombres+" "+
                "Apellidos: "+apellidos+" "+
                "DNI: "+dni+" "+
                "Dirección: "+direccion+" "+
                "Teléfono: "+telefono+" \n";

    }

}
