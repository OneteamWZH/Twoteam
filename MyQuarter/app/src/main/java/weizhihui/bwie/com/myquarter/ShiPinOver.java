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
import weizhihui.bwie.com.myquarter.adapter.Remen_Adapter;
import weizhihui.bwie.com.myquarter.bean.Remen_Bean;
import weizhihui.bwie.com.myquarter.presenter.Remen_Presenter;
import weizhihui.bwie.com.myquarter.view.Remen_View;

public class ShiPinOver extends AppCompatActivity implements Remen_View{
private ImageView over_fan;
    private ImageView over_zhuan;
    private RecyclerView duan_over;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shi_pin_over);
        over_fan= (ImageView) findViewById(R.id.fan_over);
        over_zhuan= (ImageView) findViewById(R.id.over_zhuan);
        duan_over= (RecyclerView) findViewById(R.id.duan_over);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        duan_over.setLayoutManager(linearLayoutManager);
        Remen_Presenter remen_presenter = new Remen_Presenter(this);
        remen_presenter.getRemen_presenter(1,1,1,"android",101);
        //返回上一个界面
        over_fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //分享
        over_zhuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMImage image=new UMImage(ShiPinOver.this,R.drawable.umeng_socialize_qq);
                new ShareAction(ShiPinOver.this).withMedia(image).setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                        .setCallback(umShareListener).open();
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
            Toast.makeText(ShiPinOver.this,"成功 了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(ShiPinOver.this,"失 败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(ShiPinOver.this,"取消                                     了",Toast.LENGTH_LONG).show();

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

    @Override
    public void setRemen_View(Remen_Bean remen_bean) {
        List<Remen_Bean.DataEntity> data = remen_bean.getData();
        Remen_Adapter remen_adapter = new Remen_Adapter(ShiPinOver.this, data);
        duan_over.setAdapter(remen_adapter);
    }
}
