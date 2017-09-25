package com.example.designpatterns.strategy;

import com.example.designpatterns.strategy.shipping.IShippingCostStrategy;
import com.example.designpatterns.strategy.shipping.Order;
import com.example.designpatterns.strategy.shipping.ShippingCostCalculatorService;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShippingCostCalculatorServiceTest {
    @Test
    public void When_shipping_via_UPS_The_shipping_cost_is_425() throws Exception {
        final ShippingCostCalculatorService shippingCostCalculatorService
                = new ShippingCostCalculatorService(IShippingCostStrategy.upsStrategy);
        final Order orderUps = Mother.createOrder_UPS();
        final double cost = shippingCostCalculatorService.calculateShippingCost(orderUps);
        assertThat(cost, Matchers.is(4.25));
    }

    @Test
    public void When_shipping_via_USPS_The_shipping_cost_is_300() throws Exception {
        final ShippingCostCalculatorService shippingCostCalculatorService
                = new ShippingCostCalculatorService(IShippingCostStrategy.uspsStrategy);
        final Order order = Mother.createOrder_USPS();
        final double cost = shippingCostCalculatorService.calculateShippingCost(order);
        assertThat(cost, Matchers.is(3.00));
    }

    @Test
    public void When_shipping_via_FedEx_The_shipping_cost_is_5() throws Exception {
        final ShippingCostCalculatorService shippingCostCalculatorService
                = new ShippingCostCalculatorService(IShippingCostStrategy.fedExStrategy);
        final Order order = Mother.createOrder_FedEx();
        final double cost = shippingCostCalculatorService.calculateShippingCost(order);
        assertThat(cost, Matchers.is(5.00));
    }
}