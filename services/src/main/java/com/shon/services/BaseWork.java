package com.shon.services;

import android.os.Handler;
import android.os.Looper;

public abstract class BaseWork implements IWork, IEvent {

    private final Handler handler;
    public BaseWork(){
        handler = new Handler(Looper.getMainLooper());
    }
    @Override
    public void onDestroy() {

    }


    protected void postMain(Runnable runnable){
        handler.post(runnable);
    }
    protected void postMainDelayed(long delayed,Runnable runnable){
        handler.postDelayed(runnable,delayed);
    }
}
