package com.example.ben.greenisthenewblack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/*
* Joshua Lawson, Michael Lee
* Oct. 15, 2016
* Green is the New Black, to promote local awareness of climate change and the
* effects on wildlife.
* UserAreaActivity is a class in the application that handles the main menu section of the program.
* After the user logs in and is redirected to the UserAreaActivity, two buttons are displayed. These
* redirect the user to either the MapsActivity or the WildlifeActivity during an onClick response.
* Created on Oct. 20, 2016 and revised up until Nov. 26, 2016.
* The class file is designed to interact with a .xml file, which is the visual representation
* of the activity.  While the java class file handles the manipulation of the data inputted from
* the U.I. of the application.
*
* */

public class UserAreaActivity extends AppCompatActivity {

    /**
     * The onCreate is an @Override(change of a built-in function) that is ran during the initial
     * setup of the activity page. This allows for custom actions to take place during the
     * initialization of the details page.
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        final Button bmap = (Button) findViewById(R.id.bmap);
        final Button blearn = (Button) findViewById(R.id.blearn);
        final TextView welcomeMessage = (TextView) findViewById(R.id.welcome);

        bmap.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent mapIntent = new Intent(UserAreaActivity.this, MapsActivity.class);
                UserAreaActivity.this.startActivity(mapIntent);
            }
        });

        blearn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent learnIntent = new Intent(UserAreaActivity.this, WildLifeActivity.class);
                UserAreaActivity.this.startActivity(learnIntent);
            }
        });

        /**
         * Setting the TextView associated with the Main Menu text to display the phrase,
         * "Main Menu".
         */
        String message = "Main Menu";
        welcomeMessage.setText(message);
    }
}
