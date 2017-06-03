package id.katalog.entity;

import java.util.List;

/**
 *
 * @author panji
 */
public class Kategori {
    private int kategoriId;
    private String namaKategori;
    List<Buku> bukuList;

    public List<Buku> getBukuList() {
        return bukuList;
    }

    public int getKategoriId() {
        return kategoriId;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public void setBukuList(List<Buku> bukuList) {
        this.bukuList = bukuList;
    }

    public void setKategoriId(int kategoriId) {
        this.kategoriId = kategoriId;
    }

    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }
    
    public void printInfoKategori(){
        System.out.println("Nama kategori : "+this.getNamaKategori());
        System.out.println("Kategori id : "+this.getKategoriId());
    }
    
}
