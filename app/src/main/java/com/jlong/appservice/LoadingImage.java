package com.jlong.appservice;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;


public class LoadingImage extends Activity {
    SimpleDraweeView mDraweeViewe ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Fresco.initialize(this);
        setContentView(R.layout.activity_loading_image);
        mDraweeViewe = (SimpleDraweeView) this.findViewById(R.id.sd_img);
        Uri uri = Uri.parse("http://www.jcodecraeer.com/uploads/150329/1-150329192I2Q5.png");

        /*GenericDraweeHierarchy hierarchy = mDraweeViewe.getHierarchy();
        RoundingParams roundingParams = hierarchy.getRoundingParams();
        roundingParams.setCornersRadius(10);
        hierarchy.setRoundingParams(roundingParams);*/
        mDraweeViewe.setImageURI(uri);

    }
}
