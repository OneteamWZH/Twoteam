package weizhihui.bwie.com.myquarter;

import android.content.Intent;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.OnClick;
import weizhihui.bwie.com.myquarter.view.activity.BaseActivity;

public class Login_Activity extends BaseActivity {
    @BindView(R.id.ElseLogin)
    TextView ElseLogin;
    @BindView(R.id.hui)
    ImageView mHui;
    @BindView(R.id.weixin)
    ImageView mWx;
    @BindView(R.id.qq)
    ImageView mQq;
    private static final String TAG = "MainActivity";
    private static final String APP_ID = "1105602574";//官方获取的APPID
    private Tencent mTencent;
    private BaseUiListener mIUiListener;
    private UserInfo mUserInfo;
    private UserInfo mInfo;

    @Override
    protected int getRootView() {

        return R.layout.activity_login_;
    }

    @Override
    protected void initView() {

    }


    @Override
    protected void initData() {
        //传入参数APPID和全局Context上下文
        mTencent = Tencent.createInstance(APP_ID,Login_Activity.this.getApplicationContext());
    }

    @Override
    protected void initListener() {

    }

    @Override
    @OnClick({ R.id.hui, R.id.weixin, R.id.qq, R.id.ElseLogin})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hui:
                Intent in = new Intent(Login_Activity.this, MainActivity.class);
                startActivity(in);
                break;
            case R.id.ElseLogin:
                Intent elseLogin = new Intent(Login_Activity.this, ElseLogin_Activity.class);
                startActivity(elseLogin);
                break;
            case R.id.qq:
//              跳转到QQ登录第三方页面  ——琳琳做
                /**通过这句代码，SDK实现了QQ的登录，这个方法有三个参数，第一个参数是context上下文，第二个参数SCOPO 是一个String类型的字符串，表示一些权限
                 官方文档中的说明：应用需要获得哪些API的权限，由“，”分隔。例如：SCOPE = “get_user_info,add_t”；所有权限用“all”
                 第三个参数，是一个事件监听器，IUiListener接口的实例，这里用的是该接口的实现类 */
                mIUiListener = new BaseUiListener();
                //all表示获取所有权限
                mTencent.login(Login_Activity.this,"all", mIUiListener);
                updateUserInfo();
                break;
            case R.id.weixin:
//              跳转到微信登录第三方页面  ——琳琳做
                break;
            default:
                break;
        }
    }

    @Override
    protected void processClick(View v) {

    }


    /**
     * 自定义监听器实现IUiListener接口后，需要实现的3个方法
     * onComplete完成 onError错误 onCancel取消
     */
    private class BaseUiListener implements IUiListener{

        @Override
        public void onComplete(Object response) {
            Toast.makeText(Login_Activity.this, "授权成功", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "response:" + response);
            JSONObject obj = (JSONObject) response;
            try {
                String openID = obj.getString("openid");
                String accessToken = obj.getString("access_token");
                String expires = obj.getString("expires_in");
                mTencent.setOpenId(openID);
                mTencent.setAccessToken(accessToken,expires);
                QQToken qqToken = mTencent.getQQToken();
                mUserInfo = new UserInfo(getApplicationContext(),qqToken);
                mUserInfo.getUserInfo(new IUiListener() {
                    @Override
                    public void onComplete(Object response) {
                        Log.e(TAG,"登录成功"+response.toString());
                    }

                    @Override
                    public void onError(UiError uiError) {
                        Log.e(TAG,"登录失败"+uiError.toString());
                    }

                    @Override
                    public void onCancel() {
                        Log.e(TAG,"登录取消");

                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError(UiError uiError) {
            Toast.makeText(Login_Activity.this, "授权失败", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancel() {
            Toast.makeText(Login_Activity.this, "授权取消", Toast.LENGTH_SHORT).show();

        }

    }

    /**
     * 在调用Login的Activity或者Fragment中重写onActivityResult方法
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == Constants.REQUEST_LOGIN){
            Tencent.onActivityResultData(requestCode,resultCode,data,mIUiListener);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void updateUserInfo() {
        if (mTencent != null && mTencent.isSessionValid()) {
            IUiListener listener = new IUiListener() {
                @Override
                public void onError(UiError e) {
                }
                @Override
                public void onComplete(final Object response) {
                    Message msg = new Message();
                    msg.obj = response;
                    Log.i("tag", response.toString());
                    msg.what = 0;
                    //mHandler.sendMessage(msg);
                }
                @Override
                public void onCancel() {
                }
            };
            mInfo = new UserInfo(this, mTencent.getQQToken());
            mInfo.getUserInfo(listener);

        }
    }
//    Handler mHandler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            if (msg.what == 0) {
//                JSONObject response = (JSONObject) msg.obj;
//                if (response.has("nickname")) {
//                    try {
//                        Gson gson=new Gson();
//                        User user=gson.fromJson(response.toString(),User.class);
//                        if (user!=null) {
//
////                            //加载圆形图片
////                            Uri uri1 = Uri.parse("res:///" + R.mipmap.hui);
////                            AbstractDraweeController build1 = Fresco.newDraweeControllerBuilder()
////                                    .setUri(uri1)
////                                    .setTapToRetryEnabled(true)
////                                    .build();
////                            mSimpleClick.setController(build1);
//
//                           //Picasso.with(Login_Activity.this).load(response.getString("figureurl_qq_2")).into(imageView);
//                        }
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//    };


}
