package httpdemo.dell.example.com.demirecyclerview;

import android.database.Cursor;
import android.support.annotation.BoolRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import httpdemo.dell.example.com.demirecyclerview.helperclass.DataBaseHelper;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper myDB=new DataBaseHelper(this);
    EditText id,name,surname,marks;
    Button insert;

    TextView vname,vsurname,vmarks;
    Button vinsert,updte,delt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id=(EditText)findViewById(R.id.id);
        name=(EditText)findViewById(R.id.name);
        surname=(EditText)findViewById(R.id.sname);
        marks=(EditText)findViewById(R.id.marks);
        insert=(Button) findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Clickme();
            }
        });
        updte=(Button)findViewById(R.id.update);
        updte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Update();
            }
        });
        delt=(Button)findViewById(R.id.delee);
        delt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delet();
            }
        });


        vname=(TextView)findViewById(R.id.vname);
        vsurname=(TextView)findViewById(R.id.vsname);
        vmarks=(TextView)findViewById(R.id.vmarks);
        vinsert=(Button) findViewById(R.id.view);
        vinsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewdata();
            }
        });
    }

    private void viewdata() {
        Cursor res=myDB.getAllData();
        StringBuffer stringbuffer=new StringBuffer();
        if (res !=null && res.getCount()>0){
            while (res.moveToNext()){
                stringbuffer.append("Id: "+res.getString(0)+"\n");
                stringbuffer.append("Name: "+res.getString(1)+"\n"+"\n");
                stringbuffer.append("Surname: "+res.getString(2)+"\n"+"\n"+"\n");
                stringbuffer.append("Marks: "+res.getString(3)+"\n"+"\n"+"\n"+"\n");
            }
            vname.setText(stringbuffer.toString());
            Toast.makeText(MainActivity.this,"Data read",Toast.LENGTH_SHORT).show();
        }else {

            Toast.makeText(MainActivity.this,"No Data read!",Toast.LENGTH_SHORT).show();
        }
    }

    private void Clickme() {
        String Name=name.getText().toString();
        String sname=surname.getText().toString();
        String Marks=marks.getText().toString();
        Boolean result=myDB.insertData(Name,sname,Marks);
        if (result==true){
            Toast.makeText(MainActivity.this,"Data inserted",Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(MainActivity.this,"Data is not inserted",Toast.LENGTH_SHORT).show();

        }

    }

    private void Update() {
        String Id=id.getText().toString();
        String Name=name.getText().toString();
        String sname=surname.getText().toString();
        String Marks=marks.getText().toString();
        Boolean result=myDB.updateeData(Id,Name,sname,Marks);
        if (result==true){
            Toast.makeText(MainActivity.this,"Data Updated",Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(MainActivity.this,"Data is not Updated",Toast.LENGTH_SHORT).show();

        }
    }

    private void delet() {
        String Name=name.getText().toString();
        int result=myDB.deletData(Name);
        Toast.makeText(MainActivity.this,result+" row effected ",Toast.LENGTH_SHORT).show();

    }
}
