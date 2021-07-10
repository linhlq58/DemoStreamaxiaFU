package com.botbanhang.botlive.view;

import com.botbanhang.botlive.base.BaseFaceUnityActivity;
import com.botbanhang.botlive.data.BodyBeautyDataFactory;
import com.botbanhang.botlive.entity.FunctionEnum;
import com.faceunity.core.enumeration.FUAIProcessorEnum;
import com.botbanhang.botlive.R;
import com.faceunity.ui.control.BodyBeautyControlView;

/**
 * DESC：
 * Created on 2021/3/2
 */
public class BodyBeautyActivity extends BaseFaceUnityActivity {


    private BodyBeautyControlView mBodyBeautyControlView;
    private BodyBeautyDataFactory mBodyBeautyDataFactory;

    @Override
    protected int getStubBottomLayoutResID() {
        return R.layout.layout_control_body_beauty;
    }

    @Override
    public void initData() {
        super.initData();
        mBodyBeautyDataFactory = new BodyBeautyDataFactory();
    }

    @Override
    protected void configureFURenderKit() {
        super.configureFURenderKit();
        mBodyBeautyDataFactory.bindCurrentRenderer();
    }


    @Override
    public void initView() {
        super.initView();
        mBodyBeautyControlView = (BodyBeautyControlView) mStubView;
        changeTakePicButtonMargin(getResources().getDimensionPixelSize(R.dimen.x298), getResources().getDimensionPixelSize(R.dimen.x122));
    }

    @Override
    public void bindListener() {
        super.bindListener();
        mBodyBeautyControlView.bindDataFactory(mBodyBeautyDataFactory);
    }


    @Override
    public void onDestroy() {
        mBodyBeautyDataFactory.releaseAIProcessor();
        super.onDestroy();
    }

    @Override
    protected FUAIProcessorEnum getFURenderKitTrackingType() {
        return FUAIProcessorEnum.HUMAN_PROCESSOR;
    }

    @Override
    protected int getFunctionType() {
        return FunctionEnum.BODY_BEAUTY;
    }
}
