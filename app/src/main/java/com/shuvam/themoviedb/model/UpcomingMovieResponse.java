package com.shuvam.themoviedb.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Shuvam Ghosh on 9/5/2017.
 */

public class UpcomingMovieResponse {

    @SerializedName("results")
    UpcomingResult [] res;

    public UpcomingResult[] getRes() {
        return res;
    }

    public void setRes(UpcomingResult[] res) {
        this.res = res;
    }

    public class UpcomingResult {

        @SerializedName("id")
        String id;

        @SerializedName("title")
        String title;

        @SerializedName("poster_path")
        String poster_path;

        @SerializedName("overview")
        String overview;

        public String getId() {
            return id;
        }





        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }


    }
}
