package com.itheima.oschina.ui.fragment;

import java.io.InputStream;

import org.apache.http.HttpResponse;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.itheima.oschina.R;
import com.itheima.oschina.ui.activity.CollectActivity;
import com.itheima.oschina.bean.UserInformation;
import com.itheima.oschina.http.AllUrl;
import com.itheima.oschina.http.HttpHelper;
import com.itheima.oschina.ui.activity.MessageActivity;
import com.itheima.oschina.ui.fragment.base.BaseFragment;
import com.itheima.oschina.util.DrawCircle;
import com.itheima.oschina.util.XmlUtils;

public class MeFragment extends BaseFragment {

	private LinearLayout ll_framgmentme_header;
	private TextView tv_frame_message;
	private UserInformation userInfo;



	private Handler handler=new Handler(){
		@Override
		public void handleMessage(Message msg) {
			tv_frame_me_score.setText(userInfo.getUser().getScore()+"");
			tv_frame_me_collect.setText(userInfo.getUser().getFavoritecount()+"");
			tv_frame_me_attention.setText(userInfo.getUser().getFollowers()+"");
			tv_frame_me_fans.setText(userInfo.getUser().getFans()+"");
		}
	};
	private TextView tv_frame_me_score;
	private TextView tv_frame_me_collect;
	private TextView tv_frame_me_attention;
	private TextView tv_frame_me_fans;


	@Override
	protected View getSuccessView() {

		View view=View.inflate(getActivity(), R.layout.frame_me, null);
		ll_framgmentme_header = (LinearLayout) view.findViewById(R.id.ll_framgmentme_header);
		//设置背景
		ViewTreeObserver viewTreeObserver = ll_framgmentme_header.getViewTreeObserver();
		viewTreeObserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				//获取宽高
				int height = ll_framgmentme_header.getHeight();
				int width = ll_framgmentme_header.getWidth();
				//设置图片
				Options options = new Options();
				options.inJustDecodeBounds = true;
				BitmapFactory.decodeResource(getResources(), R.drawable.user_center_bg,options);
				int outWidth = options.outWidth;
				int outHeight = options.outHeight;
				//3，计算比例
				int widthScale = outWidth/width;
				int heightScale = outHeight/height ; 
				int scale = widthScale > heightScale ? widthScale : heightScale;

				//4，给图片设置缩减
				options.inJustDecodeBounds = false; // 加载器就会返回图片了
				options.inSampleSize=scale;
				Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.user_center_bg, options);
				ll_framgmentme_header.setBackgroundDrawable(new BitmapDrawable(bitmap));
			}
		});
		//设置头像圆角
		setCircle(view);
		//初始化按钮
		initmenu(view);
		//跳转微博,博客,便签,团队
		skip(view);
		return view;
	}


	/**
	 * 跳转微博,博客,便签,团队
	 * @param view
	 */
	private void skip(View view) {
		//消息
		tv_frame_message = (TextView) view.findViewById(R.id.tv_frame_message);
		tv_frame_message.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(),MessageActivity.class);
				getActivity().startActivityForResult(intent,3);
			}
		});
	}


	/**
	 * 设置圆角
	 */
	private void setCircle(View view) {
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.widget_dface);
		Bitmap circleMap = DrawCircle.circleMap(bitmap, bitmap.getWidth());
		ImageView imageView=(ImageView) view.findViewById(R.id.ib_fragmentme_info);
		imageView.setImageBitmap(circleMap);

	}


	/**
	 * 初始化菜单
	 * @param view
	 */
	private void initmenu(View view) {
		LinearLayout ll_frameme_score = (LinearLayout) view.findViewById(R.id.ll_frameme_score);
		LinearLayout ll_frameme_collect =(LinearLayout) view.findViewById(R.id.ll_frameme_collect);
		LinearLayout ll_frameme_attention =(LinearLayout) view.findViewById(R.id.ll_frameme_attention);
		LinearLayout ll_frameme_fans =(LinearLayout) view.findViewById(R.id.ll_frameme_fans);

		tv_frame_me_score = (TextView) view.findViewById(R.id.tv_frame_me_score);
		tv_frame_me_collect = (TextView) view.findViewById(R.id.tv_frame_me_collect);
		tv_frame_me_attention = (TextView) view.findViewById(R.id.tv_frame_me_attention);
		tv_frame_me_fans = (TextView) view.findViewById(R.id.tv_frame_me_fans);

		tv_frame_me_score.setText(0+"");
		tv_frame_me_collect.setText(0+"");
		tv_frame_me_attention.setText(0+"");
		tv_frame_me_fans.setText(0+"");

		ll_frameme_score.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
		ll_frameme_collect.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(getActivity(),CollectActivity.class);
				
				//intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				
				startActivityForResult(intent, 3);
				
			}
		});
		ll_frameme_attention.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
		ll_frameme_fans.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
	}


	@Override
	protected Object requestData() {
	
		String url=AllUrl.me_fragment;
		System.out.println(url);
		HttpResponse response = HttpHelper.getResponse(url);
		int code =response.getStatusLine().getStatusCode();
		if(code == 200){
			InputStream in;
			try {
				in = response.getEntity().getContent();
				userInfo = XmlUtils.toBean(UserInformation.class,in);
				handler.sendEmptyMessage(0);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return userInfo;
	}
}
