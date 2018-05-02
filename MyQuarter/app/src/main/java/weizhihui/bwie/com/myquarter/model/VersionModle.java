package weizhihui.bwie.com.myquarter.model;


import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import weizhihui.bwie.com.myquarter.api.Api;
import weizhihui.bwie.com.myquarter.api.ApiService;
import weizhihui.bwie.com.myquarter.bean.VersionBean;
import weizhihui.bwie.com.myquarter.utils.RetrofitUtils;

/**
 * Created by asus on 2018/4/20.
 * 获取版本信息
 */

public class VersionModle {

    //自定义接口
    public interface setOnVersionListener{
        void onSuccess(VersionBean versionBean);
    }
    //声明接口
    setOnVersionListener listener;
    //提供一个对外的接口监听方法
    public void onVersionListener( setOnVersionListener listener){
        this.listener=listener;
    }



    //定义版本更新的方法
    public void getVersion(int type){
        ApiService apiService = RetrofitUtils.getInData().getRetrofit(Api.Version_Url, ApiService.class);
        Flowable<VersionBean> flowable = apiService.getVersion();
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new DisposableSubscriber<VersionBean>() {
                     @Override
                     public void onNext(VersionBean versionBean) {
                         if (listener!=null){
                             listener.onSuccess(versionBean);
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
