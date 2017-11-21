package cc.somkiat.basicunittesting;

import android.app.Activity;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Date;

import cc.somkiat.basicunittesting.model.UserInfo;

public class MainActivity extends AppCompatActivity implements UserInfo.userInfoListener{

    private EditText name;
    private DatePicker birthday;
    private EditText email;

    public static Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.name = findViewById(R.id.userNameInput);
        this.birthday = findViewById(R.id.dateOfBirthInput);
        this.email = findViewById(R.id.emailInput);

        context = this;
    }

    public void onSaveClick(View view) throws Exception {
        UserInfo userInfo = new UserInfo(this, name.getText().toString(),
                new Date(birthday.getYear(), birthday.getMonth(), birthday.getDayOfMonth()),
                email.getText().toString());
    }

    public void onRevertClick(View view) {
        this.name.setText("");
        this.email.setText("");
    }

    @Override
    public void onShow(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error")
                .setMessage(text)
                .setPositiveButton("OK", null);
        builder.show();
    }
}
