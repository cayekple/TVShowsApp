package com.cayekple.tvshowsapp.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.cayekple.tvshowsapp.R;
import com.cayekple.tvshowsapp.databinding.ItemContainerTvShowBinding;
import com.cayekple.tvshowsapp.models.TVShow;

import java.util.List;

public class TVShowsAdapter extends RecyclerView.Adapter<TVShowsAdapter.TVShowViewHolder>{

    private List<TVShow> mTVShows;
    private LayoutInflater mLayoutInflater;

    public TVShowsAdapter(List<TVShow> tvShows){
        this.mTVShows = tvShows;
    }

    @NonNull
    @Override
    public TVShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mLayoutInflater == null){
            mLayoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemContainerTvShowBinding tvShowBinding = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_container_tv_show, parent, false);
        return new TVShowViewHolder(tvShowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TVShowViewHolder holder, int position) {
        holder.bindTVShow(mTVShows.get(position));
    }

    @Override
    public int getItemCount() {
        return mTVShows.size();
    }


    static class TVShowViewHolder extends RecyclerView.ViewHolder{
        private ItemContainerTvShowBinding mItemContainerTvShowBinding;

        public TVShowViewHolder(ItemContainerTvShowBinding itemContainerTvShowBinding) {
            super(itemContainerTvShowBinding.getRoot());
            this.mItemContainerTvShowBinding = itemContainerTvShowBinding;
        }

        public void bindTVShow(TVShow tvShow){
            mItemContainerTvShowBinding.setTvShow(tvShow);
            mItemContainerTvShowBinding.executePendingBindings();
        }
    }
}
