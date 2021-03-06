package com.example.abc.stockbridge;

import java.io.StringReader;
import java.lang.ref.SoftReference;
import java.util.HashMap;



public class Utils {












    static String zebpay_bitcoin="Zebpay";
    static  String zebpay_etherum="Zebpay_Etherum";
    static String zebpay_ripple="Zebpay_ripple";
    static String zebpay_litecoin="Zebpay_litecoin";
    static String zebpay_cash="Zebpay_bitocincash";
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
    static String one_day_litecoin="1DAYLTC";
    static String seven_day_litecoin="7DAYLTC";
    static String one_month_litecoin="1MONLTC";
    static String three_montyh_litecoin="3MONLTC";
    static String six_month_litecoin="6MONLTC";
    static String one_year_litecoin="1YEARLTC";

    static String bitcoin_cash="Bitcoin_Cash";
    static String one_day_bitcoin_cash="1DAYLTC";
    static String seven_day_bitcoin_cash="7DAYLTC";
    static String one_month_bitcoin_cash="1MONLTC";
    static String three_montyh_bitcoin_cash="3MONLTC";
    static String six_month_bitcoin_cash="6MONLTC";
    static String one_year_bitcoin_cash="1YEARLTC";
    static String koinex_bitcoin="Koinex_bitcon";

    static String Unocoin="Uncoin";

    static String buyucoin_bitcoin="BUyUCoin_bitocoin";
    static String buyucoin_ripple="BUyUCoin_eipple";
    static String buyucoin_etherum="BUyUCoin_bitocoin";
    static String buyucoin_litecoin="BUyUCoin_bitocoin";
    static String buyucoin_bitcoincash="BUyUCoin_bitocoin";


    static  String ethexindia="Ethexindia";

    static  String btcxindia_ripple="BTCXindia_ripple";


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
        hashMap.put(Utils.litecoin,"https://api.coinmarketcap.com/v1/ticker/");
        hashMap.put(Utils.bitcoin_cash,"https://api.coinmarketcap.com/v1/ticker/");
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
        hashMap.put(Utils.one_day_litecoin,"http://coincap.io/history/");
        hashMap.put(Utils.seven_day_litecoin,"http://coincap.io/history/");
        hashMap.put(Utils.one_month_litecoin,"http://coincap.io/history/");
        hashMap.put(Utils.three_montyh_litecoin,"http://coincap.io/history/");
        hashMap.put(Utils.six_month_litecoin,"http://coincap.io/history/");
        hashMap.put(Utils.one_year_litecoin,"http://coincap.io/history/");
        hashMap.put(Utils.zebpay_bitcoin,"https://www.zebapi.com/api/v1/market/ticker-new/btc/");

        hashMap.put(Utils.koinex_bitcoin,"https://koinex.in/api/");

        hashMap.put(Utils.one_day_bitcoin_cash,"http://coincap.io/history/");
        hashMap.put(Utils.seven_day_bitcoin_cash,"http://coincap.io/history/");
        hashMap.put(Utils.one_month_bitcoin_cash,"http://coincap.io/history/");
        hashMap.put(Utils.three_montyh_bitcoin_cash,"http://coincap.io/history/");
        hashMap.put(Utils.six_month_bitcoin_cash,"http://coincap.io/history/");
        hashMap.put(Utils.one_year_bitcoin_cash,"http://coincap.io/history/");


        hashMap.put(Utils.zebpay_etherum,"https://www.zebapi.com/api/v1/market/ticker-new/ltc/");
        hashMap.put(Utils.zebpay_litecoin,"https://www.zebapi.com/api/v1/market/ticker-new/ltc/");
        hashMap.put(Utils.zebpay_ripple,"https://www.zebapi.com/api/v1/market/ticker-new/xrp/");
        hashMap.put(Utils.zebpay_cash,"https://www.zebapi.com/api/v1/market/ticker-new/bch/");


        hashMap.put(Utils.buyucoin_bitcoin,"https://www.buyucoin.com/api/v1/");
        hashMap.put(Utils.buyucoin_ripple,"https://www.buyucoin.com/api/v1/");
        hashMap.put(Utils.buyucoin_etherum,"https://www.buyucoin.com/api/v1/");
        hashMap.put(Utils.buyucoin_litecoin,"https://www.buyucoin.com/api/v1/");
        hashMap.put(Utils.buyucoin_bitcoincash,"https://www.buyucoin.com/api/v1/");


        hashMap.put(Utils.ethexindia,"https://ethexindia.com/api/");

        hashMap.put(Utils.Unocoin,"https://www.unocoin.com/");

        hashMap.put(Utils.btcxindia_ripple,"https://api.btcxindia.com/");
    }

    public static String getAPI(String key){
        return hashMap.get(key);
    }
}
