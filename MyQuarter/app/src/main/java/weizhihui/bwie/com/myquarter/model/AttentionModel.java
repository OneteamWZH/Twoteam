package weizhihui.bwie.com.myquarter.model;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import weizhihui.bwie.com.myquarter.api.Api;
import weizhihui.bwie.com.myquarter.api.ApiService;
import weizhihui.bwie.com.myquarter.bean.AttentionBean;
import weizhihui.bwie.com.myquarter.utils.RetrofitUtils;

/**
 * Created by asus on 2018/4/27.
 */

public class AttentionModel {

    //自定义接口
    public interface onAttentionListener{
        void onSuccess(AttentionBean attentionBean);
    }
    //声明接口
    onAttentionListener listener;
    public void setonAttentionListener(onAttentionListener listener){
        this.listener=listener;
    }

     public void getAttentionModel(){
         ApiService apiService = RetrofitUtils.getInData().getRetrofit(Api.Attention_Url, ApiService.class);
         Flowable<AttentionBean> flowable = apiService.getAtention();
         flowable.subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribeWith(new DisposableSubscriber<AttentionBean>() {
                     @Override
                     public void onNext(AttentionBean attentionBean) {
                         if (listener!=null){
                             listener.onSuccess(attentionBean);
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
