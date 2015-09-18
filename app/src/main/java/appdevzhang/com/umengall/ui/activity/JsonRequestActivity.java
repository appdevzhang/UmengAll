package appdevzhang.com.umengall.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import appdevzhang.com.umengall.R;
import appdevzhang.com.umengall.net.Url;
import appdevzhang.com.umengall.ui.activity.base.BaseActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @ClassName: JsonRequestActivity
 * @Description:
 * @author: appdevzhang
 * @email: 1160030655@qq.com
 * @date: 15/8/27 下午3:57
 */
public class JsonRequestActivity extends BaseActivity {

    @OnClick(R.id.bt_json_request) void doRequest(){
        executeRequest(new JsonObjectRequest(Request.Method.GET, Url.JSONREQUESTURL,null,listener(),errorListener()));
    };
    @Bind(R.id.tv_request_result) TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_request);

        ButterKnife.bind(this);
    }

    private Response.Listener<JSONObject> listener(){
        return new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                tvResult.setText(jsonObject.toString());
            }
        };
    }
}
