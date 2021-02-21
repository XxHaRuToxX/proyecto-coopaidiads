package com.saltamontes.vistas;

import com.saltamontes.controladores.CProducto;
import com.saltamontes.modulos.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class VAlmacenero extends JFrame {

    private JPanel panelAlmacenero;
    private JPanel panelProductos;
    private JPanel panelTabla;
    private JPanel panelBotones;
    private JScrollPane scrTabla;
    private JTable tablaProductos;
    private JTextField txtIdProducto;
    private JTextField txtNombreP;
    private JTextField txtPrecioP;
    private JTextField txtDescP;
    private JButton btnActualizarP;
    private JButton btnEliminarP;
    private JButton btnImprimir;
    private JButton btnRegistrarP;
    private JLabel lblIDProducto;
    private JLabel lblNombreP;
    private JLabel lblPrecioP;
    private JLabel lblDescP;
    private JComboBox boxNombre;
    private JTextField txtCantidadp;
    private JLabel lblNombrePro;
    private JLabel lblCodigo;
    private Producto produ;
    private DefaultTableModel modelo;

    public VAlmacenero(){
        setContentPane(panelAlmacenero);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
//        mostrarStock();
        cargarProductos();
//        String[][]date=new String[][]{{"hola","Hola","hola"},{"hola2","hola2","hola2"},{"hola3","hola3","hola3"}};
//        tablaProductos.setModel(new DefaultTableModel(null,new String[]{"ID","CÓDIGO","NOMBRE","PRECIO","DESCRIPCIÓN","CANTIDAD"}));

        txtIdProducto.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    produ = Producto.getProducto(Integer.parseInt(txtIdProducto.getText()));
                    if (produ == null) {
                        JOptionPane.showMessageDialog(null, "No existe Producto");
                        limpiarControles();
                    } else {
                        mostrarDatos();
                    }
                }
            }
        });

        btnRegistrarP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(txtPrecioP.getText().isEmpty()||txtDescP.getText().isEmpty()|| txtCantidadp.getText().isEmpty())){
                    registrarProducto();
                    cargarProductos();
                }else{
                    JOptionPane.showMessageDialog(null,"Complete los espacios requeridos para registar");
                }

            }
        });
        btnActualizarP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(txtIdProducto.getText().isEmpty()||txtPrecioP.getText().isEmpty()||txtDescP.getText().isEmpty()|| txtCantidadp.getText().isEmpty())){
                    actualizarProducto();
                    cargarProductos();
                    limpiarControles();
                }else{
                    JOptionPane.showMessageDialog(null,"Ingrese un ID para actualizar");
                }

            }
        });
        btnEliminarP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(txtIdProducto.getText().isEmpty()||txtPrecioP.getText().isEmpty()||txtDescP.getText().isEmpty()|| txtCantidadp.getText().isEmpty())){
                    eliminarProducto();
                    cargarProductos();
                    limpiarControles();
                }else{
                    JOptionPane.showMessageDialog(null,"Ingrese un ID para Eliminar");
                }

            }
        });
        btnImprimir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
//                    JFrame yourComponent = new JFrame();
                    PrinterJob pjob = PrinterJob.getPrinterJob();
                    PageFormat preformat = pjob.defaultPage();
                    preformat.setOrientation(PageFormat.LANDSCAPE);
                    PageFormat postformat = pjob.pageDialog(preformat);
//If user does not hit cancel then print.
                    if (preformat != postformat) {
                        //Set print component
                        pjob.setPrintable(new Printer(panelTabla), postformat);
                        if (pjob.printDialog()) {
                            pjob.print();
                        }
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }
//    private void mostrarStock(){
//        produ=Producto.getStock(produ.getStockp());
//        String box= String.valueOf(boxNombre.getSelectedItem());
//        if(box.equals("C. Criollo")){
//            txtStock.setText(Float.toString(produ.getCantidadp()));
//        }else{
//            if(box.equals("C. Tropical")){
//                txtStock.setText(Float.toString(produ.getCantidadp()));
//            }else{
//                txtStock.setText(Float.toString(produ.getCantidadp()));
//            }
//        }

//    }
    private String generarCodigo(){
        String box= String.valueOf(boxNombre.getSelectedItem());

        if(box.equals("C. Criollo")){
            box="CRIO";
        }else{
            if(box.equals("C. Tropical")){
                box="TROP";
            }else{
                box="FAMA";
            }
        }
        return box;
    }
