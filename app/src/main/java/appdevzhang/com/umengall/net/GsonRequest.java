package appdevzhang.com.umengall.net;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

/**
 * @ClassName: GsonRequest
 * @Description:
 * @author: appdevzhang
 * @email: 1160030655@qq.com
 * @date: 15/8/28 上午9:31
 */
public class GsonRequest<T> extends Request<T> {
    private final Listener<T> mListener;
    private Gson mGson;
    private Class<T> mClass;

    public GsonRequest(int method,String url,Class<T> clazz,Listener<T> listener,ErrorListener errorListener) {
        super(method,url,errorListener);
        mListener = listener;
        mGson = new Gson();
        mClass = clazz;
    }

    public GsonRequest(String url,Class<T> clazz,Listener<T> listener,ErrorListener errorListener){
        this(Method.GET,url,clazz,listener,errorListener);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            String jsonStirng = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
            return Response.success(mGson.fromJson(jsonStirng,mClass),HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError());
        }
    }

    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }
}
