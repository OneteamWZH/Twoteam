package weizhihui.bwie.com.myquarter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ElseLogin_Activity extends AppCompatActivity {


    /**
     * 注册账号
     */
    private TextView mRegtelid;
    private ImageView mLoginimgid;
    /**
     * 账号
     */
    private EditText mTelid;
    /**
     * 密码
     */
    private EditText mPwdid;
    private ImageView mElseloginid,mElseloginid2;
    /**
     * 忘记密码
     */
    private TextView mWangjipwdid;
    /**
     * 游客登录
     */
    private TextView mYoukelogin;
    /**
     * 登录
     */
    private Button mElselogin2id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_else_login_);
        initView();

        //点击返回箭头  返回上一个页面
        mElseloginid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //点击登录   游客登录  跳转到推荐页面
        mElselogin2id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ElseLogin_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        mYoukelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ElseLogin_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //点击忘记密码  跳转到忘记密码的页面
        mWangjipwdid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ElseLogin_Activity.this, WangjiPwdActivity.class);
                startActivity(intent);
            }
        });
            //点击注册账号  跳转到注册页面
        mRegtelid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=new Intent(ElseLogin_Activity.this,Reg_Activity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mRegtelid = (TextView) findViewById(R.id.regtelid);
        mLoginimgid = (ImageView) findViewById(R.id.loginimgid);
        mTelid = (EditText) findViewById(R.id.telid);
        mPwdid = (EditText) findViewById(R.id.pwdid);
        mElseloginid = (ImageView) findViewById(R.id.elseloginid);
        mWangjipwdid = (TextView) findViewById(R.id.wangjipwdid);
        mYoukelogin = (TextView) findViewById(R.id.youkelogin);
        mElselogin2id = (Button) findViewById(R.id.elselogin2id);

    }

}

