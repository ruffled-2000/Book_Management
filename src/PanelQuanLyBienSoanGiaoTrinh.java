
import BLL.BLLDanhMuc;
import BLL.BLLGiaoTrinh;
import BLL.BLLNhaXuatBan;
import DTO.DTODanhMuc;
import DTO.DTOGiaoTrinh;
import DTO.DTONhaXuatBan;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
public class PanelQuanLyBienSoanGiaoTrinh extends javax.swing.JPanel {

    /**
     * Creates new form PanelQuanLyGiaoTrinh
     */
    public static ResultSet rsGiaoTrinh = null;
    public static ResultSet rsDanhMuc = null;
    public static ResultSet rsNhaXuatBan = null;
    public BLL.BLLGiaoTrinh giaoTrinh = new BLLGiaoTrinh();
    public BLL.BLLNhaXuatBan nhaXuatBan = new BLLNhaXuatBan();
    public BLL.BLLDanhMuc danhMuc = new BLLDanhMuc();
    public ArrayList<DTO.DTOGiaoTrinh> giaoTrinhs = new ArrayList<DTOGiaoTrinh>();
    public ArrayList<DTO.DTODanhMuc> danhMucs = new ArrayList<DTODanhMuc>();
    public ArrayList<DTO.DTONhaXuatBan> nhaXuatBans = new ArrayList<DTONhaXuatBan>();

    public PanelQuanLyBienSoanGiaoTrinh() {
        initComponents();
        LoadData();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateChooserComboNamXB.setDateFormat(dateFormat);
    }

    private void LoadBang() throws Exception {
        try {
            jTableThongTinSach.removeAll();
            String[] tieuDe = {"STT", "Tên giáo trình", "Tác giả", "Nhà xuất bản", "Danh mục", "Năm xuất bản", "Lần xuất bản", "Số lượng", "Giá bán"};
            DefaultTableModel model = new DefaultTableModel(tieuDe, 0);
            int i = 1;
            for (DTOGiaoTrinh a : giaoTrinhs) {
                Vector vt = new Vector();
                vt.add(String.valueOf(i));
                vt.add(a.getTenGT());
                vt.add(a.getTacGia());
                ResultSet rsNhaXuatBan = nhaXuatBan.getTenNhaXuatBan(a.getMaNXB());
                rsNhaXuatBan.next();
                vt.add(rsNhaXuatBan.getString("TenNXB"));
                ResultSet rsDanhMuc = danhMuc.getTenDanhMuc(a.getMaDanhMuc());
                rsDanhMuc.next();
                vt.add(rsDanhMuc.getString("TenDanhMuc"));
                vt.add(a.getNamXB());
                vt.add(String.valueOf(a.getLanXB()));
                vt.add(String.valueOf(a.getSoLuong()));
                vt.add(String.valueOf(a.getGiaBan()));
                model.addRow(vt);
                i++;
            }
            jTableThongTinSach.setModel(model);
        } catch (SQLException e) {
        }

//            jTableThongTinSach.removeAll();
//            String []tieuDe ={"STT", "Tên giáo trình", "Tác giả", "Nhà xuất bản", "Danh mục", "Năm xuất bản", "Lần xuất bản", "Số lượng"};
//            DefaultTableModel model = new DefaultTableModel(tieuDe, 0);
//            jTableThongTinSach.setModel(model);
    }

