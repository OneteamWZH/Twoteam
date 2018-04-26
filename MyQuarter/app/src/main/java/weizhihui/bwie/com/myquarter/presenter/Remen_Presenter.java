package weizhihui.bwie.com.myquarter.presenter;

import weizhihui.bwie.com.myquarter.bean.Remen_Bean;
import weizhihui.bwie.com.myquarter.model.Remen_Model;
import weizhihui.bwie.com.myquarter.view.Remen_View;

/**
 * Created by asus on 2018/4/26.
 */

public class Remen_Presenter {

    Remen_Model remen_model;
    Remen_View remen_view;

    public Remen_Presenter(Remen_View remen_view) {
        this.remen_view = remen_view;
        remen_model = new Remen_Model();
    }

    public void getRemen_presenter(int uid,int type,int page,String source,int appVersion){
        remen_model.setRemen_Model(uid, type, page,source, appVersion);
        remen_model.getRemen_Listener(new Remen_Model.Remen_Listener() {
            @Override
            public void setRemen_Listener(Remen_Bean remen_bean) {
                if(remen_view!=null){
                    remen_view.setRemen_View(remen_bean);
                }
            }
        });
    }

}
