package weizhihui.bwie.com.myquarter;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import weizhihui.bwie.com.myquarter.adapter.Remen_Adapter;
import weizhihui.bwie.com.myquarter.bean.Remen_Bean;
import weizhihui.bwie.com.myquarter.presenter.Remen_Presenter;
import weizhihui.bwie.com.myquarter.view.Remen_View;

public class ChildAttentionActivity extends AppCompatActivity implements Remen_View{

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
        remen_presenter.getRemen_presenter(1,1,1,"android",101);
           //添加布局管理器
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
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
    }

    @Override
    public void setRemen_View(Remen_Bean remen_bean) {
        List<Remen_Bean.DataEntity> data = remen_bean.getData();
        Remen_Adapter remen_adapter = new Remen_Adapter(ChildAttentionActivity.this, data);
        mCArvid.setAdapter(remen_adapter);
    }
}
