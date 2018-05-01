package weizhihui.bwie.com.myquarter.retrofit;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import weizhihui.bwie.com.myquarter.interceptor.InterceptorPost;

public class RetrofitManager {

    public static OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(new InterceptorPost())
           // .addInterceptor(new InterceptorGet())
            .build();


    public static  ApiService  apiService = new Retrofit.Builder()
            .baseUrl("https://www.zhaoapi.cn/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ApiService.class);


    public static void get(String url, Map<String,String> map, Observer observer){

        apiService.get(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }


    public static void post(String url, Map<String,String> map, Observer observer){
        apiService.post(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


}