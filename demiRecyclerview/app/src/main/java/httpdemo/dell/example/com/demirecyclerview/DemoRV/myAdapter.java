package httpdemo.dell.example.com.demirecyclerview.DemoRV;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

import httpdemo.dell.example.com.demirecyclerview.R;

/**
 * Created by DELL on 10/16/2017.
 */

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder> {
    private ArrayList<String> mDataset;

public class ViewHolder extends RecyclerView.ViewHolder{

    public TextView txtHeader;
    public TextView txtFooter;

    public ViewHolder(View v) {
        super(v);
        txtHeader = (TextView) v.findViewById(R.id.secline);
        txtFooter = (TextView) v.findViewById(R.id.firstline);
    }
}
public void add(int position,String item){
    mDataset.add(position,item);
    notifyItemInserted(position);
}
    public void remove(String item){
        int Position=mDataset.indexOf(item);
        mDataset.remove(Position);
        notifyItemRemoved(Position);
    }

    public myAdapter(ArrayList<String> dataset) {
        mDataset = dataset;
    }

    @Override
    public myAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.demo_item,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(myAdapter.ViewHolder holder, int position) {

        final String name=mDataset.get(position);
        holder.txtHeader.setText(""+position);
        holder.txtFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove(name);
            }
        });
        holder.txtFooter.setText("Footer :"+ mDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