    private void LoadData() {
        try {
            giaoTrinhs.clear();
            rsGiaoTrinh = giaoTrinh.ShowGiaoTrinh();
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
                a.setGiaBan(Integer.parseInt(rsGiaoTrinh.getString("giaBan")));
                giaoTrinhs.add(a);
            }
            LoadBang();

            jComboBoxDanhMuc.removeAllItems();
            danhMucs.clear();
            rsDanhMuc = danhMuc.ShowDanhMuc();
            while (rsDanhMuc.next()) {
                DTODanhMuc a = new DTODanhMuc();
                a.setMaDanhMuc(Integer.parseInt(rsDanhMuc.getString("MaDanhMuc")));
                a.setTenDanhMuc(rsDanhMuc.getString("TenDanhMuc"));
                jComboBoxDanhMuc.addItem(a.getTenDanhMuc());
                danhMucs.add(a);
            }

            jComboBoxNhaXuatBan.removeAllItems();
            nhaXuatBans.clear();
            rsNhaXuatBan = nhaXuatBan.ShowNhaXuatBan();
            while (rsNhaXuatBan.next()) {
                DTONhaXuatBan a = new DTONhaXuatBan();
                a.setMaNXB(Integer.parseInt(rsNhaXuatBan.getString("MaNXB")));
                a.setTenNXB(rsNhaXuatBan.getString("TenNXB"));
                a.setDiaChi(rsNhaXuatBan.getString("DiaChi"));
                a.setSoDT(rsNhaXuatBan.getString("SoDT"));
                jComboBoxNhaXuatBan.addItem(a.getTenNXB());
                nhaXuatBans.add(a);

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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableThongTinSach = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldTenGT = new javax.swing.JTextField();
        jTextFieldTacGia = new javax.swing.JTextField();
        jComboBoxNhaXuatBan = new javax.swing.JComboBox<>();
        jTextFieldLanXB = new javax.swing.JTextField();
        jTextFieldSoLuong = new javax.swing.JTextField();
        dateChooserComboNamXB = new datechooser.beans.DateChooserCombo();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxDanhMuc = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldGiaBan = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonThem = new javax.swing.JButton();
        jButtonSua = new javax.swing.JButton();
        jButtonXoa = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jTextFieldTimKiem = new javax.swing.JTextField();
        jComboBoxTimKiemTheo = new javax.swing.JComboBox<>();
        jButtonTimKiem = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(85, 65, 118));
        setForeground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1072, 482));

        jTableThongTinSach.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTableThongTinSach.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableThongTinSach.setFocusable(false);
        jTableThongTinSach.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTableThongTinSach.setRowHeight(25);
        jTableThongTinSach.setSelectionBackground(new java.awt.Color(51, 102, 255));
        jTableThongTinSach.setShowVerticalLines(false);
        jTableThongTinSach.getTableHeader().setReorderingAllowed(false);
        jTableThongTinSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableThongTinSachMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableThongTinSach);

        jPanel1.setBackground(new java.awt.Color(85, 65, 118));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Lần xuất bản:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Số lượng:");

        jTextFieldTenGT.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jTextFieldTacGia.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jComboBoxNhaXuatBan.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jTextFieldLanXB.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextFieldLanXB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldLanXBKeyPressed(evt);
            }
        });

        jTextFieldSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextFieldSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldSoLuongKeyPressed(evt);
            }
        });

        dateChooserComboNamXB.setCalendarPreferredSize(new java.awt.Dimension(350, 300));
        dateChooserComboNamXB.setWeekStyle(datechooser.view.WeekDaysStyle.FULL);
        try {
            dateChooserComboNamXB.setDefaultPeriods(new datechooser.model.multiple.PeriodSet(new datechooser.model.multiple.Period(new java.util.GregorianCalendar(2021, 4, 29),
                new java.util.GregorianCalendar(2021, 4, 29))));
    } catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
        e1.printStackTrace();
    }

    jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(255, 255, 255));
    jLabel4.setText("Danh mục:");

    jComboBoxDanhMuc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

    jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(255, 255, 255));
    jLabel8.setText("Giá bán:");

    jTextFieldGiaBan.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
    jTextFieldGiaBan.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            jTextFieldGiaBanKeyPressed(evt);
        }
    });

    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 255, 255));
    jLabel1.setText("Tên giáo trình:");

    jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(255, 255, 255));
    jLabel2.setText("Tác giả:");

    jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(255, 255, 255));
    jLabel3.setText("Nhà xuất bản:");

    jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(255, 255, 255));
    jLabel5.setText("Ngày biên soạn:");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(30, 30, 30)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel2)
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(jLabel4)
                        .addComponent(jLabel8))
                    .addGap(24, 24, 24)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldTacGia)
                        .addComponent(jTextFieldTenGT)
                        .addComponent(jComboBoxNhaXuatBan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxDanhMuc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                        .addComponent(dateChooserComboNamXB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldLanXB)
                        .addComponent(jTextFieldSoLuong))))
            .addContainerGap(30, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jTextFieldTenGT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(15, 15, 15)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTextFieldTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jComboBoxNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jComboBoxDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5)
                        .addComponent(dateChooserComboNamXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jTextFieldLanXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jTextFieldSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGap(15, 15, 15)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel8)
                .addComponent(jTextFieldGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(22, Short.MAX_VALUE))
    );

    jPanel2.setBackground(new java.awt.Color(153, 153, 255));

    jButtonThem.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
    jButtonThem.setText("Thêm");
    jButtonThem.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonThemActionPerformed(evt);
        }
    });

    jButtonSua.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
    jButtonSua.setText("Sửa");
    jButtonSua.setToolTipText("");
    jButtonSua.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonSuaActionPerformed(evt);
        }
    });

    jButtonXoa.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
    jButtonXoa.setText("Xóa");
    jButtonXoa.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonXoaActionPerformed(evt);
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
    jTextFieldTimKiem.setText("Tìm kiếm");
    jTextFieldTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTextFieldTimKiemMouseClicked(evt);
        }
    });

    jComboBoxTimKiemTheo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
    jComboBoxTimKiemTheo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã", "Tên", "Tác giả" }));

    jButtonTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-search-20.png"))); // NOI18N
    jButtonTimKiem.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonTimKiemActionPerformed(evt);
        }
    });

    jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
    jLabel9.setText("Tìm kiếm theo:");

    jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
    jLabel10.setText("CÁC CHỨC NĂNG");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap(87, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(36, 36, 36)
                            .addComponent(jComboBoxTimKiemTheo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextFieldTimKiem))
                    .addGap(18, 18, 18)
                    .addComponent(jButtonTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButtonXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonThem))
                            .addGap(40, 40, 40)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButtonSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGap(97, 97, 97))))
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel10)
            .addGap(29, 29, 29)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jButtonTimKiem)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonSua)
                        .addComponent(jButtonThem))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonReset)
                        .addComponent(jButtonXoa))
                    .addGap(37, 37, 37)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxTimKiemTheo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addGap(18, 18, 18)
                    .addComponent(jTextFieldTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(74, 74, 74))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
            .addContainerGap())
        .addGroup(layout.createSequentialGroup()
            .addGap(78, 78, 78)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(106, 106, 106)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(18, 18, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldTimKiemMouseClicked
        // TODO add your handling code here:
        jTextFieldTimKiem.setText("");
    }//GEN-LAST:event_jTextFieldTimKiemMouseClicked

    private void jButtonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemActionPerformed
        // TODO add your handling code here:
        try {
            if (jTextFieldTenGT.getText().equals("") || jTextFieldTacGia.getText().equals("") || jTextFieldGiaBan.getText().equals("") || jTextFieldLanXB.getText().equals("") || jTextFieldSoLuong.getText().equals("")) {
                throw new Exception("Không được để trống các trường nhập!!");
            }
            String tenGT = jTextFieldTenGT.getText();
            String tenTG = jTextFieldTacGia.getText();
            int index = jComboBoxNhaXuatBan.getSelectedIndex();
            int maNXB = nhaXuatBans.get(index).getMaNXB();
            index = jComboBoxDanhMuc.getSelectedIndex();
            int maDM = danhMucs.get(index).getMaDanhMuc();
            String namXB = dateChooserComboNamXB.getText();
//            final String OLD_FORMAT = "dd/MM/yyyy";
//            final String NEW_FORMAT = "yyyy/MM/dd";
//            String newDateString;
//            SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
//            Date d = sdf.parse(namXB);
//            sdf.applyPattern(NEW_FORMAT);
//            newDateString = sdf.format(d);
//            System.out.println(newDateString);
            System.out.println(namXB);
            int lanXB = Integer.parseInt(jTextFieldLanXB.getText());
            int soLuong = Integer.parseInt(jTextFieldSoLuong.getText());
            int giaBan = Integer.parseInt(jTextFieldGiaBan.getText());
            giaoTrinh.insertGiaoTrinh(tenGT, tenTG, maNXB, maDM, namXB, lanXB, soLuong, giaBan);

            giaoTrinhs.clear();
            rsGiaoTrinh = giaoTrinh.ShowGiaoTrinh();
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
                a.setGiaBan(Integer.parseInt(rsGiaoTrinh.getString("giaBan")));
                giaoTrinhs.add(a);
            }
            LoadBang();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(jButtonThem, ex.getMessage(), "Lỗi nhập liệu", HEIGHT);
        }

    }//GEN-LAST:event_jButtonThemActionPerformed

    private void jButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaActionPerformed
        // TODO add your handling code here:
        try {

            int index = jTableThongTinSach.getSelectedRow();
            if (index < 0) {
                throw new Exception("Vui lòng chọn giáo trình cần xóa!!");
            }
            int rsPane = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (rsPane == JOptionPane.YES_OPTION) {
                giaoTrinh.deleteGiaoTrinh(giaoTrinhs.get(index).getMaGT());
                LoadData();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jButtonXoa, e.getMessage(), "Lỗi", HEIGHT);
        }
    }//GEN-LAST:event_jButtonXoaActionPerformed

    private void jTableThongTinSachMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableThongTinSachMousePressed
        // TODO add your handling code here:
        int index = jTableThongTinSach.getSelectedRow();
        jTextFieldTenGT.setText(giaoTrinhs.get(index).getTenGT());
        jTextFieldTacGia.setText(giaoTrinhs.get(index).getTacGia());
        jTextFieldLanXB.setText(String.valueOf(giaoTrinhs.get(index).getLanXB()));
        jTextFieldSoLuong.setText(String.valueOf(giaoTrinhs.get(index).getSoLuong()));
        jTextFieldGiaBan.setText(String.valueOf(giaoTrinhs.get(index).getGiaBan()));
        for (int i = 0; i < danhMucs.size(); i++) {
            if (giaoTrinhs.get(index).getMaDanhMuc() == danhMucs.get(i).getMaDanhMuc()) {
                jComboBoxDanhMuc.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < nhaXuatBans.size(); i++) {
            if (giaoTrinhs.get(index).getMaNXB() == nhaXuatBans.get(i).getMaNXB()) {
                jComboBoxNhaXuatBan.setSelectedIndex(i);
            }
        }
        try {
            String date=giaoTrinhs.get(index).getNamXB().replace('-', '/');  
            System.out.println(date);
            final String OLD_FORMAT = "yyyy/MM/dd";
            final String NEW_FORMAT = "dd/MM/yyyy";
            String newDateString;
            SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
            Date d = sdf.parse(date);
            sdf.applyPattern(NEW_FORMAT);
            newDateString = sdf.format(d);
            
            
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
            Date date1 = sdf.parse(newDateString);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date1);
            dateChooserComboNamXB.setSelectedDate(cal);
        } catch (Exception e) {
        }
        
        
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        
//        
//        dateFormat.format(giaoTrinhs.get(index).getNamXB().replace('-', '/'));
//        dateChooserComboNamXB.setDateFormat(dateFormat);
//        System.out.println(dateFormat);
        
    }//GEN-LAST:event_jTableThongTinSachMousePressed

    private void jButtonSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuaActionPerformed
        // TODO add your handling code here:
        try {
            if (jTextFieldTenGT.getText().equals("") || jTextFieldTacGia.getText().equals("") || jTextFieldGiaBan.getText().equals("") || jTextFieldLanXB.getText().equals("") || jTextFieldSoLuong.getText().equals("")) {
                throw new Exception("Không được để trống các trường nhập!!");
            }
            int indextable = jTableThongTinSach.getSelectedRow();
            int maGT = giaoTrinhs.get(indextable).getMaGT();
            String tenGT = jTextFieldTenGT.getText();
            String tenTG = jTextFieldTacGia.getText();
            int indexNXB = jComboBoxNhaXuatBan.getSelectedIndex();
            int maNXB = nhaXuatBans.get(indexNXB).getMaNXB();
            int indexDM = jComboBoxDanhMuc.getSelectedIndex();
            int maDM = danhMucs.get(indexDM).getMaDanhMuc();
            String namSB = dateChooserComboNamXB.getText();
//            final String OLD_FORMAT = "dd/MM/yyyy";
//            final String NEW_FORMAT = "yyyy/MM/dd";
//            String newDateString;
//            SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
//            Date d = sdf.parse(namSB);
//            sdf.applyPattern(NEW_FORMAT);
//            newDateString = sdf.format(d);
//            System.out.println(newDateString);
            
            int lanXB = Integer.parseInt(jTextFieldLanXB.getText());
            int soLuong = Integer.parseInt(jTextFieldSoLuong.getText());
            int giaBan = Integer.parseInt(jTextFieldGiaBan.getText());
            giaoTrinh.updateGiaoTrinh(maGT, tenGT, tenTG, maNXB, maDM, namSB, lanXB, soLuong, giaBan);
            giaoTrinhs.clear();
            rsGiaoTrinh = giaoTrinh.ShowGiaoTrinh();
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
                a.setGiaBan(Integer.parseInt(rsGiaoTrinh.getString("giaBan")));
                giaoTrinhs.add(a);
            }
            LoadBang();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(jButtonSua, ex.getMessage(), "Lỗi nhập liệu", HEIGHT);
        }
    }//GEN-LAST:event_jButtonSuaActionPerformed

    private void jButtonTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimKiemActionPerformed
        // TODO add your handling code here:
        try {
            if (jTextFieldTimKiem.getText().equals("")) {
                throw new Exception("Vui lòng nhập thông tin tìm kiếm!!!");
            }
            if (jComboBoxTimKiemTheo.getSelectedIndex() == 0) {
                rsGiaoTrinh = giaoTrinh.getGiaoTrinhByID(Integer.parseInt(jTextFieldTimKiem.getText()));
            }
            if (jComboBoxTimKiemTheo.getSelectedIndex() == 1) {
                rsGiaoTrinh = giaoTrinh.SearchGiaoTrinhWithTenGT(jTextFieldTimKiem.getText());
            }
            if (jComboBoxTimKiemTheo.getSelectedIndex() == 2) {
                rsGiaoTrinh = giaoTrinh.SearchGiaoTrinhWithTacGia(jTextFieldTimKiem.getText());
            }
            if (rsGiaoTrinh.next() == false) {
                JOptionPane.showMessageDialog(jButtonTimKiem, "Không tìm thấy thông tin", "Không tìm thấy!!", HEIGHT);
            } else {
                giaoTrinhs.clear();
                do {
                    DTOGiaoTrinh a = new DTOGiaoTrinh();
                    a.setMaGT(Integer.parseInt(rsGiaoTrinh.getString("MaGT")));
                    a.setTenGT(rsGiaoTrinh.getString("TenGT"));
                    a.setTacGia(rsGiaoTrinh.getString("TacGia"));
                    a.setMaNXB(Integer.parseInt(rsGiaoTrinh.getString("MaNXB")));
                    a.setMaDanhMuc(Integer.parseInt(rsGiaoTrinh.getString("MaDanhMuc")));
                    a.setNamXB(rsGiaoTrinh.getString("NamXB"));
                    a.setLanXB(Integer.parseInt(rsGiaoTrinh.getString("LanXB")));
                    a.setSoLuong(Integer.parseInt(rsGiaoTrinh.getString("SoLuong")));
                    a.setGiaBan(Integer.parseInt(rsGiaoTrinh.getString("giaBan")));
                    giaoTrinhs.add(a);
                } while (rsGiaoTrinh.next());
            }
            LoadBang();
        } catch (SQLException ex) {
            Logger.getLogger(PanelQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(jButtonTimKiem, ex.getMessage(), "Lỗi nhập liệu", HEIGHT);
        }
    }//GEN-LAST:event_jButtonTimKiemActionPerformed

    private void jTextFieldLanXBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLanXBKeyPressed
        // TODO add your handling code here:
        String lanXB = jTextFieldLanXB.getText();
        int length = lanXB.length();
        char c = evt.getKeyChar();

        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {//Kiểm tra xem số nhập vào có là từ 0-9
            if (length < 2)//kiểm tra độ dài của khung nhập
            {
                jTextFieldLanXB.setEditable(true);
            } else {
                jTextFieldLanXB.setEditable(false);//Nếu >2 thì k cho nhập
            }
        } else {
            //Cho phép sử dụng phím backspace và delete
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                jTextFieldLanXB.setEditable(true);
            } else {
                jTextFieldLanXB.setEditable(false);
            }
        }
    }//GEN-LAST:event_jTextFieldLanXBKeyPressed

    private void jTextFieldSoLuongKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSoLuongKeyPressed
        // TODO add your handling code here:
        String soLuong = jTextFieldSoLuong.getText();
        int length = soLuong.length();
        char c = evt.getKeyChar();

        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {//Kiểm tra xem số nhập vào có là từ 0-9
            if (length < 5)//kiểm tra độ dài của khung nhập
            {
                jTextFieldSoLuong.setEditable(true);
            } else {
                jTextFieldSoLuong.setEditable(false);//Nếu >5 thì k cho nhập
            }
        } else {
            //Cho phép sử dụng phím backspace và delete
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                jTextFieldSoLuong.setEditable(true);
            } else {
                jTextFieldSoLuong.setEditable(false);
            }
        }
    }//GEN-LAST:event_jTextFieldSoLuongKeyPressed

    private void jTextFieldGiaBanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldGiaBanKeyPressed
        // TODO add your handling code here:
        String gia = jTextFieldGiaBan.getText();
        int length = gia.length();
        char c = evt.getKeyChar();

        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {//Kiểm tra xem số nhập vào có là từ 0-9
            if (length < 10)//kiểm tra độ dài của khung nhập
            {
                jTextFieldGiaBan.setEditable(true);
            } else {
                jTextFieldGiaBan.setEditable(false);//Nếu >10 thì k cho nhập
            }
        } else {
            //Cho phép sử dụng phím backspace và delete
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                jTextFieldGiaBan.setEditable(true);
            } else {
                jTextFieldGiaBan.setEditable(false);
            }
        }
    }//GEN-LAST:event_jTextFieldGiaBanKeyPressed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        // TODO add your handling code here:
        jTextFieldTenGT.setText("");
        jTextFieldTacGia.setText("");
        jTextFieldLanXB.setText("");
        jTextFieldSoLuong.setText("");
        jTextFieldGiaBan.setText("");
        jTextFieldTimKiem.setText("Tìm kiếm");
        jComboBoxTimKiemTheo.setSelectedIndex(0);
        LoadData();
    }//GEN-LAST:event_jButtonResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo dateChooserComboNamXB;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonSua;
    private javax.swing.JButton jButtonThem;
    private javax.swing.JButton jButtonTimKiem;
    private javax.swing.JButton jButtonXoa;
    private javax.swing.JComboBox<String> jComboBoxDanhMuc;
    private javax.swing.JComboBox<String> jComboBoxNhaXuatBan;
    private javax.swing.JComboBox<String> jComboBoxTimKiemTheo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableThongTinSach;
    private javax.swing.JTextField jTextFieldGiaBan;
    private javax.swing.JTextField jTextFieldLanXB;
    private javax.swing.JTextField jTextFieldSoLuong;
    private javax.swing.JTextField jTextFieldTacGia;
    private javax.swing.JTextField jTextFieldTenGT;
    private javax.swing.JTextField jTextFieldTimKiem;
    // End of variables declaration//GEN-END:variables
}
