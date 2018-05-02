package weizhihui.bwie.com.myquarter.view.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.analytics.MobclickAgent;

import weizhihui.bwie.com.myquarter.R;
import weizhihui.bwie.com.myquarter.bean.VersionBean;
import weizhihui.bwie.com.myquarter.presenter.VersionPresenter;
import weizhihui.bwie.com.myquarter.utils.OkHttp3Utils;
import weizhihui.bwie.com.myquarter.view.VersionView;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener,VersionView {

    /**
     * 版本号
     */
    private TextView mVersionCodeid;
    /**
     * 退出登录
     */
    private Button mUnLogin;
    private String versionCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();

        String appVersionName = getAppVersionName(this);
        mVersionCodeid.setText(appVersionName);

        VersionPresenter versionPresenter=new VersionPresenter(this);
        versionPresenter.getVersionPresenter();
    }
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    private void initView() {
        mVersionCodeid = (TextView) findViewById(R.id.versionCodeid);
        mUnLogin = (Button) findViewById(R.id.un_login);
        mUnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            //退出登录
            case R.id.un_login:
                finish();
                break;
        }
    }

    //获取当前的版本号
    private int getVersionCode() {
        //获取packagemanager的实例
        PackageManager packageManager = getPackageManager();
        //getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = null;
        try {
            packInfo = packageManager.getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Log.e("TAG","版本号"+packInfo.versionCode);
        Log.e("TAG","版本名"+packInfo.versionName);
        return packInfo.versionCode;
    }

    /**
     * 返回当前程序版本名
     */
    public static String getAppVersionName(Context context) {
        String versionName = "";
        try {
            // ---get the package info---
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            Log.e("VersionInfo", "Exception", e);
        }
        return versionName;
    }

    @Override
    public void onSuccess(VersionBean versionBean) {
        versionCode= versionBean.getData().getVersionCode();
        Log.i("code",versionCode);
        final String apkUrl = versionBean.getData().getApkUrl();
        Log.d("ccccc", apkUrl);
        try {
            int versionCode1 = getVersionCode();
            int i = Integer.parseInt(versionCode);
            if (i>versionCode1){
                AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);
                builder.setTitle("版本更新")
                        .setMessage("更新新的版本")
                        .setCancelable(true) //点击对话框以外的区域是否让对话框消
                        .setPositiveButton("更新版本", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(SettingActivity.this, "你点击了更新版本", Toast.LENGTH_SHORT).show();
                                OkHttp3Utils.download(SettingActivity.this, apkUrl, "E:\\version-master");

                                dialog.dismiss();
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(SettingActivity.this, "取消", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).create().show();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
