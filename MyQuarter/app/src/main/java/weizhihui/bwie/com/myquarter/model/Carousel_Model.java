package weizhihui.bwie.com.myquarter.model;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import weizhihui.bwie.com.myquarter.api.Api;
import weizhihui.bwie.com.myquarter.api.ApiService;
import weizhihui.bwie.com.myquarter.bean.Carousel_Bean;

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
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.Carousel_url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        final Observable<Carousel_Bean> carousel = apiService.getCarousel();
        carousel.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Carousel_Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("model数据",e.getMessage());
                    }

                    @Override
                    public void onNext(Carousel_Bean carousel_bean) {
                        if(carousel_listener!=null){

                            carousel_listener.setCarousel_Listener(carousel_bean);
                        }
                    }
                });

    }

}
