package com.wanhu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

public class Start extends Activity {
	private EditText logName;
	private EditText logPassword;
	private Button logButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);

		logName = (EditText) findViewById(R.id.logName);
		logPassword = (EditText) findViewById(R.id.logPassword);
		logPassword.setOnKeyListener(onKeyListener); 
		
		/*
		 * 配置scrollview ScrollView mScrollView =
		 * (ScrollView)findViewById(R.id.scrollContent);
		 * mScrollView.setVerticalScrollBarEnabled(false);
		 * mScrollView.setHorizontalScrollBarEnabled(false);
		 */
	}

	public void login_check(View v) {
		String log_username = logName.getText().toString();
		String log_password = logPassword.getText().toString();
		if (log_username.equals("1") && log_password.equals("q")) {
			Intent intent = new Intent();
			intent.setClass(Start.this, Loading.class);
			startActivity(intent);
			Start.this.finish();

		} else if (log_username.equals("")) {
			Toast.makeText(getApplicationContext(), "请输入玩号", 3000).show();
			/*
			 * new AlertDialog.Builder(Start.this)
			 * .setIcon(getResources().getDrawable(R.drawable.login_error_icon))
			 * .setTitle("请完整") .setMessage("请完整输入") .create().show();
			 */
		} else if (!(log_username.equals(null)) && log_password.equals("")) {
			Toast.makeText(getApplicationContext(), "请输入密码", 3000).show();
		} else {
			Toast.makeText(getApplicationContext(), "玩号、密码输入错误", 3000).show();
		}
	}

	private OnKeyListener onKeyListener = new OnKeyListener() {

		@Override
		public boolean onKey(View v, int keyCode, KeyEvent event) {
			if (keyCode == KeyEvent.KEYCODE_ENTER) {
				/* 隐藏软键盘 */
				InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				if (inputMethodManager.isActive()) {
					inputMethodManager.hideSoftInputFromWindow(
							v.getApplicationWindowToken(), 0);
				}

				login_check(logButton);

				return true;
			}
			return false;
		}
	};

}
