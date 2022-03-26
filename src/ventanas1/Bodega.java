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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author User
 */
public class Bodega extends javax.swing.JFrame {
    String user = Conexion.user;
    String clave = Conexion.clave;
    String url = Conexion.url;
    Connection con ;
    Statement stmt;
    ResultSet rs;
    
    /**
     * Creates new form Inicio
     */
    public Bodega() {
        initComponents();
        this.setTitle("El cajón: Bodega");
        this.setLocationRelativeTo(null);
        
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Bodega.class.getName()).log(Level.SEVERE, null, ex);
            }
        buscarProducto(jTextFieldBuscar.getText());
        cantidadProductos();

    }
    public Image getIconImage(){
       Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes1/icono.png"));
       return retValue;
    }

    
    void buscarProducto(String buscar){
        
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("CÓDIGO");
        modelo.addColumn("CARACTER");
        modelo.addColumn("MARCA");
        modelo.addColumn("TIPO");
        modelo.addColumn("TALLA");
        
        modelo.addColumn("PRECIO VENTA");
        
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("COLECCIÓN");
        modelo.addColumn("SEXO");
        TablaDatos.setModel(modelo);

        
        
        String datos[] = new String [11];
         
        try {
            con = DriverManager.getConnection(url, user, clave);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario WHERE codigo LIKE '%"+buscar+"%' OR tipo LIKE '%"+buscar+"%' OR marca LIKE '%"+buscar+"%' "
                    + "");
            while(rs.next()){
                if(Integer.parseInt(rs.getString(7))>0){
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);
                datos[2]= rs.getString(3);
                datos[3]= rs.getString(8);
                datos[4]= rs.getString(12);
                datos[5]= rs.getString(9);
                datos[6]= rs.getString(5);
                datos[7]= rs.getString(7);
                datos[8]= rs.getString(10);
                datos[9]= rs.getString(11);
                
                
                modelo.addRow(datos);
                }
            }
            TablaDatos.setModel(modelo);
            TableColumn columna = TablaDatos.getColumn("ID");
            TableColumn columna1 = TablaDatos.getColumn("COLECCIÓN");
            TableColumn columna2 = TablaDatos.getColumn("CANTIDAD");
            TableColumn columna3 = TablaDatos.getColumn("TALLA");
            TableColumn columna4 = TablaDatos.getColumn("SEXO");
            
            
            TableColumn columna7 = TablaDatos.getColumn("PRECIO VENTA");
            
            
            columna.setMinWidth(48);
            columna.setMaxWidth(48);
            columna1.setMinWidth(70);
            columna1.setMaxWidth(70);
            columna2.setMinWidth(70);
            columna2.setMaxWidth(70);
            columna3.setMinWidth(50);
            columna3.setMaxWidth(50);
            columna4.setMinWidth(35);
            columna4.setMaxWidth(35);
            
            
            columna7.setMinWidth(95);
            columna7.setMaxWidth(95);
            
        } catch (SQLException ex) {
            Logger.getLogger(Bodega.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    void buscarGenero(String buscar , String buscar2 , String buscar3){
        
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("CÓDIGO");
        modelo.addColumn("CARACTER");
        modelo.addColumn("MARCA");
        modelo.addColumn("TIPO");
        modelo.addColumn("TALLA");
        
        modelo.addColumn("PRECIO VENTA");
        
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("COLECCIÓN");
        modelo.addColumn("SEXO");
        TablaDatos.setModel(modelo);

        
        
        String datos[] = new String [11];
        
        if(buscar == "TODO"){
            buscar="";
        }
        if(buscar2=="TODO"){
            buscar2="";
        }if(buscar3=="TODO"){
            buscar3="";
        }
         
        try {
            con = DriverManager.getConnection(url, user, clave);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario WHERE sexo "
                    + "LIKE '%"+buscar+"%' AND tipo LIKE '%"+buscar2+"%' AND"
                            + " talla LIKE '%"+buscar3+"%' ");
            while(rs.next()){
                if(Integer.parseInt(rs.getString(7))>0){
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);
                datos[2]= rs.getString(3);
                datos[3]= rs.getString(8);
                datos[4]= rs.getString(12);
                datos[5]= rs.getString(9);
                datos[6]= rs.getString(5);
                datos[7]= rs.getString(7);
                datos[8]= rs.getString(10);
                datos[9]= rs.getString(11);
                
                
                modelo.addRow(datos);
                }
            }
            TablaDatos.setModel(modelo);
            TableColumn columna = TablaDatos.getColumn("ID");
            TableColumn columna1 = TablaDatos.getColumn("COLECCIÓN");
            TableColumn columna2 = TablaDatos.getColumn("CANTIDAD");
            TableColumn columna3 = TablaDatos.getColumn("TALLA");
            TableColumn columna4 = TablaDatos.getColumn("SEXO");
            
            
            TableColumn columna7 = TablaDatos.getColumn("PRECIO VENTA");
            
            
            columna.setMinWidth(48);
            columna.setMaxWidth(48);
            columna1.setMinWidth(70);
            columna1.setMaxWidth(70);
            columna2.setMinWidth(70);
            columna2.setMaxWidth(70);
            columna3.setMinWidth(50);
            columna3.setMaxWidth(50);
            columna4.setMinWidth(35);
            columna4.setMaxWidth(35);
            
            
            columna7.setMinWidth(95);
            columna7.setMaxWidth(95);
            
        } catch (SQLException ex) {
            Logger.getLogger(Bodega.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    




    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jComboBoxTalla = new javax.swing.JComboBox<>();
        jScrollPaneProducto = new javax.swing.JScrollPane();
        TablaDatos = new javax.swing.JTable();
        jButtonAtras = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxSexo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelVenta = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextFieldBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonInicio = new javax.swing.JButton();
        jLabelLogo = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, -1, -1));

        jComboBoxTalla.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxTalla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODO", "N/A", "XS", "S", "M", "L", "XL", "XXL", "XXXL", "5", "5-6", "5Y", "5.5", "6", "6Y", "6.5", "7", "7Y", "7.5", "8", "8.5", "9", "9.5", "10", "10.5", "11", "11.5", "12" }));
        jComboBoxTalla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxTallaMouseClicked(evt);
            }
        });
        jComboBoxTalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTallaActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxTalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 70, 90, -1));

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

        getContentPane().add(jScrollPaneProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 1230, 300));

        jButtonAtras.setBackground(new java.awt.Color(153, 153, 0));
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
        getContentPane().add(jButtonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 70, 40));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CANTIDAD DE ARTÍCULOS:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, -1, -1));

        jComboBoxTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODO", "CAMISETA CUELLO REDONDO", "CAMISETA CUELLO REDONDO X3", "CAMISETA POLO", "CAMISETA CUELLO V", "CAMIBUSO", "CHAQUETA-ABOLLONADA", "CAMISA MANGA-LARGA", "CAMISA MANGA-CORTA", "CORREAS", "BILLETERA", "SUDADERA", "ROMPEVIENTOS", "CHOMPA DE CIERRE", "CHOMPA CERRADA", "GORRAS", "GORRA PLANA", "MORRAL", "TENIS", "ESQUELETO DEPORTIVO", "LICRA", "LONCHERA", "ZAPATO", "GUAYOS", "RIÑONERA", "MEDIAS X6", "MEDIASX15", "BOXER X4", "BOXER X3", "BOXER X1" }));
        jComboBoxTipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxTipoMouseClicked(evt);
            }
        });
        jComboBoxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 100, 230, 30));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Y TALLA:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, -1, -1));

        jComboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODO", "F", "M" }));
        getContentPane().add(jComboBoxSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, -1, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("BUSCAR POR GÉNERO ,TIPO");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, -1, -1));

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TOTAL BRUTO:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 590, -1, -1));

        jLabelVenta.setBackground(new java.awt.Color(255, 255, 255));
        jLabelVenta.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelVenta.setOpaque(true);
        getContentPane().add(jLabelVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 590, 170, 30));

        jLabelTotal.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotal.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelTotal.setOpaque(true);
        getContentPane().add(jLabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 540, 170, 30));

        jButton2.setText("BUSCAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 150, -1, 30));

        jTextFieldBuscar.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
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
        getContentPane().add(jTextFieldBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 260, -1));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(",ESCANEE EL CÓDIGO DE BARRAS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(", INGRESE LA MARCA DEL PRODUCTO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 460, 30));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("INGRESE EL TIPO DE PRODUCTO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 420, 30));

        jButtonInicio.setBackground(new java.awt.Color(153, 0, 153));
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

        jLabelLogo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes1/cajon_1.png"))); // NOI18N
        getContentPane().add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 70, -1, -1));

        jLabelFondo.setBackground(new java.awt.Color(0, 0, 0));
        jLabelFondo.setOpaque(true);
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    void cantidadProductos(){
        int filas = TablaDatos.getRowCount();
        int suma=0;
        jLabelTotal.setText(String.valueOf(filas));
        for(int i=0; i<filas; i++){
            suma += Integer.parseInt(TablaDatos.getValueAt(i, 6).toString());
        }
        jLabelVenta.setText(String.valueOf(suma));
        
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
         cantidadProductos();
         jTextFieldBuscar.setText("");
    }//GEN-LAST:event_jTextFieldBuscarActionPerformed

    private void jTextFieldBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyReleased
       
    }//GEN-LAST:event_jTextFieldBuscarKeyReleased

    private void jButtonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInicioActionPerformed
        Inicio I = new Inicio();
        I.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonInicioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        buscarProducto(jTextFieldBuscar.getText());
        cantidadProductos();
         jTextFieldBuscar.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        buscarGenero(jComboBoxSexo.getSelectedItem().toString() , jComboBoxTipo.getSelectedItem().toString() ,
            jComboBoxTalla.getSelectedItem().toString());
        
        cantidadProductos();
       
         
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBoxTipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxTipoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoMouseClicked

    private void jComboBoxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoActionPerformed

    private void jComboBoxTallaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxTallaMouseClicked

    }//GEN-LAST:event_jComboBoxTallaMouseClicked

    private void jComboBoxTallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTallaActionPerformed
        String selectedValue = jComboBoxTalla.getSelectedItem().toString();

        //seleccionarCliente(selectedValue);
    }//GEN-LAST:event_jComboBoxTallaActionPerformed
    
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
            java.util.logging.Logger.getLogger(Bodega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bodega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bodega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bodega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Bodega().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TablaDatos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonInicio;
    private javax.swing.JComboBox<String> jComboBoxSexo;
    private javax.swing.JComboBox<String> jComboBoxTalla;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelVenta;
    private javax.swing.JScrollPane jScrollPaneProducto;
    public javax.swing.JTextField jTextFieldBuscar;
    // End of variables declaration//GEN-END:variables
}
