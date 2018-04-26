package weizhihui.bwie.com.myquarter.presenter;

import java.util.Map;

import weizhihui.bwie.com.myquarter.bean.LoginBean;
import weizhihui.bwie.com.myquarter.model.LoginModule;


/**
 * Created by QinQinBaoBei on 2018/1/22.
 */

public class LoginPresenter {
    private LoginPresenterListener loginPresenterListener;
    private final LoginModule loginModule;

    public LoginPresenter(LoginPresenterListener loginPresenterListener) {
        this.loginPresenterListener = loginPresenterListener;
        loginModule = new LoginModule();
    }

    public void getData(Map<String,String> map){

         loginModule.getData(map, new LoginModule.LoginModuleListener() {
             @Override
             public void success(LoginBean loginBean) {
                 if(loginPresenterListener!=null){
                     loginPresenterListener.success(loginBean.getMsg());
                     //WeakReference d = new WeakReference(true= Activity==)
                 }
             }
         });
    }
    public void detach(){
        loginPresenterListener=null;
    }
    public interface LoginPresenterListener{
        void success(String s);
    }
}
