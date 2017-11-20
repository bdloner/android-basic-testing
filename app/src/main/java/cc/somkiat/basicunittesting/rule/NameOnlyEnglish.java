package cc.somkiat.basicunittesting.rule;

import java.util.regex.Pattern;

import cc.somkiat.basicunittesting.model.UserInfo;

public class NameOnlyEnglish extends Exception implements Rule{
    public NameOnlyEnglish() {

    }

    public NameOnlyEnglish(String s) {
        super(s);
    }

    @Override
    public boolean validate(UserInfo user) throws Exception {
        if (!Pattern.matches("^[a-zA-Z]+$", user.getName())){
            throw new NameOnlyEnglish("Name Only English.");
        }
        return true;
    }
}
