package appdevzhang.com.umengall.ui.activity.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.umeng.analytics.MobclickAgent;

import java.util.Map;

import appdevzhang.com.umengall.net.RequestManager;

/**
 * @ClassName: BaseActivity
 * @Description: Base of Activity
 * @author: appdevzhang
 * @email: 1160030655@qq.com
 * @date: 15/8/27 上午11:16
 */
public class BaseActivity extends Activity implements View.OnClickListener {
    protected Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(activity);
        MobclickAgent.onPageStart(activity.getClass().getSimpleName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(activity);
        MobclickAgent.onPageEnd(activity.getClass().getSimpleName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        RequestManager.cancelAll(this);
    }

    protected void executeRequest(Request<?> request) {
        RequestManager.addRequest(request, this);
    }

    protected Response.ErrorListener errorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(activity, volleyError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * @param name
     * @param param
     * @param finishFlg
     * @return void
     * @Title: NextPage
     * @Description: (页面跳转)
     */
    public void NextPage(Class<?> name, Bundle param, boolean finishFlg) {
        Intent intent = new Intent(this, name);
        if (param != null) {
            intent.putExtras(param);
        }
        startActivity(intent);
        if (finishFlg) {
            finish();
        }
    }

    public void NextPage(Class<?> name, boolean finishFlg) {
        Intent intent = new Intent(this, name);
        startActivity(intent);
        if (finishFlg) {
            finish();
        }
    }

    public void NextPage(Class<?> name, Map<String, String> param, boolean finishFlg) {
        Intent intent = new Intent(this, name);
        if (param != null) {
            for (Map.Entry<String, String> m : param.entrySet()) {
                intent.putExtra(m.getKey(), m.getValue());
            }
        }
        startActivity(intent);
        if (finishFlg) {
            finish();
        }
    }

    public void NextPageForResult(Class<?> name, Bundle param, int requestCode) {
        Intent intent = new Intent(this, name);
        if (param != null) {
            intent.putExtras(param);
        }
        startActivityForResult(intent, requestCode);
    }

    public void NextPageForResult(Class<?> name, int requestCode) {
        Intent intent = new Intent(this, name);
        startActivityForResult(intent, requestCode);
    }

    public void NextPageForResult(Class<?> name, Map<String, String> param, int requestCode) {
        Intent intent = new Intent(this, name);
        if (param != null) {
            for (Map.Entry<String, String> m : param.entrySet()) {
                intent.putExtra(m.getKey(), m.getValue());
            }
        }
        startActivityForResult(intent, requestCode);
    }

    public void BackPage(Bundle param, int resultCode) {
        Intent intent = new Intent();
        if (param != null) {
            intent.putExtras(param);
        }
        setResult(resultCode, intent);
        finish();
    }
}
