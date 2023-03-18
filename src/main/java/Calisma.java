import java.sql.*;

import static utilities.DataBaseUtility.DatabaseUtilty.closeConnection;
import static utilities.DataBaseUtility.DatabaseUtilty.createConnection;

public class Calisma {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        // driver tanımla
        Class.forName("org.postgresql.Driver");

        //databese e baglan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc","postgres","sevcan3933");

        //statement
        Statement st = con.createStatement();


        //String sql="create table ogretmenler (isim varchar(10),brans varchar(20),id int)";
        //st.execute(sql);

        String[] arr ={ "insert into ogretmenler values ('Sevcan','Bilgisayar',12)",
        "insert into ogretmenler values ('can','Bilgisayar',12)"};

        for (String w : arr) {
            st.addBatch(w);
        }

        st.executeBatch();

        con.close();








    }
}
