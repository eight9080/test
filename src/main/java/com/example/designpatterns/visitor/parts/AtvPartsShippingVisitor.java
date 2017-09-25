package com.example.designpatterns.visitor.parts;

import java.util.List;

public class AtvPartsShippingVisitor implements AtvPartVisitor {

    double shippingAmount = 0;

    @Override
    public void visit(Wheel wheel) {
        shippingAmount+=15;
        System.out.println("Wheels are expensive to ship.");
    }

    @Override
    public void visit(Fender fender) {
        shippingAmount+=3;
        System.out.println("Fenders are cheap to ship.");
    }

    @Override
    public void visit(Oil oil) {
        shippingAmount+=9;
        System.out.println("Oil has a fee to ship.");
    }

    @Override
    public void visit(PartsOrder partsOrder) {
        System.out.println("If they bought more than 3 things we will give them a discount on shipping");
        final List<AtvPart> parts = partsOrder.getParts();
        if(parts.size()>3){
            shippingAmount-=5;
        }
        System.out.println("Shipping amount is: "+shippingAmount);
    }
}
