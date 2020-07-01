package com.example.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

/**
 * 项目名称 jetpack
 * 创建人 xiaojinli
 * 创建时间 2020/6/30 6:50 PM
 **/

@Entity
public class StudentRecord {
    @ColumnInfo(name = "name")
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ColumnInfo(name = "password")
    public String password;

    @Override
    public String toString() {
        return "StudentRecord{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
