package com.shon.services;

public class ServiceEvent {
    private static final ServiceEventImpl serviceEvent = new ServiceEventImpl();
    public static void sendEvent(int key){
        sendEvent(new Event(key));
    }

    public static void sendEvent(Event event){
        serviceEvent.sendEvent(event);
    }

     static void addObserver(IEvent iEvent){
        serviceEvent.addIEvent(iEvent);
    }
}
