package com.shon.services;

import android.content.Context;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;


public interface IWork {
    @WorkerThread
    void onStart(@NonNull Context context);

    @MainThread
    void onDestroy();
}
