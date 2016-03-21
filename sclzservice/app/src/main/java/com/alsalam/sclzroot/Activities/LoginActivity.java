package com.alsalam.sclzroot.Activities;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alsalam.sclzroot.PushNotifHandler;
import com.alsalam.sclzroot.TableManager.EventTbl;
import com.alsalam.sclzroot.TableManager.UserTbl;
import com.example.sclzservice.R;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.microsoft.windowsazure.notifications.NotificationsManager;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
   private TextView tvemail,tvPass;
    private EditText et_MAIL,et_Pass;
    private Button btnSign,btnFacebook,btnGoogle,btnRegister, btnUpload;
    private String connectionString;

    private MobileServiceClient mClient;
    private MobileServiceTable<UserTbl> msUsersTbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        connectionString = "DefaultEndpointsProtocol=https;AccountName=asalami4g;AccountKey=R1AMsy/aGGBIMwCsGfqtX/04eEiRVPZaWCedgp7yyHQum8Y1mzfFhwBonaTcL1b32mxXsxUSmrvFyZnQN6tk9g==;BlobEndpoint=https://asalami4g.blob.core.windows.net/;TableEndpoint=https://asalami4g.table.core.windows.net/;QueueEndpoint=https://asalami4g.queue.core.windows.net/;FileEndpoint=https://asalami4g.file.core.windows.net/";

    //    tvemail=(TextView)findViewById(R.id.tvemail);// "Email Or Username"

        et_MAIL=(EditText)findViewById(R.id.et_MAIL);// writing an email
        et_Pass=(EditText)findViewById(R.id.et_PASS);// password
        btnSign=(Button)findViewById(R.id.btnSign);// Sing in button
        btnFacebook=(Button)findViewById(R.id.btnFacebook);// Sing in with facebook button
        btnGoogle=(Button)findViewById(R.id.btnGoogle);// Sing in with Google+ button
        btnRegister=(Button)findViewById(R.id.btnRegister);// Sing in button
        //btnUpload=(Button)findViewById(R.id.btnUpload);// Sing in button

        btnRegister.setOnClickListener(this);
        btnSign.setOnClickListener(this);
        //btnUpload.setOnClickListener(this);
        NotificationsManager.handleNotifications(this, "488253055244", PushNotifHandler.class);


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

    public void userLogin(final String userName, final String userPassword) throws ExecutionException, InterruptedException {
        try {
            mClient = new MobileServiceClient(
                    "https://sclzservice.azurewebsites.net",
                    this);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        msUsersTbl = mClient.getTable(UserTbl.class);
        final List<UserTbl> results = msUsersTbl.where().field("userName").eq(userName).and().field("userPassword").eq(userPassword).execute().get();
        results.toString();
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
                break;
            case R.id.btnFacebook:
                try {
                    userLogin("waelabedelal", "123123");
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;

        }

    }
}
