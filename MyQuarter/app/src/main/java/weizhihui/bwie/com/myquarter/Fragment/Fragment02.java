package weizhihui.bwie.com.myquarter.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import weizhihui.bwie.com.myquarter.R;
import weizhihui.bwie.com.myquarter.adapter.DuanAdapter;
import weizhihui.bwie.com.myquarter.bean.DuanBean;
import weizhihui.bwie.com.myquarter.presenter.DuanPresenter;
import weizhihui.bwie.com.myquarter.view.DuanIview;

/**
 * Created by asus on 2018/4/16.
 */

public class Fragment02 extends Fragment{
private RecyclerView duanrv;
    private DuanPresenter duanPresenter;
    private List<DuanBean.DataBean> data;
    private DuanAdapter duanAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.duanzi,container,false);
        duanrv= (RecyclerView) view.findViewById(R.id.duan_rv);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        duanrv.setLayoutManager(linearLayoutManager);
        duanPresenter=new DuanPresenter();
        duanPresenter.DuanDemo("1", "android", "101", new DuanIview() {
            @Override
            public void OnSuccess(DuanBean duanBean) {
               data = duanBean.getData();
               duanAdapter=new DuanAdapter(getActivity(),data);
                duanrv.setAdapter(duanAdapter);
            }
        });
        return view;
    }
}
