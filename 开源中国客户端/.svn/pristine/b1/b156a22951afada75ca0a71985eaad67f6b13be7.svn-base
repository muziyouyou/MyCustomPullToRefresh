package com.itheima.oschina.ui.adapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itheima.oschina.R;
import com.itheima.oschina.global.ImageLoaderOptions;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyHolder> {

	DisplayImageOptions options; 
	ArrayList<String> listImgPath;  
	String[] imageUriArray;
	public RecycleAdapter(ArrayList<String> list){
		listImgPath=list;
		// list转成数组  
		imageUriArray = (String[]) listImgPath.toArray(new String[listImgPath.size()]);
		System.out.println("获取图片数组"+imageUriArray.length);
		// 配置图片加载及显示选项（还有一些其他的配置，查阅doc文档吧）  
		 options = new DisplayImageOptions.Builder()
		.showImageOnLoading(R.drawable.ic_launcher)
		.showImageOnFail(R.drawable.ic_launcher).cacheInMemory(true)
		.cacheOnDisk(true).bitmapConfig(Bitmap.Config.RGB_565).build();
	}



	@Override
	public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		View view = View.inflate(parent.getContext(), R.layout.item_recycle, null);
		return new MyHolder(view);
	}

	@Override
	public void onBindViewHolder(MyHolder holder, int position) {

		holder.textView.setText("大熊");
		ImageLoader.getInstance().displayImage("file:///"+imageUriArray[position], holder.imageView,options);
	}

	@Override
	public int getItemCount() {
		return imageUriArray.length;
	}


	/**
	 * 设置ViewHolder
	 * @author lishu_000
	 *
	 */
	public static class MyHolder extends RecyclerView.ViewHolder{


		ImageView imageView;
		TextView textView;
		public MyHolder(View view) {
			super(view);
			imageView=(ImageView) view.findViewById(R.id.iv_item_recycle);
			textView=(TextView) view.findViewById(R.id.tv_item_recycle);
		}
	}

	/** 图片加载监听事件 **/  
	private static class AnimateFirstDisplayListener extends  SimpleImageLoadingListener {  
		static final List<String> displayedImages = Collections  
				.synchronizedList(new LinkedList<String>());  
		@Override  
		public void onLoadingComplete(String imageUri, View view,  
				Bitmap loadedImage) {  
			if (loadedImage != null) {  
				ImageView imageView = (ImageView) view;  
				boolean firstDisplay = !displayedImages.contains(imageUri);  
				if (firstDisplay) {  
					FadeInBitmapDisplayer.animate(imageView, 500); // 设置image隐藏动画500ms  
					displayedImages.add(imageUri); // 将图片uri添加到集合中  
				}  
			}  
		}  
	}  

}
