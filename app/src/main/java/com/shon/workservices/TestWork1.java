package com.shon.workservices;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.shon.services.BaseWork;
import com.shon.services.Event;

import org.jetbrains.annotations.NotNull;

public class TestWork1 extends BaseWork {
    private final String TAG = "TestWork1";

    @Override
    public void onStart(@NotNull Context context) {
        Log.i(TAG, "onStart()" + Thread.currentThread().getName());
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy()" + Thread.currentThread().getName());
    }

    @Override
    public void onEvent(@NonNull Event event) {
        Log.i(TAG, "onEvent()" +event.toString());
    }
}
