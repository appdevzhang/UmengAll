package appdevzhang.com.umengall.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import appdevzhang.com.umengall.R;
import appdevzhang.com.umengall.net.Url;

/**
 * @ClassName: StringRequestActivity
 * @Description:
 * @author: appdevzhang
 * @email: 1160030655@qq.com
 * @date: 15/8/27 上午11:14
 */
public class StringRequestActivity extends BaseActivity{

    private Button btStringRequest;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_request);
        btStringRequest = (Button) findViewById(R.id.bt_string_request);
        btStringRequest.setOnClickListener(this);
        tvResult = (TextView) findViewById(R.id.tv_request_result);

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.bt_string_request:
                executeRequest(new StringRequest(Request.Method.GET, Url.STRINGREQUESTURL,listener(),errorListener()));
                break;
            default:
                break;
        }
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
