import org.junit.Assert;
import org.junit.Test;

import static utilities.DataBaseUtility.DatabaseUtilty.*;

public class JUnit_Test {
    @Test
    public void Test01(){
        createConnection();
        String sql01="select * from ogrenciler";
        System.out.println(getColumnData(sql01, "ogrenci_ismi"));
        Assert.assertTrue("Database'de kayit bulunamadı",
                getColumnData(sql01, "ogrenci_ismi").contains("Derya Soylu"));

        Assert.assertTrue("database de kayıt bulunamadı",
                getColumnData(sql01,"ogrenci_isimi").contains("Ahmet Aslan"));
        // gecolumndata(query,"sütun_ismi")=> sutundakı bütün dataları verır.

        closeConnection();

    }

    @Test
    public void test02(){

        //118 numaralı öğrenci databaede var mı?
        createConnection();
        Assert.assertTrue("DATABASE'DE KAYIT BULUNAMADI",
                getColumnData("select * from ogrenciler", "okul_no").contains(118));
        closeConnection();
    }
}