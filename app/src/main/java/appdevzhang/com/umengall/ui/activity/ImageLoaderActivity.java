package appdevzhang.com.umengall.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;

import appdevzhang.com.umengall.R;
import appdevzhang.com.umengall.net.RequestManager;
import appdevzhang.com.umengall.net.Url;
import appdevzhang.com.umengall.ui.activity.base.BaseActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @ClassName: ImageLoaderActivity
 * @Description:
 * @author: appdevzhang
 * @email: 1160030655@qq.com
 * @date: 15/8/26 下午4:20
 */
public class ImageLoaderActivity extends BaseActivity {
    @Bind(R.id.iv_loader_result) ImageView ivResult;
    @OnClick(R.id.bt_image_loader) void get(){
        imageLoader.get(Url.IMAGEREQUESTURL,imageListener);
    }
    private ImageLoader imageLoader;
    private ImageLoader.ImageListener imageListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader);

        ButterKnife.bind(this);
        imageLoader = RequestManager.getImageLoader();
        imageListener = ImageLoader.getImageListener(ivResult,R.drawable.ic_default_adimage,R.mipmap.ic_launcher);
    }

}
