package BikeManagemntSystem;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {
    @Test
void insert_Test() {
    Operations db = new Operations();
    String query = "insert into registration(username,name,contact,gender,password,confirmpass)values('" +"alok" +"','" + "alok bista"+"','" + "9869167415" + "','" + "male" + "','" + 123 + "','" + 123 + "')";
    int result = db.insert(query);
    assertEquals(1, result);
}
    @Test
    void select_Test1() throws SQLException {
        Operations db = new Operations();
        String username = "1";
        String query = "select * from registration where username='" + username + "'";
        ResultSet rs = db.select(query);
        int count = rs.getRow();
        assertEquals(0, count);
    }

    @Test
    void delete_Test() {
        Operations db = new Operations();
        String sql = "DELETE FROM bike WHERE id='" + 5 + "'";
        int rowsDeleted = db.executeDelete(sql);
        assertEquals(0, rowsDeleted);
    }



    @Test
    void update_Test() {
        String query = "update registration set name='" + 2 + "' where username='" + 2 + "'";
        Operations db = new Operations();
        int rs = db.Update(query);
        assertEquals(0, rs);
    }

    @Test
    void update_Test1() {
        String query = "update registration set name='" + 2 + "' where username='" + 2 + "'";
        Operations db = new Operations();
        int rs = db.Update(query);
        assertEquals(1, rs);
    }


}