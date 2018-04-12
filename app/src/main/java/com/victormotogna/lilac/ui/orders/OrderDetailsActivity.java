package com.victormotogna.lilac.ui.orders;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import com.victormotogna.lilac.R;
import com.victormotogna.lilac.model.Order;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_order_details)
public class OrderDetailsActivity extends AppCompatActivity {

    private Order order;

    @ViewById(R.id.webViewMap)
    WebView webView;

    @ViewById(R.id.order_client)
    TextView orderClient;

    @ViewById(R.id.order_price)
    TextView orderPrice;

    @ViewById(R.id.order_description)
    TextView orderDescription;

    @ViewById(R.id.view_map)
    Button viewMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        order = (Order) extras.getSerializable("order");
    }

    @AfterViews
    public void setupViews() {
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://maps.google.co.in/maps?q=" + order.getAddress());

        orderDescription.setText(order.getDescription());
        orderPrice.setText(order.getPrice() + " lei");
        orderClient.setText(order.getClient());
    }

    @Click(R.id.view_map)
    public void goToMap() {
        String uri = "http://maps.google.co.in/maps?q=" + order.getAddress();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }
}
