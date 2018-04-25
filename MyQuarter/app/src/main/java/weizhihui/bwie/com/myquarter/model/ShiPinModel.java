package weizhihui.bwie.com.myquarter.model;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import weizhihui.bwie.com.myquarter.api.Api;
import weizhihui.bwie.com.myquarter.api.ApiService;
import weizhihui.bwie.com.myquarter.bean.ShiPinBean;
import weizhihui.bwie.com.myquarter.utils.RetrofitUtils;

/**
 * Created by lenovo on 2018/4/25.
 */

public class ShiPinModel {

    public void ShiPin(String page,String android,String appVersion,String type,final OnGetListener onGetListener){
        ApiService apiService = RetrofitUtils.getInData().getRetrofit(Api.Video_URL, ApiService.class);
        Flowable<ShiPinBean> flowable = apiService.getShiPin(page, android, appVersion,type);
            flowable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableSubscriber<ShiPinBean>() {
                        @Override
                        public void onNext(ShiPinBean shiPinBean) {
                            if (onGetListener!=null){
                                onGetListener.OnGetSuccess(shiPinBean);
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
    void OnGetSuccess(ShiPinBean shiPinBean);
}
}
