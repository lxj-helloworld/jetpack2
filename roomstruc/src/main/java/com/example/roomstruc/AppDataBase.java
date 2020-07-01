package com.example.roomstruc;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * 项目名称 jetpack
 * 创建人 xiaojinli
 * 创建时间 2020/7/1 10:19 AM
 **/
@Database(entities = {Student.class},version = 1,exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase appDataBase;

    public abstract StudentDao studentDao();

    public static synchronized AppDataBase getAppDataBase(Context context){
        if(appDataBase == null){
            appDataBase = Room.databaseBuilder(context.getApplicationContext(),AppDataBase.class,"StrucDB")
                    //可以强制在主线程进行操作
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return appDataBase;
    }

}
