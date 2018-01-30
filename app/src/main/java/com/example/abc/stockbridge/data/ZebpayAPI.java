package com.example.abc.stockbridge.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Priyank Jain on 09-09-2017.
 */

public class ZebpayAPI {

    @SerializedName("market")
    @Expose
    private Float market;
    @SerializedName("buy")
    @Expose
    private Float buy;
    @SerializedName("sell")
    @Expose
    private Float sell;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("volume")
    @Expose
    private Float volume;

    public Float getMarket() {
        return market;
    }

    public void setMarket(Float market) {
        this.market = market;
    }

    public ZebpayAPI withMarket(Float market) {
        this.market = market;
        return this;
    }

    public Float getBuy() {
        return buy;
    }

    public void setBuy(Float buy) {
        this.buy = buy;
    }

    public ZebpayAPI withBuy(Float buy) {
        this.buy = buy;
        return this;
    }

    public Float getSell() {
        return sell;
    }

    public void setSell(Float sell) {
        this.sell = sell;
    }

    public ZebpayAPI withSell(Float sell) {
        this.sell = sell;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public ZebpayAPI withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public Float getVolume() {
        return volume;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }

    public ZebpayAPI withVolume(Float volume) {
        this.volume = volume;
        return this;
    }

}
