package com.example.roomstruc;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * 项目名称 jetpack
 * 创建人 xiaojinli
 * 创建时间 2020/7/1 9:57 AM
 **/
@Dao
public interface StudentDao {
    @Insert
    void insert(Student... students);

    @Delete
    void delete(Student student);

    @Update
    void update(Student student);

    @Query("select * from Student")
    List<Student> getAll();

    //将查询到的内容用LiveData封装，使数据具有可观察性
    @Query("select * from Student order by uid")
    LiveData<List<Student>> getAllLiveDataStudents();
}
