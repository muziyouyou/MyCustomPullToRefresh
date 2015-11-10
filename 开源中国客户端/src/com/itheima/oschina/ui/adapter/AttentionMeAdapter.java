package com.itheima.oschina.ui.adapter;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itheima.oschina.R;
import com.itheima.oschina.bean.Active;
import com.itheima.oschina.global.GooglePlayApplication;
import com.itheima.oschina.ui.base.MyBaseAdapter;
import com.itheima.oschina.util.CommonUtil;
import com.itheima.oschina.util.DrawCircle;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

public class AttentionMeAdapter extends MyBaseAdapter<Active> {


	public AttentionMeAdapter(ArrayList<Active> list) {
		super(list);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//获取数据
		Active active = list.get(position);
		if(convertView==null){
			convertView = View.inflate(GooglePlayApplication.getContext(),R.layout.item_attention_me, null);
		}
		ViewHolder viewHolder = ViewHolder.getHolder(convertView);
		viewHolder.tv_item_attention_author.setText(active.getAuthor());
		viewHolder.tv_item_attention_time.setText(active.getCatalog()+"");
		CharSequence charSequence = Html.fromHtml(active.getMessage());
		viewHolder.tv_item_attention_active.setText(charSequence);
		Bitmap bitmap = BitmapFactory.decodeResource(CommonUtil.getResources(), R.drawable.widget_dface);
		Bitmap circleMap = DrawCircle.circleMap(bitmap, bitmap.getWidth()/2);
		viewHolder.iv_item_attention_me.setImageBitmap(circleMap);

		//4,设置ContentView的动画
		AnimatorSet as = new AnimatorSet();
		ObjectAnimator o1 = ObjectAnimator.ofFloat(convertView, "rotationX", 0,360);
		ObjectAnimator o2 = ObjectAnimator.ofFloat(convertView, "scaleY", 0.0f,1.0f);
		ObjectAnimator o3 = ObjectAnimator.ofFloat(convertView, "scaleX", 0.0f,1.0f);
		as.setDuration(1500).setTarget(convertView);
		as.playTogether(o2,o3,o1);
		as.start();
		return convertView;
	}

	static class ViewHolder{
		ImageView iv_item_attention_me;
		TextView tv_item_attention_author,tv_item_attention_time;
		TextView tv_item_attention_active;
		public ViewHolder(View convertView){
			iv_item_attention_me = (ImageView) convertView.findViewById(R.id.iv_item_attention_me);
			tv_item_attention_author = (TextView) convertView.findViewById(R.id.tv_item_attention_author);
			tv_item_attention_time = (TextView) convertView.findViewById(R.id.tv_item_attention_time);
			tv_item_attention_active=(TextView) convertView.findViewById(R.id.tv_item_attention_active);
		}
		public static ViewHolder getHolder(View convertView){
			ViewHolder holder = (ViewHolder) convertView.getTag();
			if(holder==null){
				holder = new ViewHolder(convertView);
				convertView.setTag(holder);
			}
			return holder;
		}
	}

}
