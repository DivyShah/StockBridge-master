package com.example.abc.stockbridge.network;

import com.example.abc.stockbridge.data.Latest;
import com.example.abc.stockbridge.data.LatestCrypto;
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

    @GET("trade?all")
    Call<Unocoin> getUncoin();

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
    Call<Latest> getlatestprice();



}
