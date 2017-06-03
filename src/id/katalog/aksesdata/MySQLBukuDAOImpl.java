package id.katalog.aksesdata;

import id.katalog.entity.Buku;
import id.katalog.entity.Kategori;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author panji
 */
public class MySQLBukuDAOImpl implements BukuDAO {

    private Koneksi koneksi;

    public MySQLBukuDAOImpl() {
        koneksi = new Koneksi("root", "", "jdbc:mysql://localhost:3306/pbo", "com.mysql.jdbc.Driver");
    }
    
    /**
     * Method untuk mendapatkan kode buku berdasarkan kode buku.
     * @param kodeBuku - kode buku yang ingin dicari
     * @return - objek buku
     * @throws Exception 
     */
    @Override
    public Buku getBukuByKodeBuku(String kodeBuku) throws Exception{
        Buku buku = new Buku();
        Kategori kategori = new Kategori();
        
        PreparedStatement ps;
        
        String query = "SELECT judul_buku, kode_buku, buku.kategori_id, nama_kategori\n"
                + "FROM buku INNER JOIN kategori\n"
                + "ON buku.kategori_id=kategori.kategori_id\n"
                + "WHERE kode_buku =?";
        ps = koneksi.getKoneksi().prepareStatement(query);
        ps.setString(1, kodeBuku);
        ps.executeQuery();
        ResultSet result = ps.executeQuery();
        
        while(result.next()) {
        buku.setKodeBuku(result.getString("kode_buku"));
        buku.setJudulBuku(result.getString("judul_buku"));
        kategori.setKategoriId(result.getInt(3));
        kategori.setNamaKategori(result.getString("nama_kategori"));
        buku.setKategori(kategori);
        }
        return buku;
    }

    /**
     * Method untuk menghapus data buku.
     * @param buku - objek buku
     * @throws SQLException
     * @throws Exception 
     */
    @Override
    public void deleteBuku(Buku buku) throws SQLException, Exception {
        String query = "DELETE FROM buku WHERE judul_buku = ? AND kode_buku = ?";
        try{
            PreparedStatement ps = koneksi.getKoneksi().prepareStatement(query);
            ps.setString(1, buku.getJudulBuku());
            ps.setString(2, buku.getKodeBuku());
            ps.executeUpdate();
        }finally{
            koneksi.tutupKoneksi();
        }
    }
    
    /**
     * Method untuk menyimpan data buku
     * @param buku - data buku yang akan disimpan (dalam objek buku).
     * @throws SQLException
     * @throws Exception 
     */
    @Override
    public void saveBuku(Buku buku) throws SQLException, Exception {
        String query = "INSERT INTO buku(kode_buku,judul_buku,kategori_id) VALUES (?,?,?)";
        try{
            PreparedStatement ps = koneksi.getKoneksi().prepareStatement(query);
            ps.setString(1, buku.getKodeBuku());
            ps.setString(2, buku.getJudulBuku());
            ps.setInt(3, buku.getKategori().getKategoriId());
            ps.executeUpdate();
        }finally{
            koneksi.tutupKoneksi();
        }
    }

    @Override
    public void updateBuku(Buku buku) throws Exception {
        String query = "UPDATE buku SET judul_buku = ?, kode_buku = ?, kategori_id=?";
        try{
            PreparedStatement ps = koneksi.getKoneksi().prepareStatement(query);
            ps.setString(1, buku.getJudulBuku());
            ps.setString(2, buku.getKodeBuku());
            ps.setInt(3, buku.getKategori().getKategoriId());
            ps.executeUpdate();
        }finally{
            koneksi.tutupKoneksi();
        }
    }
    
    //Tulis implementasi dari kode untuk pencarian buku.

    @Override
    public List<Buku> cariBuku(String judulbuku) throws Exception {
        List<Buku> listBuku = new ArrayList<>();
        PreparedStatement ps;
        
        String query = "select kode_buku, judul_buku, buku.kategori_id, nama_kategori\n"
                + "from buku inner join kategori\n"
                + "ON buku.kategori_id=kategori.kategori_id\n"
                + "WHERE judul_buku LIKE ?";
        ps = koneksi.getKoneksi().prepareStatement(query);
        ps.setString(1, judulbuku);
        ResultSet result = ps.executeQuery();
        
        //menampilkan hasil
        while(result.next()){
            Buku buku = new Buku();
            Kategori kategori = new Kategori();
            buku.setKodeBuku(result.getString(1));
            buku.setJudulBuku(result.getString(2));
            kategori.setKategoriId(result.getInt(3));
            kategori.setNamaKategori(result.getString(4));
            buku.setKategori(kategori);
            listBuku.add(buku);
            
        }
        return listBuku;
        
    }
}
