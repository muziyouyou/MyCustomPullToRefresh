package com.handmark.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;
import com.handmark.pulltorefresh.library.R;

public class MyLoadingLayOut extends LoadingLayout {

	private Animation loadAnimation;

	public MyLoadingLayOut(Context context, Mode mode,Orientation scrollDirection, TypedArray attrs) {
		super(context, mode, scrollDirection, attrs);
		
		mHeaderImage.setImageResource(R.drawable.mystart);
		loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.myrotate);
	}

	@Override
	protected int getDefaultDrawableResId() {
		// TODO Auto-generated method stub
		return R.drawable.mystart;
	}

	@Override
	protected void onLoadingDrawableSet(Drawable imageDrawable) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onPullImpl(float scaleOfLayout) {
		// TODO Auto-generated method stub

	}

	//下来刷新
	@Override
	protected void pullToRefreshImpl() {
		mHeaderImage.setVisibility(View.VISIBLE);
	}

	//正在刷新回调
	@Override
	protected void refreshingImpl() {
		mHeaderImage.setVisibility(View.VISIBLE);
		mHeaderImage.startAnimation(loadAnimation);
	}

	//释放刷新
	@Override
	protected void releaseToRefreshImpl() {
		mHeaderImage.startAnimation(loadAnimation);
	}

	//重新设置
	@Override
	protected void resetImpl() {
		mHeaderImage.clearAnimation();
		/*mHeaderProgress.setVisibility(View.GONE);*/
		mHeaderImage.setVisibility(View.VISIBLE);
	}

}
