package weizhihui.bwie.com.myquarter.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by asus on 2018/4/28.
 */

public class Preferences {
    private static final String shared_name="guide";

    private static SharedPreferences sp;
    public static String getString(Context context, String key, String defaultValues) {
        sp = context.getSharedPreferences(shared_name, context.MODE_PRIVATE);
        return sp.getString(key, defaultValues);
    }

    public static void setString(Context context, String key, String Values) {

        sp = context.getSharedPreferences(shared_name, context.MODE_PRIVATE);

        sp.edit().putString(key, Values).commit();

    }

}
