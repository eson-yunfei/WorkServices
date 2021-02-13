package com.shon.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.shon.services.annotation.StartCommand;
import com.shon.services.annotation.Works;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseServices<T> extends Service {

    private final List<IWork> iWorkList = new ArrayList<>();
    private T service;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        service = (T) this;
        new Thread(() -> {
            try {
                initWorkList(service);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return createNotification(intent, flags, startId);
    }

    @StartCommand
    public abstract int createNotification(Intent intent, int flags, int startId);
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        for (IWork iWork : iWorkList) {
            iWork.onDestroy();
        }
    }

    private void initWorkList(Object services) throws Exception {
        Class<?> service = services.getClass();
        Works works = service.getAnnotation(Works.class);
        if (works == null) {
            return;
        }
        Class<? >[] iWorkClass = works.value();
        for (Class<?> workClass : iWorkClass) {
            Object iWork = workClass.newInstance();
            if (iWork instanceof IWork) {
                iWorkList.add((IWork) iWork);
            }
            if (iWork instanceof IEvent){
                ServiceEvent.addObserver((IEvent) iWork);
            }
        }
        for (IWork iWork : iWorkList) {
            iWork.onStart(getApplicationContext());
        }
    }

}
