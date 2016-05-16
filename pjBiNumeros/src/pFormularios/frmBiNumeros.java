package pFormularios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import pClases.ArregloBiNumeros;

public class frmBiNumeros extends JFrame implements ActionListener {

    JLabel fila, columna, result;
    JTextField tfila, tcolumna;
    JButton generar, sumaf, sumac, salir;
    JTable tabla;
    JList lista;
    JScrollPane s, s2;

    DefaultTableModel modelo = new DefaultTableModel();
    DefaultListModel listas = new DefaultListModel();
    ArregloBiNumeros an;

    public frmBiNumeros() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Matriz de numeros");

        fila = new JLabel("Num Filas");
        tfila = new JTextField();
        fila.setBounds(10, 20, 80, 20);
        tfila.setBounds(10, 50, 80, 30);
        add(fila);
        add(tfila);

        columna = new JLabel("Num Columnas");
        tcolumna = new JTextField();
        columna.setBounds(110, 20, 100, 20);
        tcolumna.setBounds(110, 50, 80, 30);
        add(columna);
        add(tcolumna);

        generar = new JButton("Generar");
        generar.setBounds(30, 100, 100, 30);
        add(generar);
        generar.addActionListener(this);

        // Object[][] values =New Object[4][4];
        Object[][] tamaño = new Object[3][3];
        String[] nombres = {"", "", ""};

        tabla = new JTable(tamaño, nombres);
        s = new JScrollPane(tabla);
        s.setBounds(30, 150, 230, 100);
        add(s);
      //tabla.setModel(modelo);

        sumaf = new JButton("Suma de filas");
        sumaf.setBounds(30, 270, 100, 30);
        add(sumaf);
        sumaf.addActionListener(this);

        sumac = new JButton("Suma de Columnas");
        sumac.setBounds(140, 270, 100, 30);
        add(sumac);
        sumac.addActionListener(this);

        result = new JLabel("Resumen");
        result.setBounds(30, 320, 100, 20);
        add(result);

        lista = new JList();
        s2 = new JScrollPane(lista);
        s2.setBounds(30, 340, 230, 100);
        add(s2);
        lista.setModel(listas);

        salir = new JButton("Salir");
        salir.setBounds(140, 450, 100, 30);
        add(salir);
        salir.addActionListener(this);

    }

    public int getFilas() {
        return Integer.parseInt(tfila.getText());
    }

    public int getColumnas() {
        return Integer.parseInt(tcolumna.getText());
    }
    //ArregloBiNumeros n= new ArregloBiNumeros(f,c);

    void listar() {
        limpiar();
        int x;
        for (int i = 0; i < getFilas(); i++) {
            for (int j = 0; j < getColumnas(); j++) {
                // x=an.Obtener(i, j);
                tabla.setValueAt(an.Obtener(i, j), i, j);

            }
        }
    }

    void limpiar() {
        for (int i = 0; i < getFilas(); i++) {
            for (int j = 0; j < getColumnas(); j++) {
                tabla.setValueAt("", i, j);
            }
        }
    }

    void mensaje(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == salir) {
            System.exit(0);
        }

        if (e.getSource() == generar) {
            try {

                listas.clear();
        //int f=Integer.parseInt(tfila.getText());
                //int c=Integer.parseInt(tcolumna.getText());
                int f = getFilas();
                int c = getColumnas();

                if (f > 0 & c > 0 & f <= 3 & c <= 3) {
                    an = new ArregloBiNumeros(f, c);
                    listar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error de datos");
                }

                /*switch(c){
             
                 case 1:
                 modelo.addColumn("");
                 for (int i = 0; i < f; i++) {
                 modelo.addRow(new Object[]{});
                  
                 // an.Generar();
                 }
                 break;   
           
                 case 2:
                 modelo.addColumn("");
                 modelo.addColumn("");
                 for (int i = 0; i < f; i++) {
                 modelo.addRow(new Object[]{""});
                 }
                 break; 
             
                 case 3:
                 modelo.addColumn("");
                 modelo.addColumn("");
                 modelo.addColumn("");
                 for (int i = 0; i < f; i++) {
                 modelo.addRow(new Object[]{""});
                 }
                 break; 
                
                 case 4:
                 modelo.addColumn("");
                 modelo.addColumn("");
                 modelo.addColumn("");
                 modelo.addColumn("");
                 for (int i = 0; i < f; i++) {
                 modelo.addRow(new Object[]{""});
                 }
                 break;
            
                 default:
                 JOptionPane.showMessageDialog(null,"El tamaño maximo de la tabla es de 4x4");
                 } */
            } catch (Exception ae) {
                JOptionPane.showMessageDialog(null, "Error en la app");
            }

        }

        if (e.getSource() == sumaf){
            int fo = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese un numero de fila"));

            if (fo > getFilas()) 
                mensaje("El numero de filas es superior a la Matriz");
            else 
                listas.addElement("La suma de la fila" + fo + "es : " + an.SumaFila(fo));
            

        }

        if (e.getSource() == sumac) {
            int co = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese un numero de columna"));

            if (co > getColumnas()) 
                mensaje("El numero de Columnas es superior a la matriz ");
            else 
                listas.addElement("La suma de la columa " + co + "es : " + an.SumaColumna(co));
            
        
}
    }

    public static void main(String[] args) {
        frmBiNumeros fo = new frmBiNumeros();
        fo.setBounds(120, 100, 300, 550);
        fo.setVisible(true);
    }

}
