package com.shon.services;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Event {

    private final int key;
    @Nullable
    private Object value;

    public Event(int key) {
        this.key = key;
    }

    public Event(int key, @NonNull Object value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    @Nullable
    public Object getValue() {
        return value;
    }


    @NonNull
    @Override
    public String toString() {
        return "Event{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
