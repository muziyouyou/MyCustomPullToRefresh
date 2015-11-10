package com.itheima.oschina.ui.activity;

import com.itheima.oschina.R;
import com.itheima.oschina.R.layout;
import com.itheima.oschina.R.menu;
import com.itheima.oschina.ui.fragment.MessageFragment;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MessageActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message);
		//设置ActionBar
		setActionBar();

		//设置加载的Fragment
		FragmentManager manager = getSupportFragmentManager();
		MessageFragment messageFragment = new MessageFragment();
		manager.beginTransaction().replace(R.id.fl_message_all, messageFragment).commit();
	}

	/**
	 * 设置Action
	 */
	private void setActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle(getString(R.string.message));// 设置ActionBAR的标题
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.message, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			setResult(3);
			finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

}
