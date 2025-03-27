/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Mode.DonHang;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DonHangServices {

    static String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=DATN_PRO230;user=sa;password=123;trustServerCertificate=true";

    public static boolean Insert(DonHang dh) {
        String sql = "INSERT INTO DonHang (MaDH,MaNV, MaKH, MaSP, Size, SoLuong, NgayDatHang, HinhThucThanhToan, TongTien) VALUES (?,?,?,?,?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(connectionUrl); PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, dh.getMaDH());
            ps.setString(2, dh.getMaNV());
            ps.setString(3, dh.getMaKH());
            ps.setString(4, dh.getMaSP());
            ps.setString(5, dh.getSize());
            ps.setInt(6, dh.getSoLuong());
            ps.setString(7, dh.getNgayDatHang());
            ps.setString(8, dh.getHinhThucThanhToan());
            ps.setInt(9, dh.getTongTien());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean Update(DonHang dh){
        String sql = "update DonHang set MaNV = ?, MaKH = ?, MaSP = ?, Size = ?, SoLuong = ?, NgayDatHang = ?, HinhThucThanhToan = ?, TongTien = ?  WHERE MaDH = ?";
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(9, dh.getMaDH());
            ps.setString(1, dh.getMaNV());
            ps.setString(2, dh.getMaKH());
            ps.setString(3, dh.getMaSP());
            ps.setString(4, dh.getSize());
            ps.setInt(5, dh.getSoLuong());
            ps.setString(6, dh.getNgayDatHang());
            ps.setString(7, dh.getHinhThucThanhToan());
            ps.setInt(8, dh.getTongTien());
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<DonHang> getAll() {
        String sql = "select MaDH,HoTenNV, TenKH, TenSP, Size, SoLuong, NgayDatHang, HinhThucThanhToan, TongTien from DonHang \n"
                + "join NhanVien on NhanVien.MaNV = DonHang.MaNV\n"
                + "join KhachHang on KhachHang.MaKH = DonHang.MaKH\n"
                + "join SanPham on SanPham.MaSP = DonHang.MaSP";
        try(Connection conn = DriverManager.getConnection(connectionUrl); PreparedStatement ps = conn.prepareStatement(sql);) {
            List<DonHang> dhlist = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                DonHang dh = new DonHang();
                dh.setMaDH(rs.getString("MaDH"));
                dh.setMaNV(rs.getString("HoTenNV"));
                dh.setMaKH(rs.getString("TenKH"));
                dh.setMaSP(rs.getString("TenSP"));
                dh.setSize(rs.getString("Size"));
                dh.setSoLuong(rs.getInt("SoLuong"));
                dh.setNgayDatHang(rs.getString("NgayDatHang"));
                dh.setHinhThucThanhToan(rs.getString("HinhThucThanhToan"));
                dh.setTongTien(rs.getInt("TongTien"));
                dhlist.add(dh);
            }
            return dhlist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static DonHang getByName(String MaDH){
        String sql = "select * from DonHang where MaDH = ?";
        DonHang dh = new DonHang();
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1,MaDH);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                dh.setMaDH(rs.getString("MaDH"));
                dh.setMaNV(rs.getString("MaNV"));
                dh.setMaKH(rs.getString("MaKH"));
                dh.setMaSP(rs.getString("MaSP"));
                dh.setSize(rs.getString("Size"));
                dh.setSoLuong(rs.getInt("SoLuong"));
                dh.setNgayDatHang(rs.getString("NgayDatHang"));
                dh.setHinhThucThanhToan(rs.getString("HinhThucThanhToan"));
                dh.setTongTien(rs.getInt("TongTien"));
            }
            return dh;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<DonHang> getById(String MaDH){
        String sql = "select * from DonHang where MaDH = ?";
        DonHang dh = new DonHang();
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1,MaDH);
            List<DonHang> dhList = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                dh.setMaDH(rs.getString("MaDH"));
                dh.setMaNV(rs.getString("MaNV"));
                dh.setMaKH(rs.getString("MaKH"));
                dh.setMaSP(rs.getString("MaSP"));
                dh.setSize(rs.getString("Size"));
                dh.setSoLuong(rs.getInt("SoLuong"));
                dh.setNgayDatHang(rs.getString("NgayDatHang"));
                dh.setHinhThucThanhToan(rs.getString("HinhThucThanhToan"));
                dh.setTongTien(rs.getInt("TongTien"));
                dhList.add(dh);
            }
            return dhList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
