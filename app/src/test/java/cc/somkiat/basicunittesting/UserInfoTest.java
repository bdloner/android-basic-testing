package cc.somkiat.basicunittesting;

import org.junit.Test;

import java.util.Date;

import cc.somkiat.basicunittesting.model.UserInfo;

import static org.junit.Assert.assertEquals;

public class UserInfoTest {

    @Test
    public void UserInfoTestConGetSetOnlyName() throws Exception {
        String name = "bdloner";
        UserInfo userInfo = new UserInfo(name);
        assertEquals("bdloner", userInfo.getName());
        userInfo.setName("Hello");
        assertEquals("Hello", userInfo.getName());
    }

    @Test
    public void UserInfoTestConGetSetOnlyNameandEmail() throws Exception {
        String name = "bdloner";
        String email = "bdloner@gmail.com";
        UserInfo userInfo = new UserInfo(name, email);
        assertEquals("bdloner", userInfo.getName());
        assertEquals("bdloner@gmail.com", userInfo.getEmail());
        userInfo.setName("Hello");
        userInfo.setEmail("bdloner@gm.com");
        assertEquals("Hello", userInfo.getName());
        assertEquals("bdloner@gm.com", userInfo.getEmail());
    }

    @Test
    public void UserInfoTestConGetSet(){
        String name = "bdloner";
        String email = "bdloner@gmail.com";
        Date date = new Date(1996, 11, 20);
        UserInfo userInfo = new UserInfo(name, date, email);
        assertEquals("bdloner", userInfo.getName());
        assertEquals("bdloner@gmail.com", userInfo.getEmail());
        assertEquals(date, userInfo.getBirthday());
        date = new Date(1996, 11, 20);
        userInfo.setName("Hello");
        userInfo.setEmail("bdloner@gm.com");
        userInfo.setBirthday(date);
        assertEquals("Hello", userInfo.getName());
        assertEquals("bdloner@gm.com", userInfo.getEmail());
        assertEquals(date, userInfo.getBirthday());
    }
}
