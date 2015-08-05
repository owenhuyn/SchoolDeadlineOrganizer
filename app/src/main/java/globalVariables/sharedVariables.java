package globalVariables;

import android.app.Application;
/**
 * Created by ohuyn on 8/5/15.
 */
public class sharedVariables extends Application {

    public static String name;
    public static String email;

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
