package com.example.room;

import android.graphics.Paint;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import javax.xml.namespace.QName;

/**
 * 项目名称 jetpack
 * 创建人 xiaojinli
 * 创建时间 2020/6/30 4:52 PM
 *
 * 数据访问对象，操作表
 * 依赖注解
 *
 **/


@Dao
public interface StudentDao {

    //插入一条数据
    @Insert
    public void insert(Student student);

    //插入多条数据
    @Insert
    public void insert(Student... students);

    //删除
    @Delete
    public void delete(Student student);

    //更新修改
    @Update
    public void update(Student student);

    //查询
    @Query("select * from Student")
    public List<Student> getAll();

    //条件查询，变量在冒号处替换
    @Query("select * from Student where name like :name")
    public Student queryByName(String name);

    //条件查询
    @Query("select * from Student where uid in (:uids)")
    public List<Student> queryByUids(int[] uids);

    //返回部分字段
    @Query("select name,password from Student")
    public List<StudentRecord> getRecord();


}
