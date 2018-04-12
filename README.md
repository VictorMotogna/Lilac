# Lilac - Android flower ordering app

## Description

**Lilac** is an Android application used to manage incoming flower orders. It can help online sellers to view data about their orders, on the go.

Each order would have information about: the id of the order, description of the flowers, total price of the order, client name & his address.

## Technologies used

### HTTP Requests
  http://demo9997383.mockable.io/getOrders - HTTP request URL
  
  Request Body:
  ```
  {
    "id": 20,
    "description": "Red Roses",
    "price": 50,
    "deliver_to": "Bianca",
    "address": "str. Liviu Rebreanu 4, Cluj-Napoca"
  }
  ```


  #### Retrofit 2.3 - http://square.github.io/retrofit/
  * Retrofit was used to manage API requests
  * It's an easy to configure your requests and turn them into a Java Interface
  #### Converters
  * Retrofit handles incoming bodies into Google GSON format
  * To create instances of objects incoming from the request, converters were used
  * Converters managed to call constructors of Order (in this case) from JsonObject, using members from the json object

### Dependency Injection
  #### Dagger 2.11 - https://google.github.io/dagger/
  * Dagger 2 is a framework used to manage dependency injection
  * It's used to generate code that will further make development of big enterprise applications easier
  * Although Lilac is not an enterprise application (yet), Dagger allows it to be easily scaled
  * The example from this application was for instantiating a ViewModel

### UI & Development
  #### Android Annotations - http://androidannotations.org/
  * Android Annotations is a framework that makes the development process easier
  * It cuts down on code to make it easier to read and develop
  * In this application, it was to manage activities and link them to layouts, to manage Background tasks (on the networking threads), to populate the layour after the views have been instantiated, etc.
  
  #### Intro screens - https://github.com/TangoAgency/material-intro-screen
  * Assuming Lilac is an application that is new for most people (created by a new startup), it has 3 intro screens to explain to new users what it can do
  * Intro Screens use only one activity that contains customizable slide fragments

  #### RecyclerView & WebView
  * Lilac has 2 main features: viewing a list of flower orders, and viewing details for each order individually
  * The list used for this application was created using RecyclerView (was considered a better choice against ListView), because of its design to re-use "cells" (created UI layouts that are re-used for each item individually, with new data coming from an Adapter)
  * When viewing each order individually, the user also sees the map with the location of the client: to enhance his experience, the location is visible on Google Maps through a WebView (the user also has the possibility of opening the address in the Google Maps application through an Intent)
  
### Architecture
  The chosen architecture for this application was **MVVM**, which uses a ViewModel as a helper for the View (in this case, only Activities - only used on OrdersActivity), where all the logic is implemented.
  Lilac only uses one ViewModel, where the logic for the request is implemented, so the method in the Activity only calls another method inside the ViewModel. This minimizes the logic in the View layer, making the application architecture easier to understand and manage.
