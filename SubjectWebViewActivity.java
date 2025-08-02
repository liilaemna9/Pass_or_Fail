package com.noobbros.yt;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SubjectWebViewActivity extends Activity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_webview);

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        // ✅ Load correct file based on subject passed from MainActivity
        String subject = getIntent().getStringExtra("subject");
        if (subject != null) {
            String fileName = subject + "_test.html";
            webView.loadUrl("file:///android_asset/" + fileName);
        }
    }
}
