package com.cayekple.tvshowsapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cayekple.tvshowsapp.repositories.MostPopularTVShowsRepository;
import com.cayekple.tvshowsapp.responses.TVShowsResponse;

public class MostPopularTVShowsViewModel extends ViewModel {

    private MostPopularTVShowsRepository mMostPopularTVShowsRepository;

    private MostPopularTVShowsViewModel(){
        mMostPopularTVShowsRepository = new MostPopularTVShowsRepository();
    }

    public LiveData<TVShowsResponse> getMostPopularTVShows(int page){
        return mMostPopularTVShowsRepository.getMostPopularTVShows(page);
    }
}
