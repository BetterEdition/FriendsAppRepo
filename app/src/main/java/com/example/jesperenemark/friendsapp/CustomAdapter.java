package com.example.jesperenemark.friendsapp;

/**
 * Created by edwinsilva on 26/03/2018.
 */
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String friendList[];
    int friendIcon[];
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, String[] friendList, int[] friendImg) {
        this.context = context;
        this.friendList = friendList;
        this.friendIcon = friendImg;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return friendList.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.listview_item, null);
        TextView friend = (TextView)           view.findViewById(R.id.name);
        ImageView friendImg = (ImageView) view.findViewById(R.id.icon);
        friend.setText(friendList[i]);
        friendImg.setImageResource(friendIcon[i]);
        return view;
    }}
