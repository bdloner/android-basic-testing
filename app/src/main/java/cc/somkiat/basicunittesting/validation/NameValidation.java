package cc.somkiat.basicunittesting.validation;

import cc.somkiat.basicunittesting.model.UserInfo;
import cc.somkiat.basicunittesting.rule.NameIsEmpty;
import cc.somkiat.basicunittesting.rule.NameOnlyEnglish;

public class NameValidation {
    UserInfo userInfo;

    public NameValidation(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public boolean nameIsEmpty() throws Exception{
        NameIsEmpty nameIsEmptyRule = new NameIsEmpty();
        return nameIsEmptyRule.validate(userInfo);
    }

    public boolean nameOnlyEnglish() throws Exception{
        NameOnlyEnglish nameOnlyEnglishRule = new NameOnlyEnglish();
        return nameOnlyEnglishRule.validate(userInfo);
    }

    public boolean validation() throws Exception{
        nameIsEmpty();
        nameOnlyEnglish();
        return true;
    }
}
