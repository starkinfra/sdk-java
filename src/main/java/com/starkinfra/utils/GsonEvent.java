package com.starkinfra.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.starkinfra.Event;


class GsonEvent {
     private static Gson instance;

     private GsonEvent() {}

     public static synchronized Gson getInstance()
     {
         if(instance == null)
             instance = new GsonBuilder()
                     .registerTypeAdapter(Event.class, new Event.Deserializer())
                     .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ")
                     .create();
         return instance;
     }
}
