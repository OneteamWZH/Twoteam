package weizhihui.bwie.com.myquarter.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import weizhihui.bwie.com.myquarter.R;
import weizhihui.bwie.com.myquarter.bean.DuanBean;

/**
 * Created by lenovo on 2018/4/27.
 */

public class DuanAdapter extends RecyclerView.Adapter<DuanAdapter.MyViewHolder> {
    private Context context;
    private List<DuanBean.DataBean> data;

    public DuanAdapter(Context context, List<DuanBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  view= LayoutInflater.from(context).inflate(R.layout.duan_rvli,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
    holder.duanname.setText(data.get(position).getUser().getNickname());
        holder.duantime.setText(data.get(position).getCreateTime());
        holder.duancontent.setText(data.get(position).getContent());
//        Uri uri = Uri.parse(data.get(position).getUser().getIcon());
//        AbstractDraweeController build = Fresco.newDraweeControllerBuilder()
//                .setUri(uri)
//                .setTapToRetryEnabled(true)
//                .build();
//        holder.duanimg.setController(build);
        ImageLoader.getInstance().displayImage(data.get(position).getUser().getIcon(),holder.duanimg);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
     private ImageView duanimg;
        private TextView duanname,duantime,duancontent;
        public MyViewHolder(View itemView) {
            super(itemView);
            duanimg= (ImageView) itemView.findViewById(R.id.duan_img);
            duanname= (TextView) itemView.findViewById(R.id.duann_name);
            duantime= (TextView) itemView.findViewById(R.id.duan_time);
            duancontent= (TextView) itemView.findViewById(R.id.duan_cotent);
        }
    }
}
