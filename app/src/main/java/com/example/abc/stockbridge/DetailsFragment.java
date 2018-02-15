package com.example.abc.stockbridge;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abc.stockbridge.data.LatestCrypto;
import com.example.abc.stockbridge.network.Client;
import com.example.abc.stockbridge.network.ServiceGenrator;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DetailsFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    TextView mainprice,price_difference,updated_time;
    TextView max_supply,total_supply,market_capital;
    Bundle bundle;
    Client client;
    ImageView imageView,image_arrow;
    Drawable drawable,arrow_up,arrow_down;

    public DetailsFragment() {
        // Required empty public constructor
    }

    public static DetailsFragment newInstance(String param1, String param2) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle=getActivity().getIntent().getExtras();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View rootview = inflater.inflate(R.layout.fragment_details,container,false);
        mainprice=(TextView)rootview.findViewById(R.id.textview1);
        price_difference=(TextView)rootview.findViewById(R.id.hello);
        updated_time=(TextView) rootview.findViewById(R.id.upadted_time);
        imageView= (ImageView) rootview.findViewById(R.id.image_view);
        image_arrow=(ImageView)rootview.findViewById(R.id.arrow);
        max_supply=(TextView)rootview.findViewById(R.id.max_supply);
        total_supply=(TextView)rootview.findViewById(R.id.total_supply);
        market_capital=(TextView)rootview.findViewById(R.id.market_usd);

       // imageView.setImageDrawable(drawable);

        if(bundle.get("one")!=null)
        {
            drawable= getResources().getDrawable(R.drawable.bitcoin2);
            arrow_up=getResources().getDrawable(R.drawable.ic_arrow_drop_up_black_24dp);
            arrow_down=getResources().getDrawable(R.drawable.ic_arrow_drop_down_black_24dp);
            String s= Utils.getAPI(Utils.latest_price);
            client= ServiceGenrator.createService(Client.class,s);
            calllatestprice(client);

        }
        else if(bundle.get("three")!=null){
            drawable=getResources().getDrawable(R.drawable.ethereum);

            String s = Utils.getAPI(Utils.latest_price);
            client=ServiceGenrator.createService(Client.class,s);
            calllatestprice(client);
        }

        else if(bundle.get("two")!=null)
        {
            drawable=getResources().getDrawable(R.drawable.ripple);
            String s= Utils.getAPI(Utils.latest_price);
            client= ServiceGenrator.createService(Client.class,s);
            calllatestprice(client);
        }
        else if (bundle.get("four")!=null)
        {
            drawable=getResources().getDrawable(R.drawable.litecoin);
            String s= Utils.getAPI(Utils.latest_price);
            client= ServiceGenrator.createService(Client.class,s);
            calllatestprice(client);
        }
        else if (bundle.get("five")!=null)
        {
            drawable=getResources().getDrawable(R.drawable.bitcoincash);
            String s= Utils.getAPI(Utils.latest_price);
            client= ServiceGenrator.createService(Client.class,s);
            calllatestprice(client);
        }


        return rootview;

    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

