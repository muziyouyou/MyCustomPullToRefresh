package com.itheima.oschina.ui.adapter;

import java.util.ArrayList;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itheima.oschina.R;
import com.itheima.oschina.bean.Favorite;
import com.itheima.oschina.global.GooglePlayApplication;
import com.itheima.oschina.ui.base.MyBaseAdapter;

public class SoftwareAdapter extends MyBaseAdapter<Favorite> {

	public SoftwareAdapter(ArrayList<Favorite> list) {
		super(list);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if(convertView==null){
			convertView = View.inflate(GooglePlayApplication.getContext(), R.layout.software_adapter_item, null);
		}
		ViewHolder holder = ViewHolder.getHolder(convertView);
		
		Favorite favorite = list.get(position);
		
		holder.tv_software_item.setText(favorite.getTitle());
		
		return convertView;
	}
	
	static class ViewHolder{
		TextView tv_software_item;
		
		public ViewHolder(View convertView){
			tv_software_item = (TextView) convertView.findViewById(R.id.tv_software_item);
		}
		
		public static ViewHolder getHolder(View convertView){
			
			ViewHolder viewHolder = (ViewHolder) convertView.getTag();
			
			if(viewHolder==null){
				 viewHolder = new ViewHolder(convertView);
				 convertView.setTag(viewHolder);
			}
			
			return viewHolder;
			
		}
	}

}
