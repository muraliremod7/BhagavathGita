package com.murali.hariprahlad.bhagavathgita.activitys;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.murali.hariprahlad.bhagavathgita.R;
import com.murali.hariprahlad.bhagavathgita.Services.ConnectionDetector;
import com.murali.hariprahlad.bhagavathgita.model.AlertDialogManager;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private Toolbar toolbar;
    private EditText username,email,mobile,pin,conpin,pincode;
    private AutoCompleteTextView country,state,city;
    private Button register;
    private TextView reglogin;
    private ArrayAdapter<String> adapter;
    private String[] regcountries,regstates,regcitys;
    String Contrys,States,Citys;
    AlertDialogManager alert = new AlertDialogManager();
    ConnectionDetector cd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.YELLOW);
        toolbar.setCollapsible(true);

        username = (EditText)findViewById(R.id.regusername);
        email = (EditText)findViewById(R.id.regemail);
        mobile = (EditText)findViewById(R.id.regmobile);
        pin = (EditText)findViewById(R.id.regpin);
        conpin = (EditText)findViewById(R.id.regconpin);
        pincode = (EditText)findViewById(R.id.regpincode);
        country  = (AutoCompleteTextView)findViewById(R.id.regcountry);
        state = (AutoCompleteTextView)findViewById(R.id.regstate);
        city = (AutoCompleteTextView)findViewById(R.id.regcity);
        register = (Button)findViewById(R.id.regsignUp);
        register.setOnClickListener(this);
        reglogin = (TextView)findViewById(R.id.reglogin);
        reglogin.setOnClickListener(this);
        //countrys array.........
        regcountries = getResources().getStringArray(R.array.countries_array);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, regcountries);
        country.setThreshold(1);
        //Set adapter to AutoCompleteTextView
        country.setAdapter(adapter);
        country.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long rowId) {
                Contrys = (String)parent.getItemAtPosition(position);
                //TODO Do something with the selected text
            }
        });
        //states array .........
        regstates = getResources().getStringArray(R.array.states);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, regstates);
        state.setThreshold(1);
        //Set adapter to AutoCompleteTextView
        state.setAdapter(adapter);
        state.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long rowId) {
                States = (String)parent.getItemAtPosition(position);
                //TODO Do something with the selected text
            }
        });
        //cities array..............
        regcitys = getResources().getStringArray(R.array.india_top_places);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, regcitys);
        city.setThreshold(1);
        //Set adapter to AutoCompleteTextView
        city.setAdapter(adapter);
        city.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long rowId) {
                Citys = (String)parent.getItemAtPosition(position);
                //TODO Do something with the selected text
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.regsignUp:
                String regusername = username.getText().toString();
                String regemail = email.getText().toString();
                String regmobile = mobile.getText().toString();
                String regpin = pin.getText().toString();
                String regconpin = conpin.getText().toString();
                String regpincode = pincode.getText().toString();
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }

                if( regusername.length() == 0) {
                alert.showAlertDialog(RegisterActivity.this,"Enter Username",false);
                }
                else if( regemail.length() == 0) {
                    alert.showAlertDialog(RegisterActivity.this,"Enter Email",false);
                }
                else if( regmobile.length() == 0) {
                    alert.showAlertDialog(RegisterActivity.this,"Enter Mobile Number",false);
                }
                else if( regpin.length() == 0) {
                    alert.showAlertDialog(RegisterActivity.this,"Enter Pin number",false);
                }
                else if(!cd.isNetworkOn(getApplicationContext())){
                    alert.showAlertDialog(RegisterActivity.this,"There is Network error",false);
                }
                else if(regconpin!=regpin){
                    alert.showAlertDialog(RegisterActivity.this,"Pin And Confirm Pin Are Not Same",false);
                }
                else {
                    //signIn(loginmobile,loginpin);
                }
                break;
            case R.id.reglogin:
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
