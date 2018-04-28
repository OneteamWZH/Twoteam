package weizhihui.bwie.com.myquarter;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.OnClick;
import weizhihui.bwie.com.myquarter.presenter.ForgetPresenter;
import weizhihui.bwie.com.myquarter.view.activity.BaseActivity;

//  点击忘记密码跳转来的
public class ForgetActivity extends BaseActivity implements ForgetPresenter.ForgetPresenterListener{

    @BindView(R.id.register)
    TextView mRegister;
    @BindView(R.id.image)
    SimpleDraweeView mImage;
    @BindView(R.id.mobile)
    EditText mMobile;
    @BindView(R.id.password)
    EditText mPassword;
    @BindView(R.id.linear)
    LinearLayout mLinear;
    @BindView(R.id.next)
    Button mNext;
    @BindView(R.id.forgetpwd)
    TextView mForgetpwd;
    @BindView(R.id.relative)
    RelativeLayout mRelative;
    @BindView(R.id.visitor_login)
    TextView mVisitorLogin;
    private ForgetPresenter forgetPresenter;
    @Override
    protected int getRootView() {
        return R.layout.activity_forget;
    }

    @Override
    protected void initView() {
        overridePendingTransition(R.anim.zoomin, R.anim.zoomout);

    }

    @Override
    protected void initData() {
        forgetPresenter = new ForgetPresenter(ForgetActivity.this);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void processClick(View v) {

    }


    @Override
    @OnClick({R.id.next, R.id.visitor_login})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.next:
           /*     Map<String,String> params = new HashMap<>();
                params.put("uid","1701");
                params.put("oldPassword",mMobile.getText().toString().trim());
                params.put("newPassword",mPassword.getText().toString().trim());
                forgetPresenter.getData(params);*/
                Intent intent = new Intent(ForgetActivity.this, UpdatePwdActivity.class);
                startActivity(intent);
                break;
            case R.id.visitor_login:
                Intent intent1 = new Intent(ForgetActivity.this, MainActivity.class);
                startActivity(intent1);
                break;
        }
    }


    @Override
    public void succcess(String s) {
        Intent intent = new Intent(ForgetActivity.this, UpdatePwdActivity.class);
        startActivity(intent);
//        finish();
    }
}
