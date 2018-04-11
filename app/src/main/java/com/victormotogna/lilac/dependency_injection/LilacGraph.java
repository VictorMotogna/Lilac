package com.victormotogna.lilac.dependency_injection;

import com.victormotogna.lilac.ui.orders.OrdersActivity;

public interface LilacGraph {
    void inject(OrdersActivity ordersActivity);
}
