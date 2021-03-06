package com.example.jesperenemark.friendsapp.Controller;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jesperenemark.friendsapp.BE.Friend;
import com.example.jesperenemark.friendsapp.DAO.AppProvider;
import com.example.jesperenemark.friendsapp.R;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    ArrayList<String> listOfFriends = new ArrayList<String>();
    ArrayAdapter<String> a;

    // reference to ListView widget
    private ListView listV;
    AppProvider appProvider;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listV = (ListView) findViewById(R.id.friend_list);
        appProvider = new AppProvider(this);

         listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Intent x = new Intent();
                 x.setClass(MainActivity.this, DetailsActivity.class);
                 x.putExtra("index", position);
                 startActivity(x);
             }
         });
}

    @Override
    protected void onStart() {
        super.onStart();
        fillList();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu_item; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    // Setting event upon click
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add) {

            Intent i = new Intent(MainActivity.this, DetailsActivity.class);
            startActivity(i);
            return true;
        }

     return super.onOptionsItemSelected(item);

    }

    public void fillList() {

            listOfFriends.clear();
            for (Friend friend : appProvider.getAll()) {
                listOfFriends.add("Fulde navn: " + friend.FirstName + " " + friend.LastName + "\n" + "Addresse: " + friend.Address);
            }

            AppProvider appProvider = new AppProvider(this);
            a = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,
                    listOfFriends);
            Log.d(TAG, "fillList: " + appProvider.getAll());
            listV.setAdapter(a);
        }


    }

