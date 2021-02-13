package com.shon.workservices;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.shon.services.BaseWork;
import com.shon.services.Event;

import org.jetbrains.annotations.NotNull;

public class TestWork2 extends BaseWork {
    private final String TAG = "TestWork2";

    private Context context;
    @Override
    public void onStart(@NotNull Context context) {

        this.context = context;
        Log.i(TAG, "onStart()" + Thread.currentThread().getName());
    }

    @Override
    public void onEvent(@NonNull Event event) {
        Log.i(TAG, "onStart()" + event.toString());
        postMain(() -> Toast.makeText(context,"收到消息："+event.getKey()+" ; ",Toast.LENGTH_SHORT).show());
    }
}