//    private float obtenerStock(){
//        String box= String.valueOf(boxNombre.getSelectedItem());
//        float cant=Float.parseFloat(txtCantidadp.getText());
//        float stock=Float.parseFloat(txtStock.getText());
//        if(box.equals("C. Criollo")){
//            stock=stock+cant;
//        }else{
//            if(box.equals("C. Tropical")){
//                stock=stock+cant;
//            }else {
//                stock=stock+cant;
//            }
//        }
//        return stock;
//    }
    public void registrarProducto(){

        String nombrep= String.valueOf(boxNombre.getSelectedItem());
        float precio=Float.parseFloat(txtPrecioP.getText());
        String desc=txtDescP.getText();
        float cantidad=Float.parseFloat(txtCantidadp.getText());

        produ= CProducto.crearProducto(generarCodigo(),nombrep,precio,desc,cantidad);
        try {
            if (!produ.save()){
                JOptionPane.showMessageDialog(null,"Guardado");
//                limpiarControles();
            }else{
                JOptionPane.showMessageDialog(null,"No guardado");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    private void actualizarProducto(){
//        String.valueOf(boxCodigo.getSelectedItem())
        produ= CProducto.update(generarCodigo(),String.valueOf(boxNombre.getSelectedItem()),Float.parseFloat(txtPrecioP.getText()),txtDescP.getText(),Float.parseFloat(txtCantidadp.getText()));
        produ.setEsNuevo('a');
        produ.setId_producto(Integer.parseInt(txtIdProducto.getText()));
        try{
            if (!produ.save()) {
                JOptionPane.showMessageDialog(null, "Actualizado correctamente");
//                    limpiarControles();
            } else {
                JOptionPane.showMessageDialog(null, "No se actualizo");
                limpiarControles();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    private void eliminarProducto(){
        produ= CProducto.delete(Integer.parseInt(txtIdProducto.getText()),generarCodigo());
        produ.setEsNuevo('e');
        produ.setId_producto(Integer.parseInt(txtIdProducto.getText()));
        try{
            if (!produ.save()) {
                JOptionPane.showMessageDialog(null, "Eliminado correctamente");
                limpiarControles();
                cargarProductos();
            } else {
                JOptionPane.showMessageDialog(null, "No se Eliminó");
                limpiarControles();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    private void cargarProductos(){
//        String datos []=new String[5];
        String[] titulos={"ID","CÓDIGO","NOMBRE","PRECIO","DESCRIPCIÓN","CANTIDAD"};
        modelo=new DefaultTableModel(null,titulos);
        CProducto.obtenerProductos().forEach(p->{
            Object [] fila=new Object[6];
            fila[0]=p.getId_producto();
            fila[1]=p.getCodigo();
            fila[2]=p.getNombrep();
            fila[3]=p.getPreciop();
            fila[4]=p.getDescripciop();
            fila[5]=p.getCantidadp();
            modelo.addRow(fila);

        });
        tablaProductos.setModel(modelo);
    }
    private void limpiarControles(){
        txtIdProducto.setText(null);
        lblCodigo.setText(null);
        lblNombrePro.setText(null);
        txtPrecioP.setText(null);
        txtDescP.setText(null);
        txtCantidadp.setText(null);
    }
    private void mostrarDatos(){
        txtIdProducto.setText(Integer.toString(produ.getId_producto()));
        lblCodigo.setText(produ.getCodigo());
        lblNombrePro.setText(produ.getNombrep());
        txtPrecioP.setText(Float.toString(produ.getPreciop()));
        txtDescP.setText(produ.getDescripciop());
        txtCantidadp.setText(Float.toString(produ.getCantidadp()));

    }

    class Printer implements Printable {
        final Component comp;

        public Printer(Component comp){
            this.comp = comp;
        }

        @Override
        public int print(Graphics g, PageFormat format, int page_index) throws PrinterException {
            if (page_index > 0) {
                return Printable.NO_SUCH_PAGE;
            }

            // get the bounds of the component
            Dimension dim = comp.getSize();
            double cHeight = dim.getHeight();
            double cWidth = dim.getWidth();

            // get the bounds of the printable area
            double pHeight = format.getImageableHeight();
            double pWidth = format.getImageableWidth();

            double pXStart = format.getImageableX();
            double pYStart = format.getImageableY();

            double xRatio = pWidth / cWidth;
            double yRatio = pHeight / cHeight;


            Graphics2D g2 = (Graphics2D) g;
            g2.translate(pXStart, pYStart);
            g2.scale(xRatio, yRatio);
            comp.paint(g2);

            return Printable.PAGE_EXISTS;
        }
    }
}
