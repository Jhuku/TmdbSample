package com.shuvam.themoviedb.api;

import com.shuvam.themoviedb.model.NowPlayingMovieResponse;
import com.shuvam.themoviedb.model.UpcomingMovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Shuvam Ghosh on 2/1/2017.
 */

public interface ApiInterface {

    @GET("movie/upcoming")
    Call<UpcomingMovieResponse> getUpcomingMovies(@Query("api_key") String apiKey);

    @GET("movie/now_playing")
    Call<NowPlayingMovieResponse> getNowPlayingMovies(@Query("api_key") String apiKey);
}
