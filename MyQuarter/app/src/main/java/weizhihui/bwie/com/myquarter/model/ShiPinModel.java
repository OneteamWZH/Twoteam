package weizhihui.bwie.com.myquarter.model;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import weizhihui.bwie.com.myquarter.api.Api;
import weizhihui.bwie.com.myquarter.api.ApiService;
import weizhihui.bwie.com.myquarter.bean.ShiPinBean;

/**
 * Created by lenovo on 2018/4/25.
 */

public class ShiPinModel {
    public void ShiPin(String page,String android,String appVersion,String type,final OnGetListener onGetListener){
    Retrofit retrofit=new Retrofit.Builder()
            .baseUrl(Api.Video_URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<ShiPinBean> shiPin = apiService.getShiPin(page, android, appVersion,type);
        shiPin.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShiPinBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ShiPinBean shiPinBean) {
                    if (onGetListener!=null){
                        onGetListener.OnGetSuccess(shiPinBean);
                    }
                    }
                });
    }
public interface OnGetListener{
    void OnGetSuccess(ShiPinBean shiPinBean);
}
}
