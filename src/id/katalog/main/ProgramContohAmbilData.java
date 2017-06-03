package id.katalog.main;

import id.katalog.aksesdata.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author panji
 */
public class ProgramContohAmbilData {
    public static void main(String[] args) throws Exception {
        Koneksi koneksi = new Koneksi("root", "", "jdbc:mysql://localhost:3306/pbo", "com.mysql.jdbc.Driver");
        String query = "SELECT kategori_id,nama_kategori FROM kategori where nama_kategori=?";
        PreparedStatement ps = koneksi.getKoneksi().prepareStatement(query);
        ps.setString(1, "Software Engineering");
        ResultSet result = ps.executeQuery();
        //koneksi.tutupKoneksi();
        //menampilkan hasil
        while(result.next()){
            System.out.println(result.getInt("kategori_id")); //menggunakan nama kolom
            System.out.println(result.getString(2)); //akses menggunakan indeks kolom
        }
    }
}