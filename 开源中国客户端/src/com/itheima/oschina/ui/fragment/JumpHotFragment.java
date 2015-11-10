package com.itheima.oschina.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.itheima.oschina.ui.fragment.base.BaseFragment;

public class JumpHotFragment extends BaseFragment {

	@Override
	protected View getSuccessView() {
		TextView textView = new TextView(getActivity());
		textView.setText("热门动弹");
		
		return textView;
	}

	@Override
	protected Object requestData() {
		return "2";
	}

}
