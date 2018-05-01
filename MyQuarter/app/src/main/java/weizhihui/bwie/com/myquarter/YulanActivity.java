package weizhihui.bwie.com.myquarter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class YulanActivity extends AppCompatActivity {

    private ImageView mYulanImg;
    private String filepath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yulan);
        initView();
        //注册
//        EventBus.getDefault().register(this);
//        SharedPreferences picture = getSharedPreferences("picture", MODE_PRIVATE);
//        filepath = picture.getString("filepath", null);
    }

    private void initView() {
        mYulanImg = (ImageView) findViewById(R.id.yulan_img);
    }
 /*   //处理事件
    public void onEventMainThread(MessageEvent message) {
        //得到MessageEvent
        Bitmap photo = message.getMessage();
        //赋值
        Glide.with(this).load(filepath).into(mYulanImg);
    }
    //关闭/解除注册
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }*/

}
