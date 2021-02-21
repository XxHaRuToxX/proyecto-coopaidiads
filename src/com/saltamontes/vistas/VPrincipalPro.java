package com.saltamontes.vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VPrincipalPro extends JFrame {
    private JPanel panelPro;
    private JButton btnAdministrador;
    private JButton btnContador;
    private JLabel lblLogo;
    private JButton btnAlmacenero;
    private JButton btnCliente;
    private JLabel lblAdministrador;
    private JLabel lblContador;
    private JLabel lblAlmacenero;
    private JLabel lblCliente;


//    private JDesktopPane dpanEscritorio;

    ImageFondo ejemplo=new ImageFondo("/com/saltamontes/assets/frutocacao.jpg");
    public VPrincipalPro() {
        this.setContentPane(ejemplo);
        ejemplo.add(lblLogo);
        lblLogo.show();
        ejemplo.add(lblAdministrador);
        lblAdministrador.show();
        ejemplo.add(btnAdministrador);
        btnAdministrador.show();

        ejemplo.add(lblContador);
        lblContador.show();
        ejemplo.add(btnContador);
        btnContador.show();

        ejemplo.add(lblAlmacenero);
        lblAlmacenero.show();;
        ejemplo.add(btnAlmacenero);
        btnAlmacenero.show();

        ejemplo.add(lblCliente);
        lblCliente.show();
        ejemplo.add(btnCliente);
        btnCliente.show();





//        dpanEscritorio=new JDesktopPane();
        setTitle("Menu Principal");
//        setContentPane(dpanEscritorio);
        setSize(398, 750);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);




        btnAdministrador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    cargarFormLogin("Administrador");
                    dispose();

            }
        });
        btnContador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarFormLogin("Contador");
                dispose();

            }
        });
        btnAlmacenero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarFormLogin("Almacenero");
                dispose();
            }
        });
    }

    private void cargarFormLogin(String cargo){
        VLogin logeando=new VLogin(cargo);
//        pnPrincipal.add(logeando.getPanelLogin());
        logeando.setVisible(true);
    }
    private void cargarFormLogin2(){
        VLogin2 log=new VLogin2();
//        pnPrincipal.add(logeando.getPanelLogin());
        log.setVisible(true);
    }
    private void closeWindowa(){

        String botones[]={"Cerrar","Cancelar"};
        int eleccion=JOptionPane.showOptionDialog(this,"¿Desea Cerrar la aplicacion?","Titulo",
                0,0,null,botones,this);
        ;
        if(eleccion==JOptionPane.YES_OPTION){
            System.exit(0);
            VPrincipalPro obj=new VPrincipalPro();
            obj.setVisible(true);
        }else{
            System.out.println("Se cancelo el cierre");
        }
    }

    class ImageFondo extends JPanel{
//         private Image imagen;
//         public void paint(Graphics g){
//             imagen=new ImageIcon(getClass().getResource("/com/saltamontes/assets/fondo.jpeg")).getImage();
//             g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
//             setOpaque(false);
//             super.paint(g);
//         }
        ImageIcon imagen;
        String nombre;
        public ImageFondo(String nombre){
            this.nombre=nombre;
        }
        public void paint(Graphics g){
            Dimension tamanio=getSize();
            imagen=new ImageIcon(getClass().getResource(nombre));
            g.drawImage(imagen.getImage(),0,0,tamanio.width,tamanio.height,null);
            setOpaque(false);
            super.paint(g);
        }
    }

}
