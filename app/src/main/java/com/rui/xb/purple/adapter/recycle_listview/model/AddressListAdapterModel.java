package com.rui.xb.purple.adapter.recycle_listview.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rui on 2018/7/24.
 */

public class AddressListAdapterModel implements Parcelable {

    private String id;
    private String name;
    private boolean isDefault;
    private String phone;
    private String address;
    private String province;
    private String location;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeByte(this.isDefault ? (byte) 1 : (byte) 0);
        dest.writeString(this.phone);
        dest.writeString(this.address);
        dest.writeString(this.province);
        dest.writeString(this.location);
    }

    public AddressListAdapterModel() {
    }

    protected AddressListAdapterModel(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.isDefault = in.readByte() != 0;
        this.phone = in.readString();
        this.address = in.readString();
        this.province = in.readString();
        this.location = in.readString();
    }

    public static final Parcelable.Creator<AddressListAdapterModel> CREATOR = new Parcelable
            .Creator<AddressListAdapterModel>() {
        @Override
        public AddressListAdapterModel createFromParcel(Parcel source) {
            return new AddressListAdapterModel(source);
        }

        @Override
        public AddressListAdapterModel[] newArray(int size) {
            return new AddressListAdapterModel[size];
        }
    };
}
