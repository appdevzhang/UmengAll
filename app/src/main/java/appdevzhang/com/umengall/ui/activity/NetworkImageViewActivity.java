package appdevzhang.com.umengall.ui.activity;

import android.os.Bundle;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import appdevzhang.com.umengall.R;
import appdevzhang.com.umengall.net.RequestManager;
import appdevzhang.com.umengall.net.Url;
import appdevzhang.com.umengall.ui.activity.base.BaseActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @ClassName: NetworkImageViewActivity
 * @Description:
 * @author: appdevzhang
 * @email: 1160030655@qq.com
 * @date: 15/8/27 下午5:20
 */
public class NetworkImageViewActivity extends BaseActivity {
    private NetworkImageView networkImageView;
    @OnClick(R.id.bt_network_imageview) void doRequest(){
        networkImageView.setDefaultImageResId(R.mipmap.ic_launcher);
        networkImageView.setErrorImageResId(R.mipmap.ic_launcher);
        networkImageView.setImageUrl(Url.IMAGEREQUESTURL,imageLoader);
    };
    private ImageLoader imageLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_imageview);
        imageLoader = RequestManager.getImageLoader();
        networkImageView = (NetworkImageView) findViewById(R.id.niv_loader);

        ButterKnife.bind(this);
    }

}
