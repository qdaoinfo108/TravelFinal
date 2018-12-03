package com.traveltotal.ltmobile.travelfinal;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import static com.traveltotal.ltmobile.travelfinal.R.*;

public class home_first extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    //khai bao fragment
    private Location_fragment location_fragment;
    private food_fragment food_fragment;
    private person_fragment person_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_home);

        // tao doi tuong
        mMainNav = (BottomNavigationView) findViewById(id.main_nav);
        mMainFrame = (FrameLayout) findViewById(id.main_frame);

        location_fragment = new Location_fragment();
        food_fragment = new food_fragment();
        person_fragment = new person_fragment();
        // thay doi mau khi bam vao nav
        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case id.nav_home:
                        mMainNav.setItemBackgroundResource(color.colorDarkWhile);
                        return true;
                    case id.nav_location:
                        mMainNav.setItemBackgroundResource(color.colorPrimary);
                        setFragment(location_fragment);
                        return true;
                    case id.nav_food:
                        mMainNav.setItemBackgroundResource(color.colorBlack);
                        //setFragment
                        setFragment(food_fragment);
                        return true;
                    case id.nav_trans:
                        mMainNav.setItemBackgroundResource(color.colorBlack);
                        //setFragment
                        return true;
                    case id.nav_person:
                        mMainNav.setItemBackgroundResource(color.colorPrimaryDark);
                        setFragment(person_fragment);
                        return true;

                    default:
                        return false;
                }
            }
        });


    }


    // module fragment
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(id.main_frame, fragment);
        fragmentTransaction.commit();
    }
}
