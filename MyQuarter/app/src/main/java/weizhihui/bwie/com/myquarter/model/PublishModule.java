package weizhihui.bwie.com.myquarter.model;

import java.util.Map;

import weizhihui.bwie.com.myquarter.bean.PublishBean;
import weizhihui.bwie.com.myquarter.retrofit.APIS;
import weizhihui.bwie.com.myquarter.retrofit.BaseObserver;
import weizhihui.bwie.com.myquarter.retrofit.RetrofitManager;


/**
 * Created by QinQinBaoBei on 2018/1/25.
 */

public class PublishModule {
    //https://www.zhaoapi.cn/quarter/publishJoke?uid=1701&content=%E4%BD%A0%E5%A5%BD%E4%B8%96%E7%95%8C%E4%BD%A0%E5%A5%BD%E4%B8%96%E7%95%8C&token=E6C4C1B581A506F2F4D6748B3649AD3C
     public void getData(Map<String,String> map, final PulishModuleListener pulishModuleListener){
         RetrofitManager.post(APIS.pulish, map, new BaseObserver<PublishBean>() {
             @Override
             public void success(PublishBean publishBean) {
                if(pulishModuleListener!=null){
                    pulishModuleListener.success(publishBean);
                }
             }

             @Override
             public void failure(int code) {

             }

         });
     }
   public interface PulishModuleListener{
         void success(PublishBean publishBean);
   }
}
