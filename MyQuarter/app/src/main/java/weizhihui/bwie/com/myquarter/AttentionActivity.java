package weizhihui.bwie.com.myquarter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
//  我的关注
public class AttentionActivity extends AppCompatActivity {

    /**
     * < 返回
     */
    private TextView mGbackid;
    /**
     * 我的关注
     */
    private TextView mGmineid;
    /**
     * 热门关注
     */
    private TextView mGremenid;
    private RecyclerView mGrvid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attention);
        initView();
    }

    private void initView() {
        mGbackid = (TextView) findViewById(R.id.gbackid);
        mGmineid = (TextView) findViewById(R.id.gmineid);
        mGremenid = (TextView) findViewById(R.id.gremenid);
        mGrvid = (RecyclerView) findViewById(R.id.grvid);
    }
}
