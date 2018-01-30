package com.example.abc.stockbridge.data;

/**
 * Created by divyshah on 23/1/18.
 */



        import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class CryptoCurrency {

    @SerializedName("market_cap")
    @Expose
    private List<List<Float>> marketCap = null;
    @SerializedName("price")
    @Expose
    private List<List<Float>> price = null;
    @SerializedName("volume")
    @Expose
    private List<List<Float>> volume = null;

    public List<List<Float>> getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(List<List<Float>> marketCap) {
        this.marketCap = marketCap;
    }

    public CryptoCurrency withMarketCap(List<List<Float>> marketCap) {
        this.marketCap = marketCap;
        return this;
    }

    public List<List<Float>> getPrice() {
        return price;
    }

    public void setPrice(List<List<Float>> price) {
        this.price = price;
    }

    public CryptoCurrency withPrice(List<List<Float>> price) {
        this.price = price;
        return this;
    }

    public List<List<Float>> getVolume() {
        return volume;
    }

    public void setVolume(List<List<Float>> volume) {
        this.volume = volume;
    }

    public CryptoCurrency withVolume(List<List<Float>> volume) {
        this.volume = volume;
        return this;
    }

}