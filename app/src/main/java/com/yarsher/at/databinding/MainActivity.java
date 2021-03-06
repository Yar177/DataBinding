package com.yarsher.at.databinding;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.yarsher.at.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private ClickHandler clickHandler;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ContactInfo contactInfo = new ContactInfo("Yar", "Sher");
        activityMainBinding.setContact(contactInfo);
        setSupportActionBar(activityMainBinding.myToolbar);
        clickHandler = new ClickHandler(this);
        activityMainBinding.content.setOnClickHandler(clickHandler);

        user = new User();
        user.setFirstName("Android");
        user.setLastName("Droid");
        activityMainBinding.setUser(user);

    }

    public void goToObservable(View view) {
        Intent intent = new Intent(this, ObservableAct.class);
        startActivity(intent);
    }


    public class ClickHandler{
        private Context context;
        public ClickHandler(Context context) {
            this.context = context;
        }

        public void onButtonClick(View view){
            Toast.makeText(context, "Button Click Event", Toast.LENGTH_SHORT).show();
        }

        public boolean onLongClick(View view){
            Toast.makeText(context, "Button Loog Click Event", Toast.LENGTH_LONG).show();
        return false;
        }

        public void onButtonClickPassParameters(View view, ContactInfo contactInfo){
            Toast.makeText(context, "Passes Parameters:\nFirst Name:" + contactInfo.firstName
                    + "\nLast Name: " + contactInfo.lastName, Toast.LENGTH_LONG).show();
        }


   }


}
