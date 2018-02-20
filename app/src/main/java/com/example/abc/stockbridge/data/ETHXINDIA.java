package com.example.abc.stockbridge.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by divyshah on 20/2/18.
 */

public class ETHXINDIA {
    @SerializedName("ticker")
    @Expose
    private String ticker;
    @SerializedName("high")
    @Expose
    private String high;
    @SerializedName("low")
    @Expose
    private String low;
    @SerializedName("avg")
    @Expose
    private Double avg;
    @SerializedName("total_volume_24h")
    @Expose
    private Long totalVolume24h;
    @SerializedName("current_volume")
    @Expose
    private Long currentVolume;
    @SerializedName("last_traded_price")
    @Expose
    private Long lastTradedPrice;
    @SerializedName("bid")
    @Expose
    private Long bid;
    @SerializedName("ask")
    @Expose
    private Long ask;
    @SerializedName("last_traded_time")
    @Expose
    private Long lastTradedTime;
    @SerializedName("last_traded_time_IST")
    @Expose
    private Long lastTradedTimeIST;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public ETHXINDIA withTicker(String ticker) {
        this.ticker = ticker;
        return this;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public ETHXINDIA withHigh(String high) {
        this.high = high;
        return this;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public ETHXINDIA withLow(String low) {
        this.low = low;
        return this;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public ETHXINDIA withAvg(Double avg) {
        this.avg = avg;
        return this;
    }

    public Long getTotalVolume24h() {
        return totalVolume24h;
    }

    public void setTotalVolume24h(Long totalVolume24h) {
        this.totalVolume24h = totalVolume24h;
    }

    public ETHXINDIA withTotalVolume24h(Long totalVolume24h) {
        this.totalVolume24h = totalVolume24h;
        return this;
    }

    public Long getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(Long currentVolume) {
        this.currentVolume = currentVolume;
    }

    public ETHXINDIA withCurrentVolume(Long currentVolume) {
        this.currentVolume = currentVolume;
        return this;
    }

    public Long getLastTradedPrice() {
        return lastTradedPrice;
    }

    public void setLastTradedPrice(Long lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
    }

    public ETHXINDIA withLastTradedPrice(Long lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
        return this;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public ETHXINDIA withBid(Long bid) {
        this.bid = bid;
        return this;
    }

    public Long getAsk() {
        return ask;
    }

    public void setAsk(Long ask) {
        this.ask = ask;
    }

    public ETHXINDIA withAsk(Long ask) {
        this.ask = ask;
        return this;
    }

    public Long getLastTradedTime() {
        return lastTradedTime;
    }

    public void setLastTradedTime(Long lastTradedTime) {
        this.lastTradedTime = lastTradedTime;
    }

    public ETHXINDIA withLastTradedTime(Long lastTradedTime) {
        this.lastTradedTime = lastTradedTime;
        return this;
    }

    public Long getLastTradedTimeIST() {
        return lastTradedTimeIST;
    }

    public void setLastTradedTimeIST(Long lastTradedTimeIST) {
        this.lastTradedTimeIST = lastTradedTimeIST;
    }

    public ETHXINDIA withLastTradedTimeIST(Long lastTradedTimeIST) {
        this.lastTradedTimeIST = lastTradedTimeIST;
        return this;
    }

}
