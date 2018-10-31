/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lnj.restaurant;
import javax.swing.*;
import java.sql.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Josiane Mango
 */
public class LooginAdmin extends javax.swing.JFrame {

    /**
     * Creates new form LoginAg
     */
    public LooginAdmin() {
        initComponents();
        //JFrame frame= new JFrame();
       this.setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        password = new javax.swing.JPasswordField();
        username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        login = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(450, 400));
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(password);
        password.setBounds(220, 190, 170, 30);

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        getContentPane().add(username);
        username.setBounds(220, 130, 170, 30);

        jLabel2.setText("Username");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(51, 51, 0)));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 130, 140, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 102, 0));
        jLabel4.setText("Login Page");
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 1, 1, 6));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 0, 460, 80);

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        exit.setText("Exit");
        exit.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(51, 51, 0)));
        exit.setOpaque(false);
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit);
        exit.setBounds(270, 260, 90, 21);

        login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Login.png"))); // NOI18N
        login.setText("Login");
        login.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(51, 51, 0)));
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login);
        login.setBounds(70, 260, 90, 21);

        jLabel3.setText("Password");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(51, 51, 0)));
        jLabel3.setMaximumSize(new java.awt.Dimension(52, 18));
        jLabel3.setMinimumSize(new java.awt.Dimension(52, 18));
        jLabel3.setPreferredSize(new java.awt.Dimension(52, 18));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 190, 140, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/96917059-wooden-board-empty-table-top-on-of-blurred-background-perspective-brown-wood-table-over-blur-in-coff.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 51, 0), new java.awt.Color(51, 51, 0)));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 80, 470, 230);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
       System.exit(0);
    }//GEN-LAST:event_exitActionPerformed
/*private void previousActionPerformed(java.awt.event.ActionEvent evt){
    HomePage hp= new HomePage();
    hp.setVisible(true);
    hp.pack();
    hp.setLocationRelativeTo(null);
    this.dispose();
}*/
    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
       Connection con=null;
        PreparedStatement ps;
        ResultSet rs;
        String user= username.getText();
        String pass= String.valueOf(password.getPassword());
        String query= "SELECT * FROM loginadmin WHERE Username = ? AND Password= ? " ;
        
        
        try{
            ps=Connection.getConnection().prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs=ps.executeQuery();
            if (rs.next()){
                JOptionPane.showMessageDialog(null, "login successful");
                Customerinfo ci= new Customerinfo();
                ci.setVisible(true);
                ci.setLocationRelativeTo(null);
                ci.pack();
                this.dispose();
            }else {
        JOptionPane.showMessageDialog(null, "Please, check your credentials");
        }
        }
            catch(Exception ex){
Logger.getLogger(LooginAdmin.class.getName()).log(Level.SEVERE, null, ex);
       }
     
    }//GEN-LAST:event_loginActionPerformed
    
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
            java.util.logging.Logger.getLogger(LooginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LooginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LooginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LooginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LooginAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
