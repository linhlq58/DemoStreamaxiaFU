package com.botbanhang.botlive.view;


import com.botbanhang.botlive.base.BaseFaceUnityActivity;
import com.botbanhang.botlive.data.MakeupDataFactory;
import com.botbanhang.botlive.R;
import com.botbanhang.botlive.entity.FunctionEnum;
import com.faceunity.ui.control.MakeupControlView;

/**
 * DESC：
 * Created on 2021/3/1
 */
public class MakeupActivity extends BaseFaceUnityActivity {


    private MakeupControlView mMakeupControlView;
    private MakeupDataFactory mMakeupDataFactory;

    @Override
    protected int getStubBottomLayoutResID() {
        return R.layout.layout_control_makeup;
    }

    @Override
    protected void configureFURenderKit() {
        super.configureFURenderKit();
        mMakeupDataFactory.bindCurrentRenderer();
    }

    @Override
    public void initData() {
        super.initData();
        mMakeupDataFactory = new MakeupDataFactory(1);
    }

    @Override
    public void initView() {
        super.initView();
        mMakeupControlView = (MakeupControlView) mStubView;
        changeTakePicButtonMargin(getResources().getDimensionPixelSize(R.dimen.x304), getResources().getDimensionPixelSize(R.dimen.x122));

    }

    @Override
    public void bindListener() {
        super.bindListener();
        mMakeupControlView.bindDataFactory(mMakeupDataFactory);
        mMakeupControlView.setOnBottomAnimatorChangeListener(showRate -> {
            // 收起 1-->0，弹出 0-->1
            updateTakePicButton(getResources().getDimensionPixelSize(R.dimen.x122), showRate, getResources().getDimensionPixelSize(R.dimen.x304), getResources().getDimensionPixelSize(R.dimen.x98), false);
        });
    }

    @Override
    protected int getFunctionType() {
        return FunctionEnum.MAKE_UP;
    }

}