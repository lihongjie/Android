package com.example.datastoredemo.sql;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDBOpenHelper extends SQLiteOpenHelper {

    private SQLiteOpenHelper dbOpenHelper;

    public MyDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                          int version) {
        super(context, name, factory, version);
    }

    @Override
    //数据库第一次创建时被调用
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE person(personid INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(20))");

    }

    //软件版本号发生改变时调用
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//        onCreate(db);
        db.execSQL("ALTER TABLE person ADD phone VARCHAR(12) NULL");
    }

    public void save(Person p) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        db.execSQL("INSERT INTO person(name,phone) values(?,?)",
                new String[]{p.getName(), p.getPhone()});
    }

    public void delete(Integer id) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        db.execSQL("DELETE FROM person WHERE personid = ?",
                new String[]{String.valueOf(id)});
    }

    public void update(Person p) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        db.execSQL("UPDATE person SET name = ?,phone = ? WHERE personid = ?",
                new String[]{p.getName(), p.getPhone(), String.valueOf(p.getId())});
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Person find(Integer id) {
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM person WHERE personid = ?",
                new String[]{id.toString()});
        //存在数据才返回true
        if (cursor.moveToFirst()) {
            int personid = cursor.getInt(cursor.getColumnIndex("personid"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));
            return new Person(personid, name, phone);
        }
        cursor.close();
        return null;
    }

    /**
     * 数据分页
     * @param offset
     * @param maxResult
     * @return
     */
    public List<Person> getScrollData(int offset, int maxResult) {
        List<Person> person = new ArrayList<Person>();
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM person ORDER BY personid ASC LIMIT= ?,?",
                new String[]{String.valueOf(offset), String.valueOf(maxResult)});
        while (cursor.moveToNext()) {
            int personid = cursor.getInt(cursor.getColumnIndex("personid"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));
            person.add(new Person(personid, name, phone));
        }
        cursor.close();
        return person;
    }

    /**
     * 查询总数
     * @return
     */
    public long getCount() {
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT COUNT (*) FROM person", null);
        cursor.moveToFirst();
        long result = cursor.getLong(0);
        cursor.close();
        return result;
    }
}
