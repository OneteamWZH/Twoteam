package weizhihui.bwie.com.myquarter.presenter;

import weizhihui.bwie.com.myquarter.bean.DuanBean;
import weizhihui.bwie.com.myquarter.model.DuanModel;
import weizhihui.bwie.com.myquarter.view.DuanIview;

/**
 * Created by lenovo on 2018/4/27.
 */

public class DuanPresenter {
    private DuanModel duanModel;
    public void DuanDemo(String page, String android, String appVersion, final DuanIview duanIview){
        duanModel=new DuanModel();
        duanModel.DuanDemo(page, android, appVersion, new DuanModel.OnGetListner() {
            @Override
            public void OnGetSuccess(DuanBean duanBean) {
                if (duanIview!=null){
                    duanIview.OnSuccess(duanBean);
                }
            }
        });

    }
}
