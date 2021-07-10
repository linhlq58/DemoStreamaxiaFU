package com.botbanhang.botlive.view;

import com.botbanhang.botlive.base.BaseFaceUnityActivity;
import com.botbanhang.botlive.data.HairBeautyDataFactory;
import com.botbanhang.botlive.R;
import com.botbanhang.botlive.entity.FunctionEnum;
import com.faceunity.ui.control.HairBeautyControlView;

/**
 * DESC：
 * Created on 2021/3/3
 */
public class HairBeautyActivity extends BaseFaceUnityActivity {

    private HairBeautyControlView mHairBeautyControlView;
    private HairBeautyDataFactory mHairBeautyDataFactory;

    @Override
    protected int getStubBottomLayoutResID() {
        return R.layout.layout_control_hair_beauty;
    }


    @Override
    protected void configureFURenderKit() {
        super.configureFURenderKit();
        mHairBeautyDataFactory.bindCurrentRenderer();
    }

    @Override
    public void initData() {
        super.initData();
        mHairBeautyDataFactory = new HairBeautyDataFactory(1);
    }

    @Override
    public void initView() {
        super.initView();
        mHairBeautyControlView = (HairBeautyControlView) mStubView;
        changeTakePicButtonMargin(getResources().getDimensionPixelSize(R.dimen.x282), getResources().getDimensionPixelSize(R.dimen.x122));
    }


    @Override
    public void bindListener() {
        super.bindListener();
        mHairBeautyControlView.bindDataFactory(mHairBeautyDataFactory);
    }

    @Override
    protected int getFunctionType() {
        return FunctionEnum.HAIR_BEAUTY;
    }


    @Override
    public void onDestroy() {
        mHairBeautyDataFactory.releaseAIProcessor();
        super.onDestroy();
    }
}
