package com.timi.dispositivosmoveis2021.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Comments implements Parcelable {

    private int     postId;
    private int     id;
    private String  name;
    private String  email;
    private String  body;

    public Comments (int postId, int id, String name, String email, String body) {
        this.postId = postId;
        this.id     = id;
        this.name   = name;
        this.email  = email;
        this.body   = body;
    }

    protected Comments(Parcel in) {
        this.postId = in.readInt();
        this.id     = in.readInt();
        this.name   = in.readString();
        this.email  = in.readString();
        this.body   = in.readString();
    }

    public static final Creator<Comments> CREATOR = new Creator<Comments>() {
        @Override
        public Comments createFromParcel(Parcel in) { return new Comments(in); }
        @Override
        public Comments[] newArray(int size) { return new Comments[size]; }
    };

    public int getPostId() { return postId; }

    public void setPostId(int postId) { this.postId = postId; }

    public int getId() { return id; }

   // public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeInt(postId);
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(body);
    }
}
