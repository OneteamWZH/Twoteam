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
    public void onBindViewHolder(Remen_Adapter.Ada holder, int position) {

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

        Uri uri = Uri.parse(icon);
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setTapToRetryEnabled(true)
                .build();
        holder.img.setController(build);

        holder.jiecao.setUp("http://gslb.miaopai.com/stream/ed5HCfnhovu3tyIQAiv60Q__.mp4",holder.jiecao.SCREEN_LAYOUT_NORMAL,"");


    }







    @Override
    public int getItemCount() {
        return list.size();

    }

    public class Ada extends RecyclerView.ViewHolder{

        private final SimpleDraweeView img;
        private final SimpleDraweeView pius;
        private final TextView name,time,cotent;
        private final JCVideoPlayerStandard jiecao;
        private final RecyclerView comment;

        public Ada(View itemView) {
            super(itemView);

            img = (SimpleDraweeView) itemView.findViewById(R.id.hot_img);
            pius = (SimpleDraweeView) itemView.findViewById(R.id.hot_pius);
            name = (TextView) itemView.findViewById(R.id.hou_name);
            time = (TextView) itemView.findViewById(R.id.hou_time);
            cotent = (TextView) itemView.findViewById(R.id.hou_cotent);
            jiecao = (JCVideoPlayerStandard) itemView.findViewById(R.id.jiecao_Player);
            comment = (RecyclerView) itemView.findViewById(R.id.comment_RLV);

        }
    }
}
