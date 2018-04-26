package weizhihui.bwie.com.myquarter.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import weizhihui.bwie.com.myquarter.R;
import weizhihui.bwie.com.myquarter.bean.Remen_Bean;

/**
 * Created by asus on 2018/4/26.
 */

public class Remen_Adapter extends RecyclerView.Adapter<Remen_Adapter.Ada>{

    private Context context;
    private List<Remen_Bean.DataEntity> list;

    public Remen_Adapter(Context context, List<Remen_Bean.DataEntity> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Remen_Adapter.Ada onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(context).inflate(R.layout.item_video, parent, false);
        Ada a = new Ada(inflate);

        return a;
    }

    @Override
    public void onBindViewHolder(final Remen_Adapter.Ada holder, int position) {

        Remen_Bean.DataEntity dataEntity = list.get(position);
        String videoUrl = dataEntity.getVideoUrl();
        String workDesc = dataEntity.getWorkDesc();
        Remen_Bean.DataEntity.UserEntity user = dataEntity.getUser();
        String icon = user.getIcon();
        String nickname = (String) user.getNickname();
        String createTime = dataEntity.getCreateTime();

        holder.name.setText(nickname);
        holder.time.setText(createTime);
        holder.cotent.setText("天气美美的，适合郊游");
        holder.jiecao.setUp("http://gslb.miaopai.com/stream/ed5HCfnhovu3tyIQAiv60Q__.mp4",holder.jiecao.SCREEN_LAYOUT_NORMAL,"");

        Uri uri = Uri.parse(icon);
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setTapToRetryEnabled(true)
                .build();
        holder.img.setController(build);

        Uri uri5 = Uri.parse("res:///" + R.drawable.pingbi);
        AbstractDraweeController build5 = Fresco.newDraweeControllerBuilder()
                .setUri(uri5)
                .setTapToRetryEnabled(true)
                .build();
        holder.pius.setController(build5);

        Uri uri4 = Uri.parse("res:///" + R.drawable.fuzhi);
        AbstractDraweeController build4 = Fresco.newDraweeControllerBuilder()
                .setUri(uri4)
                .setTapToRetryEnabled(true)
                .build();
        holder.pius.setController(build4);

        Uri uri3 = Uri.parse("res:///" + R.drawable.jubao);
        AbstractDraweeController build3 = Fresco.newDraweeControllerBuilder()
                .setUri(uri3)
                .setTapToRetryEnabled(true)
                .build();
        holder.pius.setController(build3);

        Uri uri2 = Uri.parse("res:///" + R.drawable.jian);
        AbstractDraweeController build2 = Fresco.newDraweeControllerBuilder()
                .setUri(uri2)
                .setTapToRetryEnabled(true)
                .build();
        holder.pius.setController(build2);

        Uri uri1 = Uri.parse("res:///" + R.drawable.jia);
        AbstractDraweeController build1 = Fresco.newDraweeControllerBuilder()
                .setUri(uri1)
                .setTapToRetryEnabled(false)
                .build();
        holder.pius.setController(build1);

        holder.pius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.pius.setVisibility(View.GONE);
                holder.jian.setVisibility(View.VISIBLE);
                holder.jubao.setVisibility(View.VISIBLE);
                holder.fuzhi.setVisibility(View.VISIBLE);
                holder.pingbi.setVisibility(View.VISIBLE);



               /* //      旋转
                PropertyValuesHolder propertyValuesHolder1 = PropertyValuesHolder.ofFloat("rotation", 0f, 360f);
                //      x轴方向平移
                PropertyValuesHolder propertyValuesHolder2 = PropertyValuesHolder.ofFloat("translationX", -200f);
                //      y轴方向平移
                PropertyValuesHolder propertyValuesHolder3 = PropertyValuesHolder.ofFloat("translationY", 0f, 0);
                ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(holder.jian, propertyValuesHolder1, propertyValuesHolder3);
                //      设置间隔时间
                objectAnimator.setDuration(1000);
                //      开始动画
                objectAnimator.start();*/




            }
        });



    }





    @Override
    public int getItemCount() {
        return list.size();

    }

    public class Ada extends RecyclerView.ViewHolder{

        private final SimpleDraweeView img;
        private final SimpleDraweeView pius,jian,fuzhi,pingbi,jubao;
        private final TextView name,time,cotent;
        private final JCVideoPlayerStandard jiecao;
        private final RecyclerView comment;

        public Ada(View itemView) {
            super(itemView);

            img = (SimpleDraweeView) itemView.findViewById(R.id.hot_img);
            pius = (SimpleDraweeView) itemView.findViewById(R.id.hot_pius);
            jian = (SimpleDraweeView) itemView.findViewById(R.id.jian);
            jubao = (SimpleDraweeView) itemView.findViewById(R.id.jubao);
            fuzhi = (SimpleDraweeView) itemView.findViewById(R.id.fuzhi);
            pingbi = (SimpleDraweeView) itemView.findViewById(R.id.pingbi);
            name = (TextView) itemView.findViewById(R.id.hou_name);
            time = (TextView) itemView.findViewById(R.id.hou_time);
            cotent = (TextView) itemView.findViewById(R.id.hou_cotent);
            jiecao = (JCVideoPlayerStandard) itemView.findViewById(R.id.jiecao_Player);
            comment = (RecyclerView) itemView.findViewById(R.id.comment_RLV);

        }
    }
}
