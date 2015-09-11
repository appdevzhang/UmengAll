package appdevzhang.com.umengall.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import appdevzhang.com.umengall.R;
import appdevzhang.com.umengall.net.Url;

/**
 * @ClassName: JsonRequestActivity
 * @Description:
 * @author: appdevzhang
 * @email: 1160030655@qq.com
 * @date: 15/8/27 下午3:57
 */
public class JsonRequestActivity extends BaseActivity {

    private Button btJsonRequest;
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_request);
        btJsonRequest = (Button) findViewById(R.id.bt_json_request);
        btJsonRequest.setOnClickListener(this);
        tvResult = (TextView) findViewById(R.id.tv_request_result);

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.bt_json_request:
                executeRequest(new JsonObjectRequest(Request.Method.GET, Url.JSONREQUESTURL,null,listener(),errorListener()));
                break;
            default:
                break;
        }

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
