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
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author User
 */
public class BuscarCliente extends javax.swing.JFrame {
    String user = "sql5454836";
    String clave = "pkzsvhf4Qx";
    String url = "jdbc:mysql://sql5.freemysqlhosting.net/sql5454836";
    Connection con ;
    Statement stmt;
    ResultSet rs;
    
    /**
     * Creates new form Inicio
     */
    public BuscarCliente() {
        initComponents();
        this.setTitle("El cajón: Buscar cliente");
        this.setLocationRelativeTo(null);
        
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BuscarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        buscarProducto(jTextFieldBuscar.getText());

    }
    public Image getIconImage(){
       Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes1/icono.png"));
       return retValue;
    }

    
    void buscarProducto(String buscar){
        
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("CÉDULA");
        modelo.addColumn("TÉLEFONO");
        modelo.addColumn("CORREO");
        
        
        TablaDatos.setModel(modelo);

        
        
        String datos[] = new String [5];
         
        try {
            con = DriverManager.getConnection(url, user, clave);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cliente WHERE nombre LIKE '%"+buscar+"%' OR cedula LIKE '%"
                    +buscar+"%' OR id LIKE '%"+buscar+"%' ");
            while(rs.next()){
                datos[0]= rs.getString(4);
                datos[1]= rs.getString(1);
                datos[2]= rs.getString(2);
                datos[3]= rs.getString(5);
                datos[4]= rs.getString(3);
                
                modelo.addRow(datos);
            }
            TablaDatos.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(BuscarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    




    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneProducto = new javax.swing.JScrollPane();
        TablaDatos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextFieldBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonInicio = new javax.swing.JButton();
        jButtonAtras1 = new javax.swing.JButton();
        jLabelLogo = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jScrollPaneProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 1060, 300));

        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, -1, -1));

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
        jLabel1.setText("O INGRESE EL ID:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 210, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("INGRESE EL NOMBRE DEL CLIENTE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("O INGRESE EL NÚMERO DE CÉDULA");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, -1));

        jButtonInicio.setBackground(new java.awt.Color(153, 0, 153));
        jButtonInicio.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jButtonInicio.setForeground(new java.awt.Color(255, 255, 255));
        jButtonInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes1/inicio.png"))); // NOI18N
        jButtonInicio.setText("INICIO");
        jButtonInicio.setBorderPainted(false);
        jButtonInicio.setContentAreaFilled(false);
        jButtonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInicioActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 30, -1, -1));

        jButtonAtras1.setBackground(new java.awt.Color(153, 153, 0));
        jButtonAtras1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jButtonAtras1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAtras1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes1/atrasBlanco.png"))); // NOI18N
        jButtonAtras1.setText("VOLVER");
        jButtonAtras1.setBorderPainted(false);
        jButtonAtras1.setContentAreaFilled(false);
        jButtonAtras1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtras1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAtras1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 210, 40));

        jLabelLogo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes1/cajon_1.png"))); // NOI18N
        getContentPane().add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, -1, -1));

        jLabelFondo.setBackground(new java.awt.Color(0, 0, 0));
        jLabelFondo.setOpaque(true);
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButtonAtras1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtras1ActionPerformed
        Clientes I = new Clientes();
        I.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonAtras1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        buscarProducto(jTextFieldBuscar.getText());
        jTextFieldBuscar.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed
    
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
            java.util.logging.Logger.getLogger(BuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            new BuscarCliente().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TablaDatos;
    private javax.swing.JButton jButton1;
    public javax.swing.JButton jButtonAtras1;
    private javax.swing.JButton jButtonInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JScrollPane jScrollPaneProducto;
    public javax.swing.JTextField jTextFieldBuscar;
    // End of variables declaration//GEN-END:variables
}
