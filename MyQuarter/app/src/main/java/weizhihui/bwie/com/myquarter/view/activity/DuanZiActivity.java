package weizhihui.bwie.com.myquarter.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import weizhihui.bwie.com.myquarter.R;
import weizhihui.bwie.com.myquarter.ShareActivity;
import weizhihui.bwie.com.myquarter.presenter.PublishPresenter;

public class DuanZiActivity extends BaseActivity implements PublishPresenter.PublishPresenterListener {


    private TextView publishContent;
    private EditText publishEdit;
    private PublishPresenter presenter;
    private TextView iconTou;

    @Override
    protected int getRootView() {

        return R.layout.activity_duan_zi;
    }

    @Override
    protected void initView() {

        iconTou = (TextView) findViewById(R.id.iconTou);
        publishContent = (TextView) findViewById(R.id.publish_top);
        publishEdit = (EditText) findViewById(R.id.publishEit);
    }

    @Override
    protected void initData() {
        presenter = new PublishPresenter(this);

    }

    @Override
    protected void initListener() {
        publishContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //https://www.zhaoapi.cn/quarter/publishJoke?uid=1701&content=%E4%BD%A0%E5%A5%BD%E4%B8%96%E7%95%8C%E4%BD%A0%E5%A5%BD%E4%B8%96%E7%95%8C&token=E6C4C1B581A506F2F4D6748B3649AD3C&source=android&appVersion=101
                Map<String, String> map = new HashMap<>();

                if (!publishEdit.getText().toString().equals("")) {

                    map.put("content", publishEdit.getText().toString());
                    map.put("uid", "1701");
                    map.put("token", "E6C4C1B581A506F2F4D6748B3649AD3C");
                }
                presenter.getData(map);
            }
        });
        iconTou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DuanZiActivity.this, ShareActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void processClick(View v) {

    }

    @Override
    public void success(String s) {
        if (s.equals("发布成功")) {
            showShort(s);
        } else {
            showShort(s);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO:OnCreate Method has been created, run FindViewById again to generate code
        setContentView(R.layout.activity_duan_zi);
        initView();
    }
}