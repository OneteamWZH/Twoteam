package weizhihui.bwie.com.myquarter.utils;

import android.graphics.Bitmap;

/**
 * author:Created by WangZhiQiang on 2018/4/27.
 */

public class MessageEvent {

    private Bitmap message;

    public MessageEvent(Bitmap message) {
        this.message = message;
    }

    public Bitmap getMessage() {
        return message;
    }

    public void setMessage(Bitmap message) {
        this.message = message;
    }
}
