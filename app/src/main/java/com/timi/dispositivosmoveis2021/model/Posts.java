package com.timi.dispositivosmoveis2021.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Posts implements Parcelable {

    private int     userId;
    private int     id;
    private String  title;
    private String  body;

    public Posts (int userId,int id,String title, String body){
        this.userId = userId;
        this.id     = id;
        this.title  = title;
        this.body   = body;
    }

    private Posts(Parcel in) {
        this.userId = in.readInt();
        this.id     = in.readInt();
        this.title  = in.readString();
        this.body   = in.readString();
    }

    public static final Creator<Posts> CREATOR = new Creator<Posts>() {
        @Override
        public Posts createFromParcel(Parcel in) { return new Posts(in); }

        @Override
        public Posts[] newArray(int size) { return new Posts[size]; }
    };

    public int getUserId() { return userId; }

    public void setUserId(int userId) { this.userId = userId; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeInt(userId);
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(body);
    }
}
