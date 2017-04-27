package com.example.daniel.discovermovies_2;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    private Button searchBtn;
    private Button submitBtn;
    private RelativeLayout mRelative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchBtn = (Button) findViewById(R.id.start_search);
        searchBtn.setOnClickListener(this);
        submitBtn = (Button) findViewById(R.id.submit_search);
        submitBtn.setOnClickListener(this);

        mRelative = (RelativeLayout) findViewById(R.id.mRelativeLay);
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

        }
    }
}
