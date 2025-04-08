package com.example.smt_mac.activity_test;

import android.widget.RadioButton;

/**
 * Created by SMT_Mac on 4/24/16.
 */
public class permission {





        public permission() {

        }

        public void disable(RadioButton radio1, RadioButton radio2) {
            radio1.setEnabled(false);
            radio2.setEnabled(false);




        }

        public void enable(RadioButton radio1, RadioButton radio2) {

            radio1.setEnabled(true);
            radio2.setEnabled(true);



        }


}


