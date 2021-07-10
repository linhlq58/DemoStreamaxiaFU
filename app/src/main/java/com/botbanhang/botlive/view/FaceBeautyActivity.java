package com.botbanhang.botlive.view;


import android.media.MediaCodecInfo;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.botbanhang.botlive.base.BaseFaceUnityActivity;
import com.botbanhang.botlive.data.FaceBeautyDataFactory;
import com.botbanhang.botlive.R;
import com.botbanhang.botlive.entity.FunctionEnum;
import com.faceunity.ui.control.FaceBeautyControlView;
import com.streamaxia.android.handlers.EncoderHandler;
import com.streamaxia.android.handlers.RecordHandler;
import com.streamaxia.android.handlers.RtmpHandler;
import com.streamaxia.android.streamer.StreamaxiaStreamer;

import java.io.IOException;
import java.net.SocketException;

/**
 * DESC：美颜
 * Created on 2021/3/1
 */
public class FaceBeautyActivity extends BaseFaceUnityActivity implements RtmpHandler.RtmpListener, EncoderHandler.EncodeListener {


    private FaceBeautyControlView mFaceBeautyControlView;
    private FaceBeautyDataFactory mFaceBeautyDataFactory;


    public static boolean needBindDataFactory = false;

    @Override
    public void onResume() {
        if (needBindDataFactory) {
            mFaceBeautyControlView.bindDataFactory(mFaceBeautyDataFactory);
            needBindDataFactory = false;
        }
        super.onResume();
    }

    @Override
    protected int getStubBottomLayoutResID() {
        return R.layout.layout_control_face_beauty;
    }


    @Override
    protected void configureFURenderKit() {
        super.configureFURenderKit();
        mFaceBeautyDataFactory.bindCurrentRenderer();
    }

    @Override
    public void initData() {
        super.initData();
        mFaceBeautyDataFactory = new FaceBeautyDataFactory(mFaceBeautyListener);
    }

    @Override
    public void initView() {
        super.initView();

        configureStreamer();

        mFaceBeautyControlView = (FaceBeautyControlView) mStubView;
        changeTakePicButtonMargin(getResources().getDimensionPixelSize(R.dimen.x156), getResources().getDimensionPixelSize(R.dimen.x166));

        mBtnLive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                streamaxiaStreamer.startPublish("rtmp://rtmp.streamaxia.com/streamaxia/demo");
            }
        });
    }

    @Override
    public void bindListener() {
        super.bindListener();
        mFaceBeautyControlView.bindDataFactory(mFaceBeautyDataFactory);
        mFaceBeautyControlView.setOnBottomAnimatorChangeListener(showRate -> {
            // 收起 1-->0，弹出 0-->1
            updateTakePicButton(getResources().getDimensionPixelSize(R.dimen.x166), showRate,
                    getResources().getDimensionPixelSize(R.dimen.x156), getResources().getDimensionPixelSize(R.dimen.x256), true);
        });
    }


    @Override
    protected int getFunctionType() {
        return FunctionEnum.FACE_BEAUTY;
    }

    FaceBeautyDataFactory.FaceBeautyListener mFaceBeautyListener = new FaceBeautyDataFactory.FaceBeautyListener() {

        @Override
        public void onFilterSelected(int res) {
            showToast(res);
        }

        @Override
        public void onFaceBeautyEnable(boolean enable) {
            mCameraRenderer.setFURenderSwitch(enable);
        }
    };


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mFaceBeautyControlView.hideControlView();
        return super.onTouchEvent(event);
    }

    private void configureStreamer() {
        streamaxiaStreamer = new StreamaxiaStreamer(this);
        streamaxiaStreamer.setEncoderHandler(new EncoderHandler(this));
        streamaxiaStreamer.setRtmpHandler(new RtmpHandler(this));
        streamaxiaStreamer.setColorFormat(MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420Planar);

        streamaxiaStreamer.setVideoOutputResolution(720, 1280);
    }

    @Override
    public void onNetworkWeak() {

    }

    @Override
    public void onNetworkResume() {

    }

    @Override
    public void onEncodeIllegalArgumentException(IllegalArgumentException e) {

    }

    @Override
    public void onRtmpConnecting(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRtmpConnected(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

        isStreaming = true;
    }

    @Override
    public void onRtmpVideoStreaming() {

    }

    @Override
    public void onRtmpAudioStreaming() {

    }

    @Override
    public void onRtmpStopped() {

    }

    @Override
    public void onRtmpDisconnected() {

    }

    @Override
    public void onRtmpVideoFpsChanged(double v) {

    }

    @Override
    public void onRtmpVideoBitrateChanged(double v) {

    }

    @Override
    public void onRtmpAudioBitrateChanged(double v) {

    }

    @Override
    public void onRtmpBitrateChanged(double v) {

    }

    @Override
    public void onRtmpSocketException(SocketException e) {

    }

    @Override
    public void onRtmpIOException(IOException e) {

    }

    @Override
    public void onRtmpIllegalArgumentException(IllegalArgumentException e) {

    }

    @Override
    public void onRtmpIllegalStateException(IllegalStateException e) {

    }

    @Override
    public void onRtmpAuthenticationg(String s) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}