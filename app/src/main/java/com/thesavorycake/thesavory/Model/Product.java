package com.thesavorycake.thesavory.Model;

/**
 * Created by UnixMan on 15/12/2018.
 */

public class Product {


    private int id_produk;
    private String nama;
    private int harga;
    private String keterangan;
    private String image;

    public Product(int id_produk, String nama, int harga, String keterangan, String image) {
            this.id_produk = id_produk;
            this.nama = nama;
            this.harga = harga;
            this.keterangan = keterangan;
            this.image = image;
    }

    public int getId_produk() {
        return id_produk;
    }

    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
