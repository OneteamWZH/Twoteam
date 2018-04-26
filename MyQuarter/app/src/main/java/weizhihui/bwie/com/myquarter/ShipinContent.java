package weizhihui.bwie.com.myquarter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

import static android.R.attr.name;

public class ShipinContent extends AppCompatActivity {
    JCVideoPlayerStandard jcVideoPlayerStandard ;
   private ImageView fanshi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipin_content);
        fanshi= (ImageView) findViewById(R.id.fanshi);
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
    }

    @Override
    protected void onDestroy() {
        JCVideoPlayer.releaseAllVideos();
        super.onDestroy();
    }
}
