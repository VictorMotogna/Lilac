package com.victormotogna.lilac.ui.orders;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.victormotogna.lilac.R;
import com.victormotogna.lilac.dependency_injection.LilacApp;
import com.victormotogna.lilac.model.Order;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

@EActivity(R.layout.activity_orders)
public class OrdersActivity extends AppCompatActivity {

    @Inject
    OrdersActivityViewModel viewModel;

    private List<Order> orders = new ArrayList<>();
    private OrdersAdapter adapter;

    @ViewById(R.id.refresh_orders)
    SwipeRefreshLayout refreshLayout;

    @ViewById(R.id.rv_all_orders)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LilacApp.component().inject(this);
    }

    @Background
    public void getAllOrders() {
        try {
            orders = viewModel.getOrders();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("OrdersActivity: ", "getting orders from server error");
        }
    }

    public void populateView() {
        getAllOrders();

        while (orders.size() == 0) {

        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new OrdersAdapter(this, orders);

        adapter.setOnItemClickListener(new OrdersAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(int position, Order order) {
                viewOrderDetails(order);
            }
        });

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        refreshLayout.setRefreshing(false);
    }

    @AfterViews
    public void setupViews() {
        populateView();

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                populateView();
            }
        });
    }

    public void viewOrderDetails(Order order) {
        Intent intent = new Intent(OrdersActivity.this, OrderDetailsActivity_.class);
        intent.putExtra("order", order);
        startActivity(intent);
    }
}
