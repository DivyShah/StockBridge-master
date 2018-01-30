package com.example.abc.stockbridge.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by divyshah on 16/1/18.
 */

public class CoinSecure {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("count")
    @Expose
    private float count;
    @SerializedName("message")
    @Expose
    private Message message;
    @SerializedName("time")
    @Expose
    private float time;
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("title")
    @Expose
    private String title;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public float getCount() {
        return count;
    }

    public void setCount(float count) {
        this.count = count;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
