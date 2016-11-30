package com.example.ben.greenisthenewblack;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/*
* Ben Butler
* Oct. 15, 2016
* Green is the New Black, to promote local awareness of climate change and the
* effects on wildlife.
* LoginRequest is a class in the application that handles different login attempts done by
* the user who is interacting with Green is the New Black.
* Created on Oct. 15, 2016 and revised up until Nov. 20, 2016.
* The class file is designed to interact with a .xml file, which is the visual representation
* of the activity.  While the java class file handles the manipulation of the data inputted from
* the U.I. of the application.
* The LoginRequest class handles the login information that was sent over from the LoginActivity
* class, it is designed to be called from the LoginActivity class once the user has input
* the necessary information and have clicked the login button. It expects two different inputs: the
* username and then the password, which are both passed as Strings. Once this data has been received
* the class "puts" the information into a HashMap that was created to match the syntax of how the
* .php files of the database represent the data. Finally, it sends the information that was input
* to the web address of the .php file that is used to interpret the data and grab the necessary
* information from the database to signify whether the login attempt is successful or unsuccessful.
* And then lastly, it returns this information to the LoginActivity to be used in the login process.
*
* */

public class LoginRequest extends StringRequest{
    private static final String LOGIN_REQUEST_URL = "https://monophthongal-arriv.000webhostapp.com/login.php";
    private Map<String, String> params;

    /**
     *
     * The constructor for the LoginRequest class, which handles how the class is called and what
     * parameters are expected in the call.
     * Ben Butler
     * Created on Oct. 15, 2016
     * The parameters are set up to receive two String variables that would be the username/password
     * for the user wishing to access the application and the response listener that is initialized
     * in the LoginActivity to handle communication to and from the url.
     *
     */
    public LoginRequest(String username, String password, Response.Listener<String> listener){
        super (Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        //This matches the structure of the .php files used by the database.
        params.put("username", username);
        params.put("password", password);
    }

    /**
     *
     * A simple override of the getParams function.
     * Ben Butler
     * Created Oct. 15, 2015
     * This is simply an override of the original getParams to allow for the function to handle and
     * return the values of a HashMap<String, String>. This allows for the information to match the
     * syntax of the way the database is setup with the .php files.
     *
     */
    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
