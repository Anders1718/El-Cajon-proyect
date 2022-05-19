    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas1;
import java.awt.Image;
import java.awt.List;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import static ventanas1.FacturaPanel.TablaSeleccionados;
import static ventanas1.ModificarProducto.jLabelCodigo2;
import static ventanas1.ModificarProducto.jLabelIdListo;
/**
 *
 * @author User
 */
public class Vendido extends javax.swing.JFrame {
    
    Connection con ;
    Statement stmt;
    ResultSet rs;
    String codigo = null;
    int cantidad = 0;
    DefaultTableModel modelo = new DefaultTableModel();
    
    /**
     * Creates new form Inicio
     */
    public Vendido() {
        initComponents();
        this.setTitle("El cajón: Buscar producto");
        this.setLocationRelativeTo(null);
        
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Vendido.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        buscarProducto(jTextFieldBuscar.getText());
        sumarDatosNeto();
        sumarDatosBruto();
        
        

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
        modelo.addColumn("CARACTER");
        modelo.addColumn("TALLA");
        modelo.addColumn("COLECCIÓN");
        modelo.addColumn("SEXO");
        modelo.addColumn("COMPRADOR");
        modelo.addColumn("FECHA");
        modelo.addColumn("TOTAL");
        
        
        
        
        
        
        
        TablaDatos.setModel(modelo);

        
        
        String datos[] = new String [14];
         
        try {
            con = DriverManager.getConnection(url, user, clave);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ventas WHERE codigo LIKE '%"+buscar+"%' OR marca LIKE '%"+buscar+"%' "
                    + "");
            while(rs.next()){
                
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);
                datos[2]= rs.getString(3);
                datos[3]= rs.getString(4);
                datos[4]= rs.getString(5);
                datos[5]= rs.getString(6);
                datos[6]= rs.getString(7);
                datos[7]= rs.getString(14);
                datos[8]= rs.getString(8);
                datos[9]= rs.getString(9);
                datos[10]= rs.getString(10);
                datos[11]= rs.getString(11);
                datos[12]= rs.getString(12);
                datos[13]= rs.getString(13);
                modelo.addRow(datos);
                
            }
            TablaDatos.setModel(modelo);
            TableColumn columna = TablaDatos.getColumn("ID");
            TableColumn columna1 = TablaDatos.getColumn("COLECCIÓN");
            TableColumn columna2 = TablaDatos.getColumn("CANTIDAD");
            TableColumn columna3 = TablaDatos.getColumn("TALLA");
            TableColumn columna4 = TablaDatos.getColumn("SEXO");
            TableColumn columna5 = TablaDatos.getColumn("PRECIO COMPRA");
            TableColumn columna6 = TablaDatos.getColumn("GANANCIA");
            TableColumn columna7 = TablaDatos.getColumn("PRECIO VENTA");
            
            
            columna.setMinWidth(48);
            columna.setMaxWidth(48);
            columna1.setMinWidth(70);
            columna1.setMaxWidth(70);
            columna2.setMinWidth(70);
            columna2.setMaxWidth(70);
            columna3.setMinWidth(50);
            columna3.setMaxWidth(50);
            columna4.setMinWidth(50);
            columna4.setMaxWidth(50);
            columna5.setMinWidth(88);
            columna5.setMaxWidth(88);
            columna6.setMinWidth(80);
            columna6.setMaxWidth(80);
            columna7.setMinWidth(95);
            columna7.setMaxWidth(95);
            
        } catch (SQLException ex) {
            Logger.getLogger(Vendido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    




    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelId = new javax.swing.JLabel();
        jLabelCodigo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButtonDevolver = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPaneProducto = new javax.swing.JScrollPane();
        TablaDatos = new javax.swing.JTable();
        jButtonAtras = new javax.swing.JButton();
        jTextFieldBuscar = new javax.swing.JTextField();
        jLabelTotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
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

        jLabelId.setBackground(new java.awt.Color(102, 255, 102));
        jLabelId.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelId.setOpaque(true);
        getContentPane().add(jLabelId, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 170, 130, 30));

        jLabelCodigo.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelCodigo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCodigo.setText("ID:");
        getContentPane().add(jLabelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 170, -1, -1));

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TOTAL BRUTO:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 550, -1, -1));

        jButtonDevolver.setBackground(new java.awt.Color(153, 0, 153));
        jButtonDevolver.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jButtonDevolver.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDevolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes1/devolver.png"))); // NOI18N
        jButtonDevolver.setBorderPainted(false);
        jButtonDevolver.setContentAreaFilled(false);
        jButtonDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDevolverActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDevolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 550, -1, -1));

        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, -1, -1));

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
        TablaDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDatosMouseClicked(evt);
            }
        });
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

        jLabelTotal.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotal.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelTotal.setOpaque(true);
        getContentPane().add(jLabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 590, 170, 30));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(", INGRESE LA MARCA DEL PRODUCTO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 460, 30));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("INGRESE EL TIPO DE PRODUCTO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 420, 30));

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

        jLabelBruto.setBackground(new java.awt.Color(255, 255, 255));
        jLabelBruto.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelBruto.setOpaque(true);
        getContentPane().add(jLabelBruto, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 550, 170, 30));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("TOTAL NETO:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 590, -1, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("O ESCANEE EL CÓDIGO DE BARRAS");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));

        jLabelLogo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes1/cajon_1.png"))); // NOI18N
        getContentPane().add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 70, -1, -1));

        jLabelFondo.setBackground(new java.awt.Color(0, 0, 0));
        jLabelFondo.setOpaque(true);
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents
      void sumarDatosNeto(){
        int cont=0;
        int filas = TablaDatos.getRowCount();
        for(int i=0; i<filas; i++){
            cont += Integer.parseInt((String) TablaDatos.getValueAt(i, 13));
        }
        jLabelTotal.setText(String.valueOf(cont));
      }
      void sumarDatosBruto(){
        int cont=0;
        int filas = TablaDatos.getRowCount();
        for(int i=0; i<filas; i++){
            cont += Integer.parseInt((String) TablaDatos.getValueAt(i, 3));
        }
        jLabelBruto.setText(String.valueOf(cont));
      }
      
      void devolver(){
            int cantidadTotal = 0;
            try {
                con = DriverManager.getConnection(url, user, clave);
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM usuario WHERE id "
                + "LIKE '%"+jLabelId.getText()+"%'"  );
                while(rs.next()){
                cantidadTotal = Integer.parseInt(rs.getString(1));

                }
                cantidadTotal+=cantidad;
                
                stmt.executeUpdate("UPDATE usuario SET cantidad = '"+cantidadTotal+"' WHERE codigo = '"
                +codigo+"'");
                
                stmt.executeUpdate("DELETE FROM ventas WHERE id = '"
                        +jLabelId.getText()+"'");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "error");
                    Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            modelo.setRowCount(0);
            buscarProducto("");
            
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
        jTextFieldBuscar.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDevolverActionPerformed
        if(jLabelId.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "No seleccionó el producto");
        }else{
            int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea devolver el producto?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if(resp==0){
                devolver();
            }
            
        }
    }//GEN-LAST:event_jButtonDevolverActionPerformed

    private void TablaDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDatosMouseClicked
        int seleccionar = TablaDatos.rowAtPoint(evt.getPoint());
        jLabelId.setText(String.valueOf(TablaDatos.getValueAt(seleccionar, 0)));
        codigo = String.valueOf(TablaDatos.getValueAt(seleccionar, 1));
        cantidad = Integer.parseInt(String.valueOf(TablaDatos.getValueAt(seleccionar, 5)));
    }//GEN-LAST:event_TablaDatosMouseClicked
    
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
            java.util.logging.Logger.getLogger(Vendido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vendido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vendido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vendido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Vendido().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TablaDatos;
    private javax.swing.JButton jButton1;
    public javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonDevolver;
    private javax.swing.JButton jButtonInicio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelBruto;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelFondo;
    public static javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JScrollPane jScrollPaneProducto;
    public javax.swing.JTextField jTextFieldBuscar;
    // End of variables declaration//GEN-END:variables
}
