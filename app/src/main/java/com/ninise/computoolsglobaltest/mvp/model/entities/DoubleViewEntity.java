package com.ninise.computoolsglobaltest.mvp.model.entities;

public class DoubleViewEntity {

    private String mTitle;
    private String mDesrp;

    public DoubleViewEntity(String title, String desrp) {
        mTitle = title;
        mDesrp = desrp;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDesrp() {
        return mDesrp;
    }

    public void setDesrp(String desrp) {
        mDesrp = desrp;
    }
}
