package com.thesavorycake.thesavory.Model;

/**
 * Created by UnixMan on 15/12/2018.
 */

public class Product {


    private int id_produk;
    private String nama_produk;
    private int harga;
    private String ket;
    private String image;

    public Product(int id_produk, String nama_produk, int harga, String ket, String image) {
            this.id_produk = id_produk;
            this.nama_produk = nama_produk;
            this.harga = harga;
            this.ket = ket;
            this.image = image;
    }

    public int getId_produk() {
        return id_produk;
    }

    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
