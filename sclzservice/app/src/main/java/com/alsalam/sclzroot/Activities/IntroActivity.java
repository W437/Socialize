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
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class IntroActivity extends AppIntro {


    private ImageView banner;



    @Override
    public void init(Bundle savedInstanceState) {

        //banner = (ImageView)findViewById(R.id.socializeBanner);
        //banner.setScaleType(ImageView.ScaleType.FIT_XY);
        showStatusBar(false);
        setProgressIndicator();
        setIndicatorColor(Color.parseColor("#ffffff"), Color.parseColor("#9E9E9E") );
        // Instead of fragments, you can also use our default slide
        // Just set a title, description, background and image. AppIntro will do the rest.
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
        showSkipButton(false);
        setProgressButtonEnabled(true);



        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permisssion in Manifest.
        //setVibrate(true);
        //setVibrateIntensity(30);
    }

    private void loadMainActivity(){
        Intent intent = new Intent(this, LoginActivity.class);
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
