package com.itheima.oschina.global;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

public class GooglePlayApplication extends Application{
	private static Context context;//全局的上下文
	private static Handler mainHandler;//全局的主线程handler
	/**
	 * app的入口函数
	 */
	@Override
	public void onCreate() {
		super.onCreate();
		
		//初始化COntext
		context = this;
		//初始化mainHandler,在主线程创建的handler就是主线程的handler
		mainHandler = new Handler();
		//初始化IMageLoader
		initImageLoader(this);
	}
	
	public static void initImageLoader(Context context) {
		ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
		config.threadPriority(Thread.NORM_PRIORITY - 2);
		config.denyCacheImageMultipleSizesInMemory();//不会在内存中缓存多个大小的图片
		config.diskCacheFileNameGenerator(new Md5FileNameGenerator());//为了保证图片名称唯一
		config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
		//内存缓存大小默认是：app可用内存的1/8
		config.tasksProcessingOrder(QueueProcessingType.LIFO);
		config.writeDebugLogs(); // Remove for release app
		ImageLoader.getInstance().init(config.build());
	}
	
	/**
	 * 获取全局的上下文
	 * @return
	 */
	public static Context getContext(){
		return context;
	}
	
	public static Handler getMainHandler(){
		return mainHandler;
	}
}
