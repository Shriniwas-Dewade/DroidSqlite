package com.mycompany.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

public class DatabaseHandler extends SQLiteOpenHelper
{
	private static final int db_version = 1;
	private static final String db_name = "manager";
	private static final String db_table = "employee";
	private static final String Key_Id = "id";
	private static final String Key_Name = "name";
	private static final String Key_Age = "age";
	private static final String Key_City = "city";
	
	SQLiteDatabase p1;
	String res = "";
	
	public DatabaseHandler(Context c){
		super(c,db_name,null,db_version);
	}

	@Override
	public void onCreate(SQLiteDatabase p1)
	{
		String query = "CREATE TABLE " + db_table + " (" + Key_Id + " INTEGER PRIMARY KEY AUTOINCREMENT ," + Key_Name + " TEXT," + Key_Age + " TEXT," + Key_City + " TEXT" + " )";
		p1.execSQL(query);
	}

	@Override
	public void onUpgrade(SQLiteDatabase p1, int p2, int p3)
	{
		p1.execSQL("DROP TABLE IF EXITS " + db_table);
		
		onCreate(p1);
	}
	
	public long add_emp(String id,String name,String age,String city){
		p1 = this.getWritableDatabase();
		
		ContentValues v = new ContentValues();
		v.put(Key_Name,name);
		v.put(Key_Age,age);
		v.put(Key_City,city);
		return p1.insert(db_table,null,v);
	}
	
	public String get_emp(){
		
		p1 = this.getReadableDatabase();
		
		Cursor cursor = p1.query(db_table, new String[] {Key_Id,Key_Name,Key_Age,Key_City},null,null,null,null,null);
		
		int id = cursor.getColumnIndex(Key_Id);
		int name = cursor.getColumnIndex(Key_Name);
		int age = cursor.getColumnIndex(Key_Age);
		int city = cursor.getColumnIndex(Key_City);
		
		for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
		res += "Id : " + cursor.getString(id) + " \n" + "Name : " + cursor.getString(name) + " \n" + "Age : " + cursor.getString(age) + " \n" + "City : " + cursor.getString(city) + " \n";
		}
		
		p1.close();
		
		return res;
	}
}
