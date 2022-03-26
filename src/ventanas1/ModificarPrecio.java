/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas1;
import java.awt.Image;
import javax.swing.JOptionPane;
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
import javax.swing.table.TableColumn;
/**
 *
 * @author User
 */
public class ModificarPrecio extends javax.swing.JFrame {
    String user = "sql5454836";
    String clave = "pkzsvhf4Qx";
    String url = "jdbc:mysql://sql5.freemysqlhosting.net/sql5454836";
    Connection con ;
    Statement stmt;
    ResultSet rs;
    
    /**
     * Creates new form Inicio
     */
    public ModificarPrecio() {
        initComponents();
        this.setTitle("El cajón: modificar precio");
        this.setLocationRelativeTo(null);
        
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ModificarPrecio.class.getName()).log(Level.SEVERE, null, ex);
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
        modelo.addColumn("CÓDIGO");
        modelo.addColumn("MARCA");
        modelo.addColumn("PRECIO COMPRA");
        modelo.addColumn("PRECIO VENTA");
        modelo.addColumn("GANANCIA");
        
        TablaDatos.setModel(modelo);

        
        
        String datos[] = new String [6];
         
        try {
            con = DriverManager.getConnection(url, user, clave);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario WHERE codigo LIKE '%"+buscar+"%' OR marca LIKE '%"+buscar+"%' ORDER BY marca ASC");
            while(rs.next()){
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);
                datos[2]= rs.getString(8);
                datos[3]= rs.getString(4);
                datos[4]= rs.getString(5);
                datos[5]= rs.getString(6);
                
                modelo.addRow(datos);
            }
            TablaDatos.setModel(modelo);
            TableColumn columna = TablaDatos.getColumn("ID");
            TableColumn columna1 = TablaDatos.getColumn("GANANCIA");
            columna.setMinWidth(45);
            columna.setMaxWidth(45);
            columna1.setMinWidth(70);
            columna1.setMaxWidth(70);
            
        } catch (SQLException ex) {
            Logger.getLogger(ModificarPrecio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
    


    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneProducto = new javax.swing.JScrollPane();
        TablaDatos = new javax.swing.JTable();
        jTextFieldBuscar = new javax.swing.JTextField();
        jLabelSeleccionar = new javax.swing.JLabel();
        jLabelCantidad = new javax.swing.JLabel();
        jLabelId = new javax.swing.JLabel();
        jLabelBuscarNombre1 = new javax.swing.JLabel();
        jLabelBuscarNombre2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        MostrarCodigo = new javax.swing.JLabel();
        jButtonListo = new javax.swing.JButton();
        jLabelMostrarNombre1 = new javax.swing.JLabel();
        jLabelMostrarNombre3 = new javax.swing.JLabel();
        jTextFieldVenta = new javax.swing.JTextField();
        jTextFieldCompra = new javax.swing.JTextField();
        jLabelCantidad1 = new javax.swing.JLabel();
        jButtonAtras1 = new javax.swing.JButton();
        jButtonInicio = new javax.swing.JButton();
        jLabelLogo = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();
        jLabelSumas = new javax.swing.JLabel();

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
        TablaDatos.setGridColor(new java.awt.Color(0, 0, 0));
        TablaDatos.setSelectionBackground(new java.awt.Color(0, 0, 0));
        TablaDatos.getTableHeader().setReorderingAllowed(false);
        TablaDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDatosMouseClicked(evt);
            }
        });
        jScrollPaneProducto.setViewportView(TablaDatos);

        getContentPane().add(jScrollPaneProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 670, 300));

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
        getContentPane().add(jTextFieldBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 260, -1));

        jLabelSeleccionar.setBackground(new java.awt.Color(0, 0, 0));
        jLabelSeleccionar.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelSeleccionar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSeleccionar.setText("SELECCIONE EL PRODUCTO DE LA TABLA");
        jLabelSeleccionar.setOpaque(true);
        getContentPane().add(jLabelSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabelCantidad.setBackground(new java.awt.Color(0, 0, 0));
        jLabelCantidad.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelCantidad.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCantidad.setText("PRECIO DE COMPRA:");
        jLabelCantidad.setOpaque(true);
        getContentPane().add(jLabelCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 330, 250, 30));

        jLabelId.setBackground(new java.awt.Color(102, 255, 102));
        jLabelId.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelId.setOpaque(true);
        getContentPane().add(jLabelId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 250, 190, 30));

        jLabelBuscarNombre1.setBackground(new java.awt.Color(102, 255, 102));
        jLabelBuscarNombre1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelBuscarNombre1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBuscarNombre1.setText("INGRESE LA MARCA DEL PRODUCTO:");
        jLabelBuscarNombre1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabelBuscarNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        jLabelBuscarNombre2.setBackground(new java.awt.Color(102, 255, 102));
        jLabelBuscarNombre2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelBuscarNombre2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBuscarNombre2.setText("O ESCANEE EL CÓDIGO:");
        jLabelBuscarNombre2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabelBuscarNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, -1));

        jButton3.setText("BUSCAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, -1, -1));

        MostrarCodigo.setBackground(new java.awt.Color(102, 255, 102));
        MostrarCodigo.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        MostrarCodigo.setForeground(new java.awt.Color(255, 255, 255));
        MostrarCodigo.setText("ID:");
        getContentPane().add(MostrarCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 250, 50, 30));

        jButtonListo.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jButtonListo.setForeground(new java.awt.Color(255, 255, 255));
        jButtonListo.setText("INGRESAR");
        jButtonListo.setContentAreaFilled(false);
        jButtonListo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonListo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 530, 170, 40));

        jLabelMostrarNombre1.setBackground(new java.awt.Color(102, 255, 102));
        jLabelMostrarNombre1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelMostrarNombre1.setOpaque(true);
        getContentPane().add(jLabelMostrarNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 170, 190, 30));

        jLabelMostrarNombre3.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMostrarNombre3.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelMostrarNombre3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMostrarNombre3.setText("NOMBRE DEL PRODUCTO:");
        jLabelMostrarNombre3.setOpaque(true);
        getContentPane().add(jLabelMostrarNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 170, 310, 30));

        jTextFieldVenta.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jTextFieldVenta.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextFieldVentaMouseMoved(evt);
            }
        });
        jTextFieldVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldVentaMouseClicked(evt);
            }
        });
        jTextFieldVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldVentaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldVentaKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 400, 200, -1));

        jTextFieldCompra.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jTextFieldCompra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextFieldCompraMouseMoved(evt);
            }
        });
        jTextFieldCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldCompraMouseClicked(evt);
            }
        });
        jTextFieldCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCompraActionPerformed(evt);
            }
        });
        jTextFieldCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCompraKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCompraKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 330, 200, -1));

        jLabelCantidad1.setBackground(new java.awt.Color(0, 0, 0));
        jLabelCantidad1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelCantidad1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCantidad1.setText("PRECIO DE VENTA:");
        jLabelCantidad1.setOpaque(true);
        getContentPane().add(jLabelCantidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 410, 230, 30));

        jButtonAtras1.setBackground(new java.awt.Color(153, 153, 0));
        jButtonAtras1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jButtonAtras1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAtras1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes1/atrasBlanco.png"))); // NOI18N
        jButtonAtras1.setBorderPainted(false);
        jButtonAtras1.setContentAreaFilled(false);
        jButtonAtras1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtras1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAtras1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 40, 40));

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
        getContentPane().add(jButtonInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 30, -1, -1));

        jLabelLogo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes1/cajon_1.png"))); // NOI18N
        getContentPane().add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));

        jLabelFondo.setBackground(new java.awt.Color(0, 0, 0));
        jLabelFondo.setOpaque(true);
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 650));

        jLabelSumas.setText("jLabel1");
        getContentPane().add(jLabelSumas, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 560, -1, -1));

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

    private void TablaDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDatosMouseClicked

            int seleccionar = TablaDatos.rowAtPoint(evt.getPoint());
            jLabelMostrarNombre1.setText(String.valueOf(TablaDatos.getValueAt(seleccionar, 2)));
            jLabelId.setText(String.valueOf(TablaDatos.getValueAt(seleccionar, 0)));
            
            jTextFieldCompra.setText(String.valueOf(TablaDatos.getValueAt(seleccionar, 3)));
            jTextFieldVenta.setText(String.valueOf(TablaDatos.getValueAt(seleccionar, 4)));
    }//GEN-LAST:event_TablaDatosMouseClicked
    
    private void jButtonListoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListoActionPerformed
        boolean sw = true;
        int n1=0 ;
        int n2=0 ;
        String v1="";
        String v2="";
        if(jLabelMostrarNombre1.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "No selecciono el producto");
            sw = false;
        }

        else if(jTextFieldVenta.getText().isEmpty() || jTextFieldCompra.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "No ingresó el precio");
            sw = false;
        }else{
        v1 = jTextFieldCompra.getText();
        v2 = jTextFieldVenta.getText();
        n1 = Integer.parseInt(v2);
        n2 = Integer.parseInt(v1);
        }
        
        
        if(n1 < n2){
            JOptionPane.showMessageDialog(null, "El precio de compra no puede ser mayor al de venta");
            sw=false;
        }
        if(sw == true){
            
            
            int Suma = Integer.parseInt(v2) - Integer.parseInt(v1);
            String SumaDatos = String.valueOf(Suma);
            jLabelSumas.setText(SumaDatos);

            try {
                con = DriverManager.getConnection(url, user, clave);
                stmt = con.createStatement();
                stmt.executeUpdate("UPDATE usuario SET precioCompra = '"+jTextFieldCompra.getText()+"' WHERE id = '"
                        +jLabelId.getText()+"'");
                stmt.executeUpdate("UPDATE usuario SET precioVenta = '"+jTextFieldVenta.getText()+"' WHERE id = '"
                        +jLabelId.getText()+"'");
                stmt.executeUpdate("UPDATE usuario SET ganancia = '"+jLabelSumas.getText()+"' WHERE id = '"
                        +jLabelId.getText()+"'");
            } catch (SQLException ex) {
                Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
            
                
            

            JOptionPane.showMessageDialog(null, "INGRESO EXITOSO");
            jTextFieldCompra.setText("");
            jTextFieldVenta.setText("");
            jLabelId.setText("");
            jTextFieldBuscar.setText("");
            jLabelMostrarNombre1.setText("");
            jLabelSumas.setText("");
            buscarProducto(jTextFieldBuscar.getText());

        }
    }//GEN-LAST:event_jButtonListoActionPerformed

    private void jTextFieldVentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldVentaKeyReleased
    
    }//GEN-LAST:event_jTextFieldVentaKeyReleased

    private void jTextFieldVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldVentaMouseClicked
        
    }//GEN-LAST:event_jTextFieldVentaMouseClicked

    private void jTextFieldVentaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldVentaMouseMoved
        
    }//GEN-LAST:event_jTextFieldVentaMouseMoved

    private void jTextFieldVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldVentaKeyTyped
        
    }//GEN-LAST:event_jTextFieldVentaKeyTyped

    private void jTextFieldCompraMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldCompraMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCompraMouseMoved

    private void jTextFieldCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldCompraMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCompraMouseClicked

    private void jTextFieldCompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCompraKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCompraKeyReleased

    private void jTextFieldCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCompraKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCompraKeyTyped

    private void jButtonAtras1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtras1ActionPerformed
        Productos I = new Productos();
        I.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonAtras1ActionPerformed

    private void jButtonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInicioActionPerformed
        Inicio I = new Inicio();
        I.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonInicioActionPerformed

    private void jTextFieldCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCompraActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        buscarProducto(jTextFieldBuscar.getText());
         jTextFieldBuscar.setText("");
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
            java.util.logging.Logger.getLogger(ModificarPrecio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarPrecio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarPrecio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarPrecio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            new ModificarPrecio().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MostrarCodigo;
    public javax.swing.JTable TablaDatos;
    private javax.swing.JButton jButton3;
    public javax.swing.JButton jButtonAtras1;
    private javax.swing.JButton jButtonInicio;
    public javax.swing.JButton jButtonListo;
    private javax.swing.JLabel jLabelBuscarNombre1;
    private javax.swing.JLabel jLabelBuscarNombre2;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelCantidad1;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelMostrarNombre1;
    private javax.swing.JLabel jLabelMostrarNombre3;
    private javax.swing.JLabel jLabelSeleccionar;
    private javax.swing.JLabel jLabelSumas;
    private javax.swing.JScrollPane jScrollPaneProducto;
    public javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JTextField jTextFieldCompra;
    private javax.swing.JTextField jTextFieldVenta;
    // End of variables declaration//GEN-END:variables

    
}
