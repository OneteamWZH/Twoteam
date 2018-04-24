package weizhihui.bwie.com.myquarter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Login_Activity extends AppCompatActivity implements View.OnClickListener {


    private ImageView mHui;
    /**
     * 其他登陆方式
     */
    private TextView mElseLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        initView();


    }


    private void initView() {
        mHui = (ImageView) findViewById(R.id.hui);
        mHui.setOnClickListener(this);
        mElseLogin = (TextView) findViewById(R.id.ElseLogin);
        mElseLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.hui:
                Intent in = new Intent(Login_Activity.this, MainActivity.class);
                startActivity(in);
                break;
            case R.id.ElseLogin:
                Intent elseLogin = new Intent(Login_Activity.this, ElseLogin_Activity.class);
                startActivity(elseLogin);
                break;

        }
    }
}
