package eetac.dsa.lab.entity;

import static org.junit.Assert.*;

/**
 * Created by Carlos on 19/04/2017.
 */
public class UserTest {
    @org.junit.Test
    public void createUserTest() {
        User u = new User(null,"xavi","xavipssw");
        assertEquals("xavi", u.getName());
        assertEquals("123", u.getPassword());
    }
}