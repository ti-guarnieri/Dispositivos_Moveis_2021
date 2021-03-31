package com.timi.dispositivosmoveis2021.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Photos implements Parcelable {
    private int             albumId;
    private int             id;
    private String          title;
    private String          url;
    private String          thumbnailUrl;

    public Photos(int albumId, int id, String title, String url, String thumbnailUrl) {
        this.albumId      = albumId;
        this.id           = id;
        this.title        = title;
        this.url          = url;
        this.thumbnailUrl = thumbnailUrl;
    }
    private Photos(Parcel   in) {
        this.albumId      = in.readInt();
        this.id           = in.readInt();
        this.title        = in.readString();
        this.url          = in.readString();
        this.thumbnailUrl = in.readString();
    }

    public static final Creator<Photos> CREATOR = new Creator<Photos>() {
        @Override
        public Photos createFromParcel(Parcel in) {
            return new Photos(in);
        }

        @Override
        public Photos[] newArray(int size) { return new Photos[size]; }
    };

    public int getAlbumId() { return albumId; }

    public void setAlbumId(int albumId) { this.albumId = albumId; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public String getThumbnailUrl() { return thumbnailUrl; }

    public void setThumbnailUrl(String thumbnailUrl) { this.thumbnailUrl = thumbnailUrl; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeInt(this.albumId);
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeString(this.url);
        dest.writeString(this.thumbnailUrl);
    }
}