package com.example.daniel.discovermovies_2.utils;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daniel.discovermovies_2.R;
import com.example.daniel.discovermovies_2.model.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 4/27/17.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.RecyclerVwHldr>{

    List<Result> searchResult;
    Context context;

    public SearchAdapter(List<Result> searchResult, Context context) {
        this.searchResult = searchResult;
        this.context = context;
    }

    @Override
    public RecyclerVwHldr onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        RecyclerVwHldr viewHolder = new RecyclerVwHldr(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerVwHldr holder, int position) {
        holder.movieName.setText(searchResult.get(position).getOriginalTitle());
    }

    @Override
    public int getItemCount() {
        return searchResult.size();
    }

    public class RecyclerVwHldr extends RecyclerView.ViewHolder{

        TextView movieName;

        public RecyclerVwHldr(View itemView) {
            super(itemView);
            movieName = (TextView) itemView.findViewById(R.id.movie_name);
        }
    }
}
