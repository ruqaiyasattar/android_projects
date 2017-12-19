package httpdemo.dell.example.com.demosqlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import httpdemo.dell.example.com.demosqlite.recyclerv.student;

/**
 * Created by DELL on 11/9/2017.
 */

public class helperclass extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MY_STUDENTS.db";
    private static final int VERSION = 2;

    public helperclass(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS stdent(id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(50),age VARCHAR(50),course VARCHAR(50))");
    }
    public  void delstu(int id){
        String[] args = new String[]{
                String.valueOf(id)
        };
        getWritableDatabase().delete("stdent","id = ?",args);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long addstudent(String name, int age, String course) {
        SQLiteDatabase bd = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("age", age);
        contentValues.put("course", course);
        return bd.insert("stdent", null, contentValues);
    }

    public long editstudent(student student) {
        SQLiteDatabase bd = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", student.getName());
        contentValues.put("age", student.getAge());
        contentValues.put("course", student.getCourse());
        return bd.update("stdent",contentValues,"id =?",new String[]{String.valueOf(student.getId())});
    }

    public ArrayList<student> getStudents() {
        ArrayList<student> students = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query("stdent", new String[]{"name", "age", "course","id"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int idColumnIndex = cursor.getColumnIndex("id");
            int id = cursor.getInt(idColumnIndex);
            int namecolumIndex = cursor.getColumnIndex("name");
            String name = cursor.getString(namecolumIndex);
            int agecolumIndex = cursor.getColumnIndex("age");
            int age = cursor.getInt(agecolumIndex);
            int coursecolumIndex = cursor.getColumnIndex("course");
            String course = cursor.getString(coursecolumIndex);
            students.add(new student(name, age, course,id));
        }
        cursor.close();
        return students;
    }


}
