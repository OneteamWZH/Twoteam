package weizhihui.bwie.com.myquarter;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

public class ChildAttentionActivity extends AppCompatActivity {

    private ImageView mACimgid;
    private ImageView mACimg2id;
    private SimpleDraweeView mACSimpleId;
    /**
     * 15468962粉丝 |  17关注
     */
    private TextView mACfenid;
    private ImageView mACimgGuanid;
    private RecyclerView mCArvid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_attention);
        initView();
        Uri parse = Uri.parse("res:///" + R.drawable.hui);
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder()
                .setUri(parse)
                .setTapToRetryEnabled(true)
                .build();
        mACSimpleId.setController(build);

    }

    private void initView() {
        mACimgid = (ImageView) findViewById(R.id.ACimgid);
        mACimg2id = (ImageView) findViewById(R.id.ACimg2id);
        mACSimpleId = (SimpleDraweeView) findViewById(R.id.ACSimple_id);
        mACfenid = (TextView) findViewById(R.id.ACfenid);
        mACimgGuanid = (ImageView) findViewById(R.id.ACimgGuanid);
        mCArvid = (RecyclerView) findViewById(R.id.CArvid);
    }
}
