package com.itheima.oschina.bean;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class SpaceItemDecrotion extends RecyclerView.ItemDecoration {

	private int mSpace;
	public SpaceItemDecrotion(int space){
		mSpace=space;
	}

	@Override
	public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
			State state) {
		outRect.left=mSpace;
		outRect.right=mSpace;
		outRect.bottom=mSpace;
		int childPosition = parent.getChildPosition(view);
		if(childPosition==0){
			outRect.top=mSpace;
		}
	}

}
