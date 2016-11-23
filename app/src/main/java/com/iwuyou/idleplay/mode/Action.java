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
    private int money;

    private int type;

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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public Action() {
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
        dest.writeInt(this.money);
        dest.writeInt(this.type);
    }

    protected Action(Parcel in) {
        this.name = in.readString();
        this.startLabel = in.readString();
        this.address = in.readString();
        this.imageList = in.createStringArrayList();
        this.money = in.readInt();
        this.type = in.readInt();
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
