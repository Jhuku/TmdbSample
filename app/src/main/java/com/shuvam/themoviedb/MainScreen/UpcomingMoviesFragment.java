package com.shuvam.themoviedb.MainScreen;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ProgressBar;

import com.shuvam.themoviedb.R;
import com.shuvam.themoviedb.api.ApiClient;
import com.shuvam.themoviedb.api.ApiInterface;
import com.shuvam.themoviedb.model.UpcomingMovieResponse;
import java.util.Arrays;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Shuvam Ghosh on 9/5/2017.
 */

public class UpcomingMoviesFragment extends Fragment {

    private static final String API_KEY = "a2e97cbcacb4ba38135a1b29ddc67ac7";
    private static final String TAG = "UpcomingFragment Log";
    RecyclerView recViewUpcomingMovies;
    ProgressBar progressBar;
    MyAdapter adapter;
    StaggeredGridLayoutManager gridLayoutManager ;
    private int flag =1;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.upcoming_movies_fragment,container,false);
        init(v);
        makeRequest();
        setinit();
        return v;
    }

    private void setinit() {

        recViewUpcomingMovies.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                     //   view.animate().alpha(0.5f).setDuration(1000).start();
                       // view.findViewById(R.id.flt_back_ground).animate().scaleYBy(-100f).setDuration(1000).start();



                        // TODO Handle item click
                    }
                })
        );
    }

    private void init(View v) {

        gridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        gridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        recViewUpcomingMovies = v.findViewById(R.id.rec_view_upcoming);
        progressBar = v.findViewById(R.id.prb_progress_bar_upcoming);

        recViewUpcomingMovies.setHasFixedSize(true);
        recViewUpcomingMovies.setItemViewCacheSize(20);
        recViewUpcomingMovies.setDrawingCacheEnabled(true);
        recViewUpcomingMovies.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

    }

    private void makeRequest() {
        progressBar.setVisibility(View.VISIBLE);

        final ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<UpcomingMovieResponse> call = apiService.getUpcomingMovies(API_KEY);
        call.enqueue(new Callback<UpcomingMovieResponse>() {
            @Override
            public void onResponse(Call<UpcomingMovieResponse> call, Response<UpcomingMovieResponse> response) {

                Log.d(TAG,"Response"+response.body().getRes());
                adapter = new MyAdapter(getActivity(),Arrays.asList(response.body().getRes()),recViewUpcomingMovies);
                recViewUpcomingMovies.setLayoutManager(gridLayoutManager);
                recViewUpcomingMovies.setAdapter(adapter);
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<UpcomingMovieResponse> call, Throwable t) {
                Log.e(TAG,t.toString());
            }
        });
    }
}