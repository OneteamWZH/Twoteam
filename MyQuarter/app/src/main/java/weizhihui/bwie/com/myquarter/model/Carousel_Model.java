package weizhihui.bwie.com.myquarter.model;

import android.util.Log;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import weizhihui.bwie.com.myquarter.api.Api;
import weizhihui.bwie.com.myquarter.api.ApiService;
import weizhihui.bwie.com.myquarter.bean.Carousel_Bean;
import weizhihui.bwie.com.myquarter.utils.RetrofitUtils;

/**
 * Created by asus on 2018/4/16.
 */

public class Carousel_Model {

    Carousel_Listener carousel_listener;
    public interface Carousel_Listener{
        void setCarousel_Listener(Carousel_Bean carousel_bean);
    }

    public void getCarousel_Listener(Carousel_Listener carousel_listener) {
        this.carousel_listener = carousel_listener;
    }

    public void getCarousel_Model(){
        ApiService apiService = RetrofitUtils.getInData().getRetrofit(Api.Carousel_url, ApiService.class);
        Log.d("url",Api.Carousel_url);
        Flowable<Carousel_Bean> flowable = apiService.getCarousel();
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<Carousel_Bean>() {
                    @Override
                    public void onNext(Carousel_Bean carousel_bean) {
                        if (carousel_listener!=null){
                            carousel_listener.setCarousel_Listener(carousel_bean);
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
