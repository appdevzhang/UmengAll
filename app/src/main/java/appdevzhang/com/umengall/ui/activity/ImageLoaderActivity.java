package appdevzhang.com.umengall.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;

import appdevzhang.com.umengall.R;
import appdevzhang.com.umengall.net.RequestManager;
import appdevzhang.com.umengall.net.Url;

/**
 * @ClassName: ImageLoaderActivity
 * @Description:
 * @author: appdevzhang
 * @email: zhangzhongkai@damaiapp.com
 * @date: 15/8/26 下午4:20
 */
public class ImageLoaderActivity extends BaseActivity{
    private ImageView ivResult;
    private ImageLoader imageLoader;
    private ImageLoader.ImageListener imageListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader);
        ivResult = (ImageView) findViewById(R.id.iv_loader_result);
        findViewById(R.id.bt_image_loader).setOnClickListener(this);
        imageLoader = RequestManager.getImageLoader();
        imageListener = ImageLoader.getImageListener(ivResult,R.mipmap.ic_launcher,R.mipmap.ic_launcher);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.bt_image_loader:
                imageLoader.get(Url.IMAGEREQUESTURL,imageListener);
                break;
            default:
                break;
        }
    }
}
