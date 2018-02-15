
package com.example.abc.stockbridge.data.Koinex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Prices {

    @SerializedName("BTC")
    @Expose
    private String bTC;
    @SerializedName("ETH")
    @Expose
    private String eTH;
    @SerializedName("XRP")
    @Expose
    private String xRP;
    @SerializedName("BCH")
    @Expose
    private String bCH;
    @SerializedName("LTC")
    @Expose
    private String lTC;
    @SerializedName("MIOTA")
    @Expose
    private Double mIOTA;
    @SerializedName("OMG")
    @Expose
    private Double oMG;
    @SerializedName("GNT")
    @Expose
    private Double gNT;

    public String getBTC() {
        return bTC;
    }

    public void setBTC(String bTC) {
        this.bTC = bTC;
    }

    public Prices withBTC(String bTC) {
        this.bTC = bTC;
        return this;
    }

    public String getETH() {
        return eTH;
    }

    public void setETH(String eTH) {
        this.eTH = eTH;
    }

    public Prices withETH(String eTH) {
        this.eTH = eTH;
        return this;
    }

    public String getXRP() {
        return xRP;
    }

    public void setXRP(String xRP) {
        this.xRP = xRP;
    }

    public Prices withXRP(String xRP) {
        this.xRP = xRP;
        return this;
    }

    public String getBCH() {
        return bCH;
    }

    public void setBCH(String bCH) {
        this.bCH = bCH;
    }

    public Prices withBCH(String bCH) {
        this.bCH = bCH;
        return this;
    }

    public String getLTC() {
        return lTC;
    }

    public void setLTC(String lTC) {
        this.lTC = lTC;
    }

    public Prices withLTC(String lTC) {
        this.lTC = lTC;
        return this;
    }

    public Double getMIOTA() {
        return mIOTA;
    }

    public void setMIOTA(Double mIOTA) {
        this.mIOTA = mIOTA;
    }

    public Prices withMIOTA(Double mIOTA) {
        this.mIOTA = mIOTA;
        return this;
    }

    public Double getOMG() {
        return oMG;
    }

    public void setOMG(Double oMG) {
        this.oMG = oMG;
    }

    public Prices withOMG(Double oMG) {
        this.oMG = oMG;
        return this;
    }

    public Double getGNT() {
        return gNT;
    }

    public void setGNT(Double gNT) {
        this.gNT = gNT;
    }

    public Prices withGNT(Double gNT) {
        this.gNT = gNT;
        return this;
    }

}
