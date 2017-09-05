package com.shuvam.themoviedb.MainScreen;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shuvam.themoviedb.R;

/**
 * Created by Shuvam Ghosh on 9/5/2017.
 */

public class NowPlayingMoviesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.now_playing_movies_fragment,container,false);
        init(v);
        return v;
    }

    private void init(View v) {
    }
}
