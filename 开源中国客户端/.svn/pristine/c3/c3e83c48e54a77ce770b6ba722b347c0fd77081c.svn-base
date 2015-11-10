package com.itheima.oschina.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.itheima.oschina.ui.factory.CollectFragmentFactory;
public class CollectAdapter extends FragmentStatePagerAdapter {
	
	public CollectAdapter(FragmentManager fm) {
		super(fm);
		
	}

	String [] title = {"软件","话题","代码","博客","资讯"};

	@Override
	public Fragment getItem(int arg0) {
		
		return CollectFragmentFactory.create(arg0);
	}
	
	@Override
	public int getCount() {
		return title.length;
	}

	
	@Override
	public CharSequence getPageTitle(int position) {
		return title[position];
	}

	
}
