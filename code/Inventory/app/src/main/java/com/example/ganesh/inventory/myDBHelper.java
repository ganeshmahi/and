package com.example.ganesh.inventory;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class myDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="items.db";
    public static final String TABLE_ITEMS="items";
    public static final String COLUMN_ID="id";
    public static final String COLUMN_productName="product";
    public static final String COLUMN_price="price";

    public myDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query="CREATE TABLE "+TABLE_ITEMS+" ( "+
                     COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                     COLUMN_productName +" TEXT, "+
                     COLUMN_price +" INTEGER"+
                      ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_ITEMS);
        onCreate(db);

    }

    public void addItem(Items item){
        SQLiteDatabase db= getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_productName,item.get_productName());
        db.insert(TABLE_ITEMS,null,values);
        db.close();

    }

    public void deleteItem(String product)
    {
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_ITEMS+" WHERE "+COLUMN_productName+" =\" "+product+" \";");
    }

    public String dbToString(){

        String database="";
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+TABLE_ITEMS+" WHERE 1";

        Cursor c=db.rawQuery(query,null);
        c.moveToFirst();

        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("product"))!=null){
                database+=c.getString(c.getColumnIndex("product"));
                database+="\n";
            }
        }
        db.close();
        return database;
    }
}
