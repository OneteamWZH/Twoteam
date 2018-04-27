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

import weizhihui.bwie.com.myquarter.R;
import weizhihui.bwie.com.myquarter.bean.AttentionBean;

/**
 * Created by asus on 2018/4/27.
 */

public class AttentionAdapter extends RecyclerView.Adapter<AttentionAdapter.MyViewHolder>{

    private Context context;
    private List<AttentionBean.DataBean> data;

    public AttentionAdapter(Context context, List<AttentionBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_rv_att_layout, parent, false);
        final MyViewHolder holder=new MyViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getLayoutPosition();
                if (listener!=null){
                    listener.onSuccess(position);
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        AttentionBean.DataBean dataBean = data.get(position);
        String createtime = dataBean.getCreatetime();
        String title = dataBean.getTitle();
        String icon = dataBean.getIcon();
        holder.tv1.setText(title);
        holder.tv2.setText(createtime);
        Uri parse = Uri.parse(icon);
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder()
                .setUri(parse)
                .setTapToRetryEnabled(true)
                .build();
        holder.sim.setController(build);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    //自定义ViewHolder
    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView tv1;
        private final TextView tv2;
        private final SimpleDraweeView sim;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.Atv1id);
            tv2 =  (TextView) itemView.findViewById(R.id.Atv1id);
            sim = (SimpleDraweeView) itemView.findViewById(R.id.Asimid);
        }

    }
    //自定义接口
    //自定义接口
    public interface onAttentionListenerAdapter{
        void onSuccess(int  position);
    }
    //声明接口
   onAttentionListenerAdapter listener;
    public void setonAttentionListenerAdapter(onAttentionListenerAdapter listener){
        this.listener=listener;
    }

}
