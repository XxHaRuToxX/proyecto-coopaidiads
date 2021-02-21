package com.saltamontes.vistas;

import com.sun.org.apache.xpath.internal.operations.String;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.lang.String.*;

public class Vprueba2 extends JFrame{
    private JPanel panelPrueba2;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton btnImprimir;
    private JPanel panelImprimir;
    private JTable tablaProducto;
    private JScrollPane scrTabla;


    public Vprueba2() {
        setContentPane(panelPrueba2);
        setSize(600,600);
        setDefaultCloseOperation(2);
        scrTabla.setViewportView(tablaProducto);
        scrTabla.reshape(20,260,500,200);
        java.lang.String[][]date=new java.lang.String[][]{{"hola","Hola","hola"},{"hola2","hola2","hola2"},{"hola3","hola3","hola3"}};
        tablaProducto.setModel(new DefaultTableModel(date,new java.lang.String[]{"Columna1","Columna2","Columna3"}));

//        btnImprimir.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Vprueba2 obj=new Vprueba2();
//
//                try {
//                    PrinterJob gap = PrinterJob.getPrinterJob();
//                    gap.setPrintable(new Vprueba2());
//                    gap.printDialog();
//                    if (gap.printDialog()) {
//                        try {
//                            gap.print();
//                        } catch (Exception ex) {
//                            ex.printStackTrace();
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(null, "La impresion se cancelo");
//                    }
//                    boolean top = gap.printDialog();
//                    if (top) {
//                        gap.print();
//                    }
//
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });
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
                        pjob.setPrintable(new Printer(panelImprimir), postformat);
                        if (pjob.printDialog()) {
                            pjob.print();
                        }
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }



//    @Override
//    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
//        if(pageIndex>0){
//            return NO_SUCH_PAGE;
//        }
//        Graphics2D hob=(Graphics2D)graphics;
//        hob.translate(pageFormat.getImageableX()+30,pageFormat.getImageableY()+30);
//        hob.scale(1.0,1.0);
//        panelPrueba2.printAll(graphics);
//        return PAGE_EXISTS;
//    }


    class Printer implements Printable{
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
