package cc.somkiat.basicunittesting.rule;

import cc.somkiat.basicunittesting.model.UserInfo;

public class EmailIsEmpty extends Exception implements Rule {
    public EmailIsEmpty(String s) {
        super(s);
    }

    public EmailIsEmpty() {

    }

    @Override
    public boolean validate(UserInfo user) throws Exception {
        if (user.getEmail().isEmpty()) {
            throw new EmailIsEmpty("Email is empty");
        }
        return true;
    }
}
