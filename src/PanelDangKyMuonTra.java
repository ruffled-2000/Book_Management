
import BLL.BLLChiTietPhieuMuon;
import BLL.BLLDanhMuc;
import BLL.BLLGiaoTrinh;
import BLL.BLLPhieuMuon;
import BLL.BLLQuanLySinhVien;
import DTO.DTOChiTietPhieuMuon;
import DTO.DTODanhMuc;
import DTO.DTOGiaoTrinh;
import DTO.DTOPhieuMuon;
import DTO.DTOSinhVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
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
public class PanelDangKyMuonTra extends javax.swing.JPanel {

    /**
     * Creates new form PanelQuanLuMuonTra
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
    public DTO.DTOSinhVien sinhVien = new DTOSinhVien();
    public ArrayList<DTO.DTODanhMuc> danhMucs = new ArrayList<DTODanhMuc>();
    public ArrayList<DTO.DTOGiaoTrinh> giaoTrinhs = new ArrayList<DTOGiaoTrinh>();
    public ArrayList<DTO.DTOChiTietPhieuMuon> chiTietPhieuMuonns = new ArrayList<DTOChiTietPhieuMuon>();
    public DTOPhieuMuon phieuMuon = new DTOPhieuMuon();

    public int ThemPM = 0;

    public PanelDangKyMuonTra() {
        initComponents();
        LoadData();
        jTextFieldTenSV.setEnabled(false);
        jTextFieldDiaChi.setEnabled(false);
        jTextFieldEmail.setEnabled(false);
        jComboBoxLoaiGT.setEnabled(false);
        jComboBoxTenGT.setEnabled(false);
        jButtonTao.setEnabled(false);
        jButtonXoa.setEnabled(false);
        jButtonXacNhan.setEnabled(false);
        dateChooserComboNgayHenTra.setEnabled(false);
        jComboBoxLoaiGT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxLoaiGTItemStateChanged(evt);
            }
        });
        jComboBoxLoaiGT.setSelectedIndex(-1);
        jComboBoxTenGT.setSelectedIndex(-1);
    }

    private void jComboBoxLoaiGTItemStateChanged(java.awt.event.ItemEvent evt) {
        // TODO add your handling code here:
        int index = jComboBoxLoaiGT.getSelectedIndex();
        if (index >= 0) {
            jComboBoxTenGT.removeAllItems();
            giaoTrinhs.clear();
            try {
                rsGiaoTrinh = giaoTrinhBLL.ShowGiaoTrinhWithDanhMuc(danhMucs.get(index).getMaDanhMuc());
                while (rsGiaoTrinh.next()) {
                    DTOGiaoTrinh a = new DTOGiaoTrinh();
                    a.setMaGT(Integer.parseInt(rsGiaoTrinh.getString("MaGT")));
                    a.setTenGT(rsGiaoTrinh.getString("TenGT"));
                    a.setTacGia(rsGiaoTrinh.getString("TacGia"));
                    a.setMaNXB(Integer.parseInt(rsGiaoTrinh.getString("MaNXB")));
                    a.setMaDanhMuc(Integer.parseInt(rsGiaoTrinh.getString("MaDanhMuc")));
                    a.setNamXB(rsGiaoTrinh.getString("NamXB"));
                    a.setLanXB(Integer.parseInt(rsGiaoTrinh.getString("LanXB")));
                    a.setSoLuong(Integer.parseInt(rsGiaoTrinh.getString("SoLuong")));
                    a.setGiaBan(Integer.parseInt(rsGiaoTrinh.getString("GiaBan")));
                    jComboBoxTenGT.addItem(a.getTenGT());
                    giaoTrinhs.add(a);
                }
            } catch (Exception ex) {
                Logger.getLogger(PanelQuanLyBanGiaoTrinh.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableThongTinMuonTra = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldMaSV = new javax.swing.JTextField();
        jTextFieldTenSV = new javax.swing.JTextField();
        jRadioButtonNam = new javax.swing.JRadioButton();
        jRadioButtonNu = new javax.swing.JRadioButton();
        jTextFieldDiaChi = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jButtonKiemTra = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButtonTao = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxLoaiGT = new javax.swing.JComboBox<String>();
        jComboBoxTenGT = new javax.swing.JComboBox<String>();
        jLabel15 = new javax.swing.JLabel();
        dateChooserComboNgayHenTra = new datechooser.beans.DateChooserCombo();
        jButtonXoa = new javax.swing.JButton();
        jButtonXacNhan = new javax.swing.JButton();

        setBackground(new java.awt.Color(85, 65, 118));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

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
        jTableThongTinMuonTra.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTableThongTinMuonTra.setSelectionBackground(new java.awt.Color(51, 102, 255));
        jTableThongTinMuonTra.setShowVerticalLines(false);
        jTableThongTinMuonTra.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableThongTinMuonTra);

        jPanel1.setBackground(new java.awt.Color(85, 65, 118));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Mã sinh viên:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tên sinh viên:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Giới tính:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Địa chỉ:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Email:");

        jTextFieldMaSV.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jTextFieldTenSV.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jRadioButtonNam.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jRadioButtonNam.setText("Nam");

        buttonGroup1.add(jRadioButtonNu);
        jRadioButtonNu.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jRadioButtonNu.setText("Nữ");

        jTextFieldDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jTextFieldEmail.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jButtonKiemTra.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButtonKiemTra.setText("Kiểm tra");
        jButtonKiemTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKiemTraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jRadioButtonNam)
                        .addGap(81, 81, 81)
                        .addComponent(jRadioButtonNu)
                        .addGap(0, 123, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDiaChi, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldTenSV, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldMaSV))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonKiemTra)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonKiemTra, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jRadioButtonNam)
                    .addComponent(jRadioButtonNu))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(85, 65, 118));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jButtonTao.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButtonTao.setText("Tạo");
        jButtonTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTaoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tên giáo trình:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Danh mục:");

        jComboBoxLoaiGT.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jComboBoxLoaiGT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxTenGT.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jComboBoxTenGT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Ngày hẹn trả:");

        dateChooserComboNgayHenTra.setCalendarPreferredSize(new java.awt.Dimension(350, 300));

        jButtonXoa.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButtonXoa.setText("Xóa");
        jButtonXoa.setToolTipText("");
        jButtonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jButtonTao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonXoa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBoxTenGT, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxLoaiGT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateChooserComboNgayHenTra, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBoxLoaiGT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBoxTenGT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateChooserComboNgayHenTra, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTao)
                    .addComponent(jButtonXoa))
                .addGap(24, 24, 24))
        );

        jButtonXacNhan.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButtonXacNhan.setText("Xác nhận");
        jButtonXacNhan.setPreferredSize(new java.awt.Dimension(113, 31));
        jButtonXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXacNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(33, 33, 33)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void reset() {
        try {
            jTextFieldMaSV.setText("");
            jTextFieldTenSV.setText("");
            jTextFieldEmail.setText("");
            jTextFieldDiaChi.setText("");
            jTextFieldTenSV.setEnabled(false);
            jTextFieldDiaChi.setEnabled(false);
            jTextFieldEmail.setEnabled(false);
            jComboBoxLoaiGT.setEnabled(false);
            jComboBoxTenGT.setEnabled(false);
            jButtonTao.setEnabled(false);
            jButtonXoa.setEnabled(false);
            jComboBoxLoaiGT.setSelectedIndex(-1);
            jComboBoxTenGT.setSelectedIndex(-1);
            chiTietPhieuMuonns.clear();
            chiTietPhieuMuonns.clear();
            phieuMuon = new DTOPhieuMuon();
            LoadBang();
        } catch (Exception ex) {
            Logger.getLogger(PanelDangKyMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jButtonXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXacNhanActionPerformed
        // TODO add your handling code here:
        try {

            PhieuMuonBLL.insertPhieuMuon(jTextFieldMaSV.getText());
            rsPhieuMuon = PhieuMuonBLL.LayMaPhieuMuonTiepTheo();
            rsPhieuMuon.next();
            phieuMuon.setSoPhieuMuon(Integer.parseInt(rsPhieuMuon.getString(1)));
            for (int i = 0; i < chiTietPhieuMuonns.size(); i++) {
                chiTietPhieuMuonBLL.insertChiTietPhieuMuon(phieuMuon.getSoPhieuMuon(), chiTietPhieuMuonns.get(i).getMaGT(), chiTietPhieuMuonns.get(i).getNgayMuon(), chiTietPhieuMuonns.get(i).getNgayTra());
            }

            reset();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButtonXacNhanActionPerformed

    private void jButtonKiemTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKiemTraActionPerformed
        // TODO add your handling code here:
        rsSinhVien = sinhVienBLL.getThongTinSinhVien(jTextFieldMaSV.getText());
        try {
            if (rsSinhVien.next()) {

                //rsSinhVien.next();
                sinhVien.setMaSV(rsSinhVien.getString("MaSV"));
                jTextFieldTenSV.setText(rsSinhVien.getString("TenSV"));
                sinhVien.setTenSV(rsSinhVien.getString("TenSV"));
                if (Integer.parseInt(rsSinhVien.getString("GioiTinh")) == 0) {
                    jRadioButtonNam.setSelected(true);
                    sinhVien.setGioiTinh(0);
                } else {
                    jRadioButtonNu.setSelected(true);
                    sinhVien.setGioiTinh(1);
                }
                jTextFieldDiaChi.setText(rsSinhVien.getString("DiaChi"));
                sinhVien.setDiaChi(rsSinhVien.getString("DiaChi"));
                jTextFieldEmail.setText(rsSinhVien.getString("Email"));
                sinhVien.setEmail(rsSinhVien.getString("Email"));
                //rsPhieuMuon.next();
                //                PhieuMuonBLL.insertPhieuMuon(jTextFieldMaSV.getText());
                //                rsPhieuMuon = PhieuMuonBLL.LayMaPhieuMuonTiepTheo();
                //                rsPhieuMuon.next();
                //                phieuMuon.setMaSV(jTextFieldMaSV.getText());
                //                phieuMuon.setSoPhieuMuon(Integer.parseInt(rsPhieuMuon.getString(1)));
                jComboBoxLoaiGT.setEnabled(true);
                jComboBoxTenGT.setEnabled(true);
                jButtonTao.setEnabled(true);
                jButtonXoa.setEnabled(false);
                dateChooserComboNgayHenTra.setEnabled(true);
            } else {
                int rsPane = JOptionPane.showConfirmDialog(this, "Bạn có muốn tạo mới sinh viên?", "Không tồn tại sinh viên này", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (rsPane == JOptionPane.YES_OPTION) {
                    ThemSinhVien themThanhVien = new ThemSinhVien(null, true, jTextFieldMaSV.getText());
                    themThanhVien.setVisible(true);
                    System.out.println("Test");

                    rsSinhVien = sinhVienBLL.getThongTinSinhVien(jTextFieldMaSV.getText());
                    rsSinhVien.next();
                    sinhVien.setMaSV(rsSinhVien.getString("MaSV"));
                    jTextFieldTenSV.setText(rsSinhVien.getString("TenSV"));
                    sinhVien.setTenSV(rsSinhVien.getString("TenSV"));
                    if (Integer.parseInt(rsSinhVien.getString("GioiTinh")) == 0) {
                        jRadioButtonNam.setSelected(true);
                        sinhVien.setGioiTinh(0);
                    } else {
                        jRadioButtonNu.setSelected(true);
                        sinhVien.setGioiTinh(1);
                    }
                    jTextFieldDiaChi.setText(rsSinhVien.getString("DiaChi"));
                    sinhVien.setDiaChi(rsSinhVien.getString("DiaChi"));
                    jTextFieldEmail.setText(rsSinhVien.getString("Email"));
                    sinhVien.setEmail(rsSinhVien.getString("Email"));
                    jComboBoxLoaiGT.setEnabled(true);
                    jComboBoxTenGT.setEnabled(true);
                    jButtonTao.setEnabled(true);
                    jButtonXoa.setEnabled(false);
                    dateChooserComboNgayHenTra.setEnabled(true);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelQuanLyBanGiaoTrinh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonKiemTraActionPerformed

    private void jButtonTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTaoActionPerformed
        // TODO add your handling code here:

        //        try {
        //            int indexGT = jComboBoxTenGT.getSelectedIndex();
        //            ResultSet testSL = giaoTrinhBLL.getGiaoTrinhByID(giaoTrinhs.get(indexGT).getMaGT());
        //            testSL.next();
        //            int slCo = Integer.parseInt(testSL.getString(8));
        //            if(slCo<=0)
        //                throw new Exception("Đã hết sách này không thể cho mượn!");
        ////            if(ThemPM == 0){
        ////                PhieuMuonBLL.insertPhieuMuon(jTextFieldMaSV.getText());
        ////                rsPhieuMuon = PhieuMuonBLL.LayMaPhieuMuonTiepTheo();
        ////                rsPhieuMuon.next();
        ////                phieuMuon.setMaSV(jTextFieldMaSV.getText());
        ////                phieuMuon.setSoPhieuMuon(Integer.parseInt(rsPhieuMuon.getString(1)));
        ////                ThemPM=1;
        ////                jButtonXemChiTiet.setEnabled(true);
        ////                jButtonXacNhan.setEnabled(true);
        ////            }
        //            ResultSet rsSoLuongGTChuaTra = PhieuMuonBLL.DemSoLuongGTChuaTra(sinhVien.getMaSV(), 0);
        //            rsSoLuongGTChuaTra.next();
        //            int sl = Integer.parseInt(rsSoLuongGTChuaTra.getString(1));
        //            if (sl < 2) {
        //                ResultSet rs = chiTietPhieuMuonBLL.getChiTietPhieuMuon(phieuMuon.getSoPhieuMuon(), giaoTrinhs.get(indexGT).getMaGT());
        //                if (rs.next() == false) {
        //                    DTOChiTietPhieuMuon a = new DTOChiTietPhieuMuon();
        //                    a.setSoPhieuMuon(phieuMuon.getSoPhieuMuon());
        //                    a.setMaGT(giaoTrinhs.get(indexGT).getMaGT());
        //                    a.setTinhTrang(0);
        //                    a.setNgayMuon(java.time.LocalDate.now().toString());
        //                    a.setNgayTra(dateChooserComboNgayHenTra.getText());
        //                    chiTietPhieuMuonBLL.insertChiTietPhieuMuon(a.getSoPhieuMuon(), a.getMaGT(), a.getNgayMuon(), a.getNgayTra());
        //                    chiTietPhieuMuonns.add(a);
        //                    LoadBang();
        //                } else {
        //                    //DTOChiTietHoaDon a = new DTOChiTietHoaDon();
        ////                    chiTietPhieuMuonBLL.updateChiTietPhieuMuon(phieuMuon.getSoPhieuMuon(), giaoTrinhs.get(index).getMaGT(), java.time.LocalDate.now().toString(), dateChooserComboNgayHenTra.getText());
        ////                    chiTietPhieuMuonns.clear();
        ////                    rsChiTietPhieuMuon = chiTietPhieuMuonBLL.getChiTietPhieuMuon(phieuMuon.getSoPhieuMuon());
        ////                    while (rsChiTietPhieuMuon.next()) {
        ////                        DTOChiTietPhieuMuon a = new DTOChiTietPhieuMuon();
        ////                        a.setSoPhieuMuon(Integer.parseInt(rsChiTietPhieuMuon.getString("SoPhieuMuon")));
        ////                        a.setMaGT(Integer.parseInt(rsChiTietPhieuMuon.getString("MaGT")));
        ////                        a.setTinhTrang(Integer.parseInt(rsChiTietPhieuMuon.getString("TinhTrang")));
        ////                        a.setNgayMuon(rsChiTietPhieuMuon.getString("NgayMuon"));
        ////                        a.setNgayTra(rsChiTietPhieuMuon.getString("NgayTra"));
        ////                        chiTietPhieuMuonns.add(a);
        //                    //}
        ////                    LoadBang();
        //
        //                    JOptionPane.showMessageDialog(jButtonTao, "Đã mượn giáo trình này rồi", "Thông báo", HEIGHT);
        //                }
        //                jButtonXoa.setEnabled(true);
        //            } else {
        //                PhieuMuonBLL.deletePhieuMuon(phieuMuon.getSoPhieuMuon());
        //                JOptionPane.showMessageDialog(jButtonTao, "Sinh viên này đã mượn 2 sách nhưng chưa trả", "Không thể cho mượn thêm giáo trình", HEIGHT);
        //            }
        //        } catch (SQLException ex) {
        //            Logger.getLogger(PanelQuanLyBanGiaoTrinh.class.getName()).log(Level.SEVERE, null, ex);
        //        } catch (Exception ex) {
        //            Logger.getLogger(PanelQuanLyBanGiaoTrinh.class.getName()).log(Level.SEVERE, null, ex);
        //        }
        try {
            int indexGT = jComboBoxTenGT.getSelectedIndex();
            ResultSet testSL = giaoTrinhBLL.getGiaoTrinhByID(giaoTrinhs.get(indexGT).getMaGT());
            testSL.next();
            int slCo = Integer.parseInt(testSL.getString(8));
            if (slCo <= 0) {
                throw new Exception("Đã hết sách này không thể cho mượn!");
            }

            phieuMuon.setMaSV(jTextFieldMaSV.getText());
            phieuMuon.setTinhTrang(0);
            //phieuMuon.setSoPhieuMuon(Integer.parseInt(rsPhieuMuon.getString(1)));

            DTOChiTietPhieuMuon a = new DTOChiTietPhieuMuon();
            //a.setSoPhieuMuon(phieuMuon.getSoPhieuMuon());
            a.setMaGT(giaoTrinhs.get(indexGT).getMaGT());
            a.setNgayMuon(java.time.LocalDate.now().toString());
            a.setNgayTra(dateChooserComboNgayHenTra.getText());
            for (int i = 0; i < chiTietPhieuMuonns.size(); i++) {
                if (chiTietPhieuMuonns.get(i).getMaGT() == a.getMaGT()) {
                    throw new Exception("Đã mượn giáo trình này rồi");
                }
            }
            chiTietPhieuMuonns.add(a);
            LoadBang();
            jButtonXacNhan.setEnabled(true);
            jButtonXoa.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jButtonTao, e.getMessage(), "Không thể cho mượn giáo trình", HEIGHT);
        }
    }//GEN-LAST:event_jButtonTaoActionPerformed

    private void jButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaActionPerformed
        // TODO add your handling code here:
        try {
            int index = jTableThongTinMuonTra.getSelectedRow();
            if (chiTietPhieuMuonns.size() == 1) {
                //                chiTietPhieuMuonBLL.deleteChiTietPhieuMuon(chiTietPhieuMuonns.get(index).getSoPhieuMuon(), chiTietPhieuMuonns.get(index).getMaGT());
                //                PhieuMuonBLL.deletePhieuMuon(chiTietPhieuMuonns.get(index).getSoPhieuMuon());
                chiTietPhieuMuonns.remove(index);
                jButtonXoa.setEnabled(false);
                jButtonXacNhan.setEnabled(false);
                ThemPM = 0;
            } else {
                //                chiTietPhieuMuonBLL.deleteChiTietPhieuMuon(chiTietPhieuMuonns.get(index).getSoPhieuMuon(), chiTietPhieuMuonns.get(index).getMaGT());
                chiTietPhieuMuonns.remove(index);
                jButtonXoa.setEnabled(true);
                jButtonXacNhan.setEnabled(true);
            }
            LoadBang();
        } catch (Exception ex) {
            Logger.getLogger(PanelDangKyMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonXoaActionPerformed

    private void LoadBang() throws Exception {
        try {
            jTableThongTinMuonTra.removeAll();
            String[] tieuDe = {"STT", "Tên giáo trình", "Ngày mượn", "Ngày trả"};
            DefaultTableModel model = new DefaultTableModel(tieuDe, 0);
            int i = 1;
            for (DTOChiTietPhieuMuon a : chiTietPhieuMuonns) {
                Vector vt = new Vector();
                vt.add(String.valueOf(i));
                ResultSet rsGiaoTrinhBLL = giaoTrinhBLL.getGiaoTrinhByID(a.getMaGT());
                rsGiaoTrinhBLL.next();
                vt.add(rsGiaoTrinhBLL.getString("TenGT"));
                vt.add(a.getNgayMuon());
                vt.add(a.getNgayTra());
                model.addRow(vt);
                i++;
            }
            jTableThongTinMuonTra.setModel(model);
        } catch (SQLException e) {
        }
    }

    private void LoadData() {
        try {
//            chiTietHoaDons.clear();
//            rsChiTietHoaDon = chiTietHoaDonBLL.ShowChiTietHoaDon();
//            while(rsChiTietHoaDon.next()){
//                DTOChiTietHoaDon a = new DTOChiTietHoaDon();
//                a.setSoHD(Integer.parseInt(rsChiTietHoaDon.getString("SoHoaDon")));
//                a.setMaGT(Integer.parseInt(rsChiTietHoaDon.getString("MaGT")));
//                a.setSoLuongBan(Integer.parseInt(rsChiTietHoaDon.getString("SoLuongBan")));
//                a.setNgayBan(rsChiTietHoaDon.getString("NgayBan"));
//                chiTietHoaDons.add(a);
//            }
            LoadBang();

            jComboBoxLoaiGT.removeAllItems();
            danhMucs.clear();
            rsDanhMuc = danhMucBLL.ShowDanhMuc();
            while (rsDanhMuc.next()) {
                DTODanhMuc a = new DTODanhMuc();
                a.setMaDanhMuc(Integer.parseInt(rsDanhMuc.getString("MaDanhMuc")));
                a.setTenDanhMuc(rsDanhMuc.getString("TenDanhMuc"));
                jComboBoxLoaiGT.addItem(a.getTenDanhMuc());
                danhMucs.add(a);
            }
        } catch (SQLException e) {
        } catch (Exception ex) {
            Logger.getLogger(PanelQuanLyTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private datechooser.beans.DateChooserCombo dateChooserComboNgayHenTra;
    private javax.swing.JButton jButtonKiemTra;
    private javax.swing.JButton jButtonTao;
    private javax.swing.JButton jButtonXacNhan;
    private javax.swing.JButton jButtonXoa;
    private javax.swing.JComboBox<String> jComboBoxLoaiGT;
    private javax.swing.JComboBox<String> jComboBoxTenGT;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButtonNam;
    private javax.swing.JRadioButton jRadioButtonNu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableThongTinMuonTra;
    private javax.swing.JTextField jTextFieldDiaChi;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldMaSV;
    private javax.swing.JTextField jTextFieldTenSV;
    // End of variables declaration//GEN-END:variables
}