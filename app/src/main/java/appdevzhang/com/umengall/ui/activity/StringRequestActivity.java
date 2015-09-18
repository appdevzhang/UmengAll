package appdevzhang.com.umengall.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import appdevzhang.com.umengall.R;
import appdevzhang.com.umengall.net.Url;
import appdevzhang.com.umengall.ui.activity.base.BaseActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @ClassName: StringRequestActivity
 * @Description:
 * @author: appdevzhang
 * @email: 1160030655@qq.com
 * @date: 15/8/27 上午11:14
 */
public class StringRequestActivity extends BaseActivity {

    @Bind(R.id.tv_request_result) private TextView tvResult;
    @OnClick(R.id.bt_string_request) void doRequest(){
        executeRequest(new StringRequest(Request.Method.GET, Url.STRINGREQUESTURL, listener(), errorListener()));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_request);

        ButterKnife.bind(this);
    }

    private Response.Listener<String> listener(){
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                tvResult.setText(string);
            }
        };
    }
}
