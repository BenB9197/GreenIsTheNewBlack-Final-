package com.example.ben.greenisthenewblack;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/*
* Ben Butler
* Oct. 15, 2016
* Green is the New Black, to promote local awareness of climate change and the
* effects on wildlife.
* WildLifeActivity is a class in the application that handles the String values of the different
* wildlife textviews that the user may select to view the details of.
* Created on Oct. 22, 2016 and revised up until Nov. 26, 2016.
* The class file is designed to interact with a .xml file, which is the visual representation
* of the activity.  While the java class file handles the manipulation of the data inputted from
* the U.I. of the application.
* The WildLifeActivity class is used whenever the user accesses the learning page of the
* application. Each of the textviews that the .xml file creates to present to the user is tied to
* a TextView variable. This allows a listener to be applied to each TextView individually, awaiting
* to respond to the user clicking/selecting the intended scientific name. Once a click is registered
* as occurring, the program checks to see which TextView was selected by matching the id of the
* selected TextView to all the available TextViews. Once this occurs, the String value of the
* wildlife selected is assigned to the variable scientificName, which is lastly used to pass through
* the detailsRequest class to indicate which scientific name needs to be searched for in the
* database.
*
* */

public class WildLifeActivity extends AppCompatActivity implements View.OnClickListener {

    String scientificName;

    /**
     * The onCreate is an @Override(change of a built-in function) that is ran during the initial
     * setup of the activity page. This allows for custom actions to take place during the
     * initialization of the details page.
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wild_life);

        final TextView wildWel = (TextView) findViewById(R.id.wlw);

        /*Giving all the buttons listeners for clicking on them.*/
        final TextView tv1 = (TextView) findViewById(R.id.textView1);
        tv1.setOnClickListener(this);

        final TextView tv2 = (TextView) findViewById(R.id.textView2);
        tv2.setOnClickListener(this);
        final TextView tv3 = (TextView) findViewById(R.id.textView3);
        tv3.setOnClickListener(this);
        final TextView tv4 = (TextView) findViewById(R.id.textView4);
        tv4.setOnClickListener(this);
        final TextView tv5 = (TextView) findViewById(R.id.textView5);
        tv5.setOnClickListener(this);
        final TextView tv6 = (TextView) findViewById(R.id.textView6);
        tv6.setOnClickListener(this);
        final TextView tv7 = (TextView) findViewById(R.id.textView7);
        tv7.setOnClickListener(this);
        final TextView tv8 = (TextView) findViewById(R.id.textView8);
        tv8.setOnClickListener(this);
        final TextView tv9 = (TextView) findViewById(R.id.textView9);
        tv9.setOnClickListener(this);
        final TextView tv10 = (TextView) findViewById(R.id.textView10);
        tv10.setOnClickListener(this);
        final TextView tv11 = (TextView) findViewById(R.id.textView11);
        tv11.setOnClickListener(this);
        final TextView tv12 = (TextView) findViewById(R.id.textView12);
        tv12.setOnClickListener(this);
        final TextView tv13 = (TextView) findViewById(R.id.textView13);
        tv13.setOnClickListener(this);
        final TextView tv14 = (TextView) findViewById(R.id.textView14);
        tv14.setOnClickListener(this);
        final TextView tv15 = (TextView) findViewById(R.id.textView15);
        tv15.setOnClickListener(this);
        final TextView tv16 = (TextView) findViewById(R.id.textView16);
        tv16.setOnClickListener(this);
        final TextView tv17 = (TextView) findViewById(R.id.textView18);
        tv17.setOnClickListener(this);
        final TextView tv18 = (TextView) findViewById(R.id.textView19);
        tv18.setOnClickListener(this);
        final TextView tv19 = (TextView) findViewById(R.id.textView20);
        tv19.setOnClickListener(this);
        final TextView tv20 = (TextView) findViewById(R.id.textView21);
        tv20.setOnClickListener(this);
        final TextView tv21 = (TextView) findViewById(R.id.textView22);
        tv21.setOnClickListener(this);
        final TextView tv22 = (TextView) findViewById(R.id.textView23);
        tv22.setOnClickListener(this);
        final TextView tv23 = (TextView) findViewById(R.id.textView24);
        tv23.setOnClickListener(this);
        final TextView tv24 = (TextView) findViewById(R.id.textView25);
        tv24.setOnClickListener(this);
        final TextView tv25 = (TextView) findViewById(R.id.textView26);
        tv25.setOnClickListener(this);
        final TextView tv26 = (TextView) findViewById(R.id.textView27);
        tv26.setOnClickListener(this);
        final TextView tv27 = (TextView) findViewById(R.id.textView28);
        tv27.setOnClickListener(this);
        final TextView tv28 = (TextView) findViewById(R.id.textView29);
        tv28.setOnClickListener(this);
        final TextView tv29 = (TextView) findViewById(R.id.textView30);
        tv29.setOnClickListener(this);
        final TextView tv30 = (TextView) findViewById(R.id.textView31);
        tv30.setOnClickListener(this);
        final TextView tv31 = (TextView) findViewById(R.id.textView32);
        tv31.setOnClickListener(this);
        final TextView tv32 = (TextView) findViewById(R.id.textView33);
        tv32.setOnClickListener(this);
        final TextView tv33 = (TextView) findViewById(R.id.textView34);
        tv33.setOnClickListener(this);
        final TextView tv34 = (TextView) findViewById(R.id.textView35);
        tv34.setOnClickListener(this);
        final TextView tv35 = (TextView) findViewById(R.id.textView36);
        tv35.setOnClickListener(this);
        final TextView tv36 = (TextView) findViewById(R.id.textView38);
        tv36.setOnClickListener(this);
        final TextView tv37 = (TextView) findViewById(R.id.textView39);
        tv37.setOnClickListener(this);
        final TextView tv38 = (TextView) findViewById(R.id.textView40);
        tv38.setOnClickListener(this);
        final TextView tv39 = (TextView) findViewById(R.id.textView41);
        tv39.setOnClickListener(this);
        final TextView tv40 = (TextView) findViewById(R.id.textView42);
        tv40.setOnClickListener(this);
        final TextView tv41 = (TextView) findViewById(R.id.textView43);
        tv41.setOnClickListener(this);
        final TextView tv42 = (TextView) findViewById(R.id.textView44);
        tv42.setOnClickListener(this);



