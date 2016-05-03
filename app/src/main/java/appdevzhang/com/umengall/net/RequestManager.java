package appdevzhang.com.umengall.net;

import android.app.ActivityManager;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * @ClassName: RequestManager
 * @Description: RequestManager
 * @author: appdevzhang
 * @email: 1160030655@qq.com
 * @date: 15/8/26 下午5:38
 */
public class RequestManager {

    private static RequestQueue requestQueue;
    private static ImageLoader imageLoader;

    private RequestManager(){

    };

    public static void init(Context context){
        requestQueue = Volley.newRequestQueue(context);
        int memClass = ((ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE)).getMemoryClass();
        //用整个进程内存的1/6 进行缓存。
        int maxSize = memClass * 1024 * 1024 / 6;
        imageLoader = new ImageLoader(requestQueue,new BitmapLruCache(maxSize));
    };

    public static RequestQueue getRequestQueue(){
        if(null != requestQueue){
            return requestQueue;
        }else {
            throw new IllegalStateException("RequestQueue not initialized");
        }
    }

    public static void addRequest(Request<?> request,Object tag){
        if(tag != null)
            request.setTag(tag);

        requestQueue.add(request);

    }

    public static void cancelAll(Object tag){
        requestQueue.cancelAll(tag);
    }

    public static ImageLoader getImageLoader(){
        if(imageLoader != null){
            return imageLoader;
        }else {
            throw new IllegalStateException("ImageLoader not initialized");
        }
    }
}
