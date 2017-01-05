package com.murali.hariprahlad.bhagavathgita.activitys;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.murali.hariprahlad.bhagavathgita.R;
import com.murali.hariprahlad.bhagavathgita.Services.ConnectionDetector;
import com.murali.hariprahlad.bhagavathgita.model.AlertDialogManager;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private Toolbar toolbar;
    private EditText mobile,pin;
    private Button login;
    private TextView logreg;
    AlertDialogManager alert = new AlertDialogManager();
    ConnectionDetector cd;
    public String LOGIN_URL = "http://127.0.0.1:8080/login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //cd = new ConnectionDetector(LoginActivity.this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.YELLOW);

        mobile = (EditText)findViewById(R.id.loginmobile);
        pin = (EditText)findViewById(R.id.loginpin);
        login = (Button) findViewById(R.id.loginSignin);
        login.setOnClickListener(this);
        logreg = (TextView)findViewById(R.id.loginreg);
        logreg.setOnClickListener(this);
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();

            //moveTaskToBack(false);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void exitByBackKey() {

        AlertDialog alertbox = new AlertDialog.Builder(this,R.style.MyAlertDialogStyle)
                .setMessage("Do you want to exit application?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                        finish();
                        //close();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface dialog, int arg1) {
                        dialog.dismiss();
                    }
                })
                .show();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loginSignin:
                String loginmobile = mobile.getText().toString();
                String loginpin = pin.getText().toString();
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }

//                if( loginmobile.length() == 0) {
//                    alert.showAlertDialog(LoginActivity.this,"Enter Phone Number",false);
//                }
//                else if(loginmobile.length()>10|| loginmobile.length()<10){
//                    alert.showAlertDialog(LoginActivity.this,"Enter corect Phone Number",false);
//                }
//                else if(loginpin.length() == 0){
//                    alert.showAlertDialog(LoginActivity.this,"Enter PinNum Number",false);
//                }
//                else if(loginpin.length()>4|| loginpin.length()<4){
//                    alert.showAlertDialog(LoginActivity.this,"Enter Correct PinNum Number",false);
//                }
//                else if(!cd.isNetworkOn(getApplicationContext())){
//                    alert.showAlertDialog(LoginActivity.this,"There is Network error",false);
//                }
//                else {
//                    //signIn(loginmobile,loginpin);
//                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.loginreg:
                Intent intent1 = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent1);
                break;
            case android.R.id.home:
                this.onBackPressed();
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                default:
        }
    }

    private void signIn(String loginmobile, String loginpin) {
        Ion.with(getApplicationContext())
                .load("POST",LOGIN_URL)
                .setMultipartParameter("mobile",loginmobile)
                .setMultipartParameter("pin",loginpin)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                        //Toast.makeText(LoginActivity.this, result, Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
