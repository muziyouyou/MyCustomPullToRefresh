package com.itheima.oschina.ui.fragment;

import android.os.Bundle;

import com.itheima.oschina.R;
import com.itheima.oschina.bean.BlogList;
import com.itheima.oschina.bean.NewsList;
import com.itheima.oschina.ui.base.BaseViewPagerFragment;
import com.itheima.oschina.ui.base.MyViewPagerAdapter;

public class MessageFragment extends BaseViewPagerFragment {

	@Override
	protected void onSetupTabAdapter(MyViewPagerAdapter adapter) {

		//获取title
		String[] title = getResources().getStringArray(
				R.array.mymes_viewpage_arrays);
		// @我
		adapter.addTab(title[0], "news", AttentionMeFragment.class,
				getBundle(NewsList.CATALOG_ALL));
		// 评论
		adapter.addTab(title[1], "news_week", DefaultFragment.class,
				getBundle(NewsList.CATALOG_WEEK));
		// 留言
		adapter.addTab(title[2], "latest_blog", DefaultFragment.class,
				getBundle(BlogList.CATALOG_LATEST));
		// 粉丝
		adapter.addTab(title[3], "recommend_blog", DefaultFragment.class,
				getBundle(BlogList.CATALOG_RECOMMEND));

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
