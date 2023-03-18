import org.junit.Assert;
import org.junit.Test;
import utilities.JdbcUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedunaRoomTest {
    //"john_doe" tarafından oda olusturulmus mu?

    @Test
    public void roomTest01() throws SQLException {
        JdbcUtils.connectToDataBase(
                "medunna.com",
                "medunna_db",
                "medunna_user",
                "medunna_pass_987");

        Statement statement = JdbcUtils.createStatement();
        String sql01 = "select created_by from room";

        ResultSet resultSet1= statement.executeQuery(sql01);
        List<String> created_bylist = new ArrayList<>();

        while (resultSet1.next()){
            created_bylist.add(resultSet1.getString(1));

        }
        System.out.println("oda olusturanlar " + created_bylist);

        Assert.assertTrue("database de kayıt bulunamadı",created_bylist.contains("john_doe"));

    }
}
