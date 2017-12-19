package httpdemo.dell.example.com.demirecyclerview.helperclass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.ParcelUuid;

import static android.R.attr.id;
import static android.R.attr.theme;

/**
 * Created by DELL on 10/9/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="STD.db";
    public static final String TABLE_NAME ="Student_table";

    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="SUR_NAME";
    public static final String COL_4="MARKS";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //to create table
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_NAME + " (" +
                COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_2 + " TEXT," +
                COL_3 + " TEXT," +
                COL_4 + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        this.onCreate(sqLiteDatabase);
    }

    //to insert values in table
    public boolean insertData(String name,String sur_name,String marks){

        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,sur_name);
        contentValues.put(COL_4,marks);

        //query to create db
        SQLiteDatabase db=this.getWritableDatabase();

        long result=db.insert(TABLE_NAME,null,contentValues);
        db.close();

        if (result==-1){
            return false;
        }else {
            return true;
        }
    }


    public Cursor getAllData(){
        //query to create db
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("Select * from "+TABLE_NAME,null);
        return res;
    }
    //to update values in table
    public boolean updateeData(String id,String name,String sur_name,String marks){

        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,sur_name);
        contentValues.put(COL_4,marks);

        //query to create db
        SQLiteDatabase db=this.getWritableDatabase();

        int result=db.update(TABLE_NAME,contentValues,COL_1+" = ?",new String[]{id});
        db.close();

        if (result>0){
            return true;
        }else {
            return false;
        }
    }

    public Integer deletData(String id){
        //query to create db
        SQLiteDatabase db=this.getWritableDatabase();

        int result=db.delete(TABLE_NAME,COL_1+" =?",new String[]{id});
        return result;
    }


}

