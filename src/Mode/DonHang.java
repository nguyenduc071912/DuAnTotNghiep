/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mode;

/**
 *
 * @author Admin
 */
public class DonHang {
    String MaDH,MaNV,MaKH,MaSP,Size,NgayDatHang,HinhThucThanhToan;
    int SoLuong,TongTien;

    public DonHang() {
    }

    public DonHang(String MaDH, String MaNV, String MaKH, String MaSP, String Size, String NgayDatHang, String HinhThucThanhToan, int SoLuong, int TongTien) {
        this.MaDH = MaDH;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.MaSP = MaSP;
        this.Size = Size;
        this.NgayDatHang = NgayDatHang;
        this.HinhThucThanhToan = HinhThucThanhToan;
        this.SoLuong = SoLuong;
        this.TongTien = TongTien;
    }

    public String getMaDH() {
        return MaDH;
    }

    public void setMaDH(String MaDH) {
        this.MaDH = MaDH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public String getNgayDatHang() {
        return NgayDatHang;
    }

    public void setNgayDatHang(String NgayDatHang) {
        this.NgayDatHang = NgayDatHang;
    }

    public String getHinhThucThanhToan() {
        return HinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String HinhThucThanhToan) {
        this.HinhThucThanhToan = HinhThucThanhToan;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    
    
    
}
