package weizhihui.bwie.com.myquarter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;

import weizhihui.bwie.com.myquarter.Fragment.Fragment01;
import weizhihui.bwie.com.myquarter.Fragment.Fragment02;
import weizhihui.bwie.com.myquarter.Fragment.Fragment03;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BottomTabBar mBar;
    private SimpleDraweeView mSimpleId;
    private ImageView mShare;
    private DrawerLayout mDeawer;
    private RelativeLayout mLeft;
    private SimpleDraweeView mSimpleClick;
    /**
     * 推荐
     */
    private TextView mTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


        //加载圆形图片
        Uri uri = Uri.parse("res:///" + R.mipmap.hui);
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setTapToRetryEnabled(true)
                .build();
        mSimpleId.setController(build);

        //加载圆形图片
        Uri uri1 = Uri.parse("res:///" + R.mipmap.hui);
        AbstractDraweeController build1 = Fresco.newDraweeControllerBuilder()
                .setUri(uri1)
                .setTapToRetryEnabled(true)
                .build();
        mSimpleClick.setController(build1);

        //底部按钮
        mBar.init(getSupportFragmentManager())
                .setFontSize(0)
                .addTabItem("", R.drawable.tuijian2, R.drawable.tuijian1, Fragment01.class)
                .addTabItem("", R.drawable.duanzi2, R.drawable.duanzi1, Fragment02.class)
                .addTabItem("", R.drawable.shipin2, R.drawable.shipin1, Fragment03.class)

                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                        switch (position){
                            case  0:
                                mTitle.setText("推荐");
                                break;
                            case 1:
                                mTitle.setText("段子");
                                break;
                            case 2:
                                mTitle.setText("视频");
                                break;

                        }
                    }
                });




        //点击头像弹出侧拉菜单
        mSimpleId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDeawer.openDrawer(mLeft);
            }
        });

        //电解侧拉里面的头像跳转到登录页面
        mSimpleClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, Login_Activity.class);
                startActivity(in);
            }
        });


    }

    private void initView() {
        mBar = (BottomTabBar) findViewById(R.id.bar);
        mSimpleId = (SimpleDraweeView) findViewById(R.id.Simple_id);
        mShare = (ImageView) findViewById(R.id.Share);
        mShare.setOnClickListener(this);
        mDeawer = (DrawerLayout) findViewById(R.id.Deawer);
        mLeft = (RelativeLayout) findViewById(R.id.left);
        mSimpleClick = (SimpleDraweeView) findViewById(R.id.Simple_click);
        mTitle = (TextView) findViewById(R.id.title);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.Share:
                Intent in = new Intent(MainActivity.this, ShareActivity.class);
                startActivity(in);
                break;
        }
    }
}
