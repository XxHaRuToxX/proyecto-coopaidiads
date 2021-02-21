package com.saltamontes.vistas;

import com.saltamontes.modulos.Cliente;
import com.saltamontes.modulos.Producto;
import com.saltamontes.modulos.TextPrompt;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Date;

import static java.lang.System.*;


public class VBoleta extends JInternalFrame {
    private JPanel panelGeneral;
    private JPanel panelBoleta;
    private JScrollPane scrPanel;
    private JTable tablaProductos;
    private JButton btnImprimir;
    private JTextField txtClienteB;
    private JTextField txtDireccionB;
    private JTextField txtDniB;
    private JTextField txtTelefonoB;
    private JButton btnVender;
    private JTextField txtBuscarC;
    private JTextField txtCantidadV;
    private JComboBox boxVentaV;
    private JLabel lblFechaB;
    private Producto prod;
    private Cliente job;
    private DefaultTableModel modelo;
    private TextPrompt nuevo;
    private float cant;
    public VBoleta(){
        setClosable(true);
        setIconifiable(true);
        setResizable(false);
        setTitle("Boleta");
        setLayout(null);
        setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        setSize(550,510);
//        String[][]date=new String[][]{{"1","C. Criollo","2","3.00","6.00"},{"2","C. Tropical","3","4.00","12.00"},{"3","C. Criollo","2","3.00","6.00"}};
        String[]titulos={"CANTIDAD","PRODUCTO","PRECIO UNITARIO","TOTAL"};
        tablaProductos.setModel(new DefaultTableModel(null,titulos));
        modelo =(DefaultTableModel) tablaProductos.getModel();

        dimensionColumnas();
        add(panelBoleta);
        add(btnImprimir);
        add(btnVender);
        add(txtBuscarC);
        add(txtCantidadV);
        add(boxVentaV);
        nuevo=new TextPrompt("USUARIO",txtBuscarC);
        nuevo=new TextPrompt("DNI",txtDniB);

        panelBoleta.reshape(20,20,510,420);
        scrPanel.reshape(20,260,400,50);
        btnImprimir.reshape(20,450,90,20);
        txtBuscarC.reshape(130,450,100,20);
        btnVender.reshape(250,450,80,20);
        boxVentaV.reshape(350,450,80,20);
        txtCantidadV.reshape(450,450,80,20);





        txtBuscarC.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    job = Cliente.getCliente(txtBuscarC.getText());
                    if (job == null) {
                        JOptionPane.showMessageDialog(null, "no existe Cliente");
                    } else {
                        mostrarDatos();
                    }
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
                        pjob.setPrintable(new VBoleta.Printer(panelBoleta), postformat);
                        if (pjob.printDialog()) {
                            pjob.print();
                        }
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        btnVender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                produ= Producto.getStockCriollo();
                registroTabla();


            }
        });
    }
    private void registroTabla(){
        if(catchProduct()){
            float total=Float.parseFloat(String.valueOf(cant*prod.getPreciop()));
            modelo.addRow(new Object[]{cant,prod.getNombrep(),String.valueOf(prod.getPreciop()),String.valueOf(total)});
        }else{
            JOptionPane.showMessageDialog(null,"No se agregaron productos");
        }
    }
    public boolean catchProduct(){

        String[] productos={"Seleccione-Producto","C. Criollo","C. Tropical","C. Amazonico"};
        String produ=String.valueOf(JOptionPane.showInputDialog(null,"Seleccione Producto","Prodcutos",JOptionPane.QUESTION_MESSAGE,null,productos,productos[0]));
        if(!produ.equals("Seleccione-Producto")){
            prod=Producto.getProductoNombre(produ);
            if(prod!=null){
                return catchCant();
            }else{
//                JOptionPane.showMessageDialog(this,"Se cancelo la operacion");
                  return false;
            }
        }else{
            JOptionPane.showMessageDialog(this,"No se selecciono ningun producto");
            return catchProduct();
        }

    }
    private boolean catchCant(){
        String cantidad = JOptionPane.showInputDialog(null, "Ingrese la cantidad del producto");
        if(cantidad!=null){
            if(cantidad.trim().length()>0&&cantidad.trim().matches("\\d*")){
                cant=Float.parseFloat(cantidad);
                return true;
            }else{
                JOptionPane.showMessageDialog(null,"Ingrese una cantidad valida");
                return catchCant();
            }
        }else{
            JOptionPane.showMessageDialog(null,"Operacion Cancelada");
            return false;
        }
    }
    public void dimensionColumnas(){
        TableColumnModel modeloColumna=tablaProductos.getColumnModel();
        modeloColumna.getColumn(0).setMaxWidth(90);
        modeloColumna.getColumn(1).setMaxWidth(200);
        modeloColumna.getColumn(2).setMaxWidth(150);
        modeloColumna.getColumn(3).setMaxWidth(70);
    }
    public void mostrarDatos(){
        Date dia=new Date(System.currentTimeMillis());
        txtClienteB.setText(job.getNombres()+" "+job.getApellidos());
        txtDniB.setText(job.getDni());
        txtDireccionB.setText(job.getDireccion());
        txtTelefonoB.setText(job.getTelefono());
        lblFechaB.setText((dia.getDay()+23)+"/"+(dia.getMonth()+1)+"/"+(dia.getYear()+1900));
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
