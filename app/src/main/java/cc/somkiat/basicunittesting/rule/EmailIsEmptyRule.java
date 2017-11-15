package cc.somkiat.basicunittesting.rule;

import cc.somkiat.basicunittesting.model.UserInfo;

public class EmailIsEmptyRule extends Exception implements Rule {
    public EmailIsEmptyRule(String s) {
        super(s);
    }

    public EmailIsEmptyRule() {

    }

    @Override
    public boolean validate(UserInfo user) throws Exception {
        if (user.getEmail().isEmpty()) {
            throw new EmailIsEmptyRule("Email is empty");
        }
        return true;
    }
}
