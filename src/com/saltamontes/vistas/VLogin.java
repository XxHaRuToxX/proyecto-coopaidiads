package com.saltamontes.vistas;

import com.saltamontes.controladores.CTrabajador;
import com.saltamontes.modulos.Trabajador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.saltamontes.modulos.Trabajador.login;
import com.saltamontes.vistas.VPrincipalPro;
public class VLogin extends JFrame {
    private JTextField txtUsuario;
    private JPanel panelLogin;
    private JPasswordField txtContra;
    private JButton btnLogeando;
    private JTextField txtCargo;
    private JComboBox boxCargo;
    private Trabajador job;
    private VPrincipalPro obj;
    private String cargo;



    public VLogin(String cargo) {
        setContentPane(panelLogin);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        this.cargo=cargo;
        btnLogeando.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if(cargo.equals("Administrador")){
                logearseAdministrador();
            }else {
                if(cargo.equals("Contador")){
                    logearseContador();
                }else{
                    if(cargo.equals("Almacenero")){
                        logearseAlmacenero();
                    }
                }

            }

            }
        });
    }

    public JPanel getPanelLogin(){return panelLogin;}
    private void logearseAdministrador(){
        String usuario=txtUsuario.getText();
        String password=txtContra.getText();

//        job= CTrabajador.logeando(usuario,password);
            job=Trabajador.login(usuario,password);
        try{
            if(verificarEspacio()){
                    if(job!=null&&job.getCargo().equals("Administrador")){
                            VPersona per = new VPersona();
                            per.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null,"Contraseña o Usuario son incorrectos");
                        cleanControls();
                    }

            }else{
                JOptionPane.showMessageDialog(null,"Favor Complete los espacios");
                cleanControls();

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    private void logearseContador(){
        String usuario=txtUsuario.getText();
        String password=txtContra.getText();
        job=Trabajador.login(usuario,password);
        if(verificarEspacio()){
            if(job!=null&&job.getCargo().equals("Contador")){
                VContador obj = new VContador();
                obj.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,"Contraseña o Usuario son incorrectos");
                cleanControls();
            }

        }else{
            JOptionPane.showMessageDialog(null,"Favor Complete los espacios");
            cleanControls();

        }

    }
    private void logearseAlmacenero(){
        String usuario=txtUsuario.getText();
        String password=txtContra.getText();
        job=Trabajador.login(usuario,password);
        if(verificarEspacio()){
            if(job!=null&&job.getCargo().equals("Almacenero")){
                VAlmacenero obj = new VAlmacenero();
                obj.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,"Contraseña o Usuario son incorrectos");
                cleanControls();
            }

        }else{
            JOptionPane.showMessageDialog(null,"Favor Complete los espacios");
            cleanControls();

        }

    }
    private boolean verificarEspacio(){
        String usuario=txtUsuario.getText();
        String password=txtContra.getText();
        if(usuario.length()>0&&password.length()>0){
            return true;
        }else{
            return false;
        }
    }
    private void cleanControls(){
        txtUsuario.setText(null);
        txtContra.setText(null);

    }


}
