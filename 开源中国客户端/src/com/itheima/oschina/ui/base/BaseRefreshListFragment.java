package com.itheima.oschina.ui.base;

import java.util.ArrayList;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.itheima.oschina.R;
import com.itheima.oschina.ui.fragment.AttentionMeFragment;
import com.itheima.oschina.ui.fragment.base.BaseFragment;

/**
 * 带有下拉刷新listView界面的基类
 * @author Administrator
 *
 */
public abstract class BaseRefreshListFragment<T> extends BaseFragment{
	protected PullToRefreshListView refreshListView;
	protected ListView listView;
	//总的页面
	protected LinearLayout ll_content;
	/**
	 * 初始化RefreshListView
	 */
	protected void initRefreshListView(final ArrayList<T> list){
		ll_content = (LinearLayout) View.inflate(getActivity(), R.layout.ptr_listview, null);
		refreshListView = (PullToRefreshListView) ll_content.findViewById(R.id.pull_refresh_list);
		refreshListView.setMode(Mode.BOTH);//设置既可以上拉也可以下拉

		//1.得到普通的listview对象，给普通listview对象设置adapter
		listView = refreshListView.getRefreshableView();
		listView.setSelector(new ColorDrawable(Color.TRANSPARENT));//隐藏listview的selector
		//		listView.setSelector(android.R.color.transparent);//用这个也行

		//2.给refreshListView设置刷新监听器
		refreshListView.setOnRefreshListener(new OnRefreshListener<ListView>() {
			/**
			 * 上拉和下拉都会执行该方法
			 * @param refreshView
			 */
			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				if(refreshListView.getCurrentMode()==Mode.PULL_FROM_START){
					AttentionMeFragment.flag=true;
					contentPage.loadDataAndRefreshPage();
				}else {
					//如果当前是上拉加载更多
					AttentionMeFragment.flag=false;
					contentPage.loadDataAndRefreshPage();
				}
			}
		});
	}
}
