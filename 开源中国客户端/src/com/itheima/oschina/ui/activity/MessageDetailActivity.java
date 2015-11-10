package com.itheima.oschina.ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.LayoutParams;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.itheima.oschina.R;
import com.itheima.oschina.util.ToastUtil;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import com.nineoldandroids.view.ViewHelper;

public class MessageDetailActivity extends ActionBarActivity {
	private AnimationDrawable animationDrawable;
	Handler handler=new Handler(){

		@Override
		public void handleMessage(Message msg) {
			if(animationDrawable!=null){
				animationDrawable.stop();
				ib_action_loading.setImageResource(R.drawable.audio0);
				ToastUtil.showToast("更新完成");
			}
		}
	};
	private ImageButton ib_action_loading;
	private LinearLayout ll_messagedetail_write;
	private LinearLayout ll_messagedetail_biaoqing;
	private LinearLayout ll_messagedetail_sum;
	private FrameLayout fl_messagedetail;
	private ImageButton ib_emoji;
	private ImageButton ib_zhuan;
	private boolean falg;
	RelativeLayout rl_messagedetail_write;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_meaage_detail);
		//获取V7包的ActionBar
		ActionBar mActionBar = getSupportActionBar();	
		//设置显示自定义的ActionBar视图
		mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		View view=View.inflate(getApplicationContext(), R.layout.action_custorm, null);
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		mActionBar.setCustomView(view, params);
		//添加点击事件
		ImageButton ib_action_custorm = (ImageButton) view.findViewById(R.id.ib_action_custorm);
		ib_action_custorm.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
		ib_action_loading = (ImageButton) view.findViewById(R.id.ib_action_loading);
		ib_action_loading.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				ib_action_loading.setImageResource(R.drawable.action_custom_loading);
				animationDrawable = (AnimationDrawable) ib_action_loading.getDrawable();
				animationDrawable.start();
				//停止刷新
				new Thread(new Runnable() {

					@Override
					public void run() {

						SystemClock.sleep(3000);
						handler.sendEmptyMessage(0);
					}
				}).start();
			}
		});
		
		//表情弹窗
		
		fl_messagedetail = (FrameLayout)findViewById(R.id.fl_messagedetail);
		ViewTreeObserver viewTreeObserver = fl_messagedetail.getViewTreeObserver();
		viewTreeObserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {

			@Override
			public void onGlobalLayout() {
				ll_messagedetail_sum = (LinearLayout)findViewById(R.id.ll_messagedetail_sum);
				ll_messagedetail_write = (LinearLayout) findViewById(R.id.ll_messagedetail_write);
				ll_messagedetail_biaoqing = (LinearLayout) findViewById(R.id.ll_messagedetail_biaoqing);
				rl_messagedetail_write=(RelativeLayout) findViewById(R.id.rl_messagedetail_write);
				ViewHelper.setTranslationY(ll_messagedetail_sum, ll_messagedetail_biaoqing.getHeight());
				ib_emoji = (ImageButton) findViewById(R.id.ib_emoji);
				ib_zhuan = (ImageButton) findViewById(R.id.ib_zhuan);
				//表情弹窗
				ib_emoji.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						Bitmap bitmap=null;
						if(falg){//关闭
							bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.btn_emoji);
							ib_emoji.setImageBitmap(bitmap);
							ObjectAnimator.ofFloat(ll_messagedetail_sum, "translationY", 0,ll_messagedetail_biaoqing.getHeight()).setDuration(1000).start();
							falg=false;
						}else{///打开
							bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.btn_emoji_pressed);
							ib_emoji.setImageBitmap(bitmap);
							ObjectAnimator.ofFloat(ll_messagedetail_sum, "translationY", ll_messagedetail_biaoqing.getHeight(),0).setDuration(1000).start();
							falg=true;
						}
					}
				});
				//翻转
				
				ib_zhuan.setOnClickListener(new OnClickListener() {
					 // ll_messagedetail_write
					@Override
					public void onClick(View v) {
						rl_messagedetail_write.setVisibility(View.VISIBLE);
						//ll_write
						AnimatorSet as = new AnimatorSet();
						ObjectAnimator ll_write = ObjectAnimator.ofFloat(ll_messagedetail_write, "rotationX", 0,180);
						ll_write.addUpdateListener(new AnimatorUpdateListener() {
							@Override
							public void onAnimationUpdate(ValueAnimator anim) {
								float animatedFraction = anim.getAnimatedFraction();
								ll_messagedetail_write.setAlpha(1-animatedFraction);
							}
						});
						ll_write.setDuration(2000);
						
						//rl_write
						ObjectAnimator rl_write = ObjectAnimator.ofFloat(rl_messagedetail_write, "rotationX", -180,0);
						rl_write.addUpdateListener(new AnimatorUpdateListener() {
							@Override
							public void onAnimationUpdate(ValueAnimator anim) {
								float animatedFraction = anim.getAnimatedFraction();
								rl_messagedetail_write.setAlpha(animatedFraction);
							}
						});
						rl_write.setDuration(2000);
						as.setDuration(4000);
						as.playTogether(ll_write,rl_write);
						as.start();
					}
				});
			}
		});
	}


	/**
	 * 获取控件高度
	 */
	@Override
	protected void onStart() {

		super.onStart();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.meaage_detail, menu);
		return true;
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if(animationDrawable!=null){
			animationDrawable.stop();
		}
	}

}
