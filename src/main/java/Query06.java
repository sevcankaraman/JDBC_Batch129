import java.sql.*;

public class Query06 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // driver tanımla
        Class.forName("org.postgresql.Driver");

        //databese e baglan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc","postgres","sevcan3933");

        //statement
        Statement st = con.createStatement();
        //st.executeUpdate("insert into ogrenciler values(800,'Ali Can',11,'E')");

        //NOT:
        // Aynı SQL kodlarını kullancaksak statement değil preparedstatement kullanırız
        //statement kullandıgımızda her seferınde kodu database e ıletır
        //praperedeStatement kullandıgımızda ornegı saklar sadece dataları ıletır

        PreparedStatement ps=con.prepareStatement("insert into ogrenciler values(?,?,?,?)");
        ps.setInt(1,871);
        ps.setString(2,"Ali Can");
        ps.setInt(3,11);
        ps.setString(4,"E");

        ps.executeUpdate();
        ps.close();
        con.close();
    }
}
