package com.itheima.oschina.ui.factory;

import android.support.v4.app.Fragment;

import com.itheima.oschina.ui.fragment.BlogsFragment;
import com.itheima.oschina.ui.fragment.CodeFragment;
import com.itheima.oschina.ui.fragment.InformationFragment;
import com.itheima.oschina.ui.fragment.SoftwareFragment;
import com.itheima.oschina.ui.fragment.TopicFragment;

public class CollectFragmentFactory {

	

	public static Fragment create(int position) {
		Fragment fragment = null;
		switch (position) {
		case 0:
			fragment = new SoftwareFragment();
			break;
		case 1:
			fragment = new TopicFragment();
			break;
		case 2:
			fragment = new CodeFragment();
			break;
		case 3:
			fragment = new BlogsFragment();
			break;
		case 4:
			fragment = new InformationFragment();
			break;

		}

		return fragment;
	}

}
