package com.example.abc.stockbridge.data.Buyu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by divyshah on 20/2/18.
 */

public class BuyUcoinDatum  {
    @SerializedName("btc_buy_price")
    @Expose
    private String btcBuyPrice;
    @SerializedName("btc_buy_vol")
    @Expose
    private String btcBuyVol;
    @SerializedName("btc_sell_price")
    @Expose
    private String btcSellPrice;
    @SerializedName("btc_sell_vol")
    @Expose
    private String btcSellVol;

    public String getBtcBuyPrice() {
        return btcBuyPrice;
    }

    public void setBtcBuyPrice(String btcBuyPrice) {
        this.btcBuyPrice = btcBuyPrice;
    }

    public BuyUcoinDatum withBtcBuyPrice(String btcBuyPrice) {
        this.btcBuyPrice = btcBuyPrice;
        return this;
    }

    public String getBtcBuyVol() {
        return btcBuyVol;
    }

    public void setBtcBuyVol(String btcBuyVol) {
        this.btcBuyVol = btcBuyVol;
    }

    public BuyUcoinDatum withBtcBuyVol(String btcBuyVol) {
        this.btcBuyVol = btcBuyVol;
        return this;
    }

    public String getBtcSellPrice() {
        return btcSellPrice;
    }

    public void setBtcSellPrice(String btcSellPrice) {
        this.btcSellPrice = btcSellPrice;
    }

    public BuyUcoinDatum withBtcSellPrice(String btcSellPrice) {
        this.btcSellPrice = btcSellPrice;
        return this;
    }

    public String getBtcSellVol() {
        return btcSellVol;
    }

    public void setBtcSellVol(String btcSellVol) {
        this.btcSellVol = btcSellVol;
    }

    public BuyUcoinDatum withBtcSellVol(String btcSellVol) {
        this.btcSellVol = btcSellVol;
        return this;
    }







    //etherum
    @SerializedName("eth_buy_price")
    @Expose
    private String ethBuyPrice;
    @SerializedName("eth_buy_vol")
    @Expose
    private String ethBuyVol;
    @SerializedName("eth_sell_price")
    @Expose
    private String ethSellPrice;
    @SerializedName("eth_sell_vol")
    @Expose
    private String ethSellVol;

    public String getEthBuyPrice() {
        return ethBuyPrice;
    }

    public void setEthBuyPrice(String ethBuyPrice) {
        this.ethBuyPrice = ethBuyPrice;
    }

    public BuyUcoinDatum withEthBuyPrice(String ethBuyPrice) {
        this.ethBuyPrice = ethBuyPrice;
        return this;
    }

    public String getEthBuyVol() {
        return ethBuyVol;
    }

    public void setEthBuyVol(String ethBuyVol) {
        this.ethBuyVol = ethBuyVol;
    }

    public BuyUcoinDatum withEthBuyVol(String ethBuyVol) {
        this.ethBuyVol = ethBuyVol;
        return this;
    }

    public String getEthSellPrice() {
        return ethSellPrice;
    }

    public void setEthSellPrice(String ethSellPrice) {
        this.ethSellPrice = ethSellPrice;
    }

    public BuyUcoinDatum withEthSellPrice(String ethSellPrice) {
        this.ethSellPrice = ethSellPrice;
        return this;
    }

    public String getEthSellVol() {
        return ethSellVol;
    }

    public void setEthSellVol(String ethSellVol) {
        this.ethSellVol = ethSellVol;
    }

    public BuyUcoinDatum withEthSellVol(String ethSellVol) {
        this.ethSellVol = ethSellVol;
        return this;
    }


    //Litecoin


    @SerializedName("ltc_buy_price")
    @Expose
    private String ltcBuyPrice;
    @SerializedName("ltc_buy_vol")
    @Expose
    private String ltcBuyVol;
    @SerializedName("ltc_sell_price")
    @Expose
    private String ltcSellPrice;
    @SerializedName("ltc_sell_vol")
    @Expose
    private String ltcSellVol;

    public String getLtcBuyPrice() {
        return ltcBuyPrice;
    }

    public void setLtcBuyPrice(String ltcBuyPrice) {
        this.ltcBuyPrice = ltcBuyPrice;
    }

    public BuyUcoinDatum withLtcBuyPrice(String ltcBuyPrice) {
        this.ltcBuyPrice = ltcBuyPrice;
        return this;
    }

    public String getLtcBuyVol() {
        return ltcBuyVol;
    }

    public void setLtcBuyVol(String ltcBuyVol) {
        this.ltcBuyVol = ltcBuyVol;
    }

    public BuyUcoinDatum withLtcBuyVol(String ltcBuyVol) {
        this.ltcBuyVol = ltcBuyVol;
        return this;
    }

    public String getLtcSellPrice() {
        return ltcSellPrice;
    }

    public void setLtcSellPrice(String ltcSellPrice) {
        this.ltcSellPrice = ltcSellPrice;
    }

    public BuyUcoinDatum withLtcSellPrice(String ltcSellPrice) {
        this.ltcSellPrice = ltcSellPrice;
        return this;
    }

    public String getLtcSellVol() {
        return ltcSellVol;
    }

    public void setLtcSellVol(String ltcSellVol) {
        this.ltcSellVol = ltcSellVol;
    }

    public BuyUcoinDatum withLtcSellVol(String ltcSellVol) {
        this.ltcSellVol = ltcSellVol;
        return this;
    }





    //Ripple

    @SerializedName("xrp_buy_price")
    @Expose
    private String xrpBuyPrice;
    @SerializedName("xrp_buy_vol")
    @Expose
    private String xrpBuyVol;
    @SerializedName("xrp_sell_price")
    @Expose
    private String xrpSellPrice;
    @SerializedName("xrp_sell_vol")
    @Expose
    private String xrpSellVol;

    public String getXrpBuyPrice() {
        return xrpBuyPrice;
    }

    public void setXrpBuyPrice(String xrpBuyPrice) {
        this.xrpBuyPrice = xrpBuyPrice;
    }

    public BuyUcoinDatum withXrpBuyPrice(String xrpBuyPrice) {
        this.xrpBuyPrice = xrpBuyPrice;
        return this;
    }

    public String getXrpBuyVol() {
        return xrpBuyVol;
    }

    public void setXrpBuyVol(String xrpBuyVol) {
        this.xrpBuyVol = xrpBuyVol;
    }

    public BuyUcoinDatum withXrpBuyVol(String xrpBuyVol) {
        this.xrpBuyVol = xrpBuyVol;
        return this;
    }

    public String getXrpSellPrice() {
        return xrpSellPrice;
    }

    public void setXrpSellPrice(String xrpSellPrice) {
        this.xrpSellPrice = xrpSellPrice;
    }

    public BuyUcoinDatum withXrpSellPrice(String xrpSellPrice) {
        this.xrpSellPrice = xrpSellPrice;
        return this;
    }

    public String getXrpSellVol() {
        return xrpSellVol;
    }

    public void setXrpSellVol(String xrpSellVol) {
        this.xrpSellVol = xrpSellVol;
    }

    public BuyUcoinDatum withXrpSellVol(String xrpSellVol) {
        this.xrpSellVol = xrpSellVol;
        return this;
    }


}
