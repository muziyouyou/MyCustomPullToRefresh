package com.itheima.oschina.ui.factory;

import com.itheima.oschina.R;
import com.itheima.oschina.ui.fragment.MeFragment;
import com.itheima.oschina.ui.fragment.DiscoverFtagment;
import com.itheima.oschina.ui.fragment.SynthesizeFragment;
import com.itheima.oschina.ui.fragment.JumpFragment;
import com.itheima.oschina.ui.pager.TestViewPager;
import com.itheima.oschina.util.CommonUtil;
import android.support.v4.app.Fragment;

/**
 * 生成fragment的工厂类
 * 
 * @author Administrator
 * 
 */
public class FragmentFactory {
	/**
	 * 根据不同的position，生产对应的fragment对象
	 * 
	 * @param position
	 * @return
	 */
	public static Fragment create(int position) {
		Fragment fragment = null;
		String[] tabs = CommonUtil.getStringArray(R.array.mian_menu_arrays);
		switch (position) {
		case 0:
			fragment = new TestViewPager();
			break;
		case 1:
			fragment = new JumpFragment();
			break;
		case 2:
			fragment = new DiscoverFtagment();
			break;
		case 3:
			fragment = new MeFragment();
			break;
		}
		return fragment;
	}
}
