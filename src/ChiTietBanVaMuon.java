
import BLL.BLLChiTietHoaDon;
import BLL.BLLChiTietPhieuMuon;
import BLL.BLLGiaoTrinh;
import BLL.BLLHoaDon;
import BLL.BLLPhieuMuon;
import BLL.BLLQuanLySinhVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LongTienSinh
 */
public class ChiTietBanVaMuon extends javax.swing.JDialog {

    /**
     * Creates new form ChiTietBanVaMuon
     */
    BLL.BLLChiTietPhieuMuon chiTietPhieuMuonBLL = new BLLChiTietPhieuMuon();
    BLL.BLLGiaoTrinh giaoTrinhBLL = new BLLGiaoTrinh();
    BLL.BLLQuanLySinhVien quanLySinhVienBLL = new BLLQuanLySinhVien();
    BLL.BLLPhieuMuon phieuMuonBLL = new BLLPhieuMuon();
    BLL.BLLChiTietHoaDon chiTietHoaDonBLL = new BLLChiTietHoaDon();
    BLL.BLLHoaDon hoaDonBLL = new BLLHoaDon();
    int luachon=0;

    public ChiTietBanVaMuon(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public ChiTietBanVaMuon(java.awt.Frame parent, boolean modal, int soPhieuOrHD, String loai) {
        super(parent, modal);
        this.setLocationRelativeTo(null);
        initComponents();
        setResizable(false);
        System.out.println(loai);
        try {
            if (loai.equals("PhieuMuon") == true) {
                jLabelTieuDe.setText("PHIẾU MƯỢN");
                jTextFieldTongTien.setVisible(false);
                jLabelTongTien.setVisible(false);
                jTableThongTin.removeAll();
                String[] tieuDe = {"STT", "Tên giáo trình", "Ngày mượn"};
                DefaultTableModel model = new DefaultTableModel(tieuDe, 0);
                int i = 1;
                jLabelMaPhieu.setText(String.valueOf(soPhieuOrHD));
                ResultSet rs = chiTietPhieuMuonBLL.ShowChiTietPhieuMuonWithSoPM(soPhieuOrHD);
                ResultSet rsPhieuMuon = phieuMuonBLL.SearchPhieuMuonWithSoPM(soPhieuOrHD);
                rsPhieuMuon.next();
                ResultSet rsSinhVien = quanLySinhVienBLL.getThongTinSinhVien(rsPhieuMuon.getString("MaSV"));
                rsSinhVien.next();
                jLabelMaSinhVien.setText(rsSinhVien.getString("MaSV"));
                jLabelTenSinhVien.setText(rsSinhVien.getString("TenSV"));
                if(Integer.parseInt(rsPhieuMuon.getString("TinhTrang"))==1)
                    jLabelTinhTrang.setText("Đã trả");
                while (rs.next()) {
                    Vector vt = new Vector();
                    vt.add(i);
                    ResultSet rsGiaoTrinhBLL = giaoTrinhBLL.getGiaoTrinhByID(Integer.parseInt(rs.getString("MaGT")));
                    rsGiaoTrinhBLL.next();
                    vt.add(rsGiaoTrinhBLL.getString("TenGT"));
                    vt.add(rs.getString("NgayMuon"));
                    i++;
                    model.addRow(vt);
                }
                jTableThongTin.setModel(model);

            } else {
                jLabelTieuDe.setText("HÓA ĐƠN");
                jTextFieldTongTien.setVisible(true);
                jLabelTongTien.setVisible(true);
                jLabelTinhTrang.setVisible(false);
                jLabelTT.setVisible(false);
                jTextFieldTongTien.setEnabled(false);
                jTableThongTin.removeAll();
                String[] tieuDe = {"STT", "Tên giáo trình", "Số lượng bán", "Giá bán", "Ngày bán", "Thành tiền"};
                DefaultTableModel model = new DefaultTableModel(tieuDe, 0);
                int i = 1;
                jLabelMaPhieu.setText(String.valueOf(soPhieuOrHD));
                ResultSet rs = chiTietHoaDonBLL.getChiTietHoaDon(soPhieuOrHD);
                ResultSet rsHoaDon = hoaDonBLL.SearchHoaDonWithSoPM(soPhieuOrHD);
                rsHoaDon.next();
                ResultSet rsSinhVien = quanLySinhVienBLL.getThongTinSinhVien(rsHoaDon.getString("MaSV"));
                rsSinhVien.next();
                jLabelMaSinhVien.setText(rsSinhVien.getString("MaSV"));
                jLabelTenSinhVien.setText(rsSinhVien.getString("TenSV"));
                while (rs.next()) {
                    Vector vt = new Vector();
                    vt.add(i);
                    ResultSet rsGiaoTrinhBLL = giaoTrinhBLL.getGiaoTrinhByID(Integer.parseInt(rs.getString("MaGT")));
                    rsGiaoTrinhBLL.next();
                    vt.add(rsGiaoTrinhBLL.getString("TenGT"));
                    vt.add(rs.getString("SoLuongBan"));
                    vt.add(rsGiaoTrinhBLL.getString("GiaBan"));
                    vt.add(rs.getString("NgayBan"));
                    int thanhTien = Integer.parseInt(rsGiaoTrinhBLL.getString("GiaBan")) * Integer.parseInt(rs.getString("SoLuongBan"));
                    vt.add(String.valueOf(thanhTien));
                    i++;
                    model.addRow(vt);
                }
                ResultSet tongTien=chiTietHoaDonBLL.TinhTien(soPhieuOrHD);
                tongTien.next();
                jTextFieldTongTien.setText(tongTien.getString("TongTien"));
                jTableThongTin.setModel(model);
            }
        } catch (SQLException e) {
        } catch (Exception ex) {
            Logger.getLogger(ChiTietBanVaMuon.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabelTieuDe = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableThongTin = new javax.swing.JTable();
        jLabelTongTien = new javax.swing.JLabel();
        jTextFieldTongTien = new javax.swing.JTextField();
        jLabelMaSinhVien = new javax.swing.JLabel();
        jLabelTenSinhVien = new javax.swing.JLabel();
        jLabelMaPhieu = new javax.swing.JLabel();
        jLabelTT = new javax.swing.JLabel();
        jLabelTinhTrang = new javax.swing.JLabel();
        jButtonXacNhan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(85, 65, 118));

        jLabelTieuDe.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        jLabelTieuDe.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTieuDe.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mã phiếu:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tên sinh viên:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mã sinh viên:");

        jTableThongTin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTableThongTin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableThongTin.setFocusable(false);
        jTableThongTin.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTableThongTin.setRowHeight(25);
        jTableThongTin.setSelectionBackground(new java.awt.Color(51, 102, 255));
        jTableThongTin.setShowVerticalLines(false);
        jTableThongTin.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableThongTin);

        jLabelTongTien.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelTongTien.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTongTien.setText("Tổng tiền");

        jTextFieldTongTien.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabelMaSinhVien.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelMaSinhVien.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMaSinhVien.setText("jLabel5");

        jLabelTenSinhVien.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelTenSinhVien.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTenSinhVien.setText("jLabel6");

        jLabelMaPhieu.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelMaPhieu.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMaPhieu.setText("jLabel7");

        jLabelTT.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelTT.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTT.setText("Tình trạng:");

        jLabelTinhTrang.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelTinhTrang.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTinhTrang.setText("Chưa trả");

        jButtonXacNhan.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButtonXacNhan.setText("Xác nhận");
        jButtonXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXacNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMaSinhVien)
                            .addComponent(jLabelTenSinhVien)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelMaPhieu)
                                .addGap(127, 127, 127)
                                .addComponent(jLabelTT)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelTinhTrang))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(jLabelTieuDe))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabelTongTien)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonXacNhan)
                            .addComponent(jTextFieldTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTieuDe)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelMaPhieu)
                    .addComponent(jLabelTT)
                    .addComponent(jLabelTinhTrang))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabelTenSinhVien))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabelMaSinhVien))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTongTien)
                    .addComponent(jTextFieldTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButtonXacNhan)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXacNhanActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonXacNhanActionPerformed

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
            java.util.logging.Logger.getLogger(ChiTietBanVaMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietBanVaMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietBanVaMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietBanVaMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChiTietBanVaMuon dialog = new ChiTietBanVaMuon(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonXacNhan;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelMaPhieu;
    private javax.swing.JLabel jLabelMaSinhVien;
    private javax.swing.JLabel jLabelTT;
    private javax.swing.JLabel jLabelTenSinhVien;
    private javax.swing.JLabel jLabelTieuDe;
    private javax.swing.JLabel jLabelTinhTrang;
    private javax.swing.JLabel jLabelTongTien;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableThongTin;
    private javax.swing.JTextField jTextFieldTongTien;
    // End of variables declaration//GEN-END:variables
}
