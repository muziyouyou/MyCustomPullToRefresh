package com.itheima.oschina.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * 功能,主要是用来遮挡住界面,显示弹窗
 * @author lishu_000
 *
 */
public class MyRelative extends RelativeLayout {

	public MyRelative(Context context) {
		super(context);
	}
	public MyRelative(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	public MyRelative(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {

		LinearLayout ll_mian_alert = (LinearLayout) getChildAt(0);
		float y = event.getY();
		if(y<ll_mian_alert.getTop()){
				mOnCloseWindowistener.closeWindow();
		}
		return true;
	}


	private OnCloseWindowistener mOnCloseWindowistener;
	public interface OnCloseWindowistener{

		public void closeWindow();
	}
	public void setCloseWindowistener(OnCloseWindowistener onCloseWindowistener){
		mOnCloseWindowistener=onCloseWindowistener;
	}
}
