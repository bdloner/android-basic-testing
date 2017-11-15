package cc.somkiat.basicunittesting.rule;

import java.util.regex.Pattern;

import cc.somkiat.basicunittesting.model.UserInfo;

public class NameOnlyEnglishRule extends Exception implements Rule{
    public NameOnlyEnglishRule() {

    }

    public NameOnlyEnglishRule(String s) {
        super(s);
    }

    @Override
    public boolean validate(UserInfo user) throws Exception {
        if (!Pattern.matches("^[a-zA-Z]+$", user.getName())){
            throw new NameOnlyEnglishRule("Name Only English.");
        }
        return true;
    }
}
