package com.victormotogna.lilac.converters;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.victormotogna.lilac.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderConverter {

    /*
    Api model - JSON:
    {
        id: 1,
        description: "Red Roses",
        price: 50,
        deliver_to: "Bianca Rus",
        address: "str. Liviu Rebreanu 4, Cluj-Napoca"
     }
     */

    public static Order fromJson(JsonObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }

        return new Order(
                jsonObject.has("id") ? jsonObject.get("id").getAsInt() : -1,
                jsonObject.has("description") ? jsonObject.get("description").getAsString() : null,
                jsonObject.has("price") ? jsonObject.get("price").getAsInt() : 0,
                jsonObject.has("deliver_to") ? jsonObject.get("deliver_to").getAsString() : null,
                jsonObject.has("address") ? jsonObject.get("address").getAsString() : null
        );
    }

    public static List<Order> fromJson(JsonArray jsonArray) {
        if (jsonArray == null) {
            return null;
        }

        List<Order> orders = new ArrayList<>();

        for (int i = 1; i < jsonArray.size(); i++) {
            orders.add(OrderConverter.fromJson(jsonArray.get(i).getAsJsonObject()));
        }

        return orders;
    }
}
