package httpdemo.dell.example.com.demirecyclerview.CustomListView;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import httpdemo.dell.example.com.demirecyclerview.R;

public class listviewcustom extends AppCompatActivity {

//custom Adapter

    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listviewcustom);
mListView=(ListView)findViewById(R.id.custmlv);

        String[] title={"one","two","three","four"};
        String[] description={"this is one","this is two","this is three","this is four"};
        int[] images={
                R.drawable.one,
                R.drawable.two,
                R.drawable.three,
                R.drawable.four,
        };



       MycustumAdqapter adapter=new MycustumAdqapter(this,title,description,images);
       mListView.setAdapter(adapter);

    }


    class MycustumAdqapter extends ArrayAdapter {


        String[] title;
        String[] desc;
        int[] image;

        public MycustumAdqapter(@NonNull Context context, String[] title, String[] desc, int[] image) {
            super(context, R.layout.custom_listv,R.id.title,title);
            this.title = title;
            this.desc = desc;
            this.image = image;
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           View row=inflater.inflate(R.layout.custom_listv,parent,false);
            ImageView img=(ImageView)row.findViewById(R.id.img);
            TextView tittle=(TextView)row.findViewById(R.id.data);
            TextView descc=(TextView)row.findViewById(R.id.dec);

            img.setImageResource(image[position]);
            tittle.setText(title[position]);
            descc.setText(desc[position]);

            return row;
        }
    }}









