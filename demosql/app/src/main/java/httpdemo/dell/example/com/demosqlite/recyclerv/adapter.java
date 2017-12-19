package httpdemo.dell.example.com.demosqlite.recyclerv;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import httpdemo.dell.example.com.demosqlite.R;
import httpdemo.dell.example.com.demosqlite.database.helperclass;

/**
 * Created by DELL on 11/9/2017.
 */

public class adapter extends RecyclerView.Adapter<viewholder> {

    ArrayList<student> mStudents;
    StudentClickListner mStudentClickListner;

    public adapter(ArrayList<student> students, StudentClickListner studentClickListner) {
        mStudents = students;
        mStudentClickListner = studentClickListner;
    }




    @Override
    public viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(viewholder holder, final int position) {
        final student student = mStudents.get(position);

        holder.Show_name.setText(student.getName());
        holder.Show_age.setText(String.valueOf(student.getAge()));
        holder.Show_course.setText(student.getCourse());
        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               mStudentClickListner.onitemclick(student,position);
            }
        });
        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStudentClickListner.onitemupdate(student,position);
            }
        });

    }
    @Override
    public int getItemCount() {
        return mStudents.size();
    }

}
