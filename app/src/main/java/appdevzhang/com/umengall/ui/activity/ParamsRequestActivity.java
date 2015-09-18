package appdevzhang.com.umengall.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

import appdevzhang.com.umengall.R;
import appdevzhang.com.umengall.net.ApiParams;
import appdevzhang.com.umengall.net.Url;
import appdevzhang.com.umengall.ui.activity.base.BaseActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @ClassName: ParamsRequestActivity
 * @Description:
 * @author: appdevzhang
 * @email: 1160030655@qq.com
 * @date: 15/9/1 上午9:06
 */
public class ParamsRequestActivity extends BaseActivity {
    @Bind(R.id.tv_request_result) TextView tvResult;
    @OnClick(R.id.bt_params_request) void doRequest(){
        executeRequest(mStringRequest);
    }
    private StringRequest mStringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_params_request);

        ButterKnife.bind(this);
        mStringRequest = new StringRequest(Request.Method.POST, Url.PARAMSREQUESTURL,listener(),errorListener()){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return new ApiParams().with("param1","01").with("param2","02");
            }
        };
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
