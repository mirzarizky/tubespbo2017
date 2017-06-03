package id.katalog.main;

import id.katalog.aksesdata.BukuDAO;
import id.katalog.aksesdata.KategoriDAO;
import id.katalog.aksesdata.MySQLBukuDAOImpl;
import id.katalog.aksesdata.MySQLKategoriDAOImpl;
import id.katalog.entity.Buku;
import id.katalog.entity.Kategori;
import java.util.List;

/**
 *
 * @author panji
 */
public class ProgramTest {
    public static void main(String[] args) throws Exception{
        //KATEGORI
        KategoriDAO kategoriDAO = new MySQLKategoriDAOImpl();
        Kategori kategori1 = new Kategori();
        kategori1.setKategoriId(11); 
        kategori1.setNamaKategori("Ilmu Komputer");
        kategoriDAO.saveKategori(kategori1); //sudah
        kategori1.setNamaKategori("Software Engineering");
        kategoriDAO.updateKategori(kategori1); //soal 1 sudah
        System.out.println("Total Data Kategori : "+kategoriDAO.getAllKategori().size()); //soal 2 sudah
        
        //BUKU
        BukuDAO bukuDAO = new MySQLBukuDAOImpl();
        Buku buku = new Buku();
        buku.setKodeBuku("542.I");
        buku.setJudulBuku("Belajar Android Cuma 7 Hari!");
        buku.setKategori(kategori1);
        bukuDAO.saveBuku(buku); //sudah
        buku.setJudulBuku("Java 7 for Weenies");
        bukuDAO.updateBuku(buku); //soal 3 sudah
        Buku bukuRetrieved = bukuDAO.getBukuByKodeBuku("542.I"); //soal 4 sudaah
        System.out.println("Buku yang didapat : " +bukuRetrieved.getJudulBuku()+"\nKategori : "+bukuRetrieved.getKategori().getNamaKategori());
        bukuDAO.deleteBuku(buku); //soal 5 sudah
        kategoriDAO.deleteKategori(kategori1); //soal 6 sudah
        
        

    }
}
