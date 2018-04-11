package com.victormotogna.lilac.model;

public class Order {

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

    private int id;
    private String description;
    private int price;
    private String client;
    private String address;

    public Order(int id, String description, int price, String client, String address) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.client = client;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
