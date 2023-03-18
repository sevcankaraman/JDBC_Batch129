import pojos.Urun;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query07 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // driver tanımla
        Class.forName("org.postgresql.Driver");

        //databese e baglan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc","postgres","sevcan3933");

        //statement
        Statement st = con.createStatement();

        // SORU: Urunler adında bir tablo olusturalım (id int, isim varchar(10), fiyat int)
        //tablo olustracagım ıcın execute komutunu kullanıyoruz.

       // st.execute("create table urunler (id int, isim varchar(10),fiyat int)");
        // cok mıktarda kayıt eklemek ıcın preparedStatment kullanılır
        // bunun harıcınde pojo class kullanarak ta bunu yapabılırz

        List<Urun> kayitlar = new ArrayList<>();
        kayitlar.add(new Urun(100,"Laptop",35000));
        kayitlar.add(new Urun(101,"Mouse",750));
        kayitlar.add(new Urun(102,"MacBookPro",95000));
        kayitlar.add(new Urun(103,"AnaKart",5000));
        kayitlar.add(new Urun(104,"Klavye",1500));
        kayitlar.add(new Urun(105,"Ipad",45000));

        PreparedStatement tablo =con.prepareStatement("insert into urunler values (?,?,?)");
        for (Urun each : kayitlar){
            tablo.setInt(1,each.getId());
            tablo.setString(2, each.getIsim());
            tablo.setDouble(3,each.getFiyat());
            tablo.addBatch();
        }
        tablo.executeBatch();

        con.close();
        st.close();
        tablo.close();








    }
}
