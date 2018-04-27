package weizhihui.bwie.com.myquarter.presenter;

import java.util.Map;

import weizhihui.bwie.com.myquarter.bean.RegisterBean;
import weizhihui.bwie.com.myquarter.model.RegisterModule;

/**
 * author:Created by WangZhiQiang on 2018/4/27.
 */

public class RegistPresenter {
    RegisterPresenterListener registerPresenterListener;
    private final RegisterModule registerModule;

    public RegistPresenter(RegisterPresenterListener registerPresenterListener) {
        this.registerPresenterListener = registerPresenterListener;
        registerModule = new RegisterModule();
    }

    public void getData(Map<String,String> map){
        registerModule.getData(map, new RegisterModule.RegisterModuleListener() {
            @Override
            public void success(RegisterBean registerBean) {
                if(registerPresenterListener!=null){
                    registerPresenterListener.success(registerBean.getCode());
                }
            }
        });
    }
    public void detach(){
        registerPresenterListener=null;
    }

    public interface RegisterPresenterListener{
        void success(String s);
    }
}
