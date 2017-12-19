package httpdemo.dell.example.com.demosugerorm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import httpdemo.dell.example.com.demosugerorm.model.note;

import static android.R.attr.id;
import static httpdemo.dell.example.com.demosugerorm.R.attr.title;
import static httpdemo.dell.example.com.demosugerorm.R.id.time;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //note note = note.findById(note.class, id);
        //note.title = "updated title here";
        //note.save();

    }

    public  void create(){
       // note notee = new note(title, note, time);
       // notee.save();
    }
}
