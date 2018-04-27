package weizhihui.bwie.com.myquarter.api;


import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import weizhihui.bwie.com.myquarter.bean.AttentionBean;
import weizhihui.bwie.com.myquarter.bean.Carousel_Bean;
import weizhihui.bwie.com.myquarter.bean.DuanBean;
import weizhihui.bwie.com.myquarter.bean.Remen_Bean;
import weizhihui.bwie.com.myquarter.bean.ShiPinBean;
import weizhihui.bwie.com.myquarter.bean.ShipinDuanBean;

/**
 * Created by asus on 2018/4/16.
 */

public interface ApiService {

    //https://www.zhaoapi.cn/quarter/getAd    首页轮播
    @GET("getAd")
    Flowable<Carousel_Bean> getCarousel();
    //获取热门视频的url
    // 我的关注 https://www.zhaoapi.cn/ad/getAd
  @GET("getAd")
   Flowable<AttentionBean> getAtention();
    //获取视频的url
    //https://www.zhaoapi.cn/quarter/getJokes ?page=1&source=android&appVersion=0
    @GET("quarter/getVideos")
    Flowable<ShiPinBean> getShiPin(@Query("page") String page,@Query("source") String android,@Query("appVersion") String appVersion,@Query("type") String type);


    //https://www.zhaoapi.cn/quarter/getVideos?uid=1&type=1&page=1&source=android&appVersion=101
    @GET("getVideos")
    Flowable<Remen_Bean> getRemen(@Query("uid") int uid, @Query("type") int type, @Query("page") int page, @Query("source") String source, @Query("appVersion") int appVersion);
     //视频里的段子列表
    //https://www.zhaoapi.cn/quarter/getJokes?page=1&source=android&appVersion=1
    @GET("quarter/getJokes")
    Flowable<ShipinDuanBean> getParmer03(@Query("page") String page,@Query("source") String android,@Query("appVersion") String appVersion);
    //段子  https://www.zhaoapi.cn/quarter/getJokes?page=1&source=android&appVersion=101
    @GET("quarter/getJokes")
    Flowable<DuanBean> getParmer06(@Query("page") String page,@Query("source") String android,@Query("appVersion") String appVersion);

}
