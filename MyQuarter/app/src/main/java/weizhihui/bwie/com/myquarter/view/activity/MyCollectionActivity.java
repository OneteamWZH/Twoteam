package weizhihui.bwie.com.myquarter.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import weizhihui.bwie.com.myquarter.R;
import weizhihui.bwie.com.myquarter.adapter.Remen_Adapter;
import weizhihui.bwie.com.myquarter.bean.Remen_Bean;
import weizhihui.bwie.com.myquarter.presenter.Remen_Presenter;
import weizhihui.bwie.com.myquarter.view.Remen_View;

public class MyCollectionActivity extends AppCompatActivity implements Remen_View {

    private ImageView mUpdateTop;
    /**
     * 删除
     */
    private TextView mDeleteid;
    private RecyclerView mMCrvid;
    /**
     * 返回
     */
    private TextView mBackid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collection);
        initView();
        Remen_Presenter remen_presenter = new Remen_Presenter(this);
        remen_presenter.getRemen_presenter(1, 1, 1, "android", 101);
        //添加布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mMCrvid.setLayoutManager(linearLayoutManager);
     //点击返回  返回上一个页面
        mBackid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void initView() {
        mUpdateTop = (ImageView) findViewById(R.id.update_top);
        mDeleteid = (TextView) findViewById(R.id.deleteid);
        mMCrvid = (RecyclerView) findViewById(R.id.MCrvid);
        mBackid = (TextView) findViewById(R.id.backid);
    }

    @Override
    public void setRemen_View(Remen_Bean remen_bean) {
        List<Remen_Bean.DataEntity> data = remen_bean.getData();
        Remen_Adapter adapter = new Remen_Adapter(MyCollectionActivity.this, data);
        mMCrvid.setAdapter(adapter);
    }
}
