package weizhihui.bwie.com.myquarter.model;

import android.util.Log;

import java.util.Map;

import weizhihui.bwie.com.myquarter.bean.LoginBean;
import weizhihui.bwie.com.myquarter.retrofit.APIS;
import weizhihui.bwie.com.myquarter.retrofit.BaseObserver;
import weizhihui.bwie.com.myquarter.retrofit.RetrofitManager;


/**
 * Created by QinQinBaoBei on 2018/1/22.
 */

public class LoginModule {

    public void getData(Map<String, String> map, final LoginModuleListener loginModuleListener){
        RetrofitManager.post(APIS.login, map, new BaseObserver<LoginBean>() {
            @Override
            public void success(LoginBean loginBean) {
                if(loginModuleListener!=null){
                    loginModuleListener.success(loginBean);
                }
            }

            @Override
            public void failure(int code) {
                Log.d("TAG",code+"");
            }

        });
    }

    public interface LoginModuleListener{
           void success(LoginBean loginBean);
    }

}
