package com.itheima.oschina.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;

import com.itheima.oschina.R;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass. Use the
 * {@link DefaultFragment#newInstance} factory method to create an instance of
 * this fragment.
 * 
 */
public class DefaultFragment extends Fragment {
	private String mParam1;
	
	@InjectView(R.id.tv_content)
	TextView tv_content;

	public DefaultFragment() {
		// Required empty public constructor
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			mParam1 = getArguments().getString("key");
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_default, container, false);
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		ButterKnife.inject(this, view);
		System.out.println(mParam1 + " - 创建完毕");
		initView(view);
	}

	private void initView(View view) {
		if(TextUtils.isEmpty(mParam1)){
			tv_content.setText("我是一个测试用的Fragment, 我创建的时候没有传进来Bundle, 所以显示这个内容.");
		}else {
			tv_content.setText(mParam1);
		}
				
	}

}
