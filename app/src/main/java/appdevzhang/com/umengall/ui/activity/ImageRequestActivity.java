package appdevzhang.com.umengall.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

import appdevzhang.com.umengall.R;
import appdevzhang.com.umengall.net.Url;
import appdevzhang.com.umengall.ui.activity.base.BaseActivity;

/**
 * @ClassName: ImageRequestActivity
 * @Description:
 * @author: appdevzhang
 * @email: 1160030655@qq.com
 * @date: 15/8/27 下午4:15
 */
public class ImageRequestActivity extends BaseActivity {
    private Button btImageRequest;
    private ImageView ivResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_request);
        btImageRequest = (Button) findViewById(R.id.bt_image_request);
        btImageRequest.setOnClickListener(this);
        ivResult = (ImageView) findViewById(R.id.iv_request_result);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.bt_image_request:
                executeRequest(new ImageRequest(Url.IMAGEREQUESTURL,listener(),0,0, Bitmap.Config.RGB_565,errorListener()));
                break;
            default:
                break;
        }
    }

    private Response.Listener<Bitmap> listener(){
        return new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                ivResult.setImageBitmap(bitmap);
            }
        };
    }

    @Override
    protected Response.ErrorListener errorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                ivResult.setImageResource(R.mipmap.ic_launcher);
            }
        };
    }
}
