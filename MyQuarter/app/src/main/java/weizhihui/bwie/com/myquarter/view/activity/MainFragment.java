package weizhihui.bwie.com.myquarter.view.activity;

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
import weizhihui.bwie.com.myquarter.adapter.AttentionAdapter;
import weizhihui.bwie.com.myquarter.bean.AttentionBean;
import weizhihui.bwie.com.myquarter.presenter.AttentionPresenter;
import weizhihui.bwie.com.myquarter.view.AttentionView;

public class MainFragment extends Fragment implements AttentionView {

    private View view;
    private RecyclerView mMfragrvid;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_fragment, container, false);
        initView(view);
        Bundle arguments = getArguments();

        AttentionPresenter attentionPresenter = new AttentionPresenter(this);
        attentionPresenter.getAttentionPresenter();
        //添加布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mMfragrvid.setLayoutManager(linearLayoutManager);

        return view;
    }

    private void initView(View view) {
        mMfragrvid = (RecyclerView) view.findViewById(R.id.mfragrvid);
    }

    @Override
    public void onSuccessAtt(AttentionBean attentionBean) {
        List<AttentionBean.DataBean> data = attentionBean.getData();
        //添加适配器
        AttentionAdapter attentionAdapter = new AttentionAdapter(getActivity(), data);
        mMfragrvid.setAdapter(attentionAdapter);
    }
}
