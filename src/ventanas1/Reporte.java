    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas1;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
/**
 *
 * @author User
 */
public class Reporte extends javax.swing.JFrame {
    String user = "sql5454836";
    String clave = "pkzsvhf4Qx";
    String url = "jdbc:mysql://sql5.freemysqlhosting.net/sql5454836";
    Connection con ;
    Statement stmt;
    ResultSet rs;
    
    /**
     * Creates new form Inicio
     */
    public Reporte() {
        initComponents();
        this.setTitle("Reportes - El cajon");
        this.setLocationRelativeTo(null);
        
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
            }
        jTextFieldBuscar.setText(fecha());
        buscarProducto(jTextFieldBuscar.getText());
        buscarEgreso(jTextFieldBuscar.getText());
        sumarDatosNeto();
        

    }
    public Image getIconImage(){
       Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes1/icono.png"));
       return retValue;
    }

    
    void buscarProducto(String buscar){
        
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("CÓDIGO");
        modelo.addColumn("PRECIO COMPRA");
        modelo.addColumn("PRECIO VENTA");
        modelo.addColumn("GANANCIA");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("MARCA");
        modelo.addColumn("FECHA");
        modelo.addColumn("TOTAL");

        TablaDatos.setModel(modelo);

        String datos[] = new String [9];
         
        try {
            con = DriverManager.getConnection(url, user, clave);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ventas WHERE fecha LIKE '%"+buscar+"%'");
            while(rs.next()){
                
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);
                datos[2]= rs.getString(3);
                datos[3]= rs.getString(4);
                datos[4]= rs.getString(5);
                datos[5]= rs.getString(6);
                datos[6]= rs.getString(7);
                datos[7]= rs.getString(12);
                datos[8]= rs.getString(13);
                
                
                
                modelo.addRow(datos);
                
            }
            TablaDatos.setModel(modelo);
            TableColumn columna = TablaDatos.getColumn("ID");
            
            TableColumn columna2 = TablaDatos.getColumn("CANTIDAD");
            
            TableColumn columna5 = TablaDatos.getColumn("PRECIO COMPRA");
            TableColumn columna6 = TablaDatos.getColumn("GANANCIA");
            TableColumn columna7 = TablaDatos.getColumn("PRECIO VENTA");
            
            
            columna.setMinWidth(48);
            columna.setMaxWidth(48);
            
            columna2.setMinWidth(40);
            columna2.setMaxWidth(40);
           
            columna5.setMinWidth(88);
            columna5.setMaxWidth(88);
            columna6.setMinWidth(80);
            columna6.setMaxWidth(80);
            columna7.setMinWidth(95);
            columna7.setMaxWidth(95);
            
        } catch (SQLException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    void buscarEgreso(String buscar){
        
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("DESCRIPCIÓN");
        modelo.addColumn("FECHA");
        modelo.addColumn("TOTAL");

        TablaDatosGastos.setModel(modelo);

        String datos[] = new String [4];
         
        try {
            con = DriverManager.getConnection(url, user, clave);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM gastos WHERE fecha LIKE '%"+buscar+"%'");
            while(rs.next()){
                
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);
                datos[2]= rs.getString(4);
                datos[3]= rs.getString(3);

                modelo.addRow(datos);
                
            }
            TablaDatosGastos.setModel(modelo);
            TableColumn columna = TablaDatosGastos.getColumn("ID");
            
           
            
            
            columna.setMinWidth(48);
            columna.setMaxWidth(48);
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    




    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelVentasNeto = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPaneProducto1 = new javax.swing.JScrollPane();
        TablaDatosGastos = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jScrollPaneProducto = new javax.swing.JScrollPane();
        TablaDatos = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabelCantidadGastos = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabelCantidadVentas = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelGastos = new javax.swing.JLabel();
        jButtonAtras = new javax.swing.JButton();
        jTextFieldBuscar = new javax.swing.JTextField();
        jLabelTotal = new javax.swing.JLabel();
        jButtonInicio = new javax.swing.JButton();
        jLabelBruto = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelVentasNeto.setBackground(new java.awt.Color(255, 255, 255));
        jLabelVentasNeto.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelVentasNeto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jLabelVentasNeto.setOpaque(true);
        getContentPane().add(jLabelVentasNeto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 300, 170, 30));

        jButton3.setText("BUSCAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 80, -1, -1));

        jLabel7.setBackground(new java.awt.Color(204, 0, 51));
        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TOTAL VENTAS NETO:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 300, -1, -1));

        TablaDatos = new javax.swing.JTable(){
            public boolean isCellEditable(int riwIndex, int colIndex){
                return false;
            }
        };
        TablaDatosGastos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaDatosGastos.getTableHeader().setReorderingAllowed(false);
        jScrollPaneProducto1.setViewportView(TablaDatosGastos);

        getContentPane().add(jScrollPaneProducto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 550, 300));

        jLabel11.setBackground(new java.awt.Color(204, 0, 51));
        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("TOTAL VENTAS BRUTO:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 250, -1, -1));

        TablaDatos = new javax.swing.JTable(){
            public boolean isCellEditable(int riwIndex, int colIndex){
                return false;
            }
        };
        TablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaDatos.getTableHeader().setReorderingAllowed(false);
        jScrollPaneProducto.setViewportView(TablaDatos);

        getContentPane().add(jScrollPaneProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 720, 300));

        jLabel10.setBackground(new java.awt.Color(102, 0, 0));
        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("CANTIDAD DE GASTOS:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 210, -1, 30));

        jLabelCantidadGastos.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCantidadGastos.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelCantidadGastos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jLabelCantidadGastos.setOpaque(true);
        getContentPane().add(jLabelCantidadGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 210, 170, 30));

        jLabel9.setBackground(new java.awt.Color(102, 0, 0));
        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("CANTIDAD DE VENTAS");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 340, -1, -1));

        jLabelCantidadVentas.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCantidadVentas.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelCantidadVentas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jLabelCantidadVentas.setOpaque(true);
        getContentPane().add(jLabelCantidadVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 340, 170, 30));

        jLabel8.setBackground(new java.awt.Color(204, 0, 51));
        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TOTAL GASTOS:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 170, -1, -1));

        jLabelGastos.setBackground(new java.awt.Color(255, 255, 255));
        jLabelGastos.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelGastos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jLabelGastos.setOpaque(true);
        getContentPane().add(jLabelGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 170, 170, 30));

        jButtonAtras.setBackground(new java.awt.Color(204, 0, 51));
        jButtonAtras.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jButtonAtras.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes1/atrasBlanco.png"))); // NOI18N
        jButtonAtras.setBorderPainted(false);
        jButtonAtras.setContentAreaFilled(false);
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 590, 70, 40));

        jTextFieldBuscar.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jTextFieldBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
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
        getContentPane().add(jTextFieldBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 260, -1));

        jLabelTotal.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotal.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jLabelTotal.setOpaque(true);
        getContentPane().add(jLabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 380, 170, 30));

        jButtonInicio.setBackground(new java.awt.Color(204, 0, 51));
        jButtonInicio.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jButtonInicio.setForeground(new java.awt.Color(255, 255, 255));
        jButtonInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes1/inicio.png"))); // NOI18N
        jButtonInicio.setBorderPainted(false);
        jButtonInicio.setContentAreaFilled(false);
        jButtonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInicioActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 30, -1, -1));

        jLabelBruto.setBackground(new java.awt.Color(255, 255, 255));
        jLabelBruto.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelBruto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jLabelBruto.setOpaque(true);
        getContentPane().add(jLabelBruto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 250, 170, 30));

        jLabel6.setBackground(new java.awt.Color(0, 153, 102));
        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("GANANCIA:");
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 380, -1, -1));

        jLabel5.setBackground(new java.awt.Color(204, 0, 51));
        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("INGRESE LA FECHA:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, -1, -1));

        jLabelLogo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes1/cajon_1.png"))); // NOI18N
        getContentPane().add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, -1, -1));

        jLabelFondo.setBackground(new java.awt.Color(0, 0, 0));
        jLabelFondo.setOpaque(true);
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static String fecha(){
       Date fecha = new Date();
       SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
       return formatofecha.format(fecha);
    }  
    
    
    void sumarDatosNeto(){
        int cont=0;
        int contEgreso=0;
        int contNeto=0;
        int filas = TablaDatos.getRowCount();
        int filasGasto = TablaDatosGastos.getRowCount();
        
        jLabelCantidadVentas.setText(String.valueOf(filas));
        jLabelCantidadGastos.setText(String.valueOf(filasGasto));
        for(int i=0; i<filas; i++){
            cont += Integer.parseInt((String) TablaDatos.getValueAt(i, 3));
        }
        jLabelBruto.setText(String.valueOf(cont));
        
        for(int i=0; i<filas; i++){
            contNeto += Integer.parseInt((String) TablaDatos.getValueAt(i, 8));
        }
        jLabelVentasNeto.setText(String.valueOf(contNeto));
        
        
        for(int i=0; i<filasGasto; i++){
            contEgreso += Integer.parseInt((String) TablaDatosGastos.getValueAt(i, 3));
        }
        
        jLabelGastos.setText(String.valueOf(contEgreso));
        cont= contNeto - contEgreso;
        
        jLabelTotal.setText(String.valueOf(cont));
      }
      
      
    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed
        Inventario I = new Inventario();
        I.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonAtrasActionPerformed

    private void jTextFieldBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyTyped
        char c= evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c= cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_jTextFieldBuscarKeyTyped

    private void jTextFieldBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscarActionPerformed
        buscarProducto(jTextFieldBuscar.getText());
        buscarEgreso(jTextFieldBuscar.getText());
        sumarDatosNeto();
    }//GEN-LAST:event_jTextFieldBuscarActionPerformed

    private void jTextFieldBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyReleased
        
    }//GEN-LAST:event_jTextFieldBuscarKeyReleased

    private void jButtonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInicioActionPerformed
        Inicio I = new Inicio();
        I.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonInicioActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        buscarProducto(jTextFieldBuscar.getText());
        buscarEgreso(jTextFieldBuscar.getText());
        sumarDatosNeto();
    }//GEN-LAST:event_jButton3ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Reporte().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TablaDatos;
    public javax.swing.JTable TablaDatosGastos;
    private javax.swing.JButton jButton3;
    public javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonInicio;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelBruto;
    private javax.swing.JLabel jLabelCantidadGastos;
    private javax.swing.JLabel jLabelCantidadVentas;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelGastos;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelVentasNeto;
    private javax.swing.JScrollPane jScrollPaneProducto;
    private javax.swing.JScrollPane jScrollPaneProducto1;
    public javax.swing.JTextField jTextFieldBuscar;
    // End of variables declaration//GEN-END:variables
}
