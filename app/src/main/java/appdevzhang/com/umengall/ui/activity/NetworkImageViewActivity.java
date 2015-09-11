package appdevzhang.com.umengall.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import appdevzhang.com.umengall.R;
import appdevzhang.com.umengall.net.RequestManager;
import appdevzhang.com.umengall.net.Url;

/**
 * @ClassName: NetworkImageViewActivity
 * @Description:
 * @author: appdevzhang
 * @email: 1160030655@qq.com
 * @date: 15/8/27 下午5:20
 */
public class NetworkImageViewActivity extends BaseActivity{
    private NetworkImageView networkImageView;
    private ImageLoader imageLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_imageview);
        networkImageView = (NetworkImageView) findViewById(R.id.niv_loader);
        findViewById(R.id.bt_network_imageview).setOnClickListener(this);
        imageLoader = RequestManager.getImageLoader();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.bt_network_imageview:
                networkImageView.setDefaultImageResId(R.mipmap.ic_launcher);
                networkImageView.setErrorImageResId(R.mipmap.ic_launcher);
                networkImageView.setImageUrl(Url.IMAGEREQUESTURL,imageLoader);
                break;
            default:
                break;
        }
    }
}
