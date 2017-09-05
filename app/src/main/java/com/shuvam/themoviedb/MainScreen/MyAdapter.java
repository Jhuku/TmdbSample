package com.shuvam.themoviedb.MainScreen;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shuvam.themoviedb.R;
import com.shuvam.themoviedb.model.UpcomingMovieResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * A custom adapter to use with the RecyclerView widget.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    List<UpcomingMovieResponse.UpcomingResult> upcomingResults;
    private RecyclerViewAnimator mAnimator;
    private Context context;
    private String baseImg ="https://image.tmdb.org/t/p/w500/";

    public MyAdapter(Context context,List<UpcomingMovieResponse.UpcomingResult> upcomingResults, RecyclerView recView) {
        this.upcomingResults = upcomingResults;
        this.mAnimator = new RecyclerViewAnimator(recView);
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        holder.imgv = view.findViewById(R.id.imv_movie_image);
        holder.tvMovieName = view.findViewById(R.id.lbl_movie_name);
        mAnimator.onCreateViewHolder(view);

        holder.flt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder itemViewHolder, int position) {


        ViewHolder vh = itemViewHolder;
        UpcomingMovieResponse.UpcomingResult item = upcomingResults.get(position);
        vh.tvMovieName.setText(upcomingResults.get(position).getTitle());
        vh.tvMovieDesc.setText(upcomingResults.get(position).getOverview());
        Picasso.with(context).load(baseImg+item.getPoster_path()).into(vh.imgv);
        mAnimator.onBindViewHolder(vh.itemView, position);
    }

    @Override
    public int getItemCount() {

        return upcomingResults.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvMovieName;
        ImageView imgv;
        FrameLayout flt;
        TextView tvMovieDesc;
        int flag = 1;
        public ViewHolder(final View itemView) {
            super(itemView);
            flt = itemView.findViewById(R.id.flt_back_ground);
            tvMovieName = itemView.findViewById(R.id.lbl_movie_name);
            imgv = itemView.findViewById(R.id.imv_movie_image);
            tvMovieDesc = itemView.findViewById(R.id.lbl_desc_movie);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    float rat = view.getHeight()/view.findViewById(R.id.lbl_movie_name).getHeight();
                    if(flag == 1) {
                        Animation anim = new ScaleAnimation(
                                1f, 1f, // Start and end values for the X axis scaling
                                1f, rat, // Start and end values for the Y axis scaling
                                Animation.RELATIVE_TO_SELF, 0f, // Pivot point of X scaling
                                Animation.RELATIVE_TO_SELF, 1f); // Pivot point of Y scaling
                        anim.setFillAfter(true); // Needed to keep the result of the animation
                        anim.setDuration(320);
                        anim.setInterpolator(new AccelerateDecelerateInterpolator());
                        itemView.findViewById(R.id.flt_back_ground).startAnimation(anim);
                        itemView.findViewById(R.id.lbl_desc_movie).animate().alpha(1f).setDuration(500).start();
                        itemView.findViewById(R.id.lbl_movie_name).animate().alpha(0f).setDuration(500).start();
                        flag=flag*-1;
                    }
                    else
                    {
                        Animation anim = new ScaleAnimation(
                                1f, 1f, // Start and end values for the X axis scaling
                                rat, 1f, // Start and end values for the Y axis scaling
                                Animation.RELATIVE_TO_SELF, 0f, // Pivot point of X scaling
                                Animation.RELATIVE_TO_SELF, 1f); // Pivot point of Y scaling
                        anim.setFillAfter(true); // Needed to keep the result of the animation
                        anim.setDuration(320);
                        anim.setInterpolator(new AccelerateDecelerateInterpolator());
                        itemView.findViewById(R.id.flt_back_ground).startAnimation(anim);
                        itemView.findViewById(R.id.lbl_desc_movie).animate().alpha(0f).setDuration(500).start();
                        itemView.findViewById(R.id.lbl_movie_name).animate().alpha(1f).setDuration(500).start();
                        flag=flag*-1;
                    }

                }
            });

        }
    }


}
