package appdevzhang.com.umengall.net;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;

/**
 * @ClassName: XMLRequest
 * @Description:
 * @author: appdevzhang
 * @email: 1160030655@qq.com
 * @date: 15/8/27 下午5:52
 */
public class XMLRequest extends Request<XmlPullParser>{
    private final Response.Listener<XmlPullParser> mListener;

    public XMLRequest(int method, String url,Response.Listener<XmlPullParser> listener,Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.mListener = listener;
    }

    public XMLRequest(String url,Response.Listener<XmlPullParser> listener ,Response.ErrorListener errorListener) {
        this(Method.GET,url,listener,errorListener);
    }

    @Override
    protected Response<XmlPullParser> parseNetworkResponse(NetworkResponse networkResponse) {
        String xmlString = null;
        try {
            xmlString = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(new StringReader(xmlString));
            return Response.success(xmlPullParser,HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError());
        } catch (XmlPullParserException e) {
            return Response.error(new ParseError());
        }
    }

    @Override
    protected void deliverResponse(XmlPullParser xmlPullParser) {
        mListener.onResponse(xmlPullParser);
    }
}
