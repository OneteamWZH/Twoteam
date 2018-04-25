package weizhihui.bwie.com.myquarter.api;


import io.reactivex.Flowable;
import retrofit2.http.GET;
import rx.Observable;
import weizhihui.bwie.com.myquarter.bean.Carousel_Bean;

/**
 * Created by asus on 2018/4/16.
 */

public interface ApiService {

    //https://www.zhaoapi.cn/quarter/getAd    首页轮播
    @GET("getAd")
    Observable<Carousel_Bean> getCarousel();

}
