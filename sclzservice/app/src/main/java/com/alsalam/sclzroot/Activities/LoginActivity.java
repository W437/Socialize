package com.alsalam.sclzroot.Activities;

import android.app.Activity;
import android.app.AlertDialog;
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

import com.alsalam.sclzroot.PushNotifHandler;
import com.alsalam.sclzroot.TableManager.EventTbl;
import com.alsalam.sclzroot.TableManager.UserTbl;
import com.example.sclzservice.R;
import com.facebook.FacebookSdk;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.MobileServiceException;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.table.TableQueryCallback;
import com.microsoft.windowsazure.notifications.NotificationsManager;

import java.net.MalformedURLException;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
   private TextView tvemail,tvPass;
    private EditText et_MAIL,et_Pass;
    private Button btnSign,btnFacebook,btnGoogle,btnRegister;

    /**
     * Mobile Service Client reference
     */
    private MobileServiceClient mClient;

    /**
     * Mobile Service Table used to access data
     */

    private MobileServiceTable<UserTbl> msUsertTbl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getBaseContext());
        setContentView(R.layout.activity_login);
        try {

            mClient = new MobileServiceClient(
                    "https://sclzservice.azurewebsites.net",
                    this);

            if(msUsertTbl==null)
                msUsertTbl = mClient.getTable(UserTbl.class);
            //initLocalStore().get();


            // Create an adapter to bind the items with the view


            // Load the items from the Mobile Service
            //refreshItemsFromTable();

        } catch (MalformedURLException e) {
            e.printStackTrace();

        }

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
//                startActivity(new Intent(getBaseContext(), MainHomeActivity.class));
                msUsertTbl.where().field("userName").eq(et_MAIL.getText().toString()).and().field("userPassword").eq(et_Pass.getText().toString()).execute(new TableQueryCallback<UserTbl>() {
                    @Override
                    public void onCompleted(List<UserTbl> result, int count, Exception exception, ServiceFilterResponse response) {
                        if (result.size() > 0) {
                            startActivity(new Intent(getBaseContext(), MainHomeActivity.class));
                            createAndShowDialog("user and pass OKKKK", "");
                        } else {
                            createAndShowDialog("user or pass error", "");

                        }
                    }
                });
                //                    if(checkSignin(et_MAIL.getText().toString(),et_Pass.getText().toString())!=null) {
//                        startActivity(new Intent(getBaseContext(), MainHomeActivity.class));
//                        createAndShowDialog("user or pass word error","");
//
//                    }
//                    else
//                    createAndShowDialog("user or pass word error","");

        }

    }
    /**
     * Refresh the list with the items in the Table
     * OKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK
     * check the sign in and retrun user if found ot null if not
     */
    public UserTbl checkSignin(final String user, final String password) {
        final UserTbl[] userTbl = {null};
        AsyncTask<Void, Void, List<UserTbl>> task = new AsyncTask<Void,Void,List<UserTbl>>(){
            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected List<UserTbl> doInBackground(Void... params) {

                try {
                    final List<UserTbl> results = msUsertTbl.where().field("userName").eq(user).and().field("userPassword").eq(password).execute().get();


                    ///final List<EventTbl> results = msEnetTbl.where().field("status").eq(EventTbl.ACCEPTED).execute().get();
                    ///final List<EventTbl> results = msEnetTbl.where().field("status").eq(EventTbl.ACCEPTED).execute().get();

                    //Offline Sync
                    return results;
                } catch (final Exception e){
                    e.printStackTrace();
                    createAndShowDialogFromTask(e, "Error");
                }

                return null;
            }

            @Override
            protected void onPostExecute(List<UserTbl> listRes) {
                if(listRes!=null && listRes.size()>0)
                    userTbl[0] = listRes.get(0);
//                for (EventTbl item : results) {
//                    mAdapter.add(item);
//
//                }

            }
        };
        task.execute();
        // runAsyncTask(task);
        return userTbl[0];
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
     * @param exception
     *            The exception to show in the dialog
     * @param title
     *            The dialog title
     */
    private void createAndShowDialog(Exception exception, String title) {
        Throwable ex = exception;
        if(exception.getCause() != null){
            ex = exception.getCause();
        }
        createAndShowDialog(ex.getMessage(), title);
    }
    /**
     *
     * @param message
     *            The dialog message
     * @param title
     *            The dialog title
     */
    private void createAndShowDialog(final String message, final String title) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(message);
        builder.setTitle(title);
        builder.create().show();
    }

}
