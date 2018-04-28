package weizhihui.bwie.com.myquarter.view.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import weizhihui.bwie.com.myquarter.CameraActivity;
import weizhihui.bwie.com.myquarter.R;
import weizhihui.bwie.com.myquarter.RecordingActivity;

public class VideoActivity extends BaseActivity {

    private ImageView goToPhoto;

    @Override
    protected int getRootView() {
        return R.layout.activity_video;
    }

    @Override
    protected void initView() {
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
        goToPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(VideoActivity.this)
                        .setTitle("选择您想要实现的功能")
                        .setMessage("相机")
                        .setPositiveButton("拍照", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(VideoActivity.this, "点击拍照成功", Toast.LENGTH_SHORT).show();
//                                调取系统相机进行拍照
                                Intent intent = new Intent(VideoActivity.this, CameraActivity.class);
                                startActivity(intent);

                            }
                        }).setNegativeButton("录像", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(VideoActivity.this, "点击录像成功！", Toast.LENGTH_SHORT).show();
//                                调取系统摄像机进行录制视频
                        Intent intent = new Intent(VideoActivity.this, RecordingActivity.class);
                        startActivity(intent);

                    }
                }).create().show();
            }
        });
    }

    @Override
    protected void processClick(View v) {

    }
}
