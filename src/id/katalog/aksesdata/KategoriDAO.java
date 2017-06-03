package id.katalog.aksesdata;

import id.katalog.entity.Kategori;
import java.util.List;

/**
 *
 * @author panji
 */
public interface KategoriDAO {
    public void saveKategori(Kategori kategori) throws Exception;
    public void deleteKategori(Kategori kategori) throws Exception;
    public void updateKategori(Kategori kategori) throws Exception;
    public List<Kategori> getAllKategori() throws Exception;
}
