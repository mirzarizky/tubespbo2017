package id.katalog.aksesdata;

import id.katalog.entity.Kategori;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author panji
 */
public class MySQLKategoriDAOImpl implements KategoriDAO {

    Koneksi koneksi;

    public MySQLKategoriDAOImpl() {
        koneksi = new Koneksi("root", "", "jdbc:mysql://localhost:3306/pbo", "com.mysql.jdbc.Driver");
    }
    
    /**
     * Method untuk menyimpan data kategori
     * @param kategori - objek kategori sebagai masukan
     * @throws Exception 
     */
    @Override
    public void saveKategori(Kategori kategori) throws Exception {
        String query = "INSERT INTO kategori(kategori_id,nama_kategori) VALUES (?,?)";
        try{
            PreparedStatement ps = koneksi.getKoneksi().prepareStatement(query);
            ps.setInt(1, kategori.getKategoriId());
            ps.setString(2, kategori.getNamaKategori());
            ps.executeUpdate();
        }finally{
            koneksi.tutupKoneksi();
        }
    }

    /**
     * Method untuk menghapus data kategori.
     * @param kategori - objek kategori sebagai masukan
     * @throws Exception 
     */
    @Override
    public void deleteKategori(Kategori kategori) throws Exception {
        String query = "DELETE from kategori WHERE nama_kategori = ? AND kategori_id = ?";
        try{
            PreparedStatement ps = koneksi.getKoneksi().prepareStatement(query);
            ps.setString(1, kategori.getNamaKategori());
            ps.setInt(2, kategori.getKategoriId());
            ps.executeUpdate();
        }finally{
            koneksi.tutupKoneksi();
        }
    }

    /**
     * Method untuk meng-update kategori.
     * @param kategori - kategori yang akan diupdate datanya.
     * @throws Exception 
     */
    @Override
    public void updateKategori(Kategori kategori) throws Exception {
        String query = "UPDATE kategori SET nama_kategori = ?, kategori_id = ? WHERE kategori_id = ?";
        try{
            PreparedStatement ps = koneksi.getKoneksi().prepareStatement(query);
            ps.setString(1, kategori.getNamaKategori());
            ps.setInt(2, kategori.getKategoriId());
            ps.setInt(3, kategori.getKategoriId());
            ps.executeUpdate();
        }finally{
            koneksi.tutupKoneksi();
        }
    }

    /**
     * Method untuk mendapatkan data seluruh kategori yang ada.
     * @return list of kategori
     * @throws Exception 
     */
    @Override
    public List<Kategori> getAllKategori() throws Exception {
        
        List<Kategori> listKategori = new ArrayList<>();
        PreparedStatement ps;
        
        String query = "SELECT * FROM kategori";
        ps = koneksi.getKoneksi().prepareStatement(query);
        
        ResultSet result = ps.executeQuery();
        
        //menampilkan hasil
        while(result.next()){
            Kategori kategori = new Kategori();
            kategori.setKategoriId(result.getInt(1));
            kategori.setNamaKategori(result.getString(2));
            listKategori.add(kategori);
            
        }
        return listKategori;   
    }
    

}
