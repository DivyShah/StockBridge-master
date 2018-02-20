package com.example.abc.stockbridge.data.Buyu;

/**
 * Created by divyshah on 20/2/18.
 */


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BuyUCoin{
        @SerializedName("BuyUcoin_data")
        @Expose
        private List<BuyUcoinDatum> buyUcoinData = null;
        @SerializedName("success")
        @Expose
        private String success;

        public List<BuyUcoinDatum> getBuyUcoinData() {
            return buyUcoinData;
        }

        public void setBuyUcoinData(List<BuyUcoinDatum> buyUcoinData) {
            this.buyUcoinData = buyUcoinData;
        }

        public BuyUCoin withBuyUcoinData(List<BuyUcoinDatum> buyUcoinData) {
            this.buyUcoinData = buyUcoinData;
            return this;
        }

        public String getSuccess() {
            return success;
        }

        public void setSuccess(String success) {
            this.success = success;
        }

        public BuyUCoin withSuccess(String success) {
            this.success = success;
            return this;
        }
}
