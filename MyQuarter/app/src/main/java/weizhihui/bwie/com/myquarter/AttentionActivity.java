package weizhihui.bwie.com.myquarter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import weizhihui.bwie.com.myquarter.adapter.AttentionAdapter;
import weizhihui.bwie.com.myquarter.bean.AttentionBean;
import weizhihui.bwie.com.myquarter.presenter.AttentionPresenter;
import weizhihui.bwie.com.myquarter.view.AttentionView;

//  我的关注

    public class AttentionActivity extends AppCompatActivity implements AttentionView {

        /**
         * < 返回
         */
        private TextView mGbackid;
        /**
         * 我的关注
         */
        private TextView mGmineid;
        /**
         * 热门关注
         */
        private TextView mGremenid;
        private RecyclerView mGrvid;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_attention);
            initView();
            //点击返回
            mGbackid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            //点击热门关注  展示热门关注的页面
            mGremenid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });
            AttentionPresenter attentionPresenter = new AttentionPresenter(this);
            attentionPresenter.getAttentionPresenter();
            //添加布局管理器
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            mGrvid.setLayoutManager(linearLayoutManager);
        }

        private void initView() {
            mGbackid = (TextView) findViewById(R.id.gbackid);
            mGmineid = (TextView) findViewById(R.id.gmineid);
            mGremenid = (TextView) findViewById(R.id.gremenid);
            mGrvid = (RecyclerView) findViewById(R.id.grvid);
        }

        //数据响应成功的方法
        @Override
        public void onSuccessAtt(AttentionBean attentionBean) {
            List<AttentionBean.DataBean> data = attentionBean.getData();
            //添加适配器
            AttentionAdapter attentionAdapter = new AttentionAdapter(AttentionActivity.this, data);
            mGrvid.setAdapter(attentionAdapter);
            attentionAdapter.setonAttentionListenerAdapter(new AttentionAdapter.onAttentionListenerAdapter() {
                @Override
                public void onSuccess(int position) {
                    Intent intent = new Intent(AttentionActivity.this, ChildAttentionActivity.class);
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
            });

        }
    }

