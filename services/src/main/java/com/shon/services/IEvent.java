package com.shon.services;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;

interface IEvent {

    @WorkerThread
    void onEvent(@NonNull Event event);
}
