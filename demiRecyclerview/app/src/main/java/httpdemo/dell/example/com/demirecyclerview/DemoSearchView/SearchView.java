package httpdemo.dell.example.com.demirecyclerview.DemoSearchView;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import httpdemo.dell.example.com.demirecyclerview.R;

class SearchViewdemo extends AppCompatActivity implements SearchView.OnQueryTextListener {

    ListView mListView;
    SearchView mSearchView;
    ArrayAdapter<String> arrayAdapter;
    String[] data={"laptop","pc","mobile","computer","ipad","iopd"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_search_view);
        mListView=(ListView)findViewById(R.id.lvsearch);
        mSearchView=(SearchView)findViewById(R.id.find);

        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        mListView.setAdapter(arrayAdapter);
        mSearchView.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        String text=newText;
        arrayAdapter.getFilter().filter(newText);

        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
