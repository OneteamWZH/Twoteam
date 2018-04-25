package weizhihui.bwie.com.myquarter.api;


import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import weizhihui.bwie.com.myquarter.bean.Carousel_Bean;
import weizhihui.bwie.com.myquarter.bean.ShiPinBean;

/**
 * Created by asus on 2018/4/16.
 */

public interface ApiService {

    //https://www.zhaoapi.cn/quarter/getAd    首页轮播
    @GET("getAd")
<<<<<<< HEAD
    Observable<Carousel_Bean> getCarousel();
    //获取热门视频的url
    @GET("quarter/getHotVideos")
    Observable<ShiPinBean> getShiPin(@Query("page") String page,@Query("source") String android,@Query("appVersion") String appVersion,@Query("token") String type);
=======
    Flowable<Carousel_Bean> getCarousel();


    //获取视频的url
    //https://www.zhaoapi.cn/quarter/getJokes ?page=1&source=android&appVersion=0
    @GET("quarter/getVideos")
    Flowable<ShiPinBean> getShiPin(@Query("page") String page,@Query("source") String android,@Query("appVersion") String appVersion,@Query("type") String type);

>>>>>>> 8d511d771c83eb0c75fcc479dea7a9445f6e24a9

}
