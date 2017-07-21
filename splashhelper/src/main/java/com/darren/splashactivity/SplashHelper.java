package com.darren.splashactivity;

import android.os.Handler;
import android.os.Message;

/**
 * Created by Darren on 2017/7/17.
 */

public class SplashHelper {

    /**
     * The default min time the splash screen will show
     */
    private static int SPLASH_TIME = 3000;

    /**
     * The number of mission need to be done before close the splash screen
     */
    private int mMissionCount;
    /**
     * How many mission have done. Call {@link #missionDone()} to increase it
     */
    private int mMissionDoneCount;

    /**
     * The method handlerMessage will be called after the splash time out.
     */
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mSplashTimeOut = true;
            isSplashDone();
        }
    };

    private SplashListener mSplashListener;

    /**
     * If the splash time is out.
     */
    private boolean mSplashTimeOut = false;

    public SplashHelper(SplashListener splashListener, int missionCount) {
        mSplashListener = splashListener;
        mMissionCount = missionCount;
    }

    /**
     * You should call this when the splash count down shall begin.
     */
    public void splash() {
        mHandler.sendEmptyMessageDelayed(0, SPLASH_TIME);
    }

    /**
     * You should call this when the splash count down shall begin.
     */
    public void splash(int splashTime) {
        SPLASH_TIME = splashTime;
        splash();
    }

    /**
     * You should call this when one of the missions is done .
     */
    public void missionDone() {
        mMissionCount++;
        isSplashDone();
    }

    private void isSplashDone() {
        if (mSplashTimeOut && mMissionCount == mMissionDoneCount) {
            mSplashListener.splashDone();
        }
    }

    /**
     * The thing you will do when the mission of splash screen is over .
     */
    public interface SplashListener {
        void splashDone();
    }

}
