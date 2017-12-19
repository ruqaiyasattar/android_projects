package httpdemo.dell.example.com.demosugerorm.model;

import com.orm.SugarRecord;

/**
 * Created by DELL on 10/7/2017.
 */

public class note extends SugarRecord {

    String title, note;
    long time;

    public note() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
