package com.tanjim.dailyprogress;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.view.Window;
import android.view.WindowManager;
import android.graphics.Color;
import android.os.Build;
public class MainActivity extends Activity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setBackgroundDrawableResource(android.R.color.black);
        webView = new WebView(this);
        webView.setBackgroundColor(Color.parseColor("#05070d"));
        setContentView(webView);
        WebSettings s = webView.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setDatabaseEnabled(true);
        s.setAllowFileAccess(true);
        s.setSupportZoom(false);
        s.setBuiltInZoomControls(false);
        s.setLoadWithOverviewMode(true);
        s.setUseWideViewPort(true);
        if(Build.VERSION.SDK_INT>=21){s.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);}
        webView.setWebViewClient(new WebViewClient(){
            @Override public boolean shouldOverrideUrlLoading(WebView v,String u){return false;}
        });
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("file:///android_asset/index.html");
    }
    @Override public void onBackPressed(){if(webView.canGoBack())webView.goBack();else super.onBackPressed();}
    @Override protected void onPause(){super.onPause();webView.onPause();}
    @Override protected void onResume(){super.onResume();webView.onResume();}
}
