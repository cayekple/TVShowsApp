package com.cayekple.tvshowsapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.cayekple.tvshowsapp.R;
import com.cayekple.tvshowsapp.adapters.TVShowsAdapter;
import com.cayekple.tvshowsapp.databinding.ActivityMainBinding;
import com.cayekple.tvshowsapp.models.TVShow;
import com.cayekple.tvshowsapp.viewmodels.MostPopularTVShowsViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mActivityMainBinding;
    private MostPopularTVShowsViewModel mMostPopularTVShowsViewModel;
    private List<TVShow> mTVShows = new ArrayList<>();
    private TVShowsAdapter mTVShowsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        doInitialization();
    }

    private void doInitialization(){
        mActivityMainBinding.tvShowRecyclerView.setHasFixedSize(true);
        mMostPopularTVShowsViewModel = new ViewModelProvider(this).get(MostPopularTVShowsViewModel.class);
        mTVShowsAdapter = new TVShowsAdapter(mTVShows);
        mActivityMainBinding.tvShowRecyclerView.setAdapter(mTVShowsAdapter);
        getMostPopularTVShows();
    }

    private void getMostPopularTVShows(){
        mActivityMainBinding.setIsLoading(true);
        mMostPopularTVShowsViewModel.getMostPopularTVShows(0).observe(this, mostPopularTVShowsResponse -> {
//            Toast.makeText(getApplicationContext(), "Total Pages: " + mostPopularTVShowsResponse.getTotalPages(), Toast.LENGTH_LONG).show();
            mActivityMainBinding.setIsLoading(false);
            if (mostPopularTVShowsResponse != null){
                if (mostPopularTVShowsResponse.getTVShows() != null){
                    mTVShows.addAll(mostPopularTVShowsResponse.getTVShows());
                    mTVShowsAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}