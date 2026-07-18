package pl.mikolaj.old.rest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.mikolaj.old.rest.DatabaseClientMock;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseClientMockTest {

    DatabaseClientMock dbMock;

    @BeforeEach
    public void setUp() {
        dbMock = new DatabaseClientMock();

//        User user = new User("Piotr", 38, "yyy");
//        dbMock.addUser(user);

//        user = new User("Stefan", 34, "yyy");
//        dbMock.addUser(user);
    }


    @Test
    public void testGetUsers() {
        String expected = "[{\"id\":0,\"userName\":\"Piotr\",\"age\":38,\"name\":\"yyy\"}]";
        String usersString = dbMock.getUsers();
        System.out.println(usersString);

        assertEquals(expected, usersString);
    }
}
