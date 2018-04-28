package weizhihui.bwie.com.myquarter.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import weizhihui.bwie.com.myquarter.R;
import weizhihui.bwie.com.myquarter.adapter.AttentionAdapter;
import weizhihui.bwie.com.myquarter.bean.AttentionBean;
import weizhihui.bwie.com.myquarter.presenter.AttentionPresenter;
import weizhihui.bwie.com.myquarter.view.AttentionView;

public class SearchFriendsActivity extends AppCompatActivity implements AttentionView{

    private ImageView mFupdateTop;
    private RecyclerView mFrv1id;
    private RecyclerView mFrv2id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_friends);
        initView();
        mFupdateTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        AttentionPresenter attentionPresenter = new AttentionPresenter(this);
        attentionPresenter.getAttentionPresenter();
        //添加布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mFrv1id.setLayoutManager(linearLayoutManager);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        mFrv2id.setLayoutManager(linearLayoutManager1);

    }

    private void initView() {
        mFupdateTop = (ImageView) findViewById(R.id.Fupdate_top);
        mFrv1id = (RecyclerView) findViewById(R.id.Frv1id);
        mFrv2id = (RecyclerView) findViewById(R.id.Frv2id);
    }

    @Override
    public void onSuccessAtt(AttentionBean attentionBean) {
        List<AttentionBean.DataBean> data = attentionBean.getData();
        //添加适配器
        AttentionAdapter attentionAdapter = new AttentionAdapter(SearchFriendsActivity.this, data);
        mFrv1id.setAdapter(attentionAdapter);
        AttentionAdapter attentionAdapter1 = new AttentionAdapter(SearchFriendsActivity.this, data);
        mFrv2id.setAdapter(attentionAdapter1);

    }
}
