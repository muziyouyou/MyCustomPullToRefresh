package com.itheima.oschina.ui.fragment;

import com.itheima.oschina.ui.base.BaseViewPagerFragment;
import com.itheima.oschina.ui.base.MyViewPagerAdapter;

public class JumpFragment extends BaseViewPagerFragment{

	@Override
	protected void onSetupTabAdapter(MyViewPagerAdapter adapter) {
		adapter.addTab("最新动弹", getTag(), JumpNewsFragment.class, null);
		adapter.addTab("热门动弹", getTag(), JumpHotFragment.class, null);
		adapter.addTab("我的动弹", getTag(), JumpMyFragment.class, null);
	}

	
}
