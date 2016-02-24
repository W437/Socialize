package com.alsalam.sclzroot.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sclzservice.R;

public class LoginActivity extends Activity {
   private TextView tvemail,tvPass;
    private EditText et_MAIL,et_Pass;
    private Button btnSign,btnFacebook,btnGoogle,btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvemail=(TextView)findViewById(R.id.tvemail);// "Email Or Username"
        tvPass=(TextView)findViewById(R.id.tvPass);// Password
        et_MAIL=(EditText)findViewById(R.id.et_MAIL);// writing an email
        et_Pass=(EditText)findViewById(R.id.et_PASS);// password
        btnSign=(Button)findViewById(R.id.btnSign);// Sing in button
        btnFacebook=(Button)findViewById(R.id.btnFacebook);// Sing in with facebook button
        btnGoogle=(Button)findViewById(R.id.btnGoogle);// Sing in with Google+ button
        btnRegister=(Button)findViewById(R.id.btnRegister);// Sing in button

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
              //  startActivity(intent);// moving to Register Activity to sign up

            }
        });
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
}
