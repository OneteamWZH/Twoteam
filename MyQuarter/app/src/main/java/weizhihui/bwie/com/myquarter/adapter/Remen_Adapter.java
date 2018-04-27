package weizhihui.bwie.com.myquarter.adapter;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
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

//        holder.time.setText(createTime);
//        holder.cotent.setText("天气美美的，适合郊游");

        if(nickname!=null){
            holder.name.setText(nickname);
        }else{
            holder.name.setText("天王盖地虎");
        }



        holder.time.setText(createTime);
        holder.cotent.setText("天气美美的，适合郊游");
        holder.jiecao.setUp("http://gslb.miaopai.com/stream/ed5HCfnhovu3tyIQAiv60Q__.mp4",holder.jiecao.SCREEN_LAYOUT_NORMAL,"");


        Uri uri = Uri.parse(icon);
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setTapToRetryEnabled(true)
                .build();
        holder.img.setController(build);


//        holder.jiecao.setUp("http://gslb.miaopai.com/stream/ed5HCfnhovu3tyIQAiv60Q__.mp4",holder.jiecao.SCREEN_LAYOUT_NORMAL,"");

        Uri uri5 = Uri.parse("res:///" + R.drawable.pingbi);
        AbstractDraweeController build5 = Fresco.newDraweeControllerBuilder()
                .setUri(uri5)
                .setTapToRetryEnabled(true)
                .build();
        holder.pingbi.setController(build5);

        Uri uri4 = Uri.parse("res:///" + R.drawable.fuzhi);
        AbstractDraweeController build4 = Fresco.newDraweeControllerBuilder()
                .setUri(uri4)
                .setTapToRetryEnabled(true)
                .build();
        holder.fuzhi.setController(build4);


        Uri uri3 = Uri.parse("res:///" + R.drawable.jubao);
        AbstractDraweeController build3 = Fresco.newDraweeControllerBuilder()
                .setUri(uri3)
                .setTapToRetryEnabled(true)
                .build();
        holder.jubao.setController(build3);

        Uri uri2 = Uri.parse("res:///" + R.drawable.jian);
        AbstractDraweeController build2 = Fresco.newDraweeControllerBuilder()
                .setUri(uri2)
                .setTapToRetryEnabled(true)
                .build();
        holder.jian.setController(build2);

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


                //加号
                ObjectAnimator ra = ObjectAnimator.ofFloat(holder.pius,"rotation", 0f, 360f);
                ra.setDuration(1000);
                ra.start();

                //举报
                ObjectAnimator translationX = new ObjectAnimator().ofFloat(holder.jubao,"translationX",0,-70f);
                ObjectAnimator translationY = new ObjectAnimator().ofFloat(holder.jubao,"translationY",0,0);
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(holder.jubao, "alpha", 1f, 0f, 1f);
                animator1.setDuration(1000);//时间1s
                animator1.start();
                AnimatorSet animatorSet = new AnimatorSet();  //组合动画
                animatorSet.playTogether(translationX,translationY); //设置动画
                animatorSet.setDuration(1000);  //设置动画时间
                animatorSet.start(); //启动

                ObjectAnimator ra_jubao = ObjectAnimator.ofFloat(holder.jubao,"rotation", 0f, 360f);
                ra_jubao.setDuration(1000);
                ra_jubao.start();

                //复制链接
                ObjectAnimator translationX2 = new ObjectAnimator().ofFloat(holder.fuzhi,"translationX",0,-140f);
                ObjectAnimator translationY2 = new ObjectAnimator().ofFloat(holder.fuzhi,"translationY",0,0);
                ObjectAnimator animator = ObjectAnimator.ofFloat(holder.fuzhi, "alpha", 1f, 0f, 1f);
                animator.setDuration(1000);//时间1s
                animator.start();
                AnimatorSet animatorSet2 = new AnimatorSet();  //组合动画
                animatorSet2.playTogether(translationX2,translationY2); //设置动画
                animatorSet2.setDuration(1000);  //设置动画时间
                animatorSet2.start(); //启动

                ObjectAnimator ra_fuzhi = ObjectAnimator.ofFloat(holder.fuzhi,"rotation", 0f, 360f);
                ra_fuzhi.setDuration(1000);
                ra_fuzhi.start();

                //屏蔽
                ObjectAnimator translationX3 = new ObjectAnimator().ofFloat(holder.pingbi,"translationX",0,-210f);
                ObjectAnimator translationY3 = new ObjectAnimator().ofFloat(holder.pingbi,"translationY",0,0);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(holder.pingbi, "alpha", 1f, 0f, 1f);
                animator2.setDuration(1000);//时间1s
                animator2.start();
                AnimatorSet animatorSet3 = new AnimatorSet();  //组合动画
                animatorSet3.playTogether(translationX3,translationY3); //设置动画
                animatorSet3.setDuration(1000);  //设置动画时间
                animatorSet3.start(); //启动

                ObjectAnimator ra_ping = ObjectAnimator.ofFloat(holder.pingbi,"rotation", 0f, 360f);
                ra_ping.setDuration(1000);
                ra_ping.start();
            }
        });


        holder.jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.pius.setVisibility(View.VISIBLE);
                holder.jian.setVisibility(View.GONE);

                //屏蔽
                ObjectAnimator translationX3 = new ObjectAnimator().ofFloat(holder.pingbi,"translationX",-70f,0f);
                ObjectAnimator translationY3 = new ObjectAnimator().ofFloat(holder.pingbi,"translationY",0,0);
                ObjectAnimator animator = ObjectAnimator.ofFloat(holder.pingbi, "alpha", 1f, 0f);
                animator.setDuration(1000);//时间1s
                animator.start();
                AnimatorSet animatorSet3 = new AnimatorSet();  //组合动画
                animatorSet3.playTogether(translationX3,translationY3); //设置动画
                animatorSet3.setDuration(1000);  //设置动画时间
                animatorSet3.start(); //启动

                ObjectAnimator ra_ping = ObjectAnimator.ofFloat(holder.pingbi,"rotation", 0f, 360f);
                ra_ping.setDuration(1000);
                ra_ping.start();


                //复制链接
                ObjectAnimator translationX2 = new ObjectAnimator().ofFloat(holder.fuzhi,"translationX",-140,0f);
                ObjectAnimator translationY2 = new ObjectAnimator().ofFloat(holder.fuzhi,"translationY",0,0);
                ObjectAnimator animator3 = ObjectAnimator.ofFloat(holder.fuzhi, "alpha", 1f, 0f);
                animator3.setDuration(1000);//时间1s
                animator3.start();
                AnimatorSet animatorSet2 = new AnimatorSet();  //组合动画
                animatorSet2.playTogether(translationX2,translationY2); //设置动画
                animatorSet2.setDuration(1000);  //设置动画时间
                animatorSet2.start(); //启动

                ObjectAnimator ra_fuzhi = ObjectAnimator.ofFloat(holder.fuzhi,"rotation", 0f, 360f);
                ra_fuzhi.setDuration(1000);
                ra_fuzhi.start();

                //举报
                ObjectAnimator translationX = new ObjectAnimator().ofFloat(holder.jubao,"translationX",-210,0f);
                ObjectAnimator translationY = new ObjectAnimator().ofFloat(holder.jubao,"translationY",0,0);
                ObjectAnimator animator4 = ObjectAnimator.ofFloat(holder.jubao, "alpha", 1f, 0f);
                animator4.setDuration(1000);//时间1s
                animator4.start();
                AnimatorSet animatorSet = new AnimatorSet();  //组合动画
                animatorSet.playTogether(translationX,translationY); //设置动画
                animatorSet.setDuration(1000);  //设置动画时间
                animatorSet.start(); //启动

                ObjectAnimator ra_jubao = ObjectAnimator.ofFloat(holder.jubao,"rotation", 0f, 360f);
                ra_jubao.setDuration(1000);
                ra_jubao.start();


            }
        });

        holder.comment.setLayoutManager(new LinearLayoutManager(context));
        Comment_Adapter comment_adapter = new Comment_Adapter(context,list);
        holder.comment.setAdapter(comment_adapter);

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

          /*  pius = (SimpleDraweeView) itemView.findViewById(R.id.hot_pius);*/

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
