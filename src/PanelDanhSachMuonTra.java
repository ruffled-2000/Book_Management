
import BLL.BLLChiTietPhieuMuon;
import BLL.BLLDanhMuc;
import BLL.BLLGiaoTrinh;
import BLL.BLLPhieuMuon;
import BLL.BLLQuanLySinhVien;
import DTO.DTOChiTietPhieuMuon;
import DTO.DTOGiaoTrinh;
import DTO.DTOPhieuMuon;
import DTO.DTOSinhVien;
import java.awt.event.MouseEvent;
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
public class PanelDanhSachMuonTra extends javax.swing.JPanel {

    /**
     * Creates new form PanelQuanLyMuonTra
     */
    public static ResultSet rsDanhMuc = null;
    public static ResultSet rsChiTietPhieuMuon = null;
    public static ResultSet rsPhieuMuon = null;
    public static ResultSet rsGiaoTrinh = null;
    public static ResultSet rsSinhVien = null;
    public BLL.BLLDanhMuc danhMucBLL = new BLLDanhMuc();
    public BLL.BLLChiTietPhieuMuon chiTietPhieuMuonBLL = new BLLChiTietPhieuMuon();
    public BLL.BLLPhieuMuon PhieuMuonBLL = new BLLPhieuMuon();
    public BLL.BLLGiaoTrinh giaoTrinhBLL = new BLLGiaoTrinh();
    public BLL.BLLQuanLySinhVien sinhVienBLL = new BLLQuanLySinhVien();
    public DTOPhieuMuon phieuMuon = new DTOPhieuMuon();
    public DTO.DTOSinhVien sinhVien = new DTOSinhVien();
    public ArrayList<DTO.DTOGiaoTrinh> giaoTrinhs = new ArrayList<DTOGiaoTrinh>();
    public ArrayList<DTO.DTOSinhVien> sinhViens = new ArrayList<DTOSinhVien>();
    public ArrayList<DTO.DTOPhieuMuon> phieuMuons = new ArrayList<DTOPhieuMuon>();
    public ArrayList<DTO.DTOChiTietPhieuMuon> chiTietPhieuMuonns = new ArrayList<DTOChiTietPhieuMuon>();

