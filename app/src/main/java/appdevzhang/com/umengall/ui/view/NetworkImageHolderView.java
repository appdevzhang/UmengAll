package appdevzhang.com.umengall.ui.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.appdevzhang.convenientbanner.CBPageAdapter;

import appdevzhang.com.umengall.R;
import appdevzhang.com.umengall.net.RequestManager;

/**
 * Created by Sai on 15/8/4.
 * 网络图片加载例子
 */
public class NetworkImageHolderView implements CBPageAdapter.Holder<String>{
    private ImageView imageView;
    @Override
    public View createView(Context context) {
        //你可以通过layout文件来创建，也可以像我一样用代码创建，不一定是Image，任何控件都可以进行翻页
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context, final int position, String data) {
        imageView.setImageResource(R.drawable.ic_default_adimage);
        RequestManager.getImageLoader().get(data,ImageLoader.getImageListener(imageView, R.drawable.ic_default_adimage, R.mipmap.ic_launcher));

//        ImageLoader.getInstance().displayImage(data,imageView); Universalimageloader的使用方法
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击事件
                Toast.makeText(view.getContext(), "点击了第" + position + "个", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
