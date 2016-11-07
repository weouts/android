package com.weouts.program.andro.weouts;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Andro on 07/11/2016.
 */

public class Webview extends Fragment {
    View v;
    WebView myWeb;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        //menambahkan layout
        v =inflater.inflate(R.layout.webview, container, false);
        //disini kita tambahkan webview
        myWeb = (WebView)v.findViewById(R.id.webview);
        myWeb.loadUrl("http://www.balidev.top/");
        //enable javascript pada web
        WebSettings webset = myWeb.getSettings();
        webset.setJavaScriptEnabled(true);
        //redirect link
        myWeb.setWebViewClient(new WebViewClient());
        return v;
    }
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Web View");
    }
}
