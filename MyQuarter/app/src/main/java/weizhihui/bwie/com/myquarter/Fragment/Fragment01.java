package weizhihui.bwie.com.myquarter.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import weizhihui.bwie.com.myquarter.R;

/**
 * Created by asus on 2018/4/16.
 */

public class Fragment01 extends Fragment implements View.OnClickListener {

    private View view;

    private ViewPager mPager;
    /**
     * 热门
     */
    private RadioButton mBtn1;
    /**
     * 关注
     */
    private RadioButton mBtn2;
    private RadioGroup mGroup;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tuijian, container, false);
        initView(view);


        final List<Fragment> list = new ArrayList<>();
        list.add(new Frag_pager01());
        list.add(new Frag_pager02());

        mPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        mPager.setCurrentItem(0);

        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0 :
                        mGroup.check(R.id.btn1);
                        break;
                    case 1:
                        mGroup.check(R.id.btn2);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.btn1 :

                        mPager.setCurrentItem(0);
                        break;
                    case R.id.btn2 :
                        mPager.setCurrentItem(1);
                        break;
                }
            }
        });


        return view;
    }

    private void initView(View view) {

        mPager = (ViewPager) view.findViewById(R.id.pager);

        mBtn1 = (RadioButton) view.findViewById(R.id.btn1);
        mBtn1.setOnClickListener(this);
        mBtn2 = (RadioButton) view.findViewById(R.id.btn2);
        mBtn2.setOnClickListener(this);
        mGroup = (RadioGroup) view.findViewById(R.id.Group);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn1:
                break;
            case R.id.btn2:
                break;
        }
    }
}
