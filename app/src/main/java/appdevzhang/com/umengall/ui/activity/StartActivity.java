package appdevzhang.com.umengall.ui.activity;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.appdevzhang.convenientbanner.transforms.StackTransformer;

import java.util.ArrayList;
import java.util.List;

import appdevzhang.com.umengall.R;
import appdevzhang.com.umengall.ui.activity.base.BaseActivity;
import appdevzhang.com.umengall.utils.ImageCompress;

public class StartActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    private Context mContext;
    public static int screenW, screenH;
    private Button mStart;

    private static final int VIEW_NO_1 = 0;
    private static final int VIEW_NO_2 = 1;
    private static final int VIEW_NO_3 = 2;
    private static final int VIEW_NO_4 = 3;
    private static final int VIEW_NO_5 = 4;

    // 第1页的资源,坐标
    static ImageView mOnePointer;
    // 第2页的资源,坐标
    static ImageView mTwoCar;
    // 第3页的资源,坐标
    static ImageView mThreeCloudFast;
    static ImageView mThreeCloudSlow;
    static ImageView mThreeCarShadow;
    static ImageView mThreeCar;
    // 第4页的资源,坐标
    static ImageView mFourPig;
    static ImageView mFourPigShadow;
    static ImageView mFourCoin;
    static ImageView mFourCoinPack;
    // 第5页的资源,坐标
    static ImageView mFiveCar;
    static ImageView mFiveCarShadow;
    static ImageView mFiveCloudFast;
    static ImageView mFiveCloudSlow;


    private int preIndex = 0;
    private ViewPager mPager;
    private GuideViewPagerAdapter mPagerAdapter;
    List<View> list = new ArrayList<View>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mContext = this;
        DisplayMetrics metrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        screenH = metrics.widthPixels;// 屏幕宽度（像素）
        screenW = metrics.heightPixels;// 屏幕高度（像素）

        LayoutInflater inflater = LayoutInflater.from(this);
        View view0 = inflater.inflate(R.layout.fragment_guide_page_1, null, false);
        mOnePointer = (ImageView) view0.findViewById(R.id.one_pointer);
        View view1 = inflater.inflate(R.layout.fragment_guide_page_2, null, false);
        View view2 = inflater.inflate(R.layout.fragment_guide_page_3, null, false);
        View view3 = inflater.inflate(R.layout.fragment_guide_page_4, null, false);
        View view4 = inflater.inflate(R.layout.fragment_guide_page_5, null, false);
        mStart = (Button) view4.findViewById(R.id.bt_start);
        mStart.setOnClickListener(this);


        list.add(view0);
        list.add(view1);
        list.add(view2);
        list.add(view3);
        list.add(view4);


        mPager = (ViewPager) findViewById(R.id.vp_start);
        mPagerAdapter = new GuideViewPagerAdapter(list);
        mPager.setAdapter(mPagerAdapter);
        mPager.setOnPageChangeListener(this);
        mPager.setPageTransformer(true, new StackTransformer());

        animal(VIEW_NO_1);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.bt_start:
                NextPage(HomeActivity.class, true);
                break;
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        animal(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void animal(int position) {
        try {
            switch (position) {
                case VIEW_NO_1:
                    AccelerateDecelerateInterpolator interpolator = new AccelerateDecelerateInterpolator();
                    Animation animation1_1 = AnimationUtils.loadAnimation(this,
                            R.anim.guide_one_pointer_ratate);
                    animation1_1.setFillAfter(true);
                    animation1_1.setInterpolator(interpolator);
                    mOnePointer.clearAnimation();
                    mOnePointer.startAnimation(animation1_1);
                    break;
                case VIEW_NO_2:
                    AnimationDrawable animation2_1 = (AnimationDrawable) mTwoCar
                            .getBackground();
//				animation2_1.unscheduleSelf(null); // 重新将Frame动画设置到第-1帧，也就是重新开始
                    animation2_1.setVisible(false, true);
                    animation2_1.start();
                    break;
                case VIEW_NO_3:
                    LinearInterpolator linearInterpolator = new LinearInterpolator();
                    Animation animation3_1 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_PARENT, 1.0f,
                            Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);
                    animation3_1.setDuration(25000);
                    animation3_1.setInterpolator(linearInterpolator);
                    mThreeCloudFast.clearAnimation();
                    mThreeCloudFast.startAnimation(animation3_1);
                    Animation animation3_2 = new TranslateAnimation(
                            Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_PARENT, 1.0f,
                            Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);
                    animation3_2.setDuration(35000);
                    animation3_2.setInterpolator(linearInterpolator);
                    mThreeCloudSlow.clearAnimation();
                    mThreeCloudSlow.startAnimation(animation3_2);
                    Animation animation3_3 = new ScaleAnimation(1.0f, 1.0f, 1.0f,
                            1.05f, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1.0f);
                    animation3_3.setRepeatCount(-1);
                    animation3_3.setRepeatMode(Animation.REVERSE);
                    animation3_3.setDuration(500);
                    animation3_3.setInterpolator(linearInterpolator);
                    mThreeCar.clearAnimation();
                    mThreeCar.startAnimation(animation3_3);
                    Animation animation3_4 = new ScaleAnimation(1.0f, 1.05f, 1.0f,
                            1.05f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    animation3_4.setRepeatCount(-1);
                    animation3_4.setDuration(500);
                    animation3_4.setRepeatMode(Animation.REVERSE);
                    animation3_4.setInterpolator(linearInterpolator);
                    mThreeCarShadow.clearAnimation();
                    mThreeCarShadow.startAnimation(animation3_4);
                    break;

                case VIEW_NO_4:
                    // 钱桶的动画
                    Animation animation4_1 = new RotateAnimation(0, 5, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
                    animation4_1.setRepeatCount(-1);
                    animation4_1.setDuration(300);
                    mFourCoinPack.clearAnimation();
                    mFourCoinPack.startAnimation(animation4_1);
                    // 硬币掉落的动画
                    AnimationDrawable animation4_2 = (AnimationDrawable) mFourCoin.getBackground();
                    animation4_2.start();
                    // 小猪的动画
                    Animation animation4_3 = new ScaleAnimation(1.0f, 1.0f, 1.0f, 1.05f, Animation.RELATIVE_TO_SELF, 0,
                            Animation.RELATIVE_TO_SELF, 1.0f);
                    animation4_3.setRepeatCount(-1);
                    animation4_3.setDuration(500);
                    mFourPig.clearAnimation();
                    mFourPig.startAnimation(animation4_3);
                    // 小猪影子的动画
                    Animation animation4_4 = new ScaleAnimation(1.0f, 1.05f, 1.0f, 1.05f, Animation.RELATIVE_TO_SELF, 0.75f,
                            Animation.RELATIVE_TO_SELF, 0.95f);
                    animation4_4.setRepeatCount(-1);
                    animation4_4.setDuration(500);
                    mFourPigShadow.clearAnimation();
                    mFourPigShadow.startAnimation(animation4_4);
                    break;
                case VIEW_NO_5:
                    LinearInterpolator linearInterpolator2 = new LinearInterpolator();
                    Animation animation5_1 = new TranslateAnimation(
                            Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_PARENT, 1.0f,
                            Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);
                    animation5_1.setDuration(25000);
                    animation5_1.setInterpolator(linearInterpolator2);
                    mFiveCloudFast.clearAnimation();
                    mFiveCloudFast.startAnimation(animation5_1);
                    Animation animation5_2 = new TranslateAnimation(
                            Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_PARENT, 1.0f,
                            Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);
                    animation5_2.setDuration(35000);
                    animation5_2.setInterpolator(linearInterpolator2);
                    mFiveCloudSlow.clearAnimation();
                    mFiveCloudSlow.startAnimation(animation5_2);
                    Animation animation5_3 = new ScaleAnimation(1.0f, 1.0f, 1.0f, 1.1f,
                            Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1.0f);
                    animation5_3.setRepeatCount(-1);
                    animation5_3.setDuration(500);
                    animation5_3.setRepeatMode(Animation.REVERSE);
                    mFiveCar.clearAnimation();
                    mFiveCar.startAnimation(animation5_3);
                    Animation animation5_4 = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f,
                            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    animation5_4.setRepeatCount(-1);
                    animation5_4.setDuration(500);
                    animation5_4.setRepeatMode(Animation.REVERSE);
                    mFiveCarShadow.clearAnimation();
                    mFiveCarShadow.startAnimation(animation5_4);
                    break;

            }
            preIndex = position;
        } catch (Exception e) {
            finish();
        }
    }

    public class GuideViewPagerAdapter extends PagerAdapter {
        private List<View> mListViews;

        public GuideViewPagerAdapter(List<View> mListViews) {
            this.mListViews = mListViews;// 构造方法，参数是我们的页卡，这样比较方便。
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = mListViews.get(position);
            BitmapDrawable drawable = (BitmapDrawable) view.getBackground();
            if (drawable != null) {
                drawable.getBitmap().recycle();
            }
            switch (position) {
                case VIEW_NO_1:
                    break;
                case VIEW_NO_2:
//				mTwoCar.getBackground().setCallback(null) ;
                    break;
                case VIEW_NO_3:
                    BitmapDrawable d3_1 = (BitmapDrawable) mThreeCar.getBackground();
                    if (d3_1 != null) {
                        d3_1.getBitmap().recycle();
                    }
                    BitmapDrawable d3_2 = (BitmapDrawable) mThreeCarShadow.getBackground();
                    if (d3_2 != null) {
                        d3_2.getBitmap().recycle();
                    }
                    break;

                case VIEW_NO_4:
//				mFourCoin.getBackground().setCallback(null) ;
                    BitmapDrawable d4_1 = (BitmapDrawable) mFourCoinPack.getBackground();
                    if (d4_1 != null) {
                        d4_1.getBitmap().recycle();
                    }
                    BitmapDrawable d4_2 = (BitmapDrawable) mFourPig.getBackground();
                    if (d4_2 != null) {
                        d4_2.getBitmap().recycle();
                    }
                    BitmapDrawable d4_3 = (BitmapDrawable) mFourPigShadow.getBackground();
                    if (d4_3 != null) {
                        d4_3.getBitmap().recycle();
                    }
                    break;
                case VIEW_NO_5:
                    BitmapDrawable d5_1 = (BitmapDrawable) mFiveCar.getBackground();
                    if (d5_1 != null) {
                        d5_1.getBitmap().recycle();
                    }
                    BitmapDrawable d5_2 = (BitmapDrawable) mFiveCarShadow.getBackground();
                    if (d5_2 != null) {
                        d5_2.getBitmap().recycle();
                    }
                    break;

                default:
                    break;
            }
            container.removeView(mListViews.get(position));// 删除页卡
        }

        @SuppressWarnings("deprecation")
        @Override
        public Object instantiateItem(ViewGroup container, int position) { // 这个方法用来实例化页卡
            View view = mListViews.get(position);
            container.addView(view, 0);// 添加页卡
            switch (position) {
                case VIEW_NO_1:
                    mOnePointer = (ImageView) view.findViewById(R.id.one_pointer);
                    view.setBackgroundDrawable(
                            ImageCompress.getInstance().getCompressFromId(mContext, R.drawable.guide_one_bg, screenW, screenH));
                    break;
                case VIEW_NO_2:
                    mTwoCar = (ImageView) view.findViewById(R.id.two_car);
                    mTwoCar.setBackgroundResource(R.drawable.guide_two_car_frame_anim);
                    view.setBackgroundDrawable(
                            ImageCompress.getInstance().getCompressFromId(mContext, R.drawable.guide_two_bg, screenW, screenH));
                    break;
                case VIEW_NO_3:
                    mThreeCar = (ImageView) view.findViewById(R.id.three_car);
                    mThreeCarShadow = (ImageView) view.findViewById(R.id.three_car_shadow);
                    mThreeCloudFast = (ImageView) view.findViewById(R.id.three_cloud_fast);
                    mThreeCloudSlow = (ImageView) view.findViewById(R.id.three_cloud_slow);
                    view.setBackgroundDrawable(ImageCompress.getInstance().getCompressFromId(mContext, R.drawable.guide_three_bg, screenW, screenH));
                    break;

                case VIEW_NO_4:
                    mFourCoinPack = (ImageView) view.findViewById(R.id.four_pack);
                    mFourCoin = (ImageView) view.findViewById(R.id.four_coin);
                    mFourCoin.setBackgroundResource(R.drawable.guide_four_coin_frame_anim);
                    mFourPig = (ImageView) view.findViewById(R.id.four_pig);
                    mFourPigShadow = (ImageView) view.findViewById(R.id.four_pig_shadow);
                    view.setBackgroundDrawable(
                            ImageCompress.getInstance().getCompressFromId(mContext, R.drawable.guide_four_bg, screenW, screenH));
                    break;
                case VIEW_NO_5:
                    mFiveCar = (ImageView) view.findViewById(R.id.five_car);
                    mFiveCarShadow = (ImageView) view.findViewById(R.id.five_car_shadow);
                    mFiveCloudFast = (ImageView) view.findViewById(R.id.five_cloud_fast);
                    mFiveCloudSlow = (ImageView) view.findViewById(R.id.five_cloud_slow);
//                    view.setOnTouchListener(mOnTouchListener);
                    view.setBackgroundDrawable(
                            ImageCompress.getInstance().getCompressFromId(mContext, R.drawable.guide_five_bg, screenW, screenH));
                    break;
                default:
                    break;
            }

            return mListViews.get(position);
        }

        @Override
        public int getCount() {
            return mListViews.size();// 返回页卡的数量
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;// 官方提示这样写
        }
    }
    /*
    View.OnTouchListener mOnTouchListener = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (preIndex == 4) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x1 = (int) event.getX();
                        Toast.makeText(StartActivity.this, "X1--->" + x1,
                                Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_MOVE:

                        x2 = (int) event.getX();
                        Toast.makeText(StartActivity.this, "X2--->" + x2,
                                Toast.LENGTH_SHORT).show();
//                        if ((x2 - x1) < 0) {
//                            finish();
//                        }

                        // Toast.makeText(MainActivity.this, "<--->" + (int)
                        // event.getX(), Toast.LENGTH_SHORT).show() ;
                        break;
                    case MotionEvent.ACTION_UP:
                        x2 = (int) event.getX();
                        Toast.makeText(StartActivity.this, "X2--->" + x2,
                                Toast.LENGTH_SHORT).show();
//                        if ((x2 - x1) < 0) {
//                            finish();
//                        }
                        break;
                    default:
                        break;
                }
            }
            return true;
        }
    };


    int x1 = 0, x2 = 0;
    */
}
