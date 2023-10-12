package ru.liga;

public class Orders {

    private long id;
    private long customerId;
    private long restaurantId;
    private String status;
    private String tamestamp;

    public Orders(long id, String status, String tamestamp) {
        this.id = id;
        this.status = status;
        this.tamestamp = tamestamp;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }
}
