package com.saltamontes.vistas;

import com.saltamontes.controladores.CProveedor;
import com.saltamontes.controladores.CTrabajador;
import com.saltamontes.modulos.Proveedor;
import com.saltamontes.modulos.Trabajador;
import com.sun.xml.internal.org.jvnet.fastinfoset.RestrictedAlphabet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class VArchivoProveedores extends JInternalFrame {

    private JTable tablaProveedores;
    private JLabel lblID;
    private JPanel panelArchivoProveedor;
    private JTextField txtID;
    private JTextField txtDireccion;
    private JTextField txtRazon;
    private JTextField txtRuc;
    private JTextField txtTelefono;
    private JLabel lblRazon;
    private JLabel lblDireccion;
    private JLabel lblRuc;
    private JLabel lblTelefono;
    private JButton btnRegistrar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JLabel lblRucMostrar;
    private JScrollPane scrTabla;
    private Proveedor prove;
    private DefaultTableModel modelo;

    public VArchivoProveedores(){
        setClosable(true);
        setIconifiable(true);
        setResizable(false);
        setTitle("Proveedores");
        setLayout(null);
        setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        setSize(550,510);
//        limitar();

        scrTabla=new JScrollPane();
        scrTabla.setViewportView(tablaProveedores);
        add(lblID);
        add(txtID);
        add(lblRucMostrar);
        add(lblDireccion);
        add(txtDireccion);
        add(lblRazon);
        add(txtRazon);
        add(lblRuc);
        add(txtRuc);
        add(lblTelefono);
        add(txtTelefono);
        add(scrTabla);
        add(btnRegistrar);
        add(btnActualizar);
        add(btnEliminar);
        add(btnBuscar);


        lblID.reshape(20,20,110,20);
        txtID.reshape(130,20,100,20);
        lblRucMostrar.reshape(300,20,110,20);
        lblDireccion.reshape(20,60,110,20);
        txtDireccion.reshape(130,60,250,20);
        lblRazon.reshape(20,100,110,20);
        txtRazon.reshape(130,100,250,20);
        lblRuc.reshape(20,140,110,20);
        txtRuc.reshape(130,140,250,20);
        lblTelefono.reshape(20,180,110,20);
        txtTelefono.reshape(130,180,250,20);

        btnRegistrar.reshape(20,220,110,25);
        btnActualizar.reshape(150,220,120,25);
        btnEliminar.reshape(290,220,100,25);
        btnBuscar.reshape(410,220,100,25);

        scrTabla.reshape(20,260,500,200);
        cargarproveedores();


        txtID.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    prove = Proveedor.getProveedor(Integer.parseInt(txtID.getText()));
                    if (prove == null) {
                        JOptionPane.showMessageDialog(null, "no existe Proveedor");
                        limpiarControles();
                    } else {
                        mostrarDatos();
                        lblRucMostrar.setText(prove.getRuc_proveedor());
                    }
                }
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comprobarLlenado()){
                    actualizarProveedor();
                    cargarproveedores();
                }else{
                    JOptionPane.showMessageDialog(null,"Ingrese un ID por favor para actualizar");
                }

            }
        });
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                if(comprobarLlenado()){

                if(!(txtDireccion.getText().isEmpty()||txtRazon.getText().isEmpty()||txtRuc.getText().isEmpty()
                ||txtTelefono.getText().isEmpty())){
                    registrarProveedor();
                    String titulos[]={"ID Usuario","Dirección","Razón Social","RUC","Teléfono"};
                    modelo=new DefaultTableModel(null,titulos);
                    Proveedor obj=Proveedor.getLastProveedor();
                    Object [] fila=new Object[5];
                    fila[0]=obj.getId_proveedor();
                    fila[1]=obj.getDireccion_proveedor();
                    fila[2]=obj.getRazon_social();
                    fila[3]=obj.getRuc_proveedor();
                    fila[4]=obj.getTelefono_proveedor();
                    modelo.addRow(fila);

                    tablaProveedores.setModel(modelo);
                }else{
                    JOptionPane.showMessageDialog(null,"Complete los espacios requeridos");
                }

            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comprobarLlenado()){
                    eliminarProveedor();
//                    cargarproveedores();
                }else{
                    JOptionPane.showMessageDialog(null,"Ingrese un ID por favor para eliminar");
                }
            }
        });
        txtRuc.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                validarRuc(e);
                if(txtRuc.getText().length()==11){
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
        txtTelefono.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                validarRuc(e);
                if(txtTelefono.getText().length()>=9){
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
        txtDireccion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(txtDireccion.getText().length()>=150){
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
        txtRazon.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(txtRazon.getText().length()>=50){
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
    }

    public void registrarProveedor(){

        String direccion=txtDireccion.getText();
        String razonSocial=txtRazon.getText();
        String ruc=txtRuc.getText();
        String telefono=txtTelefono.getText();

        prove=CProveedor.crearProveedor(direccion,razonSocial,ruc,telefono);
        try {
            if (!prove.save()){
                JOptionPane.showMessageDialog(null,"Guardado");
//                limpiarControles();
            }else{
                JOptionPane.showMessageDialog(null,"No guardado");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    private void actualizarProveedor(){
        prove= CProveedor.update(txtDireccion.getText(),txtRazon.getText(),txtRuc.getText(),txtTelefono.getText());
        prove.setEsNuevo('a');
        prove.setId_proveedor(Integer.parseInt(txtID.getText()));
        try{
                if (!prove.save()) {
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
    private void eliminarProveedor(){
        prove= CProveedor.update(txtDireccion.getText(),txtRazon.getText(),txtRuc.getText(),txtTelefono.getText());
        prove.setEsNuevo('e');
        prove.setId_proveedor(Integer.parseInt(txtID.getText()));
        try{
            if (!prove.save()) {
                JOptionPane.showMessageDialog(null, "Eliminado correctamente");
                limpiarControles();
                cargarproveedores();
            } else {
                JOptionPane.showMessageDialog(null, "No se Eliminó");
                limpiarControles();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    private void cargarproveedores(){
//        String datos []=new String[5];
        String titulos[]={"ID Usuario","Dirección","Razón Social","RUC","Teléfono"};
        modelo=new DefaultTableModel(null,titulos);
        CProveedor.obtenerProveedores().forEach(p->{
            Object [] fila=new Object[5];
            fila[0]=p.getId_proveedor();
            fila[1]=p.getDireccion_proveedor();
            fila[2]=p.getRazon_social();
            fila[3]=p.getRuc_proveedor();
            fila[4]=p.getTelefono_proveedor();
            modelo.addRow(fila);

        });
        tablaProveedores.setModel(modelo);
    }

    private void limpiarControles(){
        txtID.setText(null);
        txtDireccion.setText(null);
        txtRazon.setText(null);
        txtRuc.setText(null);
        txtTelefono.setText(null);
    }
    private void mostrarDatos(){
        txtDireccion.setText(prove.getDireccion_proveedor());
        txtRazon.setText(String.valueOf(prove.getRazon_social()));
        txtRuc.setText(prove.getRuc_proveedor());
        txtTelefono.setText(prove.getTelefono_proveedor());

    }
//    private void limiteCaracteresRuc(){
//        char[] ruc=txtDireccion.getText().toCharArray();
//        if(!(ruc.length==11)){
//            JOptionPane.showMessageDialog(null,"Ingrese 11 caracteres");
//        }
//    }
    private void validarCaracteres(KeyEvent event){
        if(event.getKeyChar()>=33&&event.getKeyChar()<=64||
                event.getKeyChar()>=91&&event.getKeyChar()<=96||
                event.getKeyChar()>=123&&event.getKeyChar()<=208||
                event.getKeyChar()>=210&&event.getKeyChar()<=240||
                event.getKeyChar()>=242&&event.getKeyChar()<=255){
            event.consume();
            JOptionPane.showMessageDialog(null,"No se permite caracteres especiales");
        }
//        System.out.println("Soy la letra"+event.getKeyChar()+" y mi numero ASCII corresponde a: "+event.getKeyChar()+0);
    }
    private void validarRuc(KeyEvent event){
        if(event.getKeyChar()>=32&&event.getKeyChar()<=47||
                event.getKeyChar()>=58&&event.getKeyChar()<=255
                ){
            event.consume();
            JOptionPane.showMessageDialog(null,"No se permite caracteres especiales");
        }
//        System.out.println("Soy la letra"+event.getKeyChar()+" y mi numero ASCII corresponde a: "+event.getKeyChar()+0);
    }

    private void validarCamposVacios(){
        if(txtID.getText().isEmpty()){
            lblRucMostrar.setText("Campo Obligatorio");
        }else{
            lblRucMostrar.setText("");
        }
    }
//    private void limitar(){
//        txtDireccion.setDocument(new CProveedor(txtDireccion,150));
//        txtRazon.setDocument(new CProveedor(txtRazon,50));
//        txtRuc.setDocument(new CProveedor(txtRuc,11));
//        txtTelefono.setDocument(new CProveedor(txtTelefono,9));
//    }
    private boolean comprobarLlenado(){
        String id=txtID.getText();
        String dire=txtDireccion.getText();
        String razon=txtRazon.getText();
        String ruc=txtRuc.getText();
        String tele=txtTelefono.getText();

        if(id.length()>0&&dire.length()>0&&razon.length()>0&&ruc.length()>0&&tele.length()>0){
            return true;
        }else{
            return false;
        }
    }
}
