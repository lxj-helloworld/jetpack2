package com.example.roomstruc;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * 项目名称 jetpack
 * 创建人 xiaojinli
 * 创建时间 2020/7/1 10:33 AM
 **/
public class StudentViewModel extends AndroidViewModel {
    StudentRepository studentRepository;

    public StudentViewModel(@NonNull Application application) {
        super(application);
        this.studentRepository = new StudentRepository(application);
    }


    void insert(Student... students){
        studentRepository.insert(students);
    }


    void delete(Student student){
        studentRepository.delete(student);
    }


    void update(Student student){
        studentRepository.update(student);
    }


    List<Student> getAll(){
        return studentRepository.getAll();
    }


    LiveData<List<Student>> getAllLiveDataStudents(){
        return studentRepository.getAllLiveDataStudents();
    }
}
