package weizhihui.bwie.com.myquarter.api;


import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import weizhihui.bwie.com.myquarter.bean.AttentionBean;
import weizhihui.bwie.com.myquarter.bean.Carousel_Bean;
import weizhihui.bwie.com.myquarter.bean.DuanBean;
import weizhihui.bwie.com.myquarter.bean.Remen_Bean;
import weizhihui.bwie.com.myquarter.bean.ShiPinBean;
import weizhihui.bwie.com.myquarter.bean.ShipinDuanBean;
import weizhihui.bwie.com.myquarter.bean.VersionBean;

/**
 * Created by asus on 2018/4/16.
 */

public interface ApiService {

    //https://www.zhaoapi.cn/quarter/getAd    首页轮播
    @GET("getAd")
    //获取热门视频的url
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
    @GET("getVersion")
    Flowable<VersionBean> getVersion();


 /**
     * Get基本请求,这里从Call改为Observable被观察者
     *
     * @param url
     * @return
     */
    @GET
    public Observable<String> get(@Url String url);

    /**
     * Get请求提交表单
     *
     * @param url
     * @param map
     * @return
     */
    @GET
    public Observable<String> get(@Url String url, @QueryMap Map<String, String> map);

    /**
     * Post请求提交表单
     *
     * @param url
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST
    public Observable<String> post(@Url String url, @FieldMap Map<String, String> map);

    /**
     * 上传视屏所需参数如下  这种方法适用于多文件上传
     *   uid  	    string	是	用户id       13563
     videoFile	File	是	视频文件
     coverFile	File	是	视频封面
     videoDesc	String	否	视频描述
     latitude	String	是	高德纬度坐标
     longitude	String	是	高德经度坐标
     token	    String	是	用户令牌      26BD55D2E872C840EA697151F31BE06C
     *
     *  写的是个demo所有我把所有值都写成死的了，除了经纬度
     *
     */

    /**
     *
     * @param url  请求路径
     * @param description1   为视屏文件的字段描述
     * @param file1  为视频文件的请求体
     * @param description2   为封面文件的字段描述
     * @param file2  为封面文件的请求体
     * @return
     */
    @Multipart
    @POST
    Observable<String> uploadFile(
            @Url String url,
            @Part("description") RequestBody description1,
            @Part MultipartBody.Part file1,
            @Part("description") RequestBody description2,
            @Part MultipartBody.Part file2);
}

