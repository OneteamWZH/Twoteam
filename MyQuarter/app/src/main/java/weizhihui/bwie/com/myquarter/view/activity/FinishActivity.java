package weizhihui.bwie.com.myquarter.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import weizhihui.bwie.com.myquarter.ElseLogin_Activity;
import weizhihui.bwie.com.myquarter.R;

public class FinishActivity extends AppCompatActivity {


    /**
     * 完成
     */
    private Button mFinishafterid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        initView();
        //点击完成  跳转到登录页面
        mFinishafterid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FinishActivity.this,ElseLogin_Activity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mFinishafterid = (Button) findViewById(R.id.finishafterid);

    }

}
