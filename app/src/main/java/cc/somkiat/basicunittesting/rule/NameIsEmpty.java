package cc.somkiat.basicunittesting.rule;

import cc.somkiat.basicunittesting.model.UserInfo;

public class NameIsEmpty extends Exception implements Rule {
    public NameIsEmpty(String s) {
        super(s);
    }

    public NameIsEmpty() {

    }

    @Override
    public boolean validate(UserInfo user) throws Exception{
        if (user.getName().isEmpty()) {
            throw new NameIsEmpty("Name is empty");
        }
        return true;
    }
}
