package httpdemo.dell.example.com.demosqlite.recyclerv;

import android.support.v7.widget.RecyclerView;
import android.view.TextureView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import httpdemo.dell.example.com.demosqlite.R;

/**
 * Created by DELL on 11/9/2017.
 */

public class viewholder extends RecyclerView.ViewHolder {
    EditText Show_name,Show_age,Show_course;
ImageView mImageView,update;
    public viewholder(View itemView) {
        super(itemView);
        Show_name=(EditText)itemView.findViewById(R.id.show_name);
        Show_age=(EditText)itemView.findViewById(R.id.show_age);
        Show_course=(EditText)itemView.findViewById(R.id.show_course);
        mImageView=(ImageView)itemView.findViewById(R.id.slector);
        update=(ImageView)itemView.findViewById(R.id.slector2);
    }
}
