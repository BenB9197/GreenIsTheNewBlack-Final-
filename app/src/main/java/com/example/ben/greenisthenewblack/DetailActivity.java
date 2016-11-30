package com.example.ben.greenisthenewblack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/*
* Ben Butler
* Oct. 15, 2016
* Green is the New Black, to promote local awareness of climate change and the
* effects on wildlife.
* DetailActivity is a class in the application that handles presenting the different information
* about the selected endangered wildlife from the WildLifeActivity.
* Created on Oct. 29, 2016 and revised up until Nov. 26, 2016.
* The class file is designed to interact with a .xml file, which is the visual representation
* of the activity.  While the java class file handles the manipulation of the data inputted from
* the U.I. of the application.
* The DetailActivity class is designed solely to set the wildlife information to their respected
* fields in the activity_detail.xml file. However, before the requested information is displayed
* the scientific name must be changed to lowercase letters and the spaces replaced with "_". This
* action occurs because the built-in function that handles setting the image cannot process
* capital letters or spaces. This is done by the lowerCase function by using the java built-in
* toLowerCase() and replaceAll() functions. Once this occurs the class is able to set the necessary
* corresponding fields with different sets of wildlife information, including the image of the animal or
* plant.
*
* */

public class DetailActivity extends AppCompatActivity {

    /**
     * The lowerCase method is a simple method that implements the Java built-in functions of:
     * toLowerCase() and replaceAll(). These methods help to format the scientific name of the
     * wildlife that was selected to match the formatting of the different .jpg images used in
     * the activity_detail.xml.
     * Ben Butler
     * Created on Nov. 1, 2016
     * It is used within the onCreate method below during the creation of the details page for the
     * selected wildlife. It does this by accepting a String variable that is suspected to be the
     * scientific name of a plant or animal and later returns the same String but without uppercase
     * letters and no spaces in the name.
     *
     */
    public String lowerCase(String scientificName){
        String lowerScience = scientificName.toLowerCase().replaceAll("\\s", "_");
        return lowerScience;
    }

    /**
     * The onCreate is an @Override(change of a built-in function) that is ran during the initial
     * setup of the activity page. This allows for custom actions to take place during the
     * initialization of the details page.
     * Ben Butler
     * Created on Oct.29, 2016
     * This method is called upon when the DetailActivity page is accessed during the runtime of the
     * application. It accesses the activity_detail.xml file to be able to edit the specific fields
     * on the page. After doing so, it begins to look for an Intent(an action event that is
     * conducted by the android application to send information from one class to another) and after
     * doing so is able to grab the information that is needed: the scientific name, the common
     * name, and the details about the wildlife. Once all the information needed is accessed, the
     * method begins to set the text of the TextView fields until it needs to set the id for the
     * picture of the wildlife. This occurs because the setImageResource(), only is able to receive
     * an int as a parameter to set the image. After using different built-in functions the image
     * is able to be called and all the information regarding the selected wildlife is presented
     * on the screen.
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //This is where an Intent is created, which is an action that is being performed by the
        //application. This Intent is grabbing the information needed for the scientific name,
        //the common name and the information about the wildlife that was sent over from the
        //database.
        Intent intent = getIntent();
        String scientific = intent.getStringExtra("scientific");
        String common = intent.getStringExtra("commonName");
        String details = intent.getStringExtra("info");

        //Assigns the different TextViews and ImageView to specific variables to be used later.
        TextView scientificName = (TextView) findViewById(R.id.scientificName);
        TextView commonName = (TextView) findViewById(R.id.commonName);
        TextView detailsText = (TextView) findViewById(R.id.detailsText);
        ImageView image = (ImageView) findViewById(R.id.image);

        //Sets the information from the database to the different TextViews on the application to be
        //presented to the user.
        scientificName.setText("Scientific Name: " + scientific);
        commonName.setText("Common Name: " + common);
        detailsText.setText(details);
        //Changes the String value of the scientific name to an int that setImageResource is able
        //to handle.
        int id = getResources().getIdentifier(lowerCase(scientific), "drawable", getPackageName());
        image.setImageResource(id);


    }
}
