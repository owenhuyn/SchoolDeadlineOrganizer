package com.example.owenhuyn.schooldeadlineorganizer;

import java.util.*;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.*;

public class CustomCourseListAdapter extends ArrayAdapter<course> {
    private ArrayList<course> _contactList;
    private Context _context;
    private static LayoutInflater inflater=null;
    private View view;

    public CustomCourseListAdapter(Context context, ArrayList<course> d) {

        super(context, R.layout.customcirclecell, d);
        /********** Take passed values **********/
        _context = context;
        _contactList = d;

        /***********  Layout inflator to call external xml layout () ***********/
    }

    @Override
    public int getCount()
    {
        // return the number of records in cursor
        return _contactList.size();
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // if the view is null, create one

        courseHolder holder;

        if (convertView == null) {
            holder = new courseHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.customcirclecell, parent, false);

            holder.circlePicture = (TextView)convertView.findViewById(R.id.avatar_imageview);
            holder.heading = (TextView)convertView.findViewById(R.id.title_textview);

            convertView.setTag(holder);
        } else {
            holder = (courseHolder) convertView.getTag();
        }

        // set text here
        holder.circlePicture.setText(Character.toString(_contactList.get(position).name.charAt(0)));
        holder.heading.setText(_contactList.get(position).name + " | " + _contactList.get(position).courseCode);
        //holder.testSubheading.setText();


        return convertView;
    }
}

class courseHolder {
    public TextView circlePicture;
    public TextView heading;
    public TextView assignmentSubheading;
    public TextView testSubheading;
    public RelativeLayout contentHolder;
}