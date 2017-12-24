package com.example.mailo.takengo.models.backend;
import com.example.mailo.takengo.models.datasourses.Lists;
import com.example.mailo.takengo.models.datasourses.MySQL;

/**
 * class which implements the interface IDBManager.
 * Created by USER on 19/11/2017.
 */

public class DBManagerFactory {
    private static IDBManager manager=null;
    public static IDBManager getManager(){
        if (manager==null)
            manager=new MySQL();
        return manager;

    }
}