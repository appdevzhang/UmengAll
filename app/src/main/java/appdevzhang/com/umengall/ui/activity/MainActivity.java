package appdevzhang.com.umengall.ui.activity;

import android.os.Bundle;

import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;
import com.umeng.update.UmengUpdateAgent;

import appdevzhang.com.umengall.R;
import appdevzhang.com.umengall.ui.activity.base.BaseActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @OnClick(R.id.bt_string_request) void goString(){
        NextPage(StringRequestActivity.class,false);
    };
    @OnClick(R.id.bt_json_request) void goJson(){
        NextPage(JsonRequestActivity.class,false);
    };
    @OnClick(R.id.bt_image_request) void goImageRequest(){
        NextPage(ImageRequestActivity.class,false);
    };
    @OnClick(R.id.bt_image_loader) void goImageLoader(){
        NextPage(ImageLoaderActivity.class,false);
    };
    @OnClick(R.id.bt_network_imageview) void goNetworkImageview(){
        NextPage(NetworkImageViewActivity.class,false);
    };
    @OnClick(R.id.bt_xml_request) void goXML(){
        NextPage(XMLRequestActivity.class, false);
    };
    @OnClick(R.id.bt_gson_request) void goGson(){
        NextPage(GsonRequestActivity.class, false);
    };
    @OnClick(R.id.bt_params_request) void nextPage(){
        NextPage(ParamsRequestActivity.class, false);
    };
    @OnClick(R.id.bt_convenient_banner) void goBanner(){
//        NextPage(ConvenientBanner.class, false);
    }
    @OnClick(R.id.bt_check_update) void checkUpdate(){
        UmengUpdateAgent.forceUpdate(this);
    };
    @OnClick(R.id.bt_request_clear) void clear(){
        this.finish();
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        UmengUpdateAgent.setUpdateOnlyWifi(false);//关闭仅在wifi下更新
//        UmengUpdateAgent.setUpdateUIStyle(UpdateStatus.STYLE_NOTIFICATION);//以通知的形式提示更新
        //Umeng Update
        UmengUpdateAgent.update(this);
        MobclickAgent.openActivityDurationTrack(false);
        MobclickAgent.updateOnlineConfig(this);
        //Umeng Message
        PushAgent mPushAgent = PushAgent.getInstance(this);
        mPushAgent.onAppStart();//统计应用启动数据
        mPushAgent.enable();//开启推送服务
//        mPushAgent.disable();//关闭客户端的通知服务
//        mPushAgent.isEnabled();//查询通知开启状态

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


    }
}
