package weizhihui.bwie.com.myquarter.interceptor;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by QinQinBaoBei on 2018/1/22.
 */

public class InterceptorPost implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
            //post请求
            Request request = chain.request();

            FormBody.Builder builder= new FormBody.Builder();

            FormBody body = (FormBody) request.body();
            //获取原来的请求参数
            for(int i=0;i<body.size();i++){

                String name = body.name(i);
                String value = body.value(i);
                builder.add(name,value);
            }

          //添加新的请求参数
            builder.add("source","android");
            builder.add("appVersion","101");

            FormBody newbody = builder.build();
            //生成一个有公共参数的新request
            Request request1 = request.newBuilder().post(newbody).build();

            Response response = chain.proceed(request1);

            return response;
    }
}
