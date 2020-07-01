package com.example.roomstruc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.roomstruc.adapter.GoodsAdapter;

import java.util.List;

public class JetPackStructureActivity extends AppCompatActivity {

    private StudentViewModel studentViewModel;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jet_pack_structure);
        listView = findViewById(R.id.listView);

        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);
        LiveData<List<Student>> listLiveData = studentViewModel.getAllLiveDataStudents();
        if(listLiveData != null){
            listLiveData.observe(this, new Observer<List<Student>>() {
                @Override
                public void onChanged(List<Student> students) {
                    listView.setAdapter(new GoodsAdapter(JetPackStructureActivity.this,students));
                }
            });
        }else{
            Toast.makeText(this,"数据为空",Toast.LENGTH_LONG).show();
        }

        for(int i=0;i<50;i++){
            studentViewModel.insert(new Student("name " + i,"password " + i,i));
        }
    }
}
