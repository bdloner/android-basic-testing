package cc.somkiat.basicunittesting.rule;

import cc.somkiat.basicunittesting.model.UserInfo;

public interface Rule {
    boolean validate(UserInfo user) throws Exception;
}
