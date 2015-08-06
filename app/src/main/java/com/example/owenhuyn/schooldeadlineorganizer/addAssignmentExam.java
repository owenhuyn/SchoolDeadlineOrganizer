package com.example.owenhuyn.schooldeadlineorganizer;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import globalVariables.sharedVariables;

public class addAssignmentExam extends AppCompatActivity {
    private Toolbar toolbar;
    public EditText nameField;
    public EditText weightField;
    public static Button date_button;
    public static Button time_button;
    Context mContext;

    private static final int DATE_DIALOG_ID = 1;
    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_submission_dialog);
        mContext = this;


        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setHomeAsUpIndicator(R.string.SAVE);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("Add new assignment");


        nameField = (EditText) findViewById(R.id.assignment_name);
        weightField = (EditText) findViewById(R.id.assignment_weight);

        date_button = (Button) findViewById(R.id.date_button);
        date_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getSupportFragmentManager(), "datePicker");
            }
        });
        time_button = (Button) findViewById(R.id.time_button);
        time_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogFragment newFragment = new TimePickerFragment();
                newFragment.show(getSupportFragmentManager(), "timePicker");
            }
        });

        FloatingActionButton faButton = (FloatingActionButton) findViewById(R.id.fab);
        faButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(nameField.getText()) && !TextUtils.isEmpty(weightField.getText())) {
                    // do save content here

                    Assignment tempAssignment = new Assignment();
                    SimpleDateFormat tempDate = new SimpleDateFormat("dd-MMM-yyyy");

                    tempAssignment.setName(nameField.getText().toString());
                    tempAssignment.setAssignedDate(Calendar.getInstance().getTime());
                    try {
                        tempAssignment.setDueDate(tempDate.parse(date_button.getText().toString()));
                    } catch (ParseException e) {
                        System.out.println("Invalid parse on Due Date");
                    }
                    tempAssignment.setWeight(Long.parseLong(weightField.getText().toString()));
                    //tempAssignment.setWeight(weightField.getText().toString());

                    sharedVariables.assignmentArrayList.add(tempAssignment);
                    onBackPressed();
                } else {
                    sharedVariables.createAlertDialog(addAssignmentExam.this, "Error", "You need to fill out a title, date and deadline.", true, false).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add(0, 1, 0, "SAVE").setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        // getMenuInflater().inflate(R.menu.menu_add_assignment_exam, menu);
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

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker

            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            //return new DatePickerDialog(getActivity(), (EditSessionActivity)getActivity(), year, month, day);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {

            date_button.setText(String.valueOf(day) + "/"
                    + String.valueOf(month + 1) + "/" + String.valueOf(year));
            // set selected date into datepicker also


        }
    }

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute, true);
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            time_button.setText(String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
        }
    }
}
