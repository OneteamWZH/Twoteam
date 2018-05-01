package weizhihui.bwie.com.myquarter.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import weizhihui.bwie.com.myquarter.R;

public class RemenAttentionActivity extends AppCompatActivity {

    /**
     * 输入关键字
     */
    private EditText mEdid;
    private TabLayout mRetabid;
    private ViewPager mRepagerid;
    private String tabs[] = {"新闻", "励志", "爆笑", "美食", "网红", "颜值"};
    private MainFragment mainFragment;
    /**
     * 取消
     */
    private TextView mReFinishid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remen_attention);
        initView();
        //tab与viewpager连接在一起
        mRetabid.setupWithViewPager(mRepagerid);
        for (int i = 0; i < tabs.length; i++) {
            mRetabid.addTab(mRetabid.newTab().setText(tabs[i]));
        }

        //实例化Fragment
        final List<Fragment> list = new ArrayList<>();
        for (int i = 0; i < tabs.length; i++) {
            mainFragment = new MainFragment();
            list.add(mainFragment);
            Bundle bundle = new Bundle();
            bundle.putString("tab", tabs[i]);
            mainFragment.setArguments(bundle);

        }
        //给viewpager添加适配器
        mRepagerid.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tabs[position];
            }
        });

        //点击取消按钮  返回上一个页面
        mReFinishid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void initView() {
        mEdid = (EditText) findViewById(R.id.edid);
        mRetabid = (TabLayout) findViewById(R.id.Retabid);
        mRepagerid = (ViewPager) findViewById(R.id.Repagerid);
        mReFinishid = (TextView) findViewById(R.id.ReFinishid);
    }
}
