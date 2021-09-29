package BikeManagemntSystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {
    @Test
void insert_Test() {
    Operations db = new Operations();
    String query = "insert into registration(username,name,contact,gender,password,confirmpass)values('" +"alok" +"','" + "alok bista"+"','" + "9869167415" + "','" + "male" + "','" + 123 + "','" + 123 + "')";
    int result = db.insert(query);
    assertEquals(1, result);
}

}