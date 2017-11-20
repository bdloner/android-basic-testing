package cc.somkiat.basicunittesting.model;

import java.util.Date;

import cc.somkiat.basicunittesting.validation.EmailValidation;
import cc.somkiat.basicunittesting.validation.NameValidation;

public class UserInfo {
    public String name;
    public Date birthday;
    public String email;
    public NameValidation nameValid;
    public EmailValidation emailValid;
    private UserInfo.userInfoListener userInfoListener;

    public interface userInfoListener {
        void onShow(String text);
    }


    public UserInfo(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public UserInfo(userInfoListener userInfoListener, String name, Date birthday, String email) throws InterruptedException {
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.userInfoListener = userInfoListener;

        this.nameValid = new NameValidation(this);
        this.emailValid = new EmailValidation(this);

        try {
            nameValid.validation();
            emailValid.validation();
        } catch (Exception e) {
            userInfoListener.onShow(e.getMessage());;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public UserInfo(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserInfo(String name, Date birthday, String email) {
        this.name = name;
        this.birthday = birthday;
        this.email = email;
    }
}
