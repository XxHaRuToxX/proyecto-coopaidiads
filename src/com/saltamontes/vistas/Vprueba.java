package com.saltamontes.vistas;

import com.saltamontes.modulos.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class Vprueba extends JFrame {
    private JPanel panelPrueba;
    private JButton btnMinimizar;
    private JButton btnCerrar;
    private JLabel lbDesplazar;
    private JButton btnVender;
    private JPanel panelPato;
    private JButton btnImprimir;
    private JTextField txtNumero;
    private JTextField txtNombre;
    private JPanel panelImprimir;
    private JScrollPane srcTabla;
    private JTable tablaProduct;
    private int x;
    private int y;
    private Producto produ;
    private DefaultTableModel modelo;
//    Vprueba.ImageFondo ejemplo=new Vprueba.ImageFondo("/com/saltamontes/assets/fondo.jpeg");
    public Vprueba(){
//        this.setContentPane(ejemplo);
//        ejemplo.add(panelPato);
        panelPato.show();
        setContentPane(panelPrueba);
        lbDesplazar.setBackground(Color.gray);
        lbDesplazar.setOpaque(true);
//        lbDesplazar.setFocusable(false);
//        btnCerrar.setFocusable(false);
//        btnMinimizar.setFocusable(false);
        setUndecorated(true);
        setTitle("Mi menu");
//        setResizable(true);
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        String[]titulos={"ID","PRODUCTO","CANTIDAD","P. UNITARIO","TOTAL"};
        modelo=new DefaultTableModel(null,titulos);
        tablaProduct.setModel(modelo);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeWindowa();
            }
        });

        lbDesplazar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x=e.getX();
                y=e.getY();
            }
        });
        lbDesplazar.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point point=MouseInfo.getPointerInfo().getLocation();
                setLocation(point.x-x,point.y-y);
            }
        });

        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindowa();
            }
        });
        btnMinimizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setExtendedState(ICONIFIED);
            }
        });


        txtNumero.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char validar=e.getKeyChar();
                if(Character.isLetter(validar)){
                    getToolkit().beep();
                    e.consume();
                    JOptionPane.showMessageDialog(rootPane,"Ingrese solo Numeros");
                }
            }
        });
        txtNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char validar=e.getKeyChar();
                if(Character.isDigit(validar)){
                    getToolkit().beep();
                    e.consume();
                    JOptionPane.showMessageDialog(null,"Ingrese solo letras");
                }
            }
        });
        btnVender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                produ=Producto.getStockCriollo();
                float precioC=20;
                float totalC;
                float n1,n2;
                String[] productos={"C. Criollo","C. Tropical","C. Amazonico"};
                String product=String.valueOf(JOptionPane.showInputDialog(null,"Seleccione Producto","Prodcutos",JOptionPane.PLAIN_MESSAGE,null,productos,productos[0]));
                if(product.equalsIgnoreCase("C. Criollo")){
                    n1=Float.parseFloat(JOptionPane.showInputDialog(null,"Ingrese la cantidad del producto"));

                    Object [] fila=new Object[6];
                    fila[0]=product;
                    fila[1]=n1;
                    fila[2]=precioC;
                    fila[3]=(totalC=n1*precioC);
                    modelo.addRow(fila);
                    tablaProduct.setModel(modelo);
                }

            }
        });
    }
    private void closeWindowa(){

        String botones[]={"Cerrar","Cancelar"};
        int eleccion=JOptionPane.showOptionDialog(this,"¿Desea Cerrar la aplicacion?","Titulo",
                0,0,null,botones,this);
        ;
        if(eleccion==JOptionPane.YES_OPTION){
            System.exit(0);
        }else{
            System.out.println("Se cancelo el cierre");
        }
    }
    private  void obtenerVista(){
        Vprueba2 obj=new Vprueba2();
        panelImprimir.add(obj);
        obj.setVisible(true);
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
