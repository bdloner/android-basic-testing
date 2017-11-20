package cc.somkiat.basicunittesting.rule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cc.somkiat.basicunittesting.model.UserInfo;

public class EmailPattern extends Exception implements Rule {
    public EmailPattern(String s) {
        super(s);
    }

    public EmailPattern() {

    }

    @Override
    public boolean validate(UserInfo user) throws Exception {
        final Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(user.getEmail());
        if (!matcher.find()){
            throw new EmailPattern("not a email pattern");
        }
        return true;
    }
}
