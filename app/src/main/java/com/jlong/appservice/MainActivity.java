package com.jlong.appservice;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private ViewPager viewPager;
    private int imgIds[] = new int[]{R.drawable.guide_image1, R.drawable.guide_image2, R.drawable.guide_image3};

    private String[] imgUrls = new String[]{"http://www.jcodecraeer.com/uploads/150329/1-150329192I2Q5.png",
            "http://www.jcodecraeer.com/uploads/150329/1-150329192I2Q5.png",
            "http://www.jcodecraeer.com/uploads/150329/1-150329192I2Q5.png"};
    private List<ImageView> ivList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.vp_img);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                Toast.makeText(MainActivity.this,""+i,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                SimpleDraweeView mDraweeViewe = new SimpleDraweeView(MainActivity.this);
                //ImageView imgView = (ImageView) View.inflate(getApplicationContext(),R.layout.layout_imgview, null);
                /*GenericDraweeHierarchy hierarchy = mDraweeViewe.getHierarchy();
                hierarchy.setPlaceholderImage(imgIds[position]);*/

                mDraweeViewe.setScaleType(ImageView.ScaleType.CENTER_CROP);
                mDraweeViewe.setAspectRatio(1f);
                Uri imgUri = Uri.parse(imgUrls[position]);
                mDraweeViewe.setImageURI(imgUri);
                container.addView(mDraweeViewe);
                ivList.add(mDraweeViewe);
                return mDraweeViewe;
            }

            @Override
            public int getItemPosition(Object object) {
                return super.getItemPosition(object);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(ivList.get(position));
            }

            @Override
            public int getCount() {
                return imgUrls.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        });
    }

}
