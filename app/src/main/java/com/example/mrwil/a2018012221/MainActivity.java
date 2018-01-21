package com.example.mrwil.a2018012221;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image1 = (ImageView) findViewById(R.id.iv1);  //获得ImageView对象
         /*为什么图片一定要转化为 Bitmap格式的！！ */
        Bitmap bitmap = getLoacalBitmap("/storage/emulated/0/DCIM/Camera/IMG_20180121_084747.jpg"); //从本地取图片(在cdcard中获取)  //
        image1.setImageBitmap(bitmap); //设置Bitmap
    }
    public static Bitmap getLoacalBitmap(String url) {
        try {
            FileInputStream fis = new FileInputStream(url);
            return BitmapFactory.decodeStream(fis);  ///把流转化为Bitmap图片

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
