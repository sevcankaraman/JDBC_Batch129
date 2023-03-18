import java.sql.*;

public class Query02 {
    public static <ResulSet> void main(String[] args) throws ClassNotFoundException, SQLException {
        // driver tanımla
        Class.forName("org.postgresql.Driver");

        //databese e baglan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc","postgres","sevcan3933");

        //statement
        Statement st = con.createStatement();

        //Soru 1 : Region id'si 1 olan "country name" degerlerini cagirin

        String sql01="select country_name from countries where region_id=1";

        //resultset

        ResultSet veri=st.executeQuery(sql01);

        while (veri.next()){
            System.out.println(veri.getString(1));
        }

        //Soru: "region_id"nin 2'den büyük olduğu "country_id" ve "country_name" değerlerini çağırın.

        String sql02="select country_name,country_id from countries where region_id>2";
        ResultSet veri2=st.executeQuery(sql02);

        while (veri2.next()){

            System.out.println(veri2.getString("country_id") + veri2.getString("country_name"));
        }


    }
}
