
package com.example.abc.stockbridge.data.Koinex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTC {

    @SerializedName("last_traded_price")
    @Expose
    private Long lastTradedPrice;
    @SerializedName("lowest_ask")
    @Expose
    private String lowestAsk;
    @SerializedName("highest_bid")
    @Expose
    private String highestBid;
    @SerializedName("min_24hrs")
    @Expose
    private String min24hrs;
    @SerializedName("max_24hrs")
    @Expose
    private String max24hrs;
    @SerializedName("vol_24hrs")
    @Expose
    private Long vol24hrs;

    public Long getLastTradedPrice() {
        return lastTradedPrice;
    }

    public void setLastTradedPrice(Long lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
    }

    public BTC withLastTradedPrice(Long lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
        return this;
    }

    public String getLowestAsk() {
        return lowestAsk;
    }

    public void setLowestAsk(String lowestAsk) {
        this.lowestAsk = lowestAsk;
    }

    public BTC withLowestAsk(String lowestAsk) {
        this.lowestAsk = lowestAsk;
        return this;
    }

    public String getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(String highestBid) {
        this.highestBid = highestBid;
    }

    public BTC withHighestBid(String highestBid) {
        this.highestBid = highestBid;
        return this;
    }

    public String getMin24hrs() {
        return min24hrs;
    }

    public void setMin24hrs(String min24hrs) {
        this.min24hrs = min24hrs;
    }

    public BTC withMin24hrs(String min24hrs) {
        this.min24hrs = min24hrs;
        return this;
    }

    public String getMax24hrs() {
        return max24hrs;
    }

    public void setMax24hrs(String max24hrs) {
        this.max24hrs = max24hrs;
    }

    public BTC withMax24hrs(String max24hrs) {
        this.max24hrs = max24hrs;
        return this;
    }

    public Long getVol24hrs() {
        return vol24hrs;
    }

    public void setVol24hrs(Long vol24hrs) {
        this.vol24hrs = vol24hrs;
    }

    public BTC withVol24hrs(Long vol24hrs) {
        this.vol24hrs = vol24hrs;
        return this;
    }

}
