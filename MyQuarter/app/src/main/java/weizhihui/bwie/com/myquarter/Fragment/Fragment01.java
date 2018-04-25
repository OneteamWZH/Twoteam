package weizhihui.bwie.com.myquarter.Fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import weizhihui.bwie.com.myquarter.R;

/**
 * Created by asus on 2018/4/16.
 */

public class Fragment01 extends Fragment {


    private String[] tabs = {"热门", "关注"};
    private View view;
    private TabLayout mTabid;
    private ViewPager mPager;
    private MainFragment mainFragment;
    private List<Fragment> fragmentList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tuijian, container, false);
        initView(view);
        mTabid.setupWithViewPager(mPager);
        for (int i=0;i<tabs.length;i++){
            mTabid.addTab(mTabid.newTab().setText(tabs[i]));
        }

        mTabid.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(mTabid,60,60);
            }
        });


        fragmentList = new ArrayList<>();
        for (int i=0;i<tabs.length;i++){
            mainFragment = new MainFragment();
            Bundle bundle=new Bundle();
            bundle.putString("tab",tabs[i]);
            mainFragment.setArguments(bundle);
            fragmentList.add(mainFragment);
        }
        //viewpager添加适配器
        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        mPager.setAdapter(new FragmentPagerAdapter(supportFragmentManager) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tabs[position];
            }
        });
        return view;
    }


    private void initView(View view) {
        mTabid = (TabLayout) view.findViewById(R.id.tabid);
        mPager = (ViewPager) view.findViewById(R.id.pager);
    }

    public void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }
}
