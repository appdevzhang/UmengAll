package appdevzhang.com.umengall.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Response;

import appdevzhang.com.umengall.R;
import appdevzhang.com.umengall.bean.Wheather;
import appdevzhang.com.umengall.net.GsonRequest;
import appdevzhang.com.umengall.net.Url;
import appdevzhang.com.umengall.ui.activity.base.BaseActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @ClassName: GsonRequestActivity
 * @Description:
 * @author: appdevzhang
 * @email: 1160030655@qq.com
 * @date: 15/8/28 上午10:48
 */
public class GsonRequestActivity extends BaseActivity {
    @Bind(R.id.tv_request_result) private TextView tvResult;
    @OnClick(R.id.bt_gson_request) void doRequest(){
        executeRequest(new GsonRequest<Wheather>(Url.JSONREQUESTURL, Wheather.class, listener(), errorListener()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson_request);

        ButterKnife.bind(this);
    }

    protected Response.Listener<Wheather> listener(){
        return new Response.Listener<Wheather>() {
            @Override
            public void onResponse(Wheather wheather) {
                tvResult.setText(wheather.toString());
            }
        };
    }

}
