package com.shon.services.annotation;

import android.app.Service;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef(value = {
        Service.START_STICKY_COMPATIBILITY,
        Service.START_STICKY,
        Service.START_NOT_STICKY,
        Service.START_REDELIVER_INTENT,
})
@Retention(RetentionPolicy.CLASS)
public @interface StartCommand { }
