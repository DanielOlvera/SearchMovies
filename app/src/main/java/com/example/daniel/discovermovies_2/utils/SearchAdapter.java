package com.example.daniel.discovermovies_2.utils;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.daniel.discovermovies_2.model.Result;

import java.util.ArrayList;

/**
 * Created by Daniel on 4/27/17.
 */

public class SearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private boolean isLoadingAdded = false;
    private ArrayList<Result> searchResult;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
