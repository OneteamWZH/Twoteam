package weizhihui.bwie.com.myquarter.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by asus on 2018/4/16.
 */

public class MyApp extends Application{
    private static MyApp myApp;
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        ImageLoaderConfiguration aDefault = ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(aDefault);
        myApp=this;

    }
    //提供环境变量
    public static MyApp getMyApp(){
        return myApp;
    }
}
