package weizhihui.bwie.com.myquarter.model;

import android.system.StructUtsname;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;
import retrofit2.Retrofit;
import weizhihui.bwie.com.myquarter.api.Api;
import weizhihui.bwie.com.myquarter.api.ApiService;
import weizhihui.bwie.com.myquarter.app.MyApp;
import weizhihui.bwie.com.myquarter.bean.ShipinDuanBean;
import weizhihui.bwie.com.myquarter.utils.RetrofitUtils;

/**
 * Created by lenovo on 2018/4/26.
 */

public class ShiPinDuanModel {
    public void ShiDuanDemo(String page,String android,String appVersion,final OnGetListener onGetListener){
        ApiService retrofit = RetrofitUtils.getInData().getRetrofit(Api.ShiPinDuan_URL, ApiService.class);
        Flowable<ShipinDuanBean> flowable = retrofit.getParmer03(page, android, appVersion);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<ShipinDuanBean>() {
                    @Override
                    public void onNext(ShipinDuanBean shipinDuanBean) {
                        if (onGetListener!=null){
                            onGetListener.OnGetListener(shipinDuanBean);
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
    public interface OnGetListener{
        void OnGetListener(ShipinDuanBean shipinDuanBean);
    }
}
