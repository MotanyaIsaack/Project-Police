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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static project.police.ComplainantReport.DB_URL;

/**
 *
 * @author Isaack
 */
public class ComplainantOverview extends javax.swing.JFrame {
        static final String DB_URL = "jdbc:mysql://localhost/police_management_system";
        //  Database credentials
        static final String USER = "root" ;
        static final String PASS = "Isaamille2017";

    /**
     * Creates new form ComplainantOverview
     */
    public ComplainantOverview() {
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
    
    //DISPLAY DATA IN THE JTABLE
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
    public void excecuteSQLQuery(String query, String message){
        Connection con = getConnection();
        Statement st;
        try {
            st = con.createStatement();
            if ((st.executeUpdate(query) == 1)) {
                //Refresh the Data in the table
                DefaultTableModel model = (DefaultTableModel) jTable_Display_Complainants.getModel();
                model.setRowCount(0);
                Show_Complainants_In_Table();
                JOptionPane.showMessageDialog(null, "Data "+message+" Succesfully");
            }else{
               JOptionPane.showMessageDialog(null, "Data Not "+message);
            }
        } catch (Exception e) {
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

        jPanelComplainant = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        txtFirstname = new javax.swing.JTextField();
        lblFirstname = new javax.swing.JLabel();
        txtCaseID = new javax.swing.JTextField();
        lblCaseid = new javax.swing.JLabel();
        lblCases = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        txtNationalid = new javax.swing.JTextField();
        lblNationalid = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        txtLastName = new javax.swing.JTextField();
        lblLastname = new javax.swing.JLabel();
        lblBack = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Display_Complainants = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        lblExit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelComplainant.setBackground(new java.awt.Color(30, 40, 55));
        jPanelComplainant.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanelComplainant.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 280, 10));
        jPanelComplainant.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 280, 10));

        txtFirstname.setBackground(new java.awt.Color(30, 40, 55));
        txtFirstname.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtFirstname.setForeground(new java.awt.Color(255, 255, 255));
        txtFirstname.setText("Enter the complainant first name");
        txtFirstname.setBorder(null);
        txtFirstname.setName("username"); // NOI18N
        txtFirstname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFirstnameFocusGained(evt);
            }
        });
        txtFirstname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFirstnameMouseClicked(evt);
            }
        });
        txtFirstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstnameActionPerformed(evt);
            }
        });
        jPanelComplainant.add(txtFirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 280, 30));

        lblFirstname.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblFirstname.setForeground(new java.awt.Color(255, 255, 255));
        lblFirstname.setText("COMPLAINANT FIRST NAME");
        jPanelComplainant.add(lblFirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 240, 30));

        txtCaseID.setBackground(new java.awt.Color(30, 40, 55));
        txtCaseID.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtCaseID.setForeground(new java.awt.Color(255, 255, 255));
        txtCaseID.setText("Enter the case ID");
        txtCaseID.setBorder(null);
        txtCaseID.setName("username"); // NOI18N
        txtCaseID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCaseIDFocusGained(evt);
            }
        });
        txtCaseID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCaseIDMouseClicked(evt);
            }
        });
        txtCaseID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCaseIDActionPerformed(evt);
            }
        });
        txtCaseID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCaseIDKeyReleased(evt);
            }
        });
        jPanelComplainant.add(txtCaseID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 280, 30));

        lblCaseid.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblCaseid.setForeground(new java.awt.Color(255, 255, 255));
        lblCaseid.setText("CASE ID");
        jPanelComplainant.add(lblCaseid, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, 30));

        lblCases.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        lblCases.setForeground(new java.awt.Color(255, 255, 255));
        lblCases.setText("COMPLAINANT OVERVIEW");
        jPanelComplainant.add(lblCases, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 290, 30));

        lblPhone.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblPhone.setForeground(new java.awt.Color(255, 255, 255));
        lblPhone.setText("COMPLAINANT PHONE");
        jPanelComplainant.add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 240, 30));

        txtPhone.setBackground(new java.awt.Color(30, 40, 55));
        txtPhone.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtPhone.setForeground(new java.awt.Color(255, 255, 255));
        txtPhone.setText("Enter the complainant phone number");
        txtPhone.setBorder(null);
        txtPhone.setName("username"); // NOI18N
        txtPhone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPhoneFocusGained(evt);
            }
        });
        txtPhone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPhoneMouseClicked(evt);
            }
        });
        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });
        jPanelComplainant.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 280, 30));
        jPanelComplainant.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 280, 10));
        jPanelComplainant.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 452, 300, 10));

        txtNationalid.setBackground(new java.awt.Color(30, 40, 55));
        txtNationalid.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtNationalid.setForeground(new java.awt.Color(255, 255, 255));
        txtNationalid.setText("Enter the complainant national ID");
        txtNationalid.setBorder(null);
        txtNationalid.setName("username"); // NOI18N
        txtNationalid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNationalidFocusGained(evt);
            }
        });
        txtNationalid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNationalidMouseClicked(evt);
            }
        });
        txtNationalid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNationalidActionPerformed(evt);
            }
        });
        jPanelComplainant.add(txtNationalid, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 280, 30));

        lblNationalid.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblNationalid.setForeground(new java.awt.Color(255, 255, 255));
        lblNationalid.setText("COMPLAINANT ID");
        jPanelComplainant.add(lblNationalid, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 240, 30));
        jPanelComplainant.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 280, 10));

        txtLastName.setBackground(new java.awt.Color(30, 40, 55));
        txtLastName.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtLastName.setForeground(new java.awt.Color(255, 255, 255));
        txtLastName.setText("Enter the complainant last name");
        txtLastName.setBorder(null);
        txtLastName.setName("username"); // NOI18N
        txtLastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLastNameFocusGained(evt);
            }
        });
        txtLastName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtLastNameMouseClicked(evt);
            }
        });
        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNameActionPerformed(evt);
            }
        });
        jPanelComplainant.add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 280, 30));

        lblLastname.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblLastname.setForeground(new java.awt.Color(255, 255, 255));
        lblLastname.setText("COMPLAINANT LAST NAME");
        jPanelComplainant.add(lblLastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 240, 30));

        lblBack.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblBack.setForeground(new java.awt.Color(255, 255, 255));
        lblBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/police/images/back4.png"))); // NOI18N
        lblBack.setText("BACK");
        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
        });
        jPanelComplainant.add(lblBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 40));

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
        jTable_Display_Complainants.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Display_ComplainantsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Display_Complainants);

        jPanelComplainant.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 760, 370));

        btnDelete.setBackground(new java.awt.Color(0, 204, 204));
        btnDelete.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/police/images/delete.png"))); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.setBorder(null);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanelComplainant.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, 150, 60));

        btnUpdate.setBackground(new java.awt.Color(0, 204, 204));
        btnUpdate.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/police/images/update.png"))); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.setBorder(null);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanelComplainant.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 150, 60));

        lblExit.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblExit.setForeground(new java.awt.Color(255, 255, 255));
        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/police/images/exit2.png"))); // NOI18N
        lblExit.setText("EXIT");
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });
        jPanelComplainant.add(lblExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 0, 70, 40));

        getContentPane().add(jPanelComplainant, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFirstnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFirstnameFocusGained
        // TODO add your handling code here:
        txtFirstname.setText("");
    }//GEN-LAST:event_txtFirstnameFocusGained

    private void txtFirstnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFirstnameMouseClicked
        txtFirstname.setText("");
    }//GEN-LAST:event_txtFirstnameMouseClicked

    private void txtFirstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstnameActionPerformed

    private void txtCaseIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCaseIDFocusGained
        // TODO add your handling code here:
        txtCaseID.setText("");
    }//GEN-LAST:event_txtCaseIDFocusGained

    private void txtCaseIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCaseIDMouseClicked
        // TODO add your handling code here:
        txtCaseID.setText("");
    }//GEN-LAST:event_txtCaseIDMouseClicked

    private void txtCaseIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCaseIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCaseIDActionPerformed

    private void txtCaseIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCaseIDKeyReleased
        // TODO add your handling code here:
      
    }//GEN-LAST:event_txtCaseIDKeyReleased

    private void txtPhoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhoneFocusGained
        // TODO add your handling code here:
        txtPhone.setText("");
    }//GEN-LAST:event_txtPhoneFocusGained

    private void txtPhoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPhoneMouseClicked
        // TODO add your handling code here:
        txtPhone.setText("");
    }//GEN-LAST:event_txtPhoneMouseClicked

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtNationalidFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNationalidFocusGained
        // TODO add your handling code here:
        txtNationalid.setText("");
    }//GEN-LAST:event_txtNationalidFocusGained

    private void txtNationalidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNationalidMouseClicked
        // TODO add your handling code here:
        txtNationalid.setText("");
    }//GEN-LAST:event_txtNationalidMouseClicked

    private void txtNationalidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNationalidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNationalidActionPerformed

    private void txtLastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLastNameFocusGained
        // TODO add your handling code here:
        txtLastName.setText("");
    }//GEN-LAST:event_txtLastNameFocusGained

    private void txtLastNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLastNameMouseClicked
        // TODO add your handling code here:
        txtLastName.setText("");
    }//GEN-LAST:event_txtLastNameMouseClicked

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        // TODO add your handling code here:
      AdminHome admin = new AdminHome();
        admin.setSize(1200,650);
        admin.setLocationRelativeTo(null);
        admin.pack();
        admin.setVisible(true);

    }//GEN-LAST:event_lblBackMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String query = "DELETE FROM complainant where case_id='"+txtCaseID.getText()+"'";
        excecuteSQLQuery(query, "Deleted");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
         String query = "UPDATE complainant SET case_id='"+txtCaseID.getText()+"', "
                + "complainant_firstname='"+txtFirstname.getText()+"', "
                + "complainant_lastname='"+txtLastName.getText()+"', "
                + "complainant_phone_number='"+txtPhone.getText()+"', "
                + "nationalid='"+txtNationalid.getText()+"' WHERE case_id='"+txtCaseID.getText()+"'";
            excecuteSQLQuery(query, "Updated");
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jTable_Display_ComplainantsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Display_ComplainantsMouseClicked
          //Display Selected Row in JTextFields
        int i = jTable_Display_Complainants.getSelectedRow();
        TableModel model = jTable_Display_Complainants.getModel();
        txtCaseID.setText(model.getValueAt(i, 1).toString());
        txtFirstname.setText(model.getValueAt(i, 2).toString());
        txtLastName.setText(model.getValueAt(i, 3).toString());
        txtPhone.setText(model.getValueAt(i, 4).toString());
        txtNationalid.setText(model.getValueAt(i, 5).toString());
    }//GEN-LAST:event_jTable_Display_ComplainantsMouseClicked

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lblExitMouseClicked

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
            java.util.logging.Logger.getLogger(ComplainantOverview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComplainantOverview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComplainantOverview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComplainantOverview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComplainantOverview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel jPanelComplainant;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTable_Display_Complainants;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblCaseid;
    private javax.swing.JLabel lblCases;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblFirstname;
    private javax.swing.JLabel lblLastname;
    private javax.swing.JLabel lblNationalid;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JTextField txtCaseID;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtNationalid;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
