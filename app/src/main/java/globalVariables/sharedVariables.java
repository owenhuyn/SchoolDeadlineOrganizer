package globalVariables;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.content.DialogInterface;

import com.example.owenhuyn.schooldeadlineorganizer.Assignment;

import java.util.ArrayList;


/**
 * Created by ohuyn on 8/5/15.
 */
public class sharedVariables extends Application {

    public static String name;
    public static String email;
    public static ArrayList<Assignment> assignmentArrayList = new ArrayList<Assignment>();

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
