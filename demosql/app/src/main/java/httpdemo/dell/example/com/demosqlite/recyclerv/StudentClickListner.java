package httpdemo.dell.example.com.demosqlite.recyclerv;

import android.content.DialogInterface;
import android.view.View;

/**
 * Created by DELL on 11/9/2017.
 */

public interface StudentClickListner {
    public void onitemclick(student v,int position);
    public void onitemupdate(student v,int position);

}
