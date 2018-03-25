package com.example.jesperenemark.friendsapp.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jesperenemark.friendsapp.BE.Friend;
import com.example.jesperenemark.friendsapp.DAO.AppProvider;
import com.example.jesperenemark.friendsapp.R;

import java.util.ArrayList;


public class DetailsActivity extends AppCompatActivity {

    Button buttonAdd;
    EditText firstNameText,lastNameText, addressText, mailText, birthDateText, phoneText;

    AppProvider appProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        setTitle("PersonDetails");
        appProvider = new AppProvider(this);
        buttonAdd = (Button) findViewById(R.id.save);
        init();

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DetailsActivity.this.onClickAdd();
            }
        });
    }

    public void init() {
        firstNameText = (EditText) findViewById(R.id.person_firstName);
        lastNameText = (EditText) findViewById(R.id.person_lastName);
        addressText = (EditText) findViewById(R.id.person_address);
        mailText = (EditText) findViewById(R.id.person_email);
        birthDateText = (EditText) findViewById(R.id.person_web);
        phoneText = (EditText) findViewById(R.id.person_phone);
    }

    public void onClickAdd() {
        String firstname = firstNameText.getText().toString();
        String lastname = lastNameText.getText().toString();
        String address = addressText.getText().toString();
        String mail = mailText.getText().toString();
        String birthdate = birthDateText.getText().toString();
        String phone = phoneText.getText().toString();

        appProvider.addPerson(new Friend(0, firstname, lastname, address, mail, phone));
        firstNameText.setText("");
        lastNameText.setText("");
        addressText.setText("");
        mailText.setText("");
        phoneText.setText("");
        Toast.makeText(this, "FirstName: " + firstname + "LastName: " + lastname + "Address: " + address + "Mail: " + mail +
                "Birthday: "  + phone, Toast.LENGTH_LONG).show();
    }



}