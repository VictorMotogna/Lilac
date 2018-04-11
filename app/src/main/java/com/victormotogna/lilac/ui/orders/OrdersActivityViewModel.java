package com.victormotogna.lilac.ui.orders;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.victormotogna.lilac.api.LilacApi;
import com.victormotogna.lilac.converters.OrderConverter;
import com.victormotogna.lilac.model.Order;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Response;

public class OrdersActivityViewModel {
    private LilacApi api;

    @Inject
    public OrdersActivityViewModel(LilacApi api) {
        this.api = api;
    }

    public List<Order> getOrders() throws IOException {
        Response<JsonArray> response = api.getApiService().getOrders().execute();

        return OrderConverter.fromJson(response.body().getAsJsonArray());
    }
}
