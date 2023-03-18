import java.sql.*;

public class Query04 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // driver tanımla
        Class.forName("org.postgresql.Driver");

        //databese e baglan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc", "postgres", "sevcan3933");

        //statement
        Statement st = con.createStatement();

        ResultSet rs=st.executeQuery("select * from ogrenciler");
        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println("Sütun sayısı "+ rsmd.getColumnCount());
        System.out.println("1. sütun ismi: "+rsmd.getColumnName(1));
        System.out.println("2. sütun ismi: "+rsmd.getColumnName(2));
        System.out.println("3. sütun ismi: "+rsmd.getColumnName(3));
        System.out.println("4. sütun ismi: "+rsmd.getColumnName(4));

        System.out.println("Tablo ismi : "+ rsmd.getTableName(2));


        System.out.println(rsmd.getColumnTypeName(1));
        System.out.println(rsmd.getColumnTypeName(2));




    }
}
