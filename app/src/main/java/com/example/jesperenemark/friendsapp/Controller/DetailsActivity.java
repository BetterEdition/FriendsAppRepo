package com.example.jesperenemark.friendsapp.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jesperenemark.friendsapp.R;


public class DetailsActivity extends AppCompatActivity {


    Button backbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        setTitle("PersonDetails");
        backbtn = (Button) findViewById(R.id.btnBack);
        clickBack();
    }
     public void clickBack() {
         backbtn.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                finish();
             }
         });
     }
     public void saveFriend() {
        // To Be Implemented
     }


    }