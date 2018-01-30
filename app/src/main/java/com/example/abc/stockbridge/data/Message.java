package com.example.abc.stockbridge.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by divyshah on 16/1/18.
 */

public class Message {
    @SerializedName("lastPrice")
    @Expose
    private float lastPrice;
    @SerializedName("timestamp")
    @Expose
    private float timestamp;
    @SerializedName("bid")
    @Expose
    private float bid;
    @SerializedName("ask")
    @Expose
    private float ask;
    @SerializedName("fiatvolume")
    @Expose
    private float fiatvolume;
    @SerializedName("coinvolume")
    @Expose
    private float coinvolume;
    @SerializedName("open")
    @Expose
    private float open;
    @SerializedName("high")
    @Expose
    private float high;
    @SerializedName("low")
    @Expose
    private float low;

    public float getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(float lastPrice) {
        this.lastPrice = lastPrice;
    }

    public float getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(float timestamp) {
        this.timestamp = timestamp;
    }

    public float getBid() {
        return bid;
    }

    public void setBid(float bid) {
        this.bid = bid;
    }

    public float getAsk() {
        return ask;
    }

    public void setAsk(float ask) {
        this.ask = ask;
    }

    public float getFiatvolume() {
        return fiatvolume;
    }

    public void setFiatvolume(float fiatvolume) {
        this.fiatvolume = fiatvolume;
    }

    public float getCoinvolume() {
        return coinvolume;
    }

    public void setCoinvolume(float coinvolume) {
        this.coinvolume = coinvolume;
    }

    public float getOpen() {
        return open;
    }

    public void setOpen(float open) {
        this.open = open;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

}

