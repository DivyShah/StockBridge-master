package com.example.abc.stockbridge;

import java.lang.ref.SoftReference;
import java.util.HashMap;

/**
 * Created by Priyank Jain on 08-09-2017.
 */

public class Utils {
    static String gold = "Gold";
    static String indian = "Indian";
    static String yen = "Yen";
    static String dollor = "Dollor";
    static String bitcoin = "Bitcoin";
    static String silver = "Silver";
    static String platinum = "Platinum";
    static String aluminimu = "Aluminimu";
    static String unocoin ="Unocoin";
    static String coinsecure="CoinSecure";
    static String bitcoingraph="Graph";
    static String ripple="Ripple";
    static String litecoin = "Litecoin";
    static String ethereum = "Ethereum";
    static String one_day_etherum="1DETH";
    static String seven_day_ethereum="1WETH";
    static String one_month_etherum="30DaysETH";
    static String sixmonthethereum="180DaysETH";
    static  String threemonthethereum="90DaysETH";
    static String one_yearethereum="365DaysETH";
    static String one_day_ripple="1DayXRP";
    static String seven_day_ripple="7DayXRP";
    static String one_month_ripple="30DaysXRP";
    static String three_month_ripple="90DAyXRP";
    static String six_month_ripple="180DayXRP";
    static String one_year_ripple="365DAYXRP";
    static String one_day_bitcoin="1DayBTC";
    static String seven_day_bitcoin="7DayBTC";
    static String one_month_bitcoin="30DayBTc";
    static String three_month_bitcoin="90DayBTC";
    static String six_month_bitcoin="180DayBTC";
    static String one_year_bitcoin="365DAYBTC";
    static String latest_price="Latest Price";
    private static HashMap<String,String> hashMap= new HashMap<String,String>();

    static {
        hashMap.put(Utils.gold,"https://www.quandl.com/api/v1/datasets/CHRIS/MCX_GC1.json");
        hashMap.put(Utils.indian,"IndianAPI");
        hashMap.put(Utils.yen,"YenAPI");
        hashMap.put(Utils.dollor,"DollorAPI");
        hashMap.put(Utils.bitcoin,"https://www.zebapi.com/api/v1/market/ticker/btc/");
        hashMap.put(Utils.silver,"SilverAPI");
        hashMap.put(Utils.platinum,"PlatinumAPI");
        hashMap.put(Utils.aluminimu,"AluminiumAPI");
        hashMap.put(Utils.unocoin,"https://www.unocoin.com/");
        hashMap.put(Utils.coinsecure,"https://api.coinsecure.in/v1/exchange/");
        hashMap.put(Utils.bitcoingraph,"https://chart.zebpay.com/");
        hashMap.put(Utils.ripple,"https://api.coinmarketcap.com/v1/ticker/");
        hashMap.put(Utils.ethereum,"https://api.coinmarketcap.com/v1/ticker/");
        hashMap.put(Utils.litecoin,"");
        hashMap.put(Utils.one_day_etherum,"http://coincap.io/history/");
        hashMap.put(Utils.seven_day_ethereum,"http://coincap.io/history/");
        hashMap.put(Utils.one_month_etherum,"http://coincap.io/history/");
        hashMap.put(Utils.threemonthethereum,"http://coincap.io/history/");
        hashMap.put(Utils.sixmonthethereum,"http://coincap.io/history/");
        hashMap.put(Utils.one_yearethereum,"http://coincap.io/history/");
        hashMap.put(Utils.one_day_ripple,"http://coincap.io/history/");
        hashMap.put(Utils.seven_day_ripple,"http://coincap.io/history/");
        hashMap.put(Utils.one_month_ripple,"http://coincap.io/history/");
        hashMap.put(Utils.three_month_ripple,"http://coincap.io/history/");
        hashMap.put(Utils.six_month_ripple,"http://coincap.io/history/");
        hashMap.put(Utils.one_year_ripple,"http://coincap.io/history/");
        hashMap.put(Utils.one_day_bitcoin,"http://coincap.io/history/");
        hashMap.put(Utils.seven_day_bitcoin,"http://coincap.io/history/");
        hashMap.put(Utils.one_month_bitcoin,"http://coincap.io/history/");
        hashMap.put(Utils.three_month_bitcoin,"http://coincap.io/history/");
        hashMap.put(Utils.six_month_bitcoin,"http://coincap.io/history/");
        hashMap.put(Utils.one_year_bitcoin,"http://coincap.io/history/");
        hashMap.put(Utils.latest_price,"https://api.coinmarketcap.com/v1/");

    }

    public static String getAPI(String key){
        return hashMap.get(key);
    }
}
