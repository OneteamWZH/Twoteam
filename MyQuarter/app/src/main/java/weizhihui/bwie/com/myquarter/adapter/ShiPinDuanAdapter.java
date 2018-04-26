package weizhihui.bwie.com.myquarter.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import weizhihui.bwie.com.myquarter.R;
import weizhihui.bwie.com.myquarter.bean.ShipinDuanBean;

/**
 * Created by lenovo on 2018/4/26.
 */

public class ShiPinDuanAdapter extends RecyclerView.Adapter<ShiPinDuanAdapter.MyViewHolder> {
    private Context context;
    private List<ShipinDuanBean.DataBean> data;

    public ShiPinDuanAdapter(Context context, List<ShipinDuanBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.shiduanchil,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
   holder.duanname.setText(data.get(position).getContent());
        holder.duanname1.setText(data.get(position).getCreateTime());
        //Glide.with(context).load(data.get(position).getUser().getIcon()).into(holder.duantu);
        Uri uri = Uri.parse(data.get(position).getUser().getIcon());
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setTapToRetryEnabled(true)
                .build();
        holder.duantu.setController(build);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
    private SimpleDraweeView duantu;
        private TextView duanname,duanname1;
        public MyViewHolder(View itemView) {
            super(itemView);
          duantu= (SimpleDraweeView) itemView.findViewById(R.id.duantu);
            duanname= (TextView) itemView.findViewById(R.id.duanname);
            duanname1= (TextView) itemView.findViewById(R.id.duanname1);
        }
    }


}
