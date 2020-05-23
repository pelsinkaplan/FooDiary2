package com.example.foodiary.Panel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.foodiary.Controller.MainManager;
import com.example.foodiary.R;

public class EditProfilePanel extends MainManager {
    private Button saveButton;
    private Button backButton;
    private EditText nameEdit;
    private EditText surnameEdit;
    private EditText oldPasswordEdit;
    private EditText newPasswordEdit;
    private TextView email;
    private String name;
    private String surname;
    private String oldPassword;
    private String newPassword;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);
        saveButton = (Button) findViewById(R.id.save);
        nameEdit = (EditText) findViewById(R.id.namePro);
        surnameEdit = (EditText) findViewById(R.id.surnamePro);
        oldPasswordEdit = (EditText) findViewById(R.id.oldPassword);
        newPasswordEdit = (EditText) findViewById(R.id.newPassword);
        backButton = (Button) findViewById(R.id.back);

        email = (TextView) findViewById(R.id.emailPro);
        email.setText(MainManager.getInstance().getCurrentUserEmail());

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameEdit.getText().toString();
                surname = surnameEdit.getText().toString();
                oldPassword = oldPasswordEdit.getText().toString();
                newPassword = newPasswordEdit.getText().toString();

                int counter = 0;
                //name check if there is an error then print error message
                if (MainManager.getInstance().controlNameRegister(name).length() == 0) {
                    counter++;
                    MainManager.getInstance().setCurrentUserName(name);
                } else {
                    nameEdit.setError(MainManager.getInstance().controlNameRegister(name));
                }
                //surname check if there is an error then print error message
                if (MainManager.getInstance().controlSurnameRegister(surname).length() == 0) {
                    counter++;
                    MainManager.getInstance().setCurrentUserSurname(surname);
                } else {
                    surnameEdit.setError(MainManager.getInstance().controlSurnameRegister(surname));
                }
                //old password check if there is an error then print error message
                if (MainManager.getInstance().controlPasswordRegister(oldPassword).length() == 0) {
                    if (oldPassword.equals(MainManager.getInstance().getCurrentUserPassword()))
                        counter++;
                    else
                        oldPasswordEdit.setError(MainManager.getInstance().controlOldPasswordRegister(oldPassword));
                } else {
                    oldPasswordEdit.setError(MainManager.getInstance().controlPasswordRegister(oldPassword));
                }
                //password check if there is an error then print error message
                if (MainManager.getInstance().controlPasswordRegister(newPassword).length() == 0) {
                    counter++;
                    MainManager.getInstance().setCurrentUserPassword(newPassword);
                } else {
                    newPasswordEdit.setError(MainManager.getInstance().controlPasswordRegister(newPassword));
                }
                //if there is no error then go back login page
                if (counter == 4) {
                    //tüm şartlar sağlandıysa db de değişiklik yapılır
                    changeActivity(MainManager.getInstance().openProfilePanel());
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(MainManager.getInstance().openProfilePanel());
            }
        });

    }

    public void changeActivity(Class className) {
        startActivity(new Intent(this, className));
    }
}
