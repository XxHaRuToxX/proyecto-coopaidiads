package com.saltamontes.controladores;

import com.saltamontes.modulos.Persona;
import com.saltamontes.modulos.Trabajador;

public class CTrabajador {
    public static Trabajador crearPersona(String nombre, String apellidos, String dni, String fecha_Nacimiento, String genero,
                                          String usuario, String direccion, String telefono, float sueldo, String cargo, String contrasena){
        Trabajador trabajador=new Trabajador();
        trabajador.setNombre(nombre);
        trabajador.setApellidos(apellidos);
        trabajador.setDni(dni);
        trabajador.setFecha_Nacimiento(fecha_Nacimiento);
        trabajador.setGenero(genero);
        trabajador.setUsuario(usuario);
        trabajador.setDireccion(direccion);
        trabajador.setTelefono(telefono);
        trabajador.setSueldo(sueldo);
        trabajador.setCargo(cargo);
        trabajador.setContrasena(contrasena);
        return trabajador;
    }
    public static Trabajador logeando(String usuario,String contrasena){
        Trabajador login=new Trabajador();
        login.setUsuario(usuario);
        login.setContrasena(contrasena);
        return login;
    }
    public static Trabajador actualizando(String direccion,String telefono,float sueldo, String cargo,String contrasena){
        Trabajador actualizar=new Trabajador();
        actualizar.setDireccion(direccion);
        actualizar.setTelefono(telefono);
        actualizar.setSueldo(sueldo);
        actualizar.setCargo(cargo);
        actualizar.setContrasena(contrasena);
        return actualizar;
    }

}
