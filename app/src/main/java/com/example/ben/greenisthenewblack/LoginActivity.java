package com.example.ben.greenisthenewblack;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/*
* Ben Butler, Michael Lee
* Oct. 15, 2016
* Green is the New Black, to promote local awareness of climate change and the
* effects on wildlife.
* LoginActivity is a class in the application that handles different login attempts done by
* the user who is interacting with Green is the New Black.
* Created on Oct. 15, 2016 and revised up until Nov. 20, 2016.
* The class file is designed to interact with a .xml file, which is the visual representation
* of the activity.  While the java class file handles the manipulation of the data inputted from
* the U.I. of the application.
* The LoginActivity class specifically handles the data from the login screen of the application.
* This data can include: the username and password of the user wishing to access the application,
* waiting for a button press to activate the login process and finally, responding if the user
* presses the "register here" button. The expected outputs of the class include: a redirect to
* the UserAreaActivity, an invalid login popup window which occurs when the user inputs incorrect
* login information, and a redirect to the RegisterActivity.
*
* */

public class LoginActivity extends AppCompatActivity {

    /**
     * The onCreate is an @Override(change of a built-in function) that is ran during the initial
     * setup of the activity page. This allows for custom actions to take place during the
     * initialization of the login page.
     * Ben Butler, Michael Lee
     * Created on Oct. 15, 2016
     * This method is called upon during the initial runtime of the LoginActivity. This method
     * accesses the activity_login.xml file to be able access the information that is present on
     * the login screen of the application. This information includes the different EditText
     * fields, the login button and the TextView that leads to the RegisterActivity. After the
     * method has set the different attributes to variable names it implements two different
     * OnClickListeners, which are instances that are designed to execute if their corresponding
     * field is "clicked". Once one of the OnClickListeners is satisfied, it executes the commands
     * associated with the field pressed.
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Assigns the different EditTexts, Button and TextView to variables to be used later.
        final EditText etUsername = (EditText) findViewById(R.id.email);
        final EditText etPassword = (EditText) findViewById(R.id.pword);
        final Button blogin = (Button) findViewById(R.id.blogin);
        final TextView registerLink = (TextView) findViewById(R.id.tv);

        //Sets an OnClickListener onto the TextView that is associated with Registering a new user.
        registerLink.setOnClickListener(new View.OnClickListener(){

            /**
             * The onClick method is a simple @Override of the built-in function of onClick()
             * for OnClickListeners. This method is executed when the application detects a "click"
             * on the associated field.
             * Ben Butler, Michael Lee
             * Created on Oct. 15, 2016
             * When a "click" is received for the registerLinkTextView, it creates an Intent(an
             * action carried out by the application) to transfer the user from the LoginActivity
             * page to the RegisterActivity page to allow for newuser registration.
             *
             */
            @Override
            public void onClick(View v){
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

        //Sets an OnClickListener onto the Button that is associated with the Login feature.
        blogin.setOnClickListener(new View.OnClickListener() {

            /**
             * The onClick method is a simple @Override of the built-in function of onClick()
             * for OnClickListeners. This method is executed when the application detects a "click"
             * on the associated field.
             * Ben Butler, Michael Lee
             * Created on Oct. 15, 2016
             * When a "click" associated with the Login Button is received, the onClick method
             * initially grabs the user information from the username and password EditText fields.
             * This information is then converted to the String types, with the help of a toString()
             * method. This login information is passed, with the return value of the onResponse
             * method below, through the LoginRequest class to determine if the entered information
             * is correct and allow a login into the system or instead return an incorrect login
             * information error.
             *
             */
            @Override
            public void onClick(View view) {
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();

                //Sets a response listener for the action of clicking on the login button.
                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    /**
                     * The onResponse method is a simple @Override of the built-in function of
                     * onResponse() for OnClickListeners. This method is executed when the
                     * application detects an action that was executed that needs a response to the
                     * activity that occurred.
                     * Ben Butler, Michael Lee
                     * Created on Oct. 15, 2016
                     * Once the Login button has been pressed, the application needs a response from
                     * the database as to whether or not the login information entered is valid or
                     * invalid. The onResponse method attempts to try to receive a JSONObject that
                     * was sent from the associated .php file. If the information was valid, then
                     * the other corresponding user information is recorded from the database and
                     * the user is transferred to the UserAreaActivity by the use of an
                     * Intent (an internal action of the program).
                     *
                     */
                    @Override
                    public void onResponse(String response) {
                        //This attempts to receive a JSONObject from the .php file, which would
                        //occur when the application successfully connected to the database.
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                String name = jsonResponse.getString("name");

                                /**
                                 * Sends over the needed information to the UseaAreaActivity function
                                 */
                                Intent intent = new Intent(LoginActivity.this, UserAreaActivity.class);
                                intent.putExtra("name", name);
                                intent.putExtra("username", username);

                                LoginActivity.this.startActivity(intent);
                            }
                            else{
                                //Error message pop-up for the incorrect login information
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                //This is where the username, password and responseListener is passed to the
                //loginRequest class to check whether the information is actually valid or invalid.
                LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });
    }
}
