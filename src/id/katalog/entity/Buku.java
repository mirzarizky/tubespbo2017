package id.katalog.entity;

/**
 *
 * @author panji
 */
public class Buku {
    private String kodeBuku;
    private String judulBuku;
    Kategori kategori;

    public String getJudulBuku() {
        return judulBuku;
    }

    public String getKodeBuku() {
        return kodeBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public void setKodeBuku(String kodeBuku) {
        this.kodeBuku = kodeBuku;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }
    
    public void printInfoBuku() {
        System.out.println("Judul buku : "+this.getJudulBuku());
        System.out.println("Kode buku : "+this.getKodeBuku());
        this.getKategori().printInfoKategori();
        System.out.println("");
        
    }
            
}
