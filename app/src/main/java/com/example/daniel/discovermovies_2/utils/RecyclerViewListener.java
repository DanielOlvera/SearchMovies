package com.example.daniel.discovermovies_2.utils;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Daniel on 4/27/17.
 */

/*
This class is created to add more item movies to the recyclerview
on demand
 */
public abstract class RecyclerViewListener extends RecyclerView.OnScrollListener{

    LinearLayoutManager layoutManager;

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int visibleItemCount = layoutManager.getChildCount();
        int totalItemCount = layoutManager.getItemCount();
        int firstItemPosition = layoutManager.findFirstVisibleItemPosition();

        if (!isLoading() && !isLastPage()){
            if ((visibleItemCount + firstItemPosition) >= totalItemCount ){
                loadMoreItems();
            }
        }
    }

    protected abstract void loadMoreItems();

    protected abstract boolean isLastPage();

    protected abstract boolean isLoading();

    public abstract int getTotalPageCount();
}
