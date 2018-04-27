package weizhihui.bwie.com.myquarter.model;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;
import weizhihui.bwie.com.myquarter.api.Api;
import weizhihui.bwie.com.myquarter.api.ApiService;
import weizhihui.bwie.com.myquarter.bean.DuanBean;
import weizhihui.bwie.com.myquarter.utils.RetrofitUtils;

/**
 * Created by lenovo on 2018/4/27.
 */

public class DuanModel {
    public void DuanDemo(String page,String android,String appVersion,final OnGetListner onGetListner){
        RetrofitUtils inData = RetrofitUtils.getInData();
        ApiService retrofit = inData.getRetrofit(Api.duan_URL, ApiService.class);
        Flowable<DuanBean> flowable = retrofit.getParmer06(page, android, appVersion);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<DuanBean>() {
                    @Override
                    public void onNext(DuanBean duanBean) {
                        if (onGetListner!=null){
                            onGetListner.OnGetSuccess(duanBean);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    public interface OnGetListner{
        void OnGetSuccess(DuanBean duanBean);
    }
}
