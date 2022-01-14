
import BLL.BLLChiTietHoaDon;
import BLL.BLLDanhMuc;
import BLL.BLLGiaoTrinh;
import BLL.BLLHoaDon;
import BLL.BLLQuanLySinhVien;
import DTO.DTOChiTietHoaDon;
import DTO.DTODanhMuc;
import DTO.DTOGiaoTrinh;
import DTO.DTOHoaDon;
import DTO.DTOSinhVien;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
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
public class PanelQuanLyBanGiaoTrinh extends javax.swing.JPanel {

    /**
     * Creates new form PanelQuanLyBanGiaoTrinh
     */
    public static ResultSet rsDanhMuc = null;
    public static ResultSet rsChiTietHoaDon = null;
    public static ResultSet rsHoaDon = null;
    public static ResultSet rsGiaoTrinh = null;
    public static ResultSet rsSinhVien = null;
    public BLL.BLLDanhMuc danhMucBLL = new BLLDanhMuc();
    public BLL.BLLChiTietHoaDon chiTietHoaDonBLL = new BLLChiTietHoaDon();
    public BLL.BLLHoaDon hoaDonBLL = new BLLHoaDon();
    public BLL.BLLGiaoTrinh giaoTrinhBLL = new BLLGiaoTrinh();
    public BLL.BLLQuanLySinhVien sinhVienBLL = new BLLQuanLySinhVien();
    public DTO.DTOSinhVien sinhVien = new DTOSinhVien();
    public ArrayList<DTO.DTODanhMuc> danhMucs = new ArrayList<DTODanhMuc>();
    public ArrayList<DTO.DTOGiaoTrinh> giaoTrinhs = new ArrayList<DTOGiaoTrinh>();
    public ArrayList<DTO.DTOChiTietHoaDon> chiTietHoaDons = new ArrayList<DTOChiTietHoaDon>();
    public DTOHoaDon hoaDon = new DTOHoaDon();

    public static int tongTien=0;

