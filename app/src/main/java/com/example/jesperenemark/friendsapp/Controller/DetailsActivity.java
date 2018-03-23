package com.example.jesperenemark.friendsapp.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jesperenemark.friendsapp.R;


public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        setTitle("PersonDetails");
    }
}