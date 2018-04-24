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

public class Frag_pager01 extends Fragment implements Carousel_View{

    private View view;
    private Banner mBan;
    private RecyclerView mRLV;
    private String icon;
    private List<String> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_pager01, container, false);
        initView(view);
        list = new ArrayList<>();

        Carousel_Presenter carousel_presenter = new Carousel_Presenter(this);
        carousel_presenter.getCarousel_Presenter();

        return view;
    }

    private void initView(View view) {
        mBan = (Banner) view.findViewById(R.id.Ban);
        mRLV = (RecyclerView) view.findViewById(R.id.RLV);
    }

    @Override
    public void setCarousel_View(Carousel_Bean carousel_bean) {
        List<Carousel_Bean.DataEntity> data = carousel_bean.getData();
        for(int i=0;i<data.size();i++){
            icon = data.get(i).getIcon();
            list.add(icon);
        }
        Log.i("哈哈",list.size()+"");
        mBan.setImages(list);
        mBan.setImageLoader(new Img_Banner());
        mBan.setDelayTime(2000);
        mBan.start();

    }
}
