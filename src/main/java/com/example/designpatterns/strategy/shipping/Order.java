package com.example.designpatterns.strategy.shipping;

public class Order {

    public ShippingOptions shippingOptions;
    public Address destination;
    public Address origin;

    public ShippingOptions getShippingOptions() {
        return shippingOptions;
    }

    public void setShippingOptions(ShippingOptions shippingOptions) {
        this.shippingOptions = shippingOptions;
    }

    public Address getDestination() {
        return destination;
    }

    public void setDestination(Address destination) {
        this.destination = destination;
    }

    public Address getOrigin() {
        return origin;
    }

    public void setOrigin(Address origin) {
        this.origin = origin;
    }

    public enum ShippingOptions{
        UPS(100),
        FedEx(200),
        USPS(300);

        private int number;

        ShippingOptions(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }
    }
}
