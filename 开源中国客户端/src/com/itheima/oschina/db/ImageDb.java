package com.itheima.oschina.db;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
public class ImageDb {

	public static  ArrayList<String> getImgPathList(Context context) {  
		ArrayList<String> list = new ArrayList<String>();  
		Cursor cursor = context.getContentResolver().query(  
				MediaStore.Images.Media.EXTERNAL_CONTENT_URI,  
				new String[] { "_id", "_data" }, null, null, null);  
		while (cursor.moveToNext()) {  
			list.add(cursor.getString(1));// 将图片路径添加到list中  
		}  
		cursor.close();  
		return list;  
	}  

}
