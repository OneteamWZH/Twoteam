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
import weizhihui.bwie.com.myquarter.utils.UIUtils;
import weizhihui.bwie.com.myquarter.view.activity.AttentionActivity;
import weizhihui.bwie.com.myquarter.view.activity.MessageActivity;
import weizhihui.bwie.com.myquarter.view.activity.MyCollectionActivity;
import weizhihui.bwie.com.myquarter.view.activity.MyWorksActivity;
import weizhihui.bwie.com.myquarter.view.activity.SearchFriendsActivity;
import weizhihui.bwie.com.myquarter.view.activity.SettingActivity;


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
    /**
     * 我的关注
     */
    private TextView mGuanzhuId;
    /**
     * 我的收藏
     */
    private TextView mShoucangId;
    /**
     * 搜索好友
     */
    private TextView mSousuoId;
    /**
     * 消息通知
     */
    private TextView mTongzhiId;
    private ImageView mFolderId;
    private ImageView mShezhiImg;
    /**
     * 夜间模式
     */
    private TextView mYeId;
    private int theme = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //切换主题必须放在onCreate()之前

        if (savedInstanceState == null) {
//                如果么有
            theme = UIUtils.getAppTheme(MainActivity.this);
        } else {
            theme = savedInstanceState.getInt("theme");
        }
//        可以设置主题的 方法 在oncreate之前调用
        setTheme(theme);
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
                        switch (position) {
                            case 0:
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

        //点击侧拉里面的头像跳转到登录页面
        mSimpleClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, Login_Activity.class);
                startActivity(in);
            }
        });
        //我的关注点击事件
        mGuanzhuId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AttentionActivity.class);
                startActivity(intent);
            }
        });
        //点击我的收藏
        mShoucangId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyCollectionActivity.class);
                startActivity(intent);
            }
        });
        //点击搜索好友
        mSousuoId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchFriendsActivity.class);
                startActivity(intent);
            }
        });
        //点击消息通知
        mTongzhiId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                startActivity(intent);
            }
        });
        //点击我的作品
        mFolderId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyWorksActivity.class);
                startActivity(intent);
            }
        });
        //点击设置
        mShezhiImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);

            }
        });
        //点击夜间模式
        mYeId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIUtils.switchAppTheme(MainActivity.this);
                load();
            }
        });

    }
    //    切换之间的动画
    public void load() {

        Intent intent = getIntent();

        overridePendingTransition(R.anim.in

                , R.anim.out);//进入动画

        finish();

        overridePendingTransition(R.anim.in

                , R.anim.out);
        startActivity(intent);

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
        mGuanzhuId = (TextView) findViewById(R.id.Guanzhu_id);
        mShoucangId = (TextView) findViewById(R.id.Shoucang_id);
        mSousuoId = (TextView) findViewById(R.id.Sousuo_id);
        mTongzhiId = (TextView) findViewById(R.id.Tongzhi_id);
        mFolderId = (ImageView) findViewById(R.id.Folder_id);
        mShezhiImg = (ImageView) findViewById(R.id.Shezhi_img);
        mYeId = (TextView) findViewById(R.id.Ye_id);
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
