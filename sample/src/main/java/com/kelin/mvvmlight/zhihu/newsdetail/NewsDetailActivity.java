package com.kelin.mvvmlight.zhihu.newsdetail;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import android.os.Bundle;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.kelin.mvvmlight.zhihu.R;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

public class NewsDetailActivity extends RxAppCompatActivity {
    public static final String EXTRA_KEY_NEWS_ID = "key_news_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        long id = getIntent().getLongExtra(EXTRA_KEY_NEWS_ID, -1);
        ViewDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_news_detail);
        binding.setVariable(com.kelin.mvvmlight.zhihu.BR.viewModel, new NewsDetailViewModel(this, id));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedText);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedTitleText);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        WebView webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
