package com.example.roomstruc;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * 项目名称 jetpack
 * 创建人 xiaojinli
 * 创建时间 2020/7/1 10:17 AM
 *
 * 数据仓库，生命API供ViewModel调用
 **/

public class StudentRepository {

    private LiveData<List<Student>> liveDataAllStudent;
    private StudentDao studentDao;

    public StudentRepository(Context context) {
        //获取数据库对象
        AppDataBase appDataBase = AppDataBase.getAppDataBase(context);
        //获取DAO对象
        studentDao = appDataBase.studentDao();
        //初始化livedata数据
        liveDataAllStudent = studentDao.getAllLiveDataStudents();

    }

    /**
     * 提供API供ViewModel使用
     * @param students
     */
    void insert(Student... students){
        studentDao.insert(students);
    }


    void delete(Student student){
        studentDao.delete(student);
    }


    void update(Student student){
        studentDao.update(student);
    }


    List<Student> getAll(){
        return studentDao.getAll();
    }


    LiveData<List<Student>> getAllLiveDataStudents(){
        return studentDao.getAllLiveDataStudents();
    }
}
