package com.ninise.computoolsglobaltest.mvp.model.entities;

public class CardViewEntity {

    private String mTitle;
    private String mDesrp;

    public CardViewEntity(String title, String desrp) {
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
