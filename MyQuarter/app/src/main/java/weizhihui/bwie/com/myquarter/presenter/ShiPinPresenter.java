package weizhihui.bwie.com.myquarter.presenter;

import weizhihui.bwie.com.myquarter.bean.ShiPinBean;
import weizhihui.bwie.com.myquarter.model.ShiPinModel;
import weizhihui.bwie.com.myquarter.view.ShIPinIview;

/**
 * Created by lenovo on 2018/4/25.
 */

public class ShiPinPresenter {
    private ShiPinModel shiPinModel;
    public void setShiPinDemo(String page, String android, String appVersion,String type, final ShIPinIview shIPinIview){
        shiPinModel=new ShiPinModel();
        shiPinModel.ShiPin(page, android, appVersion, type ,new ShiPinModel.OnGetListener() {
            @Override
            public void OnGetSuccess(ShiPinBean shiPinBean) {
                if (shIPinIview!=null){
                    shIPinIview.OnSuccess(shiPinBean);
                }
            }
        });

    }
}
