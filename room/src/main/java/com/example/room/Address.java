package com.example.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * 项目名称 jetpack
 * 创建人 xiaojinli
 * 创建时间 2020/6/30 6:56 PM
 **/
@Entity
public class Address {
    @PrimaryKey(autoGenerate = true)
    private int addressId;

    @ColumnInfo(name = "name")
    private String name;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", name='" + name + '\'' +
                '}';
    }
}
