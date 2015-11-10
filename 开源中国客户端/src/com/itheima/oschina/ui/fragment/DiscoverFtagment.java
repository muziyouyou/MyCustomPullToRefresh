package com.itheima.oschina.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.itheima.oschina.R;
import com.itheima.oschina.util.ToastUtil;

public class DiscoverFtagment extends Fragment implements OnClickListener {

	private View view;
	private LinearLayout discover_activity;
	private LinearLayout discover_find;
	private LinearLayout discover_friends;
	private LinearLayout discover_scan;
	private LinearLayout discover_shake;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return getSuccessView();
	}


	protected View getSuccessView() {
		view = View.inflate(getActivity(), R.layout.discover_fragment, null);
		initView();
		myClick();
		return view;
	}

	private void initView() {

		discover_activity = (LinearLayout) view
				.findViewById(R.id.discover_activity);
		discover_find = (LinearLayout) view.findViewById(R.id.discover_find);
		discover_friends = (LinearLayout) view
				.findViewById(R.id.discover_friends);
		discover_scan = (LinearLayout) view.findViewById(R.id.discover_scan);
		discover_shake = (LinearLayout) view.findViewById(R.id.discover_shake);

		//获取屏幕宽 做适配
		DisplayMetrics outMetrics = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay()
		.getMetrics(outMetrics);
		Log.i("JAVA" , "width:"+outMetrics.widthPixels);
		Log.i("JAVA" , "2222:"+outMetrics);

		int height = (int)(outMetrics.widthPixels*0.17f);
		int blankHeight = (int)(outMetrics.widthPixels*0.06f);

		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(outMetrics.widthPixels,height);
		LinearLayout.LayoutParams blankParams = new LinearLayout.LayoutParams(outMetrics.widthPixels,height);

		discover_activity.setLayoutParams(params);
		discover_shake.setLayoutParams(params);

		blankParams.setMargins(0, blankHeight, 0, 0);
		discover_friends.setLayoutParams(blankParams);
		discover_find.setLayoutParams(blankParams);
		discover_scan.setLayoutParams(blankParams);
	}

	private void myClick() {

		discover_activity.setOnClickListener(this);
		discover_find.setOnClickListener(this);
		discover_friends.setOnClickListener(this);
		discover_scan.setOnClickListener(this);
		discover_shake.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.discover_activity:
			ToastUtil.showToast("discover_activity");
			break;

		case R.id.discover_find:
			ToastUtil.showToast("discover_find");
			break;

		case R.id.discover_friends:
			ToastUtil.showToast("discover_friends");
			break;

		case R.id.discover_scan:
			ToastUtil.showToast("discover_scan");
			break;

		case R.id.discover_shake:
			ToastUtil.showToast("discover_shake");
			break;

		}

	}

}
