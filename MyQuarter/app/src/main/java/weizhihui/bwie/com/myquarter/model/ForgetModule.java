package weizhihui.bwie.com.myquarter.model;

import java.util.Map;

import weizhihui.bwie.com.myquarter.bean.ForgetPwdBean;
import weizhihui.bwie.com.myquarter.retrofit.APIS;
import weizhihui.bwie.com.myquarter.retrofit.BaseObserver;
import weizhihui.bwie.com.myquarter.retrofit.RetrofitManager;

/**
 * author:Created by WangZhiQiang on 2018/4/27.
 */

public class ForgetModule {

    public void getData(Map<String, String> map, final ForgetModuleListener forgetModuleListener) {
        RetrofitManager.post(APIS.forgePwd, map, new BaseObserver<ForgetPwdBean>() {
            @Override
            public void success(ForgetPwdBean o) {
                if (forgetModuleListener != null) {
                    forgetModuleListener.success(o);
                }
            }

            @Override
            public void failure(int code) {

            }


        });
    }

    public interface ForgetModuleListener {
        void success(ForgetPwdBean forgetPwdBean);
    }
}
