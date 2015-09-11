package appdevzhang.com.umengall.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Response;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import appdevzhang.com.umengall.R;
import appdevzhang.com.umengall.net.Url;
import appdevzhang.com.umengall.net.XMLRequest;

/**
 * @ClassName: XMLRequestActivity
 * @Description:
 * @author: appdevzhang
 * @email: 1160030655@qq.com
 * @date: 15/8/27 下午11:03
 */
public class XMLRequestActivity extends BaseActivity {
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_request);
        findViewById(R.id.bt_xml_request).setOnClickListener(this);
        tvResult = (TextView) findViewById(R.id.tv_request_result);

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.bt_xml_request:
                executeRequest(new XMLRequest(Url.XMLREQUESTURL, listener(), errorListener()));
                break;
            default:
                break;
        }
    }

    protected Response.Listener<XmlPullParser> listener() {
        return new Response.Listener<XmlPullParser>() {
            @Override
            public void onResponse(XmlPullParser xmlPullParser) {
                try {
                    int eventType = xmlPullParser.getEventType();
                    StringBuffer stringBuffer = new StringBuffer();
                    while (eventType != XmlPullParser.END_DOCUMENT) {
                        switch (eventType) {
                            case XmlPullParser.START_TAG:
                                String nodeName = xmlPullParser.getName();
                                if ("city".equals(nodeName)) {
                                    stringBuffer.append(xmlPullParser.getAttributeValue(0) + " ");
                                }
                                break;
                        }
                        eventType = xmlPullParser.next();
                    }
                    tvResult.setText(stringBuffer.toString());

                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                }
        };
    }
}
