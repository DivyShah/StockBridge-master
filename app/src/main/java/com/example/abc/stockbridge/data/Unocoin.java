package com.example.abc.stockbridge.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by divyshah on 16/1/18.
 */

public class Unocoin  {
    @SerializedName("buy")
    @Expose
    private Float buy;

    public Float getBuy() {
        return buy;
    }

    public void setBuy(Float buy) {
        this.buy = buy;
    }

    public Unocoin withBuy(Float buy)
    {
        this.buy=buy;
        return this;
    }

    public Float getSell() {
        return sell;
    }

    public void setSell(Float sell) {
        this.sell = sell;
    }

    @SerializedName("sell")
    @Expose
    private Float sell;

    public Unocoin withSell(Float sell)
    {
        this.sell=sell;
        return this;
    }


}
