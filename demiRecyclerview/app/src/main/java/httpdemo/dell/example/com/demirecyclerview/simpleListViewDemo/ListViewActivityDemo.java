package httpdemo.dell.example.com.demirecyclerview.simpleListViewDemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import httpdemo.dell.example.com.demirecyclerview.MainActivity;
import httpdemo.dell.example.com.demirecyclerview.R;

public class ListViewActivityDemo extends AppCompatActivity {
//simple Listview Demo

    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);
mListView=(ListView)findViewById(R.id.listview);

        final String[] data={
                "choclate","pizza","cookies","zinger","choclate","pizza","cookies","zinger",
                "choclate","pizza","cookies","zinger","choclate","pizza","cookies","zinger"
                ,"choclate","pizza","cookies","zinger","choclate","pizza","cookies","zinger"
        };


        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        mListView.setAdapter(arrayAdapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),data[i],Toast.LENGTH_SHORT).show();
            }
        });
    }
}
