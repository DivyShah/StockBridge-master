
package com.example.abc.stockbridge.data.Koinex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Koinex {

    @SerializedName("prices")
    @Expose
    private Prices prices;
    @SerializedName("stats")
    @Expose
    private Stats stats;

    public Prices getPrices() {
        return prices;
    }

    public void setPrices(Prices prices) {
        this.prices = prices;
    }

    public Koinex withPrices(Prices prices) {
        this.prices = prices;
        return this;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Koinex withStats(Stats stats) {
        this.stats = stats;
        return this;
    }

}
