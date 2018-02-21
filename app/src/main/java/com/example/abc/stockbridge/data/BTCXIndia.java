package com.example.abc.stockbridge.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by divyshah on 20/2/18.
 */

public class BTCXIndia {

    @SerializedName("ticker")
    @Expose
    private String ticker;
    @SerializedName("high")
    @Expose
    private Long high;
    @SerializedName("low")
    @Expose
    private Double low;
    @SerializedName("avg")
    @Expose
    private String avg;
    @SerializedName("total_volume_24h")
    @Expose
    private Long totalVolume24h;
    @SerializedName("current_volume")
    @Expose
    private Long currentVolume;
    @SerializedName("last_traded_price")
    @Expose
    private Double lastTradedPrice;
    @SerializedName("bid")
    @Expose
    private Double bid;
    @SerializedName("ask")
    @Expose
    private Long ask;
    @SerializedName("last_traded_time")
    @Expose
    private Long lastTradedTime;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public BTCXIndia withTicker(String ticker) {
        this.ticker = ticker;
        return this;
    }

    public Long getHigh() {
        return high;
    }

    public void setHigh(Long high) {
        this.high = high;
    }

    public BTCXIndia withHigh(Long high) {
        this.high = high;
        return this;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public BTCXIndia withLow(Double low) {
        this.low = low;
        return this;
    }

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }

    public BTCXIndia withAvg(String avg) {
        this.avg = avg;
        return this;
    }

    public Long getTotalVolume24h() {
        return totalVolume24h;
    }

    public void setTotalVolume24h(Long totalVolume24h) {
        this.totalVolume24h = totalVolume24h;
    }

    public BTCXIndia withTotalVolume24h(Long totalVolume24h) {
        this.totalVolume24h = totalVolume24h;
        return this;
    }

    public Long getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(Long currentVolume) {
        this.currentVolume = currentVolume;
    }

    public BTCXIndia withCurrentVolume(Long currentVolume) {
        this.currentVolume = currentVolume;
        return this;
    }

    public Double getLastTradedPrice() {
        return lastTradedPrice;
    }

    public void setLastTradedPrice(Double lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
    }

    public BTCXIndia withLastTradedPrice(Double lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
        return this;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public BTCXIndia withBid(Double bid) {
        this.bid = bid;
        return this;
    }

    public Long getAsk() {
        return ask;
    }

    public void setAsk(Long ask) {
        this.ask = ask;
    }

    public BTCXIndia withAsk(Long ask) {
        this.ask = ask;
        return this;
    }

    public Long getLastTradedTime() {
        return lastTradedTime;
    }

    public void setLastTradedTime(Long lastTradedTime) {
        this.lastTradedTime = lastTradedTime;
    }

    public BTCXIndia withLastTradedTime(Long lastTradedTime) {
        this.lastTradedTime = lastTradedTime;
        return this;
    }

}
