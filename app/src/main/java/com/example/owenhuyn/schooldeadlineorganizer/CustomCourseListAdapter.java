package com.example.owenhuyn.schooldeadlineorganizer;

import java.util.*;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.*;

import com.google.gson.Gson;

import globalVariables.sharedVariables;

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
        final int row_selected = position;
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

        View.OnClickListener listClickEvent = new View.OnClickListener () {
            public void onClick(View v) {
                //put your desired action here
                //v.callOnClick();
                // get the active course
                sharedVariables.activeCourse = sharedVariables.courseArrayList.get(row_selected);
                Intent intent = new Intent(_context, courseDetail.class);
                _context.startActivity(intent);
            }
        };
        View.OnLongClickListener listLongClickEvent = new View.OnLongClickListener () {
            public boolean onLongClick (View v) {
                //put your desired action here
                //v.callOnClick();
                AlertDialog.Builder error = new AlertDialog.Builder(_context, 0);
                error.setTitle("Delete?");
                error.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sharedVariables.courseArrayList.remove(row_selected);
                        Gson gson = new Gson ();
                        String courseArrayString = gson.toJson(sharedVariables.courseArrayList);
                        sharedVariables.setPreferences("COURSE", "COURSE_LIST", courseArrayString);
                        courseArrayString = sharedVariables.getPreferences("COURSE", "COURSE");
                        notifyDataSetChanged();
                    }
                });
                error.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                error.show();
                return true;
            }
        };
        convertView.setOnClickListener(listClickEvent);
        convertView.setOnLongClickListener(listLongClickEvent);

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