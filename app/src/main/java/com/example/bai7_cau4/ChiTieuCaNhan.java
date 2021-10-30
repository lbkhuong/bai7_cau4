package com.example.bai7_cau4;

public class ChiTieuCaNhan {
    private String noiDungChiTieu;
    private int soTienChiTieu;

    public ChiTieuCaNhan(){}
    public ChiTieuCaNhan(String noiDungChiTieu, int soTienChiTieu){
        this.noiDungChiTieu = noiDungChiTieu;
        this.soTienChiTieu = soTienChiTieu;
    }

    public void setNoiDungChiTieu(String noiDungChiTieu) {
        this.noiDungChiTieu = noiDungChiTieu;
    }

    public String getNoiDungChiTieu() {
        return noiDungChiTieu;
    }

    public void setSoTienChiTieu(int soTienChiTieu) {
        this.soTienChiTieu = soTienChiTieu;
    }

    public int getSoTienChiTieu() {
        return soTienChiTieu;
    }
}
