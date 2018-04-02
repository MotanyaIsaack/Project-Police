/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.police;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Isaack
 */
public final class ComplainantReport extends javax.swing.JFrame {
        static final String DB_URL = "jdbc:mysql://localhost/police_management_system";
 
        //  Database credentials
        static final String USER = "root" ;
        static final String PASS = "Isaamille2017";

    /**
     * Creates new form ComplainantReport
     */
    public ComplainantReport() {
        initComponents();
        Show_Complainants_In_Table();
    }
    
    public Connection getConnection(){
        Connection conn;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS); 
            return conn;
        } catch (SQLException e) {
            return null;
        }
    }
    
    public ArrayList<Complainants> getComplainantList(){
        ArrayList<Complainants> complainantList = new ArrayList<>();
        Connection connection = getConnection();
        
        String query = "SELECT * FROM complainant";
        Statement st;
        ResultSet rs;
        
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Complainants complainants;
            while (rs.next()) {                
                complainants = new Complainants(rs.getInt("complainant_id"),rs.getInt("case_id"),
                rs.getString("complainant_firstname"),rs.getString("complainant_lastname"),
                rs.getInt("complainant_phone_number"),rs.getInt("nationalid"));
                complainantList.add(complainants);
            }
        } catch (SQLException e) {
        }
        return complainantList;
    }
    
//    DISPLAY DATA IN THE JTABLE
    public void Show_Complainants_In_Table(){
        ArrayList<Complainants> list = getComplainantList();
        DefaultTableModel model = (DefaultTableModel) jTable_Display_Complainants.getModel();
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getCaseID();
            row[2] = list.get(i).getFirstName();
            row[3] = list.get(i).getLastName();
            row[4] = list.get(i).getPhoneNumber();
            row[5] = list.get(i).getNationalID();
            
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lblBack = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Display_Complainants = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(30, 40, 55));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("COMPLAINANTS REPORT");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 330, -1));

        lblBack.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblBack.setForeground(new java.awt.Color(255, 255, 255));
        lblBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/police/images/back4.png"))); // NOI18N
        lblBack.setText("BACK");
        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
        });
        jPanel1.add(lblBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 40));

        jTable_Display_Complainants.setBackground(new java.awt.Color(30, 40, 55));
        jTable_Display_Complainants.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTable_Display_Complainants.setForeground(new java.awt.Color(255, 255, 255));
        jTable_Display_Complainants.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Case ID", "First Name", "Last Name", "Phone Number", "National ID"
            }
        ));
        jTable_Display_Complainants.setRowHeight(25);
        jTable_Display_Complainants.setSelectionForeground(new java.awt.Color(30, 40, 55));
        jScrollPane1.setViewportView(jTable_Display_Complainants);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 720, 370));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        // TODO add your handling code here:
        PoliceHome police = new PoliceHome();
        police.setSize(775,497);
        police.setLocationRelativeTo(null);
        police.pack();
        police.setVisible(true);

    }//GEN-LAST:event_lblBackMouseClicked

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
            java.util.logging.Logger.getLogger(ComplainantReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComplainantReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComplainantReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComplainantReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComplainantReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Display_Complainants;
    private javax.swing.JLabel lblBack;
    // End of variables declaration//GEN-END:variables
}