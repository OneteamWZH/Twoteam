package weizhihui.bwie.com.myquarter.view.activity;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import weizhihui.bwie.com.myquarter.R;

public class VideoActivity  extends BaseActivity {


    private LinearLayout backToShare;
    private ImageView goToPhoto;

    @Override
    protected int getRootView() {
        return R.layout.activity_video;
    }

    @Override
    protected void initView() {
        backToShare = (LinearLayout) findViewById(R.id.backToShare);
        goToPhoto = (ImageView) findViewById(R.id.goToPhoto);

    }

    @Override
    protected void initData() {
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.simple);
        // getData();
        DraweeController mDraweeController = Fresco.newDraweeControllerBuilder()
                .setAutoPlayAnimations(true)
                //设置uri,加载本地的gif资源
                //设置uri
                .setUri(Uri.parse("res://"+getPackageName()+"/"+R.drawable.video_backgroud))
                .build();
        //设置Controller
        simpleDraweeView.setController(mDraweeController);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void processClick(View v) {

    }
}