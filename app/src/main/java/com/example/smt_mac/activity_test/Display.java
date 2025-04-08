package com.example.smt_mac.activity_test;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

/**
 * Created by SMT_Mac on 2/26/16.
 */


public class Display extends Activity

{
    permission permisonObj;

    Selection ScObj;


    private CheckBox checkEnabler;
    private LinearLayout linearGeneral;
    private RadioGroup radioGroup;
    private RadioButton radioRed, radioGreen;




    Spinner spinner;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
//-----
        initializing_componentes();
        initializing_methods();

        permisonObj= new permission();
        permisonObj.disable(radioRed, radioGreen);



        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.Direction,android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }
    public void onButtonClick2(View v) {
        if (v.getId() == R.id.map) {
            Intent i = new Intent(this, MapsActivity.class);
            startActivity(i);
        }
    }


    public void initializing_componentes(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        checkEnabler= (CheckBox) findViewById(R.id.checkBox);
        linearGeneral=(LinearLayout)findViewById(R.id.LinearGeneral);

        radioGroup=(RadioGroup) findViewById(R.id.radioGroup);

        radioRed=(RadioButton) findViewById(R.id.radio1);
        radioGreen=(RadioButton) findViewById(R.id.radio2);



    }



    public void initializing_methods() {


        checkEnabler.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    permisonObj.enable(radioRed, radioGreen);
                    checkEnabler.setText("Anonymization ACTIVE!");
                } else {
                    permisonObj.disable(radioRed, radioGreen);
                    checkEnabler.setText("Anonymization INACTIVE!");
                    linearGeneral.setBackgroundColor(Color.LTGRAY);
                }
            }
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                switch (checkedId) {
                    case R.id.radio1:
                        linearGeneral.setBackgroundColor(Color.RED);
                        ScObj.GV=2;


                        break;
                    case R.id.radio2:
                        linearGeneral.setBackgroundColor(Color.GREEN);
                        ScObj.GV=3;

                        break;



                }


            }
        });


    }


}

/*


protected Address doInBackground(String... params) {
    Geocoder geocoder = new Geocoder(mContext);
    List<Address> addresses = null;

    //reference location TODO handle null
    double lat = mLocation.getLatitude();
    double lon = mLocation.getLongitude();
    int i = 0;
    try {
        //loop through SEARCH_RANGES until addresses are returned
        do{
            //if range is -1, call  getFromLocationName() without bounding box
            if(SEARCH_RANGES[i] != -1){

                //calculate bounding box
                double lowerLeftLatitude =  translateLat(lat,-SEARCH_RANGES[i]);
                double lowerLeftLongitude = translateLon(lon,SEARCH_RANGES[i]);
                double upperRightLatitude = translateLat(lat,SEARCH_RANGES[i]);
                double upperRightLongitude = translateLon(lon,-SEARCH_RANGES[i]);

                addresses = geocoder.getFromLocationName(params[0], 5, lowerLeftLatitude, lowerLeftLongitude, upperRightLatitude, upperRightLongitude);

            } else {
                //last resort, try unbounded call with 20 result
                addresses = geocoder.getFromLocationName(params[0], 20);
            }
            i++;

        }while((addresses == null || addresses.size() == 0) && i < SEARCH_RANGES.length );

    } catch (IOException e) {
        Log.i(this.getClass().getSimpleName(),"Gecoder lookup failed! " +e.getMessage());
    }



    if(addresses == null ||addresses.size() == 0)
        return null;

    //If multiple addresses were returned, find the closest
    if(addresses.size() > 1){
        Address closest = null;
        for(Address address: addresses){
            if(closest == null)
                closest = address;
            else
                closest = getClosest(mLocation, closest,address);//returns the address that is closest to mLocation
        }
        return closest;
    }else
        return addresses.get(0);

}

 */