package com.shumilov.vladislav.asynctaskloaderprogressbar;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class ProgressLoader extends AsyncTaskLoader<Integer> {

    public ProgressLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public Integer loadInBackground() {
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            Log.d(ProgressLoader.class.getCanonicalName(), e.getMessage());
        }

        return 1;
    }
}