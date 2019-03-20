package com.yarsher.at.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yarsher.at.databinding.databinding.ActivityObservableBinding;

public class ObservableAct extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_observable);
        ActivityObservableBinding activityObservableBinding = DataBindingUtil.setContentView(this, R.layout.activity_observable);
        setSupportActionBar(activityObservableBinding.myToolbar);

        user = new User();
        user.setFirstName("This is new F Name");
        user.setLastName("This is new L Name");
        activityObservableBinding.setUser(user);
    }
}
