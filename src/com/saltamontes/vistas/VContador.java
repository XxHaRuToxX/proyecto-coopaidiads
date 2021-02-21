package com.saltamontes.vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class VContador extends JFrame {
    private JPanel panelPrincipalTrabajador;
    private JPanel panelArchivoClientes;
    private JMenuBar mnbFactura;
    private JMenu mnuArchivo;
    private JMenu mnuMovimientos;
    private JMenu mnuAyuda;
    private JMenu mnuSalir;
    private JMenuItem mnuArchivoClientes;
    private JMenuItem mnuArchivoProductos;
    private JMenuItem mnuArchivoProveedores;
    private JMenuItem mnuMovimientoCaja;
    private JMenuItem mnuMovimientoBoleta;
    private JMenuItem mnuAyudaSistema;

    private JMenuItem mnuSalirWindows;
    private JSeparator separador;
//    private JButton btnCloseWindows;
//    private JButton btnDesplazarse;
    private int x;
    private int y;
//    private JDesktopPane pnlEscritorio;



    ImageFondo contador=new ImageFondo("/com/saltamontes/assets/fondoConta.jpeg");
    public VContador(){
        this.setContentPane(contador);
//        setContentPane(panelPrincipalTrabajador);
//        lbDesplazar.setBackground(Color.gray);
//        lbDesplazar.setOpaque(true);
//        lbDesplazar.setFocusable(false);
//        btnCerrar.setFocusable(false);
//        btnMinimizar.setFocusable(false);
        setUndecorated(true);
        setTitle("Contador");
        setResizable(true);
        setSize(550,548);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);



//        btnCloseWindows=new JButton("Cerrar");
        separador=new JSeparator();
        mnbFactura=new JMenuBar();
        mnuArchivo=new JMenu("Archivo");
        mnuMovimientos=new JMenu("Movimientos");
        mnuAyuda=new JMenu("Ayuda");
        mnuSalir=new JMenu("Salir");
        mnuArchivoClientes=new JMenuItem("Clientes");
        mnuArchivoProductos=new JMenuItem("Productos");
        mnuArchivoProveedores=new JMenuItem("Proveedores");
        mnuMovimientoCaja=new JMenuItem("Caja Chica");
        mnuMovimientoBoleta=new JMenuItem("Boleta");
        mnuAyudaSistema=new JMenuItem("Ayuda de Soporte");
        mnuSalirWindows=new JMenuItem("Salir de la Aplicación");
//        pnlEscritorio=new JDesktopPane();

        Icon icoArchivo=new ImageIcon(getClass().getResource("/com/saltamontes/assets/archivos.png"));
        Icon icoMovimientos=new ImageIcon(getClass().getResource("/com/saltamontes/assets/movimientos.png"));
        Icon icoAyuda=new ImageIcon(getClass().getResource("/com/saltamontes/assets/ayuda.png"));
        Icon icoSalida=new ImageIcon(getClass().getResource("/com/saltamontes/assets/salida.png"));
        Icon icoArchivoClientes=new ImageIcon(getClass().getResource("/com/saltamontes/assets/contacto.png"));
        Icon icoArchivoProductos=new ImageIcon(getClass().getResource("/com/saltamontes/assets/productos.png"));
        Icon icoArchivoProveedores=new ImageIcon(getClass().getResource("/com/saltamontes/assets/proveedores.png"));
        Icon icoMovimientoCaja=new ImageIcon(getClass().getResource("/com/saltamontes/assets/caja.png"));
        Icon icoMovimientoBoleta=new ImageIcon(getClass().getResource("/com/saltamontes/assets/boleta.png"));
        Icon icoAyudaSistema=new ImageIcon(getClass().getResource("/com/saltamontes/assets/ayudasistema.png"));
        Icon icoSalirWindows=new ImageIcon(getClass().getResource("/com/saltamontes/assets/salirsi.png"));

        //Asignacion de iconos
        mnuArchivo.setIcon(icoArchivo);
        mnuMovimientos.setIcon(icoMovimientos);
        mnuAyuda.setIcon(icoAyuda);
        mnuSalir.setIcon(icoSalida);
        mnuArchivoClientes.setIcon(icoArchivoClientes);
        mnuArchivoProductos.setIcon(icoArchivoProductos);
        mnuArchivoProveedores.setIcon(icoArchivoProveedores);
        mnuMovimientoCaja.setIcon(icoMovimientoCaja);
        mnuMovimientoBoleta.setIcon(icoMovimientoBoleta);
        mnuAyudaSistema.setIcon(icoAyudaSistema);
        mnuSalirWindows.setIcon(icoSalirWindows);
        
        mnuArchivo.add(mnuArchivoClientes);
        mnuArchivo.add(mnuArchivoProductos);
        mnuArchivo.add(mnuArchivoProveedores);
        mnbFactura.add(mnuArchivo);

        mnuMovimientos.add(mnuMovimientoCaja);
        mnuMovimientos.add(mnuMovimientoBoleta);
        mnbFactura.add(mnuMovimientos);

        mnuAyuda.add(mnuAyudaSistema);
        mnbFactura.add(mnuAyuda);

        mnuSalir.add(mnuSalirWindows);
        mnbFactura.add(mnuSalir);

        separador.setBackground(Color.white);
        separador.setEnabled(false);
        mnbFactura.add(separador);
//        mnbFactura.add(btnCloseWindows);

        setJMenuBar(mnbFactura);
//        setContentPane(pnlEscritorio);

        mnuArchivoClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador.add(panelArchivoClientes);
                panelArchivoClientes.show();
                mostrarArclivoClientes();
            }
        });
        mnuArchivoProveedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarArclivoProveedores();
            }
        });
        mnuMovimientoBoleta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarArclivoBoleta();
            }
        });

        mnuSalirWindows.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SalirVentana();
            }
        });
        separador.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x=e.getX();
                y=e.getY();
            }
        });
        separador.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point point=MouseInfo.getPointerInfo().getLocation();
                setLocation(point.x-x,point.y-y);
            }
        });

    }
    private void SalirVentana(){
        System.exit(0);
    }

    private void mostrarArclivoClientes(){
        VArchivoClientes obj=new VArchivoClientes();
        contador.add(obj);
        obj.show();
    }
    private void mostrarArclivoProveedores(){
        VArchivoProveedores obj=new VArchivoProveedores();
        contador.add(obj);
        obj.show();

    }
    private void mostrarArclivoBoleta(){
        VBoleta obj=new VBoleta();
        contador.add(obj);
        obj.show();

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
