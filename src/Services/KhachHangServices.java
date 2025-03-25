/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Mode.KhachHang;
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
public class KhachHangServices {
    static String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=DATN_PRO230;user=sa;password=123;trustServerCertificate=true";
    
    public static List<KhachHang> getAll(){
        String sql = "select MaKH, TenKH, YEAR(GETDATE()) - Tuoi AS Tuoi, GioiTinh,SDT from KhachHang";
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement stm = con.prepareStatement(sql)){
            List<KhachHang> khList = new ArrayList<>();
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setTuoi(rs.getInt("Tuoi"));
                kh.setGioiTinh(rs.getInt("GioiTinh"));
                kh.setSDT(rs.getInt("SDT"));
                khList.add(kh);
            }
            return khList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static KhachHang getByName(String MaKH){
        String sql = "select MaKH, TenKH,Tuoi, GioiTinh,SDT from KhachHang where MaKH = ?";
        KhachHang kh = new KhachHang();
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(1,MaKH);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                kh.setMaKH(rs.getString("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setTuoi(rs.getInt("Tuoi"));
                kh.setGioiTinh(rs.getInt("GioiTinh"));
                kh.setSDT(rs.getInt("SDT"));
            }
            return kh;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static boolean Create(KhachHang kh){
        String sql = "insert into KhachHang(MaKH,TenKH,Tuoi,GioiTinh,SDT) values(?,?,?,?,?)";
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(1,kh.getMaKH());
            stm.setString(2,kh.getTenKH());
            stm.setString(3,String.valueOf(kh.getTuoi()));
            stm.setString(4,String.valueOf(kh.getGioiTinh()));
            stm.setString(5,String.valueOf(kh.getSDT()));
            return stm.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean Update(KhachHang kh){
        String sql = "update KhachHang set TenKH = ?, Tuoi = ?, GioiTinh = ?, SDT=?  WHERE MaKH = ?";
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(5,kh.getMaKH());
            stm.setString(1,kh.getTenKH());
            stm.setString(2,String.valueOf(kh.getTuoi()));
            stm.setString(3,String.valueOf(kh.getGioiTinh()));
            stm.setString(4,String.valueOf(kh.getSDT()));
            return stm.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean Delete(KhachHang kh){
        String sql = "delete from KhachHang where MaKH=?";
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(1,kh.getMaKH());
            return stm.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
