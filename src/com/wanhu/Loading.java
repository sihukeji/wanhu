package com.wanhu;

import android.app.Activity;
//import android.content.Intent;
import android.os.Bundle;
//import android.os.Handler;
//import android.widget.Toast;

public class Loading extends Activity{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.loading);
			
		
/*	new Handler().postDelayed(new Runnable(){
		@Override
		public void run(){
			Intent intent = new Intent (Loading.this,Whatsnew.class);			
			startActivity(intent);			
			Loading.this.finish();
			Toast.makeText(getApplicationContext(), "?", Toast.LENGTH_SHORT).show();
		}
	}, 200);
*/
   }


}
