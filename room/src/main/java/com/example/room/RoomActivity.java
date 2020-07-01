package com.example.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class RoomActivity extends AppCompatActivity {

    private String TAG = "RoomActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        //数据库的操作，尽量在子线程操作
        DbThread dbThread = new DbThread();
        dbThread.start();
    }


    class DbThread extends Thread{
        @Override
        public void run() {
            super.run();

            //数据库操作在这里进行
            //初始化数据库对象
            AppDataBase appDataBase = Room.databaseBuilder(getApplicationContext(),
                    AppDataBase.class,
                    "firstRoom").build();
            //初始化数据访问对象
            StudentDao studentDao = appDataBase.studentDao();
            //数据插入操作
            studentDao.insert(new Student("this is name1","this is password1",1));
            studentDao.insert(new Student("this is name2","this is password2",2));
            studentDao.insert(new Student("this is name3","this is password3",3));
            studentDao.insert(new Student("this is name4","this is password4",4));

            //数据查询操作
            List<Student> students = studentDao.getAll();
            Log.i(TAG,"当前总数据： " + students.size() + "   " + students.toString());


            //条件查询
            Student student = studentDao.queryByName("this is name2");
            Log.i(TAG,"student = " + student.toString());
            //条件查询
            List<Student> students1 = studentDao.queryByUids(new int[]{2,3,4});
            Log.i(TAG,"条件查询： " + students1.size() + "   " + students1.toString());

            ///查询返回部分字段
            List<StudentRecord> studentRecords = studentDao.getRecord();
            Log.i(TAG,"条件查询返回部分结果： " + studentRecords.size() + "   " + studentRecords.toString());
        }
    }
}
