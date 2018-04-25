package weizhihui.bwie.com.myquarter.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import weizhihui.bwie.com.myquarter.R;

/**
 * Created by asus on 2018/4/16.
 */

public class Fragment03 extends Fragment {
private ViewPager vp;
    private TabLayout tb;
    private Fragment03Hot fragment03Hot;
    private Fragment03Near fragment03Near;
    private ArrayList<Fragment> arr;
    String[] str={"热门","附近"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shipin,container,false);
        tb= (TabLayout) view.findViewById(R.id.tb);
        vp= (ViewPager) view.findViewById(R.id.frag03vp);
        tb.setupWithViewPager(vp);
        arr=new ArrayList<>();
        fragment03Hot=new Fragment03Hot();
        fragment03Near=new Fragment03Near();
        arr.add(fragment03Hot);
        arr.add(fragment03Near);
        vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return arr.get(position);
            }

            @Override
            public int getCount() {
                return arr.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return str[position];
            }
        });
        return view;
    }
}
