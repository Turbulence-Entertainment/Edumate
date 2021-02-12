package com.pro.gurushiksha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Profession extends AppCompatActivity {

    ImageView student,parent,teacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profession);

        student=findViewById(R.id.stu_image);
        parent=findViewById(R.id.parent_image);
        teacher=findViewById(R.id.teacher_ima);

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Profession.this,MainActivity.class);
                intent.putExtra("pro","Student Login");
                startActivity(intent);

            }
        });
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Profession.this,MainActivity.class);
                intent.putExtra("pro","Parent Login");
                startActivity(intent);

            }
        });
        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Profession.this,MainActivity.class);
                intent.putExtra("pro","Teacher Login");
                startActivity(intent);
            }
        });


    }
}
