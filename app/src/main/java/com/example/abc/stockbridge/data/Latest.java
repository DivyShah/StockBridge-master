package com.example.abc.stockbridge.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by divyshah on 30/1/18.
 */

public class Latest {@SerializedName("")
@Expose
private List<LatestCrypto> latestCryptos = null;

    public List<LatestCrypto> getLatestCryptos() {
        return latestCryptos;
    }

    public void setLatestCryptos(List<LatestCrypto> latestCryptos) {
        this.latestCryptos = latestCryptos;
    }



}
