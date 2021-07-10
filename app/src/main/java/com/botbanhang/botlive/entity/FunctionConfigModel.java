package com.botbanhang.botlive.entity;

import java.util.HashMap;

/**
 * DESC：更多控制菜单
 * Created on 2021/3/19
 */
public class FunctionConfigModel {
    public boolean isOpenResolutionChange = false;//是否配置分辨率设置窗口
    public boolean isOpenFURenderInput = false;//是否配置FURender输入形式选择窗口
    public boolean isOpenPhotoVideo = false;//是否配置输入源选择窗口
    public boolean isShowAutoFocus = true;//是否自动对焦

    public FunctionConfigModel(boolean isOpenFURenderInput, boolean isOpenResolutionChange, boolean isOpenPhotoVideo, boolean isShowAutoFocus) {
        this.isOpenFURenderInput = isOpenFURenderInput;
        this.isOpenResolutionChange = isOpenResolutionChange;
        this.isOpenPhotoVideo = isOpenPhotoVideo;
        this.isShowAutoFocus = isShowAutoFocus;
    }

    public static HashMap<Integer, FunctionConfigModel> functionSwitchMap = new HashMap<Integer, FunctionConfigModel>() {
        {
            this.put(FunctionEnum.FACE_BEAUTY, new FunctionConfigModel(true, true, true, true));
            this.put(FunctionEnum.MAKE_UP, new FunctionConfigModel(false, false, false, true));
            this.put(FunctionEnum.STICKER, new FunctionConfigModel(true, false, true, true));
            this.put(FunctionEnum.ANIMOJI, new FunctionConfigModel(true, false, false, true));
            this.put(FunctionEnum.HAIR_BEAUTY, new FunctionConfigModel(true, false, false, true));
            this.put(FunctionEnum.LIGHT_MAKEUP, new FunctionConfigModel(true, false, false, true));
            this.put(FunctionEnum.AR_MASK, new FunctionConfigModel(true, false, false, true));
            this.put(FunctionEnum.BIG_HEAD, new FunctionConfigModel(true, false, false, true));
            this.put(FunctionEnum.POSTER_CHANGE, new FunctionConfigModel(true, false, false, true));
            this.put(FunctionEnum.EXPRESSION_RECOGNITION, new FunctionConfigModel(true, false, false, true));
            this.put(FunctionEnum.MUSIC_FILTER, new FunctionConfigModel(true, false, false, true));
            this.put(FunctionEnum.FACE_WARP, new FunctionConfigModel(true, false, false, true));
            this.put(FunctionEnum.ACTION_RECOGNITION, new FunctionConfigModel(true, false, false, true));
            this.put(FunctionEnum.BODY_BEAUTY, new FunctionConfigModel(true, false, false, true));
            this.put(FunctionEnum.PORTRAIT_SEGMENT, new FunctionConfigModel(true, false, false, true));
            this.put(FunctionEnum.GESTURE_RECOGNITION, new FunctionConfigModel(true, false, false, true));
            this.put(FunctionEnum.BG_SEG_GREEN, new FunctionConfigModel(true, false, true, false));
            this.put(FunctionEnum.FINE_STICKER, new FunctionConfigModel(true, false, false, false));
            this.put(FunctionEnum.AVATAR, new FunctionConfigModel(false, false, false, false));
        }

    };

}
