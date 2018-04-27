package weizhihui.bwie.com.myquarter.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.swiperefreshlayoutlibrary.SwipyRefreshLayout;
import com.bawei.swiperefreshlayoutlibrary.SwipyRefreshLayoutDirection;

import java.util.List;

import weizhihui.bwie.com.myquarter.R;
import weizhihui.bwie.com.myquarter.adapter.ShiPinHotAdapter;
import weizhihui.bwie.com.myquarter.bean.ShiPinBean;
import weizhihui.bwie.com.myquarter.presenter.ShiPinPresenter;
import weizhihui.bwie.com.myquarter.view.ShIPinIview;

/**
 * Created by lenovo on 2018/4/25.
 */

public class Fragment03Hot extends Fragment04 {
    private RecyclerView hotrv;
      private ShiPinPresenter shiPinPresenter;
    private String page="1";
    private List<ShiPinBean.DataBean> data ;
    private ShiPinHotAdapter shiPinHotAdapter;
    private SwipyRefreshLayout hotsr01;
    private Handler handler=new Handler();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag03hot,null);
        hotrv= (RecyclerView) view.findViewById(R.id.hotrv);
        hotsr01= (SwipyRefreshLayout) view.findViewById(R.id.hotsr01);
        hotsr01.setColorSchemeResources(R.color.colorAccent,R.color.colorPrimaryDark,R.color.colorPrimary);
        hotsr01.setDirection(SwipyRefreshLayoutDirection.BOTH);
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        hotrv.setLayoutManager(staggeredGridLayoutManager);
       // hotrv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        shiPinPresenter=new ShiPinPresenter();
        shiPinPresenter.setShiPinDemo(page, "android", "1","1", new ShIPinIview() {
            @Override
            public void OnSuccess(ShiPinBean shiPinBean) {
               data = shiPinBean.getData();
                for (int i = 0; i <data.size() ; i++) {
                    int uid = data.get(i).getUid();
                }
                shiPinHotAdapter=new ShiPinHotAdapter(getActivity(), Fragment03Hot.this.data);
                hotrv.setAdapter(shiPinHotAdapter);
            }
        });

        //刷新和加载
       hotsr01.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
           @Override
           public void onRefresh(final int index) {
               handler.postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       Integer integer = Integer.valueOf(page);
                       integer=1;
                       shiPinPresenter=new ShiPinPresenter();
                       shiPinPresenter.setShiPinDemo(integer+"", "android", "1","1", new ShIPinIview() {
                           @Override
                           public void OnSuccess(ShiPinBean shiPinBean) {
                               data = shiPinBean.getData();
                               shiPinHotAdapter=new ShiPinHotAdapter(getActivity(),data);
                               hotrv.setAdapter(shiPinHotAdapter);
                               hotsr01.setRefreshing(false);
                           }
                       });
                   }
               },1000);
           }

           @Override
           public void onLoad(int index) {
          handler.postDelayed(new Runnable() {
              @Override
              public void run() {
                  Integer integer = Integer.valueOf(page);
                  integer++;
                  shiPinPresenter=new ShiPinPresenter();
                  shiPinPresenter.setShiPinDemo(integer+"", "android", "1","1", new ShIPinIview() {
                      @Override
                      public void OnSuccess(ShiPinBean shiPinBean) {
                          List<ShiPinBean.DataBean> data1 = shiPinBean.getData();
                          data.addAll(data1);
                          shiPinHotAdapter.notifyDataSetChanged();
                          hotsr01.setRefreshing(false);
                      }
                  });
              }
          },1000);
           }
       });
        //点击子条目跳转
        /*shiPinHotAdapter.setOnItimeClickListener(new ShiPinHotAdapter.OnItimeClickListener() {
            @Override
            public void OnItimeClick(int position) {
//                Intent intent=new Intent(getActivity(), ShipinContent.class);
//                startActivity(intent);
            }
        });*/
        return view;
    }

}
