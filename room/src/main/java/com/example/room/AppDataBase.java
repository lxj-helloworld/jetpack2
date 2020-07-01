package com.example.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * 项目名称 jetpack
 * 创建人 xiaojinli
 * 创建时间 2020/6/30 4:57 PM
 **/

@Database(entities = {Student.class,Address.class} , version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract StudentDao studentDao();
}
