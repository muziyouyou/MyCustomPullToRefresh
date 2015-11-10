package com.itheima.oschina.global;

import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.itheima.oschina.R;
public interface ImageLoaderOptions {
	DisplayImageOptions options = new DisplayImageOptions.Builder()
	.showImageOnLoading(R.drawable.astonished)// 加载图片过程中显示哪张图片
	.showImageForEmptyUri(R.drawable.astonished)// url为空的话显示哪张图片
	.showImageOnFail(R.drawable.astonished)// 加载图片失败显示哪张图片
	.cacheInMemory(true)// 在内存中缓存该图片
	.cacheOnDisk(true)// 在硬盘中缓存该图片
	.imageScaleType(ImageScaleType.EXACTLY)//将会对图片进一步缩放，缩放的程度参考ImageVIew的宽高
	.bitmapConfig(Bitmap.Config.RGB_565)//该种渲染模式也是比较节省内存的
	.considerExifParams(true)// 会识别图片的方向信息
	// .displayer(new FadeInBitmapDisplayer(800)).build();//渐渐显示的动画效果
	.displayer(new RoundedBitmapDisplayer(28)).build();// 圆角的效果

	//显示大图的options
	DisplayImageOptions pager_options = new DisplayImageOptions.Builder()
	.showImageOnLoading(R.drawable.astonished)// 加载图片过程中显示哪张图片
	.showImageForEmptyUri(R.drawable.astonished)// url为空的话显示哪张图片
	.showImageOnFail(R.drawable.astonished)// 加载图片失败显示哪张图片
	.cacheInMemory(false)// 不在内存中缓存该图片
	.cacheOnDisk(true)// 在硬盘中缓存该图片
	.imageScaleType(ImageScaleType.EXACTLY)//将会对图片进一步缩放，缩放的程度参考ImageVIew的宽高
	.bitmapConfig(Bitmap.Config.RGB_565)//该种渲染模式也是比较节省内存的
	.considerExifParams(true)// 会识别图片的方向信息
	.displayer(new FadeInBitmapDisplayer(800)).build();//渐渐显示的动画效果
	//	.displayer(new RoundedBitmapDisplayer(28)).build();// 圆角的效果
}
