package appdevzhang.com.umengall.ui.activity;

import android.os.Bundle;

import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.media.UMImage;
import com.umeng.update.UmengUpdateAgent;

import appdevzhang.com.umengall.R;
import appdevzhang.com.umengall.ui.activity.base.BaseActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartActivity extends BaseActivity {
    // 首先在您的Activity中添加如下成员变量
    final UMSocialService mController = UMServiceFactory.getUMSocialService("com.umeng.share");
    @OnClick(R.id.bt_string_request)
    void goString() {
        NextPage(StringRequestActivity.class, false);
    }

    @OnClick(R.id.bt_json_request)
    void goJson() {
        NextPage(JsonRequestActivity.class, false);
    }

    @OnClick(R.id.bt_image_request)
    void goImageRequest() {
        NextPage(ImageRequestActivity.class, false);
    }

    @OnClick(R.id.bt_image_loader)
    void goImageLoader() {
        NextPage(ImageLoaderActivity.class, false);
    }

    @OnClick(R.id.bt_network_imageview)
    void goNetworkImageview() {
        NextPage(NetworkImageViewActivity.class, false);
    }

    @OnClick(R.id.bt_xml_request)
    void goXML() {
        NextPage(XMLRequestActivity.class, false);
    }

    @OnClick(R.id.bt_gson_request)
    void goGson() {
        NextPage(GsonRequestActivity.class, false);
    }

    @OnClick(R.id.bt_params_request)
    void nextPage() {
        NextPage(ParamsRequestActivity.class, false);
    }

    @OnClick(R.id.bt_convenient_banner)
    void goBanner() {
//        NextPage(ConvenientBanner.class, false);
    }

    @OnClick(R.id.bt_check_update)
    void checkUpdate() {
        UmengUpdateAgent.forceUpdate(this);
    }

    @OnClick(R.id.bt_umeng_share)
    void umengShare() {
        // 是否只有已登录用户才能打开分享选择页
        mController.openShare(this, false);
    }

    @OnClick(R.id.bt_request_clear)
    void clear() {
        this.finish();
    }

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
        com.umeng.socialize.utils.Log.LOG = true;
        initUmengShare();
    }

    private void initUmengShare() {

        // 设置分享内容
        mController.setShareContent("友盟社会化组件（SDK）让移动应用快速整合社交分享功能，http://www.umeng.com/social");
        // 设置分享图片, 参数2为图片的url地址
        mController.setShareMedia(new UMImage(this,"http://www.umeng.com/images/pic/banner_module_social.png"));
        // 设置分享图片，参数2为本地图片的资源引用
        //mController.setShareMedia(new UMImage(getActivity(), R.drawable.icon));
        // 设置分享图片，参数2为本地图片的路径(绝对路径)
        //mController.setShareMedia(new UMImage(getActivity(), BitmapFactory.decodeFile("/mnt/sdcard/icon.png")));
        // 设置分享音乐
        //UMusic uMusic = new UMusic("http://sns.whalecloud.com/test_music.mp3");
        //uMusic.setAuthor("GuGu");
        //uMusic.setTitle("天籁之音");
        // 设置音乐缩略图
        //uMusic.setThumb("http://www.umeng.com/images/pic/banner_module_social.png");
        //mController.setShareMedia(uMusic);

        // 设置分享视频
        //UMVideo umVideo = new UMVideo(
        //          "http://v.youku.com/v_show/id_XNTE5ODAwMDM2.html?f=19001023");
        // 设置视频缩略图
        //umVideo.setThumb("http://www.umeng.com/images/pic/banner_module_social.png");
        //umVideo.setTitle("友盟社会化分享!");
        //mController.setShareMedia(umVideo);

        mController.getConfig().removePlatform( SHARE_MEDIA.RENREN, SHARE_MEDIA.DOUBAN);
    }
}
