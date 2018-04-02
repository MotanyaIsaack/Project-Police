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
import static project.police.ReportersReport.DB_URL;

/**
 *
 * @author Isaack
 */
public class CasesReport extends javax.swing.JFrame {
    static final String DB_URL = "jdbc:mysql://localhost/police_management_system";
 
        //  Database credentials
        static final String USER = "root" ;
        static final String PASS = "Isaamille2017";

    /**
     * Creates new form CasesReport
     */
    public CasesReport() {
        initComponents();
        Show_Cases_In_Table();
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
    
     public ArrayList<Case> getCaseList(){
        ArrayList<Case> caseList;
        caseList = new ArrayList<>();
        Connection connection = getConnection();
        
        String query = "SELECT * FROM cases";
        Statement st;
        ResultSet rs;
        
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Case cases;
            while (rs.next()) {                
                cases = new Case(rs.getInt("case_id"),
                rs.getString("case_name"),rs.getString("case_type"));
                caseList.add(cases);
            }
        } catch (SQLException e) {
        }
        return caseList;
    }
    
//    DISPLAY DATA IN THE JTABLE
    public final void Show_Cases_In_Table(){
        ArrayList<Case> list;
        list = getCaseList();
        DefaultTableModel model = (DefaultTableModel) jTable_Display_Cases.getModel();
        Object[] row = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getCaseID();
            row[1] = list.get(i).getCaseName();
            row[2] = list.get(i).getCaseType();
            model.addRow(row);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lblBack = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Display_Cases = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(30, 40, 55));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("CASES REPORT");
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

        jTable_Display_Cases.setBackground(new java.awt.Color(30, 40, 55));
        jTable_Display_Cases.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTable_Display_Cases.setForeground(new java.awt.Color(255, 255, 255));
        jTable_Display_Cases.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Case ID", "Case Name", "Case Type"
            }
        ));
        jScrollPane1.setViewportView(jTable_Display_Cases);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 80, 750, 330));

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
            java.util.logging.Logger.getLogger(CasesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CasesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CasesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CasesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CasesReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Display_Cases;
    private javax.swing.JLabel lblBack;
    // End of variables declaration//GEN-END:variables
}