package com.example.kaur.geo_calc_android;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableStringBuilder;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import static android.R.attr.data;
import static com.example.kaur.geo_calc_android.R.layout.activity_main_screen;
import static java.lang.System.out;


public class MainScreen extends AppCompatActivity {
    public double dist = 0.0;
    public double bear = 0.0;
    double lat1,long1,lat2,long2;
    private TextView Dist_View , Bear_View;
    private Button CalButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main_screen);




        EditText P1Latitude = (EditText) findViewById(R.id.P1Latitude);
            EditText P1Longitude = (EditText) findViewById(R.id.P1Longitude);
            EditText P2Latitude = (EditText) findViewById(R.id.P2Latitude);
            EditText P2Longitude = (EditText) findViewById(R.id.P2Longitude);
            CalButton = (Button) findViewById(R.id.CalButton);
            Button ClearButton = (Button) findViewById(R.id.ClearButton);
            Dist_View = (TextView) findViewById(R.id.Dist_View);
            Bear_View = (TextView) findViewById(R.id.Bear_View);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.settings);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);








        ClearButton.setOnClickListener(v -> {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(ClearButton.getWindowToken(), 0);
            P1Latitude.setText("");
            P1Longitude.setText("");
            P2Latitude.setText("");
            P2Longitude.setText("");
            Bear_View.setText("");
            Dist_View.setText("");
        });

        CalButton.setOnClickListener(v -> {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(CalButton.getWindowToken(), 0);

             lat1 = Double.parseDouble(P1Latitude.getText().toString());
             long1 = Double.parseDouble(P1Longitude.getText().toString());
             lat2 = Double.parseDouble(P2Latitude.getText().toString());
             long2 = Double.parseDouble(P2Longitude.getText().toString());

            Location loc1 = new Location("location1");

            loc1.setLatitude(lat1);
            loc1.setLongitude(long1);

            Location loc2 = new Location("location2");
            loc2.setLatitude(lat2);
            loc2.setLongitude(long2);



            dist = loc1.distanceTo(loc2);
            dist = dist / 1000;


            bear = loc1.bearingTo(loc2);




                Bear_View.setText(""+bear);
                Dist_View.setText(""+ dist);




        });

        Button settings_but = (Button) findViewById(R.id.settings_but);

            settings_but.setOnClickListener(v -> {
                Intent intent = new Intent(this, Selection.class);

                //intent.putExtra("flag",1);
                startActivityForResult(intent,1);






            });



    }




    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        System.out.print("Helllo");
        //if(resultCode == RESULT_OK) {

            if ( resultCode  == 1) {

                Bear_View.setText("" + bear);
                Dist_View.setText("" + dist);

            } else if (resultCode == 2) {

                bear = bear * 17.777;
                Bear_View.setText("" + bear);
                Dist_View.setText("check" + dist);

            } else if (resultCode == 3) {
                dist = dist * 0.621371;
                Bear_View.setText("" + bear);
                Dist_View.setText("" + dist);
            } else if(resultCode == 4){
                bear = bear * 17.777;
                dist = dist * 0.621371;
                Bear_View.setText("" + bear);
                Dist_View.setText("" + dist);

            }

        super.onActivityResult(requestCode, resultCode, data);
        //}

    }



}
