package weizhihui.bwie.com.myquarter.presenter;


import weizhihui.bwie.com.myquarter.bean.VersionBean;
import weizhihui.bwie.com.myquarter.model.VersionModle;
import weizhihui.bwie.com.myquarter.view.VersionView;

import static android.R.attr.type;

/**
 * Created by asus on 2018/4/20.
 */

public class VersionPresenter {

    private VersionView view;
    private VersionModle dataModle;

    public VersionPresenter(VersionView view) {
        this.view = view;
    }

    public void getVersionPresenter(){
        dataModle = new VersionModle();
        dataModle.getVersion(type);
        dataModle.onVersionListener(new VersionModle.setOnVersionListener() {
            @Override
            public void onSuccess(VersionBean versionBean) {
                if (view!=null){
                    view.onSuccess(versionBean);
                }
            }
        });
    }
}
