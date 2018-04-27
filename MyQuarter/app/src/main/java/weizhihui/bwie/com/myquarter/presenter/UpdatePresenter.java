package weizhihui.bwie.com.myquarter.presenter;

import java.util.Map;

import weizhihui.bwie.com.myquarter.bean.ForgetPwdBean;
import weizhihui.bwie.com.myquarter.model.ForgetModule;

/**
 * author:Created by WangZhiQiang on 2018/4/27.
 */

public class UpdatePresenter {
    UpdatePresenter.UpdatePresenterListener updatePresenterListener;
    private final ForgetModule forgetModule;

    public UpdatePresenter(UpdatePresenter.UpdatePresenterListener updatePresenterListener) {
        this.updatePresenterListener = updatePresenterListener;
        forgetModule = new ForgetModule();
    }

    public void getData(Map<String,String> map) {
        forgetModule.getData(map, new ForgetModule.ForgetModuleListener() {
            @Override
            public void success(ForgetPwdBean forgetPwdBean) {
                if(updatePresenterListener!=null) {
                    updatePresenterListener.succcess(forgetPwdBean.getMsg());
                }
            }
        });
    }
    public void detach(){
        updatePresenterListener=null;
    }

    public interface UpdatePresenterListener{
        void succcess(String s);
    }

}
