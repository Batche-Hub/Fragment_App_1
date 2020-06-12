package com.example.fragmentapplication2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.example.fragmentapplication2.FirstFragment;
import com.example.fragmentapplication2.SecondFragment;
import com.example.fragmentapplication2.SectionsPagerAdapter;

import com.google.android.material.tabs.TabLayout;
public class MainActivity extends AppCompatActivity implements FirstFragment.OnFragmentCommunicationListener, ThirdFragment.OnFragmentCommunicationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        SectionsPagerAdapter sectionsPagerAdapter =  new SectionsPagerAdapter(this, getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);


        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);



    }

    @Override public void onNameChange(String name) {
        String tag = "android:switcher:" + R.id.view_pager + ":" + 1;
        SecondFragment fragment = (SecondFragment) getSupportFragmentManager().findFragmentByTag(tag);
        if (fragment != null) {
            fragment.onNameChange(name);
        }
    }

    @Override public void onEmailChange(String email) {
        String tag = "android:switcher:" + R.id.view_pager + ":" + 1;
        SecondFragment fragment = (SecondFragment) getSupportFragmentManager().findFragmentByTag(tag);
        if (fragment != null) {
            fragment.onEmailChange(email);
        }
    }

    @Override
    public void onAgeChange(String age) {
        String tag = "android:switcher:" + R.id.view_pager + ":" + 2;
        ThirdFragment fragment = (ThirdFragment) getSupportFragmentManager().findFragmentByTag(tag);
        if(fragment!= null){
            fragment.onAgeChange(age);
        }
    }

    public void onTitleChange(String titre){
        String tag = "android:switcher:" + R.id.view_pager + ":" + 2;
        ThirdFragment fragment = (ThirdFragment) getSupportFragmentManager().findFragmentByTag(tag);
        if(fragment!= null){
            fragment.onTitleChange(titre);
        }
    }
}