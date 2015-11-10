package com.itheima.oschina.util;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

public class DrawableUtils {

	/**
	 * 生成圆角图片
	 * @param rgb
	 * @param raduis
	 * @return
	 */
	public static GradientDrawable generateDrawable(int rgb,float raduis){
		
		GradientDrawable gradientDrawable = new GradientDrawable();
		gradientDrawable.setShape(GradientDrawable.RECTANGLE);
		gradientDrawable.setCornerRadius(raduis);
		gradientDrawable.setColor(rgb);
		return gradientDrawable;
	}
	
	/**
	 * 生成动态选择器
	 * @param press
	 * @param normal
	 * @return
	 */
	public static StateListDrawable generateSelector(Drawable press,Drawable normal){
		
		StateListDrawable stateListDrawable = new StateListDrawable();
		stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, press);
		stateListDrawable.addState(new int[]{}, normal);
		return stateListDrawable;
	}
	
}
