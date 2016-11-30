package com.example.ben.greenisthenewblack;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/*
* Ben Butler
* Oct. 15, 2016
* Green is the New Black, to promote local awareness of climate change and the
* effects on wildlife.
* RegisterRequest is a class in the application that handles different register attempts done by
* the user who is interacting with Green is the New Black.
* Created on Oct. 16, 2016 and revised up until Nov. 20, 2016.
* The class file is designed to interact with a .xml file, which is the visual representation
* of the activity.  While the java class file handles the manipulation of the data inputted from
* the U.I. of the application.
* The RegisterRequest class handles the registration information that the user inputted during the
* RegisterActivity, this class is designed to be called from the RegisterActivity once the user
* has inputted the desired new user information and pressed the "Register" button. Passing these
* as Strings the expected inputs are a name, username and desired password. Once the registration
* information has been received, the class "puts" the data into a HashMap which matches the syntax
* of the .php files for the database. Finally, it sends the HashMap of input data to the url of the
* .php file that handles saving the data to the table of user information; which completes the
* creation of a new user.
*
* */

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "https://monophthongal-arriv.000webhostapp.com/register.php";
    private Map<String, String> params;

    /**
     *
     * The constructor for the RegisterRequest class, which handles how the class is called and what
     * parameters are expected in the call.
     * Ben Butler
     * Created on Oct. 16, 2016
     * The parameters are set up to receive three String variables that would be the
     * name/username/password for the user wishing to access the application and the response
     * listener that is initialized in the RegisterActivity to handle communication to and from
     * the url.
     *
     */
    public RegisterRequest(String name, String username, String password, Response.Listener<String> listener){
        super (Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        //This matches the structure of the .php files used by the database.
        params.put("name", name);
        params.put("username", username);
        params.put("password", password);
    }

    /**
     *
     * A simple override of the getParams function.
     * Ben Butler
     * Created Oct. 16, 2015
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
