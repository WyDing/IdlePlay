package com.iwuyou.idleplay.mode;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by duanding on 16/11/23.
 */

public class Action implements Parcelable {
    //简要内容
    public static final int BRIEF = 1;
    //排序方式
    public static final int SORT = 2;
    //顶层title
    public static final int FORM = 3;

    private String name;
    private String startLabel;
    private String address;
    private List<String> imageList;
    private double money;
    private String imageDetailUrl;
    private int type;
    private int state;
    private boolean isLike;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartLabel() {
        return startLabel;
    }

    public void setStartLabel(String startLabel) {
        this.startLabel = startLabel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public String getImageDetailUrl() {
        return imageDetailUrl;
    }

    public void setImageDetailUrl(String imageDetailUrl) {
        this.imageDetailUrl = imageDetailUrl;
    }

    public Action() {
    }

    public Action(int type) {
        this.type = type;
    }

    public Action(String name, String startLabel, String address, List<String> imageList, double money, String imageDetailUrl, int type) {
        this.name = name;
        this.startLabel = startLabel;
        this.address = address;
        this.imageList = imageList;
        this.money = money;
        this.imageDetailUrl = imageDetailUrl;
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.startLabel);
        dest.writeString(this.address);
        dest.writeStringList(this.imageList);
        dest.writeDouble(this.money);
        dest.writeString(this.imageDetailUrl);
        dest.writeInt(this.type);
        dest.writeInt(this.state);
        dest.writeByte(this.isLike ? (byte) 1 : (byte) 0);
    }

    protected Action(Parcel in) {
        this.name = in.readString();
        this.startLabel = in.readString();
        this.address = in.readString();
        this.imageList = in.createStringArrayList();
        this.money = in.readInt();
        this.imageDetailUrl = in.readString();
        this.type = in.readInt();
        this.state = in.readInt();
        this.isLike = in.readByte() != 0;
    }

    public static final Creator<Action> CREATOR = new Creator<Action>() {
        @Override
        public Action createFromParcel(Parcel source) {
            return new Action(source);
        }

        @Override
        public Action[] newArray(int size) {
            return new Action[size];
        }
    };
}
