package weizhihui.bwie.com.myquarter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import weizhihui.bwie.com.myquarter.adapter.ShiPinDuanAdapter;
import weizhihui.bwie.com.myquarter.bean.ShipinDuanBean;
import weizhihui.bwie.com.myquarter.presenter.ShiPinDuanPresenter;
import weizhihui.bwie.com.myquarter.view.IView.ShiPinDuanIview;

import static android.R.attr.name;

public class ShipinContent extends AppCompatActivity {
    JCVideoPlayerStandard jcVideoPlayerStandard ;
   private ImageView fanshi;
    private ShiPinDuanPresenter shiPinDuanPresenter;
    private RecyclerView duanrv;
    private List<ShipinDuanBean.DataBean> data;
    private ShiPinDuanAdapter shiPinDuanAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipin_content);
        fanshi= (ImageView) findViewById(R.id.fanshi);
        duanrv= (RecyclerView) findViewById(R.id.duanrv);
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
        shiPinDuanPresenter=new ShiPinDuanPresenter();
        shiPinDuanPresenter.ShiDuanDemo("1", "android", "1", new ShiPinDuanIview() {
            @Override
            public void OnSuccess(ShipinDuanBean shipinDuanBean) {
                 data = shipinDuanBean.getData();
                shiPinDuanAdapter=new ShiPinDuanAdapter(ShipinContent.this,data);
                duanrv.setAdapter(shiPinDuanAdapter);
            }
        });
    }

    @Override
    protected void onDestroy() {
        JCVideoPlayer.releaseAllVideos();
        super.onDestroy();
    }
}