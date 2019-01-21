package com.shumilov.vladislav.asynctaskloaderprogressbar;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Integer> {

    private Button mStartProgressButton;
    private ProgressBar mProgressBar;
    private TextView mProgressText;
    private static final int LOADER_ID = 111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStartProgressButton = findViewById(R.id.btnStartProgress);
        mProgressBar = findViewById(R.id.progressBar);
        mProgressText = findViewById(R.id.tvProgress);

        Bundle bndl = new Bundle();
        getLoaderManager().initLoader(LOADER_ID, bndl, this).forceLoad();
    }

    @Override
    protected void onStart() {
        super.onStart();

        mProgressBar.setVisibility(ProgressBar.GONE);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mStartProgressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public Loader<Integer> onCreateLoader(int id, Bundle args) {
        Loader<Integer> loader = null;

        if (id == LOADER_ID) {
            loader = new ProgressLoader(this);

            mProgressBar.setVisibility(View.VISIBLE);
            mStartProgressButton.setEnabled(false);
            mProgressText.setText(R.string.loading);
        }

        return loader;
    }

    @Override
    public void onLoadFinished(Loader<Integer> loader, Integer data) {
        mProgressBar.setVisibility(View.GONE);
        mStartProgressButton.setEnabled(true);
        mProgressText.setText(R.string.ready);
    }

    @Override
    public void onLoaderReset(Loader<Integer> loader) {
        int k = 0;
        k = k + 1;
    }
}
