package com.example.roomstruc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.roomstruc.R;
import com.example.roomstruc.Student;

import java.util.List;
import java.util.zip.Inflater;

/**
 * 项目名称 jetpack
 * 创建人 xiaojinli
 * 创建时间 2020/7/1 9:36 AM
 **/
public class GoodsAdapter extends BaseAdapter {
    private LayoutInflater inflater;

    private List<Student> students;

    public GoodsAdapter(Context context, List<Student> students) {
        this.inflater = LayoutInflater.from(context);
        this.students = students;
    }

    public GoodsAdapter() {
        super();
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.item,null);
        Student student = students.get(position);
        TextView textView_id = view.findViewById(R.id.tv_id);
        textView_id.setText(student.getUid()+"");

        TextView textView_name = view.findViewById(R.id.tv_name);
        textView_name.setText(student.getName());

        return view;
    }
}
