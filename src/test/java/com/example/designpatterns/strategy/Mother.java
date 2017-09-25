package com.example.designpatterns.strategy;

import com.example.designpatterns.strategy.shipping.Address;
import com.example.designpatterns.strategy.shipping.Order;

public class Mother {


    public static Order createOrder_FedEx(){
        final Order order = new Order();
        order.setShippingOptions(Order.ShippingOptions.FedEx);
        order.setDestination(Mother.createAddress_Destination());
        order.setOrigin(Mother.createAddress_Origin());
        return order;
    }

    public static Order createOrder_USPS(){

        final Order order = new Order();
        order.setShippingOptions(Order.ShippingOptions.USPS);
        order.setDestination(Mother.createAddress_Destination());
        order.setOrigin(Mother.createAddress_Origin());
        return order;
    }

    public static Order createOrder_UPS(){

        final Order order = new Order();
        order.setShippingOptions(Order.ShippingOptions.UPS);
        order.setDestination(Mother.createAddress_Destination());
        order.setOrigin(Mother.createAddress_Origin());
        return order;
    }

    private static Address createAddress_Origin()
    {
        final Address address = new Address();
        address.setContactName("David Starr");
        address.setAddressLine1("185 Lincoln St.");
        address.setAddressLine2("Suite 305");
        address.setCity("Hingham");
        address.setCountry("U.S.");
        address.setRegion("MA");
        address.setPostalCode("02043-1741");
        return address;
    }

    private static Address createAddress_Destination(){

        final Address address = new Address();
        address.setContactName("Homer Simpson");
        address.setAddressLine1("123 Elm");
        address.setCity("Springfield");
        address.setCountry("U.S.");
        address.setRegion("Iowa");
        address.setPostalCode("1111");
        return address;
    }

}
