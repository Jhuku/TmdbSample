package com.shuvam.themoviedb.MainScreen;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.shuvam.themoviedb.R;

/**
 * Created by Shuvam Ghosh on 9/5/2017.
 */

public class MainScreenActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    MainScreenPresenterImp mainScreenPresenterImp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout)findViewById(R.id.tbl_tab_layout);
        viewPager = (ViewPager)findViewById(R.id.vpg_view_pager);
        mainScreenPresenterImp = new MainScreenPresenterImp();
        mainScreenPresenterImp.initializeViewPager(viewPager);
        SimpleFragmentPagerAdapter simpleFragmentPagerAdapter = new SimpleFragmentPagerAdapter(this,getSupportFragmentManager());
        viewPager.setAdapter(simpleFragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}

