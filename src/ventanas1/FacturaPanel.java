/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
/**
 *
 * @author User
 */
public class FacturaPanel extends javax.swing.JPanel implements Printable{

   
    Connection con ;
    Statement stmt;
    ResultSet rs;
    int cont2 = 1;
    int conTotal = 0;
    int contadorSuma = 0;
    boolean sw1 = false;
    DefaultTableModel modelo = new DefaultTableModel();
    

        
    String datos[] = new String [6];
    
    
    public FacturaPanel() {
        initComponents(); 
        jLabelFecha1.setText(fecha());
        buscarCliente();
        AutoCompleteDecorator.decorate(jComboBoxCliente);
        
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ModificarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        modelo.addColumn("ID");
        modelo.addColumn("CÓDIGO");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("PRECIO COMPRA");
        modelo.addColumn("PRECIO DE VENTA");
        modelo.addColumn("GANANCIA");

        
    }
    
    void buscarProducto(String buscar){

        try {
             
            con = DriverManager.getConnection(url, user, clave);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario WHERE codigo LIKE '%"+buscar+"%' OR nombre LIKE '%"+buscar+"%'");

                while(rs.next()){
                if(Integer.parseInt(rs.getString(7))<1){
                    JOptionPane.showMessageDialog(null, "El producto ya está vendido");
                    return;  
                }else{
                datos[0]= String.valueOf(cont2);
                datos[1]= rs.getString(2);
                datos[2]= rs.getString(8) + " "+rs.getString(12)+"-"+rs.getString(9);
                datos[3]= "1";
                datos[4]= String.valueOf(rs.getString(5));
                datos[5]= String.valueOf(Integer.parseInt(datos[4])*Integer.parseInt(datos[3]));
                }
                }
                if(datos[1]==null){
                    sw1 = true;
                }else{
                    modelo.addRow(datos); 
                    cont2 ++;
                    sw1 = false;
                }
            
            TablaSeleccionados.setModel(modelo);
            TableColumn columna = TablaSeleccionados.getColumn("ID");
            TableColumn columna1 = TablaSeleccionados.getColumn("CÓDIGO");
            TableColumn columna2 = TablaSeleccionados.getColumn("NOMBRE");
            TableColumn columna3 = TablaSeleccionados.getColumn("PRECIO COMPRA");
            TableColumn columna4 = TablaSeleccionados.getColumn("PRECIO DE VENTA");
            TableColumn columna5 = TablaSeleccionados.getColumn("GANANCIA");
            
            columna.setMinWidth(28);
            columna.setMaxWidth(28);
            columna1.setMinWidth(98);
            columna1.setMaxWidth(98);
            columna2.setMinWidth(167);
            columna2.setMaxWidth(167);
            columna3.setMinWidth(62);
            columna3.setMaxWidth(62);
            columna4.setMinWidth(89);
            columna4.setMaxWidth(89);
            columna5.setMinWidth(105);
            columna5.setMaxWidth(105);
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductosFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    void seleccionarCliente(String sele){

        try {
             
            con = DriverManager.getConnection(url, user, clave);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cliente WHERE id LIKE '%"+sele+"%' OR nombre LIKE '%"+sele+"%' ORDER BY nombre ASC");

                while(rs.next()){
                    jLabelId.setText(rs.getString(4));
                    jLabelCedula1.setText(rs.getString(2));
                    jTextFieldCorreo.setText(rs.getString(3));
                    jTextFieldDeudas.setText(rs.getString(7));
                }

        } catch (SQLException ex) {
            Logger.getLogger(FacturaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void buscarCliente(){
        try {
             
            con = DriverManager.getConnection(url, user, clave);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cliente ORDER BY nombre ASC ");

                while(rs.next()){
                    jComboBoxCliente.addItem(rs.getString(1));
                }
        
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductosFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelId = new javax.swing.JLabel();
        jTextFieldDeudas = new javax.swing.JTextField();
        jComboBoxTerminos = new javax.swing.JComboBox<>();
        jTextFieldAbono = new javax.swing.JTextField();
        Correo3 = new javax.swing.JLabel();
        Cliente2 = new javax.swing.JLabel();
        Correo2 = new javax.swing.JLabel();
        jLabelPresentado1 = new javax.swing.JLabel();
        jLabelNumeroFactura1 = new javax.swing.JLabel();
        jLabelFecha1 = new javax.swing.JLabel();
        jLabelNPagina1 = new javax.swing.JLabel();
        jLabelContado = new javax.swing.JLabel();
        jLabelCedula1 = new javax.swing.JLabel();
        jTextFieldTotal = new javax.swing.JTextField();
        TablaSeleccionados = new javax.swing.JTable();
        jTextFieldBuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        jTextFieldCorreo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Cliente = new javax.swing.JLabel();
        Correo1 = new javax.swing.JLabel();
        Cliente1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelId.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabelId.setText("ID");
        add(jLabelId, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 30, 20));

        jTextFieldDeudas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDeudasKeyTyped(evt);
            }
        });
        add(jTextFieldDeudas, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 260, 200, 30));

        jComboBoxTerminos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CONTADO", "CRÉDITO" }));
        jComboBoxTerminos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxTerminosMouseClicked(evt);
            }
        });
        jComboBoxTerminos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTerminosActionPerformed(evt);
            }
        });
        add(jComboBoxTerminos, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 310, 200, 30));

        jTextFieldAbono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldAbonoKeyTyped(evt);
            }
        });
        add(jTextFieldAbono, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 360, 200, 30));

        Correo3.setBackground(new java.awt.Color(204, 0, 51));
        Correo3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Correo3.setForeground(new java.awt.Color(255, 255, 255));
        Correo3.setText("ABONAR:");
        add(Correo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 360, 60, 30));

        Cliente2.setBackground(new java.awt.Color(204, 0, 51));
        Cliente2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Cliente2.setForeground(new java.awt.Color(255, 255, 255));
        Cliente2.setText("TÉRMINOS:");
        add(Cliente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, 80, 30));

        Correo2.setBackground(new java.awt.Color(204, 0, 51));
        Correo2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Correo2.setForeground(new java.awt.Color(255, 255, 255));
        Correo2.setText("DEUDAS:");
        add(Correo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, 60, 30));

        jLabelPresentado1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabelPresentado1.setText("Presentado");
        add(jLabelPresentado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 190, 30));

        jLabelNumeroFactura1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabelNumeroFactura1.setText("Numero");
        add(jLabelNumeroFactura1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 36, 70, 20));

        jLabelFecha1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        add(jLabelFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 70, 20));

        jLabelNPagina1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabelNPagina1.setText("1");
        add(jLabelNPagina1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 66, 70, -1));

        jLabelContado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabelContado.setText("CONTADO");
        add(jLabelContado, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 70, 20));

        jLabelCedula1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabelCedula1.setText("C.C");
        add(jLabelCedula1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 174, 70, 10));

        jTextFieldTotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldTotal.setText("0");
        jTextFieldTotal.setBorder(null);
        jTextFieldTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTotalActionPerformed(evt);
            }
        });
        add(jTextFieldTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 665, 90, 20));

        TablaSeleccionados.setBackground(new Color(0, 0, 0, 0));
        ((DefaultTableCellRenderer)TablaSeleccionados.getDefaultRenderer(Object.class)).setBackground(new Color(0, 0, 0, 0));
        TablaSeleccionados.setGridColor(Color.WHITE);
        TablaSeleccionados.setAutoCreateRowSorter(true);
        TablaSeleccionados.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TablaSeleccionados.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TablaSeleccionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaSeleccionados.setAutoscrolls(false);
        TablaSeleccionados.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        TablaSeleccionados.setGridColor(new java.awt.Color(255, 255, 255));
        TablaSeleccionados.setOpaque(false);
        TablaSeleccionados.setSelectionBackground(new java.awt.Color(51, 51, 255));
        TablaSeleccionados.setShowGrid(false);
        TablaSeleccionados.getTableHeader().setReorderingAllowed(false);
        TablaSeleccionados.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                TablaSeleccionadosMouseMoved(evt);
            }
        });
        TablaSeleccionados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaSeleccionadosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaSeleccionadosMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TablaSeleccionadosMouseReleased(evt);
            }
        });
        TablaSeleccionados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TablaSeleccionadosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TablaSeleccionadosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TablaSeleccionadosKeyTyped(evt);
            }
        });
        add(TablaSeleccionados, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 550, 460));

        jTextFieldBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBuscarActionPerformed(evt);
            }
        });
        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyTyped(evt);
            }
        });
        add(jTextFieldBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, 190, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("ELIMINAR DATO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 410, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("REGISTRAR CLIENTE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 450, -1, -1));

        jComboBoxCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxClienteMouseClicked(evt);
            }
        });
        jComboBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxClienteActionPerformed(evt);
            }
        });
        add(jComboBoxCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, 200, 30));
        add(jTextFieldCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, 200, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel2.setText("        Vendedor                                      Moneda                           Tipo Comprobante");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 400, 10));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Factura");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setText("Fecha");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, 20));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel5.setText("Número");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, -1, 10));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel6.setText("Página");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, -1, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel7.setText("Santa Rosa de Osos");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 20));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel8.setText("TEL: 319 3574617");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel10.setText("No somos responsables del IVA");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel11.setText("Presentado a:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 80, 80, 40));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel13.setText("    Código Cliente                                Cédula                                   Referencia                            Términos");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 550, 50));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel14.setText("TOTAL:");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 650, 40, 50));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel15.setText("Itm    Código Producto              Descripción Producto              Cantidad           Precio                     Importe");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 530, 50));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel16.setText("Aviso:");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 630, 40, 20));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel17.setText("Firma:");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 660, 40, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes1/FacturaSinLetras.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Cliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Cliente.setForeground(new java.awt.Color(255, 255, 255));
        Cliente.setText("CÓDIGO:");
        add(Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 80, 30));

        Correo1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Correo1.setForeground(new java.awt.Color(255, 255, 255));
        Correo1.setText("CORREO:");
        add(Correo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, -1, -1));

        Cliente1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Cliente1.setForeground(new java.awt.Color(255, 255, 255));
        Cliente1.setText("CLIENTE:");
        add(Cliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, -1, 20));
    }// </editor-fold>//GEN-END:initComponents
    public static String fecha(){
       Date fecha = new Date();
       SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
       return formatofecha.format(fecha);
    }
    private void jTextFieldBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyTyped
        
    }//GEN-LAST:event_jTextFieldBuscarKeyTyped

    private void jTextFieldBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyReleased
       
    }//GEN-LAST:event_jTextFieldBuscarKeyReleased

    private void TablaSeleccionadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaSeleccionadosMouseClicked
    
    }//GEN-LAST:event_TablaSeleccionadosMouseClicked

    private void TablaSeleccionadosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablaSeleccionadosKeyReleased
    int fila = TablaSeleccionados.getSelectedRow();
    if(fila>=0){
        
        String v3 = (String) TablaSeleccionados.getValueAt(fila, 5);
        contadorSuma = contadorSuma - Integer.parseInt(v3);    
        if(fila >= 0){
            int v1 = Integer.parseInt((String) TablaSeleccionados.getValueAt(fila, 4));
            int v2 = Integer.parseInt((String) TablaSeleccionados.getValueAt(fila, 3));
            String mult = String.valueOf(v1 * v2) ;        
            TablaSeleccionados.setValueAt(mult, fila, 5);
            modelo.fireTableDataChanged();
        }

        String v2 = (String) TablaSeleccionados.getValueAt(fila, 5);
        contadorSuma = Integer.parseInt(v2) + contadorSuma ;
        String Suma = String.valueOf(contadorSuma);
        jTextFieldTotal.setText(Suma);
    }
    }//GEN-LAST:event_TablaSeleccionadosKeyReleased

    private void TablaSeleccionadosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablaSeleccionadosKeyTyped
    int fila = TablaSeleccionados.getSelectedRow();
    if(fila>=0){
        
        String v3 = (String) TablaSeleccionados.getValueAt(fila, 5);
        contadorSuma = contadorSuma - Integer.parseInt(v3);    
        if(fila >= 0){
            int v1 = Integer.parseInt((String) TablaSeleccionados.getValueAt(fila, 4));
            int v2 = Integer.parseInt((String) TablaSeleccionados.getValueAt(fila, 3));
            String mult = String.valueOf(v1 * v2) ;        
            TablaSeleccionados.setValueAt(mult, fila, 5);
            modelo.fireTableDataChanged();
        }

        String v2 = (String) TablaSeleccionados.getValueAt(fila, 5);
        contadorSuma = Integer.parseInt(v2) + contadorSuma ;
        String Suma = String.valueOf(contadorSuma);
        jTextFieldTotal.setText(Suma);
    }
        
        
    }//GEN-LAST:event_TablaSeleccionadosKeyTyped

    private void jTextFieldBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscarActionPerformed
       
       if(cont2<24){
           
       
            boolean sw = false;
            for(int i = 0; i < modelo.getRowCount(); i ++){
                if(TablaSeleccionados.getValueAt(i, 1).equals(jTextFieldBuscar.getText()) || 
                        TablaSeleccionados.getValueAt(i, 1).equals(jTextFieldBuscar.getText()) ){
                         sw = true ;
                }
                
                for(int j=0; j<modelo.getRowCount(); j++){
                  if(j!=i){
                    if(TablaSeleccionados.getValueAt(i, 1).equals(TablaSeleccionados.getValueAt(j, 1))){
                    sw = true;
                        }
                    } 
                }
                
            }if(sw == true){
                JOptionPane.showMessageDialog(null, "El producto ya está registrado");
                jTextFieldBuscar.setText("");
            }else{
                
                buscarProducto(jTextFieldBuscar.getText());
                jTextFieldBuscar.setText("");
                
                if(sw1==false && datos[2]!=null){
                    int v1 = contadorSuma;

                    String v2 = (String) TablaSeleccionados.getValueAt(conTotal, 5);
                    contadorSuma = Integer.parseInt(v2) + contadorSuma ;
                    String Suma = String.valueOf(contadorSuma);
                    jTextFieldTotal.setText(Suma);

                     conTotal ++;
                     datos[2] = null;
                }else{
                    jTextFieldBuscar.setText("");
                    if(modelo.getRowCount() - 1>0){
                        cont2 --;
                        modelo.removeRow(modelo.getRowCount()-1);
                    }
                    
                    JOptionPane.showMessageDialog(null, "El producto no se encuentra registrado");  
                }
            }
       }else{
           JOptionPane.showMessageDialog(null, "No puede ingresar más productos en esta hoja\nimprima esta hoja y cree nueva hoja");
       }
    }//GEN-LAST:event_jTextFieldBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int fila = TablaSeleccionados.getSelectedRow();
        if(fila >= 0){
            int j = fila + 1 ;
            
            for(int i = fila + 1; i < modelo.getRowCount() ; i++){
                TablaSeleccionados.setValueAt(j, i, 0);
                j++;
            }
            contadorSuma = contadorSuma - Integer.parseInt((String) TablaSeleccionados.getValueAt(fila, 5));
            jTextFieldTotal.setText(String.valueOf(contadorSuma));
            modelo.removeRow(fila);
            modelo.fireTableDataChanged();
            cont2 = modelo.getRowCount() + 1;
            conTotal --;
            
        }else{
            JOptionPane.showMessageDialog(null, "Seleccionar fila");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TablaSeleccionadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaSeleccionadosMouseReleased
        
    }//GEN-LAST:event_TablaSeleccionadosMouseReleased

    private void jTextFieldTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTotalActionPerformed

    private void jComboBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxClienteActionPerformed
        String selectedValue = jComboBoxCliente.getSelectedItem().toString();
        jLabelPresentado1.setText(selectedValue);
        seleccionarCliente(selectedValue);
    }//GEN-LAST:event_jComboBoxClienteActionPerformed

    private void jComboBoxClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxClienteMouseClicked
        
    }//GEN-LAST:event_jComboBoxClienteMouseClicked

    private void TablaSeleccionadosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablaSeleccionadosKeyPressed
    int fila = TablaSeleccionados.getSelectedRow();
    if(fila>=0 ){
        
        
        String v3 = (String) TablaSeleccionados.getValueAt(fila, 5);
        contadorSuma = contadorSuma - Integer.parseInt(v3);    
        if(fila >= 0){
            int v1 = Integer.parseInt((String) TablaSeleccionados.getValueAt(fila, 4));
            int v2 = Integer.parseInt((String) TablaSeleccionados.getValueAt(fila, 3));
            String mult = String.valueOf(v1 * v2) ;        
            TablaSeleccionados.setValueAt(mult, fila, 5);
            modelo.fireTableDataChanged();
        }

        String v2 = (String) TablaSeleccionados.getValueAt(fila, 5);
        contadorSuma = Integer.parseInt(v2) + contadorSuma ;
        String Suma = String.valueOf(contadorSuma);
        jTextFieldTotal.setText(Suma);
    }    
    

    }//GEN-LAST:event_TablaSeleccionadosKeyPressed

    private void TablaSeleccionadosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaSeleccionadosMousePressed
    
    }//GEN-LAST:event_TablaSeleccionadosMousePressed

    private void TablaSeleccionadosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaSeleccionadosMouseMoved
    int fila = TablaSeleccionados.getSelectedRow();
    if(fila<0){
       for(int i=0; i<TablaSeleccionados.getRowCount(); i++){
            String v3 = (String) TablaSeleccionados.getValueAt(i, 5);
            contadorSuma = contadorSuma - Integer.parseInt(v3);    
        
            int v1 = Integer.parseInt((String) TablaSeleccionados.getValueAt(i, 4));
            int v2 = Integer.parseInt((String) TablaSeleccionados.getValueAt(i, 3));
            String mult = String.valueOf(v1 * v2) ;        
            TablaSeleccionados.setValueAt(mult, i, 5);
            modelo.fireTableDataChanged();
        

            String v4 = (String) TablaSeleccionados.getValueAt(i, 5);
            contadorSuma = Integer.parseInt(v4) + contadorSuma ;
            String Suma = String.valueOf(contadorSuma);
            jTextFieldTotal.setText(Suma);
        } 
    }    
        
        
    }//GEN-LAST:event_TablaSeleccionadosMouseMoved

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Window w = SwingUtilities.getWindowAncestor(FacturaPanel.this);
        w.setVisible(false);
        RegistrarCliente R = new RegistrarCliente();
        R.setVisible(true);
        Inicio I = new Inicio();
        I.setVisible(false);
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextFieldDeudasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDeudasKeyTyped
        char n = evt.getKeyChar();
        if(n < '0' || n> '9') evt.consume();

    }//GEN-LAST:event_jTextFieldDeudasKeyTyped

    private void jComboBoxTerminosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxTerminosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTerminosMouseClicked

    private void jComboBoxTerminosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTerminosActionPerformed
        String selectedValue = jComboBoxTerminos.getSelectedItem().toString();
        jLabelContado.setText(selectedValue);
    }//GEN-LAST:event_jComboBoxTerminosActionPerformed

    private void jTextFieldAbonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAbonoKeyTyped
        char n = evt.getKeyChar();
        if(n < '0' || n> '9') evt.consume();
    }//GEN-LAST:event_jTextFieldAbonoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cliente;
    private javax.swing.JLabel Cliente1;
    private javax.swing.JLabel Cliente2;
    private javax.swing.JLabel Correo1;
    private javax.swing.JLabel Correo2;
    private javax.swing.JLabel Correo3;
    public static javax.swing.JTable TablaSeleccionados;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxCliente;
    public static javax.swing.JComboBox<String> jComboBoxTerminos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabelCedula1;
    public static javax.swing.JLabel jLabelContado;
    public static javax.swing.JLabel jLabelFecha1;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelNPagina1;
    public static javax.swing.JLabel jLabelNumeroFactura1;
    public static javax.swing.JLabel jLabelPresentado1;
    public static javax.swing.JTextField jTextFieldAbono;
    private javax.swing.JTextField jTextFieldBuscar;
    public static javax.swing.JTextField jTextFieldCorreo;
    public static javax.swing.JTextField jTextFieldDeudas;
    public static javax.swing.JTextField jTextFieldTotal;
    // End of variables declaration//GEN-END:variables

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
       if(pageIndex==0){
           Graphics2D graphics2d = (Graphics2D) graphics;
           graphics2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
           printAll(graphics2d);
           return PAGE_EXISTS;
        }else{
           return NO_SUCH_PAGE;
       }
    }
}
