package weizhihui.bwie.com.myquarter.utils;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;


/**
 * Created by Administrator on 2018/3/26.
 */

public class BaseApplication extends Application {


        public BaseApplication() {
        }

        protected String getAppkey() {
            return null;
        }

        protected String getAppSecret() {
            return null;
        }




    private static Context mContext;


    public static BaseApplication instances;

    @Override
    public void onCreate() {
        super.onCreate();
        //目的是为了别人获取上下文
        mContext = getApplicationContext();
        //图片  初始化
        Fresco.initialize(this);
//        MobSDK.init(this, this.getAppkey(), this.getAppSecret());
    }

    /**
     * 单例模式
     *
     * @return
     */
    public static BaseApplication getInstances() {
        return instances;
    }

    public static Context getContext() {
        return mContext;
    }
}
