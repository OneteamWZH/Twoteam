package weizhihui.bwie.com.myquarter.model;

import java.util.Map;

import weizhihui.bwie.com.myquarter.bean.RegisterBean;
import weizhihui.bwie.com.myquarter.retrofit.APIS;
import weizhihui.bwie.com.myquarter.retrofit.BaseObserver;
import weizhihui.bwie.com.myquarter.retrofit.RetrofitManager;

/**
 * author:Created by WangZhiQiang on 2018/4/27.
 */

public class RegistModel {

    public void getData(Map<String,String> map, final RegisterModuleListener registerModuleListener){
        RetrofitManager.post(APIS.register, map, new BaseObserver<RegisterBean>() {
            @Override
            public void success(RegisterBean registerBean) {
                if(registerModuleListener != null){
                    registerModuleListener.success(registerBean);
                }
            }

            @Override
            public void failure(int code) {

            }

        });
    }

    public interface RegisterModuleListener{
        void success(RegisterBean registerBean);
    }
}
