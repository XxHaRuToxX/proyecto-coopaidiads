package com.saltamontes.modulos;

import com.saltamontes.conexion.Conexion;
import com.saltamontes.intefaces.IModels;

import java.util.ArrayList;
import java.util.List;

public class Producto extends Conexion implements IModels {
    private int id_producto;
    private String codigo;
    private String nombrep;
    private float preciop;
    private String descripciop;
    private float cantidadp;
    private float stockp;
    private char esNuevo;

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombrep() {
        return nombrep;
    }

    public void setNombrep(String nombrep) {
        this.nombrep = nombrep;
    }

    public float getPreciop() {
        return preciop;
    }

    public void setPreciop(float preciop) {
        this.preciop = preciop;
    }

    public String getDescripciop() {
        return descripciop;
    }

    public void setDescripciop(String descripciop) {
        this.descripciop = descripciop;
    }

    public float getCantidadp() {
        return cantidadp;
    }

    public void setCantidadp(float cantidadp) {
        this.cantidadp = cantidadp;
    }

    public float getStockp() { return stockp;
    }

    public void setStockp(float stockp) { this.stockp = stockp;}

    public char isEsNuevo() {
        return esNuevo;
    }

    public void setEsNuevo(char esNuevo) {
        this.esNuevo = esNuevo;
    }
    public Producto(){
        this.id_producto=0;
        this.codigo="";
        this.nombrep="";
        this.preciop=0;
        this.descripciop="";
        this.cantidadp=0;
        this.esNuevo='c';
    }
    public Producto(int id_producto,String codigo,String nombrep,float preciop,String descripciop,float cantidadp){
        this.id_producto=id_producto;
        this.codigo=codigo;
        this.nombrep=nombrep;
        this.preciop=preciop;
        this.descripciop=descripciop;
        this.cantidadp=cantidadp;
        this.esNuevo='c';
    }
    @Override
    public boolean save() throws Exception{
        try {
            openConexion();
            consulta=conexion.prepareStatement("call spGestionarProducto(?,?,?,?,?,?,?)");
            consulta.setString(1,String.valueOf(isEsNuevo()));
            consulta.setInt(2,getId_producto());
            consulta.setString(3,getCodigo());
            consulta.setString(4,getNombrep());
            consulta.setFloat(5,getPreciop());
            consulta.setString(6,getDescripciop());
            consulta.setFloat(7,getCantidadp());
            return consulta.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return true;
    }
    public static Producto getStock(float stock) {
        try {
            openConexion();
            consulta = conexion.prepareStatement("select MAX(stock_producto) from producto where codigo_producto=?");
            resultado = consulta.executeQuery();
            if (resultado.next()) {
                Producto p = new Producto();
                p.setStockp(resultado.getFloat(1));
                return p;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeConexion();
        }
        return null;
    }
    public static Producto getProducto(int id_produ){
        try {
            openConexion();
            consulta=conexion.prepareStatement("select id_producto,codigo_producto,nombre_producto,precio_producto,desc_producto,cantidad_producto from producto where id_producto =?");
            consulta.setInt(1,id_produ);
            resultado=consulta.executeQuery();
            if(resultado.next()){
                Producto pro=new Producto();
                pro.setId_producto(resultado.getInt(1));
                pro.setCodigo(resultado.getString(2));
                pro.setNombrep(resultado.getString(3));
                pro.setPreciop(resultado.getFloat(4));
                pro.setDescripciop(resultado.getString(5));
                pro.setCantidadp(resultado.getFloat(6));
                return pro;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return  null;
    }
    public static Producto getProductoNombre(String nombre){
        try {
            openConexion();
            consulta=conexion.prepareStatement("select max(nombre_producto),max(precio_producto) from producto where nombre_producto =?");
            consulta.setString(1,nombre);
            resultado=consulta.executeQuery();
            if(resultado.next()){
                Producto pro=new Producto();
                pro.setNombrep(resultado.getString(1));
                pro.setPreciop(resultado.getFloat(2));
                return pro;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return  null;
    }
//    public static String[] getProductName(){
//        String[]productos=new String[]{};
//        try {
//            openConexion();
//            consulta=conexion.prepareStatement("select nombre_producto,precio_producto from producto");
//            resultado=consulta.executeQuery();
//            while(resultado.next()){
//                Producto produ=new Producto();
//                produ.setId_producto(resultado.getInt(1));
//                produ.setNombre(resultado.getString(2));
//                produ.setDescripcion(resultado.getString(3));
//                produ.setPrecio(resultado.getFloat(4));
//                produ.setStock(resultado.getInt(5));
//                producto.add(produ);
//            }
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }finally {
//            closeConexion();
//        }
//        return producto;
//    }
    public static Producto getStockCriollo(){
        try {
            openConexion();
            consulta=conexion.prepareStatement("select stock_criollo from stockProductos where id_stockproducto =(select max(id_stockproducto) from stockproductos)");
            resultado=consulta.executeQuery();
            if(resultado.next()){
                Producto pro=new Producto();
                pro.setStockp(resultado.getFloat(1));
                return pro;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return  null;
    }

    public static Producto getStockAmazonico(){
        try {
            openConexion();
            consulta=conexion.prepareStatement("select stock_amazonico from stockProductos where id_stockproducto =(select max(id_stockproducto) from stockproductos)");
            resultado=consulta.executeQuery();
            if(resultado.next()){
                Producto pro=new Producto();
                pro.setStockp(resultado.getFloat(1));
                return pro;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return  null;
    }
    public static Producto getStockTropical(){
        try {
            openConexion();
            consulta=conexion.prepareStatement("select stock_tropical from stockProductos where id_stockproducto =(select max(id_stockproducto) from stockproductos)");
            resultado=consulta.executeQuery();
            if(resultado.next()){
                Producto pro=new Producto();
                pro.setStockp(resultado.getFloat(1));
                return pro;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return  null;
    }

    public static List<Producto> getProductos(){
        List<Producto> producto=new ArrayList<Producto>();
        try {
            openConexion();
            consulta=conexion.prepareStatement("select*from producto");
            resultado=consulta.executeQuery();
            while(resultado.next()){
                Producto produ=new Producto();
                produ.setId_producto(resultado.getInt(1));
                produ.setCodigo(resultado.getString(2));
                produ.setNombrep(resultado.getString(3));
                produ.setPreciop(resultado.getFloat(4));
                produ.setDescripciop(resultado.getString(5));
                produ.setCantidadp(resultado.getFloat(6));

                producto.add(produ);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConexion();
        }
        return producto;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "stockp=" + stockp +
                '}';
    }

    @Override
    public boolean refresh() throws Exception {
        return false;
    }

}
