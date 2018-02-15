package com.example.abc.stockbridge;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.INotificationSideChannel;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.abc.stockbridge.network.Client;


public class DefineFragment extends Fragment {

    TextView what_is,tv,understand;
    TextView textView;

    Bundle bundle;
    WebView webView;
    String ripple="https://www.youtube.com/watch?v=VSRomZboFVQ";
    String etherum1="https://www.youtube.com/watch?v=-_Qs0XdPpw8";
    String official_website="https://ethereum.org/";
    String bitcoin_url="https://www.youtube.com/watch?time_continue=16&v=jiEllBFNaMA";
    String litecoin_url="https://www.youtube.com/watch?v=q7B7S88RtV8";
    String litecoin_website="https://litecoin.org/";
    String litecoin2="https://litecoin.com/";


    private OnFragmentInteractionListener mListener;

    public DefineFragment() {

    }


    public static DefineFragment newInstance(String param1, String param2) {
        DefineFragment fragment = new DefineFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle= getActivity().getIntent().getExtras();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_define,container,false);
        what_is=(TextView)root.findViewById(R.id.whatis);
        understand=(TextView)root.findViewById(R.id.understand);
        webView=(WebView)root.findViewById(R.id.webview);
        tv=(TextView)root.findViewById(R.id.tv);
        textView=(TextView)root.findViewById(R.id.website);
        if(bundle.get("one")!=null)
        {
            what_is.setText("What is Bitcoin?");

            understand.setText("Understand Bitcoin with this video");
            ClickableSpan video= new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    Intent intent = new Intent("android.intent.action.VIEW",Uri.parse("https://www.youtube.com/watch?time_continue=16&v=jiEllBFNaMA"));
                    startActivity(intent);
                }
            };
            makeLinks(understand,new String[] {"video"},new ClickableSpan[]{
                    video
            });



            tv.setText(R.string.bitcoin);
            makeTextViewResizable(tv,3,"View More",false);




            textView.setText("Checkout the history of Bitcoin here");
            ClickableSpan clickhere= new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    Intent intent = new Intent("android.intent.action.VIEW",Uri.parse("https://www.zebpay.com/bitcoin-history/"));
                    startActivity(intent);
                }

            };

            makeLinks(textView,new String[] {"here"}, new ClickableSpan[]{
                    clickhere
            });




        }
        else if(bundle.get("two")!=null)

        {
            what_is.setText("What is Ripple?");
            understand.setText("Understand ripple with this video");
            tv.setText(R.string.ripple);
            makeTextViewResizable(tv,4,"View More",false);
            ClickableSpan clickableSpan = new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    Intent intent = new Intent("android.intent.action.VIEW",Uri.parse("https://www.youtube.com/watch?v=VSRomZboFVQ"));
                    startActivity(intent);
                }

            };
            makeLinks(understand, new String[] {"video"}, new ClickableSpan[]{
                    clickableSpan
            });

            textView.setText("To learn more about Ripple Click Here");
            ClickableSpan clickhere = new ClickableSpan() {
                @Override
                public void onClick(View widget) {

                    Intent intent = new Intent("android.intent.action.VIEW",Uri.parse("https://ripple.com/"));
                    startActivity(intent);
                }
            };
            makeLinks(textView,new String[] {"Click Here"},new ClickableSpan[]{
                    clickhere
            });

        }
        else if(bundle.get("three")!=null)
        {
            what_is.setText("Whar is Etherum?");
            understand.setText("Understand Ethereum with this video");
            ClickableSpan video= new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    Intent intent = new Intent("android.intent.action.VIEW",Uri.parse("https://www.youtube.com/watch?v=-_Qs0XdPpw8"));
                    startActivity(intent);
                }
            };
            makeLinks(understand,new String[] {"video"},new ClickableSpan[]{
                    video
            });
            tv.setText(R.string.etherum);
            makeTextViewResizable(tv,4,"View More",false);


          /* final String website=("For more Detailed informatin [ether]");
            int t11=website.indexOf("[");
            int t12=website.indexOf("]");
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            Spannable spannable1= (Spannable)textView.getText();
            ClickableSpan clickableSpan1= new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    webView.loadUrl(official_website);
                }
            };
            spannable1.setSpan(clickableSpan1,t11,t12+1,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);*/

          textView.setText("For more detailed information visit official webiste of etherum");
            ClickableSpan etherumclick=new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    Intent intent= new Intent("android.intent.action.VIEW",Uri.parse("https://ethereum.org/"));
                    startActivity(intent);
                }
            } ;
            makeLinks(textView,new String[] {"etherum"},new ClickableSpan[]{
                    etherumclick
            });

        }
        else if(bundle.get("four")!=null)
        {
            what_is.setText("What is LiteCoin");
            understand.setText("Understand Litecoin with this video");
            ClickableSpan video= new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    Intent intent = new Intent("android.intent.action.VIEW",Uri.parse("https://www.youtube.com/watch?v=q7B7S88RtV8"));
                    startActivity(intent);
                }
            };
            makeLinks(understand,new String[] {"video"},new ClickableSpan[]{
                    video
            });
            tv.setText(R.string.litecoin);
            makeTextViewResizable(tv,4,"View More",false);
            ;



            textView.setText("For more Detailed Information, visit official website of litecoin and to know more about merchants accepting litecoin, click here. ");
            ClickableSpan litecoinclick = new ClickableSpan() {
                @Override
                public void onClick(View view) {
                    Intent viewintent= new Intent("android.intent.action.VIEW", Uri.parse("https://litecoin.org"));
                    startActivity(viewintent);

                }
            };

            ClickableSpan clickhereclick = new ClickableSpan() {
                @Override
                public void onClick(View view) {

                    Intent view1 = new Intent("android.intent.action.VIEW",Uri.parse("https://litecoin.com/"));
                    startActivity(view1);

                                }
            };

            makeLinks(textView, new String[] { "litecoin", "click here" }, new ClickableSpan[] {
                    litecoinclick, clickhereclick
            });
        }

        else if(bundle.get("five")!=null)
        {
            what_is.setText("What is Bitcoin Cash?");
            understand.setText("Understand bitcoin cash with this video");
            tv.setText(R.string.bitcoin_cash);
            makeTextViewResizable(tv,4,"View More",false);
            ClickableSpan clickableSpan = new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    Intent intent = new Intent("android.intent.action.VIEW",Uri.parse("https://www.youtube.com/watch?v=1aE-EuqMY4k"));

                    startActivity(intent);
                }

            };
            makeLinks(understand, new String[] {"video"}, new ClickableSpan[]{
                    clickableSpan
            });

            textView.setText("For detailed guide oon bitcoin cash  Click Here.Visit official website to know more about the features of BCH");
            ClickableSpan clickhere = new ClickableSpan() {
                @Override
                public void onClick(View widget) {

                    Intent intent = new Intent("android.intent.action.VIEW",Uri.parse("https://blog.zebpay.com/bitcoin-cash-bch-for-beginners-facc62a2ac45"));
                    startActivity(intent);
                }
            };
            ClickableSpan officialwebsite= new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    Intent intent =  new Intent("android.intent.action.VIEW",Uri.parse("https://www.bitcoincash.org/"));
                    startActivity(intent);
                }
            };
            makeLinks(textView,new String[] {"Click Here","official website"},new ClickableSpan[]{
                    clickhere,officialwebsite
            });
        }



        return root;
    }


    public void makeLinks(TextView textView, String[] links, ClickableSpan[] clickableSpans) {
        SpannableString spannableString = new SpannableString(textView.getText());
        for (int i = 0; i < links.length; i++) {
            ClickableSpan clickableSpan = clickableSpans[i];
            String link = links[i];

            int startIndexOfLink = textView.getText().toString().indexOf(link);
            spannableString.setSpan(clickableSpan, startIndexOfLink, startIndexOfLink + link.length(),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.ble)),startIndexOfLink,startIndexOfLink + link.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString, TextView.BufferType.SPANNABLE);
    }
    public static void makeTextViewResizable(final TextView tv,
                                             final int maxLine, final String expandText, final boolean viewMore) {

        if (tv.getTag() == null) {
            tv.setTag(tv.getText());
        }
        ViewTreeObserver vto = tv.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @SuppressWarnings("deprecation")
            @Override
            public void onGlobalLayout() {

                ViewTreeObserver obs = tv.getViewTreeObserver();
                obs.removeGlobalOnLayoutListener(this);
                if (maxLine == 0) {
                    int lineEndIndex = tv.getLayout().getLineEnd(0);

                    String text = tv.getText().subSequence(0,
                            lineEndIndex - expandText.length() + 1)
                            + " " + expandText;
                    tv.setText(text);
                    tv.setMovementMethod(LinkMovementMethod.getInstance());
                    tv.setText(
                            addClickablePartTextViewResizable(tv.getText()
                                            .toString(), tv, maxLine, expandText,
                                    viewMore), TextView.BufferType.SPANNABLE);
                } else if (maxLine > 0 && tv.getLineCount() >= maxLine) {
                    int lineEndIndex = tv.getLayout().getLineEnd(maxLine - 1);
                    String text = tv.getText().subSequence(0,
                            lineEndIndex - expandText.length() + 1)
                            + " " + expandText;
                    tv.setText(text);
                    tv.setMovementMethod(LinkMovementMethod.getInstance());
                    tv.setText(
                            addClickablePartTextViewResizable(tv.getText()
                                            .toString(), tv, maxLine, expandText,
                                    viewMore), TextView.BufferType.SPANNABLE);
                } else {
                    int lineEndIndex = tv.getLayout().getLineEnd(
                            tv.getLayout().getLineCount() - 1);

                    String text = tv.getText().subSequence(0, lineEndIndex)
                            + " " + expandText;
                    tv.setText(text);
                    tv.setMovementMethod(LinkMovementMethod.getInstance());
                    tv.setText(
                            addClickablePartTextViewResizable(tv.getText()
                                            .toString(), tv, lineEndIndex, expandText,
                                    viewMore), TextView.BufferType.SPANNABLE);
                }
            }
        });

    }

    private static SpannableStringBuilder addClickablePartTextViewResizable(
            final String strSpanned, final TextView tv, final int maxLine,
            final String spanableText, final boolean viewMore) {
        final SpannableStringBuilder ssb = new SpannableStringBuilder(strSpanned);

        if (strSpanned.contains(spanableText)) {
            ssb.setSpan(
                    new ClickableSpan() {

                        @Override
                        public void onClick(View widget) {

                            tv.setLayoutParams(tv.getLayoutParams());
                            tv.setText(tv.getTag().toString(),
                                    TextView.BufferType.SPANNABLE);
                            tv.invalidate();
                            tv.setTextColor(Color.BLACK);

                            if (viewMore) {

                                makeTextViewResizable(tv, -3, "View Less",
                                        false);

                            } else {

                                makeTextViewResizable(tv, 3, "View More",
                                        true);

                            }

                        }
                    }, strSpanned.indexOf(spanableText),
                    strSpanned.indexOf(spanableText) + spanableText.length(), 0);

        }
        return ssb;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    /*public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/




    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
