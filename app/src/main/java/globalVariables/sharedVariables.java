package globalVariables;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;

import com.example.owenhuyn.schooldeadlineorganizer.Assignment;
import com.example.owenhuyn.schooldeadlineorganizer.course;


import java.util.ArrayList;
import java.util.prefs.Preferences;


/**
 * Created by ohuyn on 8/5/15.
 */
public class sharedVariables extends Application {

    public static Context contextOfApplication;
    public static Preferences preferences;
    public static String name;
    public static String email;
    public static ArrayList<Assignment> assignmentArrayList = new ArrayList<Assignment>();
    public static ArrayList<course> courseArrayList = new ArrayList<course>();

    public static Dialog createAlertDialog (Activity activity, String title, String message, boolean yesButton, boolean cancelButton) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(message);
        builder.setTitle(title);
        if (yesButton) {
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.dismiss();
                }
            });
        }
        if (cancelButton) {
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.dismiss();
                }
            });
        }
        // Create the AlertDialog object and return it
        return builder.create();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        contextOfApplication = getApplicationContext();
    }

    public static String getPreferences (String bundle, String name) {
        final SharedPreferences pref1 = contextOfApplication.getSharedPreferences(bundle, MODE_ENABLE_WRITE_AHEAD_LOGGING);

        String text = pref1.getString(bundle, name);
        return text;
    }

    public static void setPreferences (String bundle, String name, String content) {
        final SharedPreferences pref1 = contextOfApplication.getSharedPreferences(bundle, MODE_ENABLE_WRITE_AHEAD_LOGGING);

        SharedPreferences.Editor preferenceEditor = pref1.edit();
        preferenceEditor.putString(name, content);
        preferenceEditor.commit();
    }

    public String getName() {

        return name;
    }

    public void setName(String aName) {

        name = aName;

    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String aEmail) {

        email = aEmail;
    }

}
