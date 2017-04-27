package com.example.daniel.discovermovies_2;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.daniel.discovermovies_2.api.SearchService;
import com.example.daniel.discovermovies_2.model.Result;
import com.example.daniel.discovermovies_2.model.SearchModel;
import com.example.daniel.discovermovies_2.utils.RecyclerViewListener;
import com.example.daniel.discovermovies_2.utils.SearchAdapter;
import com.example.daniel.discovermovies_2.utils.SearchConstants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    private Button searchBtn;
    private Button submitBtn;
    private RelativeLayout mRelative;
    private LinearLayoutManager linearManager;
    private RecyclerView recyclerView;
    private SearchAdapter adapter;
    private SearchService searchService;
    private EditText searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchBtn = (Button) findViewById(R.id.start_search);
        searchBtn.setOnClickListener(this);
        submitBtn = (Button) findViewById(R.id.submit_search);
        submitBtn.setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.mReciclerVw);
        searchText = (EditText) findViewById(R.id.search_field);

        mRelative = (RelativeLayout) findViewById(R.id.mRelativeLay);

        linearManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.start_search) {
            Log.d(TAG, "onClick: start");
            searchBtn.setVisibility(View.GONE);
            mRelative.setVisibility(View.VISIBLE);
        } 
        if (view.getId() == R.id.submit_search) {
            //TODO: put here the things for the recycler view
            Log.d(TAG, "onClick: submit" );

            if (networkCheck()) {
                Call<SearchModel> call = searchService.getSearch(getString(R.string.my_api_key),
                        searchText.getText().toString());
                call.enqueue(new Callback<SearchModel>() {
                    @Override
                    public void onResponse(Call<SearchModel> call, Response<SearchModel> response) {
                        SearchModel searchModel = response.body();
                        linearManager = new LinearLayoutManager(getApplicationContext());
                        linearManager.setOrientation(LinearLayoutManager.VERTICAL);
                        recyclerView.setLayoutManager(linearManager);
                        adapter = new SearchAdapter(searchModel.getResults(), getApplicationContext());
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<SearchModel> call, Throwable t) {

                    }
                });
            }


        }
    }

    private boolean networkCheck() {
        boolean isConnected = false;
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork != null) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                isConnected = true;
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                isConnected = true;
            }
        }

        return isConnected;
    }
}