/*    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    } */

    private String calllatestprice(Client client)
    {
        Call<List<LatestCrypto>> latestcryptocall=client.getlatestprice();

        latestcryptocall.enqueue(new Callback<List<LatestCrypto>>() {
            @Override
            public void onResponse(retrofit2.Call<List<LatestCrypto>> call, Response<List<LatestCrypto>> response) {
                if(bundle.get("one")!=null)
                {


                    Float bitcoinprice= response.body().get(0).getPriceUsd();
                    Float percentagechange= Float.valueOf(response.body().get(0).getPercentChange1h());
                    Float latest_time= response.body().get(0).getLastUpdated();
                    String maximum_supply= (String) response.body().get(0).getMaxSupply();
                    Float total_supply1= Float.valueOf(response.body().get(0).getTotalSupply());
                    Float market1_capital= Float.valueOf(response.body().get(0).getMarketCapUsd());
                    SpannableStringBuilder spannableStringBuilder= new SpannableStringBuilder(maximum_supply.toString());
                    spannableStringBuilder.setSpan(new StyleSpan(Typeface.BOLD),spannableStringBuilder.length()-1,spannableStringBuilder.length(),0);
                    market_capital.setText("Market Cap"+"\n"+NumberFormat.getCurrencyInstance(new Locale("en","us")).format(market1_capital));

                    max_supply.setText("Max. Supply"+"\n"+"$"+maximum_supply);
                   // total_supply.setText("Total Supply"+"\n"+"\n"+total_supply1.toString());
                    total_supply.setText("Total Supply"+"\n"+NumberFormat.getCurrencyInstance(new Locale("en","US")).format(total_supply1));
                    if(percentagechange>0)
                    {
                        ImageSpan imageSpan= new ImageSpan(getContext(),R.drawable.ic_arrow_drop_up_black_24dp);
                        SpannableString spannableString= new SpannableString(percentagechange.toString()+"%");
                        spannableString.setSpan(imageSpan,spannableString.length()-1,spannableString.length(),0);


                        mainprice.setText("$"+bitcoinprice.toString());
                        price_difference.setText(percentagechange.toString()+"%");
                        price_difference.setTextColor(Color.GREEN);
                        imageView.setImageDrawable(drawable);
                        updated_time.setText(latest_time.toString());

                    }

                    else {

                        ImageSpan imageSpan= new ImageSpan(getContext(),R.drawable.ic_arrow_drop_down_black_24dp);
                        SpannableString spannableString= new SpannableString(percentagechange.toString()+"%");
                        spannableString.setSpan(imageSpan,spannableString.length()-1,spannableString.length(),0);
                        mainprice.setText("$"+bitcoinprice.toString());
                        price_difference.setText(percentagechange.toString()+"%");
                        imageView.setImageDrawable(drawable);
                        price_difference.setTextColor(Color.RED);

                        updated_time.setText("Last upadted "+latest_time.toString());
                    }
                }
                else if(bundle.get("three")!=null)
                {
                    Float ethereumprice= response.body().get(1).getPriceUsd();
                    Float percentagechange= Float.valueOf(response.body().get(1).getPercentChange1h());
                    Float latest_time= response.body().get(1).getLastUpdated();
                    String maximum_supply= (String) response.body().get(1).getMaxSupply();
                    Float total_supply1= Float.valueOf(response.body().get(1).getTotalSupply());
                    Float market1_capital= Float.valueOf(response.body().get(1).getMarketCapUsd());
                   /* SpannableStringBuilder spannableStringBuilder= new SpannableStringBuilder();
                    spannableStringBuilder.setSpan(new StyleSpan(Typeface.BOLD),spannableStringBuilder.length()-1,spannableStringBuilder.length(),0);*/
                    market_capital.setText("Market Cap"+"\n"+NumberFormat.getCurrencyInstance(new Locale("en","us")).format(market1_capital));

                   // max_supply.setText("Max. Supply"+"\n"+"$"+maximum_supply);
                    // total_supply.setText("Total Supply"+"\n"+"\n"+total_supply1.toString());
                    total_supply.setText("Total Supply"+"\n"+NumberFormat.getCurrencyInstance(new Locale("en","US")).format(total_supply1));
                    if(percentagechange>0)
                    {
                        ImageSpan imageSpan= new ImageSpan(getContext(),R.drawable.ic_arrow_drop_up_black_24dp);
                        SpannableString spannableString= new SpannableString(percentagechange.toString()+"%");
                        spannableString.setSpan(imageSpan,spannableString.length()-1,spannableString.length(),0);


                        mainprice.setText("$"+ethereumprice.toString());
                        price_difference.setText(percentagechange.toString()+"%");
                        price_difference.setTextColor(Color.GREEN);
                        imageView.setImageDrawable(drawable);
                        updated_time.setText(latest_time.toString());

                    }

                    else {

                        ImageSpan imageSpan= new ImageSpan(getContext(),R.drawable.ic_arrow_drop_down_black_24dp);
                        SpannableString spannableString= new SpannableString(percentagechange.toString()+"%");
                        spannableString.setSpan(imageSpan,spannableString.length()-1,spannableString.length(),0);
                        mainprice.setText("$"+ethereumprice.toString());
                        price_difference.setText(percentagechange.toString()+"%");
                        imageView.setImageDrawable(drawable);
                        price_difference.setTextColor(Color.RED);

                        updated_time.setText("Last upadted "+latest_time.toString());
                    }
                }

                else if(bundle.get("two")!=null)
                {

                    Float rippleprice= response.body().get(2).getPriceUsd();
                    Float percentagechange= Float.valueOf(response.body().get(2).getPercentChange1h());
                    Float latest_time= response.body().get(2).getLastUpdated();
                    String maximum_supply= (String) response.body().get(2).getMaxSupply();
                    Float total_supply1= Float.valueOf(response.body().get(2).getTotalSupply());
                    Float market1_capital= Float.valueOf(response.body().get(2).getMarketCapUsd());
                    SpannableStringBuilder spannableStringBuilder= new SpannableStringBuilder(maximum_supply.toString());
                    spannableStringBuilder.setSpan(new StyleSpan(Typeface.BOLD),spannableStringBuilder.length()-1,spannableStringBuilder.length(),0);
                    market_capital.setText("Market Cap"+"\n"+NumberFormat.getCurrencyInstance(new Locale("en","us")).format(market1_capital));

                    max_supply.setText("Max. Supply"+"\n"+"$"+maximum_supply);
                    // total_supply.setText("Total Supply"+"\n"+"\n"+total_supply1.toString());
                    total_supply.setText("Total Supply"+"\n"+NumberFormat.getCurrencyInstance(new Locale("en","US")).format(total_supply1));
                    if(percentagechange>0)
                    {
                        ImageSpan imageSpan= new ImageSpan(getContext(),R.drawable.ic_arrow_drop_up_black_24dp);
                        SpannableString spannableString= new SpannableString(percentagechange.toString()+"%");
                        spannableString.setSpan(imageSpan,spannableString.length()-1,spannableString.length(),0);


                        mainprice.setText("$"+rippleprice.toString());
                        price_difference.setText(percentagechange.toString()+"%");
                        price_difference.setTextColor(Color.GREEN);
                        imageView.setImageDrawable(drawable);
                        updated_time.setText(latest_time.toString());

                    }

                    else {

                        ImageSpan imageSpan= new ImageSpan(getContext(),R.drawable.ic_arrow_drop_down_black_24dp);
                        SpannableString spannableString= new SpannableString(percentagechange.toString()+"%");
                        spannableString.setSpan(imageSpan,spannableString.length()-1,spannableString.length(),0);
                        mainprice.setText("$"+rippleprice.toString());
                        price_difference.setText(percentagechange.toString()+"%");
                        imageView.setImageDrawable(drawable);
                        price_difference.setTextColor(Color.RED);

                        updated_time.setText("Last upadted "+latest_time.toString());
                    }
                }

                else if(bundle.get("four")!=null)
                {
                    Float litecoin= response.body().get(4).getPriceUsd();
                    Float percentagechange= Float.valueOf(response.body().get(4).getPercentChange1h());
                    Float latest_time= response.body().get(4).getLastUpdated();
                    String maximum_supply= (String) response.body().get(4).getMaxSupply();
                    Float total_supply1= Float.valueOf(response.body().get(4).getTotalSupply());
                    Float market1_capital= Float.valueOf(response.body().get(4).getMarketCapUsd());
                    SpannableStringBuilder spannableStringBuilder= new SpannableStringBuilder(maximum_supply.toString());
                    spannableStringBuilder.setSpan(new StyleSpan(Typeface.BOLD),spannableStringBuilder.length()-1,spannableStringBuilder.length(),0);
                    market_capital.setText("Market Cap"+"\n"+NumberFormat.getCurrencyInstance(new Locale("en","us")).format(market1_capital));

                    max_supply.setText("Max. Supply"+"\n"+"$"+maximum_supply);
                    // total_supply.setText("Total Supply"+"\n"+"\n"+total_supply1.toString());
                    total_supply.setText("Total Supply"+"\n"+NumberFormat.getCurrencyInstance(new Locale("en","US")).format(total_supply1));
                    if(percentagechange>0)
                    {
                        ImageSpan imageSpan= new ImageSpan(getContext(),R.drawable.ic_arrow_drop_up_black_24dp);
                        SpannableString spannableString= new SpannableString(percentagechange.toString()+"%");
                        spannableString.setSpan(imageSpan,spannableString.length()-1,spannableString.length(),0);


                        mainprice.setText("$"+litecoin.toString());
                        price_difference.setText(percentagechange.toString()+"%");
                        price_difference.setTextColor(Color.GREEN);
                        imageView.setImageDrawable(drawable);
                        updated_time.setText(latest_time.toString());

                    }

                    else {

                        ImageSpan imageSpan= new ImageSpan(getContext(),R.drawable.ic_arrow_drop_down_black_24dp);
                        SpannableString spannableString= new SpannableString(percentagechange.toString()+"%");
                        spannableString.setSpan(imageSpan,spannableString.length()-1,spannableString.length(),0);
                        mainprice.setText("$"+litecoin.toString());
                        price_difference.setText(percentagechange.toString()+"%");
                        imageView.setImageDrawable(drawable);
                        price_difference.setTextColor(Color.RED);

                        updated_time.setText("Last upadted "+latest_time.toString());
                    }
                }
                else if(bundle.get("two")!=null)
                {

                    Float bitcoin_cashprice= response.body().get(3).getPriceUsd();
                    Float bitcoincash_percentagechange= Float.valueOf(response.body().get(3).getPercentChange1h());
                    Float latest_time= response.body().get(3).getLastUpdated();
                    String maximum_supply= (String) response.body().get(3).getMaxSupply();
                    Float total_supply1= Float.valueOf(response.body().get(3).getTotalSupply());
                    Float market1_capital= Float.valueOf(response.body().get(3).getMarketCapUsd());
                    SpannableStringBuilder spannableStringBuilder= new SpannableStringBuilder(maximum_supply.toString());
                    spannableStringBuilder.setSpan(new StyleSpan(Typeface.BOLD),spannableStringBuilder.length()-1,spannableStringBuilder.length(),0);
                    market_capital.setText("Market Cap"+"\n"+NumberFormat.getCurrencyInstance(new Locale("en","us")).format(market1_capital));

                    max_supply.setText("Max. Supply"+"\n"+"$"+maximum_supply);
                    // total_supply.setText("Total Supply"+"\n"+"\n"+total_supply1.toString());
                    total_supply.setText("Total Supply"+"\n"+NumberFormat.getCurrencyInstance(new Locale("en","US")).format(total_supply1));
                    if(bitcoincash_percentagechange>0)
                    {
                        ImageSpan imageSpan= new ImageSpan(getContext(),R.drawable.ic_arrow_drop_up_black_24dp);
                        SpannableString spannableString= new SpannableString(bitcoincash_percentagechange.toString()+"%");
                        spannableString.setSpan(imageSpan,spannableString.length()-1,spannableString.length(),0);


                        mainprice.setText("$"+bitcoin_cashprice.toString());
                        price_difference.setText(bitcoincash_percentagechange.toString()+"%");
                        price_difference.setTextColor(Color.GREEN);
                        imageView.setImageDrawable(drawable);
                        updated_time.setText(latest_time.toString());

                    }

                    else {

                        ImageSpan imageSpan= new ImageSpan(getContext(),R.drawable.ic_arrow_drop_down_black_24dp);
                        SpannableString spannableString= new SpannableString(bitcoincash_percentagechange.toString()+"%");
                        spannableString.setSpan(imageSpan,spannableString.length()-1,spannableString.length(),0);
                        mainprice.setText("$"+bitcoin_cashprice.toString());
                        price_difference.setText(bitcoincash_percentagechange.toString()+"%");
                        imageView.setImageDrawable(drawable);
                        price_difference.setTextColor(Color.RED);

                        updated_time.setText("Last upadted "+latest_time.toString());
                    }
                }






            }
            public Float dateformat(String getprice_time) {
                SimpleDateFormat formatter = new SimpleDateFormat("HH.mm");
                Float formattedDate = Float.valueOf((formatter.format(getprice_time)));
                // formattedDate=(formatter.format(getprice.get(getprice.size())));


                return formattedDate;
            }
            @Override
            public void onFailure(retrofit2.Call<List<LatestCrypto>> call, Throwable t) {
               Log.e("price_difference","hi",t);

            }
        });
        return null;
    }

    private String getDate(Float getprice) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
        return formatter.format(getprice);
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    /**
     * Created by divyshah on 8/2/18.
     */

    public static class MySpannable extends ClickableSpan {
        @Override
        public void onClick(View widget) {

        }

        private boolean isUnderline = false;

        /**
         * Constructor
         */
        public MySpannable(boolean isUnderline) {
            this.isUnderline = isUnderline;
        }

        @Override
        public void updateDrawState(TextPaint ds) {

            ds.setUnderlineText(isUnderline);
            ds.setColor(Color.parseColor("#343434"));

        }
    }
}
