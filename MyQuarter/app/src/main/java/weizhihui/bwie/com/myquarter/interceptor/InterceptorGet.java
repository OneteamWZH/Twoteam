package weizhihui.bwie.com.myquarter.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by QinQinBaoBei on 2018/1/22.
 */

public class InterceptorGet implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {
        //get请求
        Request request = chain.request();
        String s = request.url().url().toString();
        String url = s+"&source=android&appVersion=101";

        Request request1 = request.newBuilder().url(url).build();
        Response response = chain.proceed(request1);
        return response;
    }
}
