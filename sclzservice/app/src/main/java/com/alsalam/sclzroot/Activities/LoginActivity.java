package com.alsalam.sclzroot.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alsalam.sclzroot.PushNotifHandler;
import com.example.sclzservice.R;
import com.facebook.FacebookSdk;
import com.microsoft.windowsazure.notifications.NotificationsManager;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
   private TextView tvemail,tvPass;
    private EditText et_MAIL,et_Pass;
    private Button btnSign,btnFacebook,btnGoogle,btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getBaseContext());
        setContentView(R.layout.activity_login);

    //    tvemail=(TextView)findViewById(R.id.tvemail);// "Email Or Username"

        et_MAIL=(EditText)findViewById(R.id.et_MAIL);// writing an email
        et_Pass=(EditText)findViewById(R.id.et_PASS);// password
        btnSign=(Button)findViewById(R.id.btnSign);// Sing in button
        btnFacebook=(Button)findViewById(R.id.btnFacebook);// Sing in with facebook button
        btnGoogle=(Button)findViewById(R.id.btnGoogle);// Sing in with Google+ button
        btnRegister=(Button)findViewById(R.id.btnRegister);// Sing in button

        btnRegister.setOnClickListener(this);
        btnSign.setOnClickListener(this);

       // NotificationsManager.handleNotifications(this, "488253055244", PushNotifHandler.class);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnRegister:
                startActivity(new Intent(getBaseContext(), RegisterActivity.class));
                break;
            case R.id.btnSign:
                if(true) {
                    startActivity(new Intent(getBaseContext(), MainHomeActivity.class));
                }
        }

    }

}