    public PanelQuanLyBanGiaoTrinh() {
        initComponents();
        LoadData();
        jTextFieldTenSV.setEnabled(false);
        jTextFieldDiaChi.setEnabled(false);
        jTextFieldEmail.setEnabled(false);
        jComboBoxLoaiGT.setEnabled(false);
        jComboBoxTenGT.setEnabled(false);
        jTextFieldSoLuong.setEnabled(false);
        jButtonDongY.setEnabled(false);
        jButtonXoa.setEnabled(false);
        jButtonThanhToan.setEnabled(false);
        jComboBoxLoaiGT.setSelectedIndex(-1);
        jComboBoxTenGT.setSelectedIndex(-1);
        jComboBoxLoaiGT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxLoaiGTItemStateChanged(evt);
            }
        });
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

    private void LoadBang() throws Exception {
        try {
            jTableThongTinHoaDon.removeAll();
            String[] tieuDe = {"STT", "Tên giáo trình", "Số lượng bán", "Giá bán", "Ngày bán", "Thành tiền"};
            DefaultTableModel model = new DefaultTableModel(tieuDe, 0);
            int i = 1;
            for (DTOChiTietHoaDon a : chiTietHoaDons) {
                Vector vt = new Vector();
                vt.add(String.valueOf(i));
                ResultSet rsGiaoTrinhBLL = giaoTrinhBLL.getGiaoTrinhByID(a.getMaGT());
                rsGiaoTrinhBLL.next();
                vt.add(rsGiaoTrinhBLL.getString("TenGT"));
                vt.add(a.getSoLuongBan());
                vt.add(rsGiaoTrinhBLL.getString("GiaBan"));
                vt.add(a.getNgayBan());
                int thanhTien = Integer.parseInt(rsGiaoTrinhBLL.getString("GiaBan")) * a.getSoLuongBan();
                vt.add(String.valueOf(thanhTien));
                model.addRow(vt);
                i++;
            }
            jTableThongTinHoaDon.setModel(model);
        } catch (SQLException e) {
        }
    }

    private void LoadData() {
        try {
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupGioiTinh = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableThongTinHoaDon = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldMaSV = new javax.swing.JTextField();
        jButtonKiemTra = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldTenSV = new javax.swing.JTextField();
        jRadioButtonNam = new javax.swing.JRadioButton();
        jRadioButtonNu = new javax.swing.JRadioButton();
        jTextFieldDiaChi = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabelThanhTien = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxLoaiGT = new javax.swing.JComboBox<String>();
        jComboBoxTenGT = new javax.swing.JComboBox<String>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldSoLuong = new javax.swing.JTextField();
        jButtonDongY = new javax.swing.JButton();
        jButtonXoa = new javax.swing.JButton();
        jButtonThanhToan = new javax.swing.JButton();

        setBackground(new java.awt.Color(85, 65, 118));

        jTableThongTinHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTableThongTinHoaDon.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableThongTinHoaDon.setFocusable(false);
        jTableThongTinHoaDon.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTableThongTinHoaDon.setRowHeight(25);
        jTableThongTinHoaDon.setSelectionBackground(new java.awt.Color(51, 102, 255));
        jTableThongTinHoaDon.setShowVerticalLines(false);
        jTableThongTinHoaDon.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableThongTinHoaDon);

        jPanel1.setBackground(new java.awt.Color(85, 65, 118));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã sinh viên:");

        jTextFieldMaSV.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jButtonKiemTra.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButtonKiemTra.setText("Kiểm tra");
        jButtonKiemTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKiemTraActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tên sinh viên:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Giới tính:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Địa chỉ:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Email:");

        jTextFieldTenSV.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        buttonGroupGioiTinh.add(jRadioButtonNam);
        jRadioButtonNam.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jRadioButtonNam.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonNam.setText("Nam");

        buttonGroupGioiTinh.add(jRadioButtonNu);
        jRadioButtonNu.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jRadioButtonNu.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonNu.setText("Nữ");

        jTextFieldDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jTextFieldEmail.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDiaChi)
                    .addComponent(jTextFieldEmail)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jRadioButtonNam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                        .addComponent(jRadioButtonNu)
                        .addGap(9, 9, 9))
                    .addComponent(jTextFieldMaSV)
                    .addComponent(jTextFieldTenSV))
                .addGap(18, 18, 18)
                .addComponent(jButtonKiemTra)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonKiemTra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextFieldMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jRadioButtonNam)
                    .addComponent(jRadioButtonNu))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Thành tiền: ");

        jLabelThanhTien.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelThanhTien.setForeground(new java.awt.Color(255, 255, 255));
        jLabelThanhTien.setText("0000");

        jPanel2.setBackground(new java.awt.Color(85, 65, 118));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Danh mục:");

        jComboBoxLoaiGT.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jComboBoxLoaiGT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxTenGT.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jComboBoxTenGT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tên giáo trình:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Số lượng:");

        jTextFieldSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextFieldSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldSoLuongKeyPressed(evt);
            }
        });

        jButtonDongY.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButtonDongY.setText("Đồng ý");
        jButtonDongY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDongYActionPerformed(evt);
            }
        });

        jButtonXoa.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButtonXoa.setText("Xóa");
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
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonDongY)
                        .addGap(42, 42, 42)
                        .addComponent(jButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxTenGT, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxLoaiGT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(50, 50, 50))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxLoaiGT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxTenGT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDongY)
                    .addComponent(jButtonXoa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonThanhToan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonThanhToan.setText("Thanh toán");
        jButtonThanhToan.setToolTipText("");
        jButtonThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelThanhTien)
                        .addGap(224, 224, 224)
                        .addComponent(jButtonThanhToan))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(147, 147, 147))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabelThanhTien)
                    .addComponent(jButtonThanhToan))
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonKiemTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKiemTraActionPerformed
        // TODO add your handling code here:
        rsSinhVien = sinhVienBLL.getThongTinSinhVien(jTextFieldMaSV.getText());
        try {
            if (rsSinhVien.next()) {

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
                jButtonDongY.setEnabled(true);
                jButtonXoa.setEnabled(true);
                jTextFieldSoLuong.setEnabled(true);
                jButtonThanhToan.setEnabled(true);
            } else {
                int rsPane = JOptionPane.showConfirmDialog(this, "Bạn có muốn tạo mới sinh viên?", "Không tồn tại sinh viên này", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (rsPane == JOptionPane.YES_OPTION) {
                    ThemSinhVien themThanhVien = new ThemSinhVien(null, true, jTextFieldMaSV.getText());
                    themThanhVien.setVisible(true);
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
                jButtonDongY.setEnabled(true);
                jButtonXoa.setEnabled(true);
                jTextFieldSoLuong.setEnabled(true);
                jButtonThanhToan.setEnabled(true);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelQuanLyBanGiaoTrinh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonKiemTraActionPerformed

    private void jButtonDongYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDongYActionPerformed
        // TODO add your handling code here:
        try {
            int indexGT = jComboBoxTenGT.getSelectedIndex();
            ResultSet testSL = giaoTrinhBLL.getGiaoTrinhByID(giaoTrinhs.get(indexGT).getMaGT());
            testSL.next();
            int slCo = Integer.parseInt(testSL.getString(8));
            if (slCo < Integer.parseInt(jTextFieldSoLuong.getText())) {
                throw new Exception("Không đủ số lượng giáo trình để bán!");
            }
            hoaDon.setMaSV(jTextFieldMaSV.getText());
            DTOChiTietHoaDon a = new DTOChiTietHoaDon();
            a.setMaGT(giaoTrinhs.get(indexGT).getMaGT());
            a.setNgayBan(java.time.LocalDate.now().toString());
            a.setSoLuongBan(Integer.parseInt(jTextFieldSoLuong.getText()));
            tongTien = tongTien + (a.getSoLuongBan()*giaoTrinhs.get(indexGT).getGiaBan());
            for (int i = 0; i < chiTietHoaDons.size(); i++) {
                if (chiTietHoaDons.get(i).getMaGT() == a.getMaGT()) {
                    chiTietHoaDons.get(i).setSoLuongBan(a.getSoLuongBan());
                }
            }
            chiTietHoaDons.add(a);
            LoadBang();
            jButtonXoa.setEnabled(true);
            jLabelThanhTien.setText(tongTien+" VNĐ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jButtonDongY, e.getMessage(), "Không thể bán", HEIGHT);
        }
    }//GEN-LAST:event_jButtonDongYActionPerformed

    private void jButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaActionPerformed
        // TODO add your handling code here:
        int index = jTableThongTinHoaDon.getSelectedRow();
        try {
            if (chiTietHoaDons.size() == 1) {
                chiTietHoaDons.remove(index);
                jButtonXoa.setEnabled(false);
            } else {
                chiTietHoaDons.remove(index);
                jButtonXoa.setEnabled(true);
            }
            LoadBang();
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jButtonXoaActionPerformed

    private void jTextFieldSoLuongKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSoLuongKeyPressed
        // TODO add your handling code here:
        String soLuong = jTextFieldSoLuong.getText();
        int length = soLuong.length();
        char c = evt.getKeyChar();

        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {//Kiểm tra xem số nhập vào có là từ 0-9
            jTextFieldSoLuong.setEditable(true);
        } else {
            //Cho phép sử dụng phím backspace và delete
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                jTextFieldSoLuong.setEditable(true);
            } else {
                jTextFieldSoLuong.setEditable(false);
            }
        }
    }//GEN-LAST:event_jTextFieldSoLuongKeyPressed

    public void reset() {
        tongTien=0;
        jLabelThanhTien.setText("0 VNĐ");
        jTextFieldMaSV.setText("");
        jTextFieldTenSV.setText("");
        jTextFieldDiaChi.setText("");
        jTextFieldEmail.setText("");
        jTextFieldSoLuong.setText("");
        jRadioButtonNam.setSelected(true);
        jButtonThanhToan.setEnabled(false);
        jButtonDongY.setEnabled(false);
        jButtonXoa.setEnabled(false);
        chiTietHoaDons.clear();
        hoaDon=new DTOHoaDon();
        try {
            jTextFieldSoLuong.setText("");
            jComboBoxLoaiGT.setSelectedIndex(-1);
            jComboBoxTenGT.setSelectedIndex(-1);
        } catch (Exception ex) {
            Logger.getLogger(PanelQuanLyBanGiaoTrinh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void jButtonThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThanhToanActionPerformed
        // TODO add your handling code here:
        try {
            if(jTextFieldSoLuong.getText().equals(""))
                throw new Exception("Hãy nhập số lượng!");
            hoaDonBLL.insertHoaDon(jTextFieldMaSV.getText());
            rsHoaDon = hoaDonBLL.LayMaHoaDonTiepTheo();
            rsHoaDon.next();
            hoaDon.setSoHoaDon(Integer.parseInt(rsHoaDon.getString(1)));
            for (int i = 0; i < chiTietHoaDons.size(); i++) {
                chiTietHoaDonBLL.insertChiTietHoaDon(hoaDon.getSoHoaDon(), chiTietHoaDons.get(i).getMaGT(), chiTietHoaDons.get(i).getSoLuongBan(), chiTietHoaDons.get(i).getNgayBan());
            }
            int rsPane = JOptionPane.showConfirmDialog(this, "Bạn có muốn xuất hóa đơn", "Thông báo!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (rsPane == JOptionPane.YES_OPTION) {
                    ChiTietBanVaMuon chiTietBanVaMuon = new ChiTietBanVaMuon(null, true, hoaDon.getSoHoaDon(), "HoaDon");
                    chiTietBanVaMuon.setVisible(true);
                }
            reset();
            LoadBang();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jButtonDongY, e.getMessage(), "Lỗi nhập liệu", HEIGHT);
        }
    }//GEN-LAST:event_jButtonThanhToanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupGioiTinh;
    private javax.swing.JButton jButtonDongY;
    private javax.swing.JButton jButtonKiemTra;
    private javax.swing.JButton jButtonThanhToan;
    private javax.swing.JButton jButtonXoa;
    private javax.swing.JComboBox<String> jComboBoxLoaiGT;
    private javax.swing.JComboBox<String> jComboBoxTenGT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelThanhTien;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButtonNam;
    private javax.swing.JRadioButton jRadioButtonNu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableThongTinHoaDon;
    private javax.swing.JTextField jTextFieldDiaChi;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldMaSV;
    private javax.swing.JTextField jTextFieldSoLuong;
    private javax.swing.JTextField jTextFieldTenSV;
    // End of variables declaration//GEN-END:variables
}
