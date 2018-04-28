package weizhihui.bwie.com.myquarter;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import weizhihui.bwie.com.myquarter.view.activity.BaseActivity;

public class Login_Activity extends BaseActivity {
    @BindView(R.id.ElseLogin)
    TextView ElseLogin;
    @BindView(R.id.hui)
    ImageView mHui;
    @BindView(R.id.weixin)
    ImageView mWx;
    @BindView(R.id.qq)
    ImageView mQq;



    @Override
    protected int getRootView() {
        return R.layout.activity_login_;
    }

    @Override
    protected void initView() {
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    @OnClick({ R.id.hui, R.id.weixin, R.id.qq, R.id.ElseLogin})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hui:
                Intent in = new Intent(Login_Activity.this, MainActivity.class);
                startActivity(in);
                break;
            case R.id.ElseLogin:
                Intent elseLogin = new Intent(Login_Activity.this, ElseLogin_Activity.class);
                startActivity(elseLogin);
                break;
            case R.id.qq:
//              跳转到QQ登录第三方页面  ——琳琳做
                break;
            case R.id.weixin:
//              跳转到微信登录第三方页面  ——琳琳做
                break;
            default:
                break;
        }
    }

    @Override
    protected void processClick(View v) {

    }
}
