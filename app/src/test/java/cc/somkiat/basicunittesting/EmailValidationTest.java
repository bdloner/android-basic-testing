package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.model.UserInfo;
import cc.somkiat.basicunittesting.rule.EmailIsEmpty;
import cc.somkiat.basicunittesting.rule.EmailPattern;
import cc.somkiat.basicunittesting.validation.EmailValidation;

import static junit.framework.Assert.assertTrue;

public class EmailValidationTest {

    @Test
    public void correctEmailPattern() throws Exception {
        String email = "bdloner@gmail.com";
        UserInfo userInfo = new UserInfo("" , email);
        EmailValidation emailValidation = new EmailValidation(userInfo);
        assertTrue("Invalid  Email is empty", emailValidation.isEmailPattern());
    }

    @Test
    public void emailIsAcceptable() throws Exception{
        String email = "bdloner@gmail.com";
        UserInfo userInfo = new UserInfo("" , email);
        EmailValidation emailValidation = new EmailValidation(userInfo);
        assertTrue("Invalid  Email that not Email Pattern", emailValidation.validation());
    }

    @Test
    public void emailIsNotEmpty() throws Exception{
        String email = "test123!@#";
        UserInfo userInfo = new UserInfo("" , email);
        EmailValidation emailValidation = new EmailValidation(userInfo);
        assertTrue("Invalid  Email", emailValidation.emailIsEmpty());
    }

    @Test(expected = EmailIsEmpty.class)
    public void emailIsEmpty() throws Exception{
        String email = "";
        UserInfo userInfo = new UserInfo("" , email);
        EmailValidation emailValidation = new EmailValidation(userInfo);
        emailValidation.emailIsEmpty();
    }

    @Test(expected = EmailPattern.class)
    public void emailWithOutAtSymbol() throws Exception {
        String email = "bdloner.com";
        UserInfo userInfo = new UserInfo("" , email);
        EmailValidation emailValidation = new EmailValidation(userInfo);
        emailValidation.isEmailPattern();
    }

    @Test(expected = EmailPattern.class)
    public void emailIsString() throws Exception {
        String email = "bdlonergmailcom";
        UserInfo userInfo = new UserInfo("" , email);
        EmailValidation emailValidation = new EmailValidation(userInfo);
        emailValidation.isEmailPattern();
    }

    @Test(expected = EmailIsEmpty.class)
    public void emailIsNotAcceptableByEmpty() throws Exception{
        String email = "";
        UserInfo userInfo = new UserInfo("" , email);
        EmailValidation emailValidation = new EmailValidation(userInfo);
        assertTrue("Invalid  Email", emailValidation.validation());
    }

    @Test(expected = EmailPattern.class)
    public void emailWithOutTopDomain() throws Exception {
        String email = "bd@loner";
        UserInfo userInfo = new UserInfo("" , email);
        EmailValidation emailValidation = new EmailValidation(userInfo);
        emailValidation.isEmailPattern();
    }

    @Test(expected = EmailPattern.class)
    public void emailIsNotAcceptableByIsString() throws Exception{
        String email = "test";
        UserInfo userInfo = new UserInfo("" , email);
        EmailValidation emailValidation = new EmailValidation(userInfo);
        assertTrue("Invalid  Email", emailValidation.validation());
    }

    @Test(expected = EmailPattern.class)
    public void emailIsNotAcceptableByWithOutOnTopDomain() throws Exception{
        String email = "gmail@hotmail";
        UserInfo userInfo = new UserInfo("" , email);
        EmailValidation emailValidation = new EmailValidation(userInfo);
        assertTrue("Invalid  Email", emailValidation.validation());
    }

}
