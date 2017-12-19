package httpdemo.dell.example.com.demosqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import httpdemo.dell.example.com.demosqlite.database.helperclass;
import httpdemo.dell.example.com.demosqlite.recyclerv.StudentClickListner;
import httpdemo.dell.example.com.demosqlite.recyclerv.adapter;
import httpdemo.dell.example.com.demosqlite.recyclerv.student;

public class MainActivity extends AppCompatActivity {
    public static EditText Name, Age, Course;
    public static RecyclerView show_data;
    public static Button add, rev_iew;
    adapter adaptr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        widget();
        final helperclass hepler = new helperclass(MainActivity.this);
        final ArrayList<student> students = new ArrayList<>();
        //for delet
        adaptr = new adapter(students, new StudentClickListner() {
            @Override
            public void onitemclick(student v,int position) {
                hepler.delstu(v.getId());
                students.remove(position);
                adaptr.notifyDataSetChanged();
            }
            @Override
            public void onitemupdate(student v,int position) {
                String name = Name.getText().toString();
                int age = Integer.parseInt(Age.getText().toString());
                String course = Course.getText().toString();
                v.setName(Name.getText().toString());
                v.setAge(age);
                v.setCourse(course);
                hepler.editstudent(v);
                students.set(position,v);
                adaptr.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "data updated", Toast.LENGTH_SHORT).show();

            }
        });
                show_data.setAdapter(adaptr);
        show_data.setLayoutManager(new LinearLayoutManager(this));
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = Name.getText().toString();
                int age = Integer.parseInt(String.valueOf(Age.getText().toString()));
                String course = Course.getText().toString();
                long id = hepler.addstudent(name, age, course);
            }
        });

        rev_iew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<student> sts = hepler.getStudents();
                Log.e("STudents Count",String.valueOf(sts.size()));
                students.clear();
                students.addAll(sts);
                adaptr.notifyDataSetChanged();

            }
        });
    }

    public void widget() {
        Name = findViewById(R.id.name);
        Age = findViewById(R.id.age);
        Course = findViewById(R.id.couse);
        show_data = findViewById(R.id.show);
        add = findViewById(R.id.add);
        rev_iew = findViewById(R.id.review);
    }
}
