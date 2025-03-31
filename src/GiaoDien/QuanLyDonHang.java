/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GiaoDien;

import Mode.DonHang;
import Services.DonHangServices;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class QuanLyDonHang extends javax.swing.JFrame {

    static String connectionUrl = "jdbc:sqlserver://26.107.57.204:1433;databaseName=DATN_PRO230;user=datn;password=123;trustServerCertificate=true";
    DefaultTableModel tblModel;

    /**
     * Creates new form SanPham
     */
    public QuanLyDonHang() {
        initComponents();
        initTable();
        loadData();
        txtTongTien.setEnabled(false);
    }

    public void initTable() {
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(new String[]{"Mã đơn hàng", "Tên nhân viên", "Tên khách hàng", "Tên sản phẩm", "Size", "Số lượng", "Ngày tạo đơn", "Hình thức", "Tổng tiển"});
        tblDH.setModel(tblModel);
    }

    public void loadData() {
        List<DonHang> dhlist = DonHangServices.getAll();
        tblModel.setNumRows(0);
        for (DonHang dh : dhlist) {
            tblModel.addRow(new Object[]{dh.getMaDH(), dh.getMaNV(), dh.getMaKH(), dh.getMaSP(), dh.getSize(), dh.getSoLuong(), dh.getNgayDatHang(), dh.getHinhThucThanhToan(), dh.getTongTien()});
        }
    }

    private void tinhTongTien() {
        String maSP = txtMaSP.getText();
        int soLuong = 0;

        try {
            soLuong = Integer.parseInt(txtSoLuong.getText());
        } catch (NumberFormatException e) {
            txtTongTien.setText(""); // Xóa nếu nhập sai
            return;
        }

        int giaSanPham = DonHangServices.getGiaSanPham(maSP);
        int tongTien = giaSanPham * soLuong;

        txtTongTien.setText(String.valueOf(tongTien)); // Hiển thị tổng tiền
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        txtMaNV = new javax.swing.JTextField();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMaDH = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cboHinhThucThanhToan = new javax.swing.JComboBox<>();
        txtNgayTaoDon = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDH = new javax.swing.JTable();
        txtTim = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cboSize = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 51));
        jLabel1.setText("Quản lý đơn hàng");

        jLabel3.setText("Mã nhân viên");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel4.setText("Ngày tạo đơn");

        txtTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienActionPerformed(evt);
            }
        });

        jLabel5.setText("Mã khách hàng");

        txtMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKHActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã đơn hàng");

        jLabel7.setText("Hình thức thanh toán");

        jLabel8.setText("Tổng tiền");

        cboHinhThucThanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Quẹt thẻ" }));

        txtNgayTaoDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayTaoDonActionPerformed(evt);
            }
        });

        tblDH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã đơn hàng", "Tên nhân viên", "Tên khách hàng", "Tên sản phẩm", "Size", "Số lượng", "Ngày tạo đơn", "Hình thức", "Tổng tiền"
            }
        ));
        tblDH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDHMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDH);

        txtTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimActionPerformed(evt);
            }
        });

        btnTim.setText("Tìm kiếm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jLabel6.setText("Mã sản phẩm");

        txtMaSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaSPKeyReleased(evt);
            }
        });

        jLabel9.setText("Size");

        cboSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "M", "L" }));
        cboSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSizeActionPerformed(evt);
            }
        });

        jLabel10.setText("Số lượng");

        txtSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoLuongKeyReleased(evt);
            }
        });

        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(401, 401, 401))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel3))
                                        .addGap(56, 56, 56)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMaDH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMaKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMaSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cboSize, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThanhToan)
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(486, 486, 486)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnThem)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSua)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnTim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel8))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel4))
                                                .addGap(48, 48, 48)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTongTien)
                                            .addComponent(txtNgayTaoDon)
                                            .addComponent(cboHinhThucThanhToan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(72, 72, 72))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(txtNgayTaoDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThem)
                        .addComponent(btnSua)
                        .addComponent(btnXoa)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTim, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimActionPerformed

    private void txtMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKHActionPerformed

    private void cboSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSizeActionPerformed

    private void txtNgayTaoDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayTaoDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayTaoDonActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        String MaDH = txtTim.getText().trim();
        if (MaDH.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã đơn hàng!");
            return;
        }
        List<DonHang> dhList = (List<DonHang>) DonHangServices.getById(MaDH);
        if (dhList != null) {
            tblModel.setNumRows(0);
            for (DonHang dh : dhList) {
                tblModel.addRow(new Object[]{dh.getMaDH(), dh.getMaNV(), dh.getMaKH(), dh.getMaSP(), dh.getSize(), dh.getSoLuong(), dh.getNgayDatHang(), dh.getHinhThucThanhToan(), dh.getTongTien()});
            }
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy nguyên liệu với mã: " + MaDH);
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if (txtMaDH.getText().isEmpty()) {
            sb.append("Vui lòng nhập Mã đơn hàng");
        }
        if (txtMaNV.getText().isEmpty()) {
            sb.append("Vui lòng nhập Mã nhân viên");
        }
        if (txtMaKH.getText().isEmpty()) {
            sb.append("Vui lòng nhập Mã khách hàng");
        }
        if (txtMaSP.getText().isEmpty()) {
            sb.append("Vui lòng nhập Mã sản phẩm");
        }
        if (txtSoLuong.getText().isEmpty()) {
            sb.append("Vui lòng nhập Mã số lượng");
        }
        if (txtNgayTaoDon.getText().isEmpty()) {
            sb.append("Vui lòng nhập Mã ngày tạo đơn");
        }
        if (txtTongTien.getText().isEmpty()) {
            sb.append("Vui lòng nhập Mã tổng tiền");
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb.toString(), "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            DonHang dh = new DonHang();
            dh.setMaDH(txtMaDH.getText());
            dh.setMaNV(txtMaNV.getText());
            dh.setMaKH(txtMaKH.getText());
            dh.setMaSP(txtMaSP.getText());
            dh.setSize((String) cboSize.getSelectedItem());
            dh.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
            dh.setNgayDatHang(txtNgayTaoDon.getText());
            dh.setHinhThucThanhToan((String) cboHinhThucThanhToan.getSelectedItem());
            dh.setTongTien(Integer.parseInt(txtTongTien.getText()));
            int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm ?", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                if (DonHangServices.Insert(dh)) {
                    loadData();
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        int row = tblDH.getSelectedRow();
        if (row > -1) {
            String maDH = (String) tblDH.getValueAt(row, 0);

            // Lấy mã nhân viên từ bảng DonHang
            String query = "SELECT MaNV FROM DonHang WHERE MaDH = ?";
            String maNV = null;

            try (Connection conn = DriverManager.getConnection(connectionUrl); PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setString(1, maDH);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    maNV = rs.getString("MaNV");
                } else {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy đơn hàng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi truy vấn: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String sql = "EXEC ThanhToanDonHang @MaDH = ?,@MaNV = ?";

            // Gọi stored procedure để thanh toán
            try (Connection conn = DriverManager.getConnection(connectionUrl); CallableStatement stmt = conn.prepareCall("{CALL ThanhToanDonHang(?, ?)}")) {

                stmt.setString(1, maDH);
                stmt.setString(2, maNV);
                stmt.execute();
                int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn thanh toán ?", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(this, "Thanh toán thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    loadData();
                }

            } catch (Exception e) {
                if (e.getMessage().contains("Đơn hàng này đã được thanh toán")) {
                    JOptionPane.showMessageDialog(this, "Đơn hàng này đã được thanh toán!", "Lỗi", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi khi thanh toán: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if (txtMaDH.getText().isEmpty()) {
            sb.append("Vui lòng nhập Mã đơn hàng");
        }
        if (txtMaNV.getText().isEmpty()) {
            sb.append("Vui lòng nhập Mã nhân viên");
        }
        if (txtMaKH.getText().isEmpty()) {
            sb.append("Vui lòng nhập Mã khách hàng");
        }
        if (txtMaSP.getText().isEmpty()) {
            sb.append("Vui lòng nhập Mã sản phẩm");
        }
        if (txtSoLuong.getText().isEmpty()) {
            sb.append("Vui lòng nhập Mã số lượng");
        }
        if (txtNgayTaoDon.getText().isEmpty()) {
            sb.append("Vui lòng nhập Mã ngày tạo đơn");
        }
        if (txtTongTien.getText().isEmpty()) {
            sb.append("Vui lòng nhập Mã tổng tiền");
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb.toString(), "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            DonHang dh = new DonHang();
            dh.setMaDH(txtMaDH.getText());
            dh.setMaNV(txtMaNV.getText());
            dh.setMaKH(txtMaKH.getText());
            dh.setMaSP(txtMaSP.getText());
            dh.setSize((String) cboSize.getSelectedItem());
            dh.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
            dh.setNgayDatHang(txtNgayTaoDon.getText());
            dh.setHinhThucThanhToan((String) cboHinhThucThanhToan.getSelectedItem());
            dh.setTongTien(Integer.parseInt(txtTongTien.getText()));
            int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa ?", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                if (DonHangServices.Update(dh)) {
                    loadData();
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if (txtMaDH.getText().isEmpty()) {
            sb.append("Vui lòng nhập Mã đơn hàng");
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb.toString(), "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            DonHang dh = new DonHang();
            dh.setMaDH(txtMaDH.getText());
            int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa ?", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                if (DonHangServices.Delete(dh)) {
                    loadData();
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblDHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDHMouseClicked
        // TODO add your handling code here:
        int row = tblDH.getSelectedRow();
        if (row > -1) {
            String ma = (String) tblDH.getValueAt(row, 0);
            DonHang dh = DonHangServices.getByName(ma);
            txtMaDH.setText(dh.getMaDH());
            txtMaNV.setText(dh.getMaNV());
            txtMaKH.setText(dh.getMaKH());
            txtMaSP.setText(dh.getMaSP());
            cboSize.setSelectedItem(dh.getSize());
            txtSoLuong.setText(String.valueOf(dh.getSoLuong()));
            txtNgayTaoDon.setText(dh.getNgayDatHang());
            cboHinhThucThanhToan.setSelectedItem(dh.getHinhThucThanhToan());
            txtTongTien.setText(String.valueOf(dh.getTongTien()));
        }
    }//GEN-LAST:event_tblDHMouseClicked

    private void txtTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienActionPerformed

    private void txtMaSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaSPKeyReleased
        // TODO add your handling code here:
        tinhTongTien();
    }//GEN-LAST:event_txtMaSPKeyReleased

    private void txtSoLuongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuongKeyReleased
        // TODO add your handling code here:
        tinhTongTien();
    }//GEN-LAST:event_txtSoLuongKeyReleased

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
            java.util.logging.Logger.getLogger(QuanLyDonHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyDonHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyDonHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyDonHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyDonHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboHinhThucThanhToan;
    private javax.swing.JComboBox<String> cboSize;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDH;
    private javax.swing.JTextField txtMaDH;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtNgayTaoDon;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
