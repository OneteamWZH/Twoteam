package weizhihui.bwie.com.myquarter.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import weizhihui.bwie.com.myquarter.R;

/**
 * Created by asus on 2018/4/16.
 */

public class Fragment02 extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.duanzi,container,false);
        TextView textView = new TextView(getActivity());
        textView.setText("zheshilifangxinjiashangqudeha9999999");
        return textView;
    }
}
