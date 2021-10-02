package com.mycompany.sqlite;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends Activity 
{
	EditText Eid,Ename,Eage,Ecity;
	Button bsave,bwipe,bview;
	DatabaseHandler db;
	
	String i,n,a,c;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		Eid = (EditText) findViewById(R.id.Eid);
		Ename = (EditText) findViewById(R.id.Ename);
		Eage = (EditText) findViewById(R.id.Eage);
		Ecity = (EditText) findViewById(R.id.Ecity);
		
		bsave = (Button) findViewById(R.id.Bsave);
		bwipe = (Button) findViewById(R.id.Bdelete);
		bview = (Button) findViewById(R.id.Bview);
		
		db = new DatabaseHandler(this);
    }
	
	public void SaveState(View v){
		
		i = Eid.getText().toString();
		n = Ename.getText().toString();
		a = Eage.getText().toString();
		c = Ecity.getText().toString();
		
		db.add_emp(i,n,a,c);
		Toast.makeText(this,"Data Saved",Toast.LENGTH_SHORT).show();
	}
	
	public void DeleteState(View v){

	}
	
	public void ViewState(View v){
		
		Intent i = new Intent(this,Second.class);
		startActivity(i);

	}
}
