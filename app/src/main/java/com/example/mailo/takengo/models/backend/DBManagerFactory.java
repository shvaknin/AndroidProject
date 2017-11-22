package com.example.mailo.takengo.models.backend;
import com.example.mailo.takengo.models.datasourses.Lists;

/**
 * class which implements the interface IDBManager.
 * Created by USER on 19/11/2017.
 */

public class DBManagerFactory {
    static IDBManager manager=null;
    public static IDBManager getManager(){
        if (manager==null)
            manager=new Lists();
        return manager;

    }
}