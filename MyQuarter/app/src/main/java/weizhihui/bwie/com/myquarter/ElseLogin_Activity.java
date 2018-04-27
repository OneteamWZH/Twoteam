package weizhihui.bwie.com.myquarter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import weizhihui.bwie.com.myquarter.presenter.LoginPresenter;
//  账号密码登录界面
public class ElseLogin_Activity extends BaseActivity  implements LoginPresenter.LoginPresenterListener{



//   返回主登陆界面
    @BindView(R.id.elseloginid)
    ImageView mElseloginid;
//    注册账号
    @BindView(R.id.regtelid)
    TextView mRegtelid;
//    账号
    @BindView(R.id.telid)
    EditText mTelid;
//    密码
    @BindView(R.id.pwdid)
    EditText mPwdid;
//    登陆
    @BindView(R.id.elselogin2id)
    Button mElselogin2id;
//    忘记密码
    @BindView(R.id.wangjipwdid)
    TextView mWangjipwdid;
//    游客登陆
    @BindView(R.id.youkelogin)
    TextView mYoukelogin;

    private LoginPresenter loginPresenter;
    private ImageView mLoginimgid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //点击返回箭头  返回上一个页面
        mElseloginid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //  登陆按钮 点击进入展示主界面
        mElselogin2id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,String> params = new HashMap<>();

                params.put("mobile",mTelid.getText().toString().trim());
                params.put("password",mPwdid.getText().toString().trim());
                loginPresenter.getData(params);

                    new LoginPresenter(new LoginPresenter.LoginPresenterListener() {
                        @Override
                        public void success(String s) {
                            if(("登录成功").equals(s)){
                                Toast.makeText(ElseLogin_Activity.this, s, Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(ElseLogin_Activity.this, MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(ElseLogin_Activity.this, s, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
              /*  }*/




             /*   Intent intent = new Intent(ElseLogin_Activity.this, MainActivity.class);
                startActivity(intent);*/
            }
        });
        //点击登录   游客登录  跳转到推荐页面
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
                Intent intent = new Intent(ElseLogin_Activity.this, ForgetActivity.class);
                startActivity(intent);
            }
        });

        mRegtelid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ElseLogin_Activity.this, Reg_Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int getRootView() {
        return R.layout.activity_else_login_;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void processClick(View v) {

    }

    public void initView() {
        mRegtelid = (TextView) findViewById(R.id.regtelid);
        ImageView mLoginimgid = (ImageView) findViewById(R.id.loginimgid);
        mTelid = (EditText) findViewById(R.id.telid);
       EditText mPwdid = (EditText) findViewById(R.id.pwdid);
        mElseloginid = (ImageView) findViewById(R.id.elseloginid);
        mWangjipwdid = (TextView) findViewById(R.id.wangjipwdid);
        mYoukelogin = (TextView) findViewById(R.id.youkelogin);
        mElselogin2id = (Button) findViewById(R.id.elselogin2id);
        overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
    }

    @Override
    protected void initData() {

        loginPresenter = new LoginPresenter(this);

    }
    @Override
    public void success(String s) {
        if(("登录成功").equals(s)){
            showShort(s);
            openActivity(MainActivity.class);
        }else{
            showShort(s);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.detach();
    }
}

