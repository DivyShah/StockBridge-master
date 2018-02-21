package com.example.abc.stockbridge.network;

import com.example.abc.stockbridge.data.BTCXIndia;
import com.example.abc.stockbridge.data.Buyu.BuyUCoin;
import com.example.abc.stockbridge.data.Buyu.BuyUcoinDatum;
import com.example.abc.stockbridge.data.ETHXINDIA;
import com.example.abc.stockbridge.data.Koinex.Koinex;
import com.example.abc.stockbridge.data.LatestCrypto;
import com.example.abc.stockbridge.data.Message;
import com.example.abc.stockbridge.data.ZebpayAPI;
import com.example.abc.stockbridge.data.CoinSecure;
import com.example.abc.stockbridge.data.Crypto;
import com.example.abc.stockbridge.data.CryptoCurrency;
import com.example.abc.stockbridge.data.Unocoin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;



public interface Client {




    @GET("inr")
    Call<ZebpayAPI> getBitcoin();
    @GET("inr")
    Call<ZebpayAPI> getzebpayripple();
    @GET("inr")
    Call<ZebpayAPI> getzebpayLitecoin();
    @GET("inr")
    Call<ZebpayAPI> getzebpaybitcoin_cash();



    @GET("ticker?apiKey=YYpKw3obuJvRWB0JgchzhT9iMPlSKZdPGJCH5eEH")
    Call<CoinSecure> getCoinsecure();

    @GET("ethereum/?convert=INR")
    Call<List<Crypto>>  getethereum();
    @GET("1day/ETH")
    Call<CryptoCurrency> getonedayETH();
    @GET("7day/ETH")
    Call<CryptoCurrency> getsevendayETH();
    @GET("30day/ETH")
    Call<CryptoCurrency> getonemonthETH();
    @GET("90day/ETH")
    Call<CryptoCurrency> getThreemonthsETH();
    @GET("180day/ETH")
    Call<CryptoCurrency> getsixmonthETH();
    @GET("365day/ETH")
    Call<CryptoCurrency> getoneyearETH();
    @GET("1day/XRP")
    Call<CryptoCurrency> getonedayXRP();
    @GET("7day/XRP")
    Call<CryptoCurrency> getsevendayXRP();
    @GET("30day/XRP")
    Call<CryptoCurrency> getonemonthXRP();
    @GET("90day/XRP")
    Call<CryptoCurrency> getthreemonthXRP();
    @GET("180day/XRP")
    Call<CryptoCurrency> getsixmonthXRP();
    @GET("365day/XRP")
    Call<CryptoCurrency> getoneyearXRP();

    @GET("1day/BTC")
    Call<CryptoCurrency> getGetonedayBTC();

    @GET("7day/BTC")
    Call<CryptoCurrency> getsevendayBTC();
    @GET("30day/BTC")
    Call<CryptoCurrency> getonemonthBCT();
    @GET("90day/BTC")
    Call<CryptoCurrency> getthreemonthBTC();
    @GET("180day/BTC")
    Call<CryptoCurrency> getsixmonthBTC();
    @GET("365day/BTC")
    Call<CryptoCurrency> getoneyearBTC();

    @GET("ticker/?limit=10")
    Call<List<LatestCrypto>> getlatestprice();

    @GET("1day/LTC")
    Call<CryptoCurrency> getonedayLTC();

    @GET("7day/LTC")
    Call<CryptoCurrency> getsevendayLTC();
    @GET("30day/LTC")
    Call<CryptoCurrency> getonemonthLCT();
    @GET("90day/LTC")
    Call<CryptoCurrency> getthreemonthLTC();
    @GET("180day/LTC")
    Call<CryptoCurrency> getsixmonthLTC();
    @GET("365day/LTC")
    Call<CryptoCurrency> getoneyearLTC();


    @GET("1day/BCH")
    Call<CryptoCurrency> getonedayBCH();

    @GET("7day/BCH")
    Call<CryptoCurrency> getsevendayBCH();
    @GET("30day/BCH")
    Call<CryptoCurrency> getonemonthBCH();
    @GET("90day/BCH")
    Call<CryptoCurrency> getthreemonthBCH();
    @GET("180day/BCH")
    Call<CryptoCurrency> getsixmonthBCH();
    @GET("365day/BCH")
    Call<CryptoCurrency> getoneyearBCH();



    @GET("ticker-new/bch/inr")
    Call<List<ZebpayAPI>> getbitcoinzebpay();


    @GET("btc/")
    Call<BuyUCoin> getBuyUCOin_bitcoin();
    @GET("xrp/")
    Call<BuyUCoin> getBuyUCOin_ripple();
    @GET("eth/")
    Call<BuyUCoin> getBuyUCOin_ethereum();
    @GET("ltc/")
    Call<BuyUCoin> getBuyUCOin_litecoin();
    @GET("ltc/")
    Call<BuyUCoin> getBuyUCOin_bitcoincash();




    @GET("trade?all")
    Call<Unocoin> getUNcoin();


    @GET("ticker")
    Call<Koinex> getcoinex();


    @GET("ticker")
    Call<ETHXINDIA> getethxindia();

    @GET("ticker/")
    Call<BTCXIndia> getbtcXindia_ripple();


}
