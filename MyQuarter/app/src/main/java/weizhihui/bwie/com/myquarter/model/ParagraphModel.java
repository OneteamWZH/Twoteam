package weizhihui.bwie.com.myquarter.model;


import java.util.HashMap;

import weizhihui.bwie.com.myquarter.api.Api;
import weizhihui.bwie.com.myquarter.utils.RetrofitAndOkHttpAndRxAndroid;
import weizhihui.bwie.com.myquarter.view.ParagraphP_I;

/**
 * Created by Y_xl on 2018/4/20.
 */

public class ParagraphModel {


    private final ParagraphP_I paragraph_p;

    public ParagraphModel(ParagraphP_I paragraph_p) {
        this.paragraph_p =paragraph_p;
    }

    public void getdata(String s) {

        HashMap<String, String> map = new HashMap<>();
        map.put("uid","13315");
        map.put("content",s);
        map.put("token","CA0472E4E3D63DCE47F388F778CA6C17");
        map.put("source","android");
        map.put("appVersion","3");
        RetrofitAndOkHttpAndRxAndroid.post(Api.add_content,map).subscribe(new weizhihui.bwie.com.myquarter.utils.BaseObserver() {
            @Override
            public void onSuccess(String result) {
                paragraph_p.success(result);
            }
        });
    }
}
