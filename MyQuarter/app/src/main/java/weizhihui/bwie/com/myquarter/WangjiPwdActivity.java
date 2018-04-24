package weizhihui.bwie.com.myquarter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class WangjiPwdActivity extends AppCompatActivity {

    private ImageView mWangjiloginid;
    /**
     * 已有账号
     */
    private TextView mWangjitelid;
    private ImageView mWangjilogin2imgid;
    /**
     * 密码
     */
    private EditText mWangjipwdid;
    /**
     * 下一步
     */
    private Button mWangjiafterid;
    /**
     * 游客登录
     */
    private TextView mWangjiyoukelogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wangji_pwd);
        initView();
        //点击返回箭头  返回上一个页面
        mWangjiloginid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //点击下一步
        mWangjiafterid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(WangjiPwdActivity.this,FinishActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mWangjiloginid = (ImageView) findViewById(R.id.wangjiloginid);
        mWangjitelid = (TextView) findViewById(R.id.wangjitelid);
        mWangjilogin2imgid = (ImageView) findViewById(R.id.wangjilogin2imgid);
        mWangjitelid = (EditText) findViewById(R.id.wangjitel2id);
        mWangjipwdid = (EditText) findViewById(R.id.wangjipwdid);
        mWangjiafterid = (Button) findViewById(R.id.wangjiafterid);
        mWangjiyoukelogin = (TextView) findViewById(R.id.wangjiyoukelogin);
    }
}
