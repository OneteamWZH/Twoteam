package weizhihui.bwie.com.myquarter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.umeng.analytics.MobclickAgent;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import weizhihui.bwie.com.myquarter.adapter.DuanAdapter;
import weizhihui.bwie.com.myquarter.adapter.ShiPinDuanAdapter;
import weizhihui.bwie.com.myquarter.bean.DuanBean;
import weizhihui.bwie.com.myquarter.bean.ShipinDuanBean;
import weizhihui.bwie.com.myquarter.presenter.DuanPresenter;
import weizhihui.bwie.com.myquarter.presenter.ShiPinDuanPresenter;
import weizhihui.bwie.com.myquarter.view.IView.DuanIview;
import weizhihui.bwie.com.myquarter.view.IView.ShiPinDuanIview;

import static android.R.attr.name;

public class ShipinContent extends AppCompatActivity {
    JCVideoPlayerStandard jcVideoPlayerStandard ;
   private ImageView fanshi,zhuan;
    private ShiPinDuanPresenter shiPinDuanPresenter;
    private RecyclerView duanrv;
    private List<ShipinDuanBean.DataBean> data1;
    private ShiPinDuanAdapter shiPinDuanAdapter;
    private DuanPresenter duanPresenter;
    private DuanAdapter duanAdapter;
    private List<DuanBean.DataBean> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipin_content);
        fanshi= (ImageView) findViewById(R.id.fanshi);
        duanrv= (RecyclerView) findViewById(R.id.duanrv);
        zhuan= (ImageView) findViewById(R.id.zhuan);

        //布局管理器
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        duanrv.setLayoutManager(linearLayoutManager);

        //点击返回
        fanshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //第三方分享
        zhuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMImage image=new UMImage(ShipinContent.this,R.drawable.umeng_socialize_qq);
                new ShareAction(ShipinContent.this).withMedia(image).setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                        .setCallback(umShareListener).open();
            }
        });
        initView();
    }

    private void initView(){
        jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.jc_video);
        String video_url = getIntent().getStringExtra("video_url");// 获取传递过来的bean
        jcVideoPlayerStandard.setUp("http://gslb.miaopai.com/stream/ed5HCfnhovu3tyIQAiv60Q__.mp4", JCVideoPlayerStandard.SCREEN_WINDOW_FULLSCREEN, ""+name);
        jcVideoPlayerStandard.startPlayLogic();  // 开始自动播放

        // 视频的回退按钮设置点击事件
//        jcVideoPlayerStandard.backButton.setOnClickListener(new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                jcVideoPlayerStandard.release(); // 释放视频
//                startActivity(new Intent(ShipinContent.this, MainActivity.class)); // 跳转到上层界面
//                JCPlayerActivity.this.finish(); // 结束当前界面
//            }
//        });
        //段子类表
//        shiPinDuanPresenter=new ShiPinDuanPresenter();
//        shiPinDuanPresenter.ShiDuanDemo("1", "android", "1", new ShiPinDuanIview() {
//            @Override
//            public void OnSuccess(ShipinDuanBean shipinDuanBean) {
//                 data = shipinDuanBean.getData();
//                shiPinDuanAdapter=new ShiPinDuanAdapter(ShipinContent.this,data);
//                duanrv.setAdapter(shiPinDuanAdapter);
//            }
//        });
        duanPresenter=new DuanPresenter();
        duanPresenter.DuanDemo("1", "android", "101", new DuanIview() {
            @Override
            public void OnSuccess(DuanBean duanBean) {
              data = duanBean.getData();
                duanAdapter=new DuanAdapter(ShipinContent.this,data);
                duanrv.setAdapter(duanAdapter);
            }
        });
    }
    private UMShareListener umShareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(ShipinContent.this,"成功 了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(ShipinContent.this,"失 败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(ShipinContent.this,"取消                                     了",Toast.LENGTH_LONG).show();

        }
    };

    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
    @Override
    protected void onDestroy() {
        JCVideoPlayer.releaseAllVideos();
        super.onDestroy();
    }
}
