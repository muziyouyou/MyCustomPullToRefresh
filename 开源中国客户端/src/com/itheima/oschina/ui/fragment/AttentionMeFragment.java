package com.itheima.oschina.ui.fragment;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.itheima.oschina.R;
import com.itheima.oschina.bean.Active;
import com.itheima.oschina.bean.ActiveListNote;
import com.itheima.oschina.http.AllUrl;
import com.itheima.oschina.http.HttpHelper;
import com.itheima.oschina.ui.activity.MessageDetailActivity;
import com.itheima.oschina.ui.adapter.AttentionMeAdapter;
import com.itheima.oschina.ui.base.BaseRefreshListFragment;
import com.itheima.oschina.util.CommonUtil;
import com.itheima.oschina.util.LogUtils;
import com.itheima.oschina.util.XmlUtils;

public class AttentionMeFragment extends BaseRefreshListFragment {

	public static boolean flag=false;
	private AttentionMeAdapter attentionMeAdapter;
	private ActiveListNote activeListNote;
	private ArrayList<Active> activeList=new ArrayList<Active>();
	private RelativeLayout list_foot;
	//判断上拉还是下拉

	//页大小
	int pagesize=10;
	@Override
	protected View getSuccessView() {

		initRefreshListView(activeList);
		//设置adapter
		attentionMeAdapter = new AttentionMeAdapter(activeList);
		listView.setAdapter(attentionMeAdapter);
		
		
		
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent=new Intent(getActivity(), MessageDetailActivity.class);
				getActivity().startActivity(intent);
			}
		});
		
		
		
		return ll_content;
	}

	@Override
	protected Object requestData() {

		if(flag){
			System.out.println("清空");
			activeList.clear();
		}
		//设置当前页
		int currentPage=activeList.size()/pagesize;
		String url=AllUrl.attention_me+"page"+currentPage+".xml";
		LogUtils.i("url", url);
		//获取数据
		HttpResponse response = HttpHelper.getResponse(url);
		int statusCode = response.getStatusLine().getStatusCode();
		if(statusCode==200){
			InputStream in;
			try {
				//获取数据
				in = response.getEntity().getContent();
				
				activeListNote = XmlUtils.toBean(ActiveListNote.class,in);
				LogUtils.i("abc", activeListNote.toString());
				//activeListNote获取数据不为空
				if(activeListNote!=null){
					final List<Active> activelist2 = activeListNote.getActivelist();
					//有链表数据
					if(activelist2!=null&&activelist2.size()>0){
						activeList.addAll(activelist2);

						CommonUtil.runOnUIThread(new Runnable() {
							@Override
							public void run() {
								//如果加载的数据>pagesize
								System.out.println(activelist2.size()+"数");
								if(activelist2.size()==pagesize){
									attentionMeAdapter.notifyDataSetChanged();
									refreshListView.onRefreshComplete();	
									refreshListView.setMode(Mode.BOTH);
									if(list_foot!=null){
										listView.removeFooterView(list_foot);
										list_foot=null;
									}
								}else{//加载数据小于
									attentionMeAdapter.notifyDataSetChanged();
									refreshListView.onRefreshComplete();
									refreshListView.setMode(Mode.PULL_FROM_START);
									if(list_foot==null){
										list_foot=(RelativeLayout) View.inflate(getActivity(), R.layout.list_foot_message, null);
										listView.addFooterView(list_foot);
									}
								}
								//结束刷新
							}
						});
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				LogUtils.i("error", "error");
			} 
		}
		return activeListNote;
	}
}
