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
* DetailsRequest is a class in the application that handles requests directed towards the database
* concerning information about the indicated wildlife by scientific name.
* Created on Oct. 29, 2016 and revised up until Nov. 26, 2016.
* The class file is designed to interact with a .xml file, which is the visual representation
* of the activity.  While the java class file handles the manipulation of the data input from
* the U.I. of the application.
* The DetailsRequest class handles the scientific name that was sent over from the WildLifeActivity
* class, it is designed to be called during the WildLifeActivity class once the user has selected
* the wildlife they wish to know more about. This scientific name is then placed in a HashMap that
* matches the syntax of how the .php files of the database represent the different information of
* the wildlife. This information is then sent to the url of the .php file that handles finding
* the entry in the database that matches the scientific name from the pressed textfield. This
* sent information is necessary for being used later to find the other statistics about the specific
* wildlife, once it has been returned.
*
* */

public class DetailsRequest extends StringRequest{

    //The variable that the url location of the .php file is stored in.
    private static final String GRAB_REQUEST_URL = "https://monophthongal-arriv.000webhostapp.com/grab.php";
    private Map<String, String> params;

    /**
     *
     * The constructor for the DetailsRequest class, which handles how the class is called and what
     * parameters are expected in the call.
     * Ben Butler
     * Created on Oct. 29, 2016
     * The parameters are set up to receive a String variable that would be the scientific name of
     * the wildlife and the response listener that is initialized in the WildLifeActivity to handle
     * communication to and from the url.
     *
     */
    public DetailsRequest(String scientificName, Response.Listener<String> listener){
        super (Request.Method.POST, GRAB_REQUEST_URL, listener, null);
        params = new HashMap<>();
        //This matches the structure of the .php files used by the database.
        params.put("scientific", scientificName);
    }

    /**
     *
     * A simple override of the getParams function.
     * Ben Butler
     * Created Oct. 29, 2015
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
