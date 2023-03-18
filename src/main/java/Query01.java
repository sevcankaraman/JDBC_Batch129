import java.sql.*;

public class Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // driver tanımla
        Class.forName("org.postgresql.Driver");

        //databese e baglan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc","postgres","sevcan3933");

        //statement
        Statement st = con.createStatement();

        // resulset
        ResultSet veri= st.executeQuery("select * from ogrenciler");

        // dataları al
        while ( veri.next()){
            System.out.println(veri.getInt(1)
            +" "+ veri.getString(2)
            +" "+ veri. getString(3)
            +" "+ veri. getString(4));
        }

        //baglantıları kapatma
        con.close();
        st.close();
        veri.close();

    }
}
