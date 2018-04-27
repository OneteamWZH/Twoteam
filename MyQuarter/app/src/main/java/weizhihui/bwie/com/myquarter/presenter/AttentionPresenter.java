package weizhihui.bwie.com.myquarter.presenter;

import weizhihui.bwie.com.myquarter.bean.AttentionBean;
import weizhihui.bwie.com.myquarter.model.AttentionModel;
import weizhihui.bwie.com.myquarter.view.AttentionView;

/**
 * Created by asus on 2018/4/27.
 */

public class AttentionPresenter {

    private AttentionView view;
    private AttentionModel attentionModel;

    public AttentionPresenter(AttentionView view) {
        this.view = view;
    }

    public void getAttentionPresenter(){
        attentionModel = new AttentionModel();
        attentionModel.getAttentionModel();
        attentionModel.setonAttentionListener(new AttentionModel.onAttentionListener() {
            @Override
            public void onSuccess(AttentionBean attentionBean) {

                if (view!=null){
                    view.onSuccessAtt(attentionBean);
                }
            }
        });
    }
}
