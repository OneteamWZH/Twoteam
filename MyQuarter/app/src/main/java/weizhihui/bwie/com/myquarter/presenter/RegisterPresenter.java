package weizhihui.bwie.com.myquarter.presenter;

import java.util.Map;

import weizhihui.bwie.com.myquarter.bean.RegisterBean;
import weizhihui.bwie.com.myquarter.model.RegisterModule;


/**
 * Created by QinQinBaoBei on 2018/1/22.
 */

public class RegisterPresenter {
      RegisterPresenterListener registerPresenterListener;
    private final RegisterModule registerModule;

    public RegisterPresenter(RegisterPresenterListener registerPresenterListener) {
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
