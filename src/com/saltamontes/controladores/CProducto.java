package com.saltamontes.controladores;

import com.saltamontes.modulos.Producto;
import com.saltamontes.modulos.Proveedor;

import java.util.List;

public class CProducto {
    public static Producto crearProducto(String codigo, String nombre, float precio, String desc,float cantidad){
        Producto registrar=new Producto();
        registrar.setCodigo(codigo);
        registrar.setNombrep(nombre);
        registrar.setPreciop(precio);
        registrar.setDescripciop(desc);
        registrar.setCantidadp(cantidad);

        return registrar;
    }
    public static Producto update(String codigo, String nombre, float precio, String desc,float cant){
        Producto actualizar=new Producto();
        actualizar.setCodigo(codigo);
        actualizar.setNombrep(nombre);
        actualizar.setPreciop(precio);
        actualizar.setDescripciop(desc);
        actualizar.setCantidadp(cant);
        return actualizar;
    }
    public static Producto delete(int idproducto,String codigo){
        Producto eliminar=new Producto();
        eliminar.setId_producto(idproducto);
        eliminar.setCodigo(codigo);
        return eliminar;
    }
    public static List<Producto> obtenerProductos(){
        return Producto.getProductos();
    }
}
