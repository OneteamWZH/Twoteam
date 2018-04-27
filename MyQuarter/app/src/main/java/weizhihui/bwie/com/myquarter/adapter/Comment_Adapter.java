package weizhihui.bwie.com.myquarter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import weizhihui.bwie.com.myquarter.R;
import weizhihui.bwie.com.myquarter.bean.Remen_Bean;

/**
 * Created by asus on 2018/4/27.
 */

public class Comment_Adapter extends RecyclerView.Adapter<Comment_Adapter.Ada>{

    private List<Remen_Bean.DataEntity> list;
    private Context context;

    public Comment_Adapter(Context context, List<Remen_Bean.DataEntity> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Comment_Adapter.Ada onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(context).inflate(R.layout.comment, parent, false);
        Ada a = new Ada(inflate);

        return a;
    }

    @Override
    public void onBindViewHolder(Comment_Adapter.Ada holder, int position) {
        String workDesc = list.get(position).getWorkDesc();
        Remen_Bean.DataEntity.UserEntity user = list.get(position).getUser();
        String nickname = (String) user.getNickname();

        if(nickname!=null&&workDesc!=null){
            holder.name.setText(nickname+"：");
            holder.work.setText(workDesc);
        }else{
            holder.work.setVisibility(View.GONE);
            holder.name.setVisibility(View.GONE);

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Ada extends RecyclerView.ViewHolder{

        private final TextView name,work;

        public Ada(View itemView) {
            super(itemView);

            name =  (TextView) itemView.findViewById(R.id.nickname);
            work =  (TextView) itemView.findViewById(R.id.work);

        }
    }

}
