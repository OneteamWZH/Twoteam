package weizhihui.bwie.com.myquarter.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import weizhihui.bwie.com.myquarter.R;
import weizhihui.bwie.com.myquarter.adapter.ShiPinHotAdapter;
import weizhihui.bwie.com.myquarter.bean.ShiPinBean;
import weizhihui.bwie.com.myquarter.presenter.ShiPinPresenter;
import weizhihui.bwie.com.myquarter.view.ShIPinIview;

/**
 * Created by lenovo on 2018/4/25.
 */

public class Fragment03Near extends Fragment{
    private RecyclerView nearrv;
    private ShiPinPresenter shiPinPresenter;
    private  List<ShiPinBean.DataBean> data;
    private ShiPinHotAdapter shiPinHotAdapter;
    private String page="5";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag03near,null);
        nearrv= (RecyclerView) view.findViewById(R.id.nearrv);
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        nearrv.setLayoutManager(staggeredGridLayoutManager);
        shiPinPresenter=new ShiPinPresenter();
        shiPinPresenter.setShiPinDemo(page, "android", "1", "1", new ShIPinIview() {
            @Override
            public void OnSuccess(ShiPinBean shiPinBean) {
              data = shiPinBean.getData();
                shiPinHotAdapter=new ShiPinHotAdapter(getActivity(),data);
                nearrv.setAdapter(shiPinHotAdapter);
            }
        });
        return view;
    }
}
