package appdevzhang.com.umengall.app;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;

import appdevzhang.com.umengall.net.RequestManager;

/**
 * @ClassName: VolleyDemoApp
 * @Description: application
 * @author: appdevzhang
 * @email: 1160030655@qq.com
 * @date: 15/8/26 下午5:14
 */
public class UmengAllApp extends Application {
    ArrayList<Activity> list = new ArrayList<Activity>();


    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        RequestManager.init(this);
    }

    /**
     * Activity关闭时，删除Activity列表中的Activity对象
     */
    public void removeActivity(Activity a) {
        list.remove(a);
    }

    /**
     * 向Activity列表中添加Activity对象
     */
    public void addActivity(Activity a) {
        list.add(a);
    }

    /**
     * 关闭Activity列表中的所有Activity
     */
    public void finishActivity() {
        for (Activity activity : list) {
            if (null != activity) {
                activity.finish();
            }
        }
        // 杀死该应用进程
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
