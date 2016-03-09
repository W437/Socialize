package com.alsalam.sclzroot.Activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.alsalam.sclzroot.MyFragments.AddEventFragment;
import com.alsalam.sclzroot.MyFragments.EventStoriesFragments;
import com.alsalam.sclzroot.MyFragments.MapListFragment;
import com.alsalam.sclzroot.MyFragments.Profile2Fragment;
import com.alsalam.sclzroot.TableManager.EventTbl;
import com.alsalam.sclzroot.TableManager.UserTbl;
import com.example.sclzservice.R;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.table.TableOperationCallback;

import java.net.MalformedURLException;
import java.sql.Date;

public class MainHomeActivity extends AppCompatActivity {
    ViewPager viewPager;
    Fragment[] fragments;
    MyPagerAdatpter myPagerAdatpter;
    TabLayout tabLayout;
    private MobileServiceClient mClient;
    private RadioGroup rgLocation;
    private String location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        viewPager= (ViewPager) findViewById(R.id.homepager);
        tabLayout= (TabLayout) findViewById(R.id.tabs);
        //rgLocation = (RadioGroup) findViewById(R.id.rgLocation);



        //to do
        fragments=new Fragment[4];
        fragments[0]=new MapListFragment();
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_action_map));

        fragments[1]=new Profile2Fragment();
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_action_profile));

        fragments[2]=new AddEventFragment();
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.ic_add_event));

        fragments[3]=new EventStoriesFragments();
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.ic_stories));


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));




        myPagerAdatpter=new MyPagerAdatpter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(myPagerAdatpter);



    }



    private  static class MyPagerAdatpter extends FragmentPagerAdapter
    {
        Fragment[] fragments;
        public MyPagerAdatpter(FragmentManager fm,Fragment[] fragments) {
            super(fm);
            this.fragments=fragments;
        }

        @Override
        public Fragment getItem(int position) {

            return fragments[position];
        }

        @Override
        public int getCount() {
            return null==fragments ? 0:fragments.length;
        }
    }
}
