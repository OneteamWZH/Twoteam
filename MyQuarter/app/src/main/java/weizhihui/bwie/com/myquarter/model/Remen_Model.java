package weizhihui.bwie.com.myquarter.model;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import weizhihui.bwie.com.myquarter.api.Api;
import weizhihui.bwie.com.myquarter.api.ApiService;
import weizhihui.bwie.com.myquarter.bean.Remen_Bean;
import weizhihui.bwie.com.myquarter.utils.RetrofitUtils;

/**
 * Created by asus on 2018/4/26.
 */

public class Remen_Model {

    Remen_Listener remen_listener;
    public interface Remen_Listener{
        void setRemen_Listener(Remen_Bean remen_bean);
    }

    public void getRemen_Listener(Remen_Listener remen_listener) {
        this.remen_listener = remen_listener;
    }

    public void setRemen_Model(int uid,int type,int page,String source,int appVersion){

        ApiService apiService = RetrofitUtils.getInData().getRetrofit(Api.Remen_url, ApiService.class);
        Flowable<Remen_Bean> remen = apiService.getRemen(uid, type,page, source, appVersion);
        remen.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSubscriber<Remen_Bean>() {
                    @Override
                    public void onNext(Remen_Bean remen_bean) {
                        if(remen_listener!=null){
                            remen_listener.setRemen_Listener(remen_bean);
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
}
