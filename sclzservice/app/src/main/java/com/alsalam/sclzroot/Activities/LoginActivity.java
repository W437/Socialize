package com.alsalam.sclzroot.Activities;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alsalam.sclzroot.MyFragments.ParticipatorsDialogFragment;
import com.alsalam.sclzroot.MyFragments.RestoringPassFragment;
import com.alsalam.sclzroot.TableManager.DataBaseMngr;
import com.alsalam.sclzroot.TableManager.UserTbl;
import com.alsalam.sclzroot.R;
import com.facebook.FacebookSdk;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.table.TableQueryCallback;
import com.microsoft.windowsazure.notifications.NotificationsManager;

import java.net.MalformedURLException;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    FragmentManager fragmentManager;
    private TextView tvemail, tvPass, forgotPassword;
    private EditText et_MAIL, et_Pass;
    private Button btnSign, btnRegister;
    public static int NOTIFICATION_ID = 1;
    private NotificationManager mNotificationManager;
    //android.support.v4.app.NotificationCompat.Builder builder;
    Context ctx;


    /**
     * Mobile Service Client reference
     */
    private MobileServiceClient mClient;

    /**
     * Mobile Service Table used to access data
     */


    private MobileServiceTable<UserTbl> msUsertTbl;
    private AlertDialog signinDialog;
    private AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(DataBaseMngr.getLogedUserName(getBaseContext())!=null)
        {
            startActivity(new Intent(getBaseContext(), MainpageActivity.class));
            finish();
        }


        setContentView(R.layout.activity_login);
        try {

            mClient = new MobileServiceClient(
                    "https://sclzservice.azurewebsites.net",
                    this);

            if (msUsertTbl == null)
                msUsertTbl = mClient.getTable(UserTbl.class);
            //initLocalStore().get();


            // Create an adapter to bind the items with the view


            // Load the items from the Mobile Service
            //refreshItemsFromTable();

        } catch (MalformedURLException e) {
            e.printStackTrace();

        }


        //    tvemail=(TextView)findViewById(R.id.tvemail);// "Email Or Username"

        et_MAIL = (EditText) findViewById(R.id.et_MAIL);// writing an email
        et_Pass = (EditText) findViewById(R.id.et_PASS);// password
        btnSign = (Button) findViewById(R.id.btnSign);// Sing in button

        btnRegister = (Button) findViewById(R.id.btnRegister);// Sing in button
        forgotPassword=(TextView) findViewById(R.id. btnForgot_Password);
        btnRegister.setOnClickListener(this);
        btnSign.setOnClickListener(this);

        //forgotPassword.setOnClickListener(this);

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRestorePassDialog();
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


    //asd
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRegister:
                startActivity(new Intent(getBaseContext(), RegisterActivity.class));
                finish();
                break;



            case R.id.btnSign:
                if(et_MAIL.getText().toString().length() == 0)
                {
                    et_MAIL.requestFocus();
                    et_MAIL.setError("ENTER YOUR USERNAME OR EMAIL");
                }
                else if(et_Pass.getText().toString().length() == 0)
                {
                    et_Pass.requestFocus();
                    et_Pass.setError("ENTER YOUR PASSWORD");
                }
                else {
                    signinDialog = createAndReturnDialog(getResources().getString(R.string.Wait), getResources().getString(R.string.signing_in));
                    // signinDialog=createAndReturnDialog("wait", "signing_i");
                    signinDialog.setCancelable(false);
                    signinDialog.show();
                    msUsertTbl.where().field("userEmail").eq(et_MAIL.getText().toString()).and().field("userPassword").eq(et_Pass.getText().toString()).execute(new TableQueryCallback<UserTbl>() {
                @Override
                public void onCompleted(List<UserTbl> result, int count, Exception exception, ServiceFilterResponse response) {

                    // it appears for me and error here, ** remember to ask about it
                    if (result!=null && result.size() > 0) {
                        DataBaseMngr.saveLogIn(result.get(0), getBaseContext());
                        signinDialog.dismiss();
                        Intent intent=new Intent(getBaseContext(), MainpageActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        Toast.makeText(getBaseContext(), "WELCOME, " + DataBaseMngr.getLogedFirstName(ctx) + ".", Toast.LENGTH_LONG).show();
                        //    finish();

                    } else {
                        signinDialog.dismiss();
                        createAndShowDialog("EMAIL OR PASSWORD WRONG", "");

                    }
                }
            });
        }



                //                    if(checkSignin(et_MAIL.getText().toString(),et_Pass.getText().toString())!=null) {
//                        startActivity(new Intent(getBaseContext(), MainHomeActivity.class));
//                        createAndShowDialog("user or pass word error","");
//
//                    }
//                    else
//                    createAndShowDialog("user or pass word error","");
        }


    }


//ss
    void showRestorePassDialog(){
        RestoringPassFragment restoringPassFragment =new RestoringPassFragment();
        restoringPassFragment.show(getSupportFragmentManager(),"PPPP");
    }



    private void createAndShowDialogFromTask(final Exception exception, String title) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                createAndShowDialog(exception, "Error");
            }
        });
    }

    /**
     * Creates a dialog and shows it
     *
     * @param exception The exception to show in the dialog
     * @param title     The dialog title
     */
    private void createAndShowDialog(Exception exception, String title) {
        Throwable ex = exception;
        if (exception.getCause() != null) {
            ex = exception.getCause();
        }
        createAndShowDialog(ex.getMessage(), title);
    }

    /**
     * @param message The dialog message
     * @param title   The dialog title
     */
    private void createAndShowDialog(final String message, final String title) {
        if(builder==null)
            builder = new AlertDialog.Builder(this);

        builder.setMessage(message);
        builder.setTitle(title);
       builder.create().show();
    }

    private AlertDialog createAndReturnDialog(final String message, final String title) {
        if(builder==null)
            builder = new AlertDialog.Builder(this);

        builder.setMessage(message);
        builder.setTitle(title);
        return builder.create();
    }
}
