
package com.example.abc.stockbridge.data.Koinex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats {

    @SerializedName("ETH")
    @Expose
    private ETH eTH;
    @SerializedName("BTC")
    @Expose
    private BTC bTC;
    @SerializedName("LTC")
    @Expose
    private LTC lTC;
    @SerializedName("XRP")
    @Expose
    private XRP xRP;
    @SerializedName("BCH")
    @Expose
    private BCH bCH;

    public ETH getETH() {
        return eTH;
    }

    public void setETH(ETH eTH) {
        this.eTH = eTH;
    }

    public Stats withETH(ETH eTH) {
        this.eTH = eTH;
        return this;
    }

    public BTC getBTC() {
        return bTC;
    }

    public void setBTC(BTC bTC) {
        this.bTC = bTC;
    }

    public Stats withBTC(BTC bTC) {
        this.bTC = bTC;
        return this;
    }

    public LTC getLTC() {
        return lTC;
    }

    public void setLTC(LTC lTC) {
        this.lTC = lTC;
    }

    public Stats withLTC(LTC lTC) {
        this.lTC = lTC;
        return this;
    }

    public XRP getXRP() {
        return xRP;
    }

    public void setXRP(XRP xRP) {
        this.xRP = xRP;
    }

    public Stats withXRP(XRP xRP) {
        this.xRP = xRP;
        return this;
    }

    public BCH getBCH() {
        return bCH;
    }

    public void setBCH(BCH bCH) {
        this.bCH = bCH;
    }

    public Stats withBCH(BCH bCH) {
        this.bCH = bCH;
        return this;
    }

}
