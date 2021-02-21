package com.saltamontes.controladores;

import com.saltamontes.modulos.Proveedor;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.util.List;


public class CProveedor{
//    extends PlainDocument
//    private JTextField editor;
//    private int numero;
//
//    public CProveedor(JTextField editor, int numero) {
//        this.editor = editor;
//        this.numero = numero;
//    }
//    public void insertarString(int arg0, String arg1, AttributeSet arg2) throws BadLocationException {
//        if((editor.getText().length()+arg1.length()>this.numero)){
//            return;
//        }
//        super.insertString(arg0,arg1,arg2);
//    }

    public static Proveedor crearProveedor(String direccion, String razon, String ruc, String telefono){
        Proveedor registrar=new Proveedor();
        registrar.setDireccion_proveedor(direccion);
        registrar.setRazon_social(razon);
        registrar.setRuc_proveedor(ruc);
        registrar.setTelefono_proveedor(telefono);
        return registrar;
    }
    public static Proveedor update(String direccion, String razon, String ruc, String telefono){
        Proveedor actualizar=new Proveedor();
        actualizar.setDireccion_proveedor(direccion);
        actualizar.setRazon_social(razon);
        actualizar.setRuc_proveedor(ruc);
        actualizar.setTelefono_proveedor(telefono);
        return actualizar;
    }
    public static List<Proveedor> obtenerProveedores(){
        return Proveedor.getProveedores();
    }
}
