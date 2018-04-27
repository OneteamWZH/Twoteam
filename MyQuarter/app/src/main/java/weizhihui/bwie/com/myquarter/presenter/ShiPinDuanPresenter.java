package weizhihui.bwie.com.myquarter.presenter;

import weizhihui.bwie.com.myquarter.bean.ShipinDuanBean;
import weizhihui.bwie.com.myquarter.model.ShiPinDuanModel;
import weizhihui.bwie.com.myquarter.view.ShiPinDuanIview;

/**
 * Created by lenovo on 2018/4/26.
 */

public class ShiPinDuanPresenter {
    private ShiPinDuanModel shiPinDuanModel;
    public void ShiDuanDemo(String page, String android, String appVersion, final ShiPinDuanIview shiPinDuanIview){
        shiPinDuanModel=new ShiPinDuanModel();
        shiPinDuanModel.ShiDuanDemo(page, android, appVersion, new ShiPinDuanModel.OnGetListener() {
            @Override
            public void OnGetListener(ShipinDuanBean shipinDuanBean) {
                if (shiPinDuanIview!=null){
                   shiPinDuanIview.OnSuccess(shipinDuanBean);
                }
            }
        });

    }
}