    public PanelDanhSachMuonTra() {
        initComponents();
        jComboBoxLoc.setSelectedIndex(-1);
        LoadData();
        jComboBoxLoc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxLocItemStateChanged(evt);
            }
        });
    }

    private void LoadBang() throws Exception {
        try {
            jTableThongTinMuonTra.removeAll();
            String[] tieuDe = {"STT", "Mã sinh viên", "Tên sinh viên", "Số phiếu mượn", "Tên giáo trình", "Ngày mượn", "Ngày trả", "Tình trạng"};
            DefaultTableModel model = new DefaultTableModel(tieuDe, 0);
            int i = 1;
            if (phieuMuons.isEmpty() == false) {
                for (DTOPhieuMuon a : phieuMuons) {
                    Vector vt = new Vector();
                    vt.add(String.valueOf(i));
                    vt.add(a.getMaSV());
                    System.out.println(a.getMaSV());
                    rsSinhVien = sinhVienBLL.getThongTinSinhVien(a.getMaSV());
                    rsSinhVien.next();
                    System.out.println("Test");
                    vt.add(rsSinhVien.getString("TenSV"));
                    vt.add(a.getSoPhieuMuon());
                    rsGiaoTrinh = giaoTrinhBLL.getGiaoTrinhByWithSoPM(Integer.parseInt(String.valueOf(a.getSoPhieuMuon())));
                    String tenGT = "";
                    while (rsGiaoTrinh.next()) {
                        tenGT = tenGT+rsGiaoTrinh.getString("TenGT")+", ";
                    }
                    tenGT = tenGT.substring(0, tenGT.length()-2);
                    rsChiTietPhieuMuon = chiTietPhieuMuonBLL.ShowChiTietPhieuMuonWithSoPM(a.getSoPhieuMuon());
                    rsChiTietPhieuMuon.next();
                    vt.add(tenGT);
                    vt.add(rsChiTietPhieuMuon.getString("NgayMuon"));
                    vt.add(rsChiTietPhieuMuon.getString("NgayTra"));
                    if (a.getTinhTrang() == 0) {
                        vt.add("Chưa trả");
                    } else {
                        vt.add("Đã trả");
                    }
                    model.addRow(vt);
                    i++;
                }
            }
            jTableThongTinMuonTra.setModel(model);
        } catch (SQLException e) {
        }
    }

    private void LoadData() {
        try {
            phieuMuons.clear();
            rsPhieuMuon = PhieuMuonBLL.ShowPhieuMuon();
            while (rsPhieuMuon.next()) {
                DTOPhieuMuon a = new DTOPhieuMuon();
                a.setSoPhieuMuon(Integer.parseInt(rsPhieuMuon.getString("SoPhieuMuon")));
                a.setMaSV(rsPhieuMuon.getString("MaSV"));
                a.setTinhTrang(Integer.parseInt(rsPhieuMuon.getString("TinhTrang")));
                phieuMuons.add(a);
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

        jPopupMenu = new javax.swing.JPopupMenu();
        jMenuItemXoa = new javax.swing.JMenuItem();
        jMenuItemTinhTrang = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableThongTinMuonTra = new javax.swing.JTable();
        jComboBoxLoc = new javax.swing.JComboBox<String>();
        jTextFieldTimKiem = new javax.swing.JTextField();
        jButtonTimKiem = new javax.swing.JButton();
        jComboBoxTimKiemTheo = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();
        jButtonReset = new javax.swing.JButton();
        jButtonXemChiTiet = new javax.swing.JButton();

        jMenuItemXoa.setText("Xóa");
        jMenuItemXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemXoaActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMenuItemXoa);

        jMenuItemTinhTrang.setText("Đánh dấu tình trạng");
        jMenuItemTinhTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTinhTrangActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMenuItemTinhTrang);

        jPanel1.setBackground(new java.awt.Color(85, 65, 118));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jTableThongTinMuonTra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTableThongTinMuonTra.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableThongTinMuonTra.setFocusable(false);
        jTableThongTinMuonTra.setGridColor(new java.awt.Color(125, 125, 125));
        jTableThongTinMuonTra.setInheritsPopupMenu(true);
        jTableThongTinMuonTra.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTableThongTinMuonTra.setRowHeight(25);
        jTableThongTinMuonTra.setSelectionBackground(new java.awt.Color(51, 102, 255));
        jTableThongTinMuonTra.setShowVerticalLines(false);
        jTableThongTinMuonTra.getTableHeader().setReorderingAllowed(false);
        jTableThongTinMuonTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableThongTinMuonTraMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableThongTinMuonTra);

        jComboBoxLoc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jComboBoxLoc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chưa trả", "Đã trả" }));

        jTextFieldTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextFieldTimKiem.setText("Tìm kiếm");
        jTextFieldTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextFieldTimKiemMousePressed(evt);
            }
        });

        jButtonTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButtonTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-search-20.png"))); // NOI18N
        jButtonTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTimKiemActionPerformed(evt);
            }
        });

        jComboBoxTimKiemTheo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jComboBoxTimKiemTheo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theo mã sinh viên", "Theo số phiếu mượn" }));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lọc");

        jButtonReset.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        jButtonXemChiTiet.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButtonXemChiTiet.setText("Xem chi tiết phiếu mượn");
        jButtonXemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXemChiTietActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxTimKiemTheo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jButtonReset)
                .addGap(145, 145, 145))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonXemChiTiet)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 985, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBoxTimKiemTheo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonTimKiem))
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jButtonReset))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonXemChiTiet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTableThongTinMuonTraMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableThongTinMuonTraMouseReleased
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON3) {
            int index = jTableThongTinMuonTra.getSelectedRow();
            if (jTableThongTinMuonTra.getValueAt(index, 7).equals("Chưa trả")) {
                jMenuItemTinhTrang.setText("Đánh dấu đã trả");
            } else {
                jMenuItemTinhTrang.setText("Đánh dấu chưa trả");
            }
            if (evt.isPopupTrigger() && jTableThongTinMuonTra.getSelectedRowCount() != 0) {
                jPopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_jTableThongTinMuonTraMouseReleased

    private void jMenuItemXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemXoaActionPerformed
        // TODO add your handling code here:
        try {
            int rsPane = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (rsPane == JOptionPane.YES_OPTION) {
                int index = jTableThongTinMuonTra.getSelectedRow();
                chiTietPhieuMuonBLL.deleteChiTietPhieuMuon(phieuMuons.get(index).getSoPhieuMuon());
                PhieuMuonBLL.deletePhieuMuon(phieuMuons.get(index).getSoPhieuMuon());
                phieuMuons.remove(index);
                LoadBang();
            }
        } catch (Exception ex) {
            Logger.getLogger(PanelDanhSachMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemXoaActionPerformed
    private void jComboBoxLocItemStateChanged(java.awt.event.ItemEvent evt) {
        // TODO add your handling code here:
        try {
            int tinhTrang;
            if (jComboBoxLoc.getSelectedIndex() == 0) {
                tinhTrang = 0;
            } else {
                tinhTrang = 1;
            }
            phieuMuons.clear();
            rsPhieuMuon = PhieuMuonBLL.SearchPhieuMuonWithTinhTrang(tinhTrang);
            while (rsPhieuMuon.next()) {
                DTOPhieuMuon a = new DTOPhieuMuon();
                a.setSoPhieuMuon(Integer.parseInt(rsPhieuMuon.getString("SoPhieuMuon")));
                a.setMaSV(rsPhieuMuon.getString("MaSV"));
                phieuMuons.add(a);
            }
            LoadBang();
        } catch (SQLException ex) {
            Logger.getLogger(PanelDanhSachMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PanelDanhSachMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void jMenuItemTinhTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTinhTrangActionPerformed
        // TODO add your handling code here:
        int index = jTableThongTinMuonTra.getSelectedRow();
        if (jMenuItemTinhTrang.getText().equals("Đánh dấu đã trả")) {
            PhieuMuonBLL.updateTinhTrangPhieuMuon(phieuMuons.get(index).getSoPhieuMuon(), 1);
        } else {
            PhieuMuonBLL.updateTinhTrangPhieuMuon(phieuMuons.get(index).getSoPhieuMuon(), 0);
        }
        LoadData();
    }//GEN-LAST:event_jMenuItemTinhTrangActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        try {
            // TODO add your handling code here:
            jComboBoxLoc.setSelectedIndex(-1);
            jTextFieldTimKiem.setText("Tìm kiếm");
            LoadData();
        } catch (Exception ex) {
            Logger.getLogger(PanelDanhSachMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButtonTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimKiemActionPerformed
        // TODO add your handling code here:
        try {
            if (jTextFieldTimKiem.getText().equals("")) {
                throw new Exception("Không được để trống ô tìm kiếm!!!");
            }
            if (jComboBoxTimKiemTheo.getSelectedIndex() == 0) {
                rsPhieuMuon = PhieuMuonBLL.SearchPhieuMuonWithMaSV(jTextFieldTimKiem.getText());
            }
            if (jComboBoxTimKiemTheo.getSelectedIndex() == 1) {
                rsPhieuMuon = PhieuMuonBLL.SearchPhieuMuonWithSoPM(Integer.parseInt(jTextFieldTimKiem.getText()));
            }
            if (rsPhieuMuon.next() == false) {
                JOptionPane.showMessageDialog(jButtonTimKiem, "Không tìm thấy thông tin", "Không tìm thấy!!", HEIGHT);
            } else {
                phieuMuons.clear();
                do {
                    DTOPhieuMuon a = new DTOPhieuMuon();
                    a.setSoPhieuMuon(Integer.parseInt(rsPhieuMuon.getString("SoPhieuMuon")));
                    a.setMaSV(rsPhieuMuon.getString("MaSV"));
                    phieuMuons.add(a);
                } while (rsPhieuMuon.next());
            }
            LoadBang();
        } catch (SQLException ex) {
            Logger.getLogger(PanelQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(jButtonTimKiem, ex.getMessage(), "Lỗi nhập liệu", HEIGHT);
        }
    }//GEN-LAST:event_jButtonTimKiemActionPerformed

    private void jButtonXemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXemChiTietActionPerformed
        // TODO add your handling code here:
        try {
            int index = jTableThongTinMuonTra.getSelectedRow();
            if(index<0)
                throw new Exception("Hãy chọn phiếu mượn cần xem");
            ChiTietBanVaMuon chiTietBanVaMuon = new ChiTietBanVaMuon(null, true, phieuMuons.get(index).getSoPhieuMuon(), "PhieuMuon");
            chiTietBanVaMuon.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jButtonTimKiem, e.getMessage(), "Chọn phiếu mượn", HEIGHT);
        }
        
    }//GEN-LAST:event_jButtonXemChiTietActionPerformed

    private void jTextFieldTimKiemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldTimKiemMousePressed
        // TODO add your handling code here:
        jTextFieldTimKiem.setText("");
    }//GEN-LAST:event_jTextFieldTimKiemMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonTimKiem;
    private javax.swing.JButton jButtonXemChiTiet;
    private javax.swing.JComboBox<String> jComboBoxLoc;
    private javax.swing.JComboBox<String> jComboBoxTimKiemTheo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItemTinhTrang;
    private javax.swing.JMenuItem jMenuItemXoa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableThongTinMuonTra;
    private javax.swing.JTextField jTextFieldTimKiem;
    // End of variables declaration//GEN-END:variables
}
