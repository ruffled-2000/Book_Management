
import BLL.BLLDanhMuc;
import DTO.DTODanhMuc;
import static java.awt.image.ImageObserver.HEIGHT;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
public class PanelQuanLyDanhMuc extends javax.swing.JPanel {

    /**
     * Creates new form PanelQuanLyDanhMuc
     */
    public static ResultSet rs = null;
    public BLLDanhMuc danhMuc = new BLLDanhMuc();
    public ArrayList<DTODanhMuc> danhMucs = new ArrayList<DTODanhMuc>();

    public PanelQuanLyDanhMuc() {
        initComponents();
        LoadData();
    }

    private void LoadBang() {
        jTableDanhMuc.removeAll();
        String[] tieuDe = {"STT", "Mã danh mục", "Tên danh mục"};
        DefaultTableModel model = new DefaultTableModel(tieuDe, 0);
        int i = 1;
        for (DTODanhMuc danhMuc : danhMucs) {
            Vector vt = new Vector();
            vt.add(String.valueOf(i));
            vt.add(danhMuc.getMaDanhMuc());
            vt.add(danhMuc.getTenDanhMuc());
            model.addRow(vt);
            i++;
        }
        jTableDanhMuc.setModel(model);
    }

    private void LoadData() {
        try {
            danhMucs.clear();
            rs = danhMuc.ShowDanhMuc();
            while (rs.next()) {
                DTODanhMuc a = new DTODanhMuc();
                a.setMaDanhMuc(Integer.parseInt(rs.getString("MaDanhMuc")));
                a.setTenDanhMuc(rs.getString("TenDanhMuc"));
                danhMucs.add(a);
            }
            LoadBang();
        } catch (SQLException e) {
        } catch (Exception ex) {
            Logger.getLogger(PanelQuanLyTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDanhMuc = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButtonThem = new javax.swing.JButton();
        jButtonXoa = new javax.swing.JButton();
        jButtonSua = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jTextFieldTimKiem = new javax.swing.JTextField();
        jButtonTimKiem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTenDanhMuc = new javax.swing.JTextField();

        setBackground(new java.awt.Color(85, 65, 118));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableDanhMuc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTableDanhMuc.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableDanhMuc.setFocusable(false);
        jTableDanhMuc.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTableDanhMuc.setRowHeight(25);
        jTableDanhMuc.setSelectionBackground(new java.awt.Color(51, 102, 255));
        jTableDanhMuc.setShowVerticalLines(false);
        jTableDanhMuc.getTableHeader().setReorderingAllowed(false);
        jTableDanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDanhMucMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDanhMuc);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, 470));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonThem.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButtonThem.setText("Thêm");
        jButtonThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemActionPerformed(evt);
            }
        });

        jButtonXoa.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButtonXoa.setText("Xóa");
        jButtonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaActionPerformed(evt);
            }
        });

        jButtonSua.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButtonSua.setText("Sửa");
        jButtonSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuaActionPerformed(evt);
            }
        });

        jButtonReset.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        jTextFieldTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextFieldTimKiem.setText("Tìm kiếm theo tên danh mục");
        jTextFieldTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldTimKiemMouseClicked(evt);
            }
        });
        jTextFieldTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTimKiemActionPerformed(evt);
            }
        });

        jButtonTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-search-20.png"))); // NOI18N
        jButtonTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTimKiemActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        jLabel1.setText("CÁC CHỨC NĂNG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonThem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButtonSua, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextFieldTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jButtonTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jTextFieldTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 450, 320));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tên danh mục:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, -1, 28));

        jTextFieldTenDanhMuc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextFieldTenDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTenDanhMucActionPerformed(evt);
            }
        });
        add(jTextFieldTenDanhMuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 60, 220, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldTimKiemMouseClicked
        // TODO add your handling code here:
        jTextFieldTimKiem.setText("");
    }//GEN-LAST:event_jTextFieldTimKiemMouseClicked

    private void jButtonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemActionPerformed
        // TODO add your handling code here:
        try {
            if (jTextFieldTenDanhMuc.getText().equals("")) {
                throw new Exception("Không được để trống danh mục");
            }
            danhMuc.insertDanhMuc(jTextFieldTenDanhMuc.getText());
            LoadData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jButtonThem, e.getMessage(), "Lỗi nhập liệu", HEIGHT);
        }
        LoadData();
    }//GEN-LAST:event_jButtonThemActionPerformed

    private void jTableDanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDanhMucMouseClicked
        // TODO add your handling code here:
        int index = jTableDanhMuc.getSelectedRow();
        jTextFieldTenDanhMuc.setText(jTableDanhMuc.getModel().getValueAt(index, 2).toString());
    }//GEN-LAST:event_jTableDanhMucMouseClicked

    private void jButtonSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuaActionPerformed
        // TODO add your handling code here:
        try {
            if (jTextFieldTenDanhMuc.getText().equals("")) {
                throw new Exception("Không được để trống danh mục");
            }
            int index = jTableDanhMuc.getSelectedRow();
            danhMuc.updateDanhMuc(Integer.parseInt(jTableDanhMuc.getModel().getValueAt(index, 1).toString()), jTextFieldTenDanhMuc.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jButtonSua, e.getMessage(), "Lỗi nhập liệu", HEIGHT);
        }
        LoadData();
    }//GEN-LAST:event_jButtonSuaActionPerformed

    private void jButtonTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimKiemActionPerformed
        // TODO add your handling code here:
        try {
            if (jTextFieldTimKiem.getText().equals("")) {
                throw new Exception("Vui lòng nhập thông tin tìm kiếm");
            }
            danhMucs.clear();
            rs = danhMuc.TimKiemDanhMuc(jTextFieldTimKiem.getText());
            while (rs.next()) {
                DTODanhMuc a = new DTODanhMuc();
                a.setMaDanhMuc(Integer.parseInt(rs.getString("MaDanhMuc")));
                a.setTenDanhMuc(rs.getString("TenDanhMuc"));
                danhMucs.add(a);
            }
            LoadBang();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jButtonTimKiem, e.getMessage(), "Lỗi nhập liệu", HEIGHT);
        }
    }//GEN-LAST:event_jButtonTimKiemActionPerformed

    private void jButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaActionPerformed
        // TODO add your handling code here:
        try {
            int index = jTableDanhMuc.getSelectedRow();
            if (index < 0) {
                throw new Exception("Vui lòng chọn danh mục cần xóa!!");
            }
            int rsPane = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (rsPane == JOptionPane.YES_OPTION) {
                danhMuc.deleteDanhMuc(danhMucs.get(index).getMaDanhMuc());
                danhMucs.remove(index);
                LoadBang();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jButtonXoa, e.getMessage(), "Lỗi nhập liệu", HEIGHT);
        }
    }//GEN-LAST:event_jButtonXoaActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        // TODO add your handling code here:
        jTextFieldTenDanhMuc.setText("");
        jTextFieldTimKiem.setText("Tìm kiếm theo tên danh mục");
        LoadData();
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jTextFieldTenDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTenDanhMucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTenDanhMucActionPerformed

    private void jTextFieldTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonSua;
    private javax.swing.JButton jButtonThem;
    private javax.swing.JButton jButtonTimKiem;
    private javax.swing.JButton jButtonXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDanhMuc;
    private javax.swing.JTextField jTextFieldTenDanhMuc;
    private javax.swing.JTextField jTextFieldTimKiem;
    // End of variables declaration//GEN-END:variables
}
