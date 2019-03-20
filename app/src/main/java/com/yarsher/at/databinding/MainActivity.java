package com.yarsher.at.databinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.yarsher.at.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ContactInfo contactInfo = new ContactInfo("Yar", "Sher");
        activityMainBinding.setContact(contactInfo);
        setSupportActionBar(activityMainBinding.myToolbar);

    }


    public class clickHandler{

        private Context context;

        public clickHandler(Context context) {
            this.context = context;
        }

        public void onButtonClick(View view){
            Toast.makeText(context, "Button Click Event", Toast.LENGTH_LONG).show();
        }





    }
}
