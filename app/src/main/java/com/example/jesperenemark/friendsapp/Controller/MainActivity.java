package com.example.jesperenemark.friendsapp.Controller;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jesperenemark.friendsapp.BE.Friend;
import com.example.jesperenemark.friendsapp.CustomAdapter;
import com.example.jesperenemark.friendsapp.DAO.AppProvider;
import com.example.jesperenemark.friendsapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    ArrayList<Friend> list;
    ArrayAdapter<Friend> adapter;

    ListView simpleList;
    String friendlist[] = {"Tim"};
    int fImg[] = {R.mipmap.ic_launcher_round};

    // reference to ListView widget
    private ListView listV;

    TextView textView;
    Button insertButton;
    EditText editText;

    AppProvider appProvider;

    /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listV = (ListView) findViewById(R.id.friend_list);

        appProvider = new AppProvider(this);
        fillList();
}
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleList = (ListView) findViewById(R.id.friend_list);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),friendlist , fImg);
        simpleList.setAdapter(customAdapter);
    }


        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent x = new Intent();
                x.setClass(MainActivity.this, DetailsActivity.class);
                x.putExtra("index", position);
                startActivity(x);
            }
        });


    // Populating main activity with menu_item
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

            Intent k = new Intent(MainActivity.this, DetailsActivity.class);
            startActivity(k);
            return true;
        }

     return super.onOptionsItemSelected(item);

    }

//
//    public void onClickInsert() {
//        String name = editText.getText().toString();
//        appProvider.addPerson(new Friend(0,name));
//        editText.setText("");
//        fillList();
//        Toast.makeText( this,"name = " + name, Toast.LENGTH_LONG).show();
//    }
/*
    public void fillList() {
        AppProvider appProvider = new AppProvider(this);

        ArrayAdapter<Friend> a =
                new ArrayAdapter<Friend>(this,
                        android.R.layout.simple_list_item_1,
                        appProvider.getAll() );
        listV.setAdapter(a);
    }

*/
}
