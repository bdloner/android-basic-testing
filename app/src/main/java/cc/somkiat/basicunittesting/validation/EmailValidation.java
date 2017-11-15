package cc.somkiat.basicunittesting.validation;

import cc.somkiat.basicunittesting.model.UserInfo;
import cc.somkiat.basicunittesting.rule.EmailIsEmptyRule;
import cc.somkiat.basicunittesting.rule.EmailPatternRule;

public class EmailValidation {
    UserInfo userInfo;
    public EmailValidation(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public boolean emailIsEmpty() throws Exception{
        EmailIsEmptyRule emailIsEmptyRule = new EmailIsEmptyRule();
        return emailIsEmptyRule.validate(userInfo);
    }

    public boolean isEmailPattern() throws Exception{
        EmailPatternRule EmailPatternRule = new EmailPatternRule();
        return EmailPatternRule.validate(userInfo);
    }

    public boolean validation() throws Exception {
        emailIsEmpty();
        isEmailPattern();
        return true;
    }
}
