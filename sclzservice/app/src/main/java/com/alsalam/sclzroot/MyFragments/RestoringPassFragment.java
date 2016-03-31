package com.alsalam.sclzroot.MyFragments;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alsalam.sclzroot.Activities.MainpageActivity;
import com.alsalam.sclzroot.R;
import com.alsalam.sclzroot.TableManager.DataBaseMngr;
import com.alsalam.sclzroot.TableManager.UserTbl;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.table.TableQueryCallback;

import java.net.MalformedURLException;
import java.util.List;

public class RestoringPassFragment extends DialogFragment implements View.OnClickListener
{
  private EditText et_EnterKEY;
  private TextView tv_YourPassword;
  private Button btn_Check;
  private Button btn_Ok;



    /**
     * Mobile Service Client reference
     */
    private MobileServiceClient mClient;

    /**
     * Mobile Service Table used to access data
     */


    private MobileServiceTable<UserTbl> msUsertTbl;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_restoring_pass, container, false);
        init(view);

        return  view;
    }

    private void init(View view)
    {

        et_EnterKEY=(EditText)view.findViewById(R.id.et_EnterKEY);
        tv_YourPassword=(TextView)view.findViewById(R.id.tv_YourPassword);
        btn_Check=(Button)view.findViewById(R.id.btn_Check);
        btn_Ok=(Button)view.findViewById(R.id.btn_Ok);

        btn_Check.setOnClickListener(this);
        btn_Ok.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
         switch (v.getId()){
             case R.id.btn_Check:
                 try {
                     mClient = new MobileServiceClient("https://sclzservice.azurewebsites.net",getContext());
                 MobileServiceTable<UserTbl> msUsertTbl = mClient.getTable(UserTbl.class);
                 msUsertTbl.where().field("restoringKey").eq(et_EnterKEY.getText().toString()).execute(new TableQueryCallback<UserTbl>() {
                     @Override
                     public void onCompleted(List<UserTbl> result, int count, Exception exception, ServiceFilterResponse response) {


                         if (result != null && result.size() > 0) {

                             tv_YourPassword.setText(DataBaseMngr.getLogedUserPassword(getContext()));

                         } else {

                             Toast.makeText(getContext(),"Key Not Found",Toast.LENGTH_LONG).show();
                         }
                     }

                 });
                 } catch (MalformedURLException e) {
                     e.printStackTrace();
                 }
                       break;
             case R.id.btn_Ok:
                 dismiss();
                 break;
         }

    }
}
