package com.example.ben.greenisthenewblack;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/*
* Joshua Lawson
* Oct. 15, 2016
* Green is the New Black, to promote local awareness of climate change and the
* effects on wildlife.
* MapsActivity is a class in the application that handles the implementation of the Google Maps API
* into the program. It sets the visual map using the onCreate method to display the map at runtime.
* The map tags are represented by addMarker using the latitude and longitude and then placed on
* the map.
* Created on Nov. 5, 2016 and revised up until Nov. 26, 2016.
* The class file is designed to interact with a .xml file, which is the visual representation
* of the activity.  While the java class file handles the manipulation of the data inputted from
* the U.I. of the application.
*
* */

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    /**
     * The onCreate is an @Override(change of a built-in function) that is ran during the initial
     * setup of the activity page. This allows for custom actions to take place during the
     * initialization of the details page.
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the MapFragment and get notified when the map is ready to be used.
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Wilmington, North Carolina.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Wilmington and move the camera
        LatLng wilm = new LatLng(34.2257, -77.9447);
        mMap.addMarker(new MarkerOptions().position(wilm).title("Our Home!!!"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(wilm, 11));

        //Adding markers for the different animals

        //Markers for Canis Rufus
        LatLng fox1 = new LatLng(35.738852, -76.303502);
        LatLng fox2 = new LatLng(35.822409, -75.853063);
        LatLng fox3 = new LatLng(35.859146, -76.428472);
        mMap.addMarker(new MarkerOptions().position(fox1).title("Canis Rufus"));
        mMap.addMarker(new MarkerOptions().position(fox2).title("Canis Rufus"));
        mMap.addMarker(new MarkerOptions().position(fox3).title("Canis Rufus"));

        //Markers for Dermochelys Coriacea
        LatLng turtle1 = new LatLng(34.154008, -77.713872);
        LatLng turtle2 = new LatLng(34.639001, -76.469671);
        LatLng turtle3 = new LatLng(35.600511, -75.719854);
        mMap.addMarker(new MarkerOptions().position(turtle1).title("Dermochelys Coriacea"));
        mMap.addMarker(new MarkerOptions().position(turtle2).title("Dermochelys Coriacea"));
        mMap.addMarker(new MarkerOptions().position(turtle3).title("Dermochelys Coriacea"));

        //Markers for Glaucomys Sabrinus Coloratus
        LatLng flySquirrel1 = new LatLng(35.366405, -82.882453);
        LatLng flySquirrel2 = new LatLng(35.995537, -81.745368);
        LatLng flySquirrel3 = new LatLng(35.590069, -81.635504);
        mMap.addMarker(new MarkerOptions().position(flySquirrel1).title("Glaucomys Sabrinus Coloratus"));
        mMap.addMarker(new MarkerOptions().position(flySquirrel2).title("Glaucomys Sabrinus Coloratus"));
        mMap.addMarker(new MarkerOptions().position(flySquirrel3).title("Glaucomys Sabrinus Coloratus"));

        //Markers for Neonympha mitchellii francisci
        LatLng butterfly1 = new LatLng(34.856788, -79.075052);
        LatLng butterfly2 = new LatLng(35.269122, -78.859156);
        LatLng butterfly3 = new LatLng(35.020662, -78.411373);
        mMap.addMarker(new MarkerOptions().position(butterfly1).title("Neonympha mitchellii francisci"));
        mMap.addMarker(new MarkerOptions().position(butterfly2).title("Neonympha mitchellii francisci"));
        mMap.addMarker(new MarkerOptions().position(butterfly3).title("Neonympha mitchellii francisci"));

        //Markers for Picoides borealis
        LatLng woodPecker1 = new LatLng(34.501705, -77.643743);
        LatLng woodPecker2 = new LatLng(35.190743, -79.318935);
        LatLng woodPecker3 = new LatLng(34.817410, -77.088011);
        mMap.addMarker(new MarkerOptions().position(woodPecker1).title("Picoides borealis"));
        mMap.addMarker(new MarkerOptions().position(woodPecker2).title("Picoides borealis"));
        mMap.addMarker(new MarkerOptions().position(woodPecker3).title("Picoides borealis"));

    }
}
