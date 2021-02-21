package com.saltamontes.vistas;

import javax.swing.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class VPrincipal extends JFrame {
    private JPanel panel1;
    private JPanel pnPrincipal;
    private JButton btnNuevo;
    private JButton btnLogin;
    private JButton btnActuEliminar;

    public VPrincipal() {
        setContentPane(panel1);
        setSize(1024, 600);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);

        btnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarFormPersona();
            }
        });
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            cargarFormLogin2();

            }
        });
        btnActuEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarFormActuEliminar();
            }
        });
    }

    private void cargarFormPersona(){
        VPersona personita=new VPersona();
        pnPrincipal.add(personita.getPanelPersona());
        setVisible(true);
    }
//    private void cargarFormLogin(){
//        VLogin logeando=new VLogin();
////        pnPrincipal.add(logeando.getPanelLogin());
//        logeando.setVisible(true);
//    }
    private void cargarFormActuEliminar(){
        VActualizarPersona actu=new VActualizarPersona();
        pnPrincipal.add(actu.getPanelActualizar());
        setVisible(true);
    }
    private void cargarFormLogin2(){
        VLogin2 log=new VLogin2();
//        pnPrincipal.add(logeando.getPanelLogin());
        log.setVisible(true);
    }


}
