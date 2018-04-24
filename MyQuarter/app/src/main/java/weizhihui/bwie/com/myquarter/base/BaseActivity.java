package weizhihui.bwie.com.myquarter.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by asus on 2018/3/16.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    //声明Presenter
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取布局
        setContentView(getLayoutId());
        //初始化布局
        initView();
        //提供Presenter
        presenter=providePresenter();
       //初始化数据
        initData();
      //相应数据的监听
        OnResultListener();

    }

    protected abstract void OnResultListener();

    protected abstract void initData();

    protected abstract P providePresenter();

    protected abstract void initView();

    protected abstract int getLayoutId();

    //提供销毁的方法  防止内存溢出


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
