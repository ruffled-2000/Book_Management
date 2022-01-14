
import BLL.BLLTaiKhoan;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import static java.awt.image.ImageObserver.HEIGHT;
import java.sql.ResultSet;
import java.time.Clock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.S
 */

/**
 *
 * @author LongTienSinh
 */
public class DangNhap extends javax.swing.JFrame {

    /**
     * Creates new form DangNhap
     */
    BLL.BLLTaiKhoan taiKhoanBLL = new BLLTaiKhoan();
    
    public DangNhap() {
        initComponents();
        setResizable(false);
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

        jPanel1 = new javax.swing.JPanel();
        jLabelDangNhap = new javax.swing.JLabel();
        jTextFieldTenDangNhap = new javax.swing.JTextField();
        jPasswordMatKhau = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonDangNhap = new javax.swing.JButton();
        jButtonHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 33, 89));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDangNhap.setText("ĐĂNG NHẬP");
        jPanel1.add(jLabelDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        jTextFieldTenDangNhap.setBackground(new java.awt.Color(51, 33, 89));
        jTextFieldTenDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldTenDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldTenDangNhap.setText("Tên đăng nhập");
        jTextFieldTenDangNhap.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextFieldTenDangNhap.setOpaque(false);
        jTextFieldTenDangNhap.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldTenDangNhapFocusLost(evt);
            }
        });
        jTextFieldTenDangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldTenDangNhapMouseClicked(evt);
            }
        });
        jTextFieldTenDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTenDangNhapActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldTenDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 127, 228, 29));

        jPasswordMatKhau.setBackground(new java.awt.Color(51, 33, 89));
        jPasswordMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPasswordMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordMatKhau.setText("matkhau");
        jPasswordMatKhau.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPasswordMatKhau.setOpaque(false);
        jPasswordMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordMatKhauMouseClicked(evt);
            }
        });
        jPasswordMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordMatKhauActionPerformed(evt);
            }
        });
        jPanel1.add(jPasswordMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 180, 228, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-male-user-50.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 50, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-user-male-30.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 127, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-forgot-password-30.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 180, -1, -1));

        jButtonDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonDangNhap.setText("Đăng nhập");
        jButtonDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDangNhapActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 235, 110, -1));

        jButtonHuy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonHuy.setText("Hủy");
        jButtonHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHuyActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 235, 110, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTenDangNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldTenDangNhapMouseClicked
        // TODO add your handling code here:
        jTextFieldTenDangNhap.setText("");
    }//GEN-LAST:event_jTextFieldTenDangNhapMouseClicked

    private void jPasswordMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordMatKhauMouseClicked
        jPasswordMatKhau.setText("");
    }//GEN-LAST:event_jPasswordMatKhauMouseClicked

    private void jButtonHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHuyActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButtonHuyActionPerformed

    private void jButtonDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDangNhapActionPerformed
        try {
            // TODO add your handling code here:
            ResultSet rs = taiKhoanBLL.DangNhap(jTextFieldTenDangNhap.getText(),String.valueOf(jPasswordMatKhau.getPassword()));
            if(rs.next()){
//                WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
//                Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
                dispose();
                new JFrameTrangChu(jTextFieldTenDangNhap.getText()).setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(jButtonDangNhap, "Sai tên đăng nhập hoặc mật khẩu", "Không thể đăng nhập", HEIGHT);
            }
        } catch (Exception ex) {
            Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonDangNhapActionPerformed

    private void jTextFieldTenDangNhapFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldTenDangNhapFocusLost
        // TODO add your handling code here:
//        jPasswordMatKhau.setText("");
    }//GEN-LAST:event_jTextFieldTenDangNhapFocusLost

    private void jPasswordMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordMatKhauActionPerformed

    private void jTextFieldTenDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTenDangNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTenDangNhapActionPerformed

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
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDangNhap;
    private javax.swing.JButton jButtonHuy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelDangNhap;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordMatKhau;
    private javax.swing.JTextField jTextFieldTenDangNhap;
    // End of variables declaration//GEN-END:variables
}
