package id.katalog.aksesdata;

/**
 *
 * @author panji
 */
import java.sql.*;

public class Koneksi {

    private String dbUser;
    private String dbPass;
    private String url;
    private String driver;
    private Connection con;
    private PreparedStatement ps;

    public Koneksi(String dbUser, String dbPass, String url, String driver) {
        this.dbUser = dbUser;
        this.dbPass = dbPass;
        this.url = url;
        this.driver = driver;
    }

    //buat koneksi
    public Connection getKoneksi() throws Exception {
        Class.forName(this.driver);
        this.con = DriverManager.getConnection(this.url, this.dbUser, this.dbPass);
        return con;
    }

    //melakukan query langsung tanpa prepared statement untuk selain SELECT (tidak ada hasil)
    public void executeUpdate(String query) throws SQLException, Exception {
        this.getKoneksi().createStatement().executeUpdate(query);
    }

    //melakukan query langsung untuk SELECT
    public ResultSet executeQuery(String query) throws SQLException, Exception {
        return this.getKoneksi().createStatement().executeQuery(query);
    }

    public void tutupKoneksi() throws Exception {
        this.con.close();
    }

}
