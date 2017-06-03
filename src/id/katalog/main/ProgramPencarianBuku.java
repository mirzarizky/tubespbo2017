package id.katalog.main;

import id.katalog.aksesdata.BukuDAO;
import id.katalog.aksesdata.MySQLBukuDAOImpl;
import id.katalog.entity.Buku;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author panji
 */
public class ProgramPencarianBuku {
    public static void main(String[] args) throws Exception {
        
        Scanner scan = new Scanner(System.in);
        BukuDAO bukuDAO = new MySQLBukuDAOImpl();
        String keyword;
        
        System.out.println("-----Program Cari Buku-----");
        System.out.println("Masukkan kata kunci yang ingin dicari : ");
        
        keyword = scan.nextLine();
        List<Buku> nyaribuku = bukuDAO.cariBuku("%"+keyword+"%");
        
        if(nyaribuku.isEmpty()){
            System.out.println("\nMaaf, tidak ada buku yang sesuai dengan kata kunci");
        } else {
        System.out.println("\nJumlah buku yang didapat : "+nyaribuku.size()+"\n");
        for(int i = 0; i < nyaribuku.size(); i++){
            int j =i+1;
            System.out.println(j);
            nyaribuku.get(i).printInfoBuku();
        }
        }
    }
}
