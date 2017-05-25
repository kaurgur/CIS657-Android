package com.example.kaur.geo_calc_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import static com.example.kaur.geo_calc_android.R.layout.activity_selection;

public class Selection extends AppCompatActivity {
    int flag =0 ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);






        Spinner dist_spinner = (Spinner) findViewById(R.id.dist_spinner);
        Spinner bear_spinner = (Spinner) findViewById(R.id.bear_spinner);

        // Adding options for selecting distance units
        List<String> dist_list = new ArrayList<String>();

        dist_list.add("Kilometers");
        dist_list.add("Miles");

        ArrayAdapter<String> dataAdapter_dist = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, dist_list);
        dataAdapter_dist.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dist_spinner.setAdapter(dataAdapter_dist);

        // Adding options for selecting bearing units
        List<String> bear_list = new ArrayList<String>();

        bear_list.add("Degrees");
        bear_list.add("Mils");

        ArrayAdapter<String> dataAdapter_bear = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, bear_list);
        dataAdapter_bear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bear_spinner.setAdapter(dataAdapter_bear);


        Intent payload = getIntent();
        //if (payload.hasExtra("flag")) {



            if (dist_spinner.getSelectedItem() == "Kilometers" && bear_spinner.getSelectedItem() == "Degrees") {
                flag = 1;
            } else if (dist_spinner.getSelectedItem() == "Kilometers" && bear_spinner.getSelectedItem() == "Mils") {
                flag=2;

            } else if (dist_spinner.getSelectedItem() == "Miles" && bear_spinner.getSelectedItem() == "Degrees") {
                flag=3;

            } else if(dist_spinner.getSelectedItem() == "Miles" && bear_spinner.getSelectedItem() == "Mils"){
                flag=4;

            }




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(Selection.this, MainScreen.class);
                Intent i = new Intent();

                setResult(flag,i);
                finish();
                //startActivity(intent);
                //finish();

            }
        });

    }


}
