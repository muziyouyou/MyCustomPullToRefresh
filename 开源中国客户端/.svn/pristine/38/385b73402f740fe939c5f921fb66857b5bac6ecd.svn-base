package com.itheima.oschina.ui.adapter;

import java.util.ArrayList;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itheima.oschina.R;
import com.itheima.oschina.bean.News;
import com.itheima.oschina.global.GooglePlayApplication;
import com.itheima.oschina.ui.base.MyBaseAdapter;

public class SynthesizeAdapter extends MyBaseAdapter<News>{

	public SynthesizeAdapter(ArrayList<News> list) {
		super(list);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if(convertView==null){
			convertView = View.inflate(GooglePlayApplication.getContext(),R.layout.item_synthesize, null);
		}
		ViewHolder viewHolder = ViewHolder.getViewHolder(convertView);
		
		viewHolder.ll_synthesize_title.setText(list.get(position).getTitle());
		viewHolder.ll_synthesize_body.setText(list.get(position).getBody());
		viewHolder.ll_synthesize_author.setText(list.get(position).getAuthor());
		viewHolder.ll_synthesize_pubDate.setText(list.get(position).getPubDate());
		viewHolder.ll_synthesize_commentCount.setText(list.get(position).getCommentCount()+"");
		
		return convertView;
	}
	
	
	public static class ViewHolder{
		private TextView ll_synthesize_title,ll_synthesize_body,ll_synthesize_author,ll_synthesize_pubDate,ll_synthesize_commentCount;
		
		public ViewHolder(View convertView){
			ll_synthesize_title = (TextView) convertView.findViewById(R.id.ll_synthesize_title);
			ll_synthesize_body = (TextView) convertView.findViewById(R.id.ll_synthesize_body);
			ll_synthesize_author = (TextView) convertView.findViewById(R.id.ll_synthesize_author);
			ll_synthesize_pubDate = (TextView) convertView.findViewById(R.id.ll_synthesize_pubDate);
			ll_synthesize_commentCount = (TextView) convertView.findViewById(R.id.ll_synthesize_commentCount);
		}
		
		public static ViewHolder getViewHolder(View convertView){
			ViewHolder viewHolder = (ViewHolder) convertView.getTag();
			if(viewHolder == null){
				viewHolder = new ViewHolder(convertView);
				convertView.setTag(viewHolder);
			}
			return viewHolder;
		}
		
	}

}
