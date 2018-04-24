package weizhihui.bwie.com.myquarter.app;

import android.content.Context;
import android.widget.ImageView;

import com.youth.banner.loader.ImageLoader;

/**
 * Created by asus on 2018/4/16.
 */

public class Img_Banner extends ImageLoader{


    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage((String) path,imageView);
    }
}
