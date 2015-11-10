package com.itheima.oschina.ui.fragment;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.itheima.oschina.R;
import com.itheima.oschina.bean.News;
import com.itheima.oschina.bean.NewsList;
import com.itheima.oschina.http.AllUrl;
import com.itheima.oschina.http.HttpHelper;
import com.itheima.oschina.ui.adapter.SynthesizeAdapter;
import com.itheima.oschina.ui.base.BaseRefreshListFragment;
import com.itheima.oschina.util.CommonUtil;
import com.itheima.oschina.util.LogUtils;
import com.itheima.oschina.util.XmlUtils;

public class SynthesizeFragment extends BaseRefreshListFragment{
	//页大小
	private int pagesize=10;
	private RelativeLayout list_foot;
	private ArrayList<News> newList=new ArrayList<News>();
	private NewsList newsList;
	private SynthesizeAdapter synthesizeAdapter;
	@Override
	protected View getSuccessView() {
		
		initRefreshListView(newList);
		
		synthesizeAdapter = new SynthesizeAdapter(newList);
		listView.setAdapter(synthesizeAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				News news = newList.get(position);
				String title = news.getTitle();
				Toast.makeText(getActivity(), title, 0).show();
			}
		});
		
		return ll_content;
	}
	@Override
	protected Object requestData() {
		//设置当前页
				int currentPage=newList.size()/pagesize;
				
				String url=AllUrl.synthesize_information+currentPage+".xml";
				
				LogUtils.i("url", url);
				//获取数据
				HttpResponse response = HttpHelper.getResponse(url);
				if(refreshListView.getCurrentMode()==Mode.PULL_FROM_START){
					newList.clear();
				}
				int statusCode = response.getStatusLine().getStatusCode();
				if(statusCode==200){
					InputStream in;
					try {
						//获取数据
						in = response.getEntity().getContent();
						newsList = XmlUtils.toBean(NewsList.class,in);
						
						LogUtils.i("abc", newsList.toString());
						
						//activeListNote获取数据不为空
						if(newsList!=null){
						//	final List<Active> activelist2 = activeListNote.getActivelist();
							final List<News> list = newsList.getList();
							
							//有链表数据
							if(list!=null&&list.size()>0){
								newList.addAll(list);

								CommonUtil.runOnUIThread(new Runnable() {

									@Override
									public void run() {
										//如果加载的数据>pagesize

										System.out.println(list.size()+"数");
										if( list.size()==pagesize){
											synthesizeAdapter.notifyDataSetChanged();
											refreshListView.onRefreshComplete();	
											refreshListView.setMode(Mode.BOTH);
											if(list_foot!=null){
												listView.removeFooterView(list_foot);
												list_foot=null;
											}
										}else{//加载数据小于
											synthesizeAdapter.notifyDataSetChanged();
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
				return newsList;
	}
}
