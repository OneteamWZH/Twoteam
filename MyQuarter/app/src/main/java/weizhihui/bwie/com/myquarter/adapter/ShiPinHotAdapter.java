package weizhihui.bwie.com.myquarter.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import weizhihui.bwie.com.myquarter.R;
import weizhihui.bwie.com.myquarter.view.activity.ShipinContent;
import weizhihui.bwie.com.myquarter.bean.ShiPinBean;

/**
 * Created by lenovo on 2018/4/25.
 */

public class ShiPinHotAdapter extends RecyclerView.Adapter<ShiPinHotAdapter.MyViewHolder> {
    private Context context;
    private List<ShiPinBean.DataBean> data ;
    /*private OnItimeClickListener mlistener;
    public void setOnItimeClickListener(OnItimeClickListener onItimeClickListener){
        mlistener=onItimeClickListener;
    }*/

    public ShiPinHotAdapter(Context context, List<ShiPinBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.frag03rvchil01,parent,false);
        final MyViewHolder holder=new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getLayoutPosition();
                Intent intent=new Intent(context, ShipinContent.class);
                intent.putExtra("video_url",data.get(position).getVideoUrl());
                context.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
      Glide.with(context).load(data.get(position).getCover()).into(holder.rv01img);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
     private ImageView rv01img;
        public MyViewHolder(View itemView) {
            super(itemView);
            rv01img= (ImageView) itemView.findViewById(R.id.rv01img);
        }
    }
    /*//点击事件
    public interface OnItimeClickListener{
        void OnItimeClick(int position);
    }*/

}
