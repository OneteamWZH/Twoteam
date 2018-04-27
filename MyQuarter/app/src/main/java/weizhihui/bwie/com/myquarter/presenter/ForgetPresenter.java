package weizhihui.bwie.com.myquarter.presenter;

import java.util.Map;

import weizhihui.bwie.com.myquarter.bean.ForgetPwdBean;
import weizhihui.bwie.com.myquarter.model.ForgetModule;

/**
 * author:Created by WangZhiQiang on 2018/4/27.
 */

public class ForgetPresenter {
    ForgetPresenterListener forgetPresenterListener;
    private final ForgetModule forgetModule;

    public ForgetPresenter(ForgetPresenterListener forgetPresenterListener) {
        this.forgetPresenterListener = forgetPresenterListener;
        forgetModule = new ForgetModule();
    }

    public void getData(Map<String,String> map) {
        forgetModule.getData(map, new ForgetModule.ForgetModuleListener() {
            @Override
            public void success(ForgetPwdBean forgetPwdBean) {
                if(forgetPresenterListener!=null) {
                    forgetPresenterListener.succcess(forgetPwdBean.getMsg());
                }
            }
        });
    }
    public void detach(){
        forgetPresenterListener=null;
    }

    public interface ForgetPresenterListener{
        void succcess(String s);
    }

}
