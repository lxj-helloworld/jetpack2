package com.example.jetpack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.room.RoomActivity;
import com.example.roomstruc.JetPackStructureActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View view) {
        switch (view.getId()){
            case R.id.room_btn:
                Intent intent = new Intent(MainActivity.this, RoomActivity.class);
                startActivity(intent);
                break;
            case R.id.structure_btn:
                Intent intent1 = new Intent(MainActivity.this, JetPackStructureActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
