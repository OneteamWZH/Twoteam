package weizhihui.bwie.com.myquarter;

import android.view.View;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.OnClick;

public class ShareActivity extends BaseActivity {

    @BindView(R.id.video)
    LinearLayout mVideo;
    @BindView(R.id.duanzi)
    LinearLayout mDuanzi;


    @Override
    protected int getRootView() {
        return R.layout.activity_share;
    }

    @Override
    protected void initView() {
        overridePendingTransition(R.anim.zoomin, R.anim.zoomout);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    @OnClick({R.id.video, R.id.duanzi})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.video:
                openActivity(VideoActivity.class);
                break;
            case R.id.duanzi:
                openActivity(DuanZiActivity.class);
                break;
        }
    }

    @Override
    protected void processClick(View v) {

    }
}
