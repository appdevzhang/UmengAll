package appdevzhang.com.umengall.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.appdevzhang.convenientbanner.ConvenientBanner;

import java.util.ArrayList;
import java.util.List;

import appdevzhang.com.umengall.R;

public class ConvenientBannerActivity extends AppCompatActivity {
    private ConvenientBanner convenientBanner;//顶部广告栏控件
    private ArrayList<Integer> localImages = new ArrayList<Integer>();
    private List<String> networkImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convenient_banner);
    }
}
