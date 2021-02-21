package com.saltamontes.vistas;

import com.saltamontes.controladores.CTrabajador;
import com.saltamontes.modulos.Trabajador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VActualizarPersona extends JFrame {
    private JTextField txtId;
    private JTextField txtDirecAc;
    private JTextField txtTeleActu;
    private JTextField txtSuelActu;
    private JPasswordField txtPassactu;
    public JButton btnActualizar;
    private JPanel panelActualizar;
    private JTextField txtCarActu;
    private JLabel lblId;
    private JButton btnCancelar;
    public JButton btnEliminar;
    public JPanel panelBtnEliminar;
    public JPanel panelBtnActualizar;
    private Trabajador job;


    public VActualizarPersona() {
        setContentPane(panelActualizar);
        setSize(1024, 600);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        btnEliminar.setEnabled(false);

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtId.getText().isEmpty()||txtDirecAc.getText().isEmpty()||txtTeleActu.getText().isEmpty()||
                        txtSuelActu.getText().isEmpty()||txtPassactu.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Por favor complete los espacios requeridos");
                }else {
                    if(comprobarLlenado()){
                        confirmacionActualizar();
                    }
                }

            }
        });
        txtId.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    job = Trabajador.getTrabajador(Integer.parseInt(txtId.getText()));
                    if (job == null) {
                        JOptionPane.showMessageDialog(null, "no existe trabajador");
                    } else {
                        mostrarDatos();
                        lblId.setText(job.getNombre()+" "+job.getApellidos());
                    }
                }
            }
        });


        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(comprobarLlenado()){
                    cancelarActualizacion();
                }

            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtId.getText().isEmpty()||txtDirecAc.getText().isEmpty()||txtTeleActu.getText().isEmpty()||
                        txtSuelActu.getText().isEmpty()||txtPassactu.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Por favor complete los espacios requeridos");
                }else {
                    if(comprobarLlenado()){
                        eliminarPersona();
                    }
                }
            }
        });
    }
    public JPanel getPanelActualizar(){return panelActualizar;}
    private void eliminarPersona(){
        VActualizarPersona.habilitarPanel(panelBtnActualizar,false);
        job= CTrabajador.actualizando(txtDirecAc.getText(),txtTeleActu.getText(),Float.parseFloat(txtSuelActu.getText()),txtCarActu.getText(),txtPassactu.getText());
        job.setEsRefresh('e');
        job.setId_persona(Integer.parseInt(txtId.getText()));
        String place=txtCarActu.getText();
        try{
            if(job.getCargo().equals("Administrador")){
                JOptionPane.showMessageDialog(null,"No se puede eliminar al Administrador");
                limpiarControles();
            }else{
                if(!job.refresh()){
                    JOptionPane.showMessageDialog(null,"Se elimino correctamente");
                    limpiarControles();
                }else{
                    JOptionPane.showMessageDialog(null,"No se pudo eliminar");
                    limpiarControles();
                }

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    private void actualizarPersona(){
        VActualizarPersona.habilitarPanel(panelBtnEliminar,false);
        job= CTrabajador.actualizando(txtDirecAc.getText(),txtTeleActu.getText(),Float.parseFloat(txtSuelActu.getText()),txtCarActu.getText(),txtPassactu.getText());
        job.setEsRefresh('a');
        job.setId_persona(Integer.parseInt(txtId.getText()));
        try{
            if(job.getCargo().equals("Administrador")){
                JOptionPane.showMessageDialog(null,"No se puede Actualizar al Administrador");
                limpiarControles();
            }else {
                if (!job.refresh()) {
                    JOptionPane.showMessageDialog(null, "Actualizado correctamente");
                    limpiarControles();
                } else {
                    JOptionPane.showMessageDialog(null, "No se actualizo");
                    limpiarControles();
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    private void mostrarDatos(){
        txtDirecAc.setText(job.getDireccion());
        txtTeleActu.setText(job.getTelefono());
        txtSuelActu.setText(String.valueOf(job.getSueldo()));
        txtCarActu.setText(job.getCargo());
        txtPassactu.setText(job.getContrasena());

    }
    private void limpiarControles(){
        txtId.setText(null);
        txtDirecAc.setText(null);
        txtTeleActu.setText(null);
        txtSuelActu.setText(null);
        txtCarActu.setText(null);
        txtPassactu.setText(null);
    }
    private boolean comprobarLlenado(){
        String user=txtId.getText();
        String pass=txtPassactu.getText();
        String tele=txtTeleActu.getText();
        String dire=txtDirecAc.getText();
        String suel=txtSuelActu.getText();
        String car=txtCarActu.getText();
        if(user.length()>0&&pass.length()>0&&tele.length()>0&&dire.length()>0&&suel.length()>0&&car.length()>0){
            return true;
        }else{
            return false;
        }
    }
    private void cancelarActualizacion(){
        String botones[]={"Si","Cancelar"};
        int eleccion=JOptionPane.showOptionDialog(this,"¿Desea Cancelar la Actualización?","Titulo",
                0,0,null,botones,this);
        ;
        if(eleccion==JOptionPane.YES_OPTION){
            limpiarControles();
            lblId.setText(null);
        }else{
            JOptionPane.showMessageDialog(null,"Continue Actualizando");
        }
    }
    private void confirmacionActualizar(){
        String botones[]={"Si","Cancelar"};
        int eleccion=JOptionPane.showOptionDialog(this,"¿Esta seguro de Actualizar?","Confirmación!!!!!!!!",
                0,0,null,botones,this);
        ;
        if(eleccion==JOptionPane.YES_OPTION){
            actualizarPersona();
        }else{
            JOptionPane.showMessageDialog(null,"Usted Cancelo la Actualización");
        }
    }
    public static void habilitarPanel(Container c, boolean band) {

        Component [] components = c.getComponents();
        c.setEnabled(band);
        for(int i = 0; i < components.length; i++) {
            components[i].setEnabled(band);

            if(components[i] instanceof Container) {
                habilitarPanel((Container)components[i], band);
            }
        }
    }


}
