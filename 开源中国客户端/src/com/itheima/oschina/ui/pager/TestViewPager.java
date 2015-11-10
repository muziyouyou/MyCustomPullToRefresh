package com.itheima.oschina.ui.pager;

import android.os.Bundle;

import com.itheima.oschina.R;
import com.itheima.oschina.bean.BlogList;
import com.itheima.oschina.bean.NewsList;
import com.itheima.oschina.ui.base.BaseViewPagerFragment;
import com.itheima.oschina.ui.base.MyViewPagerAdapter;
import com.itheima.oschina.ui.fragment.AttentionMeFragment;
import com.itheima.oschina.ui.fragment.DefaultFragment;
import com.itheima.oschina.ui.fragment.SynthesizeFragment;

public class TestViewPager extends BaseViewPagerFragment {

	@Override
	protected void onSetupTabAdapter(MyViewPagerAdapter adapter) {
		adapter.addTab("资讯", "资讯", SynthesizeFragment.class, null);
		adapter.addTab("热点", "热点", SynthesizeFragment.class, null);
		adapter.addTab("博客", "博客", SynthesizeFragment.class, null);
		adapter.addTab("推荐", "推荐", SynthesizeFragment.class, null);
		

	}
	@Override
	protected void setScreenPageLimit() {
		mViewPager.setOffscreenPageLimit(3);
	}
	private Bundle getBundle(int newType) {
		Bundle bundle = new Bundle();
		bundle.putString("key", "我是综合里的: " + newType);
		return bundle;
	}

	/**
	 * 基类会根据不同的catalog展示相应的数据
	 * @param catalog  要显示的数据类别
	 * @return
	 */
	private Bundle getBundle(String catalog) {
		Bundle bundle = new Bundle();
		bundle.putString("key", "我是综合里的: " + catalog);
		return bundle;
	}

}
