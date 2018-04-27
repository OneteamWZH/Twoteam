package weizhihui.bwie.com.myquarter;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import weizhihui.bwie.com.myquarter.presenter.UpdatePresenter;

//  修改密码的类
public class UpdatePwdActivity extends BaseActivity implements UpdatePresenter.UpdatePresenterListener {

    @BindView(R.id.back_key)
    ImageView mBackKey;
    @BindView(R.id.mobile)
    EditText mMobile;
    @BindView(R.id.password)
    EditText mPassword;
    @BindView(R.id.completed)
    Button mCompleted;
    @BindView(R.id.relative)
    RelativeLayout mRelative;
    @BindView(R.id.visitor_login)
    TextView mVisitorLogin;
    private UpdatePresenter updatePresenter;

    @Override
    protected int getRootView() {
        return R.layout.activity_update_pwd;
    }

    @Override
    protected void initView() {
        overridePendingTransition(R.anim.zoomin, R.anim.zoomout);

    }

    @Override
    protected void initData() {
        updatePresenter = new UpdatePresenter(this);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void processClick(View v) {

    }


    @Override
    @OnClick({R.id.back_key, R.id.completed,R.id.visitor_login})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back_key:
                break;
            case R.id.completed:
                Intent intent = new Intent(UpdatePwdActivity.this, MainActivity.class);
                startActivity(intent);
              /*  Map<String,String> params = new HashMap<>();
                params.put("uid","1701");
                params.put("oldPassword",mMobile.getText().toString().trim());
                params.put("newPassword",mPassword.getText().toString().trim());
                updatePresenter.getData(params);*/
                break;
            case R.id.visitor_login:
                Intent intent1 = new Intent(UpdatePwdActivity.this, MainActivity.class);
                startActivity(intent1);
                break;
        }
    }

    @Override
    public void succcess(String s) {
        if(s.equals("密码修改成功")){
            finish();
        }
    }
}