        String message = "Wildlife Data";
        wildWel.setText(message);

    }
    @Override
    public void onClick(View view) {


            if (view == findViewById(R.id.textView1)){
                String sv1 = ((TextView) findViewById(R.id.textView1)).getText().toString();
                scientificName = sv1;}
            else if (view == findViewById(R.id.textView2)){
                String sv2 = ((TextView) findViewById(R.id.textView2)).getText().toString();
                scientificName = sv2;}
            else if (view == findViewById(R.id.textView3)){
                String sv3 = ((TextView) findViewById(R.id.textView3)).getText().toString();
                scientificName = sv3;}
            else if (view == findViewById(R.id.textView4)){
                String sv4 = ((TextView) findViewById(R.id.textView4)).getText().toString();
                scientificName = sv4;}
            else if (view == findViewById(R.id.textView5)){
                String sv5 = ((TextView) findViewById(R.id.textView5)).getText().toString();
                scientificName = sv5;}
            else if (view == findViewById(R.id.textView6)){
                String sv6 = ((TextView) findViewById(R.id.textView6)).getText().toString();
                scientificName = sv6;}
            else if (view == findViewById(R.id.textView7)){
                String sv7 = ((TextView) findViewById(R.id.textView7)).getText().toString();
                scientificName = sv7;}
            else if (view == findViewById(R.id.textView8)){
                String sv8 = ((TextView) findViewById(R.id.textView8)).getText().toString();
                scientificName = sv8;}
            else if (view == findViewById(R.id.textView9)){
                String sv9 = ((TextView) findViewById(R.id.textView9)).getText().toString();
                scientificName = sv9;}
            else if (view == findViewById(R.id.textView10)){
                String sv10 = ((TextView) findViewById(R.id.textView10)).getText().toString();
                scientificName = sv10;}
            else if (view == findViewById(R.id.textView11)){
                String sv11 = ((TextView) findViewById(R.id.textView11)).getText().toString();
                scientificName = sv11;}
            else if (view == findViewById(R.id.textView12)){
                String sv12 = ((TextView) findViewById(R.id.textView12)).getText().toString();
                scientificName = sv12;}
            else if (view == findViewById(R.id.textView13)){
                String sv13 = ((TextView) findViewById(R.id.textView13)).getText().toString();
                scientificName = sv13;}
            else if (view == findViewById(R.id.textView14)){
                String sv14 = ((TextView) findViewById(R.id.textView14)).getText().toString();
                scientificName = sv14;}
            else if (view == findViewById(R.id.textView15)){
                String sv15 = ((TextView) findViewById(R.id.textView15)).getText().toString();
                scientificName = sv15;}
            else if (view == findViewById(R.id.textView16)){
                String sv16 = ((TextView) findViewById(R.id.textView16)).getText().toString();
                scientificName = sv16;}
            else if (view == findViewById(R.id.textView18)){
                String sv18 = ((TextView) findViewById(R.id.textView18)).getText().toString();
                scientificName = sv18;}
            else if (view == findViewById(R.id.textView19)){
                String sv19 = ((TextView) findViewById(R.id.textView19)).getText().toString();
                scientificName = sv19;}
            else if (view == findViewById(R.id.textView20)){
                String sv20 = ((TextView) findViewById(R.id.textView20)).getText().toString();
                scientificName = sv20;}
            else if (view == findViewById(R.id.textView21)){
                String sv21 = ((TextView) findViewById(R.id.textView21)).getText().toString();
                scientificName = sv21;}
            else if (view == findViewById(R.id.textView22)){
                String sv22 = ((TextView) findViewById(R.id.textView22)).getText().toString();
                scientificName = sv22;}
            else if (view == findViewById(R.id.textView23)){
                String sv23 = ((TextView) findViewById(R.id.textView23)).getText().toString();
                scientificName = sv23;}
            else if (view == findViewById(R.id.textView24)){
                String sv24 = ((TextView) findViewById(R.id.textView24)).getText().toString();
                scientificName = sv24;}
            else if (view == findViewById(R.id.textView25)){
                String sv25 = ((TextView) findViewById(R.id.textView25)).getText().toString();
                scientificName = sv25;}
            else if (view == findViewById(R.id.textView26)){
                String sv26 = ((TextView) findViewById(R.id.textView26)).getText().toString();
                scientificName = sv26;}
            else if (view == findViewById(R.id.textView27)){
                String sv27 = ((TextView) findViewById(R.id.textView27)).getText().toString();
                scientificName = sv27;}
            else if (view == findViewById(R.id.textView28)){
                String sv28 = ((TextView) findViewById(R.id.textView28)).getText().toString();
                scientificName = sv28;}
            else if (view == findViewById(R.id.textView29)){
                String sv29 = ((TextView) findViewById(R.id.textView29)).getText().toString();
                scientificName = sv29;}
            else if (view == findViewById(R.id.textView30)){
                String sv30 = ((TextView) findViewById(R.id.textView30)).getText().toString();
                scientificName = sv30;}
            else if (view == findViewById(R.id.textView31)){
                String sv31 = ((TextView) findViewById(R.id.textView31)).getText().toString();
                scientificName = sv31;}
            else if (view == findViewById(R.id.textView32)){
                String sv32 = ((TextView) findViewById(R.id.textView32)).getText().toString();
                scientificName = sv32;}
            else if (view == findViewById(R.id.textView33)){
                String sv33 = ((TextView) findViewById(R.id.textView33)).getText().toString();
                scientificName = sv33;}
            else if (view == findViewById(R.id.textView34)){
                String sv34 = ((TextView) findViewById(R.id.textView34)).getText().toString();
                scientificName = sv34;}
            else if (view == findViewById(R.id.textView35)){
                String sv35 = ((TextView) findViewById(R.id.textView35)).getText().toString();
                scientificName = sv35;}
            else if (view == findViewById(R.id.textView36)){
                String sv36 = ((TextView) findViewById(R.id.textView36)).getText().toString();
                scientificName = sv36;}
            else if (view == findViewById(R.id.textView38)){
                String sv38 = ((TextView) findViewById(R.id.textView38)).getText().toString();
                scientificName = sv38;}
            else if (view == findViewById(R.id.textView39)){
                String sv39 = ((TextView) findViewById(R.id.textView39)).getText().toString();
                scientificName = sv39;}
            else if (view == findViewById(R.id.textView40)){
                String sv40 = ((TextView) findViewById(R.id.textView40)).getText().toString();
                scientificName = sv40;}
            else if (view == findViewById(R.id.textView41)){
                String sv41 = ((TextView) findViewById(R.id.textView41)).getText().toString();
                scientificName = sv41;}
            else if (view == findViewById(R.id.textView42)){
                String sv42 = ((TextView) findViewById(R.id.textView42)).getText().toString();
                scientificName = sv42;}
            else if (view == findViewById(R.id.textView43)){
                String sv43 = ((TextView) findViewById(R.id.textView43)).getText().toString();
                scientificName = sv43;}
            else if (view == findViewById(R.id.textView44)){
                String sv44 = ((TextView) findViewById(R.id.textView44)).getText().toString();
                scientificName = sv44;}

                Response.Listener<String> responseListenerWild = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                String scientific = jsonResponse.getString("scientific");
                                String common = jsonResponse.getString("common");
                                String info = jsonResponse.getString("info");

                                /**
                                 * Sends over the needed information to the DetailActivity function
                                 */
                                Intent sendInformation = new Intent(WildLifeActivity.this, DetailActivity.class);
                                sendInformation.putExtra("scientific", scientific);
                                sendInformation.putExtra("commonName", common);
                                sendInformation.putExtra("info", info);

                                WildLifeActivity.this.startActivity(sendInformation);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(WildLifeActivity.this);
                                builder.setMessage("Request Failed!")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                DetailsRequest detailsRequest = new DetailsRequest(scientificName, responseListenerWild);
                RequestQueue queue = Volley.newRequestQueue(WildLifeActivity.this);
                queue.add(detailsRequest);
        }

    }

