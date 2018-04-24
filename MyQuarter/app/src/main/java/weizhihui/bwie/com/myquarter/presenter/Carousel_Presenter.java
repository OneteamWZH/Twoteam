package weizhihui.bwie.com.myquarter.presenter;

import weizhihui.bwie.com.myquarter.bean.Carousel_Bean;
import weizhihui.bwie.com.myquarter.model.Carousel_Model;
import weizhihui.bwie.com.myquarter.view.Carousel_View;

/**
 * Created by asus on 2018/4/16.
 */

public class Carousel_Presenter {

    Carousel_Model carousel_model;
    Carousel_View carousel_view;

    public Carousel_Presenter(Carousel_View carousel_view) {
        this.carousel_view = carousel_view;
        carousel_model = new Carousel_Model();
    }

    public void getCarousel_Presenter(){
        carousel_model.getCarousel_Model();
        carousel_model.getCarousel_Listener(new Carousel_Model.Carousel_Listener() {
            @Override
            public void setCarousel_Listener(Carousel_Bean carousel_bean) {
                if(carousel_view!=null){
                    carousel_view.setCarousel_View(carousel_bean);
                }
            }
        });
    }

}
