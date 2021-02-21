package com.saltamontes.vistas;

import com.saltamontes.controladores.CTrabajador;
import com.saltamontes.modulos.Trabajador;
import javafx.embed.swing.SwingFXUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VPersona extends JFrame {
    private JTextField txtNombre;
    private JTextField txtApellidos;
    private JTextField txtDni;
    private JTextField txtFecha;
    private JTextField txtGenero;
    private JTextField txtUsuario;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtSueldo;
    private JTextField txtCargo;
    private JPasswordField txtContra;
    private JPanel panelPersona;
    private JButton btnRigistrar;
    private JComboBox boxCargo;
    private JPanel panelRegistrar;
    private JPanel panelActualizar;
    private JPanel panelBotones;
    public JComboBox boxActualizar;
    private Trabajador people;


    public VPersona() {
        setContentPane(panelPersona);
        setSize(1024, 600);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        VPersona.setEnableContainer(panelActualizar,false);

        btnRigistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(txtNombre.getText().isEmpty()||txtApellidos.getText().isEmpty()||txtDni.getText().isEmpty()||
                        txtFecha.getText().isEmpty()||txtGenero.getText().isEmpty()||txtUsuario.getText().isEmpty()||
                        txtDireccion.getText().isEmpty()||txtTelefono.getText().isEmpty()||txtSueldo.getText().isEmpty()||
                        txtContra.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Por favor complete los espacios requeridos");
                }else {
                    registrarPersona();
                }
            }
        });
        boxActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(boxActualizar.getSelectedItem().toString().equals("Registrar")){
                    VPersona.setEnableContainer(panelRegistrar,true);
                    VPersona.setEnableContainer(panelActualizar,false);
                }else{
                    if(boxActualizar.getSelectedItem().toString().equals("Actualizar")||boxActualizar.getSelectedItem().toString().equals("Eliminar")) {
                        VPersona.setEnableContainer(panelRegistrar, false);
                        VPersona.setEnableContainer(panelActualizar,true);
                        cargarFormActuEliminar();
                    }else {
                        VPersona.setEnableContainer(panelRegistrar,false);
                    }
                }
            }
        });
    }

    public JPanel getPanelPersona(){return panelPersona;}
    private void registrarPersona(){
        String nombre=txtNombre.getText();
        String apellidos=txtApellidos.getText();
        String dni=txtDni.getText();
        String fecha_nacimiento=txtFecha.getText();
        String genero=txtGenero.getText();
        String usuario=txtUsuario.getText();
        String direccion=txtDireccion.getText();
        String telefono=txtTelefono.getText();
        float sueldo=Float.parseFloat(txtSueldo.getText());
        String cargo=boxCargo.getSelectedItem().toString();
        String contrasena=txtContra.getText();
        people= CTrabajador.crearPersona(nombre,apellidos,dni,fecha_nacimiento,genero,usuario,direccion,telefono,sueldo,cargo,contrasena);

        try{
            if(!people.save()){
                JOptionPane.showMessageDialog(null,"Persona Agreagado correctamente");
                cleanControls();
            }else {
                JOptionPane.showMessageDialog(null,"Persona No agregado correctamente");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
    private void cleanControls(){
        txtNombre.setText(null);
        txtApellidos.setText(null);
        txtDni.setText(null);
        txtFecha.setText(null);
        txtGenero.setText(null);
        txtUsuario.setText(null);
        txtDireccion.setText(null);
        txtTelefono.setText(null);
        txtSueldo.setText(null);
        txtContra.setText(null);
    }
    private void cargarFormActuEliminar(){
        VActualizarPersona actu=new VActualizarPersona();
        panelActualizar.add(actu.getPanelActualizar());
        setVisible(true);
    }

    public static void setEnableContainer(Container c, boolean band) {

        Component [] components = c.getComponents();
        c.setEnabled(band);
        for(int i = 0; i < components.length; i++) {
            components[i].setEnabled(band);

            if(components[i] instanceof Container) {
                setEnableContainer((Container)components[i], band);
            }
        }
    }

}
