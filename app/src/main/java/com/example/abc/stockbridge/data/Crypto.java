package com.example.abc.stockbridge.data;

/**
 * Created by divyshah on 17/1/18.
 */



        import com.google.gson.Gson;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;
        import com.google.gson.reflect.TypeToken;

        import java.lang.reflect.Type;
        import java.nio.channels.FileLock;
        import java.util.ArrayList;
        import java.util.List;

public class Crypto {




    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("rank")
    @Expose
    private String rank;
    @SerializedName("price_inr")
    @Expose
    private  Float priceInr;
    @SerializedName("price_usd")
    @Expose
    private Float priceUsd;
    @SerializedName("price_btc")
    @Expose
    private String priceBtc;
    @SerializedName("24h_volume_usd")
    @Expose
    private String _24hVolumeUsd;
    @SerializedName("market_cap_usd")
    @Expose
    private String marketCapUsd;
    @SerializedName("available_supply")
    @Expose
    private String availableSupply;
    @SerializedName("total_supply")
    @Expose
    private String totalSupply;
    @SerializedName("max_supply")
    @Expose
    private String maxSupply;
    @SerializedName("percent_change_1h")
    @Expose
    private Float percentChange1h;
    @SerializedName("percent_change_24h")
    @Expose
    private Float percentChange24h;
    @SerializedName("percent_change_7d")
    @Expose
    private Float percentChange7d;
    @SerializedName("last_updated")
    @Expose
    private String lastUpdated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Float getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(Float priceUsd) {
        this.priceUsd = priceUsd;
    }

    public Float getPriceInr()
    {
        return priceInr;
    }
    public void setPriceInr()
    {
        this.priceInr=priceInr;
    }

    public String getPriceBtc() {
        return priceBtc;
    }

    public void setPriceBtc(String priceBtc) {
        this.priceBtc = priceBtc;
    }

    public String get24hVolumeUsd() {
        return _24hVolumeUsd;
    }

    public void set24hVolumeUsd(String _24hVolumeUsd) {
        this._24hVolumeUsd = _24hVolumeUsd;
    }

    public String getMarketCapUsd() {
        return marketCapUsd;
    }

    public void setMarketCapUsd(String marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
    }

    public String getAvailableSupply() {
        return availableSupply;
    }

    public void setAvailableSupply(String availableSupply) {
        this.availableSupply = availableSupply;
    }

    public String getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(String totalSupply) {
        this.totalSupply = totalSupply;
    }

    public String getMaxSupply() {
        return maxSupply;
    }

    public void setMaxSupply(String maxSupply) {
        this.maxSupply = maxSupply;
    }

    public Float getPercentChange1h() {
        return percentChange1h;
    }

    public void setPercentChange1h(Float percentChange1h) {
        this.percentChange1h = percentChange1h;
    }

    public Float getPercentChange24h() {
        return percentChange24h;
    }

    public void setPercentChange24h(Float percentChange24h) {
        this.percentChange24h = percentChange24h;
    }

    public Float getPercentChange7d() {
        return percentChange7d;
    }

    public void setPercentChange7d(Float percentChange7d) {
        this.percentChange7d = percentChange7d;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
