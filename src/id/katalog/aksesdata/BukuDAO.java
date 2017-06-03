package id.katalog.aksesdata;

import id.katalog.entity.Buku;
import java.util.List;

/**
 *
 * @author panji
 */

public interface BukuDAO {
    public Buku getBukuByKodeBuku(String kodeBuku) throws Exception;
    public void deleteBuku(Buku buku) throws Exception;
    public void saveBuku(Buku buku) throws Exception;
    public void updateBuku(Buku buku) throws Exception;
    public List<Buku> cariBuku(String judulbuku) throws Exception;
    //Tulis interface untuk pencarian buku dengan return list of objek buku
}
