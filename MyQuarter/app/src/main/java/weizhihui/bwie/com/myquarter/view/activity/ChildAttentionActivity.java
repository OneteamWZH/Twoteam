package weizhihui.bwie.com.myquarter.view.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.util.List;

import weizhihui.bwie.com.myquarter.R;
import weizhihui.bwie.com.myquarter.adapter.Remen_Adapter;
import weizhihui.bwie.com.myquarter.bean.Remen_Bean;
import weizhihui.bwie.com.myquarter.presenter.Remen_Presenter;
import weizhihui.bwie.com.myquarter.view.Remen_View;

public class ChildAttentionActivity extends AppCompatActivity implements Remen_View, View.OnClickListener {

    private ImageView mACimgid;
    private ImageView mACimg2id;
    private SimpleDraweeView mACSimpleId;
    /**
     * 15468962粉丝 |  17关注
     */
    private TextView mACfenid;
    private ImageView mACimgGuanid;
    private RecyclerView mCArvid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_attention);
        initView();
        Uri parse = Uri.parse("res:///" + R.drawable.hui);
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder()
                .setUri(parse)
                .setTapToRetryEnabled(true)
                .build();
        mACSimpleId.setController(build);

        Remen_Presenter remen_presenter = new Remen_Presenter(this);
        remen_presenter.getRemen_presenter(1, 1, 1, "android", 101);
        //添加布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mCArvid.setLayoutManager(linearLayoutManager);
        //点击返回  返回上一个页面
        mACimgid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        mACimgid = (ImageView) findViewById(R.id.ACimgid);
        mACimg2id = (ImageView) findViewById(R.id.ACimg2id);
        mACSimpleId = (SimpleDraweeView) findViewById(R.id.ACSimple_id);
        mACfenid = (TextView) findViewById(R.id.ACfenid);
        mACimgGuanid = (ImageView) findViewById(R.id.ACimgGuanid);
        mCArvid = (RecyclerView) findViewById(R.id.CArvid);
        mACimg2id.setOnClickListener(this);
    }

    @Override
    public void setRemen_View(Remen_Bean remen_bean) {
        List<Remen_Bean.DataEntity> data = remen_bean.getData();
        Remen_Adapter remen_adapter = new Remen_Adapter(ChildAttentionActivity.this, data);
        mCArvid.setAdapter(remen_adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.ACimg2id:
                UMImage image=new UMImage(ChildAttentionActivity.this,R.drawable.umeng_socialize_qq);
                new ShareAction(ChildAttentionActivity.this).withMedia(image).setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                        .setCallback(umShareListener).open();
                break;
        }
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
            Toast.makeText(ChildAttentionActivity.this,"成功 了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(ChildAttentionActivity.this,"失 败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(ChildAttentionActivity.this,"取消",Toast.LENGTH_LONG).show();

        }
    };

}
