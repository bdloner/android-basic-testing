package cc.somkiat.basicunittesting.rule;

import cc.somkiat.basicunittesting.model.UserInfo;

public class NameIsEmptyRule extends Exception implements Rule {
    public NameIsEmptyRule(String s) {
        super(s);
    }

    public NameIsEmptyRule() {

    }

    @Override
    public boolean validate(UserInfo user) throws Exception{
        if (user.getName().isEmpty()) {
            throw new NameIsEmptyRule("Name is empty");
        }
        return true;
    }
}
