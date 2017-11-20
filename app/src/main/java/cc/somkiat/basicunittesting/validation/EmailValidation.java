package cc.somkiat.basicunittesting.validation;

import cc.somkiat.basicunittesting.model.UserInfo;
import cc.somkiat.basicunittesting.rule.EmailIsEmpty;
import cc.somkiat.basicunittesting.rule.EmailPattern;

public class EmailValidation {
    UserInfo userInfo;
    public EmailValidation(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public boolean emailIsEmpty() throws Exception{
        EmailIsEmpty emailIsEmptyRule = new EmailIsEmpty();
        return emailIsEmptyRule.validate(userInfo);
    }

    public boolean isEmailPattern() throws Exception{
        EmailPattern EmailPatternRule = new EmailPattern();
        return EmailPatternRule.validate(userInfo);
    }

    public boolean validation() throws Exception {
        emailIsEmpty();
        isEmailPattern();
        return true;
    }
}
