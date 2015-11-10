package com.itheima.oschina.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itheima.oschina.R;
import com.itheima.oschina.ui.view.EmptyLayout;
import com.itheima.oschina.ui.view.PagerSlidingTabStrip;

/**
 * 带有导航条的基类
 * 
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年11月6日 下午4:59:50
 * 
 */
public abstract class BaseViewPagerFragment extends Fragment {

    protected PagerSlidingTabStrip mTabStrip; // ViewPager顶部的导航条
    protected ViewPager mViewPager; // 展示内容用的滚动布局ViewPager
    protected MyViewPagerAdapter mTabsAdapter; // 封装了数据集合的ViewPager适配器
    protected EmptyLayout mErrorLayout; // 布局加载异常时, 显示的空布局.

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	// 填充并返回一个公共的包含导航条和ViewPager的界面
        return inflater.inflate(R.layout.base_viewpage_fragment, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
    	// 导航条, 可以跟随ViewPapger左右滑动.可以设置自定义的导航条内容
        mTabStrip = (PagerSlidingTabStrip) view.findViewById(R.id.pager_tabstrip);
        
        // 可以滑动的ViewPager
        mViewPager = (ViewPager) view.findViewById(R.id.pager);

        // 空布局
        mErrorLayout = (EmptyLayout) view.findViewById(R.id.error_layout);

        // 封装adapter, 注意这里是继承的FragmentStatePagerAdapter, 并且传入的是getChildFragmentManager()
        // 此处封装了PagerSlidingTabStrip, ViewPager, 在Adapter内部进行一系列的初始化.
        mTabsAdapter = new MyViewPagerAdapter(getChildFragmentManager(), mTabStrip, mViewPager);
        
        // 设置ViewPager左右两边保留页面的个数, 这里为空实现, 子类可以重写此方法进行设置
        setScreenPageLimit();
        
        // 通过ViewPageFragmentAdapter设置Tab选项及内容, 抽象方法, 由子类重写进行实现.
        onSetupTabAdapter(mTabsAdapter);

    }

    protected void setScreenPageLimit() {
    }
    
    protected abstract void onSetupTabAdapter(MyViewPagerAdapter adapter);

}