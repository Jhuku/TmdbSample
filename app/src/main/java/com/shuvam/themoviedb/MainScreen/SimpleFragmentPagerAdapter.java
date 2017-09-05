package com.shuvam.themoviedb.MainScreen;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.shuvam.themoviedb.R;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

        private Context mContext;
        public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
            super(fm);
            mContext = context;
        }
        // This determines the fragment for each tab
        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new UpcomingMoviesFragment();
            } else {
                return new NowPlayingMoviesFragment();
            }
        }
        // This determines the number of tabs
        // This determines the title for each tab
        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            switch (position) {
                case 0:
                    return mContext.getString(R.string.now_playing_moview);
                case 1:
                    return mContext.getString(R.string.upcoming_movies);
                default:
                    return "Apple";
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }