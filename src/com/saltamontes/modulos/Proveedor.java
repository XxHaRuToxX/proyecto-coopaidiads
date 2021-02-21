package com.saltamontes.modulos;

import com.saltamontes.conexion.Conexion;
import com.saltamontes.intefaces.IModels;

import java.util.ArrayList;
import java.util.List;

public class Proveedor extends Conexion implements IModels {
    private int id_proveedor;
    private String direccion_proveedor;
    private String razon_social;
    private String ruc_proveedor;
    private String telefono_proveedor;
    private char esNuevo;

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getDireccion_proveedor() {
        return direccion_proveedor;
    }

    public void setDireccion_proveedor(String direccion_proveedor) {
        this.direccion_proveedor = direccion_proveedor;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getRuc_proveedor() {
        return ruc_proveedor;
    }

    public void setRuc_proveedor(String ruc_proveedor) {
        this.ruc_proveedor = ruc_proveedor;
    }

    public String getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public void setTelefono_proveedor(String telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }

    public char isEsNuevo() {
        return esNuevo;
    }

    public void setEsNuevo(char esNuevo) {
        this.esNuevo = esNuevo;
    }

    public Proveedor(){
        this.id_proveedor=0;
        this.direccion_proveedor="";
        this.razon_social="";
        this.ruc_proveedor="";
        this.telefono_proveedor="";
        this.esNuevo='c';
    }
    public Proveedor(String direccion_proveedor,String razon_social,String ruc_proveedor,String telefono_proveedor){
        this.id_proveedor=0;
        this.direccion_proveedor=direccion_proveedor;
        this.razon_social=razon_social;
        this.ruc_proveedor=ruc_proveedor;
        this.telefono_proveedor=telefono_proveedor;
        this.esNuevo='c';
    }

    @Override
    public boolean save() throws Exception{
        try {
            openConexion();
            consulta=conexion.prepareStatement("call spGestionarProveedores(?,?,?,?,?,?)");
            consulta.setString(1,String.valueOf(isEsNuevo()));
            consulta.setInt(2,getId_proveedor());
            consulta.setString(3,getDireccion_proveedor());
            consulta.setString(4,getRazon_social());
            consulta.setString(5,getRuc_proveedor());
            consulta.setString(6,getTelefono_proveedor());
            return consulta.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return true;
    }

    public static Proveedor getLastProveedor() {
        try {
            openConexion();
            consulta = conexion.prepareStatement("select id_proveedor,direccion_proveedor,razon_social,ruc_proveedor,telefono_proveedor from proveedor WHERE id_proveedor = (select max(id_proveedor) from proveedor)");
            resultado = consulta.executeQuery();
            if (resultado.next()) {
                Proveedor p = new Proveedor();
                p.setId_proveedor(resultado.getInt(1));
                p.setDireccion_proveedor(resultado.getString(2));
                p.setRazon_social(resultado.getString(3));
                p.setRuc_proveedor(resultado.getString(4));
                p.setTelefono_proveedor(resultado.getString(5));
                return p;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeConexion();
        }
        return null;
    }
    public static Proveedor getProveedor(int id_prove){
        try {
            openConexion();
            consulta=conexion.prepareStatement("select id_proveedor,direccion_proveedor,razon_social,ruc_proveedor,telefono_proveedor from proveedor where id_proveedor=?");
            consulta.setInt(1,id_prove);
            resultado=consulta.executeQuery();
            if(resultado.next()){
                Proveedor pro=new Proveedor();
                pro.setId_proveedor(resultado.getInt(1));
                pro.setDireccion_proveedor(resultado.getString(2));
                pro.setRazon_social(resultado.getString(3));
                pro.setRuc_proveedor(resultado.getString(4));
                pro.setTelefono_proveedor(resultado.getString(5));
                return pro;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return  null;
    }
    public static List<Proveedor> getProveedores(){
        List<Proveedor> proveedor=new ArrayList<Proveedor>();
        try {
            openConexion();
            consulta=conexion.prepareStatement("select id_proveedor,direccion_proveedor,razon_social,ruc_proveedor,telefono_proveedor from proveedor");
            resultado=consulta.executeQuery();
            while(resultado.next()){
                Proveedor prove=new Proveedor();
                prove.setId_proveedor(resultado.getInt(1));
                prove.setDireccion_proveedor(resultado.getString(2));
                prove.setRazon_social(resultado.getString(3));
                prove.setRuc_proveedor(resultado.getString(4));
                prove.setTelefono_proveedor(resultado.getString(5));

                proveedor.add(prove);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return proveedor;
    }

    @Override
    public String toString(){
        return "ID Proveedor: "+id_proveedor+" "+
                "Dirección: "+direccion_proveedor+" "+
                "Razón Social: "+razon_social+" "+
                "RUC: "+ruc_proveedor+" "+
                "Teléfono: "+telefono_proveedor+" \n";

    }


    @Override
    public boolean refresh() throws Exception {
        return false;
    }

}
