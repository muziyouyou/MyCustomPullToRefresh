package com.itheima.oschina.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

import com.itheima.oschina.R;
import com.itheima.oschina.ui.adapter.CollectAdapter;
import com.itheima.oschina.ui.view.PagerSlidingTab;

public class CollectActivity extends ActionBarActivity {
	
	private PagerSlidingTab pst_collect;
	private ViewPager vp_collect;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.collect_activity);
		
		ActionBar actionBar = getSupportActionBar();
		
		actionBar.setTitle("收藏");// 设置ActionBAR的标题
		//设置Home按钮
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		System.out.println("222222222222222");
		initView();
	}

	private void initView() {
		
		pst_collect = (PagerSlidingTab) findViewById(R.id.pst_collect);
		
		vp_collect = (ViewPager) findViewById(R.id.vp_collect);
		
		vp_collect.setAdapter(new CollectAdapter(getSupportFragmentManager()));
		
		pst_collect.setViewPager(vp_collect);
	}
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
