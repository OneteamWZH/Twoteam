package weizhihui.bwie.com.myquarter.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import weizhihui.bwie.com.myquarter.R;
import weizhihui.bwie.com.myquarter.app.Img_Banner;
import weizhihui.bwie.com.myquarter.bean.Carousel_Bean;
import weizhihui.bwie.com.myquarter.presenter.Carousel_Presenter;
import weizhihui.bwie.com.myquarter.view.Carousel_View;

/**
 * Created by asus on 2018/4/16.
 */

public class MainFragment extends Fragment implements Carousel_View{
    private View view;
    private Banner mBannerid;
    private RecyclerView mRvframid;
    private List<String> listimg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.show1_mainfragment_layout, container, false);
        initView(view);

        Bundle arguments = getArguments();
        String tab = arguments.getString("tab");
        Log.d("tab",tab);
        Carousel_Presenter presenter=new Carousel_Presenter(this);
        presenter.getCarousel_Presenter();



        return view;
    }

    private void initView(View view) {
        mBannerid = (Banner) view.findViewById(R.id.bannerid);
        mRvframid = (RecyclerView) view.findViewById(R.id.rvframid);
    }

    @Override
    public void setCarousel_View(Carousel_Bean carousel_bean) {
        List<Carousel_Bean.DataEntity> data = carousel_bean.getData();
        Log.d("ccccdata", data.size()+"");

        listimg = new ArrayList<>();
        for (int i = 0; i< data.size(); i++){
            String icon = data.get(i).getIcon();
            listimg.add(icon);
        }
        mBannerid.setImageLoader(new Img_Banner());
        mBannerid.setImages(listimg);
        Log.d("cccc",listimg.size()+"");
        mBannerid.setDelayTime(1000);
        mBannerid.start();

    }
    //数据响应成功的方法

}
