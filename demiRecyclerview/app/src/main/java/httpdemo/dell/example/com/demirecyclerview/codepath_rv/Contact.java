package httpdemo.dell.example.com.demirecyclerview.codepath_rv;

import java.util.ArrayList;

/**
 * Created by DELL on 10/17/2017.
 */

public class Contact {
    private String mName;
    private boolean mOnline;
    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Contact(String name, boolean online) {
        mName = name;
        mOnline = online;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public boolean isOnline() {
        return mOnline;
    }

    public void setOnline(boolean online) {
        mOnline = online;
    }

    private static int lastContactId = 0;

    public static ArrayList<Contact> createContactsList(int numContacts) {
        ArrayList<Contact> contacts = new ArrayList<Contact>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new Contact("Person " + ++lastContactId, i <= numContacts / 2));
        }

        return contacts;
    }
}
