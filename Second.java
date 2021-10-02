package com.mycompany.sqlite;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.*;

public class Second extends Activity
{
	DatabaseHandler db;
	String data = "Data Not Found";
	TextView edata;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		
		db = new DatabaseHandler(this);
		edata = (TextView) findViewById(R.id.secondTextView);
		
		data = db.get_emp();
		
		Toast.makeText(this,db.get_emp().toString(),Toast.LENGTH_SHORT).show();
		
		edata.setText(data);
	}
}
