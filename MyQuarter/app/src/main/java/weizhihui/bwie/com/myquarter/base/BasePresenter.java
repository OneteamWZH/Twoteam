package weizhihui.bwie.com.myquarter.base;

import android.content.Context;

import weizhihui.bwie.com.myquarter.app.MyApp;


/**
 * Created by asus on 2018/3/16.
 */

public class BasePresenter<V extends BaseIView> {
//声明V
    protected V view;

    public BasePresenter(V view) {
        this.view = view;
    }

    //再次提供销毁的方法  彻底防止内存溢出
    public void onDestory(){
           view=null;
    }
    //拿环境变量
    public Context getcontext(){
        if(view!=null&view.context()!=null){
         return   view.context();
        }
        return MyApp.getMyApp();
    }


}
