package weizhihui.bwie.com.myquarter;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import weizhihui.bwie.com.myquarter.presenter.RegisterPresenter;
import weizhihui.bwie.com.myquarter.view.activity.BaseActivity;

//  注册账号页面
public class Reg_Activity extends BaseActivity implements RegisterPresenter.RegisterPresenterListener {

    @BindView(R.id.back_key)
    ImageView mBackKey;
    @BindView(R.id.register)
    TextView mRegister;
    @BindView(R.id.reg_admin)
    EditText mRegAdmin;
    @BindView(R.id.reg_pwd)
    EditText mRegPwd;
    @BindView(R.id.lregister)
    Button mLregister;
    @BindView(R.id.reg_visitor)
    TextView mRegVisitor;
    private RegisterPresenter registerPresenter;


    @Override
    protected int getRootView() {
        return R.layout.activity_reg_;
    }

    @Override
    protected void initView() {
        overridePendingTransition(R.anim.zoomin, R.anim.zoomout);

    }

    @Override
    protected void initData() {
        registerPresenter = new RegisterPresenter(this);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void processClick(View v) {

    }

    @Override
    @OnClick({R.id.back_key, R.id.register, R.id.lregister, R.id.reg_visitor})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back_key:
                finish();
                break;
            case R.id.register:
                //已有账号登录
                break;
            case R.id.lregister:
                //注册
                Map<String,String> params = new HashMap<>();
                params.put("mobile",mRegAdmin.getText().toString());
                params.put("password",mRegPwd.getText().toString());
                registerPresenter.getData(params);
                break;
            case R.id.reg_visitor:
                //游客登录
                Intent intent = new Intent(Reg_Activity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void success(String s) {
        if(("0").equals(s)){
            showShort("注册成功");
        }else{
            showShort("注册失败");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        registerPresenter.detach();
    }
}
