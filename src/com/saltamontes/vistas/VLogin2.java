package com.saltamontes.vistas;

import com.saltamontes.controladores.CTrabajador;
import com.saltamontes.modulos.Trabajador;

import javax.swing.*;
import java.awt.event.*;

import static com.saltamontes.modulos.Trabajador.login;

public class VLogin2 extends JDialog {
    private JPanel contentPane;
    private JButton btnIniciar;
    private JButton btnCancelar;
    private JTextField txtUser;
    private JPasswordField txtPassword;
    private Trabajador job;

    public VLogin2() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnIniciar);
        setSize(300, 200);
        setLocationRelativeTo(null);

        btnIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }
    public JPanel getPanelLogin2(){return contentPane;}
    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

//    private void login(){
//        String user=txtUser.getText();
//        String passw=txtPassword.getText();
//        job= CTrabajador.logeando(user,passw);
//
//        try{
//            if(user==null&&passw==null){
//                JOptionPane.showMessageDialog(null,"esapcio en blanco");
//                cleanControls();
//            }else{
//                if(job.login(user,passw)!=null){
//                        JOptionPane.showMessageDialog(null,"logueado");
//                        cleanControls();
//                }else{
//                        JOptionPane.showMessageDialog(null,"no existe trabajador");
//                        cleanControls();
//                }
//            }
//         }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }

    private void login(){
        String user=txtUser.getText();
        String passw=txtPassword.getText();
        job= CTrabajador.logeando(user,passw);

        try{
            if(user.length()>0&&passw.length()>0){
                if(job.login(user,passw)!=null){
                    JOptionPane.showMessageDialog(null,"Logeado");
                    cleanControls();
                }else{
                    JOptionPane.showMessageDialog(null,"Usuario o contraseña son Incorrectos");
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
    private void cleanControls(){
        txtUser.setText(null);
        txtPassword.setText(null);

    }

    public static void main(String[] args) {
        VLogin2 dialog = new VLogin2();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
