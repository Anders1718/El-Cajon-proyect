/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas1;
import java.awt.Image;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author User
 */
public class Separado extends javax.swing.JFrame {
     String user = "sql5454836";
    String clave = "pkzsvhf4Qx";
    String url = "jdbc:mysql://sql5.freemysqlhosting.net/sql5454836";
    Connection con ;
    Statement stmt;
    ResultSet rs;
    DefaultTableModel modelo = new DefaultTableModel();
    double pagar = 0;
    double deuda = 0;
    String datos[] = new String [8];
    String codigo , fechas;
    int venta;
    
    /**
     * Creates new form Inicio
     */
    public Separado() {
        initComponents();
        this.setTitle("Separado - El cajon");
        this.setLocationRelativeTo(null);
        
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Separado.class.getName()).log(Level.SEVERE, null, ex);
            }
        buscarProducto(jTextFieldBuscar.getText());
        

    }
    public Image getIconImage(){
       Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes1/icono.png"));
       return retValue;
    }

     
    void buscarProducto(String buscar){
        
        
        
        modelo.addColumn("ID");
        modelo.addColumn("CÓDIGO");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("CÉDULA");
        modelo.addColumn("FECHA");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRECIO VENTA");
        
        modelo.addColumn("TOTAL");
        
        
        TablaDatos.setModel(modelo);

        
        
        
         
        try {
            con = DriverManager.getConnection(url, user, clave);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM separado WHERE cedula"
                    + " LIKE '%"+buscar+"%' OR cliente LIKE '%"+buscar+"%'");
            while(rs.next()){
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);
                datos[2]= rs.getString(3);
                datos[3]= rs.getString(4);
                datos[4]= rs.getString(5);
                datos[5]= rs.getString(6);
                datos[6]= rs.getString(7);
                datos[7]= rs.getString(8);
                
                
                modelo.addRow(datos);
            }
            TablaDatos.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Separado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    void refrescarPagina(String buscar){
         
        try {
            con = DriverManager.getConnection(url, user, clave);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM separado WHERE cedula"
                    + " LIKE '%"+buscar+"%' OR cliente LIKE '%"+buscar+"%'");
            while(rs.next()){
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);
                datos[2]= rs.getString(3);
                datos[3]= rs.getString(4);
                datos[4]= rs.getString(5);
                datos[5]= rs.getString(6);
                datos[6]= rs.getString(7);
                datos[7]= rs.getString(8);
                datos[8]= rs.getString(9);
                
                modelo.addRow(datos);
            }
            TablaDatos.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Separado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public String saldoFavor(String buscar){
      
        String saldo = "";
        String deuda="";
         
        try {
            con = DriverManager.getConnection(url, user, clave);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cliente WHERE cedula"
                    + " LIKE '%"+buscar+"%'");
            while(rs.next()){
                
            saldo = rs.getString(6);
            deuda=rs.getString(7);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Separado.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return saldo;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneProducto = new javax.swing.JScrollPane();
        TablaDatos = new javax.swing.JTable();
        jButtonAtras = new javax.swing.JButton();
        jTextFieldBuscar = new javax.swing.JTextField();
        jLabelSeleccionar = new javax.swing.JLabel();
        jButtonAbono = new javax.swing.JButton();
        MostrarCodigo1 = new javax.swing.JLabel();
        jLabelCantidad = new javax.swing.JLabel();
        jLabelId = new javax.swing.JLabel();
        jLabelMostrarNombre6 = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jTextFieldAbono = new javax.swing.JTextField();
        MostrarCodigo2 = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        jLabelMostrarNombre4 = new javax.swing.JLabel();
        jLabelBuscarNombre1 = new javax.swing.JLabel();
        jLabelBuscarNombre2 = new javax.swing.JLabel();
        MostrarCodigo = new javax.swing.JLabel();
        jButtonListo = new javax.swing.JButton();
        jLabelSaldoFavor = new javax.swing.JLabel();
        jLabelMostrarNombre3 = new javax.swing.JLabel();
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
        TablaDatos.getTableHeader().setReorderingAllowed(false);
        TablaDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDatosMouseClicked(evt);
            }
        });
        jScrollPaneProducto.setViewportView(TablaDatos);

        getContentPane().add(jScrollPaneProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 670, 240));

        jButtonAtras.setBackground(new java.awt.Color(204, 0, 51));
        jButtonAtras.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jButtonAtras.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes1/atrasBlanco.png"))); // NOI18N
        jButtonAtras.setBorderPainted(false);
        jButtonAtras.setContentAreaFilled(false);
        jButtonAtras.setOpaque(true);
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 90, 40));

        jTextFieldBuscar.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jTextFieldBuscar.setBorder(null);
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
        getContentPane().add(jTextFieldBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 260, -1));

        jLabelSeleccionar.setBackground(new java.awt.Color(204, 0, 51));
        jLabelSeleccionar.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelSeleccionar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSeleccionar.setText("SELECCIONE UNA FILA DE LA TABLA");
        getContentPane().add(jLabelSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jButtonAbono.setBackground(new java.awt.Color(204, 0, 51));
        jButtonAbono.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jButtonAbono.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAbono.setText("+");
        jButtonAbono.setContentAreaFilled(false);
        jButtonAbono.setOpaque(true);
        jButtonAbono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbonoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAbono, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 240, -1, 40));

        MostrarCodigo1.setBackground(new java.awt.Color(204, 0, 51));
        MostrarCodigo1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        MostrarCodigo1.setForeground(new java.awt.Color(255, 255, 255));
        MostrarCodigo1.setText("CANTIDAD:");
        getContentPane().add(MostrarCodigo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 490, 130, 30));

        jLabelCantidad.setBackground(new java.awt.Color(102, 255, 102));
        jLabelCantidad.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelCantidad.setOpaque(true);
        getContentPane().add(jLabelCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 490, 190, 30));

        jLabelId.setBackground(new java.awt.Color(102, 255, 102));
        jLabelId.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelId.setOpaque(true);
        getContentPane().add(jLabelId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 440, 190, 30));

        jLabelMostrarNombre6.setBackground(new java.awt.Color(204, 0, 51));
        jLabelMostrarNombre6.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelMostrarNombre6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMostrarNombre6.setText("NOMBRE:");
        getContentPane().add(jLabelMostrarNombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 380, 120, 30));

        jLabelNombre.setBackground(new java.awt.Color(102, 255, 102));
        jLabelNombre.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelNombre.setOpaque(true);
        getContentPane().add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 380, 190, 30));

        jTextFieldAbono.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jTextFieldAbono.setBorder(null);
        jTextFieldAbono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAbonoActionPerformed(evt);
            }
        });
        jTextFieldAbono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldAbonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldAbonoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldAbono, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 250, 190, -1));

        MostrarCodigo2.setBackground(new java.awt.Color(204, 0, 51));
        MostrarCodigo2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        MostrarCodigo2.setForeground(new java.awt.Color(255, 255, 255));
        MostrarCodigo2.setText("ID:");
        getContentPane().add(MostrarCodigo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 530, 40, 30));

        jLabelID.setBackground(new java.awt.Color(102, 255, 102));
        jLabelID.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelID.setOpaque(true);
        getContentPane().add(jLabelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 530, 190, 30));

        jLabelMostrarNombre4.setBackground(new java.awt.Color(204, 0, 51));
        jLabelMostrarNombre4.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelMostrarNombre4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMostrarNombre4.setText("ABONAR:");
        getContentPane().add(jLabelMostrarNombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 250, 110, 30));

        jLabelBuscarNombre1.setBackground(new java.awt.Color(204, 0, 51));
        jLabelBuscarNombre1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelBuscarNombre1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBuscarNombre1.setText("INGRESE EL NOMBRE DEL CLIENTE:");
        getContentPane().add(jLabelBuscarNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        jLabelBuscarNombre2.setBackground(new java.awt.Color(204, 0, 51));
        jLabelBuscarNombre2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelBuscarNombre2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBuscarNombre2.setText("O INGRESE LA CÉDULA:");
        getContentPane().add(jLabelBuscarNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));

        MostrarCodigo.setBackground(new java.awt.Color(204, 0, 51));
        MostrarCodigo.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        MostrarCodigo.setForeground(new java.awt.Color(255, 255, 255));
        MostrarCodigo.setText("CÉDULA:");
        getContentPane().add(MostrarCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 440, 110, 30));

        jButtonListo.setBackground(new java.awt.Color(204, 0, 51));
        jButtonListo.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jButtonListo.setForeground(new java.awt.Color(255, 255, 255));
        jButtonListo.setText("PAGAR");
        jButtonListo.setContentAreaFilled(false);
        jButtonListo.setOpaque(true);
        jButtonListo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonListo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 570, 170, 50));

        jLabelSaldoFavor.setBackground(new java.awt.Color(102, 255, 102));
        jLabelSaldoFavor.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelSaldoFavor.setOpaque(true);
        getContentPane().add(jLabelSaldoFavor, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 320, 190, 30));

        jLabelMostrarNombre3.setBackground(new java.awt.Color(204, 0, 51));
        jLabelMostrarNombre3.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabelMostrarNombre3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMostrarNombre3.setText("SALDO A FAVOR:");
        getContentPane().add(jLabelMostrarNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 320, 210, 30));

        jButtonInicio.setBackground(new java.awt.Color(204, 0, 51));
        jButtonInicio.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jButtonInicio.setForeground(new java.awt.Color(255, 255, 255));
        jButtonInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes1/inicio.png"))); // NOI18N
        jButtonInicio.setBorderPainted(false);
        jButtonInicio.setContentAreaFilled(false);
        jButtonInicio.setOpaque(true);
        jButtonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInicioActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 30, -1, -1));

        jLabelLogo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes1/cajon_1.png"))); // NOI18N
        getContentPane().add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, -1));

        jLabelFondo.setBackground(new java.awt.Color(0, 0, 0));
        jLabelFondo.setOpaque(true);
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 650));

        jLabelSumas.setText("jLabel1");
        getContentPane().add(jLabelSumas, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 560, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed
        Clientes I = new Clientes();
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
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBuscarActionPerformed

    private void jTextFieldBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyReleased
        modelo.setRowCount(0);
        refrescarPagina(jTextFieldBuscar.getText());
        
    }//GEN-LAST:event_jTextFieldBuscarKeyReleased

    private void TablaDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDatosMouseClicked

            int seleccionar = TablaDatos.rowAtPoint(evt.getPoint());
            jLabelSaldoFavor.setText(saldoFavor(String.valueOf(TablaDatos.getValueAt(seleccionar, 3))));
            jLabelId.setText(String.valueOf(TablaDatos.getValueAt(seleccionar, 3)));
            jLabelSumas.setText(String.valueOf(TablaDatos.getValueAt(seleccionar, 5)));
            jLabelNombre.setText(String.valueOf(TablaDatos.getValueAt(seleccionar, 2)));
            jLabelCantidad.setText(String.valueOf(TablaDatos.getValueAt(seleccionar, 8)));
            pagar=Double.parseDouble(TablaDatos.getValueAt(seleccionar, 8).toString());
            jLabelID.setText(String.valueOf(TablaDatos.getValueAt(seleccionar, 0)));
            codigo = String.valueOf(TablaDatos.getValueAt(seleccionar, 1));
            venta=Integer.parseInt(String.valueOf(TablaDatos.getValueAt(seleccionar, 6)));
            fechas = String.valueOf(TablaDatos.getValueAt(seleccionar, 4));
    }//GEN-LAST:event_TablaDatosMouseClicked
    
    private void jButtonListoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListoActionPerformed
        
        if(jLabelSaldoFavor.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Seleccione un cliente de la lista");
        }else if(Double.parseDouble(jLabelSaldoFavor.getText())< pagar){
            JOptionPane.showMessageDialog(null, "El saldo a favor es menor que el producto");
        }else{
            String precioCompra = null, cantidad = null;
            String talla = null, coleccion = null, sexo = null, marca = null , caracter=null;
           try {
                con = DriverManager.getConnection(url, user, clave);
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM usuario WHERE codigo LIKE '%"+codigo+"%' ");
                while(rs.next()){
                    precioCompra = rs.getString(4);
                    marca = rs.getString(8);
                    talla = rs.getString(9);
                    coleccion = rs.getString(10);
                    sexo = rs.getString(11);
                    cantidad  = rs.getString(7);
                    caracter= rs.getString(14);

                }

                } catch (SQLException ex) {
                    Logger.getLogger(BuscarProducto.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                int gananciaTotal = venta - Integer.parseInt(precioCompra) ;
                int total = gananciaTotal * Integer.parseInt(jLabelCantidad.getText());
                int quedan = Integer.parseInt(cantidad) - Integer.parseInt(jLabelCantidad.getText());
                try {
                    con = DriverManager.getConnection(url, user, clave);
                    stmt = con.createStatement();
                    stmt.executeUpdate("INSERT INTO ventas VALUES('0','"+codigo+"', '"+precioCompra+"', "
                    + "'"+venta+"', '"+gananciaTotal+"', '"+jLabelCantidad.getText()+"', '"+marca+"',"
                            + "'"+talla+"', '"+coleccion+"', '"+sexo+"', '"+jLabelNombre.getText()+"',"
                                    + " '"+fechas+"', '"+total+"' , '"+caracter+"' )");
                    
                    stmt.executeUpdate("UPDATE usuario SET cantidad = '"+quedan+"' WHERE codigo = '"
                    +codigo+"'");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "error");
                        Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
                    }
           double restar =  Double.parseDouble(jLabelSaldoFavor.getText()) - Double.parseDouble(jLabelCantidad.getText());
            try {
                con = DriverManager.getConnection(url, user, clave);
                stmt = con.createStatement();
                stmt.executeUpdate("UPDATE cliente SET favor = '"+restar+"' WHERE cedula = '"
                        +jLabelId.getText()+"'");
                
                stmt.executeUpdate("DELETE FROM separado WHERE id = '"
                        +jLabelID.getText()+"'");
            } catch (SQLException ex) {
                Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
            }
            

            JOptionPane.showMessageDialog(null, "INGRESO EXITOSO");
            
            
            jLabelId.setText("");
            jTextFieldBuscar.setText("");
            jLabelSaldoFavor.setText("");
            jLabelSumas.setText("");
            jTextFieldAbono.setText("");
            
            modelo.setRowCount(0);
            refrescarPagina(jTextFieldBuscar.getText());
            

        }
    }//GEN-LAST:event_jButtonListoActionPerformed

    private void jButtonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInicioActionPerformed
        Inicio I = new Inicio();
        I.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonInicioActionPerformed

    private void jTextFieldAbonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAbonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAbonoActionPerformed

    private void jTextFieldAbonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAbonoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAbonoKeyReleased

    private void jTextFieldAbonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAbonoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAbonoKeyTyped

    private void jButtonAbonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbonoActionPerformed
        if(jTextFieldAbono.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese un valor");
        }else{
            if(jLabelId.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Seleccione una fila");
            }else{
                double suma = Double.parseDouble(jLabelSaldoFavor.getText()) + Double.parseDouble(jTextFieldAbono.getText());
                try {
                con = DriverManager.getConnection(url, user, clave);
                stmt = con.createStatement();
                stmt.executeUpdate("UPDATE cliente SET favor = '"+suma+"' WHERE cedula = '"
                        +jLabelId.getText()+"'");
                
            } catch (SQLException ex) {
                Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
            }
             jLabelSaldoFavor.setText(String.valueOf(suma));
             modelo.setRowCount(0);
             refrescarPagina("");
             
            }
        }
    }//GEN-LAST:event_jButtonAbonoActionPerformed
    
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
            java.util.logging.Logger.getLogger(Separado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Separado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Separado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Separado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            new Separado().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MostrarCodigo;
    private javax.swing.JLabel MostrarCodigo1;
    private javax.swing.JLabel MostrarCodigo2;
    public javax.swing.JTable TablaDatos;
    public javax.swing.JButton jButtonAbono;
    public javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonInicio;
    public javax.swing.JButton jButtonListo;
    private javax.swing.JLabel jLabelBuscarNombre1;
    private javax.swing.JLabel jLabelBuscarNombre2;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelMostrarNombre3;
    private javax.swing.JLabel jLabelMostrarNombre4;
    private javax.swing.JLabel jLabelMostrarNombre6;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelSaldoFavor;
    private javax.swing.JLabel jLabelSeleccionar;
    private javax.swing.JLabel jLabelSumas;
    private javax.swing.JScrollPane jScrollPaneProducto;
    public javax.swing.JTextField jTextFieldAbono;
    public javax.swing.JTextField jTextFieldBuscar;
    // End of variables declaration//GEN-END:variables

    private class SumaCantidad {

        public SumaCantidad() {
        
        
        
        }
    }
}
