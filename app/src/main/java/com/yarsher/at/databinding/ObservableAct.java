package com.yarsher.at.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.yarsher.at.databinding.databinding.ActivityObservableBinding;

public class ObservableAct extends AppCompatActivity {

    private User user;
    private ObservableClickHandler observableClickHandler;


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

        observableClickHandler = new ObservableClickHandler(activityObservableBinding.content.firstName, activityObservableBinding.content.lastName);
        activityObservableBinding.content.setObservableClickHandler(observableClickHandler);
    }


    public class ObservableClickHandler {
        private EditText firstName, lastName;

        public ObservableClickHandler(EditText firstName, EditText lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public void updateUser(View view){


            user.setFirstName(firstName.getText().toString());
            user.setLastName(lastName.getText().toString());
            firstName.setText("");
            lastName.setText("");


        }


    }

}
