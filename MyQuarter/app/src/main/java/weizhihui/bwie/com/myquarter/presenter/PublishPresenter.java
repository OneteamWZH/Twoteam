package weizhihui.bwie.com.myquarter.presenter;

import java.util.Map;

import weizhihui.bwie.com.myquarter.bean.PublishBean;
import weizhihui.bwie.com.myquarter.model.PublishModule;


/**
 * Created by QinQinBaoBei on 2018/1/25.
 */

public class PublishPresenter {
    PublishPresenterListener publishPresenterListener;
    private final PublishModule publishModule;

    public PublishPresenter(PublishPresenterListener publishPresenterListener) {
        this.publishPresenterListener = publishPresenterListener;
        publishModule = new PublishModule();
    }

    public void getData(Map<String,String> map){
         publishModule.getData(map, new PublishModule.PulishModuleListener() {
             @Override
             public void success(PublishBean publishBean) {
                 if(publishPresenterListener!=null){
                     publishPresenterListener.success(publishBean.getMsg());
                 }
             }
         });
    }
     public void detach(){
        publishPresenterListener=null;
     }
    public interface PublishPresenterListener{
        void success(String s);
    }
}
