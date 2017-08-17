package com.test.demoanimation.mode;

/**
 * Created by Administrator on 2017/8/9.
 */

public class ImageAndTextInfo {
    private String imgUrl;
    private  String context;


    public ImageAndTextInfo() {

    }

    public ImageAndTextInfo(String imgUrl, String context) {
        this.imgUrl = imgUrl;
        this.context = context;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
