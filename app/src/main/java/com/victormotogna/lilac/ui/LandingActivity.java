package com.victormotogna.lilac.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.victormotogna.lilac.R;
import com.victormotogna.lilac.ui.orders.OrdersActivity_;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_landing)
public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Click(R.id.button_start)
    public void start() {
        Intent intent = new Intent(LandingActivity.this, OrdersActivity_.class);
        startActivity(intent);
    }
}
