package appdevzhang.com.umengall.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.umeng.analytics.MobclickAgent;
import com.umeng.update.UmengUpdateAgent;

import appdevzhang.com.umengall.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        UmengUpdateAgent.setUpdateOnlyWifi(false);//关闭仅在wifi下更新
//        UmengUpdateAgent.setUpdateUIStyle(UpdateStatus.STYLE_NOTIFICATION);//以通知的形式提示更新
        UmengUpdateAgent.update(this);
        MobclickAgent.openActivityDurationTrack(false);
        MobclickAgent.updateOnlineConfig(this);

        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_string_request).setOnClickListener(this);
        findViewById(R.id.bt_json_request).setOnClickListener(this);
        findViewById(R.id.bt_image_request).setOnClickListener(this);
        findViewById(R.id.bt_image_loader).setOnClickListener(this);
        findViewById(R.id.bt_network_imageview).setOnClickListener(this);
        findViewById(R.id.bt_xml_request).setOnClickListener(this);
        findViewById(R.id.bt_gson_request).setOnClickListener(this);
        findViewById(R.id.bt_params_request).setOnClickListener(this);
        findViewById(R.id.bt_check_update).setOnClickListener(this);
        findViewById(R.id.bt_request_clear).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_string_request:
                NextPage(StringRequestActivity.class,false);
                break;
            case R.id.bt_json_request:
                NextPage(JsonRequestActivity.class,false);
                break;
            case R.id.bt_image_request:
                NextPage(ImageRequestActivity.class,false);
                break;
            case R.id.bt_image_loader:
                NextPage(ImageLoaderActivity.class,false);
                break;
            case R.id.bt_network_imageview:
                NextPage(NetworkImageViewActivity.class,false);
                break;
            case R.id.bt_xml_request:
                NextPage(XMLRequestActivity.class,false);
                break;
            case R.id.bt_gson_request:
                NextPage(GsonRequestActivity.class,false);
                break;
            case R.id.bt_params_request:
                NextPage(ParamsRequestActivity.class,false);
                break;
            case R.id.bt_request_clear:
                this.finish();
                break;
            case R.id.bt_check_update:
                UmengUpdateAgent.forceUpdate(this);
                break;
            default:
                break;
        }
    }
}
