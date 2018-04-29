package weizhihui.bwie.com.myquarter.presenter;


import weizhihui.bwie.com.myquarter.model.ParagraphModel;
import weizhihui.bwie.com.myquarter.view.ParagraphP_I;
import weizhihui.bwie.com.myquarter.view.ParagraphView;

/**
 * Created by Y_xl on 2018/4/20.
 */

public class ParagraphPresenter implements ParagraphP_I {

    private final ParagraphModel paragraph_m;
    private final ParagraphView paragraphV_i;

    public ParagraphPresenter(ParagraphView paragraphV_i) {
        this.paragraphV_i = paragraphV_i;
        paragraph_m = new ParagraphModel(this);
    }

    public void getdata(String s) {
        paragraph_m.getdata(s);
    }

    @Override
    public void success(String s) {
        paragraphV_i.success(s);
    }

}
