package weizhihui.bwie.com.myquarter.view.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import weizhihui.bwie.com.myquarter.R;
import weizhihui.bwie.com.myquarter.presenter.ParagraphPresenter;
import weizhihui.bwie.com.myquarter.view.ParagraphView;

public class DuanZiActivity extends BaseActivity  {


    private TextView publish_top;
    private EditText publishEdit;
    private ParagraphPresenter presenter;
    private ImageView zp;
    private static int RESULT_LOAD_IMAGE = 10;
    private TextView iconTou;

    @Override
    protected int getRootView() {

        return R.layout.activity_duan_zi;
    }

    @Override
    protected void initView() {
        //这个是点击取消发布段子
        iconTou = (TextView) findViewById(R.id.iconTou);
        //这个是点击去发布
        publish_top = (TextView) findViewById(R.id.publish_top);
        //发表的段子 文本内容
        publishEdit = (EditText) findViewById(R.id.publishEit);
        //点击去相册挑选照片
        zp = (ImageView) findViewById(R.id.zp);
    }

    @Override
    protected void initData() {
        presenter = new ParagraphPresenter(new ParagraphView() {
            @Override
            public void success(String s) {

                Toast.makeText(DuanZiActivity.this, "" + s, Toast.LENGTH_SHORT).show();
                s = publishEdit.getText().toString();
                s = "";
            }
        });

    }

    @Override
    protected void initListener() {
//        取消发布，返回之前ShareActivity.class的点击事件
        iconTou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//        点击发布段子 ——发布至段子列表进行刷新展示
        publish_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发表的段子内容
                String s = publishEdit.getText().toString();
                presenter.getdata(s);
                Toast.makeText(DuanZiActivity.this, "发布成功！", Toast.LENGTH_SHORT).show();

                /*Fragment02 fragment02 = new Fragment02();
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = supportFragmentManager.beginTransaction();
                transaction.replace(R.id.f2,fragment02);
                transaction.commit();
                Intent intent = new Intent(DuanZiActivity.this, Fragment02.class);
                startActivity(intent);*/



                /*Intent intent = new Intent(DuanZiActivity.this, Fragment02.class);
                startActivity(intent);*/


                //                finish();
            }
        });
//         点击加号 ——打开相册选取照片并 上传图片至段子列表，
        zp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                //这里要传一个整形的常量RESULT_LOAD_IMAGE到startActivityForResult()方法。
                startActivityForResult(intent, RESULT_LOAD_IMAGE);

            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//我们需要判断requestCode是否是我们之前传给startActivityForResult()方法的RESULT_LOAD_IMAGE，并且返回的数据不能为空
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            //查询我们需要的数据
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView imageView = (ImageView) findViewById(R.id.zp);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }

    }
    public void cancel(View view){
        finish();
    }
    @Override
    protected void processClick(View v) {
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
//        presenter.detach();
    }
}
