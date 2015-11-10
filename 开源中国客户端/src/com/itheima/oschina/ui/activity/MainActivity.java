package com.itheima.oschina.ui.activity;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Adapter;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.itheima.oschina.R;
import com.itheima.oschina.bean.SpaceItemDecrotion;
import com.itheima.oschina.db.ImageDb;
import com.itheima.oschina.ui.adapter.MainFragmentAdapter;
import com.itheima.oschina.ui.adapter.RecycleAdapter;
import com.itheima.oschina.ui.view.MyRelative;
import com.itheima.oschina.ui.view.MyRelative.OnCloseWindowistener;
import com.itheima.oschina.ui.view.MyViewPager;
import com.itheima.oschina.util.EvaluateUtil;
import com.itheima.oschina.util.LogUtils;
import com.itheima.oschina.util.ToastUtil;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import com.nineoldandroids.view.ViewHelper;

public class MainActivity extends ActionBarActivity {

	private DrawerLayout drawerLayout;
	private ActionBarDrawerToggle drawerToggle;
	private ImageButton ib_mian_menu_add;
	private LinearLayout ll_window_content;
	private MyRelative rl_mian_window;

	private Handler handler=new Handler(){

		@Override
		public void handleMessage(Message msg) {
			vp_miancontent_show.setCurrentItem(msg.what);
			//设置按钮
			switch (msg.what) {
			case 3:
				radiogroup_mian_menu.check(R.id.ra_mian_menu_me);
				break;
			}
		}
	};
	//弹窗状态
	enum Status{
		close,open;
	}
	private Status mStatus=Status.close;
	//弹窗的移动距离
	private int distance;
	private MyViewPager vp_miancontent_show;
	private RadioGroup radiogroup_mian_menu;
	private ImageButton bt_mian_cancel;
	private RotateAnimation ra;
	private ImageButton findViewById;
	/**
	 * 主函数
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//设置ActionBar
		setActionBar();
		//设置View
		initView();

		//设置图片浏览
		initImage();
	}

	/**
	 * TODO  设置照片墙
	 */
	private void initImage() {
		findViewById = (ImageButton) findViewById(R.id.ib_popu_picture);
		findViewById.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//设置弹出框
				View dialog_image = View.inflate(getApplicationContext(), R.layout.dialog_image, null);
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setTitle("请选择图片");
				builder.setView(dialog_image);
				setRecyclerView(dialog_image);
				builder.show();
			}
		});
	}
	/**
	 * 设置RecyclerView
	 * @param dialog_image
	 */
	private void setRecyclerView(View dialog_image) {
		RecyclerView recycler_view = (RecyclerView) dialog_image.findViewById(R.id.recycler_view);
		StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
		recycler_view.setLayoutManager(staggeredGridLayoutManager);
		ArrayList<String> imgPathList = ImageDb.getImgPathList(getApplicationContext());
		RecycleAdapter recycleAdapter = new RecycleAdapter(imgPathList);
		recycler_view.setAdapter(recycleAdapter);
		SpaceItemDecrotion spaceItemDecrotion = new SpaceItemDecrotion(100);
		recycler_view.addItemDecoration(spaceItemDecrotion);
	}





	@Override
	protected void onStart() {
		super.onStart();
		vp_miancontent_show.setCurrentItem(0);
		radiogroup_mian_menu.check(R.id.ra_mian_menu_sum);
	}
	/**
	 * 初始化界面
	 */
	private void initView() {
		setImageButton();
		setTanChuang();
		intitViewPager();
		initRadioButton();
		//按钮旋转
		ImageButtonRator();
	}
	/**
	 * 设置RadioButtonClick事件
	 */
	private void initRadioButton() {

		radiogroup_mian_menu = (RadioGroup) findViewById(R.id.radiogroup_mian_menu);
		radiogroup_mian_menu.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.ra_mian_menu_sum://综合

					vp_miancontent_show.setCurrentItem(0);
					break;
				case R.id.ra_mian_menu_move://弹动
					vp_miancontent_show.setCurrentItem(1);
					break;
				case R.id.ra_mian_menu_find://寻找
					vp_miancontent_show.setCurrentItem(2);
					break;
				case R.id.ra_mian_menu_me://Me
					vp_miancontent_show.setCurrentItem(3);
					break;
				}
			}
		});
	}
	/**
	 * ViewPager
	 */
	private void intitViewPager() {
		//加载ViewPager
		vp_miancontent_show = (MyViewPager) findViewById(R.id.vp_miancontent_show);
		MainFragmentAdapter mainFragmentAdapter = new MainFragmentAdapter(getSupportFragmentManager());
		vp_miancontent_show.setAdapter(mainFragmentAdapter);
	}

	/**
	 * 设置弹窗
	 */
	private void setTanChuang() {
		ll_window_content = (LinearLayout) findViewById(R.id.ll_window_content);
		rl_mian_window = (MyRelative) findViewById(R.id.rl_mian_window);
		bt_mian_cancel = (ImageButton) rl_mian_window.findViewById(R.id.bt_mian_cancel);
	}
	/**
	 * 设置ImageButton,打开
	 */
	private void setImageButton() {
		ib_mian_menu_add = (ImageButton) findViewById(R.id.ib_mian_menu_add);
		ib_mian_menu_add.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mStatus==Status.close){
					showAlert();
					mStatus=Status.open;
					LogUtils.e("abc", "打开了");
				}else{
					ToastUtil.showToast("已经打开了");
				}
			}
		});
	}

	/**
	 * 关闭
	 * @param view
	 */
	public void cancel(View view){
		if(mStatus==Status.open){
			closeAlert();
			mStatus=Status.close;
		}else{
			ToastUtil.showToast("已经关1闭了");
		}
	}

	/**
	 * 打开弹窗
	 */
	private void showAlert() {
		rl_mian_window.setVisibility(View.VISIBLE);
		ll_window_content.setVisibility(View.VISIBLE);
		/**
		 * TODO 设置监听事件
		 */
		rl_mian_window.setCloseWindowistener(new OnCloseWindowistener() {
			@Override
			public void closeWindow() {
				if(mStatus==Status.open){
					closeAlert();
					mStatus=Status.close;
				}else{
					/*		ToastUtil.showToast("已经2关闭了");*/
				}
			}
		});
		//

		distance = ll_window_content.getMeasuredHeight();
		ObjectAnimator oa = ObjectAnimator.ofFloat(ll_window_content, "translationY", distance, 0);
		oa.setDuration(1000); 
		oa.start(); 
		//开始动画
		ImageButtonRator();
	}

	private void ImageButtonRator() {
		bt_mian_cancel.clearAnimation();
		ra = new RotateAnimation(-90,0,RotateAnimation.RELATIVE_TO_SELF, 0.5f,RotateAnimation.RELATIVE_TO_SELF, 0.5f);
		ra.setDuration(5000);
		bt_mian_cancel.setAnimation(ra);
		ra.start();
	}

	/**
	 * 关闭弹窗
	 */
	private void closeAlert() {
		ObjectAnimator oa = ObjectAnimator.ofFloat(ll_window_content, "translationY",0, distance);
		oa.addUpdateListener(new AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				float animatedFraction = animation.getAnimatedFraction();
				float evaluateFloat = EvaluateUtil.evaluateFloat(animatedFraction, 1, 0);
				ViewHelper.setAlpha(rl_mian_window, evaluateFloat);
				if(evaluateFloat==0){
					rl_mian_window.setVisibility(View.INVISIBLE);
					ViewHelper.setAlpha(rl_mian_window,1);
				}
			}
		});
		oa.setDuration(1000); 
		oa.start();
	}
	/**
	 * 设置ActionBar
	 */
	private void setActionBar() {
		// 1.获取v7包中的ActionBar对象
		drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
		ActionBar actionBar = getSupportActionBar();
		//		actionBar.setIcon(R.drawable.ic_launcher);// 设置ActionBAR的图标
		actionBar.setTitle(getString(R.string.app_name));// 设置ActionBAR的标题
		// 2.显示ActionBar的home按钮
		actionBar.setDisplayHomeAsUpEnabled(true);// 显示home按钮
		actionBar.setDisplayShowHomeEnabled(true);// 设置home按钮可以被点击，其实默认就可以被点击

		// 3.给home按钮设置3条线的图标
		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
				R.drawable.ic_drawer_am, 0, 0);
		drawerToggle.syncState();// 同步ActionBar和DrawerLayout的状态

		// 4.给3条线增加进出的动画
		drawerLayout.setDrawerListener(new DrawerListener() {
			@Override
			public void onDrawerStateChanged(int newState) {
				// 将drawerLayout的滑动状态告诉drawerToggle
				drawerToggle.onDrawerStateChanged(newState);
			}

			@Override
			public void onDrawerSlide(View drawerView, float slideOffset) {
				// 将drawerLayout的滑动的百分比告诉drawerToggle
				drawerToggle.onDrawerSlide(drawerView, slideOffset);
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				// 将drawerLayout的打开的状态告诉drawerToggle
				drawerToggle.onDrawerOpened(drawerView);
			}

			@Override
			public void onDrawerClosed(View drawerView) {
				// 将drawerLayout的关闭的状态告诉drawerToggle
				drawerToggle.onDrawerClosed(drawerView);
			}
		});
	}

	/**
	 * 当点击ActionBar的home按钮的时候会执行该方法
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {


		switch (item.getItemId()) {
		case R.id.menu_search:
			ToastUtil.showToast("search");
			break;
		}
		drawerToggle.onOptionsItemSelected(item);
		return super.onOptionsItemSelected(item);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * 获的返回结果
	 */
	@Override
	protected void onActivityResult(int arg0, int arg1, Intent arg2) {
		handler.sendEmptyMessage(arg1);
	}
}
