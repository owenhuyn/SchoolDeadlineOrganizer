package com.example.owenhuyn.schooldeadlineorganizer;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {
    ArrayList<course> courseList;
    ListView courseListView;
    CustomCourseListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courseList = new ArrayList<course>();

        // set the com.example.owenhuyn.schooldeadlineorganizer.course list to the view
        courseListView = (ListView)findViewById(R.id.courselistview);
        courseList.add(new course("Biology", "BIO123"));
        courseList.add(new course("Computer Science", "COMPSCI123"));
        courseList.add(new course("Phyics", "PHYS3465"));

        adapter = new CustomCourseListAdapter (this, courseList);

        courseListView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
