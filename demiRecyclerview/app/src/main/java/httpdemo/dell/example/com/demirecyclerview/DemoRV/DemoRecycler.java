package httpdemo.dell.example.com.demirecyclerview.DemoRV;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;

import httpdemo.dell.example.com.demirecyclerview.R;

public class DemoRecycler extends Activity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<String> myDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_recycler);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        myDataset = new ArrayList<String>();
        myDataset.add("abc");
        myDataset.add("xyz");
        myDataset.add("abc");
        myDataset.add("abc");
        myDataset.add("xyz");
        myDataset.add("abc");
        myDataset.add("abc");
        myDataset.add("xyz");
        myDataset.add("abc");
        myDataset.add("abc");
        myDataset.add("xyz");
        myDataset.add("abc");
        myDataset.add("xyz");
        myDataset.add("abc");
        myDataset.add("xyz");
        myDataset.add("abc");
        myDataset.add("xyz");
        myDataset.add("abc");
        myDataset.add("xyz");
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new myAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

    }
}
