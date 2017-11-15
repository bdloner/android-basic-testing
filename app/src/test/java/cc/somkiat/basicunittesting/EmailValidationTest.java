package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.model.UserInfo;
import cc.somkiat.basicunittesting.rule.EmailIsEmptyRule;
import cc.somkiat.basicunittesting.rule.EmailPatternRule;
import cc.somkiat.basicunittesting.validation.EmailValidation;

import static junit.framework.Assert.assertTrue;

public class EmailValidationTest {

    @Test
    public void correctEmailPattern() throws Exception {
        String email = "bdloner@gmail.com";
        UserInfo userInfo = new UserInfo("" , email);
        EmailValidation emailValidation = new EmailValidation(userInfo);
        assertTrue("`true` when it's email pattern", emailValidation.isEmailPattern());
    }

    @Test
    public void emailIsAcceptable() throws Exception{
        String email = "bdloner@gmail.com";
        UserInfo userInfo = new UserInfo("" , email);
        EmailValidation emailValidation = new EmailValidation(userInfo);
        assertTrue("`true` when it's email pattern", emailValidation.validation());
    }

    @Test
    public void emailIsNotEmpty() throws Exception{
        String email = "test123!@#";
        UserInfo userInfo = new UserInfo("" , email);
        EmailValidation emailValidation = new EmailValidation(userInfo);
        assertTrue("`true` when email is not empty", emailValidation.emailIsEmpty());
    }

    @Test(expected = EmailIsEmptyRule.class)
    public void emailIsEmpty() throws Exception{
        String email = "";
        UserInfo userInfo = new UserInfo("" , email);
        EmailValidation emailValidation = new EmailValidation(userInfo);
        emailValidation.emailIsEmpty();
    }

    @Test(expected = EmailPatternRule.class)
    public void emailWithOutAtSymbol() throws Exception {
        String email = "bdloner.com";
        UserInfo userInfo = new UserInfo("" , email);
        EmailValidation emailValidation = new EmailValidation(userInfo);
        emailValidation.isEmailPattern();
    }

    @Test(expected = EmailPatternRule.class)
    public void emailIsString() throws Exception {
        String email = "bdlonergmailcom";
        UserInfo userInfo = new UserInfo("" , email);
        EmailValidation emailValidation = new EmailValidation(userInfo);
        emailValidation.isEmailPattern();
    }

    @Test(expected = EmailIsEmptyRule.class)
    public void emailIsNotAcceptableByEmpty() throws Exception{
        String email = "";
        UserInfo userInfo = new UserInfo("" , email);
        EmailValidation emailValidation = new EmailValidation(userInfo);
        assertTrue("`true` when it's email pattern", emailValidation.validation());
    }

    @Test(expected = EmailPatternRule.class)
    public void emailWithOutTopDomain() throws Exception {
        String email = "bd@loner";
        UserInfo userInfo = new UserInfo("" , email);
        EmailValidation emailValidation = new EmailValidation(userInfo);
        emailValidation.isEmailPattern();
    }

    @Test(expected = EmailPatternRule.class)
    public void emailIsNotAcceptableByIsString() throws Exception{
        String email = "test";
        UserInfo userInfo = new UserInfo("" , email);
        EmailValidation emailValidation = new EmailValidation(userInfo);
        assertTrue("`true` when it's email pattern", emailValidation.validation());
    }

    @Test(expected = EmailPatternRule.class)
    public void emailIsNotAcceptableByWithOutOnTopDomain() throws Exception{
        String email = "gmail@hotmail";
        UserInfo userInfo = new UserInfo("" , email);
        EmailValidation emailValidation = new EmailValidation(userInfo);
        assertTrue("`true` when it's email pattern", emailValidation.validation());
    }
    @Test(expected = EmailPatternRule.class)
    public void emailIsNotAcceptableByWithOutAtSymbol() throws Exception{
        String email = "gmailhotmail.com";
        UserInfo userInfo = new UserInfo("" , email);
        EmailValidation emailValidation = new EmailValidation(userInfo);
        assertTrue("`true` when it's email pattern", emailValidation.validation());
    }
    @Test(expected = EmailPatternRule.class)
    public void emailIsNotAcceptableByWrongPosition() throws Exception{
        String email = "bdloner.hotmail@com";
        UserInfo userInfo = new UserInfo("" , email);
        EmailValidation emailValidation = new EmailValidation(userInfo);
        assertTrue("`true` when it's email pattern", emailValidation.validation());
    }
}
