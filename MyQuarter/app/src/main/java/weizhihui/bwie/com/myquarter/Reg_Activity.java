package weizhihui.bwie.com.myquarter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Reg_Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mRegbackid;
    /**
     * 已有账号
     */
    private TextView mReghaveid;
    private ImageView mRegimgid;
    /**
     * 账号
     */
    private EditText mRegtelid;
    /**
     * 密码
     */
    private EditText mRegpwdid;
    /**
     * 注册
     */
    private Button mRegbtnid;
    /**
     * 游客登录
     */
    private TextView mWangjiyoukelogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_);
        initView();


    }


    private void initView() {
        mRegbackid = (ImageView) findViewById(R.id.regbackid);
        mRegbackid.setOnClickListener(this);
        mReghaveid = (TextView) findViewById(R.id.reghaveid);
        mReghaveid.setOnClickListener(this);
        mRegimgid = (ImageView) findViewById(R.id.regimgid);
        mRegimgid.setOnClickListener(this);
        mRegtelid = (EditText) findViewById(R.id.regtelid);
        mRegtelid.setOnClickListener(this);
        mRegpwdid = (EditText) findViewById(R.id.regpwdid);
        mRegpwdid.setOnClickListener(this);
        mRegbtnid = (Button) findViewById(R.id.regbtnid);
        mRegbtnid.setOnClickListener(this);
        mWangjiyoukelogin = (TextView) findViewById(R.id.wangjiyoukelogin);
        mWangjiyoukelogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.regbackid:
                //点击返回键 返回上一个页面
                finish();

                break;
            case R.id.reghaveid:
                break;
            case R.id.regimgid:
                break;
            case R.id.regtelid:
                break;
            case R.id.regpwdid:

                break;
            case R.id.regbtnid:
                Intent intent=new Intent(Reg_Activity.this,ElseLogin_Activity.class);
                startActivity(intent);
                break;
            case R.id.wangjiyoukelogin:
                break;
        }
    }
}
