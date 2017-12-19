package httpdemo.dell.example.com.demirecyclerview.codepath_rv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import httpdemo.dell.example.com.demirecyclerview.R;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class Main_Activitycodepath extends AppCompatActivity {
    ArrayList<Contact> contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__activitycodepath);

        // Lookup the recyclerview in activity layout
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.myrvcp);

        // Initialize contacts
        contacts = Contact.createContactsList(100);
        // Create adapter passing in the sample user data
        ContactsAdapter adapter = new ContactsAdapter(this, contacts);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);

        // record this value before making any changes to the existing list
        int curSize = adapter.getItemCount();

// replace this line with wherever you get new records
        ArrayList<Contact> newItems = Contact.createContactsList(20);

// update the existing list
        contacts.addAll(newItems);
// curSize should represent the first element that got added
// newItems.size() represents the itemCount
        adapter.notifyItemRangeInserted(curSize, newItems.size());

        // Set layout manager to position the items
        //for horizontal linear layout
       // rvContacts.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

// Optionally customize the position you want to default scroll to
        rvContacts.scrollToPosition(0);
        // That's all!
// First param is number of columns and second param is orientation i.e Vertical or Horizontal
       // StaggeredGridLayoutManager gridLayoutManager =
         //       new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
// Attach the layout manager to the recycler view
        rvContacts.setLayoutManager(layoutManager);
        adapter.notifyItemInserted(0);
        rvContacts.setHasFixedSize(true);
        rvContacts.scrollToPosition(0);
        adapter.notifyItemInserted(contacts.size() - 1);  // contacts.size() - 1 is the last element position
        rvContacts.scrollToPosition(adapter.getItemCount() - 1); // update based on adapter
rvContacts.setItemAnimator(new SlideInUpAnimator());

        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvContacts.addItemDecoration(itemDecoration);



           }
}
