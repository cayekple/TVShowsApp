package com.cayekple.tvshowsapp.repositories;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.cayekple.tvshowsapp.network.ApiClient;
import com.cayekple.tvshowsapp.network.ApiService;
import com.cayekple.tvshowsapp.responses.TVShowsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MostPopularTVShowsRepository {

    private ApiService mApiService;

    public MostPopularTVShowsRepository(){
        mApiService = ApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<TVShowsResponse> getMostPopularTVShows(int page){
        MutableLiveData<TVShowsResponse> data = new MutableLiveData<>();
        mApiService.getMostPopularTVShows(page).enqueue(new Callback<TVShowsResponse>() {
            @Override
            public void onResponse(@NonNull Call<TVShowsResponse> call, @Nullable Response<TVShowsResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<TVShowsResponse> call, @Nullable Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

}
