import org.testng.Assert;
import org.testng.annotations.Test;
import static utilities.DataBaseUtility.*;
import static utilities.DataBaseUtility.DatabaseUtilty.*;

public class TestNG_Test {

    @Test
    public void test01(){
        createConnection();
        String sql01 = "select * from ogrenciler";
        Assert.assertTrue(getColumnData(sql01,"ogrenci_ismi").contains("Derya Soylu"),
                "database de kayıt bulunamadı");

        closeConnection();
    }

    @Test
    public void test02(){
        createConnection();

        Assert.assertTrue(getColumnData("select * from ogrenciler",
                "okul_no").contains(118));
        closeConnection();

    }
}
