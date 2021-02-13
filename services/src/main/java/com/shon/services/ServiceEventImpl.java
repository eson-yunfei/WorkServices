package com.shon.services;

import android.os.Handler;
import android.os.HandlerThread;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

 class ServiceEventImpl {

    private final List<IEvent> iEvents;
     private final Handler handler;

    ServiceEventImpl(){
        iEvents = new ArrayList<>();
        HandlerThread handlerThread = new HandlerThread("ServiceEventImpl");
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper());
    }

    public void sendEvent(@NonNull Event event){
        if (iEvents.isEmpty()){
            return;
        }
        handler.post(() -> {
            for (IEvent iEvent : iEvents) {
                iEvent.onEvent(event);
            }
        });

    }

     void addIEvent(@NonNull IEvent iEvent){

        if (iEvents.contains(iEvent)){
            return;
        }
        iEvents.add(iEvent);
    }
     void removeIEvent(@NonNull IEvent iEvent){
        iEvents.remove(iEvent);
    }
}
