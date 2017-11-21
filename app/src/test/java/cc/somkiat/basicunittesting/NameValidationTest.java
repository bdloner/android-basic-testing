package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.model.UserInfo;
import cc.somkiat.basicunittesting.rule.NameIsEmpty;
import cc.somkiat.basicunittesting.rule.NameOnlyEnglish;
import cc.somkiat.basicunittesting.validation.NameValidation;

import static junit.framework.Assert.assertTrue;

public class NameValidationTest {

    @Test
    public void nameIsNotEmpty() throws Exception {
        String name = "bdloner1we24124";
        UserInfo userInfo = new UserInfo(name);
        NameValidation nameValidation = new NameValidation(userInfo);
        assertTrue("Name is not empty", nameValidation.nameIsEmpty());
    }

    @Test
    public void nameOnlyEnglish() throws Exception {
        String name = "bdloner";
        UserInfo userInfo = new UserInfo(name);
        NameValidation nameValidation = new NameValidation(userInfo);
        assertTrue("Name is only English", nameValidation.nameOnlyEnglish());
    }

    @Test
    public void nameIsAcceptable() throws Exception {
        String name = "bdloner";
        UserInfo userInfo = new UserInfo(name);
        NameValidation nameValidation = new NameValidation(userInfo);
        assertTrue("Name is Acceptable", nameValidation.validation());
    }

    @Test(expected = NameIsEmpty.class)
    public void nameIsEmpty() throws Exception {
        String name = "";
        UserInfo userInfo = new UserInfo(name);
        NameValidation nameValidation = new NameValidation(userInfo);
        nameValidation.nameIsEmpty();
    }

    @Test(expected = NameOnlyEnglish.class)
    public void nameHaveNumber() throws Exception {
        String name = "bdloner123";
        UserInfo userInfo = new UserInfo(name);
        NameValidation nameValidation = new NameValidation(userInfo);
        nameValidation.nameOnlyEnglish();
    }

    @Test(expected = NameIsEmpty.class)
    public void nameIsNotAcceptableByEmpty() throws Exception {
        String name = "";
        UserInfo userInfo = new UserInfo(name);
        NameValidation nameValidation = new NameValidation(userInfo);
        nameValidation.validation();
    }

    @Test(expected = NameOnlyEnglish.class)
    public void nameIsNotAcceptableByHaveNumber() throws Exception {
        String name = "wl20ew";
        UserInfo userInfo = new UserInfo(name);
        NameValidation nameValidation = new NameValidation(userInfo);
        nameValidation.validation();
    }

    @Test(expected = NameOnlyEnglish.class)
    public void nameIsNotAcceptableByHaveSymbols() throws Exception {
        String name = "bdlonersdf!@#1!@#$#";
        UserInfo userInfo = new UserInfo(name);
        NameValidation nameValidation = new NameValidation(userInfo);
        nameValidation.validation();
    }
}
