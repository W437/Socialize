package com.alsalam.sclzroot.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.alsalam.sclzroot.R;
import com.alsalam.sclzroot.SampleSlide;
import com.alsalam.sclzroot.TableManager.DataBaseMngr;
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class IntroActivity extends AppIntro {


    private ImageView banner;

    private static final String []PERMISSIONS={
            android.Manifest.permission.READ_CONTACTS,
            android.Manifest.permission.READ_PHONE_STATE,
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.GET_ACCOUNTS,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.WAKE_LOCK
    };
    private static final String rationalTitle="Permission Rational";
    private static final String rationalMessage="Permissions needed to use this app ";


    @Override
    public void init(Bundle savedInstanceState) {

        //banner = (ImageView)findViewById(R.id.socializeBanner);
        //banner.setScaleType(ImageView.ScaleType.FIT_XY);
        if(DataBaseMngr.getLogedUserName(getBaseContext())!=null)
        {
            loadMainActivity();
        }
        else {
            showStatusBar(false);
            setProgressIndicator();
            setIndicatorColor(Color.parseColor("#ffffff"), Color.parseColor("#9E9E9E"));
            addSlide(AppIntroFragment.newInstance("Welcome to Socialize.", "Meeting people and organizing events made fun.", R.drawable.sclzlogo, Color.parseColor("#F44336")));
            addSlide(AppIntroFragment.newInstance("Your Events and Others', all organised!", "Meet people around you and have fun together.", R.drawable.organised, Color.parseColor("#F44336")));
            addSlide(AppIntroFragment.newInstance("Endless Fun.", "With the variety of events to choose from, you'll always be entertained!", R.drawable.happy, Color.parseColor("#F44336")));
            addSlide(AppIntroFragment.newInstance("Socialize Yourself in One Click.", "With just a few clicks, you can find a suitable event to participate in, near you.", R.drawable.connected, Color.parseColor("#F44336")));
            addSlide(AppIntroFragment.newInstance("Everything and Anything.", "Whether it's a football game, a good-deeds-day, a meeting session to discuss relevant daily stuff with people from different cultures, you can find anything!", R.drawable.everything, Color.parseColor("#F44336")));
            addSlide(AppIntroFragment.newInstance("You are all set. Enjoy Socialize.", "Take a minute to register and get started.", R.drawable.ready, Color.parseColor("#F44336")));
            // OPTIONAL METHODS
            // Override bar/separator color.
            //setBarColor(Color.parseColor("#D32F2F"));
            //setSeparatorColor(Color.parseColor("#ffffff"));
            // Hide Skip/Done button.
            askForPermissions(PERMISSIONS,5);

            showSkipButton(false);
            setProgressButtonEnabled(true);
            //setVibrate(true);
            //setVibrateIntensity(30);
        }
    }

    private void loadMainActivity(){
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }

    @Override
    public void onSkipPressed() {

    }

    @Override
    public void onNextPressed() {

    }

    @Override
    public void onDonePressed() {
        loadMainActivity();
    }

    @Override
    public void onSlideChanged() {

    }

}
