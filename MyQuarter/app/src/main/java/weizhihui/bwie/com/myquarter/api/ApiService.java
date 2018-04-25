package weizhihui.bwie.com.myquarter.api;


import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import weizhihui.bwie.com.myquarter.bean.Carousel_Bean;
import weizhihui.bwie.com.myquarter.bean.ShiPinBean;

/**
 * Created by asus on 2018/4/16.
 */

public interface ApiService {

    //https://www.zhaoapi.cn/quarter/getAd    首页轮播
    @GET("getAd")
    Observable<Carousel_Bean> getCarousel();
    //获取热门视频的url
    @GET("quarter/getHotVideos")
    Observable<ShiPinBean> getShiPin(@Query("page") String page,@Query("source") String android,@Query("appVersion") String appVersion,@Query("token") String type);

}
