package com.apkglobal.realmdatabase;

import io.realm.RealmObject;

public class Data extends RealmObject {

    String name,mobile;

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }
}
